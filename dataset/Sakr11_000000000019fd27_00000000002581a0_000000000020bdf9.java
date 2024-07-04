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
		
		int[] arr1 =new int[2];
		
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
						temp+='J';
						LinkedList<Object> linked=new LinkedList<Object>();
				for(int p=1+z;p<nn;p++) {
					if(p<nn&&((arr[z][0]>=arr[p][0]&&arr[z][0]<arr[p][1])||(arr[z][1]>arr[p][0]&&arr[z][1]<arr[p][1])||(arr[p][0]>=arr[z][0]&&arr[p][0]<arr[z][1])||(arr[p][1]>arr[z][0]&&arr[p][1]<arr[z][1]))) {
						if(linked.isEmpty()) {
							temp+='C';
							linked.add(arr[p]);
						}
						else {
							for(int f=0; f<linked.size();f++) {
								arr1=(int[]) linked.get(f);
								if(arr1[0]<arr[p][1]&&arr1[1]>arr[p][0]) {
									continue;
								}else {
									temp+='C';
									linked.add(arr[p]);
									break;
								}
							}
						}
						
					}else {
						temp+='J';
					}
					
				}
				break;
				
			}
			
				if(temp.length()==nn) {
				System.out.println("Case #"+i+':'+' '+temp);
				temp="";
				}else {
					System.out.println("Case #"+i+':'+' '+"IMPOSSIBLE");
				}
			
			}
			
		
	}
}