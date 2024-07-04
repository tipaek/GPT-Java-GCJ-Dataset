import java.util.Scanner;

public class Solution {
  public static void solve(Scanner input, int b) {
    boolean[] data = new boolean[b];
    if(b == 10) {
    		for(int i = 1; i <= 10; i ++) {
    			System.out.println(i);
    			String s = input.next();
    			data[i] = Integer.parseInt(s) == 1;
    		}
    		String answer = "";
    		for(int i = 0; i < 10; i++) {
    			answer += data[i]?1:0;
    		}
    		System.out.println(answer);
    		if(input.next().equals("Y")) {
    			return;
    		}
    		else {
    			return;
    		}
    }
    else {
    		System.out.println("00000000000000000000");
    		input.next();
    		return;
    }
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = Integer.parseInt(input.next());
    int B = Integer.parseInt(input.next());
    for (int ks = 1; ks <= T; ks++) {
      solve(input, B);
    }
  }
}
