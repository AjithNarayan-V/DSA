
import java.util.LinkedList;
import java.util.Queue;

public class FullBinaryTree {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    // Insert method (level order insertion)
    public void insert(int data) {

        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            // Insert at first available position
            if (temp.left == null) {
                temp.left = newNode;
                return;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                return;
            } else {
                queue.add(temp.right);
            }
        }
    }

      // Delete last element
    public void deleteLast() {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            root = null;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node lastNode = null, parentOfLast = null;

        // Find the last node and its parent
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                parentOfLast = temp;
                lastNode = temp.left;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                parentOfLast = temp;
                lastNode = temp.right;
                queue.add(temp.right);
            }
        }

        // Remove the last node
        if (parentOfLast.right == lastNode) {
            parentOfLast.right = null;
        } else {
            parentOfLast.left = null;
        }
    }

    // Delete a specific element by value
    public void delete(int target) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.data == target)
                root = null;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node targetNode = null, lastNode = null, parentOfLast = null;

        // Find target node and last node in level order
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.data == target)
                targetNode = temp;


            if (temp.left != null) {
                parentOfLast = temp;
                lastNode = temp.left;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                parentOfLast = temp;
                lastNode = temp.right;
                queue.add(temp.right);
            }
        }

        if (targetNode == null) {
            System.out.println("Element " + target + " not found in tree");
            return;
        }

        // Replace target node's data with last node's data
        targetNode.data = lastNode.data;

        // Remove the last node
        if (parentOfLast.right == lastNode) {
            parentOfLast.right = null;
        } else {
            parentOfLast.left = null;
        }
    }


    // Inorder Traversal
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Preorder Traversal
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder Traversal
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // BFS Traversal (Level Order Traversal)
    public void bfs() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
        }
    }

   // Check if tree is Full Binary Tree
    public boolean isFullBinaryTree(Node node) {
        if (node == null)
            return true;

        // Leaf node
        if (node.left == null && node.right == null)
            return true;

        // If both children exist
        if (node.left != null && node.right != null)
            return isFullBinaryTree(node.left) &&
                   isFullBinaryTree(node.right);

        return false;
    }


    // Height of tree
    public int height(Node node) {
        if (node == null)
            return -1;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Size of tree (without recursion)
    public int size() {
        if (root == null)
            return 0;

        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            count++;

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
        }

        return count;
    }

    // Find maximum value in tree (without recursion)
    public int findMax() {
        if (root == null)
            throw new IllegalStateException("Tree is empty");

        int max = root.data;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.data > max)
                max = temp.data;

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
        }

        return max;
    }

    // Find minimum value in tree (without recursion)
    public int findMin() {
        if (root == null)
            throw new IllegalStateException("Tree is empty");

        int min = root.data;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.data < min)
                min = temp.data;

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
        }

        return min;
    }


    // Main method
    public static void main(String[] args) {
        FullBinaryTree tree = new FullBinaryTree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root);

        System.out.println("\nBFS Traversal (Level Order):");
        tree.bfs();

        System.out.println("\nHeight of Tree: " + tree.height(tree.root));

        System.out.println("Size of Tree: " + tree.size());

        System.out.println("Maximum value in Tree: " + tree.findMax());
        System.out.println("Minimum value in Tree: " + tree.findMin());

        if (tree.isFullBinaryTree(tree.root))
            System.out.println("Tree is a Full Binary Tree");
        else
            System.out.println("Tree is NOT a Full Binary Tree");

        // Testing deletion
        System.out.println("\n\nDeleting element 5:");
        tree.delete(5);
        System.out.print("Inorder after deletion: ");
        tree.inorder(tree.root);

        System.out.println("\n\nDeleting last element:");
        tree.deleteLast();
        System.out.print("Inorder after deletion: ");
        tree.inorder(tree.root);

        System.out.println("\n\nDeleting element 1:");
        tree.delete(1);
        System.out.print("Inorder after deletion: ");
        tree.inorder(tree.root);
    }
}
