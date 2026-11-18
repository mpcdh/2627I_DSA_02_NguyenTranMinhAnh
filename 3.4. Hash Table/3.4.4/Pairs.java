import java.util.*;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (set.contains(arr.get(i) - k)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        List<Integer> arr = Arrays.stream(line.replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .toList();
        int res = pairs(k, arr);
        System.out.println(res);
    }
}
