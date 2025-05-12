import java.util.*;
public class TopologicalSort {
    static void topologicalSortUtil(int task, boolean[] visited, Stack<Integer> stack, int[][] matrix, int numTasks) {
        visited[task] = true;
        for (int i = 0; i < numTasks; i++) {
            if (matrix[task][i] == 1 && !visited[i]) {
                topologicalSortUtil(i, visited, stack, matrix, numTasks);
            }
        }
        stack.push(task);
    }
    static void scheduleTasks(int numTasks, int[][] matrix) {
        boolean[] visited = new boolean[numTasks];
        Stack<Integer> stack = new Stack<>();
        for (int task = 0; task < numTasks; task++) {
            if (!visited[task]) {
                topologicalSortUtil(task, visited, stack, matrix, numTasks);
            }
        }
        System.out.println("Task execution order (Topological Sort):");
        while (!stack.isEmpty()) {
            System.out.print("Task " + stack.pop() + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tasks: ");
        int numTasks = sc.nextInt();
        int[][] matrix = new int[numTasks][numTasks];
        System.out.print("Enter number of dependencies: ");
        int numDependencies = sc.nextInt();
        System.out.println("Enter dependencies (u v):");
        for (int i = 0; i < numDependencies; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            matrix[u][v] = 1;
        }
        scheduleTasks(numTasks, matrix);
        sc.close();
    }
}
// Time Complexity:
// Best Case: O(V + E)
// Average Case: O(V + E)
// Worst Case: O(V + E)
