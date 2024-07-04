import java.util.*;
import java.io.*;

public class Solution{

  public static void solvef(final int i,final int x, final int y, final String s){
    int hLoc = y;
    int vLoc = x;

    for(int j=0;j<s.length();++j){
      char c = s.charAt(j);
      if(c == 'N') hLoc++;
      else if(c == 'S') hLoc--;
      else if(c == 'E') vLoc++;
      else if(c == 'W') vLoc--;
    }

    int result = Math.abs(vLoc) + Math.abs(hLoc);
    if(result>=s.length()){
      System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
    }
    else{
      System.out.println("Case #" + i + ": " + result);
    }

    
  }


  public static void main(final String[] args){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for(int i=1;i<=t;++i){
      int x = in.nextInt();
      int y = in.nextInt();
      String s = in.nextLine();
      solvef(i,x,y,s);

    }
  }

}
