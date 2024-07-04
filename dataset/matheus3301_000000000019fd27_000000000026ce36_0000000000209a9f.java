import java.util.Scanner;
import java.lang.*;

class Solution{
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int t = entrada.nextInt();
		
		for(int a = 1; a <= t; a++){
		    String s = entrada.next();
		    String res = "";
		    
		    int n[] = new int[s.length()];
		    for(int i = Character.getNumericValue(s.charAt(0)); i > 0; i--){
		        res += "(";
		    }
		    res+=s.charAt(0);
		    
		    for(int i = 0; i < s.length(); i++){
		        n[i] = Character.getNumericValue(s.charAt(i));
		    }
		    
		    for(int i = 1; i < s.length(); i++){
		        if(n[i]-n[i-1] > 0){
		            for(int j = 0; j < n[i]-n[i-1]; j++){
		                res+="(";
		                
		            }
		        }else{
		            for(int j = 0; j < n[i-1]-n[i]; j++){
		                res+=")";
		                
		            }
		        }
		        
		        res+=s.charAt(i);
		    }
		    
		   
		    for(int i = Character.getNumericValue(s.charAt(s.length()-1)); i > 0; i--){
		        res += ")";
		    }
		    
		    System.out.println("Case #"+a+": "+res);
		    
		}
		
	}
}
