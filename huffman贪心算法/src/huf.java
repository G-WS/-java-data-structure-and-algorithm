import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class huf {

    protected static LinkedList<Huff> hufList = new LinkedList<Huff>();

    public class Huff implements Comparable<Huff> {
        protected String name;
        protected int f;
        protected Huff left = null;
        protected Huff right = null;


        public Huff() {
        }

        protected Huff(int f1, String n) {
            name = n;
            f = f1;

        }

        protected Huff(Huff l, Huff r) {
            left = l;
            right = r;
            f = left.f + right.f;

        }

        public int compareTo(Huff node) {
            if (this.f < node.f) {
                return -1;
            } else if (this.f == node.f) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static void HufmanCode() {
        if (hufList.size() == 1) {
            return;
        }
        while (hufList.size() > 1) {
            Collections.sort(hufList);
            Huff node = new huf().new Huff(hufList.get(0), hufList.get(1));
            hufList.remove();
            hufList.remove();
            hufList.add(node);
        }
    }

    public static void decode(Huff n, String code) {
        if ((n.left == null) && (n.right == null)) {
            System.out.print("元素为：" + n.name + "  编码为：" + code);
            System.out.println();
            return;
        }
        decode(n.left, code + "0");
        decode(n.right, code + "1");
        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            hufList.add(new huf().new Huff(in.nextInt(), in.next()));

        }
        HufmanCode();

        decode(hufList.get(0), "");
    }

}

