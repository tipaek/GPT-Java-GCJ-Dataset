import java.util.Scanner;

public class Solution {
  public static boolean solve(Scanner input, int B) {
    float[][] count = new float[B][2];
    for(int i = 1; i <= 150; ++i){
        int idx = i % B;
        System.out.println(idx + 1);
        int bit = input.next().charAt(0) - '0';
        ++count[idx][bit];
    }
    
    StringBuilder res = new StringBuilder();
    
    for(int i = 0; i < B; ++i){
        float prob1 = count[i][1] / (count[i][1] + count[i][0]);
        res.append((prob1 >= 0.5)? '1' : '0');
    }
    
    System.out.println(res.toString());
    
    return input.next().equals("Y");
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
