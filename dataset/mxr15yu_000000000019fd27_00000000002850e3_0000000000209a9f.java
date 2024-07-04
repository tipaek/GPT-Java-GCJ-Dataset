import java.io.*;
import java.util.*;
public class Solution {
    public static void solve(Scanner sc, int t) {
    	String s = sc.nextLine();
        int num;
        boolean value = false;
        for(int test = 0; test < 10; test++){
            for(int x = 0; x<s.length(); x++){
            	if(s.charAt(x) != '(' && s.charAt(x) != ')')
            		num = Integer.parseInt(String.valueOf(s.charAt(x))); 
            	else
            		continue;
                if(num > test && value == false){
                    s = s.substring(0, x) + "(" + s.substring(x);
                    value = true;
                }
                else if(num <= test && value == true){
                	s = s.substring(0, x) + ")" + s.substring(x);
                    value = false;
                }
            }
            value = false;
        }
        num = Integer.parseInt(String.valueOf(s.charAt(s.length()-1))); 
        while(num>0) {
        	s += ")";
        	num--;
        }
        System.out.println("Case #" + t + ": " + s);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int x = 1; x <= t; x++){
            solve(sc, x);
        }
    }
}