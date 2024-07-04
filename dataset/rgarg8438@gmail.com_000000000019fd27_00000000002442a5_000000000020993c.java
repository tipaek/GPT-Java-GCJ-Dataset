import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

 class Solution {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int cases = sc.nextInt();
	for (int i = 0; i < cases; i++) {
		int n = sc.nextInt();
		HashSet<Integer> hs = new HashSet<Integer>();
		int arr[][]= new int[n][n];
		int k=0,r=0,c=0;
		boolean r_tag=true;
		for (int j = 0; j < n; j++) {
			hs.clear();
			r_tag=true;
			for (int j2 = 0; j2 < n; j2++) {
				int num = sc.nextInt();
				arr[j][j2]=num;
				if(hs.contains(num))
					r_tag=false;
				else
					hs.add(num);
				if(j==j2)
					k+=num;
				
			}
			if(!r_tag)
				r++;
		}
		for (int j = 0; j < n; j++) {
			hs.clear();
			r_tag=true;
			for (int j2 = 0; j2 < n; j2++) {
				int num = arr[j2][j];
				if(hs.contains(num))
					r_tag=false;
				else
					hs.add(num);
			}
			if(!r_tag)
				c++;
		}
		System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
		
	}
	
}
}