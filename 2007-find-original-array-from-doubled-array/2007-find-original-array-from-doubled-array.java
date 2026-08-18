import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {

        if (changed.length % 2 != 0) {
            return new int[0];
        }

        Arrays.sort(changed);

        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : changed) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[changed.length / 2];
        int idx = 0;

        for (int num : changed) {

            if (mp.getOrDefault(num, 0) == 0) {
                continue;
            }

            // Special case: 0
            if (num == 0) {

                if (mp.get(0) < 2) {
                    return new int[0];
                }

                mp.put(0, mp.get(0) - 2);

                result[idx++] = 0;

                continue;
            }

            int twice = 2 * num;

            if (!mp.containsKey(twice) || mp.get(twice) == 0) {
                return new int[0];
            }

            result[idx++] = num;

            mp.put(num, mp.get(num) - 1);
            mp.put(twice, mp.get(twice) - 1);
        }

        // Important final validation
        if (idx != changed.length / 2) {
            return new int[0];
        }

        return result;
    }
}