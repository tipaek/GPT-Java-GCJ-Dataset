import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {



    static Scanner scanner;

    public String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }
    
    public static void main(String[] args)
    {
//        try {scanner = new Scanner(new File("list.in.txt"));} catch (FileNotFoundException e) {return;}
        scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; ++t)
        {

        		String str = scanner.next();
        		StringBuffer strRes = new StringBuffer(str);
        		
        		int l = str.length();
        		int index = 0;
        		int countDigit = 0;
        		int currNumber = 0;
        		for (int i = 0; i < l; i++){
        			int n = str.charAt(i) - '0';
        			int delta = n - currNumber;
        			if(delta > 0) {
        				for(int k = 0; k< delta; k++) {
        					strRes.insert(index, '(');
        				}
        			}else {
        				for(int k = 0; k< Math.abs(delta); k++) {
        					strRes.insert(index, ')');
        				
        				}
        			}
        			countDigit += delta;
        			index += Math.abs(delta)+1;
        			currNumber = n;
        		}	
				for(int k = 0; k< Math.abs(countDigit); k++) {
					strRes.insert(index, ')');
				
				}
        	
        		System.out.println("Case #" + t +": " + strRes.toString());
        }
    }

}
