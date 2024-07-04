import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int x = in.nextInt();
          int y = in.nextInt();
          String step = in.nextLine();
          int len = step.length();
          int ans = 0;
          int temp = 0;
          //System.out.println(x +" " + y );
          for(int j = 1;j < len;j++){
              if(step.charAt(j) == 'N'){
                  y++;
              }else if(step.charAt(j) == 'S'){
                //System.out.println(x +" a" + y );
                  y--;
              }else if(step.charAt(j) == 'E'){
                  x++;
              }else{
                  x--;
              }
              ans++;
              int count = (Math.abs(x) + Math.abs(y));
              //System.out.println(x +" " + y + " " + count);
              if(ans >= count){
                System.out.println("Case #"+i+": "+ans);
                temp = 1;
                break;
              }
          }
          if(temp == 0)
              System.out.println("Case #"+i+": IMPOSSIBLE");
          
        }
        in.close();
    }
}