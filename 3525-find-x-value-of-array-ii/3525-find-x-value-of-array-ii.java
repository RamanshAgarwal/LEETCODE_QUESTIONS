class Solution {

    class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            cnt = new int[k];
            prod = 1 % k;
        }
    }

    int n, k;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        build(nums, 1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update nums[index]
            update(1, 0, n - 1, index, value);

            // Query from start to n - 1
            Node res = query(1, 0, n - 1, start, n - 1);

            ans[i] = res.cnt[x];
        }

        return ans;
    }

    // Build Segment Tree
    void build(int[] nums, int node, int l, int r) {

        if (l == r) {

            tree[node] = new Node(k);

            int val = nums[l] % k;

            tree[node].prod = val;
            tree[node].cnt[val] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        build(nums, node * 2, l, mid);
        build(nums, node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    // Merge two nodes
    Node merge(Node left, Node right) {

        Node res = new Node(k);

        // Prefixes completely inside left
        for (int i = 0; i < k; i++) {
            res.cnt[i] += left.cnt[i];
        }

        // Prefixes containing all of left
        // and some prefix of right
        for (int i = 0; i < k; i++) {

            int remainder = (left.prod * i) % k;

            res.cnt[remainder] += right.cnt[i];
        }

        // Product of complete segment
        res.prod = (left.prod * right.prod) % k;

        return res;
    }

    // Point Update
    void update(int node, int l, int r,
                int index, int value) {

        if (l == r) {

            tree[node] = new Node(k);

            int val = value % k;

            tree[node].prod = val;
            tree[node].cnt[val] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r,
                   index, value);
        }

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    // Range Query
    Node query(int node, int l, int r,
               int ql, int qr) {

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r,
                         ql, qr);
        }

        Node left = query(node * 2, l, mid, ql, qr);

        Node right = query(node * 2 + 1, mid + 1, r,
                           ql, qr);

        return merge(left, right);
    }
}