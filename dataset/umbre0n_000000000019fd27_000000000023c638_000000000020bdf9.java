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

  static int minInversionsNeeded;
  static boolean[][] isOpenCell;
  static int[][] ways;
 
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

      for(x1=0;x1<t;x1++) {
        str=in.readLine().trim();
        token=str.split(" ");

        n=Integer.parseInt(token[0]);

        char[] names=new char[] {'C', 'J'};

        int[][] activities=new int[n][3];

        for(i=0;i<n;i++) {
          str=in.readLine().trim();
          token=str.split(" ");

          int startTime=Integer.parseInt(token[0]);
          int endTime=Integer.parseInt(token[1]);
          activities[i][0]=startTime;
          activities[i][1]=endTime;
          activities[i][2]=i;
        }

        Arrays.sort(activities, new Comparator<int[]>(){
          public int compare(int[] c1,int[] c2) {
            int t1=c1[0]-c2[0];
            if(t1!=0)
              return t1;
            int t2=c1[1]-c2[1];
              return t2;
          }
        });

        boolean possible=true;
        int[] whoDoes=new int[n];
        whoDoes[0]=0;

        int[] partnerFreeingTime=new int[2];
        partnerFreeingTime[whoDoes[0]]=activities[0][1];

        for(i=1;i<n;i++) {
          if(activities[i][0]>=activities[i-1][1]) {
            whoDoes[i]=whoDoes[i-1];
          }
          else {
            if(partnerFreeingTime[1-whoDoes[i-1]]>activities[i][0]) {
              possible=false;
              break;
            }
            else {
              whoDoes[i]=1-whoDoes[i-1];
            }
          }
          partnerFreeingTime[whoDoes[i]]=activities[i][1];
        }

        String res="";

        for(i=0;i<n;i++) {
          res+=names[0];
        }

        StringBuilder resBuilder = new StringBuilder(res);

        for(i=0;i<n;i++) {
           resBuilder.setCharAt(activities[i][2], names[whoDoes[i]]);
        }

        if(possible) {
          out.println(String.format("Case #%s: %s", x1+1, resBuilder.toString()));
        }
        else {
          out.println(String.format("Case #%s: %s", x1+1, "IMPOSSIBLE"));
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
