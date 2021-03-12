import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入两个数字");
        int a = in.nextInt();
        int b = in.nextInt();
        Gcd g=new Gcd();
        g.setA(a);
        g.setB(b);
        int x;
        x=g.Euclid(g);
        System.out.println("这两个数字的最大公因子为"+x);
    }
}
