import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    static class Edge{
        int v1, v2;
        int c = 1000000;
        Edge(int v1, int v2){
            this.v1 = v1;
            this.v2 = v2;
        }

        int cos(){
            return Math.min(cost[v1], cost[v2]);
        }
    }
    static ArrayList<Edge> edges;
    static int c, d;
    static int ord[];
    static int ord2[];
    static boolean visited[];
    static int cost[];
    static ArrayList<ArrayList<Integer>> orders;
    static ArrayList<Integer> extraNodes;

    static void insertEdge(int v1, int v2){
        Edge e = new Edge(v1, v2);
        edges.add(e);
    }

    static Edge findEdge(int v){
        for(Edge e : edges){
            if((e.v1 == v && visited[e.v2]) || (e.v2 == v && visited[e.v1])){
                return e;
            }
        }
        return null;
    }

    static void dijkstra(){
        int c = 0;
        int marked = 1;
        for(ArrayList<Integer> ord : orders){

            while(ord2[ord.get(0)] != marked){
                int next = extraNodes.get(0);
                extraNodes.remove(0);
                marked++;
                Edge e = findEdge(next);
                e.c = cost[next] - e.cos();
                visited[next] = true;
                c = cost[next];
            }
            c++;
            for(int o : ord){
                Edge e = findEdge(o);
                e.c = c - e.cos();
                cost[o] = c;
            }

            for(int o : ord){
                marked++;
                visited[o] = true;
            }
        }
    }

    static int mini(){
        int mi = 150;
        for(int i = 1; i<=c; i++){
            mi = Math.min(ord[i], mi);
        }
        return mi;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int tt = 1; tt<= t; tt++){
            c = in.nextInt();
            d = in.nextInt();
            ord = new int[c+1];
            ord2 = new int[c+1];
            visited = new boolean[c+1];
            cost = new int[c+1];
            cost[1] = 0;
            for(int i = 2; i<=c; i++){
                cost[i] = 200000000;
            }
            ord[1] = 150;
            extraNodes = new ArrayList<>();
            for(int i = 2; i<=c; i++){
                int val = in.nextInt();
                if(val<0){
                    ord[i] = - val;
                    ord2[i] = -val;
                }else{
                    ord[i] = 150;
                    cost[i] = val;
                    extraNodes.add(i);
                }

            }
            Collections.sort(extraNodes, Comparator.comparingInt(a -> cost[a]));
            orders = new ArrayList<>();
            visited[1] = true;
            while(mini() < 150){
                ArrayList<Integer> a = new ArrayList<>();
                orders.add(a);
                int m = mini();
                for(int i = 1; i<=c; i++){
                    if(ord[i] == m){
                        a.add(i);
                        ord[i]= 150;
                    }
                }
            }

            edges = new ArrayList<>();
            for(int i = 0; i<d; i++){
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                insertEdge(v1, v2);
                //insertEdge(v2, v1);

            }
            cost[1] = 0;
            dijkstra();
            System.out.print("Case #" + tt + ": ");
            for(Edge e : edges){
                System.out.print(e.c + " ");
            }
            System.out.println();
        }
    }

}
/*
1
4 4
-1 -3 -2
1 2
1 3
2 4
3 4

 */
/*
1
4 4
-1 -1 -1
1 4
1 2
1 3
2 3
 */

/*
3

4 4
-1 -3 -2
1 2
1 3
2 4
3 4

4 4
-1 -1 -1
1 4
1 2
1 3
2 3

3 2
-2 -1
2 3
1 3
 */