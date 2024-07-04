//package main;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test=sc.nextInt();
		for(int t=1;t<=test;t++) {
			String s=sc.next();
			String ss="";
			int b=0;
			for(int i=0;i<s.length();i++) {
				int x = Character.getNumericValue(s.charAt(i));
				if(x>b) {
					for(int j=0;j<(x-b);j++) {
						ss+="(";
					}
					b=x;
				}
				else if(x<b) {
					for(int j=0;j<(b-x);j++) {
						ss+=")";
					}
					b=x;
				}
				ss+=s.charAt(i);
			}
			while(b-->0) {
				ss+=")";
			}
			System.out.println("Case #"+t+": "+ss);
			
		}
		sc.close();
	}

}
