public class LowestCommonAncestor {
    public static Node findLCA1(Node root, Node n1, Node n2) {
        if (root == null) {
            return null;
        }

        if (root.data > n1.data && root.data > n2.data) {
            return findLCA1(root.left, n1, n2);
        }

        if (root.data < n1.data && root.data < n2.data) {
            return findLCA1(root.right, n1, n2);
        }

        return root;
    }

    public static Node findLCA2(Node root, Node n1, Node n2) {
        while (root != null) {
            if (root.data > n1.data && root.data > n2.data) {
                root = root.left;
            } else if (root.data < n1.data && root.data < n2.data) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
