import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
   		for(int t=1;t<=T;t++){
   			int r = sc.nextInt(),c=sc.nextInt();
			int arr[][] = new int[r][c];
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					arr[i][j]  = sc.nextInt();
				}
			}
			boolean flag = true;
			long res=0;
		
			while(flag){
			flag = false;
			res += findSum(arr,r,c);
		
			int narr[][] = new int[r][c];
			makeEqual(narr,arr,r,c);
				for(int i=0;i<r;i++){
					for(int j=0;j<c;j++){
						if(arr[i][j]!=-1){
							if(makeChanges(i,j,narr,arr,r,c))
							flag = true;
						}
					}
				}
				arr = narr;
			}
			
       System.out.println("Case #"+t+": "+res);
	   }
	   }
	  static void makeEqual(int narr[][],int arr[][],int r,int c){
	  	for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				narr[i][j] = arr[i][j];
			}
		}
	  }
	static long findSum(int arr[][],int r,int c){
		long res = 0;	
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(arr[i][j]!=-1) res+=arr[i][j];
			}
		}
		return res;
	}
	static boolean makeChanges(int i,int j,int narr[][],int arr[][],int row,int col){
		double a=0,b=0,c=0,d=0;
		int count=0;
		double ans=0;
		for(int l=j-1;l>=0;l--){
			if(arr[i][l]!=-1){
				a = arr[i][l];
				count++;
				break;
			}
		}
		for(int r=j+1;r<col;r++){
			if(arr[i][r]!=-1){
				b = arr[i][r];count++;
				break;
			}
		}
		for(int u=i-1;u>=0;u--){
			if(arr[u][j]!=-1){
				c = arr[u][j];count++;
				break;
			}
		}
		for(int dow=i+1;dow<row;dow++){
			if(arr[dow][j]!=-1){
				d = arr[dow][j];count++;
				break;
			}
		}
		if(count == 0)return false;
		ans = (a+b+c+d)/count;
		if(ans > arr[i][j]){
			narr[i][j] = -1;return true;
		}
		return false;
		
	}
	
	}