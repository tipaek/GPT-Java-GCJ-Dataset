import java.util.*;
public class Solution{
    public static void main(String args[]){
         Scanner scan=new Scanner(System.in);
	        int n=scan.nextInt();
	        for(int i=1;i<=n;i++){
	            
	            String str=scan.next();
	            char last='0';
	            char front='0';
	            System.out.print("Case #"+i+" ");
	            for(int j=0;j<str.length();j++){
	                
	                if(str.length()==1) {
	                	front='0';
	                	last='0';
	                }
	                else  if(j>=1&&(j<str.length()-1))
	                {last=str.charAt(j-1);
	                front=str.charAt(j+1);}
	                
	                else if(j==0){
	                	last='0';
	                    front=str.charAt(j+1);
	                }
	                else if(j==str.length()-1){
	                	last=str.charAt(j-1);
	                    front='0';
	                }
	                
	                
	                
	                if(str.charAt(j)=='1' && last=='0'){
	                    System.out.print("(");
	                }
	                 System.out.print(str.charAt(j));
	                if(str.charAt(j)=='1' && front=='0'){
	                     System.out.print(")");
	                }
	                
	            }
	            
	            System.out.println();
	            
	            
	}
    }
}