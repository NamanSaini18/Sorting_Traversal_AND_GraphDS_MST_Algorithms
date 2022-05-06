import java.util.Scanner;

public class Prims_Algorithm_Main {
    public static void Prims(int[][] matrix)
    {
        int n = matrix.length;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] weight = new int[n];
        parent[0] = -1;
        weight[0] = 0;

        for (int i = 0; i < n; i++)
        {
            weight[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++)
        {
            int minv = findMinimum(visited,weight);
            visited[minv]=true;

            for (int j = 0;j<n; j++) {
            if(matrix[minv][j] != 0 && !visited[j])
            {
                if(weight[j] > matrix[minv][j])
                {
                    weight[j] = matrix[minv][j];
                    parent[j] = minv;

                }
            }
                
            }
        }
        for (int i = 0; i <n ; i++) {
            if(i < parent[i])
            {
                System.out.println(i+ "   "+parent[i]+ "   "+ weight[i]);
            }
            else
                System.out.println(parent[i]+ "   "+ i + "   " + weight[i]);
        }






    }

    private static int findMinimum(boolean[] visited,int[] weight)
    {
        int minv = -1;
        for (int i = 0; i < visited.length; i++)
        {
            if (!visited[i] && (minv == -1 || weight[i] < weight[minv]))
                minv = i;
        }
        return minv;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertex: ");
        int n = sc.nextInt();
        System.out.println("Enter the no of edges: ");
        int e = sc.nextInt();
        int[][] matrix =new int[n][n];
        for(int i=0;i<e;i++)
        {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            matrix[v1][v2] = weight;
            matrix[v2][v1] = weight;


        }
        Prims(matrix);
    }
}
