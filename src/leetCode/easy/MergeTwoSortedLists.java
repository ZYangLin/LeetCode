package leetCode.easy;

import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        List lsit1 = Arrays.asList(1, 2, 4);
        List lsit2 = Arrays.asList(1, 3, 4);


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode list3;
        if (list1.val < list2.val) {
            list3 = list1;
            list3.next = mergeTwoLists(list1.next, list2);
        } else {
            list3 = list2;
            list3.next = mergeTwoLists(list1, list2.next);
        }


        return list3;
    }


}
