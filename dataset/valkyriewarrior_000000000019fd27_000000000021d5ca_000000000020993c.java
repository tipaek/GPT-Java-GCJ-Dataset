package Vestigium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    List<List<Integer>> input = new ArrayList<>();
    for(int i=0; i<num; i++){
      String line = sc.next();
      int[] numbers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
      input.add(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }

    int trace = 0;
    int rowCount = 0;
    int colCount = 0;

    for (int i = 0; i<= num-1; i++) {
      trace += input.get(i).get(i);
      Set<Integer> currentRow = new HashSet<>(input.get(i));
      List<Integer> colValues = new ArrayList<>();
      for(int j=0; j <= num-1; j++){
        colValues.add(input.get(j).get(i));
      }
      Set<Integer> currentCol = new HashSet<>(colValues);

      if(currentRow.size() < num) {rowCount++;}
      if(currentCol.size() < num) {colCount++;}
    }
    return trace + " " + rowCount + " " + colCount;
  }

}
