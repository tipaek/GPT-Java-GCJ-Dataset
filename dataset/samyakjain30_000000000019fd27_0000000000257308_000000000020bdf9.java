import java.util.*;
import java.lang.*; 
class Solution{
	public static void main(String[] args) {
		Scanner sam = new Scanner(System.in);
		int t = sam.nextInt();
		Solution sham  = new Solution();
		String ram = "";
		for(int r=1;r<=t;r++)
		{
			int n = sam.nextInt();
			int a[][] = new int [n][2];
			int c [] = new int [2];
			int ja [] = new int [2];
			for(int i=0;i<n;i++){
				for(int j=0;j<2;j++){
					a[i][j] = sam.nextInt();
				}
			}
			c[0]= a[0][0];
			c[1]= a[0][1];
			int g=0;
			ram = "J";
			for(int i=1;i<n;i++){
				if(sham.fun(a[i][0] , a[i][1],c)==1){
					ram +="J";
				}
				else{
					if(g!=0){
						if(sham.fun(a[i][0] , a[i][1],ja)==1){
							ram +="C";
						}
						else{
							ram ="IMPOSSIBLE";
						}

					}
					else{
						ja[0] = a[i][0];
						ja[1] = a[i][1];
						g=1;
						ram +="C";
					}
				}
				
			}
		
			System.out.println("Case #"+r+": "+ram);
		}
	}
	int fun(int s , int e , int arry[]){
		if(((arry[0]<s)&&(s<arry[1]))||((arry[0]<e)&&(e<arry[1]))){
			return 0;
		}
		else{
			return 1;
		}
	}
}