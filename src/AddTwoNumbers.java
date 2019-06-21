import java.math.BigInteger;

public class AddTwoNumbers {

    private ListNode createLinkedList(BigInteger num) {
        ListNode rootNode = new ListNode(num.mod(BigInteger.valueOf(10)).intValue());
        rootNode.next = null;
        ListNode prevNode = rootNode;
        while (!(num = num.divide(BigInteger.valueOf(10))).equals(BigInteger.ZERO)) {
            ListNode listNode = new ListNode(num.mod(BigInteger.valueOf(10)).intValue());
            listNode.next = null;
            prevNode.next = listNode;
            prevNode = listNode;
        }

        return rootNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = BigInteger.ZERO, num2 = BigInteger.ZERO;
        int i = 0;
        while (l1 != null) {
            num1 = num1.add(BigInteger.valueOf((long) 10).pow(i++).multiply(BigInteger.valueOf((long) l1.val)));
            l1 = l1.next;
        }

        i = 0;
        while (l2 != null) {
            num2 = num2.add(BigInteger.valueOf((long) 10).pow(i++).multiply(BigInteger.valueOf((long) l2.val)));
            l2 = l2.next;
        }

        return createLinkedList(num1.add(num2));
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