import java.util.Scanner;

public class Solution {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int A = input.nextInt();
    int B = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      solve(input, A, B);
    }
    input.close();
    System.exit(0);
  }

  public static void solve(Scanner input, int A, int B) {
    int wallSize = 2000000000;
    int wallRadius = wallSize/2;
    int queries = 0;

    for(int i=-8; i<=8; i++)
      for(int j=-8; j<=8; j++){
        System.out.println(i+" "+j);
        String response = input.next();
        validateResponse(input,response);
      }
    return;
  }

  private static void validateResponse(Scanner input, String response){
    if(response.equals("CENTER")){
      return;
    }

    if(response.equals("WRONG")){
      input.close();
      System.exit(0);
    }
  }
}