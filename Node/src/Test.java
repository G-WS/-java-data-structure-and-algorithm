//import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Link link = new Link();
        Node L = new Node();
        L = link.Initlink(L);
        Scanner in = new Scanner(System.in);
        System.out.println("您所要创建的约瑟夫环的元素个数为：");
        int n = in.nextInt();
        System.out.println("出列的序号为：");
        int m = in.nextInt();

        L = link.createLink(L, n);
        //List list = new ArrayList();
        link.jose(L, m, n);
        /*System.out.println(list);
        L = link.find(L, 6);
        System.out.println(L.data);

        link.Printlink(L, 8);*/

    }
}
