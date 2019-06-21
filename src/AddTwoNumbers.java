public class AddTwoNumbers {

    private ListNode createLinkedList(long num) {
        ListNode rootNode = new ListNode((int) (num % 10));
        rootNode.next = null;
        ListNode prevNode = rootNode;
        while ((num = num / 10) != 0) {
            ListNode listNode = new ListNode((int) (num % 10));
            listNode.next = null;
            prevNode.next = listNode;
            prevNode = listNode;
        }

        return rootNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0, num2 = 0, i = 0;
        while (l1 != null) {
            num1 += l1.val * (long) Math.pow(10, i++);
            l1 = l1.next;
        }

        i = 0;
        while (l2 != null) {
            num2 += l2.val * (long) Math.pow(10, i++);
            l2 = l2.next;
        }

        return createLinkedList(num1 + num2);
    }

    /**
     * Input an array of digits and convert it into ListNode to provide input for addTwoNumbers method
     */
    public static void main(String[] args) {

    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}