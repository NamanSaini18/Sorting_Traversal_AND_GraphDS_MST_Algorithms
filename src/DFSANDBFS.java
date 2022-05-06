import java.util.*;

public class DFSANDBFS {
    HashMap<Integer, List<Integer>> obj;
    public DFSANDBFS()
    {
        obj = new HashMap<>();
    }

    // Single Source Shortest Path
    public void AddEdge(int v1, int v2, boolean isBidirectional)
    {
        List<Integer> v1neighbour = obj.getOrDefault(v1,new ArrayList<>());
        v1neighbour.add(v2);
        obj.put(v1,v1neighbour);

        if(isBidirectional == true)
        {
            List<Integer> v2neighbour = obj.getOrDefault(v2,new ArrayList<>());
            v2neighbour.add(v1);
            obj.put(v2,v2neighbour);
        }
    }

    // BFS Traversal using Queue DS
    public void BFSTraversal(int source)
    {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(source);

        Set<Integer> visited = new HashSet<>();
        visited.add(source);

        while(!bfs.isEmpty())
        {
            int front = bfs.poll();
            System.out.print(front+" ");
            List<Integer> neighbourList = obj.get(front);
            for(int neighbour : neighbourList)
            {
                if(!visited.contains(neighbour))
                {
                    bfs.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }

    public void DFSTraversal(int source)
    {
        Set<Integer> visited = new HashSet<>();
        DFSHelper(source,visited);
    }
    private void DFSHelper(int source, Set<Integer> visited)
    {
        System.out.print(source+" ");
        visited.add(source);
        List<Integer> neighbourList = obj.get(source);
        for(int neighbour : neighbourList)
        {
            if(!visited.contains(neighbour))
            {
                DFSHelper(neighbour,visited);
            }
        }

    }
    public void display()
    {
        for(Map.Entry<Integer,List<Integer>> entry : obj.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void SingleSourceShortestPath(int source)
    {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(source);
        Map<Integer, Integer> dis = new HashMap<>();
        for(int vertex: obj.keySet())
        {
            dis.put(vertex,Integer.MAX_VALUE);
        }
        dis.put(source,0);
        while(!bfs.isEmpty())
        {
            int front = bfs.poll();

            List<Integer> neighbourList = obj.get(front);
            for(int neighbour : neighbourList)
            {
                if(dis.get(neighbour) == Integer.MAX_VALUE)
                {
                    bfs.add(neighbour);
                    int distance = dis.get(front)+1;
                    dis.put(neighbour,distance);

                    System.out.println("Distance of" +" " + neighbour + " " +"from source" + " " + source+ " " +"is :" +distance);

                }
            }
        }

    }

    public static void main(String[] args) {
        DFSANDBFS obj = new DFSANDBFS();
        obj.AddEdge(1,2,true);
        obj.AddEdge(1,4,true);
        obj.AddEdge(2,3,true);
        obj.AddEdge(3,4,true);
        obj.AddEdge(3,5,true);
        obj.AddEdge(5,6,true);
        System.out.println("Information about the Graph : ");
        obj.display();
        System.out.println("DFS Traversal is: ");
        obj.DFSTraversal(1);
        System.out.println("\nBFS Traversal is: ");
        obj.BFSTraversal(1);
        System.out.println("\nSingle source shortest path details: ");
        obj.SingleSourceShortestPath(4);


    }

}
