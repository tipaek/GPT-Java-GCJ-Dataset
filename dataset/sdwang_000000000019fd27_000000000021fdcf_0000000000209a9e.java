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
public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String sss =  br.readLine();
    String[] tp =sss.split(" ");
    int nk = Integer.parseInt(tp[0]);
    int bsize = Integer.parseInt(tp[1]);
    int ik=1;
    String line=null;
    while(ik<=nk){
      int[] left = new int[10];
      int[] right = new int[10];
      if(bsize > 10){
      for(int i = 0; i < 10; i+=2) {
          System.out.println(i+1);
          line = br.readLine();
          int l = Integer.parseInt(line);
          System.out.println(20-i);
          line = br.readLine();
          int r = Integer.parseInt(line);
          right[i] = ( l ^ r );
      }
      for(int i = 1; i < 10; i+=2) {
          System.out.println(i+1);
          line = br.readLine();
          int l = Integer.parseInt(line);
          System.out.println(20-i);
          line = br.readLine();
          int r = Integer.parseInt(line);
          right[i] = ( l ^ r );
      }
      }
      for(int i = 0; i < 10; i++) {
          System.out.println(i+1);
          left[i] = Integer.parseInt(br.readLine());
      }
      String now = "", nowr = "";
      for(int i = 0; i < 10; i++) now += left[i];
      if(bsize > 10)
        for(int i = 0; i < 10; i++)
          if(right[i] == 1) nowr = (left[i] ^ 1) + nowr;
          else nowr = left[i] + nowr;
      now += nowr;
      System.out.println(now);
      String rss = br.readLine();
      if(rss.equals("N")) break;
      ik++;
    }
    br.close();
}
}
