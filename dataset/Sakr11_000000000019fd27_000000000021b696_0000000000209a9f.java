import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		int indicator=0;
		
		int nn;
		int counter=0;
		String A="",B="";
		
		int sum=0;
		int rows=0,coulums=0;
		int a= 0;
		int b=0;
		Scanner myObj = new Scanner(System.in);
		n=myObj.nextInt();
		
		
		myObj.nextLine();
		for(int i=1 ; i<=n;i++) {
			
			A=myObj.nextLine();
			for(int j=0; j<A.length();j++) {
				if(j==0) {
				 a=(A.charAt(j))-'0';
				 for(int c=0;c<a;c++) {
					 B+='(';
				 }
				 B+=A.charAt(j);
			}else {
				a=(A.charAt(j))-'0';
				b=(A.charAt(j-1))-'0';
				if(a<b) {
					for(int d=0; d<(b-a);d++) {
						B+=')';
					}
					 B+=A.charAt(j);
				}else {
					for(int d=0; d<(a-b);d++) {
						B+='(';
					}
					 B+=A.charAt(j);
				}
			}
			}	
					a=A.charAt(A.length()-1)-'0';
					for(int u=0; u<a;u++) {
						B+=')';
					}
					System.out.println("Case #"+i+':'+' '+B);
					B="";
			}
			
		
	}
}