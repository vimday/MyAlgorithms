package myalgo;

public class SelectionSort {
    private SelectionSort(){}
    public static void sort(Comparable[] arr){
        int len=arr.length;
        for(int i=0;i<len;i++){
            int minidx=i;
            for(int j=i+1;j<len;j++)
                if(arr[j].compareTo(arr[minidx])<0)
                    minidx=j;
            swap(arr,i,minidx);
        }
    }

    private static void swap(Object[] arr, int i, int minidx) {
        Object tmp=arr[i];
        arr[i]=arr[minidx];
        arr[minidx]=tmp;
    }

    public static void main(String[] args) {
        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(arr);
        for (int value : arr) {
            System.out.print(value);
            System.out.print(' ');
        }
        System.out.println();
    }
}
