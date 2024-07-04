import java.io.*;
import java.util.*;
public class java2{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1;i <= n; i++) {
			String s = sc.next();
			int no_of_open= 0;
			String ans="";
			for(int j= 0;j< s.length();j++) {
				int x=s.charAt(j) - '0' ;
				if(no_of_open<x){
					while(no_of_open!=x){
						ans=ans+'(';
						no_of_open++;
					}
				}
				else if(no_of_open>x){
					while(no_of_open!=x){
						ans=ans+')';
						no_of_open--;
					}
				}
				ans=ans+(char)(x+'0');
			}
			while(no_of_open!=0){
				ans=ans + ')';
				no_of_open--;
			}
			System.out.println("Case #"+i+": "+ans);
		}
	}
}