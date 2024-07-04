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
		int lim = Integer.parseInt(s);
		if(lim==0){
			System.out.println("Case #"+(testCase+1)+": "+s);
		}
		else if(s.length()==1){
			for(int i=0;i<lim;i++){
				if(i<(lim)){
				finalVal=finalVal+"(";
				}
			}
			finalVal = finalVal+s;
			for(int i=0;i<lim;i++){
				if(i<(lim)){
				finalVal=finalVal+")";
				}
			}
			System.out.println("Case #"+(testCase+1)+": "+finalVal);
		}
		else{
			int length = s.length();
			finalVal=s.substring(0,1);
			for(int i=0;i<length-1;i++){
				int one = Integer.parseInt(s.substring(i,i+1));
				int two = Integer.parseInt(s.substring(i+1,i+2));
				if(one<two){
					int diff=two-one;
					for(int j=0;j<diff;j++){
						finalVal=finalVal+"(";
					}
					finalVal=finalVal+s.substring(i+1,i+2);
				}
				else if(one>two){
					int diff=one-two;
					for(int j=0;j<diff;j++){
						finalVal=finalVal+")";
					}
					finalVal=finalVal+s.substring(i+1,i+2);
				}
				else if(one==two){
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