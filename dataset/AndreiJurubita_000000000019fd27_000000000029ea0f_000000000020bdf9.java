import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bytz
 */
public class Solution {

	/**
	 * @param args the command line arguments
	 * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner=new Scanner(System.in);
		Writer writer=new PrintWriter(System.out);
		Integer T=scanner.nextInt();
		scanner.nextLine();
		for(int t=0;t<T;t++){
			Integer N=scanner.nextInt();
			Interval intervals[]=new Interval[N];
			List<Interval> intervalsSorted=new ArrayList<>();
			for(int i=0;i<N;i++){
				Integer S=scanner.nextInt();
				Integer E=scanner.nextInt();
				Interval interval=new Interval(S, E);
				intervals[i]=interval;
				intervalsSorted.add(interval);
			}
			intervalsSorted.sort(
				(Interval o1, Interval o2) -> {
					if(o1.start<o2.start)
						return -1;
					if(o2.start>o1.start)
						return 1;
					else return 0;
				}
			);
			boolean impossible=false;
			int whosEnd[]=new int[2];
			for(Interval interval:intervalsSorted){
				if(whosEnd[1]<whosEnd[0])
					interval.who=1;
				else
					interval.who=0;
				if(interval.start<whosEnd[interval.who]){
					impossible=true;
					break;
				}
				whosEnd[interval.who]=interval.end;
			}
			writer.write("Case #"+(t+1)+": ");
			if(impossible||intervalsSorted.size()==0)
				writer.write("IMPOSSIBLE");
			else
				for(int i=0;i<N;i++)
					writer.write(intervals[i].who==0?"C":"J");
			writer.write(System.lineSeparator());
			writer.flush();
		}
		writer.close();
		scanner.close();
	}

}

class Interval{
	public Integer start;
	public Integer end;
	public Integer who=0;
	public Interval(Integer start,Integer end){
		this.start=start;
		this.end=end;
	}
}
