package search;

import search.bean.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树类
 */
public class BST {
    private Node root;
    public static int count;//节点数

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
            root.setLeft(insertNode(node, root.getLeft()));
            return root;

            //这样做返回的是儿子
            //return insertNode(node, root.getLeft());
        } else if (compareResult > 0) {
            //值大于根节点，放在右边
            root.setRight(insertNode(node, root.getRight()));
            return root;
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

    /**
     * 从树中查找key，找到就返回该元素的value，没有找到就返回Null
     * @param key
     * @param root
     * @return
     */
    public static Node search(Comparable key, Node root) {
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
            return root;
        }
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.getKey() + "\t");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getKey());
            inOrder(root.getRight());
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getKey());
        }
    }

    /**
     * 销毁树
     * @param root
     */
    public static void destroy(Node root) {
        if (root != null) {
            destroy(root.getLeft());
            destroy(root.getRight());
            root = null;
            count--;
        }
    }

    public static void levelOrder(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        //将根元素进队列
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            //弹出队列第一个
            Node firstNode = nodeQueue.poll();
            System.out.print(firstNode.getKey());
            if (firstNode.getLeft() != null) {
                nodeQueue.offer(firstNode.getLeft());
            }
            if (firstNode.getRight() != null) {
                nodeQueue.offer(firstNode.getRight());
            }
            System.out.println();
        }
    }

    /**
     * 寻找最小值节点
     * @param root
     * @return
     */
    public static Node getMinNode(Node root) {
        return root.getLeft() == null ? root : getMinNode(root.getLeft());
    }

    /**
     * 寻找最大值节点
     * @param root
     * @return
     */
    public static Node getMaxNode(Node root) {
        return root.getRight() == null ? root : getMaxNode(root.getRight());
    }

    /**
     * 这个逻辑还挺复杂的,因为没有指针
     * 删除最小值，如果这个最小值有右儿子，就要返回这个右儿子，接上
     * @param root 需要被删除左儿子的节点
     * @return
     */
    public static Node removeMin(Node root) {
        if (root.getLeft() == null) {
            //没有左儿子了，只能删除自己了
            Node rightNode = root.getRight();//记录右儿子，要接上节点
            root.setRight(null);
            count--;
            return rightNode;
        }
        root.setLeft(removeMin(root.getLeft()));
        return root;
    }

    /**
     * 删除右儿子，但是要返回一个被接上的节点，这个节点是被删除的儿子的儿子
     * @param root 需要被删除右儿子的节点
     * @return
     */
    public static Node removeMax(Node root) {
        if (root.getRight() == null) {
            //如果没有右儿子，只能删除自己了，但是要把左儿子记录下来
            Node leftNode = root.getLeft();
            root.setLeft(null);
            count--;
            return leftNode;
        }
        //有右儿子，删除右儿子
        root.setRight(removeMax(root.getRight()));
        return root;
    }

    /**
     * 删除指定一个节点
     *
     * @param root
     * @return
     */
    public static Node remove(Node root, Node node) {
        if (root == null) {
            return null;
        }

        int compareResult = node.getKey().compareTo(root.getKey());
        if (compareResult < 0) {
            root.setLeft(remove(root.getLeft(), node));
            return root;
        } else if (compareResult > 0) {
            root.setRight(remove(root.getRight(), node));
            return root;
        } else {
            //需要删除的就是当前节点
            //首先找到当前节点右子树的最小值，作为当前节点删除后的替代节点
            if (root.getLeft() == null) {
                //左孩子为空,就回到删除最小节点问题
                Node rightNode = root.getRight();
                root.setRight(null);
                count--;
                return rightNode;
            } else if (root.getRight() == null) {
                //右孩子为空，就回到删除最大值的问题了
                Node leftNode = root.getLeft();
                root.setLeft(null);
                count--;
                return leftNode;
            } else {
                //左右孩子都不为空
                //替代的节点
                Node rightTreeMinNode = BST.getMinNode(root.getRight());
                //替代节点的右儿子就是当前需要删除最小值的根节点
                rightTreeMinNode.setRight(BST.removeMin(root));
                //替代节点的左儿子就是当前需要被删除的节点的左儿子，也就是当前节点的左儿子
                rightTreeMinNode.setLeft(root.getLeft());
                count--;
                return rightTreeMinNode;
            }


        }
    }

    public static void main(String[] args) {

        //System.out.println(insertNode(new Node("test", 20), null).getValue());
    }

}
