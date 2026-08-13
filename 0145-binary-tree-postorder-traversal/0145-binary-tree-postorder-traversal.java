class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        postorderTraversal(root, ans);
        return ans;
    }
    void postorderTraversal(TreeNode root, ArrayList<Integer> ans) {
        if (root == null)
            return;     
        postorderTraversal(root.left, ans);
        postorderTraversal(root.right, ans);
        ans.add(root.val);   
    }
}