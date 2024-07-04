//package qround.c;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Solution {
	static Character C ='C';
	static Character J='J';

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		for (int i = 0; i < t; ++i) {
			int N = Integer.parseInt(in.nextLine());
			List<Schedule>	scheduleList = new ArrayList();
			
			for(int j=0;j<N ;j++) {
				String[] array = in.nextLine().split("\\s");
				Schedule x = new Schedule();
				x.start = Integer.parseInt(array[0]);
				x.end = Integer.parseInt(array[1]);
				x.sequence = j+1;
				scheduleList.add(x);
			}
			AtomicInteger index = new AtomicInteger(0);
			List<Schedule> sortedList= scheduleList
			.stream()
			.sorted((p1, p2) -> p1.start.compareTo(p2.start))
			.map(x -> {
				x.order = index.incrementAndGet();
				x.initial = C;
				return x;
				})
			.collect(Collectors.toList());
			
			List<Schedule> baseSet = new ArrayList();
			List<Schedule> remainderBaseSet = new ArrayList();
			baseSet.add(sortedList.get(0));

			findNextInLine(sortedList, baseSet.get(0), baseSet);
			
			Set<Integer> baseSequence = baseSet.stream().map(x -> x.sequence).collect(Collectors.toSet());
			
			List<Schedule> remainderList = sortedList.stream().filter(x -> !baseSequence.contains(x.sequence))
					.map(x -> {
						x.initial = J;
						return x;
					})
					.collect(Collectors.toList());
			if(!remainderList.isEmpty()) {
				remainderBaseSet.add(remainderList.get(0));
				findNextInLine(remainderList, remainderList.get(0), remainderBaseSet);
			}
			if((remainderList.size() - remainderBaseSet.size()) > 0) {
				System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
//				System.out.println("IMPOSSIBRU");
			}else {
				baseSet.addAll(remainderBaseSet);
				baseSet.sort((p1, p2) -> p1.sequence.compareTo(p2.sequence));
				StringBuffer initialsSequence = new StringBuffer();
				baseSet.stream().forEach( x-> initialsSequence.append(x.initial));
//				System.out.println(initialsSequence);
				System.out.println("Case #" + (i+1) + ": " + initialsSequence);
				
			}
			
			
			
			
//			System.out.println("Case #" + (i+1) + ": " + ((masterBuffer.length() < bruteReverseBuffer.length()) ? masterBuffer : printReverse(bruteReverseBuffer)));

		}
	}

	public static void findNextInLine(List<Schedule> filteredList, Schedule schedule, List<Schedule> baseSet) {
		if (!filteredList.isEmpty()) {
			
			Optional<Schedule> nextSchedule = filteredList.stream()
					.filter(x -> x.start >= schedule.end).findFirst();
			if (nextSchedule.isPresent()) {
				baseSet.add(nextSchedule.get());
				findNextInLine(filteredList,nextSchedule.get(),baseSet);
			}else return;
		}else return;
	}

}

class Schedule implements Comparable<Schedule> {
	Integer start;
	Integer end;
	Integer sequence;
	Integer order;
	Character initial;

	@Override
	public int compareTo(Schedule arg0) {
		return this.start.compareTo(arg0.start);
	}
}