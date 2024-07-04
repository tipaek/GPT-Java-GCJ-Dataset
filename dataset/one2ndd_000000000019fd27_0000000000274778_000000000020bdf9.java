import java.io.*;

public class Solution{
	public static void viewArr(int[][] arr,int k){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i][k]+" ");
		}System.out.println();
	}
	public static int[][] merge(int[][] left,int[][] right,int k){
		int[][] res=new int[left.length+right.length][4];
		int r=0,R=0,l=0;
		while(l<left.length||r<right.length){
			if(l<left.length&&r<right.length){
				if(left[l][k]<=right[r][k]){ 
					res[R][0]=left[l][0]; 
					res[R][1]=left[l][1]; 
					res[R][2]=left[l][2]; 
					res[R++][3]=left[l++][3]; 
				}else{
					res[R][0]=right[r][0]; 
					res[R][1]=right[r][1]; 
					res[R][2]=right[r][2]; 
					res[R++][3]=right[r++][3];
				}
			}else if(l<left.length){
					res[R][0]=left[l][0]; 
					res[R][1]=left[l][1]; 
					res[R][2]=left[l][2]; 
					res[R++][3]=left[l++][3]; 				
			}else{
					res[R][0]=right[r][0]; 
					res[R][1]=right[r][1]; 
					res[R][2]=right[r][2]; 
					res[R++][3]=right[r++][3];
			}
		}return res;
	}
	public static int[][] mergeSort(int[][] arr,int k){
		if(arr.length<=1)	return arr;
		else{
			int len=arr.length,rightLen=0,i;
			int[][] left=new int[len/2][4];
			int[][] right; 
			if(len%2==0)	rightLen=len/2;
			else		rightLen=len/2+1;
			right=new int[rightLen][4];
			for(i=0;i<len/2;i++){ 
				left[i][0]=arr[i][0]; 
				left[i][1]=arr[i][1]; 
				left[i][2]=arr[i][2]; 
				left[i][3]=arr[i][3];
			}for(int j=0;j<rightLen;j++){
				right[j][0]=arr[i][0]; 
				right[j][1]=arr[i][1]; 
				right[j][2]=arr[i][2];
				right[j][3]=arr[i++][3];
			}left=mergeSort(left,k);
			right=mergeSort(right,k);
			return merge(left,right,k);
		}
	}
	public static boolean doesOverlap(int a,int b,int x){
		if(x>=a&&x<b)	return true;
		else		return false;
	}
	public static String assignment(int[][] interval,int N){
		interval=mergeSort(interval,0); boolean tmp;
		int lowerbound=interval[0][0],a,b,aprime,bprime;
		String sched="";
		for(int i=1;i<N;i++){
			a=interval[i-1][0]; b=interval[i-1][1];
			aprime=interval[i][0]; bprime=interval[i][1];
			if(aprime>=lowerbound){		
				int overlapCount=0;
				for(int j=i-1;j>=0;j--){
					int s=interval[j][0];
					int e=interval[j][1];
					tmp=doesOverlap(s,e,aprime);
					if(tmp==true)	overlapCount++;
				}if(overlapCount>=2)	return "IMPOSSIBLE";
				tmp=doesOverlap(a,b,aprime);
				if(tmp==true){
					lowerbound=Math.min(b,bprime);
					interval[i][3]=Math.abs(interval[i-1][3]-1);
				}else{
					lowerbound=aprime; interval[i][3]=interval[i-1][3];
				}
			}else	return "IMPOSSIBLE";
		}interval=mergeSort(interval,2);
		//viewArr(interval,3);	
		for(int i=0;i<N;i++){
			if(interval[i][3]==0)	sched+="C";
			else			sched+="J";
		}
		return sched;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//int[][] arr={{9,-1,-1},{8,-1,-1},{7,-1,-1},{6,-1,-1},{5,-1,-1},{4,-1,-1},{3,-1,-1},{2,-1,-1},{1,-1,-1}};
		//arr=mergeSort(arr,0);
		//viewArr(arr,0);
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			int N=Integer.parseInt(br.readLine());
			int[][] interval=new int[N][4];
			for(int i=0;i<N;i++){
				String[] SE=br.readLine().split(" ");
				int S=Integer.parseInt(SE[0]); 
				int E=Integer.parseInt(SE[1]); 
				interval[i][0]=S; interval[i][1]=E; interval[i][2]=i;
			}System.out.println("Case #"+t+": "+assignment(interval,N));
		}
	}
}