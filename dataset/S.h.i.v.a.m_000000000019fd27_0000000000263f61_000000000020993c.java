import java.util.*;
import java.io.*;

public class Solution{
	static int r = 0;
	static int c = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(br.readLine());
		int x = 1;
		while(x<=t){
			r = 0;
			c = 0;
			int n = Integer.parseInt(br.readLine());
			int k = 0;
			int[][] arr = new int[n][n];
			for(int i = 0;i<n;i++){
				String str = br.readLine();
				String[] s = str.split(" ");
				for(int j = 0;j<n;j++){
					arr[i][j] = Integer.parseInt(s[j]);
					if(i == j){
						k+= arr[i][j];
					}
				}
			}
			sort(arr,0,0);
			System.out.println("CASE #"+x+": "+k+" "+r+" "+c);
			x++;
		}
	}
	public static void sort(int[][] arr,int i,int j){
		while(i<arr.length){
			Map<Integer,Integer> mp = new HashMap<>();
			for(int k = 0;k<arr.length;k++){
				if(mp.containsKey(arr[i][k])){
					r += 1;
					break;
				}
				else{
					mp.put(arr[i][k],1);
				}
			}
			i++;
		}
		while(j<arr.length){
			Map<Integer,Integer> map = new HashMap<>();
			for(int k = 0;k<arr.length;k++){
				if(map.containsKey(arr[k][j])){
					c += 1;
					break;
				}
				else{
					map.put(arr[k][j],1);
				}
			}
			j++;
		}
	}
}