
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			String str=s.next();
			int len=str.length();
			char arr[]=str.toCharArray();
			int j=0;
			String ans="";
			while(j<len){
				if(arr[j]=='0'){
					j++;
					ans=ans+'0';
				}
				else{
					ans=ans+'('+'1';
					while(j+1<len&&arr[j+1]=='1'){ 
					  ans=ans+'1';
					  j++;
					}
					ans=ans+')';
					j++;
				}
				}
			System.out.println("Case #"+(i+1)+": "+ans);
			}
		}
	}


