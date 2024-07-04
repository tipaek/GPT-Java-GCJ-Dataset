import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//Scanner scanner = new Scanner(new BufferedReader(new FileReader("test.in")));
		Solution solution = new Solution();
		while (scanner.hasNext()) {
			int T = scanner.nextInt();
			
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < T; i++) {
				builder.setLength(0);
				int N = scanner.nextInt();
				List<Interval> intervals = new ArrayList<>(N);
				for(int j=0; j<N;j++)
				{
					intervals.add(solution.new Interval(scanner.nextInt(), scanner.nextInt()));
				}
				
				
				PriorityQueue<Interval> camQueue = new PriorityQueue<>(Comparator.comparing(Interval::getStart));
				PriorityQueue<Interval> jaimeQueue = new PriorityQueue<>(Comparator.comparing(Interval::getStart));
				
				
				for(Interval interval : intervals)
				{					
					if(canTakeTask(camQueue, interval))
					{
						camQueue.add(interval);
						builder.append('C');
					}
					else if(canTakeTask(jaimeQueue, interval))
					{
						jaimeQueue.add(interval);
						builder.append('J');
					}
					else
					{
						builder.setLength(0);
						builder.append("IMPOSSIBLE");
						break;
					}
					
				}
				
				System.out.println(String.format("Case #%d: %s", (i + 1), builder.toString()));
			}
		}
		scanner.close();
	}
	
	private static boolean canTakeTask(PriorityQueue<Interval> pq, Interval interval)
	{
		if(pq.isEmpty()) return true;
		Interval item = null;
		List<Interval> list = new ArrayList<>();
		
		boolean canAdd = true;
		while((item =pq.poll())!=null)
		{
			list.add(item);
			if ((interval.getStart() > item.getStart() && interval.getStart() < item.getEnd()) ||
				(interval.getEnd() > item.getStart() && interval.getEnd() < item.getEnd()))
			{
				canAdd = false;
				break;
			}
		}
		pq.addAll(list);
		return canAdd;
	}
	
	class Interval
	{
		private int start;
		
		@Override
		public String toString() {
			return "[start=" + start + ", end=" + end + "]";
		}

		private int end;
		
		public Interval(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
		
		public void setStart(int start) {
			this.start = start;
		}

		public void setEnd(int end) {
			this.end = end;
		}
				
		public int getStart()
		{
			return start;
		}
		
		public int getEnd()
		{
			return end;
		}
	}

}
