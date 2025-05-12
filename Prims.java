import java.util.*;
class PGraph{
    public static void Prim(int G[][],int v){
        int INF=9999999;
        int no_edge;
        boolean[] selected=new boolean[v];
        Arrays.fill(selected,false);
        no_edge=0;
        selected[0]=true;
        System.out.println("Edge:Weight");
        while(no_edge<v-1){
            int min=INF;
            int x=0;
            int y=0;
            for(int i=0;i<v;i++){
                if(selected[i]==true){
                    for(int j=0;j<v;j++){
                        if(!selected[j]&&G[i][j]!=0){
                            if(min>G[i][j]){
                                min=G[i][j];
                                x=i;
                                y=j;
                            }
                        }
                    }
                }
            }
            System.out.println(x+"-"+y+":"+G[x][y]);
            selected[y]=true;
            no_edge++;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int v;
        System.out.println("Enter number of vertices: ");
        v=sc.nextInt();
        int[][] G=new int[v][v];
        System.out.println("Enter matrix Elements: ");
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                G[i][j]=sc.nextInt();
            }
        }
        Prim(G,v);
    }
}