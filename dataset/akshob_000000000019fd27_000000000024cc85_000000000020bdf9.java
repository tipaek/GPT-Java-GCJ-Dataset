
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
	Integer startTime;
	Integer finishTime;
	
	Time(int startTime, int finishTime) {
		this.startTime = startTime;
		this.finishTime = finishTime;
	}

	@Override
	public int compareTo(Time o) {
		return this.finishTime.compareTo(o.finishTime);
	}
}

class Person {
	String name;
	Time time;
	Person(String name, Time time) {
		this.name = name;
		this.time = time;
	}
}

public class Solution  {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//System.out.println("Enter the number of test cases");
		int testCases = scanner.nextInt();
		for(int i = 0; i < testCases; i++) {
			//System.out.println("Enter the number of intervals");
			int intervals = scanner.nextInt();
			scanner.nextLine();
			ArrayList<Time> timeObjects = new ArrayList<>();
			for(int z=0;z<intervals;z++) {
				String str = scanner.nextLine();
				int n1 = Integer.parseInt(str.split(" ")[0]);
				int n2 = Integer.parseInt(str.split(" ")[1]);
				Time t1 = new Time(n1,n2);
				timeObjects.add(t1);
			}
			processInput(timeObjects,i);
		}
		scanner.close();
	}

	private static void processInput(ArrayList<Time> timeObjects, int caseNumber) {
		caseNumber += 1;
		Person c = new Person("C", new Time(0,0));
		Person j = new Person("J", new Time(0,0));
		
		Collections.sort(timeObjects);
		
		int totalTasks = timeObjects.size();
		int count = 0;
		StringBuilder result = new StringBuilder();
		
		c.time = timeObjects.get(0);
		result.append("C");
		count++;
		for(int k=1;k<timeObjects.size();k++) {
			if(timeObjects.get(k).startTime >= c.time.finishTime) {
				c.time = timeObjects.get(k);
				result.append("C");
				count++;
			} else if (timeObjects.get(k).startTime >= j.time.finishTime) {
				j.time = timeObjects.get(k);
				result.append("J");
				count++;
			}
		}
		
		if(count == totalTasks) {
			System.out.println("Case #"+caseNumber+": "+result);
		} else {
			System.out.println("Case #"+caseNumber+": IMPOSSIBLE");
		}
		
	}
}
