import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Random;
import java.util.BitSet;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.AbstractMap;
import java.util.Objects;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;

public class Solution{

	public static class Interval {
		public int start, end, parentIndex, id;

		public Interval(int start, int end, int id){
			this.start = start;
			this.end = end;
			this.parentIndex = -1;
			this.id = id;
		}
	}

	public static class Endpoint implements Comparable<Endpoint> {

		public int time;
		public boolean isStart;
		public Interval interval;

		public Endpoint(int time, boolean isStart, Interval interval){
			this.time = time;
			this.isStart = isStart;
			this.interval = interval;
		}

		@Override
		public int compareTo(Endpoint otherEndpoint){
			int cmp = Integer.compare(this.time, otherEndpoint.time);
			if(cmp!=0){
				return cmp;
			}
			if((!this.isStart && otherEndpoint.isStart) || (this.isStart == otherEndpoint.isStart)) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public static String solve(List<Interval> intervals){
		List<Endpoint> endpoints = new ArrayList<>();
		for(int i=0;i<intervals.size();i++){
			Interval interval = intervals.get(i);
			endpoints.add(new Endpoint(interval.start, true, interval));
			endpoints.add(new Endpoint(interval.end, false, interval));
		}
		Collections.sort(endpoints);
		List<String> plan = new ArrayList<>(Collections.nCopies(intervals.size(), "C"));
		char[] parents = {'C','J'};
		int curParent = 0;
		int nConcurrent = 0;
		for(Endpoint endpoint: endpoints){
			if(endpoint.isStart){
				nConcurrent++;
				if(nConcurrent>2){
					return "IMPOSSIBLE";
				}
				plan.set(endpoint.interval.id, String.valueOf(parents[curParent]));
				endpoint.interval.parentIndex = curParent;
				curParent = (curParent+1)%2;
			} else {
				nConcurrent--;
				curParent = endpoint.interval.parentIndex;
			}
		}
		return String.join("", plan);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int t=1;t<=T;t++){
			int n = sc.nextInt();
			List<Interval> intervals = new ArrayList<>();
			for(int i=0;i<n;i++){
				intervals.add(new Interval(sc.nextInt(), sc.nextInt(), i));
			}
			System.out.println("Case #"+t+": "+solve(intervals));
		}
	}
}