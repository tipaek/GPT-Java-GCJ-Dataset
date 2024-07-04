import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = new Integer(in.nextLine()).intValue();
    for (int i = 1; i <= t; i++) {
        String input = in.nextLine();
        String result = "";
        int current = 0;
        int prev = 0;
        char[] inputChar = input.toCharArray();
        for (int j = 0; j < inputChar.length; j++)  {
        	current = inputChar[j] - '0';
        	if (current > prev)  {
        		int diff = current - prev;
        		for (int k = 0; k < diff; k++)  {
        			result = result + "(";
        		}
        	}
        	else if (current < prev)  {
        		int diff = prev - current;
        		for (int k = 0; k < diff; k++)  {
        			result = result + ")";
        		}
        	}
			result = result + inputChar[j];
        	prev = current;
        }
        for (int z = 0 ; z < current; z++)  {
        	result = result + ")";
        }
        System.out.println("Case #" + i + ": " + result);
    }
    in.close();
  }
}