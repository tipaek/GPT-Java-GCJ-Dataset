
	import java.util.*;
    import java.io.*;
    public class solution1 {
    	
    	
    	
    	
    	public static void main(String[] args) {
    		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    		int c = in.nextInt(); // number Testcases. 
    		String str = "";
    		
    		int difference = 0;
    		
    		for (int t=1;t<=c;t++) {
    			String solution="";

    			str =in.next();
    			
    			for (int k= (int) str.charAt(0) - 48; k>0; k--) {
    				solution=solution+"(";
    			}

    			for (int i=0; i<str.length()-1; i++) {
    				solution=solution+str.charAt(i);
    				difference =str.charAt(i)-str.charAt(i+1);
    				if (difference < 0) {
    					for (int k=difference; k<0; k++) {
    						solution=solution+"(";
    					}
    				}
    				if (difference > 0) {
    					for (int k=difference; k>0; k--) {
    						solution=solution+")";
    					}
    				}
    			}
    			solution=solution+str.charAt(str.length()-1);
    			for (int k= (int) str.charAt(str.length()-1) - 48; k>0; k--) {
    				solution=solution+")";
    			}
    			System.out.println("Case #" + t + ": "+ solution );
    		}
    	}
    }
	