/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        this.build(root, result, new StringBuilder(), 1);
        return result;
    }
    
    private void build(TreeNode root, List<String> result, StringBuilder builder, Integer degree) {
        if (root == null) {
            return;
        }
        
        //叶子节点
        if (root.left == null && root.right == null) {
            if (degree == 1) {
                builder.append(root.val);
            } else {
                builder.append("->").append(root.val);
            }
            result.add(builder.toString());
            return;
        }
        
        if (degree == 1) {
            builder.append(root.val);
        } else {
            builder.append("->").append(root.val);
        }
        
        this.build(root.left, result, new StringBuilder(builder.toString()), ++degree);
        this.build(root.right, result, new StringBuilder(builder.toString()), ++degree);
    }
}