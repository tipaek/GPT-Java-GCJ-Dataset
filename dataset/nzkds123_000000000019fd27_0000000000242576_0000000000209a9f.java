import java.io.*;
import java.util.*;
import java.lang.Math;


public class Solution {

	public static void main(String[] args) {		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//		Number of test cases
        int T = in.nextInt();
        
        int cur, next, diff = 0;
        
        int magicNum = 48; //  the diff btw character '0' to number 0 in binary (ASCII) 
        
        for (int i = 1; i < T+1; ++i) {
        	// Read string;
        	String num = in.next();
        	String result = "";
        	for (int j = 0; j < num.length(); ++j) {
        		//begin
        		if (j == 0 && num.charAt(j) != '0') {
        			for (int k = 0; k < num.charAt(j) - magicNum; ++k) {
        				result+='(';
        			}
        			result += num.charAt(j);
        		}
        		
        		//end
        		if (j == num.length() - 1 && num.charAt(j) - magicNum != 0) {
        			for (int k = 0; k < num.charAt(j) - magicNum; ++k) {
        				result+=')';
        			}
        		}
        		
        		//start from index 1 to length-1
        		if (j != num.length() - 1) {
        			cur = num.charAt(j) - magicNum;
        			next = num.charAt(j+1) - magicNum;
        			
        			if (cur == next) {
        				result += next;
        			}
    				else if (cur > next) {
    					diff = cur - next;
    					for (int k = 0; k < diff; ++k) {
    						result+= ')';
    					}
    					result+= next;
    				}
    				else if (cur < next) {
    					diff = next - cur;
    					for (int k = 0; k < diff; ++k) {
    						result+= '(';
    					}
    					result += next;
    				}
        		}
        	}
                       
            System.out.println("Case #"+ i + ": "+ result);
            
        }
        in.close();
	}

}
