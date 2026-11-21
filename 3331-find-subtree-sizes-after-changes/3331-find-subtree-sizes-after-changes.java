
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] ans = new int[n];

        List<Integer>[] stack = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            stack[i] = new ArrayList<>();
        }

        // Iterative DFS: {node, parent, state}
        Stack<int[]> dfs = new Stack<>();
        dfs.push(new int[]{0, -1, 0});

        while (!dfs.isEmpty()) {

            int[] curr = dfs.pop();

            int node = curr[0];
            int par = curr[1];
            int state = curr[2];

            int idx = s.charAt(node) - 'a';

            if (state == 0) {

                ans[node] = 1;

                stack[idx].add(node);

                // Exit event
                dfs.push(new int[]{node, par, 1});

                for (int child : tree[node]) {
                    dfs.push(new int[]{child, node, 0});
                }

            } else {

                int newParent = par;

                if (stack[idx].size() > 1) {
                    newParent = stack[idx].get(
                        stack[idx].size() - 2
                    );
                }

                if (newParent != -1) {
                    ans[newParent] += ans[node];
                }

                stack[idx].remove(stack[idx].size() - 1);
            }
        }

        return ans;
    }
}
