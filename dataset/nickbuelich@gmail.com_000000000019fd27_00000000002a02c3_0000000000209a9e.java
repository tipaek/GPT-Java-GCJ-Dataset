import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		int B = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			HashSet<String> HS = new HashSet<String>();
			char[] last = new char[10];
			for(int a=0;a<10;a++){
				System.out.println(a+1);
				System.out.flush();
				last[a]=sc.next().toCharArray()[0];
			}
			System.out.println(String.valueOf(last));
			System.out.flush();
			//answer
			sc.next();
		}
	}
}
