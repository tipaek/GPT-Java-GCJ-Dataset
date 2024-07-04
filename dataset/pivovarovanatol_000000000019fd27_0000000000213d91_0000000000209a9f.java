
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
 
public class Solution {
    public static void solve(Scanner input, int caseNum, String s) {
    	String result = "";
    	result = s;
    	// idea - first pass -> we go over the string and look for duplicate digits. Then we add the number of opening and closing parenthesis equal to the digit around that group
    	// second pass - we go and recursively scan and remove pattern ")(" until we remove all of them
    	// return the result
    	StringBuilder res = new StringBuilder();
    	
    	char[] str = s.toCharArray();
    	int index  =0;
 
    	// step1
    	while (index < str.length) {
    		int count = 1;
    	   	char curr = str[index];
    		index++;
    	   	while (index < str.length && str[index] == curr) {
    	   		index++;
    	   		count++;
    	   	}
    	   	int depth = curr - '0';
    	   	addChar(res, '(', depth);
    	   	addChar(res, curr, count);
    	   	addChar(res, ')', depth);
    	}
    
    	result = res.toString();
    	
    	// Step2
    	result = result.replace(")(", "");
    	
        System.out.println("Case #" + caseNum + ": " + result);
    }
    
    static void addChar(StringBuilder sb, char ch, int count) {
    	while (count > 0) {
    		sb.append(ch);
    		count--;
    	}
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
         try {
 			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\CodeJam2020\\qalificationRound\\nestingDepth\\input.txt")));
 		} catch (FileNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
        	String s = input.next();
            solve(input, ks, s);
        }
        
        input.close();
        
    }
}
