package algorithms;

/**
 * @author yangkai
 * @date 2019-02-27
 * @email yangkai@hujiang.com
 * @description
 */
public class PathSum2 {
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            this.build(root, sum, result, list);
            for (List<Integer> e : new ArrayList<>(result)) {
                int count = 0;
                for (Integer i : e) {
                    count += i;
                }

                if (count != sum) {
                    result.remove(e);
                }
            }
            return result;
        }

        private void build(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
            if (root == null) {
                return;
            }
            //叶子节点
            if (root.left == null && root.right == null) {
                list.add(root.val);
                result.add(list);
                return;
            }
            list.add(root.val);
            build(root.left, sum, result, new ArrayList<>(list));
            build(root.right, sum, result, new ArrayList<>(list));
            list.clear();
        }
    }

    

    public static void main(String[] args) {
        new PathSum2().new Solution().pathSum(null, 22);
    }
}
