import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			
			System.out.println("Case #" + i + ": " + sol.processData(n, in));
		}
	}

	public String processData(int n, Scanner in) {

		ArrayList<DateRange> adr = new ArrayList<DateRange>();
		for (int i=0;i<n;i++) {
			DateRange dr = new DateRange();
			dr.setS(in.nextInt());
			dr.setE(in.nextInt());
			dr.setInitialOrder(i+1);
			adr.add(dr);
		}
		Collections.sort(adr,dateRangeComparator);

		//DateRange[][] dtrMatrix = new DateRange[n-1][n-1];
		ArrayList<ArrayList<DateRange>> dtrArr = new ArrayList<ArrayList<DateRange>>();
		HashMap<Integer, ArrayList<DateRange>> rowMap = new HashMap<Integer, ArrayList<DateRange>>();
		for (int i=0;i<n-1;i++) {
			ArrayList<DateRange> subArr = new ArrayList<DateRange>();
			dtrArr.add(subArr);
			for (int j=i+1;j<n;j++) {
				ArrayList<DateRange> rowSubArr = rowMap.get(j);
				if(rowSubArr==null) {
					rowSubArr= new ArrayList<DateRange>();
					rowMap.put(j, rowSubArr);
				}
			
				if(this.overlap(adr.get(i),adr.get(j))) {
					//dtrMatrix[i][j]=adr.get(j);
					subArr.add(adr.get(j));
					rowSubArr.add(adr.get(j));
				}
			}
		}
		
		for (Integer key : rowMap.keySet()) {
			ArrayList<DateRange> rowSubArr = rowMap.get(key);
			if(rowSubArr.size()>1)
				return "IMPOSSIBLE";
		}
		
		DateRange dr = adr.get(0);
		dr.setTaskOwner("J");
		
		//System.out.println(dtrArr);
		for (int i=0;i<dtrArr.size();i++) {
			dr = adr.get(i);
			String currOwner = dr.getTaskOwner();
			ArrayList<DateRange> subArr = dtrArr.get(i);
			//System.out.println(subArr);
			for(DateRange sdr : subArr) {
				if(currOwner.equals(""))
					currOwner="J";
				if(sdr.getTaskOwner().equals(currOwner))
					return "IMPOSSIBLE";
				String nextOwner = "J";
				if(currOwner.equals("J"))
					nextOwner = "C";
				sdr.setTaskOwner(nextOwner);
			}
		}

		Collections.sort(adr,initialOrderComparator);
		StringBuilder builder = new StringBuilder();
		for(DateRange dr1 : adr) {
			String taskOwner = dr1.getTaskOwner();
			if(taskOwner==null || taskOwner.equals(""))
				taskOwner="J";
			builder.append(taskOwner);  
	

		}
		return builder.toString();
	}

	public  boolean overlap(DateRange d1, DateRange d2) {
		if(d1.getS() >= d2.getS() && d1.getS() < d2.getE())
			return true;
		if(d2.getS() >= d1.getS() && d2.getS() < d1.getE())
			return true;
		if(d1.getE() > d2.getS() && d1.getE() <= d2.getE())
			return true;
		if(d2.getE() > d1.getS() && d2.getE() <= d1.getE())
			return true;

		return false;
	}


	public static Comparator<DateRange> dateRangeComparator = new Comparator<DateRange>() {         
		@Override         

		public int compare(DateRange dr1 , DateRange dr2) {
			return dr1.s - dr2.s;
		}
	};       
	
	public static Comparator<DateRange> initialOrderComparator = new Comparator<DateRange>() {         
		@Override         

		public int compare(DateRange dr1 , DateRange dr2) {
			return dr1.initialOrder - dr2.initialOrder;
		}
	};   

	private class DateRange  {
		private int s;
		private int e;
		private int initialOrder;
		private String taskOwner="";

		@Override
		public String toString() {
			return "s = " + s + " e = " + e + " initial order = " + initialOrder + " taskOwner = " + taskOwner;
		}


		


		public String getTaskOwner() {
			return taskOwner;
		}





		public void setTaskOwner(String taskOwner) {
			this.taskOwner = taskOwner;
		}





		public int getS() {
			return s;
		}
		public void setS(int s) {
			this.s = s;
		}
		public int getE() {
			return e;
		}
		public void setE(int e) {
			this.e = e;
		}
		public int getInitialOrder() {
			return initialOrder;
		}
		public void setInitialOrder(int initialOrder) {
			this.initialOrder = initialOrder;
		}



	}

}