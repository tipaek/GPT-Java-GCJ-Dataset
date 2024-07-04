import java.io.*;
public class Solution{
	public static void printShedule(int arr[][]){
		int total[] = new int[1441];
		boolean flag = true;
		for(int i =0;i<arr[0].length;i++){
			for(int k = arr[0][i];k<=arr[1][i];k++){
				total[k] = total[k]+1;
				if(total[k] == 3){
					System.out.print("IMPOSSIBLE");
					return;
				}
				// if(total[k] == 2){
				// 	flag = false;
				// }
			}
		}
		// if(flag)
			for(int i = 0;i<arr[0].length;i++)
				System.out.print("J");

	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 1;i<=testCase;i++){
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[2][N];
			for(int j = 0;j<N;j++){
				String s[] = br.readLine().split(" ");
				arr[0][j] = Integer.parseInt(s[0])+1; 
				arr[1][j] = Integer.parseInt(s[1]);
			}
			System.out.print("Case #"+i+": ");
			printShedule(arr);
			System.out.println();
		}
	}

}