import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    private static Stack<Integer> s1 = new Stack<>();
    private static Stack<Integer> s2 = new Stack<>();

    public static void enqueue(Integer n) {
        s1.push(n);
    }

    public static void dequeue() {
        head();
        s2.pop();
    }

    public static Integer head() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public static void reset() {
        s1.clear();
        s2.clear();
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        QueueUsingTwoStacks.reset();
        int t = Integer.parseInt(scn.nextLine().trim());

        for (int i = 0; i < t; i++) {
            String s = scn.nextLine();
            Integer n = Integer.parseInt(String.valueOf(s.charAt(0)));
            if (n.equals(1)) {
                Integer num = Integer.parseInt(s.substring(2));
                QueueUsingTwoStacks.enqueue(num);
            } else if (n.equals(2)) {
                QueueUsingTwoStacks.dequeue();
            } else {
                Integer head = QueueUsingTwoStacks.head();
                System.out.println(head);
            }
        }
    }
}
