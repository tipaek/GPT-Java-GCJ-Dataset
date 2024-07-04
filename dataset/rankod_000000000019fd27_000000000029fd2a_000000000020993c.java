import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException, NumberFormatException, ArrayIndexOutOfBoundsException{
		Solution v = new Solution();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int caseCount = Integer.parseInt(reader.readLine());
		
		for(int i=1; i <= caseCount; i++) {
			int msize = Integer.parseInt(reader.readLine());
			Solution.Case c = v.new Case(i, msize);
			for(int j=0; j< msize; j++) {
				String[] rowVals = reader.readLine().split(" ");
				c.setRowValues(j,rowVals);
			}
			c.getOutput();
		}
		reader.close();
	}

	class Case {
		int id;
		int size;
		private Set<Integer> uniqueRowVals = new HashSet<>();
		private Map<Integer, Set<Integer>> colLvlUniqueVals = new HashMap<>();
		private int repeatRowCount;
		private int repeatColCount;
		private int trace;
		

		public Case(int id, int size) {
			this.id = id;
			this.size = size;
		}
		
		public void setRowValues(int rowIndex, String[] vals) throws ArrayIndexOutOfBoundsException{
			for(int colIndx=0; colIndx< this.size; colIndx++) {
				
				if(rowIndex == 0)
					colLvlUniqueVals.put(colIndx, new HashSet<>());
				int val = Integer.parseInt(vals[colIndx]);
				if(colIndx == rowIndex) {
					trace+= val;
				}
				uniqueRowVals.add(val);
				Set<Integer> colSet = colLvlUniqueVals.get(colIndx);
				colSet.add(val);
				colLvlUniqueVals.putIfAbsent(colIndx, colSet);
			}
			if (uniqueRowVals.size() != size)
					this.repeatRowCount++;	
			
			uniqueRowVals.clear();
		}
		
		private void calcRepeatColCount() {
			for(int colIdx=0; colIdx < colLvlUniqueVals.size(); colIdx++) {
				if (colLvlUniqueVals.get(colIdx).size() != size)
					this.repeatColCount++;	
			}			
		}
		
		public void getOutput(){
			calcRepeatColCount();
			System.out.println("Case #%d: %d %d %d", this.id, this.trace, this.repeatRowCount, this.repeatColCount);
		}
		
	}

}
