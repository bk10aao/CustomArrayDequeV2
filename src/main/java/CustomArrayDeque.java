import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import static java.lang.reflect.Array.newInstance;

/**
 * Resizable-array implementation of the {@link Deque} interface.
 * <p>
 * This class manages an internal circular array backed by explicit head and tail
 * integer indices to support double-ended queue operations without capacity
 * restrictions other than memory limitations. It does not permit {@code null} elements.
 * <p>
 * Unlike standard implementations, this class manages dynamic resizing and array shifting
 * internally. It supports efficient insertion, extraction, and traversal at both ends
 * of the deque, alongside standard collection and bulk querying views.
 * <p>
 * <b>Note:</b> This implementation is not synchronized.
 *
 * @param <E> the type of elements held in this deque
 * @author Benjamin Kane
 * @see <a href="https://www.linkedin.com/in/benjamin-kane-81149482/">LinkedIn</a>
 * @see <a href="https://github.com/bk10aao">GitHub account bk10aao</a>
 * @see <a href="https://github.com/bk10aao/CustomArrayDequeV2">Repository</a>
 * @see <a href="https://github.com/bk10aao/CustomArrayDequeV2">Version 1 (non-circular)</a>
 */
public class CustomArrayDeque<E> implements Deque<E> {

    private E[] deque;
    private int head;
    private int tail;
    private final int minimumCapacity = 16;
    protected int modCount = 0;

    /**
     * Constructs an empty deque with an initial capacity of 16 elements.
     */
    public CustomArrayDeque() {
        head = tail = 0;
        deque = (E[]) new Object[minimumCapacity];
    }

    /**
     * Constructs an empty deque with an initial capacity sufficient to hold
     * the specified number of elements without immediate resizing.
     *
     * @param numElements the initial capacity hint
     * @throws IllegalArgumentException if {@code numElements < 0}
     */
    public CustomArrayDeque(final int numElements) {
        if(numElements < 0)
            throw new IllegalArgumentException();
        int capacity = getNewSize(numElements);
        deque =  (E[]) new Object[capacity];
        head = tail = 0;
    }

    /**
     * Constructs a deque containing the elements of the specified collection,
     * in the order they are returned by the collection's iterator.
     *
     * @param c the collection whose elements are to be placed into this deque
     * @throws NullPointerException if the specified collection or any of its elements is null
     */
    public CustomArrayDeque(final Collection<? extends E> c) {
        Objects.requireNonNull(c);
        int capacity = getNewSize(c.size());
        deque =  (E[]) new Object[capacity];
        head = 0;
        addAll(c);
    }

    /**
     * Inserts the specified element at the tail of this deque.
     *
     * @param item the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws NullPointerException if the specified element is null
     */
    public boolean add(final E item) {
        Objects.requireNonNull(item);
        if(requiresResize())
            expand(1);
        deque[tail] = item;
        shiftTailRight();
        modCount++;
        return true;
    }

    /**
     * Adds all the elements in the specified collection to the tail of this deque,
     * in the order that they are returned by the specified collection's iterator.
     *
     * @param c collection containing elements to be added to this deque
     * @return {@code true} if this deque changed as a result of the call
     * @throws NullPointerException if the specified collection or any of its elements is null
     */
    public boolean addAll(final Collection<? extends E> c) {
        Objects.requireNonNull(c);
        if(c.isEmpty())
            return false;
        if(requiresResizeForNewCollection(c))
            expand(c.size());
        for(E e : c) {
            Objects.requireNonNull(e);
            deque[tail] = e;
            shiftTailRight();
        }
        modCount++;
        return true;
    }

    /**
     * Inserts the specified element at the front of this deque.
     *
     * @param item the element to add
     * @throws NullPointerException if the specified element is null
     */
    public void addFirst(final E item) {
        Objects.requireNonNull(item);
        if(requiresResize())
            expand(1);
        shiftHeadLeft();
        deque[head] = item;
        modCount++;
    }

    /**
     * Inserts the specified element at the tail of this deque.
     *
     * @param item the element to add
     * @throws NullPointerException if the specified element is null
     */
    public void addLast(final E item) {
        add(item);
    }

    /**
     * Removes all the elements from this deque. The deque will be empty after this call returns.
     */
    public void clear() {
        deque = (E[]) new Object[minimumCapacity];
        head = tail = 0;
        modCount++;
    }

    /**
     * Returns {@code true} if this deque contains the specified element.
     *
     * @param o element whose presence in this deque is to be tested
     * @return {@code true} if this deque contains the specified element
     */
    public boolean contains(final Object o) {
        if(o == null)
            return false;
        for(int i = 0; i < size(); i++)
            if(Objects.equals(o, deque[(head + i) & (deque.length - 1)]))
                return true;
        return false;
    }

    /**
     * Returns {@code true} if this deque contains all the elements in the specified collection.
     *
     * @param c collection to be checked for containment in this deque
     * @return {@code true} if this deque contains all the elements in the specified collection
     * @throws NullPointerException if the specified collection is null
     */
    public boolean containsAll(final Collection<?> c) {
        Objects.requireNonNull(c);
        if(c.isEmpty())
            return true;
        Set<?> set = (c instanceof Set<?>) ? (Set<?>) c : new HashSet<>(c);
        for(int i = 0; i < size(); i++) {
            int index = (head + i) & (deque.length - 1);
            if(deque[index] != null && set.remove(deque[index]))
                if(set.isEmpty())
                    return true;
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this deque in reverse sequential order.
     *
     * @return an iterator over the elements in this deque in reverse sequence
     */
    public Iterator<E> descendingIterator() {
        return new Iterator<>() {
            private int cursor = size() - 1;
            private int lastReturned = -1;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return cursor >= 0;
            }

            @Override
            public E next() {
                checkForConcurrentModification();
                if(!hasNext())
                    throw new NoSuchElementException();
                int index = (head + cursor) & (deque.length - 1);
                lastReturned = cursor;
                cursor--;
                return deque[index];
            }

            @Override
            public void remove() {
                if(lastReturned < 0)
                    throw new IllegalStateException();
                checkForConcurrentModification();
                try {
                    CustomArrayDeque.this.removeInnerElement(lastReturned);
                    cursor = lastReturned - 1;
                    lastReturned = -1;
                    expectedModCount = modCount;
                } catch (IndexOutOfBoundsException e) {
                    throw new ConcurrentModificationException();
                }
            }

            private void checkForConcurrentModification() {
                if(modCount != expectedModCount)
                    throw new ConcurrentModificationException();
            }
        };
    }

    /**
     * Retrieves, but does not remove, the first element of this deque.
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    public E element() {
        return getFirst();
    }

    /**
     * Compares the specified object with this deque for equality.
     * Returns {@code true} if the specified object is also a collection, the two collections
     * have the same size, and all corresponding pairs of elements are equal.
     *
     * @param o object to be compared for equality with this deque
     * @return {@code true} if the specified object is equal to this deque
     */
    @Override
    public boolean equals(final Object o) {
        if(o == this)
            return true;
        if(!(o instanceof Collection<?> other))
            return false;
        if(this.size() != other.size())
            return false;
        Iterator<E> thisIter = this.iterator();
        Iterator<?> otherIter = other.iterator();
        while(thisIter.hasNext() && otherIter.hasNext()) {
            E e1 = thisIter.next();
            Object e2 = otherIter.next();
            if(!(Objects.equals(e1, e2)))
                return false;
        }
        return true;
    }

    /**
     * Retrieves, but does not remove, the first element of this deque.
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    public E getFirst() {
        if(head == tail)
            throw new NoSuchElementException();
        return deque[head];
    }

    /**
     * Retrieves, but does not remove, the last element of this deque.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    public E getLast() {
        if(head == tail)
            throw new NoSuchElementException();
        return peekLast();
    }

    /**
     * Returns {@code true} if this deque contains no elements.
     *
     * @return {@code true} if this deque contains no elements
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Returns an iterator over the elements in this deque in proper sequence.
     *
     * @return an iterator over the elements in this deque
     */
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int cursor = 0;
            private int lastReturned = -1;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return cursor < size();
            }

            @Override
            public E next() {
                checkForConcurrentModification();
                if(!hasNext())
                    throw new NoSuchElementException();
                int index = (head + cursor) & (deque.length - 1);
                lastReturned = cursor;
                cursor++;
                return deque[index];
            }

            @Override
            public void remove() {
                if(lastReturned < 0)
                    throw new IllegalStateException();
                checkForConcurrentModification();
                try {
                    CustomArrayDeque.this.removeInnerElement(lastReturned);
                    cursor = lastReturned;
                    lastReturned = -1;
                    expectedModCount = modCount;
                } catch (IndexOutOfBoundsException e) {
                    throw new ConcurrentModificationException();
                }
            }

            private void checkForConcurrentModification() {
                if(modCount != expectedModCount)
                    throw new ConcurrentModificationException();
            }
        };
    }

    /**
     * Inserts the specified element at the tail of this deque.
     *
     * @param item the element to add
     * @return {@code true} if the element was added to this deque
     * @throws NullPointerException if the specified element is null
     */
    public boolean offer(final E item) {
        Objects.requireNonNull(item);
        add(item);
        return true;
    }

    /**
     * Inserts the specified element at the front of this deque.
     *
     * @param item the element to add
     * @return {@code true} if the element was added to this deque
     * @throws NullPointerException if the specified element is null
     */
    public boolean offerFirst(final E item) {
        Objects.requireNonNull(item);
        addFirst(item);
        return true;
    }

    /**
     * Inserts the specified element at the tail of this deque.
     *
     * @param item the element to add
     * @return {@code true} if the element was added to this deque
     * @throws NullPointerException if the specified element is null
     */
    public boolean offerLast(final E item) {
        Objects.requireNonNull(item);
        if(requiresResize())
            expand(1);
        add(item);
        return true;
    }

    /**
     * Pop an element from the stack represented by this deque.
     * Equivalent to {@link #removeFirst()}.
     *
     * @return the element at the front of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    public E peek() {
        if(head == tail)
            return null;
        return getFirst();
    }

    /**
     * Retrieves, but does not remove, the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    public E peekFirst() {
        if(head == tail)
            return null;
        return getFirst();
    }

    /**
     * Retrieves, but does not remove, the last element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    public E peekLast() {
        if(head == tail)
            return null;
        return deque[(tail - 1) & (deque.length - 1)];
    }

    /**
     * Retrieves and removes the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    public E poll() {
        if(head == tail)
            return null;
        return remove();
    }

    /**
     * Retrieves and removes the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    public E pollFirst() {
        if(head == tail)
            return null;
        return removeFirst();
    }

    /**
     * Retrieves and removes the last element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    public E pollLast() {
        if(head == tail)
            return null;
        return removeLast();
    }

    /**
     * Pop an element from the stack represented by this deque.
     * Equivalent to {@link #removeFirst()}.
     *
     * @return the element at the front of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    public E pop() {
        return removeFirst();
    }

    /**
     * Pushes an element onto the stack represented by this deque.
     * Equivalent to {@link #addFirst(Object)}.
     *
     * @param item the element to push
     * @throws NullPointerException if the specified element is null
     */
    public void push(final E item) {
        addFirst(item);
    }

    /**
     * Retrieves and removes the first element of this deque.
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    public E remove() {
        return removeFirst();
    }

    /**
     * Removes the first occurrence of the specified element from this deque.
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if the element was removed
     */
    public boolean remove(final Object o) {
        return removeFirstOccurrence(o);
    }

    /**
     * Removes all of this deque's elements that are also contained in the specified collection.
     *
     * @param c collection containing elements to be removed from this deque
     * @return {@code true} if this deque changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean removeAll(final Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Set<?> set = (c instanceof Set<?>) ? (Set<?>) c : new HashSet<>(c);
        for(int i = 0; i < size(); i++) {
            int index = (head + i) & (deque.length - 1);
            if(deque[index] != null && set.contains(deque[index])) {
                deque[index] = null;
                modified = true;
            }
        }
        if(modified) {
            shiftElements();
            modCount++;
        }
        return modified;
    }

    /**
     * Retrieves and removes the first element of this deque.
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    public E removeFirst() {
        if(head == tail)
            throw new NoSuchElementException();
        E item = deque[head];
        deque[head] = null;
        shiftHeadRight();
        modCount++;
        return item;
    }

    /**
     * Removes the first occurrence of the specified element from this deque.
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if the element was found and removed
     */
    public boolean removeFirstOccurrence(final Object o) {
        for(int i = 0; i < size(); i++)
            if(Objects.equals(o, deque[(head + i) & (deque.length - 1)])) {
                removeInnerElement(i);
                return true;
            }
        return false;
    }

    /**
     * Retrieves and removes the last element of this deque.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    public E removeLast() {
        if(head == tail)
            throw new NoSuchElementException();
        shiftTailLeft();
        E item = deque[tail];
        deque[tail] = null;
        modCount++;
        return item;
    }

    /**
     * Removes the last occurrence of the specified element from this deque.
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if the element was found and removed
     */
    public boolean removeLastOccurrence(final Object o) {
        for(int i = size() - 1; i >= 0; i--)
            if(Objects.equals(o, deque[(head + i) & (deque.length - 1)])) {
                removeInnerElement(i);
                return true;
            }
        return false;
    }

    /**
     * Retains only the elements in this deque that are contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this deque
     * @return {@code true} if this deque changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean retainAll(final Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Set<?> set = (c instanceof Set<?>) ? (Set<?>) c : new HashSet<>(c);
        int size = size();
        for(int i = 0; i < size; i++) {
            int index = (head + i) & (deque.length - 1);
            if(deque[index] != null && !set.contains(deque[index])) {
                deque[index] = null;
                modified = true;
            }
        }
        if(modified) {
            compact();
            modCount++;
        }
        return modified;
    }

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    public int size() {
        return (tail - head) & (deque.length - 1);
    }

    /**
     * Returns an array containing all the elements in this deque in proper sequence.
     *
     * @return an array containing all the elements in this deque
     */
    public Object[] toArray() {
        int size = size();
        Object[] result = new Object[size];
        if(size == 0)
            return result;
        if(head < tail)
            System.arraycopy(deque, head, result, 0, size);
        else {
            int headToEnd = deque.length - head;
            System.arraycopy(deque, head, result, 0, headToEnd);
            System.arraycopy(deque, 0, result, headToEnd, tail);
        }
        return result;
    }

    /**
     * Returns an array containing all the elements in this deque in proper sequence;
     * the runtime type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of the deque are to be stored, if it is big enough;
     *          otherwise, a new array of the same runtime type is allocated for this purpose
     * @param <T> the runtime type of the array to contain the collection
     * @return an array containing the elements of the deque
     * @throws NullPointerException if the specified array is null
     */
    public <T> T[] toArray(T[] a) {
        Objects.requireNonNull(a);
        int size = size();
        if(a.length < size) a = (T[])
                newInstance(a.getClass().getComponentType(), size);
        if(size == 0)
            return a;
        if(head < tail)
            System.arraycopy(deque, head, a, 0, size);
        else {
            int headToEnd = deque.length - head;
            System.arraycopy(deque, head, a, 0, headToEnd);
            System.arraycopy(deque, 0, a, headToEnd, tail);
        }
        if (a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * Returns a string representation of this deque.
     *
     * @return a string representation of this deque
     */
    public String toString() {
        if(size() == 0)
            return "[]";
        StringBuilder stringBuilder = new StringBuilder("[");
        boolean first = true;
        for(int i = 0; i < size(); i++) {
            int index = (head + i) & (deque.length - 1);
            if(deque[index] != null)
                if(first) {
                    stringBuilder.append(deque[index].toString());
                    first = false;
                } else
                    stringBuilder.append(", ").append(deque[index]);
        }
        return stringBuilder + "]";
    }

    private void compact() {
        int size = size();
        int write = head;
        for(int i = 0; i < size; i++) {
            int read = (head + i) & (deque.length - 1);
            E item = deque[read];
            deque[read] = null;
            if(item != null) {
                deque[write] = item;
                write = (write + 1) & (deque.length - 1);
            }
        }
        tail = write;
    }

    private void expand(final int requiredCapacity) {
        int oldCapacity = deque.length;
        int currentSize = (tail - head) & (oldCapacity - 1);
        int targetCapacity = currentSize + requiredCapacity;
        int newSize = oldCapacity;
        while(newSize <= targetCapacity)
            if ((newSize <<= 1) < 0)
                throw new IllegalStateException("Deque too big");
        E[] newArray = (E[]) new Object[newSize];
        int elementsToCopy = oldCapacity - head;
        System.arraycopy(deque, head, newArray, 0, elementsToCopy);
        System.arraycopy(deque, 0, newArray, elementsToCopy, tail);
        deque = newArray;
        head = 0;
        tail = currentSize;
    }

    private static int getNewSize(final int minimumCapacity) {
        int newSize = 16;
        while(newSize < minimumCapacity)
            if((newSize <<= 1) <= 0)
                throw new IllegalStateException();
        return newSize;
    }

    private void removeInnerElement(final int index) {
        int size = size();
        int i = (head + index) & (deque.length - 1);
        deque[i] = null;
        if(index < size / 2) {
            for(int x = index; x > 0; x--) {
                int current = (head + x) & (deque.length - 1);
                int previous = (head + x - 1) & (deque.length - 1);
                deque[current] = deque[previous];
            }
            deque[head] = null;
            shiftHeadRight();
        } else {
            for(int x = index; x < size - 1; x++) {
                int current = (head + x) & (deque.length - 1);
                int next = (head + x + 1) & (deque.length - 1);
                deque[current] = deque[next];
            }
            shiftTailLeft();
            deque[tail] = null;
        }
        modCount++;
    }

    private boolean requiresResize() {
        return ((tail + 1) & (deque.length - 1)) == head;
    }

    private boolean requiresResizeForNewCollection(final Collection<? extends E> c) {
        return (((tail - head) & (deque.length - 1)) + c.size()) >= deque.length;
    }

    private void shiftElements() {
        int size = size();
        int writeIndex = head;
        for(int i = 0; i < size; i++) {
            int readIndex = (head + i) & (deque.length - 1);
            if(deque[readIndex] != null) {
                if(readIndex != writeIndex) {
                    deque[writeIndex] = deque[readIndex];
                    deque[readIndex] = null;
                }
                writeIndex = (writeIndex + 1) & (deque.length - 1);
            }
        }
        tail = writeIndex;
    }

    private void shiftHeadLeft() {
        head = (head - 1) & (deque.length - 1);
    }

    private void shiftHeadRight() {
        head = (head + 1) & (deque.length - 1);

    }

    private void shiftTailLeft() {
        tail = (tail - 1) & (deque.length - 1);
    }

    private void shiftTailRight() {
        tail = (tail + 1) & (deque.length - 1);
    }
}
