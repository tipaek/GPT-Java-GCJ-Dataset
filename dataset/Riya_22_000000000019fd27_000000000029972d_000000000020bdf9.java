import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		for(int y=0; y<t; ++y) {
			int n= s.nextInt();
			String arr[]= new String[10000000];
			Arrays.fill(arr, "0X");
			int flag=0;
			String ans="";
			int len=0;
			for(int i=0; i<n; ++i) {
				int st= s.nextInt();
				int en= s.nextInt();
				int tell=0;
				for(int x= st; x<en;++x) {
					int num= arr[x].charAt(0)-'0';
					char str= arr[x].charAt(1);
					if(num>2) {
						//System.out.println(i+ " "+ num+ " "+ x+ " "+ arr[x]);
						flag=1;
						break;
					}
					if(num!=0) {
						tell=x;					
					}
				}
				if(tell==0) {
					for(int ix=st; ix<en; ++ix) {
						arr[ix]="1C";
					}
					ans+='C';
					len++;
				}
				else if(tell==2) {
					flag=1;
					
				}
				else {
					char ch= arr[tell].charAt(1);
					if(ch=='C') {
						for(int ix=st; ix<en; ++ix) {
							arr[ix]="2J";
						}
						ans+='J';
					}
					else {
						for(int ix=st; ix<en; ++ix) {
							arr[ix]="2C";
						}
						ans+='C';
					}
					len++;
				}
			
			}
			if(flag==1) {
				System.out.println("Case #"+ (y+1)+": "+ "IMPOSSIBLE");
			}
			else {
				System.out.println("Case #"+ (y+1)+": "+ ans);
			}
		}
	}
}
