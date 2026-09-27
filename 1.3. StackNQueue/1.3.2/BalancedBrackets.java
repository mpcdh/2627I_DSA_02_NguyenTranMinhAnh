import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<String> ops = new Stack<>();
        if (s == null || s.isBlank()) return "NO";
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (c.equals("(") || c.equals("{") || c.equals("[")) {
                ops.push(c);
            } else if (c.equals(")")) {
                if (ops.isEmpty() || !ops.peek().equals("(")) return "NO";
                ops.pop();
            } else if (c.equals("}")) {
                if (ops.isEmpty() || !ops.peek().equals("{")) return "NO";
                ops.pop();
            } else if (c.equals("]")) {
                if (ops.isEmpty() || !ops.peek().equals("[")) return "NO";
                ops.pop();
            }
        }
        if (ops.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static String isBalanced2(String s) {
        Stack<String> ops = new Stack<>();
        if (s == null || s.isBlank()) return "NO";
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (c.equals("(") || c.equals("{") || c.equals("[")) {
                ops.push(c);
            } else if (c.equals(")") || c.equals("}") || c.equals("]")) {
                if (ops.isEmpty()) return "NO";
                String top = ops.pop();
                if (c.equals(")") && !top.equals("(") || c.equals("}") && !top.equals("{") || c.equals("]") && !top.equals("[")) {
                    return "NO";
                }
            }
        }
        return ops.isEmpty() ? "YES" : "NO";
    }
}
