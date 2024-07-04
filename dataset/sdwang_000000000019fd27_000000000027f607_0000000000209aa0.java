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
    String[] st = new String[n]; for(int stx=0;stx<n;stx++) st[stx]=g.get(stx);
    String rs=null;
    int i,j;
    return rs;
}
public static int tra(int n,int r,int c, int[][] rv, int[][] cv, int[][] mat,int k,int acc) {
    int sum = 0, flag = 0;
    for(int i = 0; i < n; i++) {
        if(rv[r][i] > 0 || cv[c][i] > 0) continue;
        rv[r][i]++;
        cv[c][i]++;
        mat[r][c] = i+1;
        int pa = 0;
        if(r == c) pa = i+1;
        if(c+1 < n) sum = tra(n, r, c+1, rv, cv, mat, k, acc + pa);
        else if(r+1 < n) sum = tra(n, r+1, 0, rv, cv, mat, k, acc + pa);
        else sum = 0;
        rv[r][i]--;
        cv[c][i]--; 
        if(sum < 0 || pa + acc > k) continue;
        if(pa + acc == k && c == n-1 && r == n-1)  sum = n*n+n;
        if(sum == n*n + n) {flag = 1; break;}
        flag = 1;
    }
    if(flag == 1) return sum;
    else return -1;
}
public static String cal(String g){
    String rs=null;
    int[] a = tin(g,"\\s+");
    int n = a[0], k = a[1];
    int[][] ma = new int[n][n];
    int s = tra(n, 0, 0, new int[n][n], new int[n][n], ma, k, 0);
    if(s < n*n + n) return "IMPOSSIBLE";
    else rs = "POSSIBLE\n";
    for(int i = 0; i < n; i++)
      for(int j = 0; j < n; j++)
        if(j == 0) rs += ma[i][j];
        else if(j == n-1 && i < n-1) rs += " " + ma[i][j] + "\n";
        else rs += " " + ma[i][j];
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
      rs=cal(line);
      System.out.println("Case #"+i+": "+rs);
      i++;
    }
    br.close();
}
}
