import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int x = in.nextInt();
          int y = in.nextInt();
          StringBuilder directions = new StringBuilder();
          if(x % 2 == 0 && y % 2 == 0){
              System.out.println("Case #" + i + ": IMPOSSIBLE");
              continue;
          }
          if(x % 2 != 0 && y % 2 != 0){
              System.out.println("Case #" + i + ": IMPOSSIBLE");
              continue;
          }
          boolean xOdd = true;
          if(x <= 4 && y <= 4){
              if(x % 2 == 0){
                  xOdd = false;
              }
              if (xOdd){
                  if(y == 0) {
                      int times = x > 0 ? x / 2 + 1 : -x / 2 + 1;
                      char dir = x > 0 ? 'E' : 'W';
                      for(int j = 0; j < times; j++){
                          directions.append(dir);
                      }
                  } else if (y == 2){
                      char dir = x > 0 ? 'E' : 'W';
                      char notDir = x > 0 ? 'W' : 'E';
                      int times = x > 0 ? x / 2 + 1 : -x / 2 + 1;
                      if (times == 1){
                          directions.append(dir).append('N');
                      } else {
                          directions.append(notDir).append('N').append(dir);
                      }
                  } else if (y == -2) {
                      char dir = x > 0 ? 'E' : 'W';
                      char notDir = x > 0 ? 'W' : 'E';
                      int times = x > 0 ? x / 2 + 1 : -x / 2 + 1;
                      if (times == 1){
                          directions.append(dir).append('S');
                      } else {
                          directions.append(notDir).append('S').append(dir);
                      }
                  }else if (y == 4) {
                      char dir = x > 0 ? 'E' : 'W';
                      char notDir = x > 0 ? 'W' : 'E';
                      int times = x > 0 ? x / 2 + 1 : -x / 2 + 1;
                      if (times == 1){
                          directions.append(notDir).append(dir).append('N');
                      } else {
                          directions.append(dir).append(dir).append('N');
                      }
                  } else if (y == -4) {
                      char dir = x > 0 ? 'E' : 'W';
                      char notDir = x > 0 ? 'W' : 'E';
                      int times = x > 0 ? x / 2 + 1 : -x / 2 + 1;
                      if (times == 1){
                          directions.append(notDir).append(dir).append('S');
                      } else {
                          directions.append(dir).append(notDir).append('S');
                      }
                  }
              } else {
                  if(x == 0) {
                      int times = y > 0 ? y / 2 + 1 : -y / 2 + 1;
                      char dir = y > 0 ? 'N' : 'S';
                      for(int j = 0; j < times; j++){
                          directions.append(dir);
                      }
                  } else if (x == 2){
                      char dir = y > 0 ? 'N' : 'S';
                      char notDir = y > 0 ? 'S' : 'N';
                      int times = y > 0 ? y / 2 + 1 : -y / 2 + 1;
                      if (times == 1){
                          directions.append(dir).append('E');
                      } else {
                          directions.append(notDir).append('E').append(dir);
                      }
                  } else if (x == -2) {
                      char dir = y > 0 ? 'N' : 'S';
                      char notDir = y > 0 ? 'S' : 'N';
                      int times = y > 0 ? y / 2 + 1 : -y / 2 + 1;
                      if (times == 1){
                          directions.append(dir).append('W');
                      } else {
                          directions.append(notDir).append('W').append(dir);
                      }
                  }else if (x == 4) {
                      char dir = y > 0 ? 'N' : 'S';
                      char notDir = y > 0 ? 'S' : 'N';
                      int times = y > 0 ? y / 2 + 1 : -y / 2 + 1;
                      if (times == 1){
                          directions.append(notDir).append(dir).append('E');
                      } else {
                          directions.append(dir).append(dir).append('E');
                      }
                  } else if (x == -4) {
                      char dir = y > 0 ? 'N' : 'S';
                      char notDir = y > 0 ? 'S' : 'N';
                      int times = y > 0 ? y / 2 + 1 : -y / 2 + 1;
                      if (times == 1){
                          directions.append(notDir).append(dir).append('W');
                      } else {
                          directions.append(dir).append(notDir).append('W');
                      }
                  }
              }
          System.out.println("Case #" + i + ": " + directions);
          }
        }
      }
    }