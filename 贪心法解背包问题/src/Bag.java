import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Bag {
    public static double Package(int s,double[] w,double[] v,double p){
        double[][] dv = new double[s][2];
        for(int i=0;i<s;i++){
            dv[i][0]=v[i]/w[i];
            dv[i][1]=i;
        }
        Arrays.sort(dv,new Comparator<double[]>(){
            public int compare(double[]o1,double[]o2){
                return o2[0]-o1[0]>0?1:-1;
            }
        });
        double tempW = 0;
        double value = 0;
        for(int i = 0;i<s;i++){
            int b = (int)dv[i][1];
            double thisW = w[b];
            if(thisW<p-tempW){
                value+=v[b];
                tempW+=w[b];
                System.out.println("物品"+b+"放入比例1获得收益"+v[b]);
            }else{
                double canW = p-tempW;
                value+=dv[i][0]*canW;
                System.out.println("物品"+b+"放入比例"+canW/thisW+"获得收益"+dv[i][0]*canW);
                break;
            }
        }
        return value;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入有几个物品");
        int n = in.nextInt();
        System.out.println("请输入书包容量");
        int p = in.nextInt();
        double [] w = new double[n];
        double []v = new double[n];
        for (int i=0;i<n;i++){
            System.out.println("请输入"+(i+1)+"号物品的重量和价值：  ");
            w[i] = in.nextDouble();
            v[i] = in.nextDouble();
        }
        double result = Package(n,w,v,p);
        System.out.println("获取最大收益为： "+result);
    }
}
