class Solution {
    int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode solve(int[] preorder,int[] inorder,int start,int end){
        if(start > end){
            return null;
        }
        int rootValue = preorder[i];
        i++;
        TreeNode root = new TreeNode(rootValue);
        int j = start;
        while(inorder[j] != rootValue){
            j++;
        }
        root.left = solve(preorder,inorder,start,j-1);
        root.right = solve(preorder,inorder,j+1,end);
        return root;
    }
}