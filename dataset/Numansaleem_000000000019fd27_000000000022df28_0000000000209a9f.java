import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    in.nextLine();
    // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int nu=1;nu<=t;nu++){
      String str = in.nextLine();
      int[] a=new int[str.length()];
      for(int i=0;i<str.length();i++){
              a[i]=str.charAt(i)-'0';
      }
      String res=find(str,0,str.length()-1,a);
      System.out.println("Case #" + nu + ": " + (res));
    }
  }
  static String find(String str,int s,int e,int[] a){
     // System.out.println(s+"  "+e+"  "+Arrays.toString(a));
      if(s>e)return "";
      if(s==e){
          StringBuilder res=new StringBuilder();
          for(int i=0;i<a[s];i++){
              res.append('(');
          }
          res.append(str.charAt(s));
            for(int i=0;i<a[s];i++){
              res.append(')');
          }
          return res.toString();
      }
      StringBuilder res=new StringBuilder();
      ArrayList<Integer> find=new ArrayList();
      int min=Integer.MAX_VALUE;
      for(int i=s;i<=e;i++){
          if(a[i]<min){
              min=a[i];
              find.clear();
              find.add(i);
          }else if(a[i]==min){
              find.add(i);
          }
      }
      for(int i=s;i<=e;i++){
          a[i]-=min;
      }
      for(int i=0;i<Math.min(min,10);i++)res.append('(');
      if(find.size()>0){
          res.append(find(str,s,find.get(0)-1,a));res.append(str.charAt(find.get(0)));
      }
      for(int i=1;i<find.size();i++){
        //    System.out.println("here"+find+" %%%%"+min+" "+find.size());
          res.append(find(str,find.get(i-1)+1,find.get(i)-1,a));
          res.append(str.charAt(find.get(i)));
      }
        if(find.size()>0){
          res.append(find(str,find.get(find.size()-1)+1,e,a));
      }
       for(int i=0;i<min;i++)res.append(')');
      return res.toString();
  }
}