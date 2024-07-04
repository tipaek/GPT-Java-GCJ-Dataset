
import java.io.*;
import java.util.*;

public class Solution {
	public static boolean hasRepeatRow(int[][] a, int r){
		Set<Integer> s = new HashSet<>();
		for(int i=0;i<a[r].length;i++){
			int temp = a[r][i];
			if(s.contains(temp)) return true;
			else s.add(temp);
		}
		return false;
	}
	public static boolean hasRepeatCol(int[][] a, int c){
		Set<Integer> s = new HashSet<>();
		for(int i=0;i<a.length;i++){
			int temp = a[i][c];
			if(s.contains(temp)) return true;
			else s.add(temp);
		}
		return false;
	}
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test =1; test<=T;test++){
			st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int [][] a = new int[N][N];
			int trace = 0;
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					a[i][j]=Integer.parseInt(st.nextToken());
					if(i==j) trace+=a[i][j];
				}
			}
			int row = 0;
			int col=0;
			for(int i=0;i<N;i++){
				if(hasRepeatRow(a,i)) row++;
				if(hasRepeatCol(a,i)) col++;
			}
			System.out.println("Case #" + test + ": "+ trace  + " " + row + " "+ col);
		}
	}
}
