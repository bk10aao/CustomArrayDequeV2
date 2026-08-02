import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import static java.lang.reflect.Array.newInstance;

public class CustomArrayDeque<E> implements Deque<E> {

    private E[] deque;
    private int head;
    private int tail;
    private final int minimumCapacity = 16;
    protected int modCount = 0;

    public CustomArrayDeque() {
        head = tail = 0;
        deque = (E[]) new Object[minimumCapacity];
    }

    public CustomArrayDeque(final int numElements) {
        if(numElements < 0)
            throw new IllegalArgumentException();
        int capacity = getNewSize(numElements);
        deque =  (E[]) new Object[capacity];
        head = tail = 0;
    }

    public CustomArrayDeque(final Collection<? extends E> c) {
        Objects.requireNonNull(c);
        int capaacity = getNewSize(c.size());
        deque =  (E[]) new Object[capaacity];
        head = 0;
        addAll(c);
    }

    public boolean add(final E item) {
        Objects.requireNonNull(item);
        if(requiresResize())
            expand(1);
        deque[tail] = item;
        shiftTailRight();
        modCount++;
        return true;
    }

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

    public void addFirst(final E item) {
        Objects.requireNonNull(item);
        if(requiresResize())
            expand(1);
        shiftHeadLeft();
        deque[head] = item;
        modCount++;
    }

    public void addLast(final E item) {
        add(item);
    }

    public void clear() {
        deque = (E[]) new Object[minimumCapacity];
        head = tail = 0;
        modCount++;
    }

    public boolean contains(final Object o) {
        if(o == null)
            return false;
        for(int i = 0; i < size(); i++)
            if(Objects.equals(o, deque[(head + i) & (deque.length - 1)]))
                return true;
        return false;
    }

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

    public E element() {
        return getFirst();
    }

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

    public E getFirst() {
        if(head == tail)
            throw new NoSuchElementException();
        return deque[head];
    }

    public E getLast() {
        if(head == tail)
            throw new NoSuchElementException();
        return peekLast();
    }

    public boolean isEmpty() {
        return head == tail;
    }

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

    public boolean offer(final E item) {
        Objects.requireNonNull(item);
        add(item);
        return true;
    }

    public boolean offerFirst(final E item) {
        Objects.requireNonNull(item);
        addFirst(item);
        return true;
    }

    public boolean offerLast(final E item) {
        Objects.requireNonNull(item);
        if(requiresResize())
            expand(1);
        add(item);
        return true;
    }

    public E peek() {
        if(head == tail)
            return null;
        return getFirst();
    }

    public E peekFirst() {
        if(head == tail)
            return null;
        return deque[head];
    }

    public E peekLast() {
        if(head == tail)
            return null;
        return deque[(tail - 1) & (deque.length - 1)];
    }

    public E poll() {
        if(head == tail)
            return null;
        return remove();
    }

    public E pollFirst() {
        if(head == tail)
            return null;
        return removeFirst();
    }

    public E pollLast() {
        if(head == tail)
            return null;
        return removeLast();
    }

    public E pop() {
        return removeFirst();
    }

    public void push(final E item) {
        addFirst(item);
    }

    public E remove() {
        return removeFirst();
    }

    public boolean remove(final Object o) {
        return removeFirstOccurrence(o);
    }

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

    public E removeFirst() {
        if(head == tail)
            throw new NoSuchElementException();
        E item = deque[head];
        deque[head] = null;
        shiftHeadRight();
        modCount++;
        return item;
    }

    public boolean removeFirstOccurrence(final Object o) {
        for(int i = 0; i < size(); i++)
            if(Objects.equals(o, deque[(head + i) & (deque.length - 1)])) {
                removeInnerElement(i);
                return true;
            }
        return false;
    }

    public E removeLast() {
        if(head == tail)
            throw new NoSuchElementException();
        shiftTailLeft();
        E item = deque[tail];
        deque[tail] = null;
        modCount++;
        return item;
    }

    public boolean removeLastOccurrence(final Object o) {
        for(int i = size() - 1; i >= 0; i--)
            if(Objects.equals(o, deque[(head + i) & (deque.length - 1)])) {
                removeInnerElement(i);
                return true;
            }
        return false;
    }

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

    public int size() {
        return (tail - head) & (deque.length - 1);
    }

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
        return a;
    }

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
