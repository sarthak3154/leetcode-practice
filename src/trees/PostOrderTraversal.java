package trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode current = root;

        List<Integer> postOrderList = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        if (current == null) {
            return postOrderList;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.peek();
            if (!visited.contains(current)) {
                visited.add(current);
                if (current.left == null && current.right == null) {
                    postOrderList.add(current.val);
                    stack.pop();
                } else {
                    if (current.right != null) {
                        stack.push(current.right);
                    }

                    if (current.left != null) {
                        stack.push(current.left);
                    }
                }
            } else {
                postOrderList.add(current.val);
                stack.pop();
            }
        }

        return postOrderList;
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
