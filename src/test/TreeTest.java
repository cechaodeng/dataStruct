package test;

import search.BST;
import search.bean.Node;
import util.FileUtil;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by kent on 18-1-29.
 */
public class TreeTest {
    public static void main(String[] args) throws IOException {
        Node root = null;
        String[] words = new String[]{"ab", "bc", "cd", "a", "bc", "a", "c", "cd", "ab", "ab", "a"};
        //String[] words = FileUtil.getFileWord2Array("/home/kent/IdeaProjects/sort/src/search/resource/bible.txt");
        for (String word : words) {
            Node node = BST.search(word, root);
            if (node == null) {
                root = BST.insertNode(new Node(word, 1), root);
            } else {
                node.setValue(node.getValue() + 1);
            }
        }
        BST.preOrder(root);
        System.out.println();

        Stack<Node> nodes = new Stack<>();
        BST.searchNoSeq("c", root, nodes);
        System.out.println();

        //BST.levelOrder(root);
        /*System.out.println(words.length);
        System.out.println(BST.count);
        System.out.println(BST.search("god", root).getValue());*/
        //System.out.println();
    }
}
