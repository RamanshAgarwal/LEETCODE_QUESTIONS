import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        // int ko String mein convert
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sorting
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Agar sabhi numbers 0 hain
        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String num : arr) {
            sb.append(num);
        }

        return sb.toString();
    }
}