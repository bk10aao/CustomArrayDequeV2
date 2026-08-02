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

| Method                          | V2        | JDK         |   Winner   |  Margin   |
|:--------------------------------|:----------|:------------|:----------:|:---------:|
| `add(E)`                        | 336       | 393         | **Custom** |   1.17x   |
| `addAll(Collection)`            | 149,339   | 169,494     | **Custom** |   1.13x   |
| `addFirst(E)`                   | 132       | 114         |  **JDK**   |   1.16x   |
| `addLast(E)`                    | 203       | 120         |  **JDK**   |   1.70x   |
| `clear()`                       | 326       | 30,497      | **Custom** |  93.61x   |
| `contains(Object)`              | 28,672    | 20,522      |  **JDK**   |   1.40x   |
| `containsAll(Collection)`       | 141,081   | 1,187,910   | **Custom** |   8.42x   |
| `descendingIterator()`          | 89,302    | 91,328      |  **Tie**   |   1.02x   |
| `element()`                     | 36        | 38          |  **Tie**   |   1.04x   |
| `equals(Object)`                | 89,474    | 338         |  **JDK**   |  264.40x  |
| `getFirst()`                    | 38        | 60          | **Custom** |   1.61x   |
| `getLast()`                     | 50        | 63          | **Custom** |   1.25x   |
| `isEmpty()`                     | 52        | 51          |  **Tie**   |   1.01x   |
| `iterator()`                    | 84,290    | 91,618      | **Custom** |   1.09x   |
| `offer(E)`                      | 152       | 254         | **Custom** |   1.67x   |
| `offerFirst(E)`                 | 122       | 161         | **Custom** |   1.32x   |
| `offerLast(E)`                  | 331       | 286         |  **JDK**   |   1.16x   |
| `peek()`                        | 31        | 34          | **Custom** |   1.11x   |
| `peekFirst()`                   | 31        | 33          | **Custom** |   1.08x   |
| `peekLast()`                    | 29        | 32          | **Custom** |   1.11x   |
| `poll()`                        | 186       | 165         |  **JDK**   |   1.13x   |
| `pollFirst()`                   | 61        | 93          | **Custom** |   1.52x   |
| `pollLast()`                    | 142       | 69          |  **JDK**   |   2.07x   |
| `pop()`                         | 71        | 173         | **Custom** |   2.44x   |
| `push(E)`                       | 105       | 124         | **Custom** |   1.18x   |
| `remove()`                      | 68        | 132         | **Custom** |   1.96x   |
| `remove(Object)`                | 67,777    | 28,120      |  **JDK**   |   2.41x   |
| `removeAll(Collection)`         | 483,159   | 853,949,674 | **Custom** | 1,767.43x |
| `removeFirst()`                 | 55        | 79          | **Custom** |   1.42x   |
| `removeFirstOccurrence(Object)` | 50,052    | 20,554      |  **JDK**   |   2.44x   |
| `removeLast()`                  | 56        | 113         | **Custom** |   2.02x   |
| `removeLastOccurrence(Object)`  | 64,440    | 30,898      |  **JDK**   |   2.09x   |
| `retainAll(Collection)`         | 478,647   | 854,068,357 | **Custom** | 1,784.34x |
| `size()`                        | 42        | 51          | **Custom** |   1.23x   |
| `toArray()`                     | 8,586     | 10,499      | **Custom** |   1.22x   |
| `toArray(T[])`                  | 34,634    | 34,608      |  **Tie**   |   1.00x   |
| `toString()`                    | 1,089,005 | 1,101,234   |  **Tie**   |   1.01x   |

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