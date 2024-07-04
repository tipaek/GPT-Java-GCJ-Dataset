import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for (int i = 1; i <= t; ++i) {
      int activties = in.nextInt();
      
      boolean impossible = false;
      String result = "";
      int CAM[][] = new int[1002][2]; int c = 0;
      int JAM[][] = new int[1002][2]; int j = 0;
      
      for(int p = 0; p < activties; p++) {
        int start = in.nextInt();
        int end = in.nextInt();

        if(impossible) {
            continue;
        }

        if(hasWeightage(CAM, c, start, end)) {
            result += "C";
            c++;
        } 
        else if(hasWeightage(JAM, j, start, end)) {
            result += "J";
            j++;
        } 
        else {
            impossible = true;   
        }
        // System.out.print("");
        // System.out.println("---------------------");

      }

      System.out.println("Case #" + i +": "+ ((impossible) ? "IMPOSSIBLE" : result));
    }
    in.close();
  }

  private static boolean hasWeightage(int data[][], int cnt, int start, int end) {
    boolean result = true;

    // System.out.println("Time : " + start + ", " + end);
    // System.out.print("Before : ");
    // printData(data, cnt);
    for(int i=0; i< cnt; i++) {
        if(!(start > data[i][1] || (end-1) < data[i][0])) {
            result = false;
            break;
        }
    }
    if(result) {
        data[cnt][0] = start;
        data[cnt][1] = end - 1;
    }
    // System.out.print("After : ");
    // printData(data, cnt);

    return result;
  }

  private static void printData(int data[][], int cnt) {
    for(int i=0; i< cnt; i++) {
        System.out.print(data[i][0] + " " + data[i][1] + ",");
    }
    System.out.println();
  }
} 