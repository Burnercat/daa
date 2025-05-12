import java.util.*;
public class GaleShapley{
    static int n;
    static boolean prefersOverCurrent(int[][] Women,int w,int m,int cur_m){
        for(int i=0;i<n;i++){
            if(Women[w][i]==m)return true;
            if(Women[w][i]==cur_m)return false;
        }
        return false;
    }
    static void stableMarriage(int[][] Men,int[][] Women){
        int[] wc=new int[n];
        boolean[] mmark=new boolean[n];
        Arrays.fill(wc,-1);
        int freeMen=n;
        while(freeMen>0){
            int m;
            for(m=0;m<n;m++){
                if(!mmark[m])break;
            }
            for(int i=0;i<n && !mmark[m];i++){
                int w=Men[m][i];
                if(wc[w]==-1){
                    wc[w]=m;
                    mmark[m]=true;
                    freeMen--;
                }else{
                    int cur_m=wc[w];
                    if(prefersOverCurrent(Women,w,m,cur_m)){
                        wc[w]=m;
                        mmark[m]=true;
                        mmark[cur_m]=false;
                    }
                }
            }
        }
        System.out.println("Stable Pairs: ");
        for(int i=0;i<n;i++){
            System.out.println("Man "+wc[i]+"is matched with Woman "+i);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Men or Women: ");
        n=sc.nextInt();
        int[][] Men=new int[n][n];
        int[][] Women=new int[n][n];
        System.out.println("Enter Men's Preference List: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Men[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter Women's Preference List: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Women[i][j]=sc.nextInt();
            }
        }
        stableMarriage(Men,Women);
    }
}
