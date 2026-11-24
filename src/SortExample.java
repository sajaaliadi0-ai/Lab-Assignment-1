
import java.util.Arrays;

/**
 * This class demonstrates Quick Sort and Merge Sort algorithms.
 *
 * @author saja
 * @version 1.0
 */
public class SortExample {

    public static void main(String[] args) {

        // This is an unsorted array
        Integer[] array1 = {12, 13, 24, 10, 3, 6, 90, 70};
        int[] array2 = {2, 6, 3, 5, 1};

        // Sort using Quick Sort
        quickSort(array1, 0, array1.length - 1);

        // Print sorted array
        System.out.println(Arrays.toString(array1));

        // Sort using Merge Sort
        mergeSort(array2, array2.length);
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Sorts an array using Quick Sort algorithm.
     *
     * @param arr the array to be sorted
     * @param low the starting index
     * @param high the ending index
     */
    public static void quickSort(Integer[] arr, int low, int high) {

        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;

        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }

        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param array the array
     * @param x the first index
     * @param y the second index
     */
    public static void swap(Integer[] array, int x, int y) {

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an array using Merge Sort algorithm.
     *
     * @param a the array to be sorted
     * @param n the number of elements
     */
    public static void mergeSort(int[] a, int n) {

        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }

        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    /**
     * Merges two sorted arrays.
     *
     * @param a the destination array
     * @param l the left array
     * @param r the right array
     * @param left the size of the left array
     * @param right the size of the right array
     */
    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {

            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Checks whether an array is sorted.
     *
     * @param x the array to check
     * @return true if sorted, otherwise false
     */
    private static boolean isSorted(int[] x) {

        for (int i = 0; i < x.length - 1; i++) {

            if (x[i] > x[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
