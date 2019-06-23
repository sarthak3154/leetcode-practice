package trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    /**
     * Solution - Iteratively
     * Left -> Root -> Right
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode current = root;
        List<Integer> inorderList = new ArrayList<>();
        if (current == null) {
            return inorderList;
        }

        HashSet<TreeNode> visited = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();
            if (!visited.contains(current)) {
                if (current.left == null && current.right == null) {
                    inorderList.add(current.val);
                } else {
                    if (current.right != null) {
                        stack.push(current.right);
                    }
                    stack.push(current);
                    if (current.left != null) {
                        stack.push(current.left);
                    }
                }
                visited.add(current);
            } else {
                inorderList.add(current.val);
            }
        }

        return inorderList;
    }

    public static void main(String[] args) {
        // TODO call the inorderTraversal method
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
