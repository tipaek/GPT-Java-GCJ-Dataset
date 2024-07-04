import java.util.Scanner;

public class Solution {
  public static void solve(Scanner input, int B) {
    int k = 1;
    int i = 1;
    String result = "";
    while(k <= B){
      System.out.println(k);
      String digit = input.next();
      if(i%10 != 1){
          result += digit;
          k++;
      }
      i++;
    }
    
    System.out.println(result);
    String s = input.next();
    
    return;
    
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    String[] data = input.nextLine().split(" ");
    int T = Integer.parseInt(data[0]);
    int B = Integer.parseInt(data[1]);
      
    for (int ks = 1; ks <= T; ks++) {
      solve(input, B);
    }
  }
}