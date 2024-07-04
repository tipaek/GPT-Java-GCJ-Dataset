import java.util.*;
import java.io.*;
public class Solution {
    
  public static void findSum(int n,int caseNum){
      int maxNum = 0;
      for(int i = 1 ; i <= n ; i ++){
          int sum = i*(i-1);
          sum= sum/2;
          if(sum <= n){
              maxNum = i-1;
          }
          else{
              break;
          }
      }
      System.out.println("Case #"+caseNum+":");
      int totalSum = 2;
      int lastRow = 0;
      System.out.println("1 1");
      if( n == 1){
          return;
      }
      System.out.println("1 2");
      for(int i = 3 ; i < maxNum+3 ;i++){
          if(totalSum+i-1 <= n){
              System.out.println(i+" 2");
              totalSum += i-1;
              lastRow = i;
          }
          else{
              break;
          }
      }
      for(int i = lastRow ; i >= 2 ; i--){
          if(totalSum >= n){
              break;
          }
          else{
              totalSum++;
              System.out.println(i+" 1");
          }
      }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
    //   System.out.println(n);
      findSum(n, i);
    }
  }
}