package other;

/**
 * Created by kent on 18-2-7.
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        fibonacciNumber(9);

    }

    /**
     * 斐波那契
     * @param index 第几个斐波那契数
     */
    public static void fibonacciNumber(int index) {
        if (index <= 0) {
            System.out.println(-1);
            return;
        }
        if (index == 1) {
            System.out.println(0);
            return;
        }
        if (index == 2) {
            System.out.println(1);
            return;
        }
        int[] fibs = new int[index];
        fibs[0] = 0;
        fibs[1] = 1;
        for (int i = 1; i < fibs.length; i++) {
            int next = fibs[i - 1] + fibs[i];
            if (i == index - 2) {
                System.out.println(next);
                return;
            }
            fibs[i + 1] = next;
        }
    }
}
