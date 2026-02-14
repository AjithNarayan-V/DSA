
class BinarySearchTree {

    // Node class
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    // ================= INSERT =================
    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // ================= SEARCH =================
    public boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (key == root.data)
            return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // ================= DELETE =================
    public Node delete(Node root, int key) {
        if (root == null)
            return null;

        // Find the node
        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null)
                return root.right;
  
            if (root.right == null)
                return root.left;

            // Case 3: Two children
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    // Find minimum value node
    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // ================= INORDER =================
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.root = bst.insert(bst.root, 50);
        bst.root = bst.insert(bst.root, 30);
        bst.root = bst.insert(bst.root, 70);
        bst.root = bst.insert(bst.root, 20);
        bst.root = bst.insert(bst.root, 40);
        bst.root = bst.insert(bst.root, 60);
        bst.root = bst.insert(bst.root, 80);

        System.out.print("Inorder Traversal: ");
        bst.inorder(bst.root);

        System.out.println("\nSearch 40: " + bst.search(bst.root, 40));

        bst.root = bst.delete(bst.root, 50);

        System.out.print("After Deleting 50: ");
        bst.inorder(bst.root);
    }
}
