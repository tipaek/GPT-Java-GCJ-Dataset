import java.util.*;
import java.io.IOException;
public class Solution {
static Scanner scan = new Scanner(System.in);
	public static void check(int arr[] , int arr1[]){
		int a=0 , b=0;
		String str="";
		int c=-1 ,d=-1 ;
		for(int i=0;i<arr.length;i++){
			if(i==0){
				a=arr[i]; 
				b=arr1[i];
				str+="C";
			}
	
			else {
				if((a>arr[i] && a>=arr1[i]) || (b<=arr[i] && b<arr1[i]) )
				{
					str+="C";
					a=arr[i]; b=arr1[i];
				}
				else {
					if(c==-1 && d==-1){
					c=arr[i];  d=arr1[i];
					str+="J";
					}
					else {if((c>arr[i] && c>=arr1[i]) || (d<=arr[i] && d<arr1[i]) ){
						c=arr[i];  d=arr1[i];
						str+="J";
					}else{
						str="IMPOSSIBLE";
					}
						
					}
				}
			}
		}
		System.out.println(str);
	}
	public static void main(String[] args) throws IOException {
		Solution pt = new Solution();
		int s=scan.nextInt();
		for(int k=1;k<=s;k++){
		int a = scan.nextInt();
		int arr[]=new int[a];
		int arr1[]=new int[a];
		
		for(int i=0;i<a;i++){
			arr[i]=scan.nextInt();
			arr1[i]=scan.nextInt();
		}
		System.out.print("Case #"+k+": ");
		pt.check(arr, arr1);
		}
		

	}

}
