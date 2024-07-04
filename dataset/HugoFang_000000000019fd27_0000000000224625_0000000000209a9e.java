import java.util.Scanner;

public class Solution {
  public static boolean solve(Scanner input, int B) {
     int[][] count = new int[B][2];
     for(int i = 1; i <= 150; ++i){
         int idx = i % B;
         System.out.println(idx);
         String bit = input.next();
         ++count[idx][bit];
     }
     
     StringBuilder res = new StringBuilder();
     
     for(int i = 0; i < B; ++i){
         int total = count[idx][0] + count[idx][1];
         float prob_of_1 = (count[idx][1] + 0.0) / (total + 0.0);
         if(prob_of_1 >= 0.5){
             res.append('1');
         }else{
             res.append('0');
         }
     }
     
     System.out.println(res.toString());
     return input.next();
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      if(!solve(input, B)) break;
    }
  }
}
