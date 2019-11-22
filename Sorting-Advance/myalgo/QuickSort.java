package myalgo;

public class QuickSort {
    private  QuickSort(){};
    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        //对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }
        //int p=partition(arr,l,r); //186ms
        //int p=mypartitionA(arr,l,r);//274ms
        int p=mypartitionB(arr,l,r);//194ms
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    //勤于拓展 懒于交换
    private static  int mypartitionA(Comparable[] arr,int l,int r){
        int idx=(int)(Math.random()*(r-l+1))+l;
        swap(arr,idx,l);
        Comparable e=arr[l];
        while(l<r){
            while(l<r&&e.compareTo(arr[r])<=0) r--;
            arr[l]=arr[r];
            while(l<r&&e.compareTo(arr[l])>=0) l++;
            arr[r]=arr[l];
        }
        arr[l]=e;
        return l;
    }

    //勤于交换 懒于拓展 能应对重复元素较多的退化情况
    private static  int mypartitionB(Comparable[] arr,int l,int r){
        int idx=(int)(Math.random()*(r-l+1))+l;
        swap(arr,idx,l);
        Comparable e=arr[l];
        while(l<r){
            while (l < r ) if(e.compareTo(arr[r])<0) r--; else {arr[l++]=arr[r];break;}
            while (l < r) if(e.compareTo(arr[l])>0) l++; else {arr[r--]=arr[l];break;}
        }
        arr[l]=e;
        //System.out.println(l);
        return l;
    }

    private static int partition(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v=arr[l];

        int j=l;
        for(int i=l+1;i<=r;i++){
            if(arr[i].compareTo(v)<0)
            {
                j++;
            swap(arr,i,j);}
        }
        swap(arr,l,j);
        return j;
    }


    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("myalgo.QuickSort", arr);

    }
}
