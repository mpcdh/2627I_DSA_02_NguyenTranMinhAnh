import java.util.List;
import java.util.Stack;

public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        Integer s1TotalHeight = 0;
        Integer s2TotalHeight = 0;
        Integer s3TotalHeight = 0;
        for (int i = h1.size() - 1; i >=0; i--) {
            s1TotalHeight += h1.get(i);
            s1.push(s1TotalHeight);
        }
        for (int i = h2.size() - 1; i >=0; i--) {
            s2TotalHeight += h2.get(i);
            s2.push(s2TotalHeight);
        }
        for (int i = h3.size() - 1; i >=0; i--) {
            s3TotalHeight += h3.get(i);
            s3.push(s3TotalHeight);
        }

        int maxHeight = 0;
        while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
            int s1Height = s1.peek();
            int s2Height = s2.peek();
            int s3Height = s3.peek();
            if (s1Height == s2Height && s2Height == s3Height) {
                maxHeight = s1Height;
                break;
            }

            if (s1Height >= s2Height && s1Height >= s3Height) {
                s1.pop();
            } else if (s2Height >= s1Height && s2Height >= s3Height) {
                s2.pop();
            } else if (s3Height >= s1Height && s3Height >= s2Height) {
                s3.pop();
            }
        }

        return maxHeight;
    }
}
