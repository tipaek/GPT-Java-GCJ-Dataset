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
		    Set<String> set = new HashSet<String>();
		    String res = "";
		    int count = 0;
		    
		    while(count + B <= 150){
		    	count += B;
		    	StringBuilder line = new StringBuilder();
		    	
		    	for(int j = 1; j <= B; ++j) {
		            System.out.println(j);
		            System.out.flush();
		            line.append(input.next().charAt(0));
		    	}
		    	
		    	res = line.toString();
	            set.add(res);
	            System.out.println(res);
	            System.out.flush();
	            if(input.next().equals("Y")) return true;
	            else break;
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
