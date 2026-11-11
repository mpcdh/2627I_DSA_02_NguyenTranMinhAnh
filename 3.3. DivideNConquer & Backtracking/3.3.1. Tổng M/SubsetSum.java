import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsetSum {
    public static List<List<Integer>> subsetSum(int[] nums, int M) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(subset, 0, 0, nums, M, res);
        return res;
    }

    public static void backtracking(List<Integer> subset, int total, int start, int[] nums, int M, List<List<Integer>> res) {
        if (total == M) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (total > M || start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtracking(subset, total + nums[i], i + 1, nums, M, res);
            subset.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] nums = Arrays.stream(line.replaceAll("\\s+$", "").split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int M = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> res = subsetSum(nums, M);
        System.out.println(res);
    }
}
