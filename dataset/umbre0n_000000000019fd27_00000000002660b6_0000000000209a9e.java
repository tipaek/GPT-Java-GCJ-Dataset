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

      int t,x1,n,i,j;
      String str;
      String[] token;

      str=in.readLine().trim();
      token=str.split(" ");

      t=Integer.parseInt(token[0]);
      int b=Integer.parseInt(token[1]);

      for(x1=0;x1<t;x1++) {
        int[] bits=new int[b];
        for(i=0;i<10;i++) {
          System.out.println(i+1);

          str=in.readLine().trim();
          token=str.split(" ");
          bits[i]=Integer.parseInt(token[0]);
        }

        String res="";

        for(i=0;i<b;i++) {
          res+=bits[i];
        }

        System.out.println(res);

        str=in.readLine().trim();
        token=str.split(" ");

        String ans=token[0];

        if(ans.equals("Y")) {
          continue;
        }
        else {
          System.exit(0);
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
