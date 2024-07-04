import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
public static int[] tin(String str, String tok){
    char[] strs = str.toCharArray();
    int n = strs.length;
    int[] rs = new int[n];
    for(int i=0;i<n;i++) rs[i]=strs[i]-'0';
    return rs;
}
public static String cal(ArrayList<String> g){
    int n=g.size(); 
    String[] st = new String[n]; for(int stx=0;stx<n;stx++) st[stx]=g.get(stx);
    String rs=null;
    int i,j;
    return rs;
}
public static String cal(String g){
    String rs="";
    int[] a = tin(g, "");
    int n = a.length;
    int right = 0, pre = 0;
    for(int i = 0; i < n; i++) {
      if(i == 0){
        for(int j = 0; j < a[i]; j++) {rs += "(";right++;}
      }else if(a[i] != pre) {
        for(int j = 0; j < (int) Math.abs(a[i]-pre); j++){
          if(a[i] > pre) {rs += "("; right++;}
          else {rs += ")"; right--;}
        }
      }
      rs += a[i];
      pre = a[i];
    }
    while(right-- > 0) rs += ")";
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
