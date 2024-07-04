import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
public static int[] tin(String str, String tok){
    String[] strs = str.split(tok);
    int n = strs.length;
    int[] rs = new int[n];
    for(int i=0;i<n;i++) rs[i]=Integer.parseInt(strs[i]);
    return rs;
}
public static String cal(ArrayList<String> g){
    int n=g.size(); 
    int[][] st = new int[n][n];
    for(int stx=0;stx<n;stx++) st[stx]=tin(g.get(stx), "\\s+");
    int c = 0, r = 0, sum = 0;
    for(int i = 0; i < n; i++){
        int[] vis = new int[n];
        for(int j = 0; j < n; j++) {
            if(vis[st[i][j]-1] > 0) {
                r++; break;
            }
            vis[st[i][j]-1]++;
        }
    }
    for(int i = 0; i < n; i++){
        int[] vis = new int[n];
        for(int j = 0; j < n; j++) {
            if(vis[st[j][i]-1] > 0) {
                c++; break;
            }
            vis[st[j][i]-1]++;
        }
    }
    for(int i = 0; i < n; i++) sum += st[i][i];
    return sum + " " + r + " " + c;
}
public static String cal(String g){
    String rs=null;
    int[] a = tin(g," ");
    int n = a.length;
    int i,j;
    return rs;
}
public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int i=1;
    String rs=null;
    String line=null;
    ArrayList<String> al = new ArrayList<String>();
    int ec=0;
    String tl = null;
    while(i<=n){
      line=br.readLine();
      int maxe = Integer.parseInt(line);
      for(ec = 0; ec < maxe; ec++){
        line = br.readLine();
        al.add(line);
      }
      rs=cal(al);
      al.clear();
      System.out.println("Case #"+i+": "+rs);
      i++;
    }
    br.close();
}
}
