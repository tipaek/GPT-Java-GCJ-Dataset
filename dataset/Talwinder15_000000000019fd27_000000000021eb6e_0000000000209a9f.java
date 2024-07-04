import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        int tcs = inp.nextInt();
        
        int tc = 1;
        while(tc <= tcs){
            String inputString = inp.next();
            
            String res = "";
            if(inputString.length() == 0) {
            	System.out.println(res);
            	continue;
            }
            int open = 0;
           
            for(int i = 0; i < inputString.length(); i++){
            	
                int curdigit = Integer.valueOf(inputString.charAt(i)) - 48;
                
                if(open > curdigit) {
                	res +=  brackets(open-curdigit,'c') + inputString.charAt(i);
                	open = open - (open - curdigit);
                }
                else if(open < curdigit) {
                	res +=  brackets(curdigit-open,'o') + inputString.charAt(i);
                	open = open + (curdigit - open);
                }
                else {
                	res += inputString.charAt(i);
                }
                
                
            }
            if(open > 0) {
            	res += brackets(open,'c');
            }
            System.out.println("Case #"+tc+": "+res);
            tc++;
        }
    }
    
    private static String brackets(int open, char c) {
		// TODO Auto-generated method stub
		String res = "";
		if(c == 'o')
		{
			while(open > 0) {
				res += "(";
				open--;
			}
		}
		else {
			while(open > 0) {
				res += ")";
				open--;
			}
		}
		return res;
	}
}