import java.util.*;
import java.io.*;
import java.util.stream.IntStream; 
import java.util.stream.Collectors;
import java.lang.Math;

public class Solution{
  
  public static void main(String[] args) throws IOException {
    Solution fd = new Solution();
    Scanner input= new Scanner(System.in);
    int testN = input.nextInt();
    for(int i = 0; i < testN; i++){
      int numberT = input.nextInt();
      int currentSum = 0;
      double r = 1;
      double k = 1;
      int test = i + 1;
      System.out.println("Case #" + test + ":");
      while(currentSum <= numberT){
        currentSum = currentSum + (int)calPascal(r, k);
        System.out.println((int)r + " " + (int)k);
        if(currentSum < numberT / 3){
          if(Math.pow(-1, (double)r + 1) == 1){
            k += 1;
          }
          r += 1;
          continue;
        }
        else if(k == r){
          k += 1;
          r += 1;
          continue;
        }
        else{
          k += 1;
        }
      }
    }
  }
  
  public static double calPascal(double r, double k){
    double result = 1.0;
    for(int s = 0; s < k-1; s++){
      result = result * (r - 1 - s) / (s + 1);
    }
    return result;
  }
}
