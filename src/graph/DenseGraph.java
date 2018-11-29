package graph;

import java.util.List;
import java.util.Vector;

/**
 * Created by kent on 18-2-7.
 * 稠密图 邻接矩阵
 */
public class DenseGraph {
    private int n;//节点数
    private int m;//边数
    private boolean directed;//是否有向图

    private Vector<Vector<Boolean>> g = new Vector<>();


    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        for (int i = 0; i < n; i++) {
            g.set(i, new Vector<>());
            Vector<Boolean> g2 = g.get(i);
            for (int j = 0; j < n; j++) {
                g2.set(j, Boolean.FALSE);
            }
        }
    }

    /**
     * 两个顶点之间添加边
     * @param v 其中一个顶点
     * @param w 另一个顶点
     */
    public void addEdge(int v, int w) {
        //判断节点位置是否合法
        if (v >= 0 && v < n && w >= 0 && w < n) {
            if (hasEdge(v, w)) {
                return;
            }
            g.get(v).set(w, true);
            //判断是否无向图
            if (!directed) {
                g.get(w).set(v, true);
            }
            this.m++;

        }
    }

    /**
     * 判断两个顶点之间是否已经存在边了
     * @param v a point
     * @param w another point
     * @return
     */
    public boolean hasEdge(int v, int w) {
        if (v >= 0 && v < n && w >= 0 && w < n) {
            return g.get(v).get(w);
        }
        return false;
    }
}
