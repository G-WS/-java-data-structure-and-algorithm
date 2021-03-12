import java.util.Scanner;

public class Test {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);

        Bt T = new Bt();
        T.createBt(T);
        T.pre(T);

    }
}
