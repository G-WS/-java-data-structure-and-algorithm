public class ManagerCommend {
    protected String commend;
    protected int num;
    protected int time;
    Stack park = new Stack(5);
    Queue queue = new Queue();
    Stack queue1 = new Stack(10);

    public ManagerCommend( int num, int time) {
        this.num = num;
        this.time = time;
    }

    //停车登记
    public Stack a(ManagerCommend a) {

        CommendA A = new CommendA(a.num, a.time);
        if (park.isFull() == true) {
            System.out.println("停车场已满");
            queue.in(A);
        } else {
            park.push(A);

        }
        return park;
    }

    //离车登记
    public Stack d(ManagerCommend d) throws Exception {
        CommendD D = new CommendD( d.num, d.time);
        if (park.isEmpty() == true) {
            throw new Exception("Error!停车场已空！！！");
        } else {
            ManagerCommend s = (ManagerCommend) park.pop();
            queue1.push(s);
            for (; s.num != d.num; ) {
                s = (ManagerCommend) park.pop();
                queue1.push(s);
            }
            if (park != null) {
                park.pop();
                while (!queue1.isEmpty()) {
                    s = (ManagerCommend) queue1.pop();
                    park.push(s);
                }
                if (queue != null) {
                    s = (ManagerCommend) queue.out();
                    park.push(s);
                }
                return park;

            } else {
                throw new Exception("Error!停车场已空！！！");
            }


        }
    }
}
