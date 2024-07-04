import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
		for(int t=0;t<test;t++){
			 int n = scan.nextInt();
			 int arr[][]=new int[n][2];
			 int ar[]=new int[n];
			 String s="";
			 ar[0]=-1;
			 int flag=0;
			for(int a=0;a<n;a++){
				for(int b=0;b<2;b++){
					arr[a][b]=scan.nextInt();
				}
			}
				for(int d=1;d<n;d++){
					if(arr[d][0]>=arr[0][1]||arr[d][1]<=arr[0][0]){
						ar[d]=ar[0];
					}
					else{
					    ar[d]=-2;
					}
				}
			
				for(int c=0;c<n;c++){
				    	for(int e=c+1;e<n;e++ ){
				   if(ar[c]==ar[e]&&((arr[e][0]<arr[c][1]&&arr[e][0]>arr[c][0])||(arr[e][1]>arr[c][0]&&arr[e][1]<arr[c][1])||(arr[c][0]<arr[e][1]&&arr[c][0]>arr[e][0])||(arr[c][1]>arr[e][0]&&arr[c][1]<arr[e][1])))
				    {
				        ar[e]=-3;
				    }
				    
				}}
					
		        System.out.print("Case #"+(t+1)+": ");
		      for(int p=0;p<n;p++){
		          if(ar[p]==-1){
		              s=s+'J';
		          }
		          else if(ar[p]==-2){
		              s=s+'C';
		          }
		          else{
		              s="IMPOSSIBLE";
		              break;
		          }
		      }
		
			System.out.print(s);
			System.out.println();
			
		} 
	}
	
}