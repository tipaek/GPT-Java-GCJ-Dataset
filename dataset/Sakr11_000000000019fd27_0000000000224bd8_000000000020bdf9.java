import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		int indicator=0;
		
		int nn;
		int counter=1;
		String A="",B="";
		
		int sum=0;
		int rows=0,coulums=0;
		int a= 0;
		int b=0;
		Scanner myObj = new Scanner(System.in);
		n=myObj.nextInt();
		
		
		
		for(int i=1 ; i<=n;i++) {
			
			nn=myObj.nextInt();
			int[][] arr=new int [nn][2];
			for(int j=0; j<nn;j++) {
				for(int u=0; u<2;u++) {
					arr[j][u]=myObj.nextInt();
				}
			}
			String temp="";
			for(int z=0;z<nn;z++) {
				for(int p=1+z;p<nn;p++) {
					if((arr[z][0]<arr[p][1]&&arr[z][1]>arr[p][0])) {
						A+=(char)(p+'0'); 
						if(counter<3) {
							++counter;
							if(counter==3) {
								temp+='3';
								indicator=1;
							}
						}
					}
					
				}
				counter=1;
				
			}
			for(int w=0; w<temp.length();w++) {
				if(temp.charAt(w)=='3'&&nn<4) {
					System.out.println("Case #"+i+':'+' '+"IMPOSSIBLE");
					indicator=1;
					B="";
					break;
				}
					
			}
			int x=0;
			if(indicator==1) {
				
			}else {
					String Final="";
					int[] array=new int [1000];
					for(int rr=0; rr<1000;rr++) {
						array[rr]=-1;
					}
					
					for(int r=0 ; r<A.length();r++) {
						array[(A.charAt(r)-'0')]=300;
					}
					for(int t=0 ;t<nn;t++) {
						if(array[t]!=300) {
							Final+='C';
						}else {
							Final+='J';
						}
					}
					System.out.println("Case #"+i+':'+' '+Final);
					B="";
					Final="";
					
			}
			indicator=0;
			}
			
		
	}
}