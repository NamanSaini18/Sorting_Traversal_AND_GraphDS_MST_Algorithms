import java.util.Arrays;

public class Dijkstra_Algorithm
{
    static int[] dijkstraMST(int g[][], int src)
    {
        int v = g.length;
        int [] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        boolean vis[] = new boolean[v];
        for (int i = 0; i < v-1; i++)
        {
            int u = -1;
            for (int j = 0; j < v; j++)
                if(!vis[j] && (u == -1 || dist[j] < dist[u]))
                    u = j;
            vis[u] = true;
            for (int j = 0; j < v; j++)
                if(!vis[j] && g[u][j] != 0)
                    dist[j] = Math.min( dist[j], dist[u]+g[u][j]);
        }
        for (int i = 0; i < g.length; i++)
            System.out.println(dist[i]);
        return dist;
    }
    public static void main(String[] args)
    {
        int g[][] = new int[][]{ { 0, 5, 10, 0},{ 5, 0, 3, 20 },{ 10, 3, 0, 2 },{ 0, 20, 2, 0 }};
        int res[] = dijkstraMST(g,0);
//        for (int i = 0; i < g.length; i++)
//            System.out.println(res[i]);
    }
}
