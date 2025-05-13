import java.util.*;

public class MergeSort{
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        for (i = low, k = 0; i <= high; i++, k++)
            arr[i] = temp[k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        Random rand = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt(1000);

        System.out.println("Unsorted Array:");
        System.out.println(Arrays.toString(arr));

        long start = System.nanoTime();
        mergeSort(arr, 0, n - 1);
        long end = System.nanoTime();

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Execution Time: " + (end - start) / 1_000_000.0 + " ms");

        sc.close();
    }
}