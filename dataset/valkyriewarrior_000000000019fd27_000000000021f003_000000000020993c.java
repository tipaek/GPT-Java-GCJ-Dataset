
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String args[]) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCaseNo = sc.nextInt();
    int printResultCounter = 1;
    for (int i = 0; i < testCaseNo; i++) {
      int n = sc.nextInt();
      String result = isVestigium(sc, n);
      String value = "Case #" + (printResultCounter++)+ ":"+ result;
      System.out.println(value);
    }
  }

  private static String isVestigium(Scanner sc, int num) {

    int[][] rowValues = new int[num][num];
    int[][] colValues = new int[num][num];
    for(int i=0; i<num; i++){
      for(int j=0; j<num ; j++) {
        int val = Integer.parseInt(sc.next());
        rowValues[i][j] =  val;
        colValues[j][i] =  val;
      }
    }

    int trace = 0;
    int rowCount = 0;
    int colCount = 0;

    for(int cnt=0; cnt<num; cnt++){
      trace += rowValues[cnt][cnt];

      List<Integer> row = Arrays.stream(rowValues[cnt]).boxed().collect(Collectors.toList());
      Set<Integer> rowSet = new HashSet<>(row);
      if(rowSet.size() < num ){rowCount++;}

      List<Integer> col = Arrays.stream(colValues[cnt]).boxed().collect(Collectors.toList());
      Set<Integer> colSet = new HashSet<>(col);
      if(colSet.size() < num ){colCount++;}

    }
    
    return trace + " " + rowCount + " " + colCount;
  }

}
