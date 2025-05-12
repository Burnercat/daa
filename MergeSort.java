import java.util.*;
public class MergeSort{
    public static void MergeSort(int[] arr,int low,int high){
        if(low!=high){
            int mid=(low+high)/2;
            MergeSort(arr,low,mid);
            MergeSort(arr,mid+1,high);
            Merge(arr,low,mid,high);
        }
    }
    public static void Merge(int[] arr,int low,int mid,int high){
        int[] b=new int[high+1];
        int k=low,i=low,j=mid+1;
        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                b[k++]=arr[i++];
            }else{
                b[k++]=arr[j++];
            }
        }
        while(i<=mid){
            b[k++]=arr[i++];
        }
        while(j<=high){
            b[k++]=arr[j++];
        }
        if(high+1-low>=0)System.arraycopy(b,low,arr,low,high+1-low);
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
        MergeSort(arr,0,n-1);
        System.out.println("Array after sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}