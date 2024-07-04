

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class Solution {

	void getSchedule(int n, Slot[] arr, int caseNo, LinkedHashMap<Slot, Integer> map) {

		Arrays.sort(arr, new Comparator<Slot>() {
			@Override
			public int compare(Slot slot1, Slot slot2) {
				return Integer.compare(slot1.startTime, slot2.startTime);
			}
		});

	    char[] workOrder = new char[n];
		workOrder[0] = 'C';
		int cEndTime = arr[0].endTime, jEndTime = 0;

		for (int i = 1; i < n; i++) {
			if (arr[i].startTime >= arr[i - 1].endTime) {
				workOrder[i] = workOrder[i - 1];
				if (workOrder[i] == 'J')
					jEndTime = arr[i].endTime;
				else if (workOrder[i] == 'C')
					cEndTime = arr[i].endTime;
			} else {
				char busy = workOrder[i - 1];

				if (busy == 'C') {
					if (jEndTime > arr[i].startTime) {
						System.out.println("Case #" + caseNo + ": "
								+ "IMPOSSIBLE");
						return;
					}
					workOrder[i] = 'J';
					jEndTime = arr[i].endTime;

				} else if (busy == 'J') {
					if (cEndTime > arr[i].startTime) {
						System.out.println("Case #" + caseNo + ": "
								+ "IMPOSSIBLE");
						return;
					}
					workOrder[i] = 'C';
					cEndTime = arr[i].endTime;
				}
			}
		}
		
		StringBuffer sbr = new StringBuffer("");
		for(int i =0 ; i<n ; i++ ){
			int idx = map.get(arr[i]);
			sbr.append(workOrder[idx]);
		}
		System.out.println("Case #" + caseNo + ": " + sbr);
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			Slot[] arr = new Slot[n];
			LinkedHashMap<Slot, Integer> map = new LinkedHashMap<Slot, Integer>();
			for (int j = 0; j < n; j++) {
				int start = in.nextInt();
				int end = in.nextInt();
				arr[j] = obj.new Slot(start, end);
				map.put(arr[j], j);
			}
			obj.getSchedule(n, arr, i , map);
		}
	}

	class Slot {
		int startTime;
		int endTime;

		Slot(int a, int b) {
			this.startTime = a;
			this.endTime = b;
		}
	}
}
