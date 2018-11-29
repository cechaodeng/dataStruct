package search.bean;

public class  Node<T> {
    private Comparable key;
    private Integer value;
    private Node left;
    private Node right;

    public Node(Comparable key, Integer value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Comparable getKey() {
        return key;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
