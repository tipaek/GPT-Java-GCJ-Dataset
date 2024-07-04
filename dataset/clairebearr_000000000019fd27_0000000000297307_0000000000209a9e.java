import java.io.*;
import java.util.*;

//solution
public class Solution {
	
	static int b;
	static int[] arr;
	static boolean complement = true, reverse = true, comprev = true, none = true;;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		b = sc.nextInt();
		outer : for (int test = 1; test <= t; test++) {
			arr = new int[b+1];
//			arr[0] = -1;
			Arrays.fill(arr, -1);
			for (int i = 1; i <= 5; i++) {
				System.out.println(i);
				arr[i] = sc.nextInt();
			}
			for (int i = b - 5 + 1; i <= b; i++) {
				System.out.println(i);
				arr[i] = sc.nextInt();
			}
			if (b == 10) {
				for (int i = 1; i <= b; i++) {
					System.out.print(arr[i]);
				}
				System.out.println();
				String str = sc.next();
				if (str.equals("N")) {
					return;
				}
				continue outer;
			}
//			System.out.println(Arrays.toString(arr));
			test(1, 5, sc, false);
			for (int i = 6; i <= 10; i++) {
				System.out.println(i);
				arr[i] = sc.nextInt();
			}
			//fine 
//			System.out.println("idfk" + Arrays.toString(arr));
//			test(6, 10, sc, true);
			complement = true; reverse = true; comprev = true; none = true;
			int[] copy = Arrays.copyOf(arr, b+1);
			int[] received = new int[b+1];
			for (int i = 6; i <= 10; i++) {
				System.out.println(i);
//				System.out.println("hola");
				int receive = sc.nextInt();
				received[i] = receive;
				if (receive != (arr[i]+1)%2) complement = false;
				if (receive != arr[i]) none = false;
				copy[i] = receive;
//				if (arr[b-i+1] == -1) continue;
//				if (receive != arr[b-i+1]) reverse = false;
//				if (receive != (arr[b-i+1]+1)%2) comprev = false;
			}
//			System.out.println("received " + Arrays.toString(received));
//			if (complement || none) {
//				for (int i = 1; i <= b; i++)
//					arr[i] = (copy[i]+1)%2;
//			}
			//change has happened
			int[] idk = new int[b+1];
			reverse = true; comprev = true; 
			for (int i = 11; i <= 15; i++) {
				System.out.println(i);
				int receive = sc.nextInt();
				copy[i] = receive;
				if (receive != arr[b-i+1]) reverse = false;
				if (receive != (arr[b-i+1]+1)%2) comprev = false;
			}
//			System.out.println(Arrays.toString(copy));
//			System.out.println(complement + " " + none + " " + reverse + " " + comprev);
			int count = 0;
			if (none) count++;
			if (complement) count++;
			if (reverse) count++;
			if (comprev) count++;
//			if (none) {
//				
//			} else if (complement) {
//				for (int i = 6; i <= 15; i++)
//					arr[i] = (copy[i]+1)%2;
//			} else if (reverse ) {
//				for (int i = 6; i <= 15; i++)
//					arr[i] = copy[b-i+1];
//			} else {
//				for (int i = 6; i <= 15; i++)
//					arr[i] = (copy[b-i+1]+1)%2;
//			}
//			System.out.println("Ded");
			if (count > 1) {
//				copy = Arrays.copyOf(arr, b+1);
				complement = true; reverse = true; comprev = true; none = true;
				for (int i = 1; i <= 5; i++) {
					System.out.println(i);
//					System.out.println("ded");
//					System.out.println("hola");
					int receive = sc.nextInt();
					if (receive != (arr[i]+1)%2) complement = false;
					if (receive != arr[i]) none = false;
					if (arr[b-i+1] == -1) continue;
					if (receive != arr[b-i+1]) reverse = false;
					if (receive != (arr[b-i+1]+1)%2) comprev = false;
				}
				if (none) {
					for (int i = 1; i <= b; i++)
						arr[i] = copy[i];
				} else if (complement) {
					for (int i = 1; i <= b; i++) {
						arr[i] = (copy[i]+1)%2;
						if (i > 5 && i <= 15) 
							arr[i] = copy[i];
					}
				} else if (reverse ) {
					for (int i = 1; i <= b; i++) {
						arr[i] = copy[b-i+1];
//						if (i == 5) i += 10;
						if (i > 5 && i <= 15) 
							arr[i] = copy[i];
					}
				} else {
					for (int i = 1; i <= b; i++) {
						arr[i] = (copy[b-i+1]+1)%2;
//						if (i == 5) i += 10;
						if (i > 5 && i <= 15) 
							arr[i] = copy[i];

					}
				}
			} else {
				if (none) {
					for (int i = 1; i <= b; i++)
						arr[i] = copy[i];
				} else if (complement) {
					for (int i = 1; i <= b; i++) {
						arr[i] = (copy[i]+1)%2;
						if (i > 5 && i <= 15) 
							arr[i] = copy[i];					}
				} else if (reverse ) {
					for (int i = 1; i <= b; i++) {
						arr[i] = copy[b-i+1];
						if (i > 5 && i <= 15) 
							arr[i] = copy[i];					}
				} else {
					for (int i = 1; i <= b; i++) {
						arr[i] = (copy[b-i+1]+1)%2;
						if (i > 5 && i <= 15) 
							arr[i] = copy[i];
					}
				}
			}
//			System.out.println(Arrays.toString(arr));
			for (int i = 1; i <= b; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			String str = sc.next();
			if (str.equals("N")) {
				return;
			}
		}
	}
	
	static void test(int start, int end, Scanner sc, boolean symmetry) {
		complement = true; reverse = true; comprev = true; none = true;
		int[] copy = Arrays.copyOf(arr, b+1);
		for (int i = start; i <= end; i++) {
			System.out.println(i);
//			System.out.println("hola");
			int receive = sc.nextInt();
			if (receive != (arr[i]+1)%2) complement = false;
			if (receive != arr[i]) none = false;
			if (arr[b-i+1] == -1) continue;
			if (receive != arr[b-i+1]) reverse = false;
			if (receive != (arr[b-i+1]+1)%2) comprev = false;
		}
		if (none) {
			
		} else if (complement) {
			for (int i = 1; i <= b; i++)
				arr[i] = (copy[i]+1)%2;
		} else if (reverse ) {
			for (int i = 1; i <= b; i++)
				arr[i] = copy[b-i+1];
		} else {
			for (int i = 1; i <= b; i++)
				arr[i] = (copy[b-i+1]+1)%2;
		}
		if (symmetry) {
			int count = 0;
			if (none) count++;
			if (complement) count++;
			if (reverse) count++;
			if (comprev) count++;
			if (count > 0) {
				test(1, 5, sc, false);
			}
		}
	}

}
