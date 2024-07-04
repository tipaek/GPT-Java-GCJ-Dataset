import java.util.*;

public class Solution{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    
    int numOfTestCases = Integer.valueOf(in.nextLine());
    for(int i = 0; i < numOfTestCases; i++){
      String digits = in.nextLine();
      String newDigits = nest(digits);
      System.out.println("Case #" + (i + 1) + ": " + newDigits);
    }
  }
  
  private static String nest(String str){
    return str.replaceAll("1", "(1)").replaceAll("\\)\\(", "");
  }
}