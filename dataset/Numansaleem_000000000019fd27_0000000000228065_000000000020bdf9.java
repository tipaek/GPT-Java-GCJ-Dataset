 import java.util.*;
 import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int nu=1;nu<=t;nu++){
      int n = in.nextInt();
      int[][] a=new int[n][3];
      for(int i=0;i<n;i++){
          for(int j=0;j<2;j++){
              a[i][j]=in.nextInt();
          }
          a[i][2]=i;
      }
      Arrays.sort(a,(p,q)->{
      if(p[0]!=q[0])return p[0]-q[0];
      return p[1]-q[1];
      });
    //   for(int[] re:a )System.out.println(Arrays.toString(re));
      char res[]=new char[n];
      String p="";
      int c=-1,j=-1;
      for(int i=0;i<n;i++){
      if(c==-1||a[c][1]<=a[i][0]){
      c=i;
      res[a[i][2]]='C';
      //System.out.println(Arrays.toString(res));
      }else if(j==-1||a[j][1]<=a[i][0]){
      j=i;
       res[a[i][2]]='J';
       }else{
       p="IMPOSSIBLE";
       break;
       }}
       if(p.length()==0){
           p=new String(res);
       }
      System.out.println("Case #" + nu + ": " + (p));
    }
  }


}