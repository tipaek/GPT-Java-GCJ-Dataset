import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int q=1;q<=t;q++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Pair> a = new ArrayList<>(); 
            for(int i=0;i<n;i++) {
                String[] s = br.readLine().split(" ");
                a.add(new Pair(Integer.parseInt(s[0]), Integer.parseInt(s[1]), i));
            }
            Collections.sort(a);
            StringBuilder sb = new StringBuilder();
            int x=0, y=0;
            boolean flag = false;
            boolean[] v = new boolean[n];
            for(Pair p : a) {
                if(p.x >= x) {
                    v[p.i] = true;
                    x = p.y;
                } else if(p.x >= y) {
                    y = p.y;
                } else {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                pw.println("Case #"+q+": IMPOSSIBLE");
            } else {
                for(int i=0;i<n;i++) {
                    sb.append(v[i] ? "C" : "J");
                }
                pw.println("Case #"+q+": "+sb.toString());
            }
        }
        pw.close();
        br.close();
    }
    static class Pair implements Comparable<Pair> {
        int x, y, i;
        Pair(int a, int b, int c) {
            x=a;y=b;i=c;
        }
        public int compareTo(Pair p) {
            if(x==p.x) {
                if(y==p.y) {
                    return i-p.i;
                }
                return y-p.y;
            }
            return x-p.x;
        }
    }
}