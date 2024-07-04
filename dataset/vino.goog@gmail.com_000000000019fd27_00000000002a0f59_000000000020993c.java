import java.util.*;
import java.io.*;
public class Solution {
public static void main(String[] args) {
//	System.in
//InputStream r = new InputStream() {
//	
//	@Override
//	public int read() throws IOException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//};
//try {
//	r = new FileInputStream("c:\\vinodh\\1.txt");
//} catch (FileNotFoundException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
int t = new Integer(in.nextLine()); // no of test cases
List<int[][]> arrayList = new ArrayList<int[][]>();
for (int i = 0; i < t; ++i) {
	 
int n = new Integer(in.nextLine()); // number of rows
	 int[][] rows = new int[n][n];
	 for (int i1 = 0; i1 < n; ++i1) {
		
		 String rowVal = in.nextLine();
		 String[] integerStrings = rowVal.split(" "); 
		 int[] row = new int[n]; 
		 for(int j=0;j<n;j++)
		 {
			 row[j] = new Integer(integerStrings[j]);
		 }
		 rows[i1] = row;
	 }
	 arrayList.add(rows);
}	
int index = 0;
for (int[][] is : arrayList) {
	 index++;
	 int sum = 0;
	 int repeatedRows = 0;
	 int repeatedCols = 0;

	 for(int i=0;i<is.length;i++) {
		 sum += is[i][i];
		 boolean rowFlag = false;
		 boolean colFlag = false;
		 HashMap<Integer,Integer> rowD = new HashMap<>();
		 HashMap<Integer,Integer> colD = new HashMap<>();
		 for(int j=0;j<is.length;j++) {
			 if(rowD.containsKey(is[i][j])) {
				 rowFlag = true;
			 }
			 else {
				 rowD.put(is[i][j], is[i][j]);
			 }
			 if(colD.containsKey(is[j][i])) {
				 colFlag = true;
			 }
			 else {
				 colD.put(is[j][i], is[j][i]);
			 }
		 }
		 if(rowFlag)
			 repeatedRows++;
		 if(colFlag)
			 repeatedCols++;
	 }
	 
	 System.out.println(String.format("Case #%d %d %d %d",index,sum,repeatedRows,repeatedCols));
}

}
}