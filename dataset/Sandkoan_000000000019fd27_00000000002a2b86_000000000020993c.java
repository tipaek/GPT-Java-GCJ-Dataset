package codejam2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {

	private Integer[][] intArray2D;

	Solution(int N) {
		this.intArray2D = new Integer[N][N];
	}

	public Integer[][] getIntArray2D() {
		return intArray2D;
	}

	public void setIntArray2D(Integer[][] intArray2D) {
		this.intArray2D = intArray2D;
	}

	public int calcTrace() {
		int trace = 0;
		for (int rows = 0; rows < intArray2D.length; rows++) {
			trace = trace + intArray2D[rows][rows];
		}

		// System.out.println ( "trace " + trace );
		return trace;
	}

	public int calcRepeatedRowElements() {
		int repeatElementCount = 0;

		for (int rows = 0; rows < intArray2D.length; rows++) {
			Set<Integer> set = new HashSet<Integer>();
			Integer[] row = intArray2D[rows];
			for (int i = 0; i < row.length; i++) {
				if (!set.add(row[i])) {
					repeatElementCount++;
					break;
				}
			}
			// System.out.println("Repeat count " + repeatElementCount);
		}

		return repeatElementCount;
	}

	public int calcRepeatedColElements() {
		int repeatElementCount = 0;

		for (int rows = 0; rows < intArray2D.length; rows++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int cols = 0; cols < intArray2D.length; cols++) {
				if (!set.add(intArray2D[cols][rows])) {
					repeatElementCount++;
					break;
				}
			}
		}
		// System.out.println("Repeat count " + repeatElementCount);
		return repeatElementCount;
	}

	static void print(String key, List<Integer> list) {
		StringBuffer strBuf = new StringBuffer(0);
		//System.out.print(key + " ");
		strBuf.append(key + " ");
		for (int i = 0; i < list.size(); i++) {
			if (i < list.size()) {
				//System.out.print(list.get(i) + " ");
				strBuf.append(list.get(i) + " ");
			} else {
//				System.out.println(list.get(i));
				strBuf.append(list.get(i) );
			}
		}
		
		System.out.println(strBuf.toString().trim());

	}

	public static void main(String[] args) throws Exception
	{
	
		
		List<Solution> twoDPracticeList = new ArrayList<Solution>();
		Map<String, List<Integer>> outResultMap = new TreeMap<String, List<Integer>>();
		
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(reader.readLine());
		int testCaseCounter = T;
		
		if(T>0 && T<=100)
		{
			T=T;
		}
		else
		{
		    T = 0;
		    System.out.println("beyond input limit");
		}
		
		while (testCaseCounter > 0) 
		{
			int N = Integer.valueOf(reader.readLine());
			Solution twoDPractice = new Solution(N);
			int rowNum = 0;
			for (int lineSize = 0; lineSize < N; lineSize++) {
				//read first row
				String rowLine =  "";
				if ( testCaseCounter == 1 && rowNum == 2 )
				{
					 char[] c = new char[10];
					 reader.read(c);
					 rowLine = (new String(c)).trim();
				}
				else
				{
					rowLine = reader.readLine();
				}
				String[] elements = rowLine.split(" ");	

				for (int col = 0; col < N; col++) 
				{
				  twoDPractice.intArray2D[rowNum][col] = Integer.valueOf( elements[col] );
				}
				rowNum++;
			}
			twoDPracticeList.add(twoDPractice);
			testCaseCounter--;
		}

		for (int i = 0; i < twoDPracticeList.size(); i++) {
			List<Integer> val = outResultMap.get("Case #" + (i+1) + ":");
			if (val == null) {
				val = new ArrayList<Integer>();
				val.add(twoDPracticeList.get(i).calcTrace());
				val.add(twoDPracticeList.get(i).calcRepeatedRowElements());
				val.add(twoDPracticeList.get(i).calcRepeatedColElements());
				outResultMap.put("Case #" + (i+1) + ":", val);
			}
		}

		// System.out.println(outResultMap );

		for (String key : outResultMap.keySet()) {
			print(key, outResultMap.get(key));
		}

		reader.close();

	}

}
