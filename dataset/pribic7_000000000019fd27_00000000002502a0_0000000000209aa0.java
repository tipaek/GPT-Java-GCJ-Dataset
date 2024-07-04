//package Q2020.latinmatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int tt = 1; tt <= t; tt++) {
      boolean found = false;
      int n = sc.nextInt();
      int trace = sc.nextInt();
      List<String> ans = permute(generateBaseString(n));
      int[][] matrix = new int[n][n];
      for(int i = 0; i < n; i++) {
        int curVal = 1;
        for (int j = i; j < n + i; j++) {
          matrix[i][j % n] = curVal;
          curVal++;
        }
      }
      /*printMatrix(matrix);
      for(String s : ans) {
        System.out.println(s);
      }*/

      for (int i = 0; i < ans.size(); i++) {
        String currentState = ans.get(i); //bcda
        int[][] dummyMatrix = new int[n][n];
        for(int j = 0; j < n; j++) {
          char rowIdentifier = currentState.charAt(j); //b
          for(int k = 0; k < n; k++) {
            dummyMatrix[j][k] = matrix[rowIdentifier - 'a'][k]; 
          }
        }
        int traceFind = findTrace(dummyMatrix, trace);
        if(traceFind == 0) {
          System.out.println(String.format("Case #%d: POSSIBLE", tt));
          printMatrix(dummyMatrix);
          found = true;
          break;
        } 
        else if(traceFind == 1) {
          dummyMatrix = mirrorMatrix(dummyMatrix);
          System.out.println(String.format("Case #%d: POSSIBLE", tt));
          printMatrix(dummyMatrix);
          found = true;
          break;
        }
      }
      
      //permute columns
      for (int i = 0; i < ans.size() && !found; i++) {
        String currentState = ans.get(i); //bcda
        int[][] dummyMatrix = new int[n][n];
        for(int j = 0; j < n; j++) {
          char colIdentifier = currentState.charAt(j); //b
          for(int k = 0; k < n; k++) {
            dummyMatrix[k][j] = matrix[k][colIdentifier - 'a'];
          }
        }
        int traceFind = findTrace(dummyMatrix, trace);
        if(traceFind == 0) {
          System.out.println(String.format("Case #%d: POSSIBLE", tt));
          printMatrix(dummyMatrix);
          found = true;
          break;
        }
        else if(traceFind == 1) {
          dummyMatrix = mirrorMatrix(dummyMatrix);
          System.out.println(String.format("Case #%d: POSSIBLE", tt));
          printMatrix(dummyMatrix);
          found = true;
          break;
        }
      }
      
      
      if(!found) {
        System.out.println(String.format("Case #%d: IMPOSSIBLE", tt));
      }
    }
    sc.close();
    
  }

  private static int[][] mirrorMatrix(int[][] dummyMatrix) {
    int[][] mm = new int[dummyMatrix.length][dummyMatrix.length];
    for(int i = 0; i < dummyMatrix.length ; i ++) {
      for(int j = 0; j <dummyMatrix.length; j++) {
        mm[i][j] = dummyMatrix[i][dummyMatrix.length - 1 - j];
      }
    }
    return mm;
  }

  private static void printMatrix(int[][] matrix) {
    for(int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  static int findTrace(int[][] matrix, int trace) {
    int ans = 0;
    for(int i=0; i < matrix.length; i++) {
      ans += matrix[i][i];
    }
    if(ans == trace)
      return 0;
    ans = 0;
    for(int i=0; i < matrix.length; i++) {
      ans += matrix[i][matrix.length - 1 - i];
    }
    return ans == trace ? 1 : 2;
  }

  private static String generateBaseString(int n) {
    char[] s = new char[n];
    for(int i = 0; i < n; i++)
      s[i] = (char) ('a' + i);
    return new String(s);
  }

  private static List<String> permute(String str) {
    if(str.length() == 1)
      return Arrays.asList(str);
    List<String> ans = new ArrayList<>();
    for(int i = 0 ; i < str.length(); i++) {
      List<String> allStrings ;
      if(i + 1 == str.length())
       allStrings = permute(str.substring(0,i));
      else
        allStrings = permute(str.substring(0,i) + str.substring(i + 1));
      for(String s: allStrings)
        ans.add( str.toCharArray()[i] + s);
    }
    return ans;
  }
}

