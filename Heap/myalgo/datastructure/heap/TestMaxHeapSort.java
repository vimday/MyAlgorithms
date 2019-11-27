package myalgo.datastructure.heap;

import myalgo.SortTestHelper;

import java.util.Arrays;

public class TestMaxHeapSort {

    // 比较 MaxHeapSort 和 MaxHeapOSort 的性能的不同
    // 以此来检验 MaxHeap 进行ShiftUp和ShiftDown优化前后效率的不同
    public static void main(String[] args) {

        int N = 1000000;

        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("myalgo.datastructure.heap.MaxHeapSort", arr1);
        SortTestHelper.testSort("myalgo.datastructure.heap.MaxHeapOSort", arr2);

    }
}