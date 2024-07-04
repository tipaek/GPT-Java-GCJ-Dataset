package CodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CJ20_Vestigium {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			int n = Integer.parseInt(br.readLine());

			int sum = 0;
			int row_count = 0;
			int column_count = 0;

			int[][] ar = new int[n][n];

			for(int i=0 ; i<n ; i++) {
				boolean fin = false;
				String[] input = br.readLine().split(" ");
				boolean[] check = new boolean[n];
				for(int j=0 ; j<n ; j++) {
					int value = Integer.parseInt(input[j]);
					if(i==j) sum += value;						
					ar[i][j] = value;
					if(!fin) {
						if(!check[value-1]) {
							check[value-1] = true;
						}
						else {
							row_count++;
							fin = true;
						}						
					}
				}
			}

			for(int i=0 ; i<n ; i++) {
				boolean[] check = new boolean[n];
				for(int j=0 ; j<n ; j++) {
					int value = ar[j][i];
					if(!check[value-1]) {
						check[value-1] = true;
					}
					else {
						column_count++;
						break;
					}
				}
			}
			bw.write("Case #"+tt+": "+sum+" "+row_count+" "+column_count+"\n");
		}

		bw.flush();
	}
}
