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
			for(int jj=0; jj<nn;jj++) {
				if(arr[jj][0]>arr[jj][1]) {
					int temp=arr[jj][1];
					arr[jj][1]=arr[jj][0];
					arr[jj][0]=temp;
				}
			}
			String temp="";
			for(int z=0;z<nn;z++) {
						temp+='C';
						LinkedList<Object> linked1=new LinkedList<Object>();
						LinkedList<Object> linked=new LinkedList<Object>();
						linked1.add(arr[0]);
				for(int p=1+z;p<nn;p++) {
					if(p<nn&&((arr[z][0]>=arr[p][0]&&arr[z][0]<arr[p][1])||(arr[z][1]>arr[p][0]&&arr[z][1]<=arr[p][1])||(arr[p][0]>=arr[z][0]&&arr[p][0]<arr[z][1])||(arr[p][1]>arr[z][0]&&arr[p][1]<=arr[z][1]))) {
						if(linked.isEmpty()) {
							temp+='J';
							linked.add(arr[p]);
						}
						else {
							if(linked.isEmpty()) {
								temp+='J';
								linked.add(arr[p]);
							}else {
							for(int ff=0; ff<linked.size();ff++) {
								arr1=(int[]) linked.get(ff);
								if((arr1[0]>=arr[p][0]&&arr1[0]<arr[p][1])||(arr1[1]>arr[p][0]&&arr1[1]<=arr[p][1])||(arr[p][0]>=arr1[0]&&arr[p][0]<arr1[1])||(arr[p][1]>arr1[0]&&arr[p][1]<=arr1[1])) {
									break;
								}else {
									temp+='J';
									linked.add(arr[p]);
									break;
								}
							}
						}
						}
						
					}else {
						int f=0;
						for(f=0; f<linked1.size();f++) {
							arr1=(int[]) linked1.get(f);
							if((arr1[0]>=arr[p][0]&&arr1[0]<arr[p][1])||(arr1[1]>arr[p][0]&&arr1[1]<=arr[p][1])||(arr[p][0]>=arr1[0]&&arr[p][0]<arr1[1])||(arr[p][1]>arr1[0]&&arr[p][1]<=arr1[1])) {
								indicator=1;
								break;
							}
						}if(indicator==0) {
							temp+='C';
							linked1.add(arr[p]);
						}
						else{
							if(linked.isEmpty()) {
								temp+='J';
								linked.add(arr[p]);
							}else {
							for(int ff=0; ff<linked.size();ff++) {
								arr1=(int[]) linked.get(ff);
								if((arr1[0]>=arr[p][0]&&arr1[0]<arr[p][1])||(arr1[1]>arr[p][0]&&arr1[1]<=arr[p][1])||(arr[p][0]>=arr1[0]&&arr[p][0]<arr1[1])||(arr[p][1]>arr1[0]&&arr[p][1]<=arr1[1])) {
									break;
								}else {
									temp+='J';
									linked.add(arr[p]);
									break;
								}
							}
						}
						
						}
					}
					
				}
				break;
				
			}
				indicator=0;
				if(temp.length()==nn) {
				System.out.println("Case #"+i+':'+' '+temp);
				temp="";
				}else {
					System.out.println("Case #"+i+':'+' '+"IMPOSSIBLE");
				}
			
			}
			
		
	}

}