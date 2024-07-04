import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = sc.nextInt();

		for(int testCase =1; testCase <=testCases ; testCase++) {

			int activities = sc.nextInt();
			int[] startTime = new int[activities];
			int[] endTime = new int[activities];

			for(int i = 0; i<activities; i++) {
				startTime[i] = sc.nextInt();
				endTime[i] = sc.nextInt();
			}

			scheduleActivities(startTime, endTime, activities, testCase);
		}
	}

	private static void scheduleActivities(int[] startTime, int[] endTime, int activities, int testCase) {

		sort(startTime, endTime, 0, activities-1);
		
		StringBuilder s = new StringBuilder();
		int cameronFreeTime = 0;
		int jamieFreeTime = endTime[0];
		s.append("J");
		
		for( int i=1; i < activities; i++) {
			if(startTime[i] >= jamieFreeTime) {
				jamieFreeTime = endTime[i];
				s.append("J");
			}
			else if(startTime[i] >= cameronFreeTime) {
				cameronFreeTime = endTime[i];
				s.append("C");
			}
			else {
				s = new StringBuilder("IMPOSSIBLE");
				break;
			}
		}
		
		display(s.toString(), testCase);
	}

	private static void sort(int[] startTime, int[] endTime, int left, int right) {

		if(left<right) {
			int mid = (left + right) / 2;
			sort(startTime, endTime, mid+1, right);
			sort(startTime, endTime, left, mid);
			merge(startTime, endTime, left, mid, right);
		}
	}

	private static void merge(int[] startTime, int[] endTime, int left, int mid, int right) {

		int length1 = mid - left + 1; 
		int length2 = right - mid;

		int[] leftStart = new int[length1];
		int[] leftEnd = new int[length1];

		int[] rightStart = new int[length2];
		int[] rightEnd = new int[length2];

		for(int i =0; i<length1; i++) {
			leftStart[i] = startTime[left + i];
			leftEnd[i] = endTime[left + i];
		}

		for(int i =0; i<length2; i++) {
			rightStart[i] = startTime[mid + 1 + i];
			rightEnd[i] = endTime[mid + 1 + i];
		}

		int i = 0;
		int j= 0;
		int k = left ;
		while(i < length1 && j <length2) {

			if(leftStart[i] <= rightStart[j]) {
				startTime[k] = leftStart[i];
				endTime[k] = leftEnd[i];
				i++;
			} else {
				startTime[k] = rightStart[j];
				endTime[k] = rightEnd[j];
				j++;
			}

			k++;

		}

		while(i < length1) {
			startTime[k] = leftStart[i];
			endTime[k] = leftEnd[i];
			k++;
			i++;
		}

		while(j < length2) {

			startTime[k] = rightStart[j];
			endTime[k] = rightEnd[j];
			k++;
			j++;
		}

	}
	
	private static void display(String s, int testCase) {

		System.out.println("Case #" +testCase + ": " + s);
	}


}
