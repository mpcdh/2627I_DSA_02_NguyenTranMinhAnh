import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class CorrectnessInvariant {
    public static void insertionSort(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int tmp = arr.get(i);
            while (j >= 0) {
                if (arr.get(j) > tmp) {
                    arr.set(j + 1, arr.get(j));
                    j--;
                } else {
                    break;
                }
            }
            arr.set(j + 1, tmp);
            System.out.println(arr.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        CorrectnessInvariant.insertionSort(n, arr);

        bufferedReader.close();
    }
}
