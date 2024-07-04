import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int t=0;t<T;t++) {
			System.out.print("Case #"+(t+1)+": ");
			int N=scanner.nextInt();
			int C=0;
			int J=0;
			String s="";
			int [][]arr=new int[N][2];
			for(int i=0;i<N;i++) {
				arr[i][0]=scanner.nextInt();
				arr[i][1]=scanner.nextInt();
			}
			
			arr=twoSort(arr);
			printArr(arr);
			for(int i=0;i<N;i++) {
				int a=arr[i][0];
				int b=arr[i][1];
				if(C>=J&&C<=a) {
					s+="C";
					C=b;
				}
				else if(J<=a) {
					s+="J";
					J=b;
				}
				else if(C<=a) {
					s+="C";
					C=b;
				}
				else {
					s="IMPOSSIBLE";
					break;
				}
			}
			System.out.println(s);
		}
	}

	public static int[][]twoSort(int[][]arr){
		int[][]result=new int[arr.length][2];
		
		for(int i=0;i<arr.length;i++) {
			int min=1441;
			int index=-1;
			for(int j=0;j<arr.length;j++) {
				if(arr[j][0]<min) {
					index=j;
					min=arr[j][0];
				}
			}
			result[i][0]=arr[index][0];
			result[i][1]=arr[index][1];
			arr[index][0]=1441;
		}
		return result;
	}
	public static void printArr(int[][]arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
