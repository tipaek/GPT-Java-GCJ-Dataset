import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int i = 1; i <=t; i++) {

      int count = in.nextInt();
      StringBuilder output = new StringBuilder();
      boolean impossible = false;

      LinkedHashMap<int[], Character> linkedHashMap = new LinkedHashMap();
      int[][] input = new int[count][2];

      for(int j = 0; j < count; j++) {
          input[j][0] = in.nextInt();
          input[j][1] = in.nextInt();
          linkedHashMap.put(input[j], '\0');
      }

      // Sort by ascending starting point
      Arrays.sort(input, Comparator.comparingInt((int[] arr) -> arr[0]).thenComparing((int[] arr) -> arr[1]));

      boolean isPrevC = true;
      int[] prevForC = input[0];
      int[] prevForJ = new int[]{-1,-1};
      linkedHashMap.put(input[0], 'C');

      for(int j = 1; j < count; j++) {
        int[] prev = input[j-1];
        int[] cur  =  input[j];

        if(prev[1] <= cur[0]) { //Non overlapping

          if(isPrevC) {
            linkedHashMap.put(cur, 'C');
            isPrevC = true;
            prevForC = cur;
          } else {
            linkedHashMap.put(cur,'J');
            isPrevC = false;
            prevForJ = cur;
          }
        }else {
           if(isPrevC && isFeasible(prevForJ, cur)) {
             linkedHashMap.put(cur,'J');
             isPrevC = false;
             prevForJ = cur;
           }else if( !isPrevC && isFeasible(prevForC, cur)){
             linkedHashMap.put(cur,'C');
             isPrevC = true;
             prevForC = cur;
           }else {
              impossible = true;
              break;
           }

        }
      }

      if(impossible) {
        System.out.println("Case #" + i + ": IMPOSSIBLE" );
      }else {
          Iterator itr = linkedHashMap.entrySet().iterator();
        while(itr.hasNext()) {
          Entry<int[][], Character> entry = (Entry<int[][], Character>) itr.next();
        //  output.append(entry.getKey());
          output.append(entry.getValue());
        }
        System.out.println("Case #" + i + ": " + output.toString());
      }

    }
  }

  public static boolean isFeasible(int[] prev, int[] cur) {

      if(prev[1] <= cur[0])
        return true;
      else
        return false;

  }
}
