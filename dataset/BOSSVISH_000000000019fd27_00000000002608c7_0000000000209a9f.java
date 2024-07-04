

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=1;i<=t;i++){
			String str=s.next();
			int arr[]=new int[str.length()];
			for(int j=0;j<str.length();j++){
				arr[j]=str.charAt(j)-'0';
			}
			int count=0;
			int currIndex=0;
			for(int j=0;j<arr.length;j++){
				if(count==0&&arr[j]!=0){
					count=arr[j];
					for(int k=0;k<count;k++){
						str=str.substring(0, j+currIndex)+"("+str.substring(j+currIndex);
						currIndex++;
					}
				}
				else if(count>arr[j]){
					for(int k=0;k<count-arr[j];k++){
						str=str.substring(0, j+currIndex)+")"+str.substring(j+currIndex);
						currIndex++;
					}
					count=arr[j];
				}
				else if(count<arr[j]){
					for(int k=0;k<arr[j]-count;k++){
						str=str.substring(0, j+currIndex)+"("+str.substring(j+currIndex);
						currIndex++;
					}
					count+=arr[j]-count;
				}
			}
			for(int j=0;j<count;j++){
				str=str+")";
			}
			System.out.println("Case #"+i+": "+str);
		}
	}
}
