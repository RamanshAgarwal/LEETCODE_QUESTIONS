class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorderTraversal(root, ans);
        return ans;
    }
    void preorderTraversal(TreeNode root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);        
        preorderTraversal(root.left, ans);
        preorderTraversal(root.right, ans);
    }
}