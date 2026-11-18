import java.util.*;
import java.util.stream.Collectors;

public class FindTheRunningMedian {
    static class Node implements Comparable<Node> {
        int value;
        int id;

        public Node(int value, int id) {
            this.value = value;
            this.id = id;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value != o.value) {
                return Integer.compare(this.value, o.value);
            }
            return Integer.compare(this.id, o.id);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> res = new ArrayList<>();
        TreeSet<Node> set = new TreeSet<>();
        Node mid = null;

        for (int i = 0; i < a.size(); i++) {
            Node curr = new Node(a.get(i), i);
            set.add(curr);

            if (i == 0) {
                mid = curr;
            } else if (set.size() % 2 == 1) {
                if (curr.compareTo(mid) > 0) {
                    mid = set.higher(mid);
                }
            } else {
                if (curr.compareTo(mid) < 0) {
                    mid = set.lower(mid);
                }
            }

            if (set.size() % 2 == 1) {
                res.add((double) mid.value);
            } else {
                Node nextMid = set.higher(mid);
                res.add((double) (mid.value + nextMid.value) / 2);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Integer> a = Arrays.stream(line.replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Double> res = runningMedian(a);
        System.out.println(res);
    }
}
