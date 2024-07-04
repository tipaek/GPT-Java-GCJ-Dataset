import java.util.Scanner;

public class Solution {
  public static boolean solve(Scanner input, int B) {
     int[][] count = new int[B][2];
     for(int i = 1; i <= 150; ++i){
         int idx = i % B;
         System.out.println(idx + 1);
         char bit = input.next().charAt(0);
         ++count[idx][bit - '0'];
     }
     
     StringBuilder res = new StringBuilder();
     
     for(int i = 0; i < B; ++i){
         int total = count[i][0] + count[i][1];
         double prob_of_1 = (count[i][1] + 0.0) / (total + 0.0);
         if(prob_of_1 >= 0.75){
             res.append('1');
         }else{
             res.append('0');
         }
     }
     
     System.out.println(res.toString());
     return input.next().equals("N")? false : true;
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
