import java.util.*;
import java.io.*;
public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int k = 1; k <= t; ++k) {
            String line = in.nextLine();
            
            int index = 0;
            String text = "";
            
            for(int i=0; i<=line.length()-1; i++) {
        		char ch1 = line.charAt(i);
        		int counter = Integer.parseInt(String.valueOf(ch1));
        		
        		while (index>counter) {
        		    text += ")";
        		    index--;
        		}
        		
        		while (counter > index) {
        		    text += "(";
        		    index++;
        		}
        		text += ch1;
        	}
            
            while (index>0) {
    		    text += ")";
    		    index--;
    		}
            
            System.out.println("Case #" + k + ": " + text);
        
        }
    }
}