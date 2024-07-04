import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		int T, N, S, E;
		
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		List<String> output=new ArrayList<>();
		for(int i=0; i<T; i++) {
			
			N = scanner.nextInt();
			List<Activity> activities=new ArrayList<>(N);
			for(int j=0; j<N; j++) {
				S = scanner.nextInt();
				E = scanner.nextInt();
				
				activities.add(new Activity((j+1), S, E));
			}
			output.add("Case #"+(i+1)+": "+getSolution(activities));
		}
		scanner.close();
		
		output.forEach(System.out::println);
	}
	
	public static <R> Predicate<R> not(Predicate<R> predicate) {
	    return predicate.negate();
	}

	private static String getSolution(List<Activity> activities) {
		int activitiesLength = activities.size();
		AtomicInteger overlappedWithFirstActivityCount=new AtomicInteger(0);
		activities.sort(Comparator.comparing(Activity::getUpperBound));
		
		for(int i=1; i<activitiesLength; i++) {
			for(int j=0; j<i; j++) {
				if(activities.get(i).overlap(activities.get(j))) {
					activities.get(i).setOverlappedActivity(activities.get(j));
					break;
				}
			}
		}
		
		activities.stream()
					.skip(1)
					.forEach(activity -> {
						Activity overlappedActivity = activity.getOverlappedActivity();
						if(overlappedActivity != null && activities.get(0).getActivityNumber()==overlappedActivity.getActivityNumber()) {
							overlappedWithFirstActivityCount.incrementAndGet();
						}
					});
		
		if(activitiesLength-1 == overlappedWithFirstActivityCount.get()) {
			return "IMPOSSIBLE";
		}
		
		activities.forEach(activity -> {
			
			Activity overlappedActivity = activity.getOverlappedActivity();
			if(overlappedActivity == null) {
				activity.setAssignedPerson(getPerson(' '));
			} else {
				activity.setAssignedPerson(getPerson(overlappedActivity.getAssignedPerson()));
			}
			
		});
		
		activities.sort(Comparator.comparing(Activity::getActivityNumber));
		
		return activities.stream()
					.map(Activity::getAssignedPerson)
					.map(String::valueOf)
					.collect(Collectors.joining());
	}

	private static char getPerson(char person) {
		char[] persons = new char[]{'C', 'J'}; 
		
		if(person != ' ') {
			persons = String.valueOf(persons).chars()
							.mapToObj(i -> Character.valueOf((char)i))
							.filter(c -> !c.equals(person))
							.map(String::valueOf)
							.collect(Collectors.joining())
							.toCharArray();
		}
		
		return persons[ThreadLocalRandom.current().nextInt(0, persons.length)];
	}

	static class Activity {
		int activityNumber;
		int upperBound;
		int lowerBound;
		Activity overlappedActivity;
		char assignedPerson;
		
		public Activity(int activityNumber, int upperBound, int lowerBound) {
			this.activityNumber = activityNumber;
			this.upperBound = upperBound;
			this.lowerBound = lowerBound;
			this.overlappedActivity = null;
			this.assignedPerson = ' ';
		}
		
		public int getActivityNumber() {
			return activityNumber;
		}
		
		public int getUpperBound() {
			return upperBound;
		}
		
		public int getLowerBound() {
			return lowerBound;
		}
		
		public Activity getOverlappedActivity() {
			return overlappedActivity;
		}
		
		public char getAssignedPerson() {
			return assignedPerson;
		}
		
		public void setOverlappedActivity(Activity overlappedActivity) {
			this.overlappedActivity = overlappedActivity;
		}
		
		public void setAssignedPerson(char assignedPerson) {
			this.assignedPerson = assignedPerson;
		}
		
		public boolean overlap(Activity other) {
			if(other.upperBound < this.upperBound && this.upperBound < other.lowerBound) {
				return true;
			}
			return false;
		}
	}
	
}
