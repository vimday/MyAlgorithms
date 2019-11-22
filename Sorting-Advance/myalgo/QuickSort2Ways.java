package myalgo;

public class QuickSort2Ways {
    private QuickSort2Ways() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l + 15 > r) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int p = partitionB(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partitionB(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
            while (i <= r && arr[i].compareTo(v) < 0)
                i++;

            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            // 思考一下为什么?
            while (j >= l + 1 && arr[j].compareTo(v) > 0)
                j--;

            // 对于上面的两个边界的设定, 有的同学在课程的问答区有很好的回答:)
            // 大家可以参考: http://coding.imooc.com/learn/questiondetail/4920.html

            if (i > j)
                break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);

        return j;
    }

    private static int partitionA(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable e = arr[l];
        while (l < r) {
            while (l < r && e.compareTo(arr[r]) < 0) r--;
            while (l < r && e.compareTo(arr[l]) > 0) l++;
            if(l<r)
                swap(arr,l++,r--);
        }
        arr[l] = e;
        return l;
    }

    private static void swap(Object[] arr, int l, int r) {
        Object t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        //双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000000);

        SortTestHelper.testSort("myalgo.QuickSort2Ways", arr);
        //for(Integer i:arr)
          //  System.out.println(i);
    }
}
