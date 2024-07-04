import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
public static int[] tin(String str, String tok, int k){
    String[] strs = str.split(tok);
    int n = strs.length;
    int[] rs = new int[n+1];
    for(int i=0;i<n;i++) rs[i]=Integer.parseInt(strs[i]);
    rs[n] = k;
    return rs;
}
public static String cal(ArrayList<String> g){
    int n=g.size(); 
    int[][] st = new int[n][3];
    for(int stx=0;stx<n;stx++) st[stx]=tin(g.get(stx), "\\s+", stx);
    char[] ass = new char[n];
    Arrays.sort(st, (a, b) -> {
                  if(a[0] == b[0]) return b[1]-a[1];
                  else return a[0] - b[0];
                });
    LinkedList<Integer> ca = new LinkedList<>();
    LinkedList<Integer> ja = new LinkedList<>();
    for(int i = 0; i < n; i++) {
      if(ca.size() == 0) ca.add(i);
      else if(ja.size() == 0) ja.add(i);
      else if(st[ca.peekLast()][1] < st[ja.peekLast()][1]) {
        if(st[i][0] < st[ca.peekLast()][1]) return "IMPOSSIBLE";
        ca.add(i);
      } else {
        if(st[i][0] < st[ja.peekLast()][1]) return "IMPOSSIBLE";
        ja.add(i);
      }
    }
    while(!ca.isEmpty()) ass[st[ca.poll()][2]] = 'C';
    while(!ja.isEmpty()) ass[st[ja.poll()][2]] = 'J';
    return new String(ass);
}
public static String cal(String g){
    String rs=null;
    int[] a = tin(g," ", 1);
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
      int maxl = Integer.parseInt(line);
      for(ec = 0; ec < maxl; ec++) {
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
