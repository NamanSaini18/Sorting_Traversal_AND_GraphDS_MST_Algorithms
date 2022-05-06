import java.util.ArrayList;
import java.util.Scanner;


public class input {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int e = scan.nextInt();

        ArrayList<ArrayList<Integer>> list = adjacencyListMethod(n, e);
        for(int i=1; i<list.size(); i++) {
            System.out.println(i + " -> " + list.get(i));
        }
    }

    static void adjacencyMatrixMethod() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int e = scan.nextInt();
        int[][] arr = new int[n+1][n+1];
        int u, v;
        for(int i=0; i<n+1; i++) {
            u = scan.nextInt();
            v = scan.nextInt();
            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<n+1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> adjacencyListMethod(int n, int e) {
        Scanner scan = new Scanner(System.in);
        int u, v;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=1; i<=n+1; i++) {
            list.add(new ArrayList<Integer>());
        }
        for(int i=1; i<=e; i++) {
            u = scan.nextInt();
            v = scan.nextInt();
            list.get(u).add(v);
            list.get(v).add(u);
        }

        return list;
    }
}
