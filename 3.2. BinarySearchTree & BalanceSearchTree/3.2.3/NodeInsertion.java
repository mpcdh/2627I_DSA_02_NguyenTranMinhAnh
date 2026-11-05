public class NodeInsertion {
    public static Node insert1(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key == root.data) {
            return root;
        }

        if (key < root.data) {
            root.left = insert1(root.left, key);
        } else {
            root.right = insert1(root.right, key);
        }

        return root;
    }

    public static Node insert2(Node root, int key) {
        Node temp = new Node(key);

        if (root == null) {
            return temp;
        }

        Node curr = root;
        while (curr != null) {
            if (curr.data == key) {
                return root;
            } else if (curr.data > key && curr.left != null) {
                curr = curr.left;
            } else if (curr.data < key && curr.right != null) {
                curr = curr.right;
            } else {
                break;
            }
        }

        if (curr.data > key) {
            curr.left = temp;
        } else {
            curr.right = temp;
        }

        return root;
    }
}
