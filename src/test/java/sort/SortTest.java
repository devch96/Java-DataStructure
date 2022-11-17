package sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SortTest extends BaseSortTest {

    private BubbleSort bubbleSort = new BubbleSort();
    private InsertionSort insertionSort = new InsertionSort();
    private QuickSort quickSort = new QuickSort();
    private MergeSort mergeSort = new MergeSort();

    @Test
    void bubbleSort() {
        for (int i = 1; i < 100; i++) {
            int[] arr = createRandomArray(i);
            int[] expected = Arrays.copyOf(arr, arr.length);
            Arrays.sort(expected);
            bubbleSort.sort(arr);
            assertArrayEquals(expected, arr);
        }
    }

    @Test
    void insertionSort() {
        for (int i = 1; i < 100; i++) {
            int[] arr = createRandomArray(i);
            int[] expected = Arrays.copyOf(arr, arr.length);
            Arrays.sort(expected);
            insertionSort.sort(arr);
            assertArrayEquals(expected, arr);
        }
    }

    @Test
    void quickSort() {
        for (int i = 1; i < 100; i++) {
            int[] arr = createRandomArray(i);
            int[] expected = Arrays.copyOf(arr, arr.length);
            Arrays.sort(expected);
            quickSort.sort(arr);
            assertArrayEquals(expected, arr);
        }
    }

    @Test
    void mergeSort() {
        for (int i = 1; i < 100; i++) {
            int[] arr = createRandomArray(i);
            int[] expected = Arrays.copyOf(arr, arr.length);
            Arrays.sort(expected);
            mergeSort.sort(arr);
            assertArrayEquals(expected, arr);
        }
    }
}
