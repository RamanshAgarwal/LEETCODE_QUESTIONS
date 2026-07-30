class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        // Reach left position
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode connection = prev;
        ListNode tail = curr;
        // Reverse right-left+1 nodes
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (connection != null)
            connection.next = prev;
        else
            head = prev;
        tail.next = curr;
        return head;
    }
}