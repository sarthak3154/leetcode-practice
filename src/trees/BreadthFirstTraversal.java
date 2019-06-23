package trees;

import java.util.*;

/**
 * Level order traversal of Binary Tree
 */
public class BreadthFirstTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if (root == null) return finalList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        TreeNode current;
        List<Integer> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current == null) {
                finalList.add(levelList);
                if (!queue.isEmpty()) {
                    levelList = new ArrayList<>();
                    queue.add(null);
                }
            } else {
                levelList.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return finalList;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
