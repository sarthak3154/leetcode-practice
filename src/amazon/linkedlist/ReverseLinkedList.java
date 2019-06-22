package amazon.linkedlist;

public class ReverseLinkedList {
    /**
     * Iterative Solution
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode nextNode = head;
        ListNode secondNode;
        while (nextNode != null) {
            secondNode = nextNode.next;
            nextNode.next = temp;
            temp = nextNode;
            nextNode = secondNode;
        }

        return temp;
    }

    /**
     * Recursive - Incorrect Solution
     * @param head
     * @return
     */
    public ListNode recursiveReverseList(ListNode head) {
        if (head == null) return null;
        ListNode current = head.next;
        current = recursiveReverseList(current);
        if (current != null) {
            current.next = head;
            return current;
        }

        return head;
    }

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
