import java.util.*;
class Kruskal{
    static class Edge {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    public static int find(int[] parent, int u) {
        if (parent[u] != u) {
            parent[u] = find(parent, parent[u]);
        }
        return parent[u];
    }
    public static List<Edge> kruskal(int n, List<Edge> edges) {
        int[] parent = new int[n];
        List<Edge> mst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        edges.sort(Comparator.comparingInt(e -> e.weight));
        int count=0;
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            if (rootU != rootV) {
                mst.add(edge);
                parent[rootU] = rootV;
                count++;
            }
            if (count>n-1)break;
        }
        return mst;
    }
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int n = sc.nextInt();
        System.out.println("Enter number of edges: ");
        int e=sc.nextInt();
        int S,D,W;
        for(int i=0;i<e;i++){
            System.out.println("Enter Edge "+(i+1)+": ");
            S=sc.nextInt();
            D=sc.nextInt();
            W= sc.nextInt();
            edges.add(new Edge(S,D,W));
        }
        List<Edge> mst = kruskal(n, edges);
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println("(" + edge.u + ", " + edge.v + ") -> " + edge.weight);
        }
    }
}
// Time Complexity:
// Best Case: O(E log E)
// Average Case: O(E log E)
// Worst Case: O(E log E)
