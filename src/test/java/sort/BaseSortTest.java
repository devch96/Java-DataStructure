package sort;

import java.util.Random;

abstract public class BaseSortTest {
    protected int[] createRandomArray(int size) {
        int[] ret = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            ret[i] = random.nextInt() % size;
        }
        return ret;
    }
}
