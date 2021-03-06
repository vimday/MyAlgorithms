package myalgo;

public class ShellSort {
    private ShellSort(){}
    public static void  sort(Comparable[] arr){
        int n=arr.length;
        int h=1;
        while(h<n/3) h=3*h+1;
        while (h>=1){
            for(int i=h;i<n;i++){
                Comparable e=arr[i];
                int j=i;
                for(;j>=h&&e.compareTo(arr[j-h])<0;j-=h){
                    arr[j]=arr[j-h];
                }
                arr[j]=e;
            }
            h/=3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr=SortTestHelper.generateRandomArray(1000000,0,100000);
        SortTestHelper.testSort("myalgo.ShellSort",arr);

    }
}
