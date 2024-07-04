import java.util.Scanner;


public class Solution {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int testcase=sc.nextInt();
		
		for(int i=0;i<testcase;i++){
			String s =sc.next();
			solve(s,i);
		}
	}
	
	
	public static void solve(String s,int testCase){
		String finalVal="";
		
		
		if(Integer.parseInt(s)==0){
			
			System.out.println("Case #"+(testCase+1)+": "+s);
		}
		else if(s.length()==1){
			for(int i=0;i<Integer.parseInt(s);i++){
				
				if(i<(Integer.parseInt(s))){
				finalVal=finalVal+"(";
				}
			}
			finalVal = finalVal+s;
			for(int i=0;i<Integer.parseInt(s);i++){
				
				if(i<(Integer.parseInt(s))){
				finalVal=finalVal+")";
				}
			}
			System.out.println("Case #"+(testCase+1)+": "+finalVal);
		}
		
		else{
			int length = s.length();
			finalVal=s.substring(0,1);
			for(int i=0;i<length-1;i++){
				if(Integer.parseInt(s.substring(i,i+1))<Integer.parseInt(s.substring(i+1,i+2))){
					int diff=Integer.parseInt(s.substring(i+1,i+2))-Integer.parseInt(s.substring(i,i+1));
					for(int j=0;j<diff;j++){
						finalVal=finalVal+"(";
					}
					finalVal=finalVal+s.substring(i+1,i+2);
				}
				else if(Integer.parseInt(s.substring(i,i+1))>Integer.parseInt(s.substring(i+1,i+2))){
					int diff=Integer.parseInt(s.substring(i,i+1))-Integer.parseInt(s.substring(i+1,i+2));
					for(int j=0;j<diff;j++){
						
						finalVal=finalVal+")";
					}
					finalVal=finalVal+s.substring(i+1,i+2);
				}
				else if(Integer.parseInt(s.substring(i,i+1))==Integer.parseInt(s.substring(i+1,i+2))){
					finalVal=finalVal+s.substring(i,i+1);
					continue;
				}
			}
			for(int i=0;i<Integer.parseInt(s.substring(0,1));i++){
				finalVal="("+finalVal;
			}
			for(int i=0;i<Integer.parseInt(s.substring(s.length()-1));i++){
				finalVal=finalVal+")";
			}
			System.out.println("Case #"+(testCase+1)+": "+finalVal);
		}
	}

}
