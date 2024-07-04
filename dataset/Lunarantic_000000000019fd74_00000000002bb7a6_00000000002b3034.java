import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static String clear(String input) {
		return input.replaceAll("\\*", "");
	}
	
	public static String regexStart(String input) {
		return "^" + input.replaceAll("\\*", "[A-Z*]*") + "$";
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(in.nextLine());
            String last = "*";
            String prev = "[A-Z*]*$";
            String temp;
            String curr;
            boolean st = false;
            
            for (int j = 0; j < n; ++j) {
            	temp = in.nextLine();
            	if (st) continue;
            	curr = regexStart(temp);
            	
            	if (clear(last).matches(curr)) {
            	} else if (clear(temp).matches(prev)) {
            		last = temp;
            		prev = curr;
            	} else {
            		if (last.indexOf('*') == last.length()-1 && temp.indexOf('*') == 0) {
            			last += temp;
            			prev = "^" + clear(last) + "[A-Z*]*" + clear(temp) + "$";
            		} else if (last.indexOf('*') == 0 && temp.indexOf('*') == temp.length()-1) {
            			last = temp + last;
            			prev = "^" + clear(temp) + "[A-Z*]*" + clear(last) + "$";
            		} else {
	            		last = "*";
	            		st = true;
            		}
            	}
            }
            if (st) {
            	System.out.println("Case #" + i + ": *");
            } else {
            	System.out.println("Case #" + i + ": " + clear(last));
            }
        }
        in.close();

        System.exit(0);
    }
}
