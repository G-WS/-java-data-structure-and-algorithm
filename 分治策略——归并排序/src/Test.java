import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    protected static int m;

    public static void main(String[] args) {

        int i=1,j=0;
        int[]a=new int[16];
        int []b = new int[16];
        while(i<=a.length){
            a[i-1]=(int)(Math.random()*100+1);
            i++;
        }
        Msort(a,b,0,a.length-1);
        while(j<b.length){
            System.out.print(b[j]+" ");
            j++;
        }
    }

    protected static void Msort(int r[], int r1[], int s, int t) {
        if (s == t) {
            r1[s] = r[s];
        } else {
            m = (s + t) / 2;
            Msort(r, r1, s, m);
            m=(s+t)/2;
            Msort(r, r1, m + 1, t);
            m=(s+t)/2;
            Merge(r,r1,s,m,t);
            int i=s;
            while(i<=t){
                r[i]=r1[i];
                i++;
            }


        }
    }

    protected static void Merge(int r[], int r1[], int s, int m, int t) {
        int i, k, j;
        i = s;
        k = s;
        j = m + 1;
        while ((i <= m) && (j <= t)) {
            if (r[i] <= r[j]) {
                r1[k] = r[i];
                i++;
            } else {
                r1[k] = r[j];
                j++;
            }
            k++;
        }
        if (i > m) {
           while(j<=t){
               r1[k]=r[j];
               j++;
               k++;
           }
        } else {
            while(i<=m){
                r1[k]=r[i];
                i++;
                k++;
            }
        }
    }
}
