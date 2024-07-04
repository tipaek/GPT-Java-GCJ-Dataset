import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			bw.write("Case #"+ t+":\n");
			int N = Integer.parseInt(br.readLine());
			
			int r = 1;
			int k = 1;
			int next = 0;
			while(N != 0) {
				if(N%2 == 0) {
					N /= 2;
					next ++;
				}
				else {
					if(next % 2 == 0) {
						if(k == 1) {
							for(int i = 1; i<=next; i++) {
								for(int j = 1; j<=i; j++) {
									if(i%2 == 1) {
										bw.write(r+" "+ k+"\n");
										if(j == i) {
											r++;
										}
										else {
											k--;
										}
									}
									else {
										bw.write(r+" " + k+"\n");
										if(j == i) {
											r++;
											k++;
										}
										else {
											k++;
										}
									}
								}
							}
							while(k != r) {
								bw.write(r+" " + k + "\n");
								k++;
							}
							bw.write(r+" " + k + "\n");
							r++;
							k++;
						}
						else {
							for(int i = 1; i<=next; i++) {
								for(int j = 1; j<=i; j++) {
									if(i%2 == 0) {
										bw.write(r+" "+ k+"\n");
										if(j == i) {
											r++;
										}
										else {
											k--;
										}
									}
									else {
										bw.write(r+" " + k+"\n");
										if(j == i) {
											r++;
											k++;
										}
										else {
											k++;
										}
									}
								}
							}
							while(k != 1) {
								bw.write(r+" " + k + "\n");
								k--;
							}
							bw.write(r+" " + k + "\n");
							r++;
						}
					}
					else {
						if(k == r) {
							for(int i = 1; i<=next; i++) {
								for(int j = 1; j<=i; j++) {
									if(i%2 == 1) {
										bw.write(r+" "+ k+"\n");
										if(j == i) {
											r++;
										}
										else {
											k--;
										}
									}
									else {
										bw.write(r+" " + k+"\n");
										if(j == i) {
											r++;
											k++;
										}
										else {
											k++;
										}
									}
								}
							}
							while(k != 1) {
								bw.write(r+" " + k + "\n");
								k--;
							}
							bw.write(r+" " + k + "\n");
							r++;
						}
						else {
							for(int i = 1; i<=next; i++) {
								for(int j = 1; j<=i; j++) {
									if(i%2 == 0) {
										bw.write(r+" "+ k+"\n");
										if(j == i) {
											r++;
										}
										else {
											k--;
										}
									}
									else {
										bw.write(r+" " + k+"\n");
										if(j == i) {
											r++;
											k++;
										}
										else {
											k++;
										}
									}
								}
							}
							while(k != r) {
								bw.write(r+" " + k + "\n");
								k++;
							}
							bw.write(r+" " + k + "\n");
							r++;
							k++;
						}
						
					}
					N /=2;
					next = 0;
				}
				
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}


