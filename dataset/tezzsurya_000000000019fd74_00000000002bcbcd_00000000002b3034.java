import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++) {
            int n = Integer.parseInt(br.readLine().trim());
            LinkedList<String> list = new LinkedList<>();
            boolean noMatch = false;
            for(int i=0;i<n;i++) {
                String[] curr = br.readLine().trim().split("\\*");
                if(i==0) {
                    list.add(curr[0]);
                    list.add(curr[1]);
                }
            
                String res = f(list.getFirst(), curr[0]);
                if(res == null) {
                    noMatch = true;
                    break;
                }
                list.set(0, res);
            
            
                res = g(list.getLast(), curr[curr.length - 1]);
                if(res == null) {
                    noMatch = true;
                    break;
                }
                list.set(list.size() - 1, res);
                
                
            }
            sb.append("Case #").append(t).append(": ");
            if(noMatch) {
                sb.append("* ");
            } else {
                for(String l : list) {
                    sb.append(l);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static String f(String left, String target) {
        char[] l = left.toCharArray();
        char[] t = target.toCharArray();
        for(int i=0;i<l.length && i<t.length; i++) {
            if(l[i] != t[i]) return null;
        }
        return l.length >= t.length ? left : target ;
    }

    static String g(String right, String target) {
        char[] l = right.toCharArray();
        char[] t = target.toCharArray();
        for(int i=0;i<l.length && i<t.length; i++) {
            if(l[l.length - i - 1] != t[t.length - i - 1]) return null;
        }
        return l.length >= t.length ? right : target ;
    }
}