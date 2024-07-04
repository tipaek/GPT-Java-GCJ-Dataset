import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		int indicator=0;
		int numberOfHouses;
		int nn;
		int counter=0;
		String A="",B="";
		int first=0,second=0;
		int sum=0;
		int rows=0,coulums=0;
		Scanner myObj = new Scanner(System.in);
		n=myObj.nextInt();
		
		
		
		for(int i=1 ; i<=n;i++) {
			A=myObj.next();
			for(int j=0; j<A.length();j++) {
				if(A.charAt(j)=='0') {
					B+=A.charAt(j);
				}else if(A.charAt(j)=='1') {
					B+='(';
					B+=A.charAt(j);
					while(((j+1)<A.length())&&A.charAt(j+1)=='1'){
						j++;
						B+=A.charAt(j);
					}
					B+=") ";
					
				}
			}
			
					System.out.println("Case #"+i+':'+' '+B);
					B="";
			}
			
		
	}
}