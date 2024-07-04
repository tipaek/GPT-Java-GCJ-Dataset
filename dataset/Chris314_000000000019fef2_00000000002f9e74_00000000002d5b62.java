  import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String arr[][] = new String[][]{{"E","W"},{"N","S"}};
        for (int i = 1; i <= t; ++i) {
            int coordinates[] = new int[2];
          coordinates[0] = in.nextInt();
          coordinates[1]= in.nextInt();
          int k = odd(coordinates);
      
       
          if (k < 0) {
              System.out.println("Case #" + i + ": IMPOSSIBLE");
              continue;
          }
             String ans = "";
          while (coordinates[0] != 0 || coordinates[1] != 0) {
      
              if (coordinates[0] == 0 && coordinates[1] == 1) {
                  ans += "N";
                  break;
                 
              }
               if (coordinates[0] == 0 && coordinates[1] == -1) {
                  ans += "S";
                  break;
                 
              }
               if (coordinates[0] == 1 && coordinates[1] == 0) {
                  ans += "E";
                  break;
                 
              }
               if (coordinates[0] == -1 && coordinates[1] == 0) {
                  ans += "W";
                  break;
                 
              }
           //step in direction of k, need to pick which way
           int other = (k+1)%2;
           if (mod2(coordinates[other]/2) == 1) {
               if (mod2((coordinates[k]+1)/2) == 0) {
                   ans += arr[k][1];
               }
               else {
                   ans += arr[k][0];
               }
              coordinates[k] = (coordinates[k]+1)/2 - mod2(((coordinates[k]+1)/2));
           }
           else {
                if (mod2((coordinates[k]+1)/2) == 1) {
                   ans += arr[k][1];
               }
               else {
                   ans += arr[k][0];
               }
               coordinates[k] = (coordinates[k]-1)/2 + mod2(((coordinates[k]-1)/2 + 1));
           }
      
           coordinates[other] /= 2;
           k = odd(coordinates);
          }
          System.out.println("Case #" + i + ": " +ans);
        }
      }
    
  public static int odd(int arr[]) {
      if (mod2(arr[0]) == 1 && mod2(arr[1]) == 0)
        return 0;
    if (mod2(arr[1] )== 1 && mod2(arr[0]) == 0)
    return 1;
    return -1;
  }
  public static int mod2(int x) {
      if (x % 2 > 0) 
      return (x % 2);
      else return -(x % 2);
  }
    }