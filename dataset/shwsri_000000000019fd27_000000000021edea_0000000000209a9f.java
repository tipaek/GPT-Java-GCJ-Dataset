import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
    	int paran_count,position=-1;
    	String paranthesis1 ="";
    	String input_digit = in.nextLine();
    	char digits[] = input_digit.toCharArray();
    	int digit_val[] = new int[input_digit.length()];
    	for(int j =0;j<input_digit.length();j++) {
    		digit_val[j] = Integer.parseInt(Character.toString(digits[j]));
    	}
    	String paranthesis = "";
    	for(int j =0;j<input_digit.length();j++) {
    		if(j==0) {
    			for(int k =0;k<digit_val[j];k++) {
    				paranthesis = paranthesis + "(";
    				
    			}
    			paranthesis = paranthesis + Integer.toString(digit_val[j]);
    			for(int k =0;k<digit_val[j];k++) {
    				paranthesis = paranthesis + ")";
    			}
//    			System.out.println(paranthesis);
    		}
    		
    		else {
    			char paran[] = paranthesis.toCharArray();
    			paran_count =0;
    			int flag =0;
    			int x,y=paranthesis.length()-1;
//    			System.out.println(paranthesis.length());
    			position = -1;
    			for (x =paranthesis.length()-1;x>=0;x--) {
    				y=x;
//    				System.out.println(paran[x]);
//    				if(x==paranthesis.length()-1&&paran[x]!=')')
//    					break;
    				if(paran[x]!=')') {
//    					position =x;
    					y =0;
    					break;
    				}
   					if(paran[x]==')') {
//   						System.out.println("Entered");
						paran_count ++;
						position = x;
					}
   					if(digit_val[j]==0) {
   						paranthesis = paranthesis + Integer.toString(digit_val[j]);
//						System.out.println(paranthesis);
						flag = 1;
						break;
   					}
   					else if(paran_count==digit_val[j]) {
//   						for(int z =0;z<digit_val[j]-paran_count;z++) {
//   	    					paranthesis = paranthesis + "(";
//   	    				}
////   	    				if (digit_val[j]!=0)
//   	    					paranthesis = paranthesis + Integer.toString(digit_val[j]);
//   	    				for(int z =0;z<digit_val[j]-paran_count;z++) {
//   	    					paranthesis = paranthesis + ")";
//   	    				}
   	    				break;
    				}
    			}
//    			System.out.println(position);
//    			System.out.println(paranthesis.substring(0,position) + "(" + digit_val[j]+")" + paranthesis.substring(position,paranthesis.length()));
    			 if (position!=-1 && flag==0) {
    				String paranthesis_interim = "";
    				for(int z =0;z<digit_val[j]-paran_count;z++) {
    					paranthesis_interim = paranthesis_interim + "(";
    				}
//    				if (digit_val[j]!=0)
    					paranthesis_interim = paranthesis_interim + Integer.toString(digit_val[j]);
    				for(int z =0;z<digit_val[j]-paran_count;z++) {
    					paranthesis_interim = paranthesis_interim + ")";
    				}
//    				System.out.println(paranthesis_interim);
//    				System.out.println(paranthesis.substring(0,position));
//    				System.out.println(paranthesis.substring(position,paranthesis.length()));
    				paranthesis = paranthesis.substring(0,position) + paranthesis_interim  + paranthesis.substring(position,paranthesis.length());
    			}
    			else if(y==0&&position==-1&& flag==0) {
    				for(int z =0;z<digit_val[j];z++) {
    					paranthesis = paranthesis + "(";
    				}
//    				if (digit_val[j]!=0)
    					paranthesis = paranthesis + Integer.toString(digit_val[j]);
    				for(int z =0;z<digit_val[j];z++) {
    					paranthesis = paranthesis + ")";
    				}
    			}
//    			System.out.println(paranthesis);
;    		}
    	}
//	  System.out.println("Col="+c);
      System.out.println("Case #" + i + ": " + paranthesis);
    }
  }
}