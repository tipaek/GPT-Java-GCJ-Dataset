import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int t=1; t<=tests; t++) {
        	 String s = in.next();
             System.out.print("Case #"+t+": ");
             
             int count = 0;
             for(int i=0; i<s.length(); i++) {
            	 int el = s.charAt(i)-'0';
            	 if(el>count) {
            		 for(int j=0; j<el-count; j++) {
            			 System.out.print("(");
            		 }
            	 } else {
            		 for(int j=0; j<count-el; j++)
            			 System.out.print(")");
            	 }
            	 count = el;
        		 System.out.print(el);
             }
             for(int j=0; j<count; j++)
    			 System.out.print(")");
             System.out.println();
        }
	}
}
