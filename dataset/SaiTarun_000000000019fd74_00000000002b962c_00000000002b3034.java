import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int totalTestCases=Integer.valueOf(in.nextInt());
		int count=0;
		while(count<totalTestCases) {
			count++;
			int N=Integer.valueOf(in.nextInt());
			String[] arr=new String[N];
			for(int i=0; i<N; i++) arr[i]=in.nextLine();
			//System.out.println("Hello");
			String output=helper(arr);
			System.out.println("Case #"+count+": "+output);
		}
	}
	
	public static String helper(String[] arr) {
		StringBuilder sb=new StringBuilder();
		int[] posArr=new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			posArr[i]=arr[i].length()-1;
		}
		
		//boolean flag=true;
		while(true) {
			//boolean local=false;
			char ch=' ';
			for(int i=0; i<arr.length; i++) {
				char temp=arr[i].charAt(posArr[i]);
				if(temp!='*') {
					//local=true;
					if(ch==' ') ch=temp;
					else if(ch!=temp) return "*";
					posArr[i]=posArr[i]-1;
				}
			}
			if(ch==' ') break;
			sb.append(ch);
		}
		return sb.reverse().toString();
	}
}