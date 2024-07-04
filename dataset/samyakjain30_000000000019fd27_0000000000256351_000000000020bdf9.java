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


			int s = a[0][0];
			int e = a[0][1];
			int g=0;
			c[0] = s ;
			c[1] = e;
			ram = "C";
			// int r;
			for(int i=1;i<n;i++){
				if(sham.for_c(a[i][0] , a[i][1],c)==1){
					ram +="C";
				}
				else{
					if(g!=0){
						if(sham.for_j(a[i][0] , a[i][1],ja)==1){
							ram +="J";
						}
						else{
							ram ="IMPOSSIBLE";
						}

					}
					else{
						ja[0] = a[i][0];
						ja[1] = a[i][1];
						g=1;
						ram +="J";
					}
				}
				
			}
		
			System.out.println(ram);
		}
	}
	int for_c(int s , int e , int arry[]){
		if(((arry[0]<s)&&(s<arry[1]))||((arry[0]<e)&&(e<arry[1]))){
			return 0;
		}
		else{
			return 1;
		}
	}
	int for_j(int s , int e , int arry[]){
		if(((arry[0]<s)&&(s<arry[1]))||((arry[0]<e)&&(e<arry[1]))){
			return 0;
		}
		else{
			return 1;
		}
	}

}