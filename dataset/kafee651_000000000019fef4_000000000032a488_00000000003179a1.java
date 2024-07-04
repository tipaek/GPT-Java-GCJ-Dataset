import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {

  public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int u = in.nextInt();
          int[][] hash = new int[26][2];
          for(int j = 1;j <= 10000;j++){
            int n = in.nextInt();
            String s = in.nextLine();
            if(s.length() == 2){
              int temp = (int)(s.charAt(1));
              hash[temp-'A'][0] += 1;
              if(hash[temp-'A'][1] != 0 && hash[temp-'A'][1] > n){
                hash[temp-'A'][1] = n;
              }else if(hash[temp-'A'][1] == 0){
                hash[temp-'A'][1] = n;
              }

            }
          }
            System.out.print("Case #"+i+": ");
            int max = 0;
            for(int j = 0;j < 10;j++){
              max = 0;
              int index = 0;
              for(int k = 0;k < 26;k++){
                if(max < hash[k][1]){
                  max = hash[k][1];
                  index = k;
                }
              }
              hash[index][1] = 0;
              char c = (char)(index + 'A');
              System.out.print(c);
            }
            System.out.println();

          }
        in.close();
    }
}