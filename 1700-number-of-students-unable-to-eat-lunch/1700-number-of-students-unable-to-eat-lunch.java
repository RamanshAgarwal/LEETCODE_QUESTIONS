import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for (int student : students) {
            q.add(student);
        }
        int sandwich = 0;
        int count = 0;
        while (!q.isEmpty()) {
            if (q.peek() == sandwiches[sandwich]) {
                q.remove();
                sandwich++;
                count = 0;
            } else {
                q.add(q.remove());
                count++;
            }
            if (count == q.size()) {
                break;
            }
        }
        return q.size();
    }
}