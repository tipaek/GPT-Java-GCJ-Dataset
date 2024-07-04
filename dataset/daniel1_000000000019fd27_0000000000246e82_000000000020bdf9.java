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
		int start, end;

		public Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

	public static class Endpoint implements Comparable<Endpoint> {

		public int time;
		public boolean isStart;

		public Endpoint(int time, boolean isStart){
			this.time = time;
			this.isStart = isStart;
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
		for(Interval interval: intervals){
			endpoints.add(new Endpoint(interval.start, true));
			endpoints.add(new Endpoint(interval.end, false));
		}
		Collections.sort(endpoints);
		StringBuilder sb = new StringBuilder();
		char[] parents = {'C','J'};
		int curParent = 0;
		int nConcurrent = 0;
		for(Endpoint endpoint: endpoints){
			if(endpoint.isStart){
				nConcurrent++;
				if(nConcurrent>2){
					return "IMPOSSIBLE";
				}
				sb.append(parents[curParent]);
				curParent = (curParent+1)%2;

			} else {
				nConcurrent--;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int t=1;t<=T;t++){
			int n = sc.nextInt();
			List<Interval> intervals = new ArrayList<>();
			for(int i=0;i<n;i++){
				intervals.add(new Interval(sc.nextInt(), sc.nextInt()));
			}
			System.out.println("Case #"+t+": "+solve(intervals));
		}
	}
}