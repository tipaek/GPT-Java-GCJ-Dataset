import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		
		
		for (int i = 1; i <= T; i++) {
			String res = "POSSIBLE";
			int n = sc.nextInt();
			int K = sc.nextInt();
			Set<Integer> set = new HashSet<>();
			String permutaion = genString(n);
			
			if (n % 2 != 0) {
				for (int j = 1; j <=n; j++) {
					set.add(j * n);
				}
				
				set.add(((1 + n) * n) / 2);
				
				if (!set.contains(K)) {
					res = "IMPOSSIBLE";
				}
			} else {
				for (int k = 1; k <= n; k++) {
					set.add(k * n);
				}
				
				if (!set.contains(K)) {
					res = "IMPOSSIBLE";
				}
			}
			
			System.out.println("Case #" + i + ": " + res);
			
			if (res.equals("IMPOSSIBLE")) { break;}
			
			int diag = (K / n);
			
			int start = ((n - diag)) % n;
			
			for (int l = 0; l < permutaion.length(); l++) {
				permutaion = genString(n);
				String rev = reverseK(permutaion.toCharArray(), start);
				
				for (int ic = 0; ic < rev.length(); ic++) {
					if (ic == rev.length() - 1) {
						System.out.println(rev.charAt(ic));
					} else {
						System.out.print(rev.charAt(ic) + " ");
					}
				}
				start = (start + 1) % n;
			}
			
			
		}
		sc.close();
	}
	
	private static String genString(int n) {
		String str = "";
		
		for (int i = 1; i <= n; i++) {
			str += ("" + i);
		}
		
		return str;
	}
	
	private static void reverse(char[] arr, int left, int right) {
		while (left < right) {
			char tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
			left++;
			right--;
		}
	}
	
	private static String reverseK(char[] arr, int k) {
		String res = "";
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, k);
		reverse(arr, k+1, arr.length - 1);
		
		return new String(arr);
	}
	
}

;