import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Kajal
 *
 */
class InsertOrder{
	
	private int endTime;
	private int order;
	private char person;
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public char getPerson() {
		return person;
	}
	public void setPerson(char person) {
		this.person = person;
	}
}

public class Solution {

	public static void main(String[] args) {
		
		int testCases, n;
		String input[];
		BufferedReader br = null;
		StringBuilder out = new StringBuilder();
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
//			br = new BufferedReader(new FileReader("in.txt"));
			
			testCases = Integer.parseInt(br.readLine().trim());
			
			for (int t = 1;t <= testCases;t++) {
				
				Map<Integer,List<InsertOrder>> startEndTimesMap = new TreeMap<>();
				n = Integer.parseInt(br.readLine().trim());
				
				for (int i = 0;i < n;i++) {
					input = br.readLine().trim().split(" ");
					int startTime = Integer.parseInt(input[0]);
					int endTime = Integer.parseInt(input[1]);
					if (startEndTimesMap.containsKey(startTime)) {
						List<InsertOrder> endTimes = startEndTimesMap.get(startTime);
						InsertOrder io = new InsertOrder();
						io.setEndTime(endTime);
						io.setOrder(i);
						endTimes.add(io);
						Collections.sort(endTimes, new Comparator<InsertOrder>() {

							@Override
							public int compare(InsertOrder o1, InsertOrder o2) {
								if (o1.getEndTime() < o2.getEndTime())
									return -1;
								else if (o1.getEndTime() > o2.getEndTime())
									return 1;
								return 0;
							}
						});
						startEndTimesMap.put(startTime, endTimes);
					} else {
						List<InsertOrder> endTimes = new ArrayList<>();
						InsertOrder io = new InsertOrder();
						io.setEndTime(endTime);
						io.setOrder(i);
						endTimes.add(io);
						startEndTimesMap.put(startTime, endTimes);
					}
					
				}
				
				int cam = 0;
				int jam = 0;
				boolean impossible = false;
				List<InsertOrder> sequence = new ArrayList<>();
				for (int start: startEndTimesMap.keySet()) {
					for (InsertOrder io: startEndTimesMap.get(start)) {
						if (cam <= start) {
							cam = io.getEndTime();
							io.setPerson('C');
						} else if (jam <= start) {
							jam = io.getEndTime();
							io.setPerson('J');
						} else {
							impossible = true;
							break;
						}
						sequence.add(io);
					}	
					if (impossible)
						break;
				}
				out.append("Case #"+t+": ");
				if (!impossible) {
					
					Collections.sort(sequence, new Comparator<InsertOrder>() {
						@Override
						public int compare(InsertOrder o1, InsertOrder o2) {
							if (o1.getOrder() < o2.getOrder())
								return -1;
							else if (o1.getOrder() > o2.getOrder())
								return 1;
							return 0;
						}
					});
					
					for (InsertOrder io: sequence) {
						out.append(io.getPerson());
					}
				} else {
					out.append("IMPOSSIBLE");
				}
				out.append("\n");
			}
			
			System.out.println(out);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
