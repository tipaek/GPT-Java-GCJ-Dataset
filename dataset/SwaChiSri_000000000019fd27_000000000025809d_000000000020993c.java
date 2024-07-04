import java.util.*;
public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		int t =in.nextInt();
		String[] test = new String[t];
		for(int x=0;x<t;x++) {
			int n = in.nextInt();
			Map<Integer, List<Integer>> rmap = new HashMap<>();
			Map<Integer, List<Integer>> cmap = new HashMap<>();
			int[] array[] = new int[n][n];
			int sum=0;
			for(int i=0; i<n;i++) {
				for(int j=0;j<n;j++) {
					int val = Integer.parseInt(in.next());
					array[i][j] = val;
					if(i==j) {
						sum+= val;
					}
					if(rmap.containsKey(i)) {
						rmap.get(i).add(val);
					}else {
						List<Integer> row = new ArrayList<>();
						row.add(val);
						rmap.put(i,row);
					}
					if(cmap.containsKey(j)) {
						cmap.get(j).add(val);
					}else {
						List<Integer> col = new ArrayList<>();
						col.add(val);
						cmap.put(j,col);
					}
				}
			}
			int rnum=0;
			int cnum=0;
			
			for(Map.Entry<Integer, List<Integer>> r : rmap.entrySet()) {
				if(new HashSet<>(r.getValue()).size() < r.getValue().size()) {
					rnum+=1;
				}
			}
			for(Map.Entry<Integer, List<Integer>> c : cmap.entrySet()) {
				if(new HashSet<>(c.getValue()).size() < c.getValue().size()) {
					cnum+=1;
				}
			}

			test[x] = "Case #"+ (x+1) +": "+sum+' '+ rnum + ' '+cnum;
		}
		for(String output : test) {
			System.out.println(output);
		}
	}

}
