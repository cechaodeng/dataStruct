package search;

import search.bean.Node;

public class BST {
    private Node root;
    private static int count;//节点数

    public BST() {
        root = null;
        count = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getCount() {
        return count;
    }

    /**
     * 插入一个节点
     * @param node
     * @param root
     * @return
     */
    public static Node insertNode(Node node, Node root) {
        //root为空
        if (root == null) {
            count++;
            root = node;
            return root;
        }
        int compareResult = node.getKey().compareTo(root.getKey());
        //root不为空
        if (compareResult < 0) {
            //值小于根节点，放在左边
            //node.setLeft(insertNode(node, root.getLeft()));
            //return node;

            return insertNode(node, root.getLeft());
        } else if (compareResult > 0) {
            //值大于根节点，放在右边
            //node.setRight(insertNode(node, root.getRight()));
            //return node;

            return insertNode(node, root.getRight());
        } else {
            //等于根节点，已存在，覆盖value
            root.setValue(node.getValue());
            return root;
        }
    }

    public static boolean contain(Comparable key, Node root) {
        if (root == null) {
            return false;
        }
        int compareResult = key.compareTo(root.getKey());
        if (compareResult < 0) {
            //小于根节点，在左边继续查找
            return contain(key, root.getLeft());
        } else if (compareResult > 0) {
            //大于根节点，在右边继续查找
            return contain(key, root.getRight());
        } else {
            //等于，找到，查找结束
            return true;
        }

    }

    public Comparable search(Comparable key, Node root) {
        if (root == null) {
            return null;
        }
        int compareResult = key.compareTo(root.getKey());
        if (compareResult < 0) {
            //小于根节点，去左边找
            return search(key, root.getLeft());
        } else if (compareResult > 0) {
            //大于根节点，去右边找
            return search(key, root.getRight());
        } else {
            //等于根节点，返回
            return root.getValue();
        }
    }

    public static void main(String[] args) {
        System.out.println(insertNode(new Node("test", 20), null).getValue());
    }

}
