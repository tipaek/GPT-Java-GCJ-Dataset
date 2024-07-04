import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int t = scanner.nextInt();
	    for (int a=1; a<=t; a++) {
	        String s = scanner.next();
	        int length = s.length();
	        StringBuilder sb = new StringBuilder();
	        int prev = -1;
	        for(int i=0; i<length; i++) {
	            int num = s.charAt(i) - '0';
	            if (prev == -1 || (num > prev)) {
	                for (int j=0; j<num; j++) {
	                    sb.append('(');
                    }
	                sb.append(num);
                }
	            if (num == prev) {
	                sb.append(num);
                }
	            if (num < prev) {
                    for (int j=0; j<prev-num; j++) {
                        sb.append(')');
                    }
                    sb.append(num);
                }
	            prev = num;
            }
	        for (int i = 0; i<prev; i++) {
	            sb.append(")");
            }
	        System.out.println("Case #" + a + ": " + sb.toString());
        }
    }
}