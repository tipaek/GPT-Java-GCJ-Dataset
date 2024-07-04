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

  public static int getManhattanDistance(int x1, int y1, int x2, int y2) {
    return (int)(Math.abs(x2-x1)+Math.abs(y2-y1));
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

      int t,x1,n,i;
      String str;
      String[] token;

      str=in.readLine().trim();
      token=str.split(" ");

      t=Integer.parseInt(token[0]);

      for(x1=0;x1<t;x1++) {
        str=in.readLine().trim();
        token=str.split(" ");
        int x=Integer.parseInt(token[0]);
        int y=Integer.parseInt(token[1]);
        str=token[2];
        n=str.length();

        boolean possible=false;
        int minuteOfMeeting=-1;

        for(i=0;i<n;i++) {
          char direction=str.charAt(i);
          if(direction=='N') {
            y+=1;
          } else if(direction=='S') {
            y-=1;
          } else if(direction=='E') {
            x+=1;
          } else {
            x-=1;
          }

          int dist=getManhattanDistance(0, 0, x, y);
          int minute=i+1;

          if(dist==minute) {
            possible=true;
            minuteOfMeeting=minute;
            break;
          } else if(dist>minute) {
            continue;
          } else {
            possible=true;
            minuteOfMeeting=minute;
            break;
          }
        }

        if(possible) {
          out.println(String.format("Case #%s: %s", x1+1, minuteOfMeeting));
        } else {
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
