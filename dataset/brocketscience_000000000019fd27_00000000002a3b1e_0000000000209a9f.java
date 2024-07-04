/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Answer solution = new Answer();
		solution.solve(in, out);
		out.flush();
		out.close();
	}
}

class Answer {
    public void solve(Scanner in, PrintWriter out) {
        int test_cases = in.nextInt();
        in.nextLine();
        for (int test_case = 0; test_case < test_cases; test_case++) {
            String s = in.nextLine();
            StringBuilder ans = new StringBuilder();
            
            int currentOpenParens = 0;
            int currentClosedParens = 0;
            
            for (int i =0; i< s.length(); i++) {
                int number = Character.getNumericValue(s.charAt(i));
                
                if (number == currentOpenParens) {
                    ans.append(s.charAt(i));
                    continue;
                }
                
                if (number < currentOpenParens) {
                    while (number < currentOpenParens) {
                        ans.append(")");
                        currentOpenParens -= 1;
                    }
                    ans.append(s.charAt(i));
                    continue;
                }
                
                if (number > currentOpenParens) {
                    while (currentOpenParens < number) {
                        ans.append("(");
                        currentOpenParens += 1;
                    }
                    ans.append(s.charAt(i));
                    continue;
                }
            }
            
            if (currentOpenParens > 0) {
                while (currentOpenParens > 0) {
                    ans.append(")");
                    currentOpenParens -= 1;
                }
            }
            
            out.println(String.format("Case #%d: %s", (test_case+1), ans.toString()));
        }
    }
}