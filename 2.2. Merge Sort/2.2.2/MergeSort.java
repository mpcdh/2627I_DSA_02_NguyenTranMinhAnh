import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] M = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            M[j] = arr[m + j + 1];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }

        printArray(arr);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (r + l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        int[] arr = Arrays.stream(line.replaceAll("\\s+$", "").split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        MergeSort.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
