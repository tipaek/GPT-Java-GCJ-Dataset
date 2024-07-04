
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
    	
    	/*File initialFile = new File("NestingActual.txt");
		InputStream targetStream=null;
	    try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        // Scanner in = new Scanner(new BufferedReader(new InputStreamReader(targetStream)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int testCase = 1;  testCase<= t; ++testCase) 
        {
        	StringBuilder s = new StringBuilder(in.next());
	
            
            //prepare input. each no with equal left and right parenthesis
            for(int i=0;i<s.length();i++){
            	char lc = s.charAt(i);
            	if(!(lc>='0'&&lc<='9'))
            		continue;
            	int ln = Character.getNumericValue(lc);
            	for(int j=0;j<ln;j++){
            		s=s.insert(i+1,")");
            		
            	}
            	for(int j=0;j<ln;j++){
            		s=s.insert(i,"(");
            		i++;
            	}
            }
//            System.out.println("before s:"+s);
            for(int i=0;i<s.length()-1;i++)
			{
            	char c1 = s.charAt(i);
            	char c2 = s.charAt(i+1);
            	if(c1==')'&&c2=='('){
            		s=s.delete(i, i+2);
            		i=i-2;
            	}
			}
            
//            System.out.println("iarr:"+Arrays.toString(iarr));
            System.out.println("Case #"+testCase+": "+s);
            
            	
            
        }
	}
	
	
}
