import java.util.*;
import java.io.*;
public class Solution {
public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int m = in.nextInt();
      int p=(int)Math.ceil(((double)Math.log(Math.abs(n)+Math.abs(m)))/Math.log(2.0));
      //System.out.println(p+" "+n);
      String res=find(n,m,0,0,0,p,"");
      if(res!=null)
      System.out.println("Case #" + i + ": " + res);
      else
      System.out.println("Case #" + i + ": " +"IMPOSSIBLE");
    }
  }
  static String find(int n,int m,int i,int x,int y,int p,String temp){
      if(i==p){
         // System.out.println(temp+" "+x+" "+y+" "+n+" "+m);
          if(n==x&&y==m){return temp;}
          return null;
      }
      String res=null;
     // System.out.println(1<<(i-1));
       res=find(n,m,i+1,x,(1<<(i))+y,p,temp+'N');
      if(res!=null)return res;
        res=find(n,m,i+1,x,y-(1<<(i)),p,temp+'S');
      if(res!=null)return res;
       res=find(n,m,i+1,x-(1<<(i)),y,p,temp+'W');
      if(res!=null)return res;
      res=find(n,m,i+1,x+(1<<(i)),y,p,temp+'E');
      if(res!=null)return res;
     
      return res;
  }
}