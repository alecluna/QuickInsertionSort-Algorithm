/*
Alec Luna
0726
This file contains three QuickSorting algorithms.
The first is traditional Quick Sort, the second is quicksort with an
Insertion Sort implemented on partitions sizes <= 10 and 
the last applies Insertion Sort on all partitions in the array.
*/

class Hw4_A {

    public static int partition(int arr[], int low, int high) {
        // pivot is right most element
        int pivot = arr[high];
        // initialize i to be < smallest in partition
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                // increment i then make a swap
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {

            int pivot = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static void quickInsertSort1(int arr[], int low, int high) {
        while (low < high) {

            if (high - low <= 10) {
                insertionSortNonRecursive(arr, low, high);
                break; // stop running since small array will be sorted
            } else {

                int pivot = partition(arr, low, high);

                // tail recursion
                // we iterate low and high to get the partition size
                // down to 10 in order to trigger InsertionSort
                if (pivot - low < high - pivot) {
                    quickInsertSort1(arr, low, pivot - 1);
                    low = pivot + 1;
                } else {
                    quickInsertSort1(arr, pivot + 1, high);
                    high = pivot - 1;
                }
            }
        }
    }

    public static void quickInsertSort2(int arr[], int low, int high) {

        if (high - low >= 10) {

            int pivot = partition(arr, low, high);
            quickInsertSort2(arr, low, pivot - 1);
            quickInsertSort2(arr, pivot + 1, high);
        }
    }

    public static void insertionSortNonRecursive(int[] arr, int low, int n) {
        // Start from second element (element at index 0
        // is already sorted)
        for (int i = low + 1; i <= n; i++) {
            int value = arr[i];
            int j = i;

            // Find the index j within the sorted subset arr[0..i-1]
            // where element arr[i] belongs
            while (j > low && arr[j - 1] > value) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = value;
        }
    }

}
