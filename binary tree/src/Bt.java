import java.util.Scanner;

public class Bt {
    protected Bt leftson;
    protected Bt rightson;
    protected int data;

    public Bt(int data) {
        this.data = data;

    }

    public Bt() {
    }


    public Bt createBt(Bt T) {

        Scanner in = new Scanner(System.in);
        System.out.println("请输入当前节点的数据域：");
        data = in.nextInt();
        T = new Bt(data);

        if (data == 0) {
            T = null;
        } else {
            T.leftson = createBt(T.leftson);
            T.rightson = createBt(T.rightson);
        }
        return T;
    }

    public static void pre(Bt T) {

        if (T == null) {
            return;
        } else {
            System.out.print(T.data + " ");
            pre(T.leftson);
            pre(T.rightson);
        }
    }

    public static Bt mid(Bt T) {
        if (T == null) {
            return T;
        } else {
            mid(T.leftson);
            System.out.print(T.data + " ");
            mid(T.rightson);
        }
        return T;
    }

    public static Bt last(Bt T) {
        if (T == null) {
            return T;
        } else {
            last(T.leftson);
            last(T.rightson);
            System.out.print(T.data + " ");
        }
        return T;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Bt T = new Bt();
        Bt L = new Bt();
        L = T.createBt(T);
        pre(L);
        System.out.println();
        mid(L);
        System.out.println();
        last(L);

    }
}
