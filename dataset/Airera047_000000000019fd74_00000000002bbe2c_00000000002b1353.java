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
      int r = 1;
      int k = 1;
      int test = i + 1;
      System.out.println("Case #" + test + ":");
      while(currentSum < numberT){
        currentSum = currentSum + calPascal(r, k);
        System.out.println(r + " " + k);
        if(currentSum < numberT / 2){
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
  
  public static int calPascal(int r, int k){
    int result = 1;
    for(int s = 0; s < k-1; s++){
      result = result * (r - 1 - s) / (s + 1);
    }
    return result;
  }
}
