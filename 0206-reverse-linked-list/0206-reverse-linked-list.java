class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode  forward = null;
        ListNode  curr =  head;
        while(curr!=null){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
}