import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static boolean can(ArrayList<ArrayList<Integer>> a , ArrayList<Integer> x) {
		boolean check = false;
		if(a.isEmpty())
			check = true;
		else {
			for(int i=0;i<a.size() && !check ;i++) {
				if(i==0) {
				if(a.get(i).get(0)>=x.get(1))
					check = true;
				}
				if(i==a.size()-1) {
					if(a.get(i).get(1)<=x.get(0))
						check = true;
				}
				else {
					if(a.get(i).get(1)<=x.get(0) && a.get(i+1).get(1)>=x.get(1))
						check = true;
				}
			}
		}
		return check;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Comparator<ArrayList<Integer>> compare = (ArrayList<Integer> o1,ArrayList<Integer> o2) ->  o1.get(0).compareTo(o2.get(0));
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			ArrayList<ArrayList<Integer>> a = new ArrayList<>();
			for(int j=0;j<n;j++) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(sc.nextInt());
				temp.add(sc.nextInt());
				a.add(temp);
			}
			String r = "";
			ArrayList<ArrayList<Integer>> J = new ArrayList<>();
			ArrayList<ArrayList<Integer>> C = new ArrayList<>();
			for(int j=0;j<a.size();j++) {
				if(can(C,a.get(j))) {
				     r +="C";
				     C.add(a.get(j));
				     C.sort(compare);
				}
				else {
					if(can(J,a.get(j))) {
						r+="J";
						J.add(a.get(j));
						J.sort(compare);
					}
					else {
						r = "IMPOSSIBLE";
						break;
					}
				}
					
			}
			System.out.println("Case #"+(i+1)+": "+r);
		}
	}
}