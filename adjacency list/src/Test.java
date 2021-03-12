import javax.swing.text.GapContent;

public class Test {

    public static void main(String[] args) {

        int[] vexs = {1, 2, 3, 4, 5, 6, 7, 8};
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 1},
                {2, 5},
                {3, 1},
                {3, 6},
                {3, 7},
                {4, 2},
                {4, 8},
                {5, 2},
                {5, 8},
                {6, 3},
                {6, 8},
                {7, 3},
                {7, 8},
                {8, 4},
                {8, 5},
                {8, 6},
                {8, 7},
        };
        Graph graph = new Graph();
        graph.buildGragh(vexs, edges);
        graph.printGraph();
        graph.dfs(1);
        System.out.println("--------");

        graph.bfs(1);
    }

}