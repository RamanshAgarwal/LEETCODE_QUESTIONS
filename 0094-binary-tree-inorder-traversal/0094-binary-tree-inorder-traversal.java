class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }
    void inorderTraversal(TreeNode root, ArrayList<Integer> ans) {
        if (root == null)
            return;     
        inorderTraversal(root.left, ans);
        ans.add(root.val);  
        inorderTraversal(root.right, ans);
    }
}