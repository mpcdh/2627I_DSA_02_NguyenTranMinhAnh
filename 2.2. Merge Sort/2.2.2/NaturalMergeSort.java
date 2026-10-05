import java.util.Arrays;
import java.util.Scanner;

public class NaturalMergeSort {

    public static void naturalMergeSort(int[] arr) {
        int n = arr.length;
        int[] aux = new int[n];

        while (true) {
            int i = 0, j, k;
            int passes = 0;

            while (i < n) {
                j = i;
                while (j < n - 1 && arr[j] < arr[j + 1]) {
                    j++;
                }
                if (j == n - 1) {
                    if (i == 0) return;
                    break;
                }

                k = j + 1;
                while (k < n - 1 && arr[k] < arr[k + 1]) {
                    k++;
                }

                merge(arr, aux, i, j, k);
                passes++;

                i = k + 1;
            }

            if (passes == 0) break;
        }
    }

    public static void merge(int[] arr, int[] aux, int low, int mid, int high) {
        if (high <= low) {
            return;
        }

        for (int k = low; k <= high; k++) {
            aux[k] = arr[k];
        }

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > high) {
                arr[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                arr[k] = aux[j++];
            } else { // aux[i] <= aux[j]
                arr[k] = aux[i++];
            }
        }
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        int[] arr = Arrays.stream(line.replaceAll("\\s+$", "").split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        NaturalMergeSort.naturalMergeSort(arr);

        System.out.println("Sorted array:");
        NaturalMergeSort.printArray(arr);
    }
}
