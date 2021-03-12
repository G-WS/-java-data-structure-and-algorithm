import java.util.Scanner;

public class N_queens {

    public void init(int n,boolean []rowExisted,boolean[]a,boolean[]b) {
        for (int i = 0; i < n + 1; i++) {
            rowExisted[i] = false;
        }
        for (int i = 0; i < n * 2; i++) {
            a[i] = b[i] = false;
        }
    }

    public boolean isExisted(int n,int row,int col,int[]queens,boolean []rowExisted,boolean[]a,boolean[]b){
        return(rowExisted[row]||a[row+col-1]||b[n+col-row]);
    }
    public void test(int n,int column,int []queens ,boolean[]rowExisted,boolean[]a,boolean[]b){
        for(int row = 1;row<n+1;row++){
            if(!isExisted(n,row,column,queens,rowExisted,a,b)){
                queens[column]=row;
                rowExisted[row]=a[row+column-1]=b[n+column-row]=true;
                if(column==n){
                    for (int col=1;col<=n;col++){
                        System.out.print("("+col+","+queens[col]+")");
                    }
                    System.out.println();
                }else{
                    test(n,column+1,queens,rowExisted,a,b);
                }
                rowExisted[row]=a[row+column-1]=b[n+column-row]=false;
            }
        }
    }



    public  static void main(String[] args){
        N_queens queen = new N_queens();
        Scanner in = new Scanner(System.in);
        int c=in.nextInt();
        int []queens = new int [c+1];
        boolean []rowExisted = new boolean[c+1];
        boolean[]a = new boolean[c*2];
        boolean[]b  = new boolean[c*2];
        queen.test(c,1,queens,rowExisted,a,b);
    }
}
