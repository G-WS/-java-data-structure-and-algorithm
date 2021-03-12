public class Gcd {
    private int a;
    private int b;

    public Gcd() {
    }

    public void Gcd(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
    public int Euclid(Gcd g){

        int r0,r1,r2,tmp;
        if(g.getA()>=g.getB()){
            r0=g.getA();
            r1=g.getB();
        }else{
            r0=g.getB();
            r1=g.getA();
        }
        tmp=r0/r1;
        r2=r0-tmp*r1;
        while(r2!=0){
            r0=r1;
            r1=r2;
            tmp=r0/r1;
            r2=r0-tmp*r1;
        }
        return r1;
    }
}
