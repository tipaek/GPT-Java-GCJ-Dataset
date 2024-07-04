import java.util.Scanner;
import java.io.*; 
import java.util.*; 

public class Solution {
		public static char[] rev(char[] input) {
			int len = input.length;
			char[] res = new char[len];
			for(int i = 0; i < len; ++i) {
				res[i] = input[len - i - 1];
			}
			return res;
		}
		
		public static char[] cmp(char[] input) {
			int len = input.length;
			char[] res = new char[len];
			for(int i = 0; i < len; ++i) {
				res[i] = (input[i] == '0')? '1' : '0';
			}
			return res;
		}
		
		public static char[] revcmp(char[] input) {
			int len = input.length;
			char[] res = new char[len];
			for(int i = 0; i < len; ++i) {
				res[i] = (input[len - i - 1] == '0')? '1' : '0';
			}
			return res;
		}
		
	  public static boolean solve(Scanner input, int B) {
		    
		    
	        if(B == 10){
    	        Set<String> set = new HashSet<String>();
    		    String res = "";
    		    StringBuilder line = new StringBuilder();
	            for(int j = 1; j <= B; ++j) {
		            System.out.println(j);
		            line.append(input.next().charAt(0));
		    	}
		    	res = line.toString();
	            set.add(res);
	            System.out.println(res);
	            if(input.next().equals("Y")) return true;
	        }else if(B == 20){
	            Set<String> L = new HashSet();
	            Set<String> R = new HashSet();
	          
	            for(int i = 1; i <= 7; ++i){
	                 StringBuilder line = new StringBuilder();
	                 for(int j = 1; j <= 10; ++j) {
	                    System.out.println(j);
		                line.append(input.next().charAt(0));
	                 }
	                 
	                 L.add(line.toString());
	                 line.setLength(0);
	                 
	                 for(int j = 11; j <= 20; ++j) {
	                    System.out.println(j);
		                line.append(input.next().charAt(0));
	                 }
	                 
	                 R.add(line.toString());
	            }
	            
	            
	            StringBuilder line = new StringBuilder();
	            for(int j = 11; j <= 20; ++j){
	                System.out.println(j);
	                line.append(input.next().charAt(0));
	            }
	            
	            String outR = line.toString();
	            String cmpR = new String(cmp(outR.toCharArray()));
	            List<String> posLList = new ArrayList();
	            for(String posL : L){
	                if(!posL.equals(outR) && !posL.equals(cmpR)){
	                    posLList.add(posL);
	                }
	            }
	            
	            String posOut = posLList.get(0) + outR;
	            if(posLList.size() == 1) {
	                System.out.println(posOut);
                    if(input.next().equals("Y")) return true;
                    else return false;
	            }
	            
	            String posOut2 = posLList.get(1) + cmpR;
	            
	            String composOut = new String(posOut);
	            
	            if(composOut.equals(posOut2)){
	                 System.out.println(posOut);
	                 
	            }else{
	                 System.out.println(posLList.get(1) + outR);
	            }
	            if(input.next().equals("Y")) return true;
	           
	        }
		    
		    
		  
		    return false;
	  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      if(!solve(input, B)) break;
    }
  }
}
