import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class Solution {
	private static class ReadWrite {
		BufferedReader in;
		PrintWriter out;
		
		public ReadWrite() {
			in = new BufferedReader(new InputStreamReader(System.in));
			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter("output.out")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ReadWrite(String fileName, Boolean isInput) {
			try {
				if (isInput) {
					in = new BufferedReader(new FileReader(fileName));
				} else {
					in = new BufferedReader(new InputStreamReader(System.in));
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (isInput) {
					out = new PrintWriter(new BufferedWriter(new FileWriter("output.out")));	
				} else {
					out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ReadWrite(String inputFileName, String outputFileName) {
			try {
				in = new BufferedReader(new FileReader(inputFileName));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public BufferedReader getIn() {
			return this.in;
		}
		
		public PrintWriter getOut() {
			return this.out;
		}
	}

	public static String solve(ReadWrite rw) {
		String result = "";
		int trace = 0;
		int rowsWithDuplicates = 0;
		int colsWithDuplicates = 0;
		try {
			int numLines = Integer.valueOf(rw.getIn().readLine());
			HashMap<String, HashMap<Integer, Integer>> gridByFrequency = new HashMap<String, HashMap<Integer, Integer>>();

			for (int i = 1; i <= numLines; i++) {
				String[] row = rw.getIn().readLine().split(" ");
				for (int col = 0; col < row.length; col++) {
					int currentCol = Integer.valueOf(row[col]);
					// update row
					HashMap<Integer, Integer> rowFrequencyMap = gridByFrequency.get("row" + i);
					if (rowFrequencyMap == null) {
						rowFrequencyMap = new HashMap<Integer, Integer>(); 
					}
					Integer rowFrequency = rowFrequencyMap.get(currentCol);
					if (rowFrequency == null) {
						rowFrequency = 1;
					} else {
						rowFrequency++;
					}
					rowFrequencyMap.put(currentCol, rowFrequency);
					gridByFrequency.put("row" + i, rowFrequencyMap);
					
					// update col
					HashMap<Integer, Integer> columnFrequencyMap = gridByFrequency.get("column" + col);
					if (columnFrequencyMap == null) {
						columnFrequencyMap = new HashMap<Integer, Integer>(); 
					}
					Integer columnFrequency = columnFrequencyMap.get(currentCol);
					if (columnFrequency == null) {
						columnFrequency = 1;
					} else {
						columnFrequency++;
					}
					columnFrequencyMap.put(currentCol, columnFrequency);
					gridByFrequency.put("column" + col, columnFrequencyMap);
					
					// calculate trace
					if ((i - 1) == col) {
						trace += currentCol;
					}
				}
			}
			
			for (String key: gridByFrequency.keySet()) {
				if (key.indexOf("row") == 0) {
					// validate rows
					HashMap<Integer, Integer> rowFrequencyMap = gridByFrequency.get(key);
					for (Integer rowValue : rowFrequencyMap.keySet()) {
						if (rowFrequencyMap.get(rowValue) > 1) {
							rowsWithDuplicates++;
							break;
						}
					}
				} else {
					// validate columns
					HashMap<Integer, Integer> columnFrequencyMap = gridByFrequency.get(key);
					for (Integer colValue : columnFrequencyMap.keySet()) {
						if (columnFrequencyMap.get(colValue) > 1) {
							colsWithDuplicates++;
							break;
						}
					}
				}
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = trace + " " + rowsWithDuplicates + " " + colsWithDuplicates;
		return result;
	}

	public static void main(String[] arg) throws NumberFormatException, IOException {
//		ReadWrite rw = new ReadWrite("input.in", true);
		ReadWrite rw = new ReadWrite();
    	int numCases = Integer.valueOf(rw.getIn().readLine());
    	for (int i = 1; i <= numCases; i++) {
    		String output = "Case #" + i + ": " + solve(rw);
    		System.out.println(output);
    		rw.getOut().println(output);
    	}
    	rw.getOut().close();
	}
}
