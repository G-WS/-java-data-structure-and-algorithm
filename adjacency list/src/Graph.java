import java.util.LinkedList;

public class Graph {
    VertexNode[] vertexArrays;
    int[] visited = new int[50];
    boolean[] isvisited = new boolean[50];

    //连接至最后
    public void linkLast(EdgeNode node1, EdgeNode node2) {
        while (node1.next != null) {
            node1 = node1.next;
        }
        node1.next = node2;
    }

    public int getPosition(int data) {
        for (int i = 0; i < vertexArrays.length; i++) {
            if (data == vertexArrays[i].data) {
                return i;
            }
        }
        return -1;
    }

    public void buildGragh(int[] vertexs, int[][] edges) {
        int vertexsLength = vertexs.length;
        int edgesLength = edges.length;
        vertexArrays = new VertexNode[vertexsLength];
        for (int i = 0; i < vertexsLength; i++) {
            vertexArrays[i] = new VertexNode();
            vertexArrays[i].data = vertexs[i];
            vertexArrays[i].firstEdge = null;
        }

        for (int i = 0; i < edgesLength; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            int begin = getPosition(a);
            int end = getPosition(b);

            EdgeNode edgeNode = new EdgeNode();
            edgeNode.adjvex = end;
            if (vertexArrays[begin].firstEdge == null) {
                vertexArrays[begin].firstEdge = edgeNode;
            } else {
                linkLast(vertexArrays[begin].firstEdge, edgeNode);
            }
        }
    }

    public void printGraph() {
        for (int i = 0; i < vertexArrays.length; i++) {
            System.out.print(vertexArrays[i] + "--");
            EdgeNode node = vertexArrays[i].firstEdge;
            while (node != null) {
                System.out.print(vertexArrays[node.adjvex].data);
                node = node.next;
            }
            System.out.println();
        }
    }

    //深度遍历
    public void dfs(int vertex) {
        int w;
        EdgeNode node;
        visited[vertex] = 1;
        System.out.println(vertex);
        node = vertexArrays[getPosition(vertex)].firstEdge;
        while (node != null) {
            w = node.adjvex;
            if (visited[vertexArrays[w].data] == 0) {
                dfs(vertexArrays[w].data);
            }
            node = node.next;
        }
    }

    //广度遍历
    public void bfs(int vertex) {
        VertexNode begin = vertexArrays[getPosition(vertex)];
        LinkedList<VertexNode> queue = new LinkedList<>();
        begin.setVisited(true);
        queue.add(begin);
        System.out.println(begin.data);
        VertexNode vertex1;
        while (!queue.isEmpty()) {
            vertex1 = queue.remove(0);
            EdgeNode node = vertex1.firstEdge;
            while (node != null) {
                if (vertexArrays[node.adjvex].isVisited == false) {
                    System.out.println(vertexArrays[node.adjvex].data);
                    vertexArrays[node.adjvex].setVisited(true);
                    queue.add(vertexArrays[node.adjvex]);
                }
                node = node.next;
            }
        }
    }
}
