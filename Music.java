import java.util.*;
class Music{
    public static int countingInversions(int[] playlist1,int[] playlist2){
        int n=playlist1.length;
        int[] pos=new int[n+1];
        
        for(int i=0;i<n;i++){
            pos[playlist2[i]]=i;
        }
        int[] mapped=new int[n];
        for(int i=0;i<n;i++){
            mapped[i]=pos[playlist1[i]];
        }
        return mergesort(mapped,0,n-1);
    }
    public static int mergesort(int a[],int low,int high){
        if(low>=high){
            return 0;
        }
        int mid=(low+high)/2;
        int count=0;
        count+=mergesort(a,low,mid);
        count+=mergesort(a,mid+1,high);
        count+=merge(a,low,mid,high);
        return count;
    }
    public static int merge(int a[],int low,int mid,int high){
        int count=0;
        int h=low;
        int i=low;
        int j=mid+1;
        int[] b=new int[high+1];
        while(i<=mid && j<=high){
            if(a[i]<=a[j]){
                b[h]=a[i];
                i++;
                h++;
            }else{
                b[h]=a[j];
                j++;
                h++;
                count+=(mid-i+1);
            }
        }
        if(i>mid){
            for(int k=j;k<=high;k++){
                b[h]=a[k];
                h++;
            }
        }else if(j>high){
            for(int k=i;k<=mid;k++){
                b[h]=a[k];
                h++;
            }
        }
        for(int k=low;k<=high;k++){
            a[k]=b[k];
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Music m=new Music();
        
        System.out.println("Enter the playlist size: ");
        int n=sc.nextInt();
        int[] user1=new int[n];
        int[] user2=new int[n];
        int[] user3=new int[n];
        System.out.println("Enter the playlist1: ");
        for(int i=0;i<n;i++){
            user1[i]=sc.nextInt();
        }
        System.out.println("Enter the playlist2: ");
        for(int i=0;i<n;i++){
            user2[i]=sc.nextInt();
        }
        System.out.println("Enter the playlist3: ");
        for(int i=0;i<n;i++){
            user3[i]=sc.nextInt();
        }
        int[][] playlist={user1,user2,user3};
        for(int i=0;i<3;i++){
            int minInversions=Integer.MAX_VALUE;
            int recommendedUser=-1;
            for(int j=0;j<3;j++){
                if(i!=j){
                    int inv=m.countingInversions(playlist[i],playlist[j]);
                    if(inv<minInversions){
                        minInversions=inv;
                        recommendedUser=j;
                    }
                }
            }
            System.out.println("user"+(i+1)+" should be recommended to user"+(recommendedUser+1)+" playlist"+" Inversions: "+minInversions);
        }
    }
}