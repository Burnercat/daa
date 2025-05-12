import java.util.*;

public class Dijkstra{

    static class Edge {
        int dest, distance;
        Edge(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }
    }

    static void findShortestPaths(List<List<Edge>> map, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            for (Edge edge : map.get(u)) {
                int v = edge.dest;
                int w = edge.distance;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println("Shortest distances from start location " + start + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To location " + i + " : " + dist[i] + " units");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of locations: ");
        int locations = sc.nextInt();
        System.out.print("Enter number of roads: ");
        int roads = sc.nextInt();

        List<List<Edge>> map = new ArrayList<>();
        for (int i = 0; i < locations; i++) {
            map.add(new ArrayList<>());
        }

        System.out.println("Enter road connections (from to distance):");
        for (int i = 0; i < roads; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int dist = sc.nextInt();
            map.get(from).add(new Edge(to, dist));
            // If roads are two-way, uncomment the line below
            // map.get(to).add(new Edge(from, dist));
        }

        System.out.print("Enter the start location of the truck: ");
        int start = sc.nextInt();

        findShortestPaths(map, start, locations);
    }
}
// Time Complexity:
// Best Case: O((V + E) log V)
// Average Case: O((V + E) log V)
// Worst Case: O((V + E) log V)

