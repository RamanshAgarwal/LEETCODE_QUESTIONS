class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bigList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return bigList;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> smallList = new ArrayList<>();
            for (int i = 1; i <= queueSize; i++) {
                TreeNode node = queue.poll();
                smallList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            bigList.add(smallList);
        }
        return bigList;
    }
}