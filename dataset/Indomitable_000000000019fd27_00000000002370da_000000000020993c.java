/*
  Copyright (c) 2019, Walmart Stores, Inc. All rights reserved.
 */



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
  Vestigium
  
  @author Deepak Singh
  
  @since 2020-04-04
  
 */
public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    int cases = 1;
    while(t>0){
      int n = sc.nextInt();

      int mat[][] = new int[n][n];

      int DiagonalSum = 0;
      int numRowDuplicate = 0;
      List<Set<Integer>> colList = new ArrayList<>();
      for(int i=0;i<n;i++){

        Set<Integer> rowSet = new HashSet<Integer>();
        for(int j=0;j<n;j++){
          if(i==0){
            Set<Integer> colSet = new HashSet<Integer>();
            colList.add(j,colSet);
          }
          Set<Integer> colSet = colList.get(j);

          mat[i][j] = sc.nextInt();
          rowSet.add(mat[i][j]);
          colSet.add(mat[i][j]);
          if(i==j){
            DiagonalSum+=mat[i][j];
          }
        }
        if(rowSet.size()<n){
          numRowDuplicate++;
        }
      }

      int numColDuplicate = 0;
      for (Set<Integer> set:colList
      ) {
        if(set.size()<n){
          numColDuplicate++;
        }
      }
      System.out.println("Case #"+cases+": "+DiagonalSum+" "+numRowDuplicate+" "+numColDuplicate);
      cases++;
      t--;
    }
  }
}
