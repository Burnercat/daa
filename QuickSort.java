import java.util.*;
public class QuickSort{
    public static void quicksort(int[] A,int l,int r){
        if(l<r){
            int s=partition(A,l,r);
            quicksort(A,l,s-1);
            quicksort(A,s+1,r);
        }
    }
    public static int partition(int[] A,int l,int r){
        int pivot=A[l];
        int i=l;
        int j=r+1;
        while(true){
            do{
                i++;
            }while(i<=r && A[i]<pivot);
            do{
                j--;
            }while(A[j]>pivot);
            if(i>=j)break;
            int temp=A[i];
            A[i]=A[j];
            A[j]=temp;
        }
        int temp=A[l];
        A[l]=A[j];
        A[j]=temp;
        return j;
    }
    public static void main(String[] args){
        int n;
        System.out.println("Enter number of elements: ");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        quicksort(arr,0,n-1);
        System.out.println("Array after sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
