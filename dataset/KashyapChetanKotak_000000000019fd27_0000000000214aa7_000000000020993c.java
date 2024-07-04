import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=Integer.parseInt(sc.nextLine());
		for(int i=0; i<tc; i++) {
//			System.out.println("new tc");
			int n=sc.nextInt();
			int rdup=0,cdup=0,k=0;
			List<HashSet<Integer>> cols=new ArrayList<HashSet<Integer>>(n);
			for (int r=0; r<n; r++) {
				HashSet<Integer> rowSet=new HashSet<Integer>();
//				System.out.println("row:"+r);
				for (int c=0; c<n; c++) {
//					System.out.println("col:"+c);
					if(cols.size()<c+1) {
						HashSet<Integer> colSet=new HashSet<Integer>();
						cols.add(colSet);
					}
					int val=sc.nextInt();
					cols.get(c).add(val);
					rowSet.add(val);
					if(c==r)
						k=k+val;
				}
				if(rowSet.size()<n)
					rdup++;
			}
			for(int c=0;c<n;c++) {
				if(cols.get(c).size()<n)
					cdup++;
			}
			System.out.println("Case #"+(i+1)+": "+k+" "+rdup+" "+cdup);
		}// test case end
	}//main end
}//class end

