import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int p = t;
		while(t-->0) {
			int n = scn.nextInt();
			Pair[] arr = new Pair[n];
			for(int i=0; i<n; i++) {
				int a = scn.nextInt();
				int b = scn.nextInt();
				Pair l = new Pair(a,b,i);
				arr[i] = l;
			}
			Arrays.sort(arr);
			char[] ch = new char[n];
			int flag = 0;
			int s1 = 0, s2=0, e1=0, e2=0;
			for(int i=0; i<n; i++) {
				if(arr[i].a >= e1) {
					ch[arr[i].c] = 'C';
					e1 = arr[i].b;
				}else if(arr[i].a >= e2) {
					ch[arr[i].c] = 'J';
					e2 = arr[i].b;
				}else {
					flag = 1;
					break;
				}
			}
			if(flag == 1) {
				System.out.println("Case #" + (p-t) + ": IMPOSSIBLE");
				continue;
			}
			System.out.print("Case #" + (p-t) + ": ");
			for(int i=0; i<n; i++) {
				System.out.print(ch[i]);
			}
			System.out.println();
		}
	}
	public static class Pair implements Comparable<Pair>{
		int a;
		int b;
		int c;
		Pair(int x, int y, int z){
			a=x;b=y;c=z;
		}
		public int compareTo(Pair k){
			if(this.a != k.a)
				return this.a - k.a;
			return this.b - k.b;
		}
	}

}

