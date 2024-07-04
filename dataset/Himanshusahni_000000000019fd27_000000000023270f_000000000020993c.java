import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
public class Solution{
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int t = 1;t<=testCases;t++){
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];
			for(int i = 0;i<N;i++){
				String str[] = br.readLine().split(" ");
				for(int j = 0;j<N;j++){
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			int k = findTrace(arr);
			int r = findRows(arr);
			int c = findCols(arr);
			System.out.println("Case #"+t+": "+k+" "+r+" "+c);
		}
	}
	public static int findTrace(int arr[][]){
		int k = 0 ;
		for(int i = 0,j = 0 ;i<arr[0].length;i++,j++)
			k +=arr[i][j];
		return k ;
	}
	public static int findRows(int arr[][]){
		int count = 0;
		HashSet<Integer> set = null;
		for(int i = 0;i<arr.length;i++){
			set = new HashSet<>();
			for(int j = 0;j<arr[0].length;j++){
				if(set.contains(arr[i][j])){
					count++;
					break;
				}else
					set.add(arr[i][j]);
				
			}
		}
		return count;
	}
	public static int findCols(int arr[][]){
		int count = 0;
		HashSet<Integer> set = null;
		for(int i = 0;i<arr.length;i++){
			set = new HashSet<>();
			for(int j = 0;j<arr[0].length;j++){
				if(set.contains(arr[j][i])){
					count++;
					break;
				}else
					set.add(arr[j][i]);
			}
		}
		return count;
	}
}