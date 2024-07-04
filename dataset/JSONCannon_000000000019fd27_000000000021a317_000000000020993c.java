package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Vestigium {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numTests = scanner.nextInt();
    for(int t = 1; t <= numTests; t++){
      int N = scanner.nextInt();
      int trace = 0;
      Map<Integer, Set<Integer>> rowMap = new HashMap<>();
      Map<Integer, Set<Integer>> colMap = new HashMap<>();
      for(int i = 0; i < N; i++){
        rowMap.put(i, new HashSet<>());
        colMap.put(i, new HashSet<>());
      }
      for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
          int currentNum = scanner.nextInt();
          if(i == j){
            trace += currentNum;
          }
          rowMap.get(i).add(currentNum);
          colMap.get(j).add(currentNum);
        }
      }
      int numRepeatRows = 0;
      int numRepeatCols = 0;
      for(Map.Entry<Integer, Set<Integer>> entry : rowMap.entrySet()){
        if(entry.getValue().size() != N){
          numRepeatRows++;
        }
      }
      for(Map.Entry<Integer, Set<Integer>> entry : colMap.entrySet()){
        if(entry.getValue().size() != N){
          numRepeatCols++;
        }
      }
      System.out.println("Case #" + t + ": " + trace + " " + numRepeatRows + " " + numRepeatCols);
    }
  }
}
