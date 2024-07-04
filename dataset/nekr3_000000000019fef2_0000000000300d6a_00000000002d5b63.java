import java.util.*;
import java.io.*;
public class Solution {
	static int size = 1000000000;
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		String fjiso = in.nextLine();
		for (int s = 1; s <= t; s++) {
			int x = 0;
			int y = 0;
			boolean hit = false;
			boolean cen = false;
			for (int i = 0; i < 7 && !hit && !cen; i++) {
				for (int j = 0; j < 7 && !hit && !cen; j++) {
					x = -size/4 + 250000000*i;
					y = -size/4 + 250000000*j;
					System.out.println(x + " " + y);
					String result = in.nextLine();
					if (result.equals("CENTER")) cen = true;
					if (result.equals("HIT")) hit = true;
				}
			}
			if (cen) continue;
			int first = x;
			int last = size;
			int mid = (first + last)/2;
			while (first <= last && !cen) {
				System.out.println(mid + " " + y);
				String res = in.nextLine();
				if (res.equals("CENTER")) cen = true;
				else {
					if (res.equals("HIT")) first = mid + 1;
					else last = mid - 1;
					mid = (first+last)/2;
				}
			}
			if (cen) continue;
			int right = last;
			first = -size;
			last = x;
			mid = (first + last)/2;
			while (first <= last && !cen) {
				System.out.println(mid + " " + y);
				String res = in.nextLine();
				if (res.equals("CENTER")) cen = true;
				else {
					if (res.equals("HIT")) first = mid + 1;
					else last = mid - 1;
					mid = (first+last)/2;
				}
			}
			if (cen) continue;
			int left = first;
			first = -size;
			last = y;
			mid = (first + last)/2;
			while (first <= last && !cen) {
				System.out.println(x + " " + mid);
				String res = in.nextLine();
				if (res.equals("CENTER")) cen = true;
				else {
					if (res.equals("HIT")) first = mid + 1;
					else last = mid - 1;
					mid = (first+last)/2;
				}
			}
			if (cen) continue;
			int top = first;
			first = y;
			last = size;
			mid = (first + last)/2;
			while (first <= last && !cen) {
				System.out.println(x + " " + mid);
				String res = in.nextLine();
				if (res.equals("CENTER")) cen = true;
				else {
					if (res.equals("HIT")) first = mid + 1;
					else last = mid - 1;
					mid = (first+last)/2;
				}
			}
			if (cen) continue;
			int bottom = last;
			System.out.println(((left + right)/2) + " " + ((top + bottom)/2));
			String res = in.nextLine();
		}
		in.close();
	}
}