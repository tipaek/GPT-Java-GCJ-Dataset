import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = new Integer(in.nextLine()).intValue();
    for (int i = 1; i <= t; i++) {
        String input = in.nextLine();
        String[] input2 = input.split(" ");
        int n = new Integer(input2[0]).intValue();
        int k = new Integer(input2[1]).intValue();
        String result = "IMPOSSIBLE";
        
        if (k % n == 0 && (k / n <= n))  {
        	result = "POSSIBLE";
        }
        System.out.println("Case #" + i + ": " + result);
        
        if (k % n == 0 && (k / n <= n))  {
        	int start = k / n;
        	String grid = "";
        	for (int x = 1; x <= n * n; x++)  {
        		if (x % n != 0)  {
            		grid += start + " ";
        		}
        		else  {
            		grid += start;
            		System.out.println(grid);
            		grid = "";
            		start = (start - 1) % n;
        		}
        		start = (start + 1) % n;
    			if (start == 0)  {
    				start = n;
    			}
        	}
        }
    }
    in.close();
  }
}