import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	public static String getA(ArrayList<ArrayList<Integer>> a) {
		String r = "";
		int c = 0;
		int j = 0;
		for(int i=0;i<a.size();i++) {
			if(j<=a.get(i).get(0)) {
				r +="J";
				j = a.get(i).get(1);
			}
			else {
				if(c<=a.get(i).get(0)) {
					r +="C";
					c = a.get(i).get(1);
				}
				else {
					return "IMPOSSIBLE";
				}
			}
		}
		return r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Comparator<ArrayList<Integer>> compare = (ArrayList<Integer> o1,ArrayList<Integer> o2) ->  o1.get(0).compareTo(o2.get(0));
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int A = sc.nextInt();
			ArrayList<ArrayList<Integer>> a = new ArrayList<>();
			ArrayList<ArrayList<Integer>> old = new ArrayList<>();
			for(int j=0;j<A;j++) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(sc.nextInt());
				temp.add(sc.nextInt());
				a.add(temp);
				old.add(temp);
			}
			a.sort(compare);
			String n = getA(a);
			char[] tem = new char[n.length()];
			int pos = 0;
			for(int j=0;j<a.size()&& !n.equals("IMPOSSIBLE");j++) {
				pos = old.indexOf(a.get(j));
				tem[pos] = n.charAt(j);
			}
			String r = "";
			for(int j=0;j<tem.length;j++) {
				r += tem[j];
			}
			if(n.equals("IMPOSSIBLE"))
				r = n;
			System.out.println("Case #"+(i+1)+": "+r);
		}
	}


}