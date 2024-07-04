/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void printRes(int r, int s, int t) {
		int total = r*s;
		int val = total - r - 1;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		while(r>1) {
			int tmp = s;
			while(tmp>1){
				ArrayList<Integer> a = new ArrayList<>();
				a.add(r);
				a.add(val--);
				tmp--;
				res.add(a);
			}
			r--;
		}
		System.out.println("Case #" + t + ": " + res.size());
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++){
			int r = sc.nextInt();
			int s = sc.nextInt();
			printRes(r, s, i);
		}
	}
}