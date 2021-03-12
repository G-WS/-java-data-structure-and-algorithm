import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入（以指令，车牌号，时间的形式输入)输入结束后请输入1");
        String c = in.next();
        int num = in.nextInt();
        int time = in.nextInt();
        ManagerCommend commend = new ManagerCommend(num, time);
        while (!in.next().equals("stop")) {


            if (c.equals("A")) {
                commend.a(commend);
                System.out.println("已成功停入停车场");
            } else if (c.equals("D")) {
                commend.d(commend);
                System.out.println("已成功离开停车场");
            } else {
                System.out.println("指令错误");
            }
            System.out.println("请继续输入（以指令，车牌号，时间的形式输入）");
            c = in.next();
            commend.num = in.nextInt();
            commend.time = in.nextInt();

        }
    }
}
