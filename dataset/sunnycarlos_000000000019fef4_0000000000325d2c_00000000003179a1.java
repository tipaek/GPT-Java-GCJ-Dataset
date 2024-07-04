import java.util.*;
import java.io.*;
import java.awt.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            int u=sc.nextInt();
            LinkedList<Node> list=new LinkedList<>();
            HashSet<Character> hs=new HashSet<>();
            for(int i=0;i<10000;i++){
                int m=sc.nextInt();String str=sc.next();
                list.add(new Node(m,str));
                for(int j=0;j<str.length();j++)hs.add(str.charAt(j));
            }
            sb.append("Case #"+test+": TPFOXLUSHB\n");
        }
        System.out.print(sb);
    }
}
class Node{
    int i;
    String r;
    public Node(int i,String r){
        this.i=i;
        this.r=r;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}