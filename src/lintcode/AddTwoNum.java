package lintcode;

/**
 * Created by kangqizhou on 2017/9/9.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode result = l1;
        ListNode temp = result;
        boolean addOne = false;
        while (temp != null && l2 != null) {
            int value1 = l1.val;
            int value2 = l2.val;
            temp.val = value1 + value2 +(addOne?1:0);
            if (temp.val > 10){
                temp.val = temp.val - 10;
                addOne = true;
            }
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}