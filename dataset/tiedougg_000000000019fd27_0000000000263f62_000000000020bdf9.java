import java.util.*;
import java.io.*;
public class Solution {
    public static class Node{
        int s;
        int e;
        int idx; 
        char assign;
        public Node(int s, int e, int idx)
        {
            this.s = s;
            this.e = e;
            this.idx = idx;
        }
        public void setJ()
        {
            assign = 'J';
        }
        public void setC()
        {
            assign = 'C';
        }
        public char getAssign()
        {
            return assign;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Node> list = new ArrayList<>();
            for(int j = 0; j<n; j++){
                int s = in.nextInt();
                int e = in.nextInt();
                list.add(new Node(s, e, j));
            }
            System.out.println("Case #" + i + ": " + solve(list));
        }
    }
    
    private static String solve(List<Node> list)
    {
        Collections.sort(list, (x,y) ->  x.s - y.s);
        list.get(0).setC();
        int cEndTime = list.get(0).e;
        int jEndTime = 0;
        
        for(int i = 1; i< list.size(); i++)
        {
            Node node = list.get(i);
            int startTime = node.s;
            if(startTime>=cEndTime){
                node.setC();
                cEndTime = node.e;
            }
            else if(startTime>=jEndTime)
            {
                node.setJ();
                jEndTime = node.e;
            }
            else{
                return "IMPOSSIBLE";
            }
        }
        
        Collections.sort(list, (x,y) ->  x.idx - y.idx);
        StringBuilder sb = new StringBuilder();
        for(Node n: list)
        {
            sb.append(n.getAssign());            
        }
        return sb.toString();
    }
}
