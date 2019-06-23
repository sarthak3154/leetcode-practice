package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    /**
     * Solution - Iteratively
     * Root -> Left -> Right
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode current = root;
        List<Integer> preOrderList = new ArrayList<>();
        if (current == null) {
            return preOrderList;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();
            preOrderList.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return preOrderList;
    }

    public static void main(String[] args) {
        // TODO call the preOrderTraversal method
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
