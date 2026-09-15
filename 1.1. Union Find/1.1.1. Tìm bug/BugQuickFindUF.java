public class BugQuickFindUF {
    private int[] leader;

    public BugQuickFindUF(int N) {
        leader = new int[N];
        for (int i = 0; i < N; i++) {
            leader[i] = i;
        }
    }

    public int find(int i) {
        return leader[i];
    }

    public void union(int p, int q) {
        for (int i = 0; i < leader.length; i++) {
            if (leader[i] == leader[p]) {
                leader[i] = leader[q];
            }
        }
    }

    /* Test case chứng minh bug:
    n = 6
    i = 2, j = 4
    union(2, 0); union(4, 0); union(2, 3)
    find(i) = 3, find(j) = 0
    Bug:
    - First state: 0 1 2 3 4 5
    - Second state: 0 1 0 3 4 5
    - Third state: 0 1 0 3 0 5
    - Fourth state: 3 1 3 3 0 5
    -> Sau khi đổi leader[2] = leader[3] (từ 0 thành 3), phép so sánh leader[i] == leader[p] bị lỗi
    khi so sánh đến leader[4] (3 khác 0)
    -> Cần biến cố định giữ leader[p]
     */
    public static void main(String[] args) {
        BugQuickFindUF test = new BugQuickFindUF(6);
        test.union(2, 0);
        test.union(4, 0);
        test.union(2, 3);
        System.out.println(test.find(2));
        System.out.println(test.find(4));
    }
}
