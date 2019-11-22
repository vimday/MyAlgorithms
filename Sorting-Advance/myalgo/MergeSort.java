package myalgo;

import java.util.Arrays;

public class MergeSort {
    public static void sort(Comparable[] arr){
        int n=arr.length;
        sort(arr,0,n-1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if(r-l<=15){
            InsertionSort.sort(arr,l,r);
            return;
        }
        int mid=l+(r-l>>1);
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        if(arr[mid].compareTo(arr[mid+1])>0)
            merge(arr,l,mid,r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux= Arrays.copyOfRange(arr,l,r+1);

        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){
            if(i>mid)
                arr[k]=aux[j++-l];
            else if(j>r)
                arr[k]=aux[i++-l];
            else if(aux[i-l].compareTo(aux[j-l])>0)
                arr[k]=aux[j++-l];
            else
                arr[k]=aux[i++-l];
        }

    }

    public static void main(String[] args) {
        int N=1000000;
        Integer[] arr=SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("myalgo.MergeSort",arr);
    }
}
