import java.util.*;
import java.util.stream.Collectors;

public class MissingNumbers {
    public static List<Integer> missingNumbers1(List<Integer> arr, List<Integer> brr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        Set<Integer> res = new TreeSet<>();
        for (Integer num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Integer num : brr) {
            int count = frequencyMap.getOrDefault(num, 0);
            if (count > 0) {
                frequencyMap.put(num, count - 1);
            } else {
                res.add(num);
            }
        }
        return new ArrayList<>(res);
    }
    // Time complexity: O(N + M + KlogK), N: arr size, M: brr size, K: res size - sort
    // Space complexity: O(N + K) cho frequencyMap và res

    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        Collections.sort(arr);
        Collections.sort(brr);
        int i = 0, j = 0;
        int n = arr.size(), m = brr.size();
        Set<Integer> res = new HashSet<>();
        while (j < m) {
            if (i < n && arr.get(i).equals(brr.get(j))) {
                i++;
            } else {
                res.add(brr.get(j));
            }
            j++;
        }
        return new ArrayList<>(res);
    }
    // Time complexity: O(NlogN + MlogM), O(NlogN) và O(MlogM) cho sort, O(N) và O(M) cho two-pointer
    // Space complexity: O(K) cho res

    public static List<Integer> missingNumbers3(List<Integer> arr, List<Integer> brr) {
        List<Integer> res = new ArrayList<>();
        Integer minb = Collections.min(brr);
        int[] count = new int[101];
        for (int i = 0; i < brr.size(); i++) {
            count[brr.get(i) - minb] ++;
        }
        for (int i = 0; i < arr.size(); i++) {
            count[arr.get(i) - minb] --;
        }
        for (int i = 0; i < 100; i++) {
            if (count[i] > 0) {
                res.add(i + minb);
            }
        }
        return res;
    }
    // Time complexity: O(N + M), O(N + M) cho duyệt arr và brr, O(M) cho tìm min, O(101) = O(1) cho duyệt count
    // Space complexity: O(1) cho res cố định phần tử

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        List<Integer> arr = Arrays.stream(line1.replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String line2 = scanner.nextLine();
        List<Integer> brr = Arrays.stream(line2.replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> res = missingNumbers3(arr, brr);
        System.out.println(res);
    }
}
