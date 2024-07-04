import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		
		//System.out.println('A'-65);
		Scanner in =new Scanner(System.in);
		
		int T=Integer.parseInt(in.nextLine());
		
		for(int i=0;i<T;i++){
			
			int U=Integer.parseInt(in.nextLine());
			
			
			int[][] mapping=new int[16][26];
			int[] simpMap=new int [26];
			
			for(int z=0;z<10000;z++){
				String line=in.nextLine();
				
				String R=line.split(" ")[1];
				
				int maxL=R.length()>2?2:R.length();
				
				for(int a=0;a<maxL;a++){
					simpMap[R.charAt(a)-65]++;
					int pos =R.length()-1-a;
					
					//mapping[pos][R.charAt(a)-65]++;
					
				}
			}
			
			int[][] ans=new int [10][2];
			int anspos=0;
			for(int j=0;j<simpMap.length;j++){
				
				if(simpMap[j]>0){
					ans[anspos][0]=j;
					ans[anspos][1]=simpMap[j];
					anspos++;
				}
			}
			
			
			java.util.Arrays.sort(ans, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[1], b[1]);
				}
			});
			
			//printMat2(ans);
			//printMat(mapping);
			String finalAns="";
			finalAns+=String.valueOf((char) (ans[0][0]+65));
			finalAns+=String.valueOf((char) (ans[9][0]+65));
			finalAns+=String.valueOf((char) (ans[8][0]+65));
			finalAns+=String.valueOf((char) (ans[7][0]+65));
			finalAns+=String.valueOf((char) (ans[6][0]+65));
			finalAns+=String.valueOf((char) (ans[5][0]+65));
			finalAns+=String.valueOf((char) (ans[4][0]+65));
			finalAns+=String.valueOf((char) (ans[3][0]+65));
			finalAns+=String.valueOf((char) (ans[2][0]+65));
			finalAns+=String.valueOf((char) (ans[1][0]+65));
			System.out.println("Case #"+(i+1)+": "+finalAns);
		}
	}
	
	public static String solve(){
		return "";
	}
	
	public static void printArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]+", "+String.valueOf((char) (i+65)));
		}
	}
	
	public static void printMat(int[][] mat){
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				if(mat[i][j]!=0){
					
				
					System.out.print(String.valueOf((char) (65+j))+": "+mat[i][j]+", ");
				}
			}
			System.out.println();
		}
	}
	
	public static void printMat2(int[][] mat){
		for(int i=0;i<mat.length;i++){
			
			
			System.out.println(String.valueOf((char)(mat[i][0]+65))+": "+mat[i][1]);
		}
	}
	
	
//T B H
	
}