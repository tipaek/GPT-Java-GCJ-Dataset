import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String[] l = in.nextLine().split(" ");
		int t = Integer.parseInt(l[0]);
		int b = Integer.parseInt(l[1]);
		for (int x = 1; x <= t; x++) {
			int[] arr = new int[b];
			int known = 0;
			int flipcheck = -1;
			int flipval = -1;
			int revcheck = -1;
			int revval = -1;
			for (int i = 1; i <= 5; i++)  {
				System.out.println(i);
				int start = Integer.parseInt(in.nextLine());
				System.out.println(b-i+1);
				int end = Integer.parseInt(in.nextLine());
				arr[i-1] = start;
				arr[b-i] = end;
				if (start == end) {
					flipcheck = i;
					flipval = start;
				}
				else {
					revcheck = i;
					revval = start;
				}
				known += 2;
			}
			if (known >= b) {
				finish(arr);
				if (in.nextLine.equals("Y")) continue;
				else break;
			}
			int next = 6;
			for (int i = 11; i <= 150 && known < b; i++) {
				if (i%10 == 1) {
					if (flipcheck > -1) {
						System.out.println(flipcheck);
						int res = Integer.parseInt(in.nextLine());
						i++;
						if (res != flipval) {
							flip(arr);
							if (flipval == 0) flipval = 1;
							else flipval = 0;
							if (revval == 0) revval = 1;
							else if (revval == 1) revval = 0;
						}
					}
					if (revcheck > -1) {
						System.out.println(revcheck);
						int res = Integer.parseInt(in.nextLine());
						i++;
						if (res != revval) {
							rev(arr);
							if (revval == 0) revval = 1;
							else revval = 0;
						}
					}
				}
				System.out.print(next);
				int s = Integer.parseInt(in.nextLine());
				System.out.print(b-next+1);
				int e = Integer.parseInt(in.nextLine());
				arr[next-1] = s;
				arr[b-next] = e;
				if (s == e) {
					flipcheck = i;
					flipval = s;
				}
				else {
					revcheck = i;
					revval = s;
				}
				known += 2;
			}
			finish(arr);
			if (!in.nextLine.equals("Y")) break;
		}
		in.close();
	}
	static void flip(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) arr[i] = 1;
			else arr[i] = 0;
		}
	}
	static void rev(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int tmp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = tmp;
		}
	}
	static void finish(int[] arr) {
		String ret = "";
		for (int i = 0; i < arr.length; i++) ret = ret + arr[i];
		System.out.println(ret);
	}
}