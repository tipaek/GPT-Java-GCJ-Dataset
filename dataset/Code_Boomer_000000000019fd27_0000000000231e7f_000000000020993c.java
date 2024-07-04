import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static int col(ArrayList<ArrayList<Integer>> a, int N) {
		int count = 0;
		for(int i=0;i<N;i++) {
			Set<Integer> s = new HashSet<>();
			for(int j=0;j<a.size();j++) {
				s.add(a.get(j).get(i));
			}
			if(s.size()<N)
				count++;
		}
		
		return count;
	}
	
	public static int row(ArrayList<ArrayList<Integer>> a, int N) {
		int count = 0;
	    for(int i=0;i<a.size();i++) {
	    	ArrayList<Integer> temp = a.get(i);
	    	for(int j=1;j<=N;j++){
	    		if(temp.indexOf(j) != temp.lastIndexOf(j)) {
	    			count++;
	    			break;
	    		}
	    	}
	    }
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int N = sc.nextInt();
			int trace = 0;
			ArrayList<ArrayList<Integer>> a = new ArrayList<>();
			for(int j=0;j<N;j++) {
				ArrayList<Integer> temp = new ArrayList<>();
				for(int k=0;k<N;k++) {
					temp.add(sc.nextInt());
					if(j == k)
						trace += temp.get(k);
				}
				a.add(temp);
			}
			System.out.println("Case #"+(i+1)+": "+trace +" "+ row(a,N)+" "+col(a,N));
		}
	}
}
