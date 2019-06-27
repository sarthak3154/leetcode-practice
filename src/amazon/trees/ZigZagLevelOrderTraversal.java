package amazon.trees;

import java.util.*;

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        boolean alt = false;
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.remove(size - 1 - i);
                list.add(node.val);
                if (node.left != null && !alt) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
                if (node.left != null && alt) stack.push(node.left);
            }
            lists.add(list);
            alt = !alt;
        }

        return lists;
    }

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
