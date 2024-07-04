import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
 
import java.util.*;
import java.lang.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class Solution implements Runnable {

  static BufferedReader in;
  static PrintWriter out;

  public int[] getPermutation(int numberToSearch, int numberPos, int n) {
    int[] a=new int[n];

    int val=numberToSearch;
    for(int i=numberPos;i>=0;i--) {
      a[i]=val;
      val--;
      if(val<1) {
        val=n;
      }
    }

    val=numberToSearch;
    for(int i=numberPos;i<n;i++) {
      a[i]=val;
      val++;
      if(val>n) {
        val=1;
      }
    }

    return a;
  }
 
  public static void main(String[] args) {
      new Thread(null, new Solution(), "whatever", 1<<29).start();
  }
 
  public void run() {
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out, false);
 
    try
    {
      // in = new BufferedReader(new FileReader("class_treasurer.txt"));
      // out = new PrintWriter("output.txt");

      int t,x1,n,k,i,j;
      String str;
      String[] token;


      str=in.readLine().trim();
      token=str.split(" ");

      t=Integer.parseInt(token[0]);

      for(x1=0;x1<t;x1++) {
        str=in.readLine().trim();
        token=str.split(" ");

        n=Integer.parseInt(token[0]);
        k=Integer.parseInt(token[1]);

        if(k%n!=0 || k<n || k>(n*n)) {
          out.println(String.format("Case #%s: %s", x1+1, "IMPOSSIBLE"));
          continue;
        }
        
        out.println(String.format("Case #%s: %s", x1+1, "POSSIBLE"));

        int numberToSearch=k/n;
        for(i=0;i<n;i++) {
          int[] a=getPermutation(numberToSearch, i, n);

          out.print(a[0]);
          for(j=1;j<n;j++) {
            out.print(" "+a[j]);
          }
          out.println();
        }
      }

      out.flush();
      out.close();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}
