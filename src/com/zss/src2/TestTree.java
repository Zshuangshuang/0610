package com.zss.src2;

import java.util.Scanner;

/**
 * @ClassName: TestTree
 * @Author: 邹双双
 * Date: 2020/6/10 10:25
 * @Description:
 */

class Node{
    public char val;//数据域
    public Node right;
    public Node left;

    public Node(char val) {
        this.val = val;
    }
}
public class TestTree {
    //构建Tree
    public static  Node buildTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.left = f;
        e.right = g;
        c.right = h;
        return a;

    }
    //先序遍历
    public static void prevOrder(Node root){
        if (root == null){
            return;
        }

        System.out.print(root.val+" ");//访问根节点
        prevOrder(root.left);
        prevOrder(root.right);

    }
    //中序遍历
    public static void inOrder(Node root){
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);

    }
    //后序遍历
    public static void postOrder(Node root){
        if (root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");

    }
    public static int size(Node root){
        //使用先序遍历
        if (root == null){
            return 0;
        }
        //访问根节点:计数器+1
        //整个树的节点个数 = 根节点个数 + 左孩子节点个数 + 右孩子节点个数
        return 1 +size(root.right) +size(root.left);
    }
    //求叶子节点的个数
    //求叶子节点的个数 = root.left的叶子节点个数+root.right的叶子节点的个数
    public static int leafSize(Node root){
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }
    //求二叉树第k层节点的个数
    public static int kLevelSize(Node root,int k){
        //如果k<1，则为空树返回0
        //k == 1，则为根节点，返回1
        //如果k>1，那么第k层的节点数 = k-1层的左子树节点个数 + k-1层右子树节点个数
        if (k < 1 || root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.right,k-1)+kLevelSize(root.left,k-1);
    }
    //在二叉树中查找指定元素
    //核心思路：遍历二叉树
    public static Node find(Node root,char toFind){
        if (root == null) {
            return null;
        }
        if (root.val == toFind) {
            return root;
        }
        Node result = find(root.left,toFind);
        if (result != null){
            return result;
        }
        return find(root.right,toFind);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.print("先序遍历:");
        prevOrder(root);
        System.out.println();
        System.out.print("中序遍历:");
        inOrder(root);
        System.out.println();
        System.out.print("后序遍历:");
        postOrder(root);
        int ret = size(root);
        System.out.println();
        System.out.println("节点个数为：" + ret);
        int tmp = leafSize(root);
        System.out.println("叶子节点的个数为："+tmp);
        Scanner sc = new Scanner(System.in);
        int sizeOfKLevel = kLevelSize(root,sc.nextInt());
        System.out.println("sizeOfKLevel:"+sizeOfKLevel);
        Node node = find(root,'A');
        

    }
}
