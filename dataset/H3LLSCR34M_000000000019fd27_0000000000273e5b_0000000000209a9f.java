
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));  
    int t = in.nextInt();
    String[] arr = new String[t];
    for(int w = 0;w<t;w++) {
    	String str = in.next();
    	String res ="";
    	int brackets = 0;
    	for(int i = 0;i<str.length();i++) {
    		char ch = str.charAt(i);
    		int n = Character.getNumericValue(ch);  
    		if(n<=brackets) {
    		while(n<brackets) {
    			brackets--;
    			res+=")";
    		}
    		res+=ch;
    		}
    		else {
    		for(int a = 0;a<n;a++) {
    			res+="(";
    			brackets++;
    		}
			res+=ch;
    		}
    	}
    	while(brackets!=0) {
    		brackets--;
    		res+=")";
    	}
    		
    	arr[w] = "Case #"+(w+1)+": "+res;
    }  
    in.close();
    for(String s:arr)
    	System.out.println(s);
  }
}
