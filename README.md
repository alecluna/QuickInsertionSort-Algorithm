# QuickInsertionSort-Algorithm
A hybrid implementation of QuickSort with an optimization for using Insertion Sort when partitions become a certain size


I set insertionSortNonRecursive() to kick in when the size of the partitions reached 10. Looking at the table, we immediately see the benefits of quickInsertionSort1’s use of Insertion Sort on small partitions, as it vastly beats out QuickSort at around size = 100. It appears to maintain its average case of O(nlogn). In the second iteration, we will see that we can do slightly better.

![Image of QuickInsertionSort](https://user-images.githubusercontent.com/18203310/55672364-015c5600-584f-11e9-8416-b1f8380e6096.png)



Insertion Sort was applied to all partitions in the array together rather than individually. This was simply done by forcing quickInsertSort2 to stop running when partitioned sizes reached 10. I then called InsertionSort() after quickInsertSort2 finished running altogether. Initially, this seemed to improve the runtime with respect to QuickSort and quickInsertSort1(). As array sizes increased, the algorithm appears to level off and increase in a similar fashion to quickInsertSort1. This means its average-case is also the same at O(nlogn).


## Summary: ##

In conclusion, I was able to optimize Quick Sort to run faster by utilizing Insertion Sort’s better performance on partitioned arrays. This meant that “Almost sorted arrays” were computationally easier to sort rather than traditionally breaking down the partitions and sorting them. It appeared both quickInsertSorting algorithms are much better to use on larger arrays with quickInsertSort2 being slightly more performant altogether while quickInsertSort1 having a more stable curve.
