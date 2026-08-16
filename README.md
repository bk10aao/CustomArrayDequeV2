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

Comparison table uses the average JMH score (ns/op) across sizes 10k–100k.

### V2 vs JDK
| Method                          | V2 (ns)   | JDK (ns)  |            Winner            | Margin |
|:--------------------------------|:----------|:----------|:----------------------------:|:------:|
| `add(E)`                        | 157,394   | 362,922   |            **V2**            | 2.31x  |
| `addAll(Collection)`            | 109,573   | 167,741   |            **V2**            | 1.53x  |
| `addFirst(E)`                   | 155,049   | 254,255   |            **V2**            | 1.64x  |
| `addLast(E)`                    | 201,035   | 363,644   |            **V2**            | 1.81x  |
| `clear()`                       | 52        | 56        | **Statistically Equivalent** | 1.07x  |
| `contains(Object)`              | 29,907    | 21,105    |           **JDK**            | 1.42x  |
| `containsAll(Collection)`       | 773,662   | 991,846   |            **V2**            | 1.28x  |
| `descendingIterator()`          | 35,177    | 49,063    |            **V2**            | 1.39x  |
| `element()`                     | 50        | 65        |            **V2**            | 1.30x  |
| `equals(Object)`                | 385,405   | 359,352   | **Statistically Equivalent** | 1.07x  |
| `getFirst()`                    | 69        | 65        | **Statistically Equivalent** | 1.06x  |
| `getLast()`                     | 57        | 66        |            **V2**            | 1.17x  |
| `isEmpty()`                     | 55        | 70        |            **V2**            | 1.28x  |
| `iterator()`                    | 38,471    | 42,217    | **Statistically Equivalent** | 1.10x  |
| `offer(E)`                      | 181,393   | 271,155   |            **V2**            | 1.49x  |
| `offerFirst(E)`                 | 172,077   | 166,344   | **Statistically Equivalent** | 1.03x  |
| `offerLast(E)`                  | 195,571   | 174,098   | **Statistically Equivalent** | 1.12x  |
| `peek()`                        | 53        | 59        | **Statistically Equivalent** | 1.11x  |
| `peekFirst()`                   | 75        | 55        |           **JDK**            | 1.36x  |
| `peekLast()`                    | 60        | 58        | **Statistically Equivalent** | 1.02x  |
| `poll()`                        | 131,335   | 128,832   | **Statistically Equivalent** | 1.02x  |
| `pollFirst()`                   | 132,204   | 128,485   | **Statistically Equivalent** | 1.03x  |
| `pollLast()`                    | 129,354   | 132,518   | **Statistically Equivalent** | 1.02x  |
| `pop()`                         | 130,565   | 132,193   | **Statistically Equivalent** | 1.01x  |
| `push(E)`                       | 163,807   | 179,258   | **Statistically Equivalent** | 1.09x  |
| `remove()`                      | 134,254   | 132,917   | **Statistically Equivalent** | 1.01x  |
| `remove(Object)`                | 214,283   | 151,925   |           **JDK**            | 1.41x  |
| `removeAll(Collection)`         | 890,940   | 869,923   | **Statistically Equivalent** | 1.02x  |
| `removeFirst()`                 | 134,206   | 126,329   | **Statistically Equivalent** | 1.06x  |
| `removeFirstOccurrence(Object)` | 231,241   | 167,785   |           **JDK**            | 1.38x  |
| `removeLast()`                  | 141,778   | 131,815   | **Statistically Equivalent** | 1.08x  |
| `removeLastOccurrence(Object)`  | 228,703   | 150,749   |           **JDK**            | 1.52x  |
| `retainAll(Collection)`         | 842,800   | 829,622   | **Statistically Equivalent** | 1.02x  |
| `size()`                        | 59        | 71        |            **V2**            | 1.21x  |
| `toArray()`                     | 8,919     | 7,619     |           **JDK**            | 1.17x  |
| `toArray(T[])`                  | 37,626    | 41,216    | **Statistically Equivalent** | 1.10x  |
| `toString()`                    | 1,005,861 | 1,113,066 | **Statistically Equivalent** | 1.11x  |

### V1 vs V2

| Method                          | V1 (ns) | V2 (ns)   |            Winner            | Margin |
|:--------------------------------|:--------|:----------|:----------------------------:|:------:|
| `add(E)`                        | 224,146 | 157,394   |            **V2**            | 1.42x  |
| `addAll(Collection)`            | 94,839  | 109,573   |            **V1**            | 1.16x  |
| `addFirst(E)`                   | 151,967 | 155,049   | **Statistically Equivalent** | 1.02x  |
| `addLast(E)`                    | 223,640 | 201,035   | **Statistically Equivalent** | 1.11x  |
| `clear()`                       | 32      | 52        |            **V1**            | 1.66x  |
| `contains(Object)`              | 14,592  | 29,907    |            **V1**            | 2.05x  |
| `containsAll(Collection)`       | 702,213 | 773,662   | **Statistically Equivalent** | 1.10x  |
| `descendingIterator()`          | 33,691  | 35,177    | **Statistically Equivalent** | 1.04x  |
| `element()`                     | 32      | 50        |            **V1**            | 1.56x  |
| `equals(Object)`                | 262,560 | 385,405   |            **V1**            | 1.47x  |
| `getFirst()`                    | 32      | 69        |            **V1**            | 2.13x  |
| `getLast()`                     | 32      | 57        |            **V1**            | 1.75x  |
| `isEmpty()`                     | 36      | 55        |            **V1**            | 1.54x  |
| `iterator()`                    | 33,103  | 38,471    |            **V1**            | 1.16x  |
| `offer(E)`                      | 221,613 | 181,393   |            **V2**            | 1.22x  |
| `offerFirst(E)`                 | 140,523 | 172,077   |            **V1**            | 1.22x  |
| `offerLast(E)`                  | 148,519 | 195,571   |            **V1**            | 1.32x  |
| `peek()`                        | 40      | 53        |            **V1**            | 1.32x  |
| `peekFirst()`                   | 41      | 75        |            **V1**            | 1.82x  |
| `peekLast()`                    | 39      | 60        |            **V1**            | 1.52x  |
| `poll()`                        | 109,990 | 131,335   |            **V1**            | 1.19x  |
| `pollFirst()`                   | 110,071 | 132,204   |            **V1**            | 1.20x  |
| `pollLast()`                    | 110,568 | 129,354   |            **V1**            | 1.17x  |
| `pop()`                         | 109,347 | 130,565   |            **V1**            | 1.19x  |
| `push(E)`                       | 150,868 | 163,807   | **Statistically Equivalent** | 1.09x  |
| `remove()`                      | 109,896 | 134,254   |            **V1**            | 1.22x  |
| `remove(Object)`                | 129,862 | 214,283   |            **V1**            | 1.65x  |
| `removeAll(Collection)`         | 763,193 | 890,940   |            **V1**            | 1.17x  |
| `removeFirst()`                 | 109,818 | 134,206   |            **V1**            | 1.22x  |
| `removeFirstOccurrence(Object)` | 127,908 | 231,241   |            **V1**            | 1.81x  |
| `removeLast()`                  | 111,249 | 141,778   |            **V1**            | 1.27x  |
| `removeLastOccurrence(Object)`  | 126,932 | 228,703   |            **V1**            | 1.80x  |
| `retainAll(Collection)`         | 709,455 | 842,800   |            **V1**            | 1.19x  |
| `size()`                        | 40      | 59        |            **V1**            | 1.47x  |
| `toArray()`                     | 6,653   | 8,919     |            **V1**            | 1.34x  |
| `toArray(T[])`                  | 32,613  | 37,626    | **Statistically Equivalent** | 1.15x  |
| `toString()`                    | 880,184 | 1,005,861 | **Statistically Equivalent** | 1.14x  |

# Performance Charts

#### Note: The following performance charts are designed to be viewed in dark mode.

# Heat Maps
![Heatmap](PerformanceCharts/V2_JDK/heatmap.png)
![Heatmap](PerformanceCharts/V1_V2/heatmap.png)
![Heatmap](PerformanceCharts/V1_JDK/heatmap.png)

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

## V1 vs JDK

![Constructor](PerformanceCharts/V1_JDK/plot_constructor__.png)
![ConstructCollection](PerformanceCharts/V1_JDK/plot_constructor_Collection_.png)
![add](PerformanceCharts/V1_JDK/plot_add_E_.png)
![addAll](PerformanceCharts/V1_JDK/plot_addAll_Collection_.png)
![addFirst](PerformanceCharts/V1_JDK/plot_addFirst_E_.png)
![addLast](PerformanceCharts/V1_JDK/plot_addLast_E_.png)
![clear](PerformanceCharts/V1_JDK/plot_clear__.png)
![contains](PerformanceCharts/V1_JDK/plot_contains_Object_.png)
![containsAll](PerformanceCharts/V1_JDK/plot_containsAll_Collection_.png)
![descendingOrderIterator](PerformanceCharts/V1_JDK/plot_descendingIterator__.png)
![element](PerformanceCharts/V1_JDK/plot_element__.png)
![equals](PerformanceCharts/V1_JDK/plot_equals_Object_.png)
![getFirst](PerformanceCharts/V1_JDK/plot_getFirst__.png)
![getLast](PerformanceCharts/V1_JDK/plot_getLast__.png)
![isEmpty](PerformanceCharts/V1_JDK/plot_isEmpty__.png)
![iterator](PerformanceCharts/V1_JDK/plot_iterator__.png)
![offer](PerformanceCharts/V1_JDK/plot_offer_E_.png)
![offerFirst](PerformanceCharts/V1_JDK/plot_offerFirst_E_.png)
![offerLast](PerformanceCharts/V1_JDK/plot_offerLast_E_.png)
![peek](PerformanceCharts/V1_JDK/plot_peek__.png)
![peekFirst](PerformanceCharts/V1_JDK/plot_peekFirst__.png)
![peekLast](PerformanceCharts/V1_JDK/plot_peekLast__.png)
![poll](PerformanceCharts/V1_JDK/plot_poll__.png)
![pollFirst](PerformanceCharts/V1_JDK/plot_pollFirst__.png)
![pollLast](PerformanceCharts/V1_JDK/plot_pollLast__.png)
![pop](PerformanceCharts/V1_JDK/plot_pop__.png)
![push](PerformanceCharts/V1_JDK/plot_push_E_.png)
![remove](PerformanceCharts/V1_JDK/plot_remove__.png)
![removeObject](PerformanceCharts/V1_JDK/plot_remove_Object_.png)
![removeAll](PerformanceCharts/V1_JDK/plot_removeAll_Collection_.png)
![removeFirst](PerformanceCharts/V1_JDK/plot_removeFirst__.png)
![removeFirstOccurrence](PerformanceCharts/V1_JDK/plot_removeFirstOccurrence_Object_.png)
![removeLast](PerformanceCharts/V1_JDK/plot_removeLast__.png)
![removeLastOccurrence](PerformanceCharts/V1_JDK/plot_removeLastOccurrence_Object_.png)
![retainAll](PerformanceCharts/V1_JDK/plot_retainAll_Collection_.png)
![size](PerformanceCharts/V1_JDK/plot_size__.png)
![toArray](PerformanceCharts/V1_JDK/plot_toArray__.png)
![toArray_T](PerformanceCharts/V1_JDK/plot_toArray_T[]_.png)
![toString](PerformanceCharts/V1_JDK/plot_toString__.png)