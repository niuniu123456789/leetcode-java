package first.leetcode.no116;

/**
 * @author lvy
 * @date 2021/10/9 17:01
 */
class Solution {
    //主方法
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        connectNode(root.left, root.right);
        return root;
    }

    //连接字符串
    public void connectNode(Node node1,Node node2){
        if (node1 == null || node2 == null){
            return;
        }

        //将传入的两个字符串连接
        node1.next = node2;

        //递归调用连接 两个同父 的子节点
        connectNode(node1.left,node1.right);
        connectNode(node2.left,node2.right);

        //递归调用连接两个不同父 的子节点
        connectNode(node1.right, node2.left);
    }
}
