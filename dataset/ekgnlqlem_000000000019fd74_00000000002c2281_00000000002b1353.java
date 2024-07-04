import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 1; i <= t; i++){
            int n = input.nextInt();
            N = n;
            HashMap<String, List<String>> graph = new HashMap();
            
            List<List<Integer>> triangle = pascal(n);
            int[][] dirs = {{-1,-1},{-1,0},{0,-1},{0,1},{1,0},{1,1}};
            for(int r = 1; r <= n; r++){
                for(int c = 1; c <= r; c++){
                    String pos = r+" "+c;
                    for(int[] d : dirs){
                        int x = r+d[0];
                        int y = c+d[1];
                        if(x >= 1 && x <= triangle.size() && y >= 1 && y <= triangle.get(x-1).size()){
                            graph.computeIfAbsent(pos, k -> new ArrayList<String>()).add(x+" "+y);
                        }
                    }
                }
            }
            
            /*
            for(Map.Entry<String, List<String>> entry : graph.entrySet()){
                System.out.println("current Pos: "+ entry.getKey());
                for(String arr : entry.getValue()){
                    System.out.println(arr);
                }
            }
            */
            
           
            for(int r = 1; r <= n; r++){
                for(int c = 1; c <= r; c++){
                    //System.out.println(r+" "+c);
                    
                    if(solve(graph,new HashSet<String>(),r+" "+c,triangle.get(r-1).get(c-1),triangle, new ArrayList<String>())){
                        r = n+1; break;
                    };
                }
            }
            System.out.println("Case #"+i+":");
            for(String s : res)
                System.out.println(s);
        }
    }
    
    private static ArrayList<String> res = new ArrayList(); 
    private static int N;
     
    public static boolean solve(HashMap<String, List<String>> graph, HashSet<String> set, String pos, int sum, List<List<Integer>> tri, ArrayList<String> path){
        //System.out.println(N+" "+pos+ " "+sum);
        path.add(pos);
        set.add(pos);
        if(sum == N && path.size() <= 500){
            res = new ArrayList<>(path);
            return true;
        }
        
        for(String s : graph.get(pos)){
            //System.out.println("\t"+s);
            if(set.contains(s)) continue;
            set.add(s);
            if(solve(graph, set, s, sum+tri.get(s.charAt(0)-'0'-1).get(s.charAt(2)-'0'-1), tri, path))
                return true;
            set.remove(s);
        }
        path.remove(pos);
        return false;
    }
        
    public static List<List<Integer>> pascal(int n){
        List<List<Integer>> tri = new ArrayList<List<Integer>>();
        
        tri.add(new ArrayList<Integer>());
        tri.get(0).add(1);
        
        for(int r = 1; r < n; r++){
            List<Integer> row = new ArrayList();
            List<Integer> prev = tri.get(r-1);
            
            row.add(1);
            
            for(int c = 1; c < r; c++){
                row.add(prev.get(c-1) + prev.get(c));
            }
            
            row.add(1);
            
            tri.add(row);
        }
        return tri;
    }
}
