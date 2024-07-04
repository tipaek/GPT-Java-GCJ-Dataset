import java.util.*;

public class Solution {
  public static boolean solve(Scanner input, int A, int B) {
    int R = (int)((A+B)/2);
    
    int low = R - (int)Math.pow(10, 9);
    int high = (int)Math.pow(10, 9) - R;
    
    int count = 0;
    
    for (int x = low; x<=high; x++) {
        for (int y=low; y<=high; y++) {
            System.out.println(x + " " + y);
            String s = input.next();
            if (!s.equals("CENTER"))
                continue;
        }
    }
    return s.equals("CENTER");
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int A = input.nextInt();
    int B = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      if (!solve(input, A, B)) break;
    }
    
    System.exit(0); 
  }
}