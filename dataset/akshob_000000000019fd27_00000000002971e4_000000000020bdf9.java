
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
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
		return this.startTime.compareTo(o.startTime);
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
			Map<Integer, Time> maps = new HashMap<>();
			for(int z=0;z<intervals;z++) {
				String str = scanner.nextLine();
				int n1 = Integer.parseInt(str.split(" ")[0]);
				int n2 = Integer.parseInt(str.split(" ")[1]);
				Time t1 = new Time(n1,n2);
				timeObjects.add(t1);
				maps.put(z, t1);
			}
			processInput(timeObjects,i, maps);
		}
		scanner.close();
	}

	private static void processInput(ArrayList<Time> timeObjects, int caseNumber, Map<Integer, Time> maps) {
		caseNumber += 1;
		char[] finalResult = new char[timeObjects.size()];
		Person c = new Person("C", new Time(0,0));
		Person j = new Person("J", new Time(0,0));
		
		Collections.sort(timeObjects);
//		System.out.println("After sorting: ");
//		for(Time t:timeObjects) {
//			System.out.println(t.startTime+" "+t.finishTime);
//		}
	
		int flag = 0;
		for(int k=0;k<timeObjects.size();k++) {
			if(timeObjects.get(k).startTime >= c.time.finishTime) {
				c.time = timeObjects.get(k);
				int key = getMapsKey(maps, timeObjects.get(k));
				if(key != -1) {
					finalResult[key] = 'C';
				}
			} else if (timeObjects.get(k).startTime >= j.time.finishTime) {
				j.time = timeObjects.get(k);
				int key = getMapsKey(maps, timeObjects.get(k));
				if(key != -1) {
					finalResult[key] = 'J';
				}
			} else {
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			System.out.println("Case #"+caseNumber+": "+String.valueOf(finalResult));
		} else {
			System.out.println("Case #"+caseNumber+": IMPOSSIBLE");
		}
	}

	private static int getMapsKey(Map<Integer, Time> maps, Time time) {
		for(Entry<Integer, Time> entry:maps.entrySet()) {
			if(Objects.equals(time, entry.getValue())) {
				return entry.getKey();
			}
		}
		return -1;
	}
}
