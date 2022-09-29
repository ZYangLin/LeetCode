package leetCode.easy;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode list = head;

        do {
            if (list.next.val != list.val)
                list = list.next;
            else
                list.next = list.next.next;
        } while (list.next != null);

        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList rdfs = new RemoveDuplicatesFromSortedList();
        ListNode ln2 = new ListNode(2);
        ListNode ln1 = new ListNode(1, ln2);
        ListNode ln = new ListNode(1, ln1);
        System.out.println(rdfs.deleteDuplicates(ln));

    }
}
