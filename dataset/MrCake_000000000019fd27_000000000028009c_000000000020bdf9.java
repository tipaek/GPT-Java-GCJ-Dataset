import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tAsString = br.readLine();
        int t = Integer.parseInt(tAsString);
        int[] ns = new int[t];
        ArrayList<ArrayList<Activity>> activities = new ArrayList<>();
        for(int i = 0; i < t; ++i) {
            activities.add(new ArrayList<>());
            String nAsString = br.readLine();
            int n = Integer.parseInt(nAsString);
            ns[i] = n;
            for(int j = 0; j < n; ++j) {
                String line = br.readLine();
                String[]elems = line.split(" ");
                activities.get(i).add
                (new Activity(Integer.parseInt(elems[0]),Integer.parseInt(elems[1])));
            }
        }
        for(int i = 0; i < t; ++i) {
            Graph graph = new Graph(ns[i], activities.get(i));
            //initialize the graph
            for(int j = 0; j < ns[i]; ++j) {
                graph.BFS(j);
            }
            if(!graph.checkNeighbours()) {
                System.out.println("Case #"+(i + 1)+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+(i + 1)+": "+graph.constructAnswer());
            }
        }
        
        

    }


    // This class represents a directed graph using adjacency list 
    // representation 
    static class Graph 
    { 
        private int V;   // No. of vertices 
        public LinkedList<Node> adj[]; //Adjacency Lists 
        public ArrayList<Node> nodes = new ArrayList<>();

        // Constructor 
        Graph(int v, ArrayList<Activity> activities) 
        { 
            V = v; 
            adj = new LinkedList[v]; 
            for (int i=0; i<v; ++i) {
                nodes.add(new Node(i, activities.get(i)));
                adj[i] = new LinkedList(); 
            }
            for(int j = 0; j < v; ++j) {
                for(int k = j + 1; k < v; ++k) {
                    if(activities.get(j).conflicts(activities.get(k))) {
                        addEdge(nodes.get(j),nodes.get(k));
                    }
                }
            }

        } 

        String constructAnswer() {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < V; ++i) {
                if(nodes.get(i).isOdd) {
                   builder.append("C"); 
                }else {
                   builder.append("J"); 
                }
            }
            return builder.toString();
        }
        
        boolean checkNeighbours() {
            for(int i = 0; i < V; ++i) {
                for(int j = 0; j < adj[i].size(); ++j) {
                    if(nodes.get(i).isOdd == adj[i].get(j).isOdd) return false;
                }
            }
            return true;
        }
        // Function to add an edge into the graph 
        void addEdge(Node v, Node w) 
        { 
            adj[v.number].add(w);
            adj[w.number].add(v);
        } 

     // prints BFS traversal from a given source s 
        void BFS(int s) 
        {  
            if(nodes.get(s).visited) {
                return;
            }
            // Create a queue for BFS 
            LinkedList<Node> queue = new LinkedList<Node>(); 
      
            // Mark the current node as visited and enqueue it 
            nodes.get(s).visited = true; 
            nodes.get(s).isOdd = true;
            queue.add(nodes.get(s)); 
      
            while (queue.size() != 0) 
            { 
                // Dequeue a vertex from queue and print it 
                Node iterated = queue.poll(); 
                boolean parity = iterated.isOdd;
                // Get all adjacent vertices of the dequeued vertex s 
                // If a adjacent has not been visited, then mark it 
                // visited and enqueue it 
                Iterator<Node> i = adj[iterated.number].listIterator();
                while (i.hasNext()) 
                { 
                    Node newIterated = i.next(); 
                    if (!newIterated.visited) 
                    { 
                        newIterated.visited = true;
                        newIterated.isOdd = !parity;
                        queue.add(newIterated); 
                    } 
                } 
            } 
        } 
        
    }
    static class Node{
        Activity acitivity;
        int number;
        boolean visited;
        boolean isOdd;
        public Node(int number, Activity activity) {
            this.number = number;
            this.acitivity = activity;
            visited = false;
        }
        
    }

    static class Activity{
        int start;
        int finish;
        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
        public boolean conflicts(Activity that) {
            return (start >= that.start && start < that.finish) ||
                    (finish > that.start && finish <= that.finish) ||
                    (start < that.start && finish > that.finish);
        }
    }

}
