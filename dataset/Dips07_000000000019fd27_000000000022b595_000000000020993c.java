import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()), i, j, k, N, trace, row, column, arr[][];
		String s, str[];
		for(i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			trace = 0;
			arr = new int[N][N];
			for(j = 0; j < N; j++) {
				s = br.readLine();
				str = s.split(" ");
				for(k = 0; k < N; k++) {
					arr[j][k] = Integer.parseInt(str[k]);
					if(j == k)
						trace += arr[j][k];
				}
			}
			row = findRepeatRows(arr);
			column = findRepeatColumn(arr);
			System.out.println("Case #" + i + ": " + trace + " " + row + " " + column);
		}
	}
	
	private static int findRepeatRows(int arr[][]) {
		int i, j , row = 0;
		Set<Integer> rowElems;
		for(i = 0; i < arr.length; i++) {
			rowElems = new HashSet<>();
			for(j = 0; j < arr.length; j++) {
				if(rowElems.contains(arr[i][j])) {
					row++;
					break;
				}else {
					rowElems.add(arr[i][j]);
				}
			}
		}
		return row;
	}
	
	private static int findRepeatColumn(int arr[][]) {
		int i, j , col = 0;
		Set<Integer> colElems;
		for(i = 0; i < arr.length; i++) {
			colElems = new HashSet<>();
			for(j = 0; j < arr.length; j++) {
				if(colElems.contains(arr[j][i])) {
					col++;
					break;
				}else {
					colElems.add(arr[j][i]);
				}
			}
		}
		return col;
	}

}
