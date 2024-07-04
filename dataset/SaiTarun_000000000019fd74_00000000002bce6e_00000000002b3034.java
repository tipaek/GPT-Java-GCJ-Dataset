package tarun;

import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int totalTestCases=Integer.valueOf(in.nextLine());
		int count=0;
		//System.out.println(totalTestCases);
		while(count<totalTestCases) {
			count++;
			int N=Integer.valueOf(in.nextLine());
			//System.out.println(N);
			String[] arr=new String[N];
			for(int i=0; i<N; i++) arr[i]=in.nextLine();
			//for(int i=0; i<N; i++) System.out.println(arr[i]);
			System.out.println("Case #"+count+": "+helper(arr));
		}
//		String[] arr=new String[] {"*CONUTS", "*COCONUTS", "*OCONUTS", "*CONUTS", "*S"};
//		System.out.println(helper(arr));
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
