import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution{

  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCaseNo = Integer.parseInt(br.readLine());

    int bracket = 0;
    for(int i = 1 ; i <= testCaseNo ; i++){
      System.out.print("Case #"+i+":");
      String numbers = br.readLine();

      for(int j = 0 ; j < numbers.length() ; j++){
        int number = numbers.charAt(j)-'0';

        if(number < bracket){
          while(number != bracket){
            System.out.print(")");
            bracket--;
          }
        }else if(number > bracket){
          while(number != bracket){
            System.out.print("(");
            bracket++;
          }
        }
        System.out.print(""+number);
      }

      while(bracket> 0){
        System.out.print(")");
        bracket--;
      }
      System.out.println();
      bracket = 0;
    }
  }
}
