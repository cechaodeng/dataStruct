/**
 * Created by Jessie Feng on 2018-11-29 .
 */
public class  Stack <T>  {
    //int[] a = new int[2];
    private int maxLength = 32;
    private Object[] nodes;
    private int length = 0;

    public Stack() {
        nodes = new Object[maxLength];
    }

    public Stack(int maxLength) {
        this.maxLength = maxLength;
        nodes = new Object[maxLength];
    }

    public void push(T node) {
        if (length > maxLength) {
            throw new RuntimeException("out of index");
        }
        nodes[length++] = node;
    }

    public T pop() {
        if (length > 0) {
            return (T)nodes[--length];
        }
        return null;
    }
}
