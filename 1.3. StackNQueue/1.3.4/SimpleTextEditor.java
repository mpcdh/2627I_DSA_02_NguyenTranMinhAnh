import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    private StringBuilder s = new StringBuilder();
    private Stack<String> strStack = new Stack<>();
    private Stack<Integer> opsStack = new Stack<>();

    public void append(String str) {
        s.append(str);
        strStack.push(str);
        opsStack.push(1);
    }

    public void delete(int k) {
        strStack.push(s.substring(s.length() - k));
        opsStack.push(2);
        s.delete(s.length() - k, s.length());
    }

    public void print(int k) {
        System.out.println(s.charAt(k-1));
    }

    public void undo() {
        Integer n = opsStack.pop();
        String str = strStack.pop();
        if (n.equals(1)) {
            s.delete(s.length() - str.length(), s.length());
        } else if (n.equals(2)) {
            s.append(str);
        }
    }

    public static void main(String[] args) {
        SimpleTextEditor editor = new SimpleTextEditor();
        Scanner scn = new Scanner(System.in);

        int t = Integer.parseInt(scn.nextLine().trim());

        for (int i = 0; i < t; i++) {
            String s = scn.nextLine();
            Integer n = Integer.parseInt(String.valueOf(s.charAt(0)));
            if (n.equals(1)) {
                String str = s.substring(2);
                editor.append(str);
            } else if (n.equals(2)) {
                int k = Integer.parseInt(s.substring(2));
                editor.delete(k);
            } else if (n.equals(3)) {
                int k = Integer.parseInt(s.substring(2));
                editor.print(k);
            } else {
                editor.undo();
            }
        }
    }
}
