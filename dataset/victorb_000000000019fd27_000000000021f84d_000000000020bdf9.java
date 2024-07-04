import java.util.*;

public class Solution {
	

	private static class Range<K, V> implements Map.Entry<K, V> {
		
		private int ind;
		private K key;
		private V value;
		private char assignee;
		
		public Range(K key, V value, int ind) {
			this.key = key;
			this.value = value;
			this.ind = ind;
		}
		
		public int getIndex() {
			return ind;
		}
		
		@Override
		public K getKey() {
			return key;
		}
		
		@Override
		public V getValue() {
			return value;
		}
		
		public V setValue(V value) {
			return this.value = value;
		}
		
		public void assign(char assignee) {
			this.assignee = assignee;
		}
		
		public char getAssignee() {
			return assignee;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);	
		for(int tNum = sc.nextInt(), tCurr = 1; tCurr <= tNum; tCurr++) {			
			int n = sc.nextInt();
			
			Queue<Range<Integer, Integer>> ranges = new PriorityQueue<Solution.Range<Integer,Integer>>((a, b) -> a.getKey().compareTo(b.getKey()));
			Queue<Range<Integer, Integer>> sortedByIndexJobs = new PriorityQueue<Solution.Range<Integer,Integer>>((a, b) -> a.getIndex() - b.getIndex());
			
			for(int i = 0; i < n; i++) {
				Range<Integer, Integer> pair = new Range<>(sc.nextInt(), sc.nextInt(), i);
				if (pair.getKey() >  pair.getValue()) {
					pair.setValue(pair.getValue() + 24*60);
				}
				ranges.add(pair);
				sortedByIndexJobs.add(pair);
			}

			StringBuilder result = new StringBuilder();
			
			Range<Integer, Integer> endC = new Range<>(0, 0, 0);
			endC.assign('C');
			Range<Integer, Integer> endJ = new Range<>(0, 0, 0);
			endJ.assign('J');
			
			
			while(!ranges.isEmpty()) {
				Range<Integer, Integer> range = ranges.poll();
					
				Range<Integer, Integer> minAssignee = endC.value.compareTo(endJ.value) < 0 ? endJ : endC; 
				if (range.getKey() >= minAssignee.getValue()) {
					range.assign(minAssignee.getAssignee());
					minAssignee.setValue(range.getValue());
				} else {
					minAssignee = (minAssignee == endC) ? endJ : endC;
				
					if (range.getKey() >= minAssignee.getValue()) {
						range.assign(minAssignee.getAssignee());
						minAssignee.setValue(range.getValue());
					} else {
						result = null;
						break;
					}
				}
			}
			
			if (result != null) {
				for(Range<Integer, Integer> job : sortedByIndexJobs) {
					result.append(job.getAssignee());
				}
			}
			
			System.out.println(String.format("Case #%d: %s", tCurr, result == null ? "IMPOSSIBLE" : result));					
			
			
		}
		System.out.flush();
		
	}
	
}
