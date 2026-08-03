# Custom Array Deque

An implementation of a java ArrayDeque using a circular buffer.

All methods implemented are identical to those found in the [Java Deque interface](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Deque.html).

Version one using a non-circular buffer can be found [here](https://github.com/bk10aao/CustomArrayDeque).

# Build and Test

To build and test the project run command `./gradlew clean build`

To test the project run command `./gradlew test`

# Time Complexity

| Method                            |          V1          |           V2           |       JDK       |     Winner      |
|:----------------------------------|:--------------------:|:----------------------:|:---------------:|:---------------:|
| **add(E)**                        |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **addFirst(E)**                   |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **addLast(E)**                    |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **offer(E)**                      |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **offerFirst(E)**                 |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **offerLast(E)**                  |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **push(E)**                       |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **addAll(Collection)**            |      $O(n + m)$      |       $O(n + m)$       |   $O(n + m)$    |       Tie       |
| **element()**                     |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **getFirst()**                    |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **getLast()**                     |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **peek()**                        |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **peekFirst()**                   |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **peekLast()**                    |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **contains(Object)**              |        $O(n)$        |         $O(n)$         |     $O(n)$      |       Tie       |
| **containsAll(Collection)**       |      $O(n + m)$      |       $O(n + m)$       |   $O(n + m)$    |       Tie       |
| **size()**                        |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **isEmpty()**                     |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **remove()**                      |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **removeFirst()**                 |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **removeLast()**                  |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **poll()**                        |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **pollFirst()**                   |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **pollLast()**                    |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **pop()**                         |        $O(1)$        |         $O(1)$         |     $O(1)$      |       Tie       |
| **remove(Object)**                |        $O(n)$        |         $O(n)$         |     $O(n)$      |       Tie       |
| **removeFirstOccurrence(Object)** |        $O(n)$        |         $O(n)$         |     $O(n)$      |       Tie       |
| **removeLastOccurrence(Object)**  |        $O(n)$        |         $O(n)$         |     $O(n)$      |       Tie       |
| **removeAll(Collection)**         |   $O(n \times m)$    |    $O(n \times m)$     | $O(n \times m)$ |       Tie       |
| **retainAll(Collection)**         |   $O(n \times m)$    |    $O(n \times m)$     | $O(n \times m)$ |       Tie       |
| **clear()**                       |        $O(1)$        |         $O(1)$         |     $O(n)$      |     V1 & V2     |
| **toArray()**                     |        $O(n)$        |         $O(n)$         |     $O(n)$      |       Tie       |
| **toArray(T[])**                  |        $O(n)$        |         $O(n)$         |     $O(n)$      |       Tie       |
| **toString()**                    |        $O(n)$        |         $O(n)$         |     $O(n)$      |       Tie       |
| **equals(Object)**                |        $O(n)$        |         $O(n)$         |     $O(n)$      |       Tie       |
| **iterator()**                    |        $O(n)$        |         $O(n)$         |     $O(1)$      |       JDK       |
| **descendingIterator()**          |        $O(n)$        |         $O(n)$         |     $O(1)$      |       JDK       |

# Space Complexity

# Space Complexity Comparison

| Method                            |          V1          |           V2           |       JDK       | Winner |
|:----------------------------------|:--------------------:|:----------------------:|:---------------:|:------:|
| **add(E)**                        |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **addAll(Collection)**            |        $O(m)$        |         $O(m)$         |     $O(m)$      |  Tie   |
| **addFirst(E)**                   |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **addLast(E)**                    |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **clear()**                       |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **contains(Object)**              |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **containsAll(Collection)**       |        $O(m)$        |         $O(m)$         |     $O(m)$      |  Tie   |
| **descendingIterator()**          |        $O(n)$        |         $O(n)$         |     $O(1)$      |  JDK   |
| **element()**                     |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **equals(Object)**                |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **getFirst()**                    |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **getLast()**                     |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **isEmpty()**                     |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **iterator()**                    |        $O(n)$        |         $O(n)$         |     $O(1)$      |  JDK   |
| **offer(E)**                      |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **offerFirst(E)**                 |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **offerLast(E)**                  |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **peek()**                        |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **peekFirst()**                   |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **peekLast()**                    |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **poll()**                        |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **pollFirst()**                   |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **pollLast()**                    |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **pop()**                         |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **push(E)**                       |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **remove()**                      |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **remove(Object)**                |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **removeAll(Collection)**         |        $O(m)$        |         $O(m)$         |     $O(m)$      |  Tie   |
| **removeFirst()**                 |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **removeFirstOccurrence(Object)** |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **removeLast()**                  |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **removeLastOccurrence(Object)**  |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **retainAll(Collection)**         |        $O(m)$        |         $O(m)$         |     $O(m)$      |  Tie   |
| **size()**                        |        $O(1)$        |         $O(1)$         |     $O(1)$      |  Tie   |
| **toArray()**                     |        $O(n)$        |         $O(n)$         |     $O(n)$      |  Tie   |
| **toArray(T[])**                  |        $O(n)$        |         $O(n)$         |     $O(n)$      |  Tie   |
| **toString()**                    |        $O(n)$        |         $O(n)$         |     $O(n)$      |  Tie   |

Notes:
- n: Current number of elements in the deque.
- m: Number of elements in the input collection.

# Performance

Below performance is a comparison made at 100,000 operations per method.

Note: all data is an average of 100 runs. Margins within $\pm 5\%$ ($\le 1.05x$) are considered statistical ties.

### V2 vs JDK
| Method                          | V2        | JDK         | Winner         | Margin    |
|---------------------------------|-----------|-------------|----------------|-----------|
| `add(E)`                        | 166       | 393         | **Custom**     | 2.37x     |
| `addAll(Collection)`            | 172,891   | 169,494     | **Equivalent** | 1.02x     |
| `addFirst(E)`                   | 116       | 114         | **Equivalent** | 1.02x     |
| `addLast(E)`                    | 104       | 120         | **Custom**     | 1.15x     |
| `clear()`                       | 345       | 30,497      | **Custom**     | 88.40x    |
| `contains(Object)`              | 47,545    | 20,522      | **JDK**        | 2.32x     |
| `containsAll(Collection)`       | 206,840   | 1,187,910   | **Custom**     | 5.74x     |
| `descendingIterator()`          | 70,808    | 91,328      | **Custom**     | 1.29x     |
| `element()`                     | 31        | 38          | **Custom**     | 1.23x     |
| `equals(Object)`                | 140,662   | 338         | **JDK**        | 416.16x   |
| `getFirst()`                    | 31        | 60          | **Custom**     | 1.94x     |
| `getLast()`                     | 35        | 63          | **Custom**     | 1.80x     |
| `isEmpty()`                     | 47        | 51          | **Equivalent** | 1.09x     |
| `iterator()`                    | 66,091    | 91,618      | **Custom**     | 1.39x     |
| `offer(E)`                      | 83        | 254         | **Custom**     | 3.06x     |
| `offerFirst(E)`                 | 141       | 161         | **Custom**     | 1.14x     |
| `offerLast(E)`                  | 266       | 286         | **Equivalent** | 1.08x     |
| `peek()`                        | 34        | 34          | **Equivalent** | 1.00x     |
| `peekFirst()`                   | 30        | 33          | **Equivalent** | 1.10x     |
| `peekLast()`                    | 30        | 32          | **Equivalent** | 1.07x     |
| `poll()`                        | 108       | 165         | **Custom**     | 1.53x     |
| `pollFirst()`                   | 50        | 93          | **Custom**     | 1.86x     |
| `pollLast()`                    | 79        | 69          | **JDK**        | 1.14x     |
| `pop()`                         | 58        | 173         | **Custom**     | 2.98x     |
| `push(E)`                       | 125       | 124         | **Equivalent** | 1.01x     |
| `remove()`                      | 79        | 132         | **Custom**     | 1.67x     |
| `remove(Object)`                | 71,870    | 28,120      | **JDK**        | 2.56x     |
| `removeAll(Collection)`         | 692,354   | 853,949,674 | **Custom**     | 1,233.41x |
| `removeFirst()`                 | 54        | 79          | **Custom**     | 1.46x     |
| `removeFirstOccurrence(Object)` | 74,441    | 20,554      | **JDK**        | 3.62x     |
| `removeLast()`                  | 50        | 113         | **Custom**     | 2.26x     |
| `removeLastOccurrence(Object)`  | 61,366    | 30,898      | **JDK**        | 1.99x     |
| `retainAll(Collection)`         | 507,633   | 854,068,357 | **Custom**     | 1,682.47x |
| `size()`                        | 37        | 51          | **Custom**     | 1.38x     |
| `toArray()`                     | 11,940    | 10,499      | **JDK**        | 1.14x     |
| `toArray(T[])`                  | 54,345    | 34,608      | **JDK**        | 1.57x     |
| `toString()`                    | 1,888,071 | 1,101,234   | **JDK**        | 1.71x     |

### V1 vs V2

| Method                          | V1 (ns) | V2 (ns)   | Winner  | Margin |
|:--------------------------------|:--------|:----------|:-------:|:------:|
| `add(E)`                        | 326     | 336       | **Tie** | 1.03x  |
| `addAll(Collection)`            | 143,766 | 149,339   | **Tie** | 1.04x  |
| `addFirst(E)`                   | 117     | 132       | **V1**  | 1.13x  |
| `addLast(E)`                    | 221     | 203       | **V2**  | 1.09x  |
| `clear()`                       | 386     | 326       | **V2**  | 1.18x  |
| `contains(Object)`              | 22,047  | 28,672    | **V1**  | 1.30x  |
| `containsAll(Collection)`       | 115,516 | 141,081   | **V1**  | 1.22x  |
| `descendingIterator()`          | 99,398  | 89,302    | **V2**  | 1.11x  |
| `element()`                     | 34      | 36        | **V1**  | 1.06x  |
| `equals(Object)`                | 71,564  | 89,474    | **V1**  | 1.25x  |
| `getFirst()`                    | 43      | 38        | **V2**  | 1.14x  |
| `getLast()`                     | 40      | 50        | **V1**  | 1.28x  |
| `isEmpty()`                     | 52      | 52        | **Tie** | 1.00x  |
| `iterator()`                    | 93,027  | 84,290    | **V2**  | 1.10x  |
| `offer(E)`                      | 125     | 152       | **V1**  | 1.22x  |
| `offerFirst(E)`                 | 113     | 122       | **V1**  | 1.09x  |
| `offerLast(E)`                  | 270     | 331       | **V1**  | 1.23x  |
| `peek()`                        | 32      | 31        | **Tie** | 1.05x  |
| `peekFirst()`                   | 32      | 31        | **Tie** | 1.04x  |
| `peekLast()`                    | 32      | 29        | **V2**  | 1.11x  |
| `poll()`                        | 166     | 186       | **V1**  | 1.12x  |
| `pollFirst()`                   | 90      | 61        | **V2**  | 1.47x  |
| `pollLast()`                    | 120     | 142       | **V1**  | 1.19x  |
| `pop()`                         | 77      | 71        | **V2**  | 1.08x  |
| `push(E)`                       | 122     | 105       | **V2**  | 1.16x  |
| `remove()`                      | 67      | 68        | **Tie** | 1.01x  |
| `remove(Object)`                | 35,387  | 67,777    | **V1**  | 1.92x  |
| `removeAll(Collection)`         | 415,387 | 483,159   | **V1**  | 1.16x  |
| `removeFirst()`                 | 82      | 55        | **V2**  | 1.49x  |
| `removeFirstOccurrence(Object)` | 23,336  | 50,052    | **V1**  | 2.14x  |
| `removeLast()`                  | 57      | 56        | **Tie** | 1.01x  |
| `removeLastOccurrence(Object)`  | 37,793  | 64,440    | **V1**  | 1.71x  |
| `retainAll(Collection)`         | 382,795 | 478,647   | **V1**  | 1.25x  |
| `size()`                        | 44      | 42        | **V2**  | 1.07x  |
| `toArray()`                     | 7,879   | 8,586     | **V1**  | 1.09x  |
| `toArray(T[])`                  | 33,924  | 34,634    | **Tie** | 1.02x  |
| `toString()`                    | 957,173 | 1,089,005 | **V1**  | 1.14x  |

# Performance Charts

#### Note: The following performance charts are designed to be viewed in dark mode.

# Heat Maps

### V2 vs JDK
![Heatmap](PerformanceCharts/V2_JDK/heatmap.png)

### V1 vs V2
![Heatmap](PerformanceCharts/V1_V2/heatmap.png)
# V1 vs V2 vs JDK

![add](PerformanceCharts/V1_V2_JDK/plot_add_E_.png)
![addAll](PerformanceCharts/V1_V2_JDK/plot_addAll_Collection_.png)
![addFirst](PerformanceCharts/V1_V2_JDK/plot_addFirst_E_.png)
![addLast](PerformanceCharts/V1_V2_JDK/plot_addLast_E_.png)
![clear](PerformanceCharts/V1_V2_JDK/plot_clear__.png)
![contains](PerformanceCharts/V1_V2_JDK/plot_contains_Object_.png)
![containsAll](PerformanceCharts/V1_V2_JDK/plot_containsAll_Collection_.png)
![descendingOrderIterator](PerformanceCharts/V1_V2_JDK/plot_descendingIterator__.png)
![element](PerformanceCharts/V1_V2_JDK/plot_element__.png)
![equals](PerformanceCharts/V1_V2_JDK/plot_equals_Object_.png)
![getFirst](PerformanceCharts/V1_V2_JDK/plot_getFirst__.png)
![getLast](PerformanceCharts/V1_V2_JDK/plot_getLast__.png)
![isEmpty](PerformanceCharts/V1_V2_JDK/plot_isEmpty__.png)
![iterator](PerformanceCharts/V1_V2_JDK/plot_iterator__.png)
![offer](PerformanceCharts/V1_V2_JDK/plot_offer_E_.png)
![offerFirst](PerformanceCharts/V1_V2_JDK/plot_offerFirst_E_.png)
![offerLast](PerformanceCharts/V1_V2_JDK/plot_offerLast_E_.png)
![peek](PerformanceCharts/V1_V2_JDK/plot_peek__.png)
![peekFirst](PerformanceCharts/V1_V2_JDK/plot_peekFirst__.png)
![peekLast](PerformanceCharts/V1_V2_JDK/plot_peekLast__.png)
![poll](PerformanceCharts/V1_V2_JDK/plot_poll__.png)
![pollFirst](PerformanceCharts/V1_V2_JDK/plot_pollFirst__.png)
![pollLast](PerformanceCharts/V1_V2_JDK/plot_pollLast__.png)
![pop](PerformanceCharts/V1_V2_JDK/plot_pop__.png)
![push](PerformanceCharts/V1_V2_JDK/plot_push_E_.png)
![remove](PerformanceCharts/V1_V2_JDK/plot_remove__.png)
![removeObject](PerformanceCharts/V1_V2_JDK/plot_remove_Object_.png)
![removeAll](PerformanceCharts/V1_V2_JDK/plot_removeAll_Collection_.png)
![removeFirst](PerformanceCharts/V1_V2_JDK/plot_removeFirst__.png)
![removeFirstOccurrence](PerformanceCharts/V1_V2_JDK/plot_removeFirstOccurrence_Object_.png)
![removeLast](PerformanceCharts/V1_V2_JDK/plot_removeLast__.png)
![removeLastOccurrence](PerformanceCharts/V1_V2_JDK/plot_removeLastOccurrence_Object_.png)
![retainAll](PerformanceCharts/V1_V2_JDK/plot_retainAll_Collection_.png)
![size](PerformanceCharts/V1_V2_JDK/plot_size__.png)
![toArray](PerformanceCharts/V1_V2_JDK/plot_toArray__.png)
![toArray_T](PerformanceCharts/V1_V2_JDK/plot_toArray_T[]_.png)
![toString](PerformanceCharts/V1_V2_JDK/plot_toString__.png)

## V2 vs JDK

![add](PerformanceCharts/V2_JDK/plot_add_E_.png)
![addAll](PerformanceCharts/V2_JDK/plot_addAll_Collection_.png)
![addFirst](PerformanceCharts/V2_JDK/plot_addFirst_E_.png)
![addLast](PerformanceCharts/V2_JDK/plot_addLast_E_.png)
![clear](PerformanceCharts/V2_JDK/plot_clear__.png)
![contains](PerformanceCharts/V2_JDK/plot_contains_Object_.png)
![containsAll](PerformanceCharts/V2_JDK/plot_containsAll_Collection_.png)
![descendingOrderIterator](PerformanceCharts/V2_JDK/plot_descendingIterator__.png)
![element](PerformanceCharts/V2_JDK/plot_element__.png)
![equals](PerformanceCharts/V2_JDK/plot_equals_Object_.png)
![getFirst](PerformanceCharts/V2_JDK/plot_getFirst__.png)
![getLast](PerformanceCharts/V2_JDK/plot_getLast__.png)
![isEmpty](PerformanceCharts/V2_JDK/plot_isEmpty__.png)
![iterator](PerformanceCharts/V2_JDK/plot_iterator__.png)
![offer](PerformanceCharts/V2_JDK/plot_offer_E_.png)
![offerFirst](PerformanceCharts/V2_JDK/plot_offerFirst_E_.png)
![offerLast](PerformanceCharts/V2_JDK/plot_offerLast_E_.png)
![peek](PerformanceCharts/V2_JDK/plot_peek__.png)
![peekFirst](PerformanceCharts/V2_JDK/plot_peekFirst__.png)
![peekLast](PerformanceCharts/V2_JDK/plot_peekLast__.png)
![poll](PerformanceCharts/V2_JDK/plot_poll__.png)
![pollFirst](PerformanceCharts/V2_JDK/plot_pollFirst__.png)
![pollLast](PerformanceCharts/V2_JDK/plot_pollLast__.png)
![pop](PerformanceCharts/V2_JDK/plot_pop__.png)
![push](PerformanceCharts/V2_JDK/plot_push_E_.png)
![remove](PerformanceCharts/V2_JDK/plot_remove__.png)
![removeObject](PerformanceCharts/V2_JDK/plot_remove_Object_.png)
![removeAll](PerformanceCharts/V2_JDK/plot_removeAll_Collection_.png)
![removeFirst](PerformanceCharts/V2_JDK/plot_removeFirst__.png)
![removeFirstOccurrence](PerformanceCharts/V2_JDK/plot_removeFirstOccurrence_Object_.png)
![removeLast](PerformanceCharts/V2_JDK/plot_removeLast__.png)
![removeLastOccurrence](PerformanceCharts/V2_JDK/plot_removeLastOccurrence_Object_.png)
![retainAll](PerformanceCharts/V2_JDK/plot_retainAll_Collection_.png)
![size](PerformanceCharts/V2_JDK/plot_size__.png)
![toArray](PerformanceCharts/V2_JDK/plot_toArray__.png)
![toArray_T](PerformanceCharts/V2_JDK/plot_toArray_T[]_.png)
![toString](PerformanceCharts/V2_JDK/plot_toString__.png)

## V1 vs V2

![add](PerformanceCharts/V1_V2/plot_add_E_.png)
![addAll](PerformanceCharts/V1_V2/plot_addAll_Collection_.png)
![addFirst](PerformanceCharts/V1_V2/plot_addFirst_E_.png)
![addLast](PerformanceCharts/V1_V2/plot_addLast_E_.png)
![clear](PerformanceCharts/V1_V2/plot_clear__.png)
![contains](PerformanceCharts/V1_V2/plot_contains_Object_.png)
![containsAll](PerformanceCharts/V1_V2/plot_containsAll_Collection_.png)
![descendingOrderIterator](PerformanceCharts/V1_V2/plot_descendingIterator__.png)
![element](PerformanceCharts/V1_V2/plot_element__.png)
![equals](PerformanceCharts/V1_V2/plot_equals_Object_.png)
![getFirst](PerformanceCharts/V1_V2/plot_getFirst__.png)
![getLast](PerformanceCharts/V1_V2/plot_getLast__.png)
![isEmpty](PerformanceCharts/V1_V2/plot_isEmpty__.png)
![iterator](PerformanceCharts/V1_V2/plot_iterator__.png)
![offer](PerformanceCharts/V1_V2/plot_offer_E_.png)
![offerFirst](PerformanceCharts/V1_V2/plot_offerFirst_E_.png)
![offerLast](PerformanceCharts/V1_V2/plot_offerLast_E_.png)
![peek](PerformanceCharts/V1_V2/plot_peek__.png)
![peekFirst](PerformanceCharts/V1_V2/plot_peekFirst__.png)
![peekLast](PerformanceCharts/V1_V2/plot_peekLast__.png)
![poll](PerformanceCharts/V1_V2/plot_poll__.png)
![pollFirst](PerformanceCharts/V1_V2/plot_pollFirst__.png)
![pollLast](PerformanceCharts/V1_V2/plot_pollLast__.png)
![pop](PerformanceCharts/V1_V2/plot_pop__.png)
![push](PerformanceCharts/V1_V2/plot_push_E_.png)
![remove](PerformanceCharts/V1_V2/plot_remove__.png)
![removeObject](PerformanceCharts/V1_V2/plot_remove_Object_.png)
![removeAll](PerformanceCharts/V1_V2/plot_removeAll_Collection_.png)
![removeFirst](PerformanceCharts/V1_V2/plot_removeFirst__.png)
![removeFirstOccurrence](PerformanceCharts/V1_V2/plot_removeFirstOccurrence_Object_.png)
![removeLast](PerformanceCharts/V1_V2/plot_removeLast__.png)
![removeLastOccurrence](PerformanceCharts/V1_V2/plot_removeLastOccurrence_Object_.png)
![retainAll](PerformanceCharts/V1_V2/plot_retainAll_Collection_.png)
![size](PerformanceCharts/V1_V2/plot_size__.png)
![toArray](PerformanceCharts/V1_V2/plot_toArray__.png)
![toArray_T](PerformanceCharts/V1_V2/plot_toArray_T[]_.png)
![toString](PerformanceCharts/V1_V2/plot_toString__.png)