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
        	if (current == 0)  {
        		if (prev == 1)  {
        			result = result + ")" + inputChar[j];
        		}
        		else  {
            		result = result + inputChar[j];
        		}
        	}
        	else if (current == 1)  {
        		if (prev == 0)  {
            		result = result + "(" + inputChar[j];
        		}
        		else  {
            		result = result + inputChar[j];
        		}
        	}
        	prev = current;
        }
        if (current == 1)  {
        	result = result + ")"
;        }
        System.out.println("Case #" + i + ": " + result);
    }
    in.close();
  }
}