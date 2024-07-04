import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int testCasesNum = in.nextInt();
		
		for(int i = 1;i <= testCasesNum; i++) {
			int task = in.nextInt();
			in.nextLine();
			
			int cEndTime = -1;
			int jEndTime = -1;
			boolean impossible = false;
			String result = "";
			
			List<Activity> activities = new ArrayList<Activity>();
			for(int j = 0;j < task; j++) {
				String inputTemp = in.nextLine();
				Activity temp = new Activity();
				temp.sequence = j + 1;
				temp.startTime = Integer.parseInt(inputTemp.split(" ")[0]);
				temp.endTime = Integer.parseInt(inputTemp.split(" ")[1]);
				activities.add(temp);
			}
			activities.sort((o1, o2) -> new Integer(o1.startTime).compareTo(o2.startTime));
			
			for(Activity temp : activities)
			{
				if(cEndTime == -1 && jEndTime == -1)
				{
					temp.assignedTo = "C";
					cEndTime = temp.endTime;
				}
				else if(cEndTime <= temp.startTime)
				{
					temp.assignedTo = "C";
					cEndTime = temp.endTime;
				}
				else if(jEndTime <= temp.startTime)
				{
					temp.assignedTo = "J";
					jEndTime = temp.endTime;
				}
				else
				{
					impossible = true;
				}
			}
			
			activities.sort((o1, o2) -> new Integer(o1.sequence).compareTo(o2.sequence));
			if(impossible)
				result = "IMPOSSIBLE";
			else
				result = activities.stream().map(t -> t.assignedTo).collect(Collectors.joining());
			
			System.out.println("Case #"+i+": "+result);
		}
	}
}
class Activity{
	int sequence;
	int startTime;
	int endTime;
	String assignedTo;
}
