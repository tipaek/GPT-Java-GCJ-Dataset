import java.util.Scanner;

public class Solution{
	
	public static void main(String[] args)
    {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int t=0;t<T;t++) {
			
			String str = scan.next();
			
			String resultStr="";
			int no;
			int openParam=0;
			
			for(int i=0;i<str.length();i++) {
				
				no=Integer.parseInt(str.charAt(i)+"");
				
				if(no > openParam) {
					
					for(int j=0;j<no-openParam;j++) {
						
						resultStr = resultStr + "(";
						
					}
					
					openParam = no;
				}
				
				else if(no < openParam) {
					
					for(int j=0;j<openParam-no;j++) {
						
						resultStr = resultStr + ")";
						
					}
					
					openParam = no;
				}
				
				resultStr = resultStr + no;
				
			}
			
			for(int i=0;i<openParam;i++)
				resultStr = resultStr + ")";
			
			System.out.println("Case #" + (t+1) + ": " + resultStr);
		}
    }
}