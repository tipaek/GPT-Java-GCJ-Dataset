import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {

		try {
			long trace = 0;
			int rowCount = 0;
			int colCount = 0;
			ArrayList<HashMap<String,String>> colMaps = new ArrayList<HashMap<String,String>>();
			HashMap<Integer,Integer> colCountMap = new HashMap<Integer,Integer>();

			Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			HashMap<String,String> colMap = null;
			for (int i = 1; i <= t; ++i) {
				int n = in.nextInt();
				in.nextLine();
				HashMap<String,String> rowMap = null;

				for (int j =0 ; j<n;j++) {
					rowMap = new HashMap<String,String>();
					boolean rowCounted = false;
					String line = in.nextLine();
					String[] splitStr = line.split(" ");
					for (int k=0;k<n;k++) {
						boolean colCounted=false;
						int indColCount=0;
						if(colMaps.size() < (k+1))
						{
							colMap = new HashMap<String,String>();
							colMaps.add(colMap);
							colCountMap.put(k, 0);
						}
						else {
							colMap = colMaps.get(k);
							indColCount = colCountMap.get(k).intValue();
							if(indColCount>0)
								colCounted=true;
						}
						if(!colCounted) {
							String val = colMap.get(splitStr[k]);
							if(val!=null) {
								//there is duplicate
								colCount++;
								indColCount++;
								colCountMap.put(k, indColCount);
								//HOW TO BREAK;
							}
						}

						colMap.put(splitStr[k], splitStr[k]);

						if(j==k)
							trace=trace+new Integer(splitStr[k]);
						if(!rowCounted) {
							String val = rowMap.get(splitStr[k]);
							if(val!=null) {
								//there is duplicate
								rowCount++;
								rowCounted=true;
								//HOW TO BREAK;
							}
						}
						rowMap.put(splitStr[k], splitStr[k]);
					}
				}

				System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
				trace=0;
				rowCount=0;
				colCount=0;
				colMaps = new ArrayList<HashMap<String,String>>();
				colCountMap = new HashMap<Integer,Integer>();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}