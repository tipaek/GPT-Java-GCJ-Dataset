import java.util.*;

public class Solution{

     public static void main(String []args){
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t=0 ; t < T ; t++){
            
            String str = sc.next();
			
			String strS = "";
			
			int i = 0;
			while(i < str.length()){
				
				char ch = str.charAt(i);
				String appendStr = ""+ ch;
				
				int newIter = i+1;
				for(int j=(i+1); j < str.length() ; j++){
					
					char nextCh = str.charAt(j);
					
					if(nextCh == ch){
						newIter = j+1;
						//System.out.println("Char same :: "+newIter);
						appendStr = appendStr + "" + nextCh;
					}
					else{
						newIter = j;
						//System.out.println("Char not same :: "+newIter);
						break;
					}
				}
				for(int j=0; j < Integer.parseInt(String.valueOf(str.charAt(i))) ; j++){
					strS = strS + "(";
				}
				strS = strS + appendStr;
				for(int j=0; j < Integer.parseInt(String.valueOf(str.charAt(i))) ; j++){
					strS = strS + ")";
				}
				i = newIter;
				//System.out.println("New i value is :: " +i);
			}
			System.out.println("Case #" +(t+1)+ ": " + strS);
			
        }
        
        sc.close();
        System.exit(0);
        
     }
}