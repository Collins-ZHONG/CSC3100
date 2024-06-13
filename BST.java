package CSC3100;

import java.util.*;

public class BST {
    public TreeNode find(TreeNode x, int key) {
        // O(h) time complexity, h is the height

        if (x == null || key == x.data) {
            return x;
        }
        if (key < x.data) {
            return find(x.left, key);
        } else {
            return find(x.right, key);
        }
    }

    public TreeNode findMin(TreeNode root) {
        // O(h) time complexity
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public TreeNode findMax(TreeNode root) {
        // O(h) time complexity
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode successor(TreeNode root) {  // mimimum value larger than key in root
        // O(h) time complexity

        if (root.right != null) {
            return findMin(root.right);     // first reach the bottom
        }
        TreeNode y = root.parent;
        while (y != null && root == y.right) {  // start searching from bottom
            root = y;
            y = y.parent;
        }
        return y;
    }
    public TreeNode predecessor(TreeNode root) {    // maximum value smaller than key in root
        if (root.left != null) {
            return findMax(root.left);
        }
        TreeNode p = root.parent;
        while(p != null && root == p.left) {
            root = p;
            p = p.parent;
        }
        return p;
    }

    public void insert(TreeNode root, TreeNode z) {
        TreeNode y = null, x = root;
        while (x != null) {
            y = x;
            if (z.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        // arrive the place we want
        z.parent = y;
        if (y == null) {
            root = z;   // T was empty
        } else {
            if (z.data < y.data) {
                z = y.left;
            } else {
                z = y.right;
            }
        }
    }

    public void delete(TreeNode z) {
        // z is the node 
    }

    public static void main(String[] args) {
        
    }
}

// class TreeNode<T> {
//     public T data;

//     public TreeNode<T> parent;
//     public TreeNode<T> left = null;
//     public TreeNode<T> right = null;
//     public TreeNode(T x, TreeNode<T> p) {
//         parent = p;
//         data = x;
//     }
// }
class TreeNode {
    public int data;

    public TreeNode parent;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int x, TreeNode p) {
        parent = p;
        data = x;
    }
}