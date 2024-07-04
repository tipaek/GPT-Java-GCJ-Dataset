import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		ArrayList<Integer[]> results= new ArrayList<Integer[]>();
		for (int i=0; i<test_cases; i++) {
			Integer[] result = latin_trace(sc.nextInt(),sc);
			results.add(result);
			
		}
		test_cases= 1;
		for(Integer[] result : results) {
			StringBuilder sb = new StringBuilder();
			sb.append("Case #");
			sb.append(test_cases);
			sb.append(": ");
			sb.append(result[0]);
			sb.append(" ");
			sb.append(result[1]);
			sb.append(" ");
			sb.append(result[2]);
			System.out.println(sb.toString());
			test_cases++;
		}
	}
	
	public static Integer[]  latin_trace(int N, Scanner sc) {
		int trace = 0;
		int r = 0;
		int c = 0;
		boolean[] col_rep = new boolean[N];
		//ArrayList<Integer> col = new ArrayList<Integer>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		HashMap<Integer,List<Integer>>cols = new HashMap<Integer,List<Integer>>();
		
		
		for (int i=0; i<N; i++) {
			boolean row_rep = false;
			for(int j=0; j<N; j++) {
				int Mij = sc.nextInt();
				if (i == j)
					trace = trace+Mij;
				if(row.contains(Mij) && !row_rep)
					row_rep = true;
				row.add(Mij);
				
				if(!cols.containsKey(j))
					cols.put(j, new ArrayList<Integer>());
				
				if(cols.get(j).contains(Mij) && !col_rep[j]) {
					col_rep[j] = true;
					c++;
				}
				cols.get(j).add(Mij);
					
			}
			if (row_rep) {
				row_rep = false;
				r++;
			}
			row.clear();
		}
		
		cols.clear();
		Integer [] result = {trace,r,c};
		return result;
	}

}
