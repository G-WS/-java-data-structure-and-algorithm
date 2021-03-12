//import java.util.ArrayList;

import java.util.List;

public class Link {
    protected int length;

    public Node Initlink(Node node) {
        node = new Node();
        node.next = null;

        return node;
    }

    public Node createLink(Node node, int i) {
        Node q = new Node(1);
        node.next = q.next;
        node.next = q;
        for (int j = 2; j <= i; j++) {
            Node p = new Node(j);
            if (j == i) {

                p.next = node.next;
                q.next = p;
                q = q.next;
            } else {

                p.next = q.next;
                q.next = p;
                q = q.next;
            }


        }
        return node;
    }

    public void Printlink(Node L, int j) {
        this.length = j;
        Node node = L.next;
        for (int i = 0; i <= j; i++) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public Node find(Node node, int i) {
        Node l = node;
        for (int j = 1; j < i; j++) {
            l = l.next;

        }
        return l;
    }

    public Node del(Node node, int i) {
        Node L = node;
        L = find(L, i - 1);
        Node P = node;
        P = L.next;

        int x = P.data;
        System.out.println(x);
        L.next = P.next;
        L = L.next;
        return L;
    }

    public void jose(Node L, int m, int n) {

        //List list = new ArrayList();
        Node node = L.next;


        for (int i = 1; i <= n; i++) {
            node = del(node, m);
            //list.add(p.data);
        }

    }


}
