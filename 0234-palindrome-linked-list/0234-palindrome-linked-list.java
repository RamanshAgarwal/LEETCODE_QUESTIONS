// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         if (head == null || head.next == null)
//          return true;
//         ListNode slow = head;
//         ListNode fast = head;
//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         ListNode prev = null;
//         ListNode curr = slow;
//         while (curr != null) {
//             ListNode next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
//         ListNode left = head;
//         ListNode right = prev;
//         while (right != null) {
//             if (left.val != right.val)
//                 return false;
//             left = left.next;
//             right = right.next;
//         }
//         return true;
//     }
// }
class Solution {
    public boolean isPalindrome(ListNode head) { 
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}