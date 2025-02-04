import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class App {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int val = node.val;
            if (val >= low && node.left != null) {
                stack.push(node.left);
            }
            if (val <= high && node.right != null) {
                stack.push(node.right);
            }
            if (val >= low && val <= high)
                sum += val;
        }
        return sum;
    }
}