import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++){
			
			int N = sc.nextInt();
			int K = sc.nextInt();

			System.out.print("Case #"+(i + 1)+": ");
			if(K % N != 0 || K > N*N)System.out.println("IMPOSSIBLE");
			else{
				System.out.println("POSSIBLE");
				int num = K / N - 1;
				for(int j = 0; j < N; j++){
					for(int k = 0; k < N; k++){
						System.out.print(((num - j + k + N) % N) + 1);
						if(k != N - 1)System.out.print(" ");
					}
					System.out.println();
				}
			}
		}
	}
}