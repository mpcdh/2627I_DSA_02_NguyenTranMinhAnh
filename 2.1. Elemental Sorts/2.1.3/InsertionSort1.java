import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InsertionSort1 {
    public static void insertionSort1(int n, List<Integer> arr) {
        int idx = n - 2;
        int tmp = arr.get(n - 1);
        while (idx >= 0) {
            if (arr.get(idx) > tmp) {
                arr.set(idx + 1, arr.get(idx));
                idx--;
                System.out.println(arr.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            } else {
                break;
            }
        }
        arr.set(idx + 1, tmp);
        System.out.println(arr.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        InsertionSort1.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
