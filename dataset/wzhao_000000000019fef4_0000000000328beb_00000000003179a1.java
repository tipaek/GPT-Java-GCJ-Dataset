import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
        char c;
        double d;
        public Node(char c, double d){
            this.c = c;
            this.d = d;
        }
        public int compareTo(Node n){
            return Double.compare(n.d, this.d);
        }
    }

public class codejam9{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t < T; t++){
            output.print("Case #" + (t+1) + ": ");
            input.readLine();
            double[] a = new double[26];
            boolean[] b = new boolean[26];
            for(int i = 0; i < 1e4; i++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                st.nextToken();
                String s = st.nextToken();
                b[s.charAt(0)-'A'] = true;
                for(int j = 0; j < s.length(); j++) a[s.charAt(j)-'A'] += Math.pow(10,s.length()-j-1);
            }
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            String ans = "";
            for(int i = 0; i < 26; i++){
                if(a[i]!=0){
                    if(!b[i]) ans += (char)('A' + i);
                    else pq.add(new Node((char)('A'+i), a[i]));
                }
            }
            for(int i = 0; i < 9; i++) output.print(pq.poll().c);
            output.println();
        }
        output.flush();
        output.close();
    }
}