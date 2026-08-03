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
| Method                          | V2 (ns)   | JDK (ns)    |            Winner            |  Margin   |
|:--------------------------------|:----------|:------------|:----------------------------:|:---------:|
| `add(E)`                        | 166       | 393         |            **V2**            |   2.37x   |
| `addAll(Collection)`            | 172,891   | 169,494     | **Statistically Equivalent** |   1.02x   |
| `addFirst(E)`                   | 116       | 114         | **Statistically Equivalent** |   1.02x   |
| `addLast(E)`                    | 104       | 120         |            **V2**            |   1.15x   |
| `clear()`                       | 345       | 30,497      |            **V2**            |  88.40x   |
| `contains(Object)`              | 47,545    | 20,522      |           **JDK**            |   2.32x   |
| `containsAll(Collection)`       | 206,840   | 1,187,910   |            **V2**            |   5.74x   |
| `descendingIterator()`          | 70,808    | 91,328      |            **V2**            |   1.29x   |
| `element()`                     | 31        | 38          |            **V2**            |   1.23x   |
| `equals(Object)`                | 140,662   | 338         |           **JDK**            |  416.16x  |
| `getFirst()`                    | 31        | 60          |            **V2**            |   1.94x   |
| `getLast()`                     | 35        | 63          |            **V2**            |   1.80x   |
| `isEmpty()`                     | 47        | 51          | **Statistically Equivalent** |   1.09x   |
| `iterator()`                    | 66,091    | 91,618      |            **V2**            |   1.39x   |
| `offer(E)`                      | 83        | 254         |            **V2**            |   3.06x   |
| `offerFirst(E)`                 | 141       | 161         |            **V2**            |   1.14x   |
| `offerLast(E)`                  | 266       | 286         | **Statistically Equivalent** |   1.08x   |
| `peek()`                        | 34        | 34          | **Statistically Equivalent** |   1.00x   |
| `peekFirst()`                   | 30        | 33          | **Statistically Equivalent** |   1.10x   |
| `peekLast()`                    | 30        | 32          | **Statistically Equivalent** |   1.07x   |
| `poll()`                        | 108       | 165         |            **V2**            |   1.53x   |
| `pollFirst()`                   | 50        | 93          |            **V2**            |   1.86x   |
| `pollLast()`                    | 79        | 69          |           **JDK**            |   1.14x   |
| `pop()`                         | 58        | 173         |            **V2**            |   2.98x   |
| `push(E)`                       | 125       | 124         | **Statistically Equivalent** |   1.01x   |
| `remove()`                      | 79        | 132         |            **V2**            |   1.67x   |
| `remove(Object)`                | 71,870    | 28,120      |           **JDK**            |   2.56x   |
| `removeAll(Collection)`         | 692,354   | 853,949,674 |            **V2**            | 1,233.41x |
| `removeFirst()`                 | 54        | 79          |            **V2**            |   1.46x   |
| `removeFirstOccurrence(Object)` | 74,441    | 20,554      |           **JDK**            |   3.62x   |
| `removeLast()`                  | 50        | 113         |            **V2**            |   2.26x   |
| `removeLastOccurrence(Object)`  | 61,366    | 30,898      |           **JDK**            |   1.99x   |
| `retainAll(Collection)`         | 507,633   | 854,068,357 |            **V2**            | 1,682.47x |
| `size()`                        | 37        | 51          |            **V2**            |   1.38x   |
| `toArray()`                     | 11,940    | 10,499      |           **JDK**            |   1.14x   |
| `toArray(T[])`                  | 54,345    | 34,608      |           **JDK**            |   1.57x   |
| `toString()`                    | 1,888,071 | 1,101,234   |           **JDK**            |   1.71x   |

### V1 vs V2

| Method                          | V1 (ns)   | V2 (ns)     |            Winner            |  Margin   |
|:--------------------------------|:----------|:------------|:----------------------------:|:---------:|
| `add(E)`                        | 166       | 166         | **Statistically Equivalent** |   1.00x   |
| `addAll(Collection)`            | 184,845   | 172,891     | **Statistically Equivalent** |   1.07x   |
| `addFirst(E)`                   | 41        | 116         |            **V1**            |   2.83x   |
| `addLast(E)`                    | 75        | 104         |            **V1**            |   1.39x   |
| `clear()`                       | 287       | 345         |            **V1**            |   1.20x   |
| `contains(Object)`              | 31,952    | 47,545      |            **V1**            |   1.49x   |
| `containsAll(Collection)`       | 161,906   | 206,840     |            **V1**            |   1.28x   |
| `descendingIterator()`          | 70,150    | 70,808      | **Statistically Equivalent** |   1.01x   |
| `element()`                     | 35        | 31          |            **V2**            |   1.13x   |
| `equals(Object)`                | 120,365   | 140,662     |            **V1**            |   1.17x   |
| `getFirst()`                    | 27        | 31          |            **V1**            |   1.15x   |
| `getLast()`                     | 30        | 35          |            **V1**            |   1.17x   |
| `isEmpty()`                     | 42        | 47          |            **V1**            |   1.12x   |
| `iterator()`                    | 66,100    | 66,091      | **Statistically Equivalent** |   1.00x   |
| `offer(E)`                      | 112       | 83          |            **V2**            |   1.35x   |
| `offerFirst(E)`                 | 75        | 141         |            **V1**            |   1.88x   |
| `offerLast(E)`                  | 221       | 266         |            **V1**            |   1.20x   |
| `peek()`                        | 34        | 34          | **Statistically Equivalent** |   1.00x   |
| `peekFirst()`                   | 28        | 30          | **Statistically Equivalent** |   1.07x   |
| `peekLast()`                    | 33        | 30          | **Statistically Equivalent** |   1.10x   |
| `poll()`                        | 270       | 108         |            **V2**            |   2.50x   |
| `pollFirst()`                   | 91        | 50          |            **V2**            |   1.82x   |
| `pollLast()`                    | 79        | 79          | **Statistically Equivalent** |   1.00x   |
| `pop()`                         | 75        | 58          |            **V2**            |   1.29x   |
| `push(E)`                       | 100       | 125         |            **V1**            |   1.25x   |
| `remove()`                      | 74        | 79          | **Statistically Equivalent** |   1.07x   |
| `remove(Object)`                | 22,478    | 71,870      |            **V1**            |   3.20x   |
| `removeAll(Collection)`         | 438,512   | 692,354     |            **V1**            |   1.58x   |
| `removeFirst()`                 | 174       | 54          |            **V2**            |   3.22x   |
| `removeFirstOccurrence(Object)` | 25,504    | 74,441      |            **V1**            |   2.92x   |
| `removeLast()`                  | 70        | 50          |            **V2**            |   1.40x   |
| `removeLastOccurrence(Object)`  | 20,150    | 61,366      |            **V1**            |   3.05x   |
| `retainAll(Collection)`         | 459,841   | 507,633     | **Statistically Equivalent** |   1.10x   |
| `size()`                        | 35        | 37          | **Statistically Equivalent** |   1.06x   |
| `toArray()`                     | 12,268    | 11,940      | **Statistically Equivalent** |   1.03x   |
| `toArray(T[])`                  | 53,814    | 54,345      | **Statistically Equivalent** |   1.01x   |
| `toString()`                    | 1,497,708 | 1,888,071   |            **V1**            |   1.26x   |
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