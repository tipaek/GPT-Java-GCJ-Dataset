/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Answer solution = new Answer();
		solution.solve(in, out);
		out.flush();
		out.close();
	}
}

class Answer {
    public void solve(Scanner in, PrintWriter out) {
        int test_cases = in.nextInt();
        for (int test_case = 0; test_case < test_cases; test_case++) {
            int N = in.nextInt();
            int[][] array = new int[N][N];
            Map<Integer, Set<Integer>> rowMap = new HashMap<Integer, Set<Integer>>();
            Map<Integer, Set<Integer>> colMap = new HashMap<Integer, Set<Integer>>();
            int trace = 0;
            int dupRow = 0;
            Set<Integer> seenDupRows = new HashSet<Integer>();
            int dupCol = 0;
            Set<Integer> seenDupCols = new HashSet<Integer>();
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    array[i][j] = in.nextInt();
                }
            }
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (i==j) {
                        trace += array[i][j];
                    }
                    
                    if (rowMap.containsKey(i) && rowMap.get(i) != null && rowMap.get(i).contains(array[i][j]) && !seenDupRows.contains(i)) {
                        dupRow += 1;
                        seenDupRows.add(i);
                    } else if (rowMap.containsKey(i) && rowMap.get(i) != null) {
                        Set<Integer> s = rowMap.get(i);
                        s.add(array[i][j]);
                        rowMap.put(i, s);
                    } else {
                        Set<Integer> s = new HashSet<Integer>();
                        s.add(array[i][j]);
                        rowMap.put(i, s);
                    }
                    
                    if (colMap.containsKey(j) && colMap.get(j) != null && colMap.get(j).contains(array[i][j]) && !seenDupCols.contains(j)) {
                        dupCol += 1;
                        seenDupCols.add(j);
                    } else if (colMap.containsKey(j) && colMap.get(j) != null) {
                        Set<Integer> s = colMap.get(j);
                        s.add(array[i][j]);
                        colMap.put(j, s);
                    } else {
                        Set<Integer> s = new HashSet<Integer>();
                        s.add(array[i][j]);
                        colMap.put(j, s);
                    }
                }
            }
            String ans = String.format("Case #%d: %d %d %d", test_case+1, trace, dupRow, dupCol);
            out.println(ans);
        }
    }
}