/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        ListNode curr = head;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                if (curr != null) {
                    ans[top][j] = curr.val;
                    curr = curr.next;
                } else {
                    ans[top][j] = -1;
                }
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                if (curr != null) {
                    ans[i][right] = curr.val;
                    curr = curr.next;
                } else {
                    ans[i][right] = -1;
                }
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    if (curr != null) {
                        ans[bottom][j] = curr.val;
                        curr = curr.next;
                    } else {
                        ans[bottom][j] = -1;
                    }
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if (curr != null) {
                        ans[i][left] = curr.val;
                        curr = curr.next;
                    } else {
                        ans[i][left] = -1;
                    }
                }
                left++;
            }
        }
        return ans;
    }
}