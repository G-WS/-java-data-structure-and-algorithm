
import java.util.Scanner;



class GraphMatrix{
    static final int MaxNum=20;
    static final int MaxValue=65535;
    char[] Vertex=new char [MaxValue];//顶点信息
    int GType;//图的类型：无向图/有向图
    int VertexNum;//顶点数量
    int EdgeNum;//边的数量
    int [][] EdgeWeight=new int[MaxNum][MaxNum];//边的权值
    int [] isTrav=new int [MaxValue];//遍历标志
}


public class Graph2 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        GraphMatrix GM= new GraphMatrix();
        System.out.println("输入图的类型：0为无向图，1为有向图");
        GM.GType=sc.nextInt();
        System.out.println("输入顶点数量");
        GM.VertexNum=sc.nextInt();
        System.out.println("输入全部顶点，如 ABCDEF");
        String vd=sc.next();
        System.out.println("输入图的边数");
        GM.EdgeNum=sc.nextInt();

        String []edgs=new String[GM.EdgeNum];
        System.out.println("输入构成各边的顶点及权值，如 :AB3   AC1  BC6 ");
        for(int i=0;i<GM.EdgeNum;i++){
            edgs[i]=sc.next();
        }



        ClearGraph(GM);//清空图（也就是初始化，将所有边置为无穷大）
        CreateGraph(GM,vd,edgs);//创建邻接表结构的图
        System.out.println("该图的邻接矩阵如下");
        OutGraph(GM);//输出邻接矩阵
        DeepTraGraph(GM);//输出深度优先搜索遍历结果
    }

    static void CreateGraph(GraphMatrix GM,String vd,String [] edgs){
        int weight; //权重
        char startV,endV; //边的起始点
        int j=0,k=0;
        GM.Vertex=vd.toCharArray();

        for(int i=0;i<GM.EdgeNum;i++){
            startV=edgs[i].charAt(0);
            endV=edgs[i].charAt(1);
            //weight=edgs[i].charAt(2);  //这里特别容易出处，每次获取int数值的时候都要特别注意。
            //weight=Character.getNumericValue(edgs[i].charAt(2));    //正确的处理应该要再转换一次,用Character包装类的方法

            String wei=edgs[i].substring(2);
            weight=Integer.valueOf(wei);



            for( j=0;startV!=GM.Vertex[j];j++); //查找已有顶点中的开始点
            for( k=0;endV!=GM.Vertex[k];k++);//查找已有顶点中的结束点
            GM.EdgeWeight[j][k]=weight;
            if(GM.GType==0){GM.EdgeWeight[k][j]=weight;} //如果是无向图，则对角位置还要记录一次
        }

    }

    static void ClearGraph(GraphMatrix GM){
        for(int i=0;i<GM.VertexNum;i++){
            for(int j=0;j<GM.VertexNum;j++){
                GM.EdgeWeight[i][j]=GraphMatrix.MaxValue;
            }
        }
    }

    static void OutGraph(GraphMatrix GM){
        for(int i=0;i<GM.VertexNum;i++){
            System.out.printf("\t%c",GM.Vertex[i]);
        }
        System.out.println("\n");
        for(int j=0;j<GM.VertexNum;j++){
            System.out.printf("%c",GM.Vertex[j]);
            for(int k=0;k<GM.VertexNum;k++){
                if(GM.EdgeWeight[k][j]==GraphMatrix.MaxValue){System.out.printf("\t∞");}
                else{System.out.printf("\t%d",GM.EdgeWeight[k][j]);}
            }
            System.out.println("\n");
        }
    }

    static void DeepTraGraph(GraphMatrix GM){

        for(int i=0;i<GM.VertexNum;i++){GM.isTrav[i]=0;} //清理标志位
        for(int j=0;j<GM.VertexNum;j++){
            if(GM.isTrav[j]==0){
                DeepTraGraphOne(GM,j);
            }
        }
    }


    static void DeepTraGraphOne(GraphMatrix GM,int n){ //从某一个特定的节点开始深度遍历图
        GM.isTrav[n]=1; //处理遍历标志位
        System.out.printf("->"+GM.Vertex[n]);
        for(int i=0;i<GM.VertexNum;i++){
            if(GM.EdgeWeight[n][i]!=GraphMatrix.MaxValue && GM.isTrav[n]==0){
                DeepTraGraphOne(GM,i);
            }
        }
    }







}
 