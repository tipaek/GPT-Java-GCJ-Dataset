import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
    public class Solution {
    	
    	public static String nestingDepths(String s) {
    		StringBuilder sb=new StringBuilder("");
    		int left=0;
    		int first=s.charAt(0)-'0';
    		for(int i=0;i<first;i++) {
    			sb.append('(');
    			left++;
    		}
    		sb.append(first);
    		for(int i=1;i<s.length();i++) {
    			int next=s.charAt(i)-'0';
    			int prev=s.charAt(i-1)-'0';
    			int diff=0;
    			if(next>prev) {
    				diff=next-prev;
    				while(diff--!=0) {
    					sb.append('(');
    					left++;
    				}
    			}else if(next<prev) {
    				diff=prev-next;
    				while(diff--!=0) {
    					sb.append(')');
    					left--;
    				}
    			}
    			sb.append(next);
    		}
    		while(left--!=0) {
    			sb.append(')');
    		}
    		return new String(sb);
    	}
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int p = 1; p <= t; ++p) {
        	String curr=in.nextLine();
        	System.out.println("Case #" + p + ": " + Solution.nestingDepths(curr));
        }
      }
    }