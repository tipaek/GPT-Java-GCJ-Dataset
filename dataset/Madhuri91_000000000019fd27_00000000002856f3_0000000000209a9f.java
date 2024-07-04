import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		int n,c=1;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		
		while(c<=n)
		{
			String str,output="";
			int braces=0,previous=0,curr,i,j;
			str=sc.next();
			for(i=0;i<str.length();i++){
	            curr=(int)str.charAt(i)-48;
	            if(curr>previous){
	                for(j=0;j<curr-previous;j++){
	                    output=output+"(";
	                }
	                braces+=(curr-braces);
	            }
	            if(curr<previous){
	                for(j=0;j<previous-curr;j++){
	                    output=output+")";
	                }
	                braces-=(previous-curr);
	            }
	            output=output+str.charAt(i);
	            previous=curr;
	            
	        }
	        for(j=0;j<braces;j++){
	            output=output+")";
	        }
	        System.out.println("Case #"+c+": "+output);
	        c++;
			
		}

	}

}
