/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean isBalanced(TreeNode root) {
        //top down
        // brute force -- calculate depth of left and right tree AT EVERY NODE and check if diff is greater than one if yes return false, return true --->  tc is o(n ^ 2) in worst case of skewed tree,  best case - o(n log n) in case of balanced tree
        //sc = recurstion stack -- o(n) skewed/worst  o(log n) balanced/best case
        // in case of skewed since we start at root and return as soon as imbalance is found, our code actually breaks at o(n) but still the tc would remain o(n^2) in case of messed up skewed+balanced tree combination

        //bottom up -
        // start at child nodes and go up to root
        // tc = sc = o(n)

        return checkHeight(root) != -1;
    }

    //bottom up
    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1; // left subtree unbalanced

        int right = checkHeight(node.right);
        if (right == -1) return -1; // right subtree unbalanced

        if (Math.abs(left - right) > 1) return -1; // current node unbalanced

        return 1 + Math.max(left, right); // return height
    }

    public boolean solve(TreeNode root) {
        if (root == null) return true;

        int left = depth(root.left);
        int right = depth(root.right);

        if (Math.abs(left - right) > 1) return false;

        return solve(root.left) && solve(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;

        int left = depth(root.left);
        int right = depth(root.right);

        return 1 + Math.max(left, right);
    }
}
