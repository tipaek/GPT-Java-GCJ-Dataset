import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;


public class Solution {

	
	public static boolean can(ArrayList<ArrayList<Integer>> a,ArrayList<Integer> x) {
		boolean check = false;
		if(a.isEmpty())
			check = true;
		else {
			for(int i=0;i<a.size() && !check ;i++) {
				if(a.size()==1) {
					if(a.get(i).get(1)<=x.get(0))
						check = true;
				}
				if(i==0) {
				if(a.get(i).get(0)>=x.get(1))
					check = true;
				}
				else {
				if(i==a.size()-1) {
					if(a.get(i).get(1)<=x.get(0))
						check = true;
				}
				else {
					if(a.get(i-1).get(1)<=x.get(0) && x.get(1)<=a.get(i).get(0))
						check = true;
				}
				}
			}
		}
		return check;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Comparator<ArrayList<Integer>> compare = (ArrayList<Integer> o1,ArrayList<Integer> o2) ->  o1.get(0).compareTo(o2.get(0));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Integer>> a = new ArrayList<>();
			for(int j=0;j<n;j++) {
				ArrayList<Integer> temp = new ArrayList<>();
				String[] tem = br.readLine().split(" ");
				temp.add(Integer.parseInt(tem[0]));
				temp.add(Integer.parseInt(tem[1]));
				a.add(temp);
			}
			ArrayList<ArrayList<Integer>> C = new ArrayList<>();
			ArrayList<ArrayList<Integer>> J = new ArrayList<>();
			String r = "";
			for(int j=0;j<n;j++) {
				if(can(C,a.get(j))) {
					r +="C";
					C.add(a.get(j));
					C.sort(compare);
				}
				else {
					if(can(J,a.get(j))) {
						r +="J";
						J.add(a.get(j));
						J.sort(compare);
					}
					else {
						r = "IMPOSSIBLE";
						break;
					}
				}
			}
			bw.write("Case #"+(i+1)+": "+r);
			bw.newLine();
			bw.flush();
		}
	}
}
