import java.util.Scanner;

public class Juzhen {
    static int N = 100;
    static int[] p = new int[N];
    static int[][] m = new int[N][N];
    static int[][] s = new int[N][N];
    static int n;

    static void matrixchain() {
        int i, j, r, k;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (i == j) {
                    m[i][j] = 0;
                    s[i][j] = 0;
                }
            }
        }
        for (r = 2; r <= n; r++) {
            for (i = 1; i <= n - r + 1; i++) {
                j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] + p[j];
                s[i][j] = i;
                for (k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[j] * p[k];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    static void print(int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
            return;
        }
        System.out.print("(");
        print(i, s[i][j]);
        print(s[i][j] + 1, j);
        System.out.print(")");

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入矩阵的个数n");
        n = in.nextInt();
        int i, j;
        System.out.println("请输入每一个矩阵行数和最后一个矩阵的列数");
        for (i = 0; i <= n; i++) {
            p[i] = in.nextInt();
        }
        matrixchain();
        print(1, n);

    }

}
