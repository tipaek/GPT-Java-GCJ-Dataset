

import java.util.Scanner;

public class Solution {
	public static String getAns(String ans,String temp){
		int ansStart=0;
		for(;ansStart<ans.length();ansStart++){
			if(ans.charAt(ansStart)=='*'){
				break;
			}
		}
		int tempStart=0;
		for(;tempStart<ans.length();tempStart++){
			if(temp.charAt(tempStart)=='*'){
				break;
			}
		}
		int ansBack=ans.length()-1;
		int ansCount=0;
		for(;ansBack>=0;ansBack--){
			if(ans.charAt(ansBack)=='*'){
				break;
			}
			ansCount++;
		}
		int tempBack=temp.length()-1;
		int tempCount=0;
		for(;tempBack>=0;tempBack--){
			if(temp.charAt(tempBack)=='*'){
				break;
			}
			tempCount++;
		}
		String tempAns="";
		if(ansStart>tempStart){
			tempAns=ans.substring(0, ansStart)+temp.substring(tempStart, tempBack)+ans.substring(ansStart, ansBack);
		}
		else{
			tempAns=temp.substring(0, tempStart)+temp.substring(tempStart, tempBack)+ans.substring(ansStart, ansBack);
		}
		if(ansCount>tempCount){
			tempAns=tempAns+ans.substring(ansBack);
		}
		else{
			tempAns=tempAns+temp.substring(tempBack);
		}
		return tempAns;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=1;i<=t;i++){
			int n=s.nextInt();
			String ans="";
			String arr[]=new String[n];
			for(int j=0;j<n;j++){
				String temp=s.next();
				arr[j]=temp;
			}
			for(int j=0;j<arr.length;j++){
				if(j==0){
					ans=arr[0];
					continue;
				}
				String temp=arr[j];
				boolean possibleFront=true;
				int kFront=0,lFront=0;
				for(;kFront<temp.length()&&lFront<ans.length();kFront++,lFront++){
					if(temp.charAt(kFront)=='*'||ans.charAt(lFront)=='*'){
						break;
					}
					else if(temp.charAt(kFront)!=ans.charAt(lFront)){
						possibleFront=false;
						break;
					}
				}
				boolean possibleBack=true;
				int kBack=temp.length()-1,lBack=ans.length()-1;
				for(;kBack>=0&&lBack>=0;kBack--,lBack--){
					if(temp.charAt(kBack)=='*'||ans.charAt(lBack)=='*'){
						break;
					}
					else if(temp.charAt(kBack)!=ans.charAt(lBack)){
						possibleBack=false;
						break;
					}
				}
				if(!possibleBack||!possibleFront){
					ans="*";
					break;
				}
				ans=getAns(ans,temp);
			}
			if(!ans.equals("*")){
				for(int c=0;;c++){
					if(c>=ans.length()){
						break;
					}
					if(ans.charAt(c)=='*'){
						ans=ans.substring(0, c)+ans.substring(c+1);
						c--;
					}
				}
			}
			System.out.println("Case #"+i+": "+ans);
		}

	}

}
