import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int t=1;t<=T;t++){
        	String s = sc.nextLine();
        	StringBuilder sb = new StringBuilder();
        	int open = 0;
        	for(int i=0;i<s.length();i++){
        		int num = s.charAt(i) - '0';
        		if (num > open) {
        			for(int j=0;j<(num-open);j++) sb.append("(");
        		}
        		else if (num < open) {
        			for(int j=0;j<(open-num);j++) sb.append(")");
        		}
        		open = num;
    			sb.append(num);
        	}
        	for(int i=0;i<open;i++) sb.append(")");
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}