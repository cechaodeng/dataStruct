package graph;

import java.util.Vector;

/**
 * Created by kent on 18-2-7.
 * 稀疏图 邻接表
 */
public class SparseGraph {
    private int n;//节点数
    private int m;//边数
    private boolean directed;//是否有向图

    Vector<Vector<Integer>> g = new Vector<>();

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        for (int i = 0; i < n; i++) {
            Vector g1 = g.get(i);
            for (int j = 0; j < n; j++) {
                g1.set(j, 0);
            }
        }
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }


}
