public class VertexNode {

    //顶点
    protected int data;
    protected EdgeNode firstEdge;//第一条边
    protected boolean isVisited;

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }//判断是否遍历过

}
