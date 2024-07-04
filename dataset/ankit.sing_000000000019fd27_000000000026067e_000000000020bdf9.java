import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int i=1;i<=tests;i++) {
            int schedules = in.nextInt();
			int end1 = 0, start1 = 999999;
			int end2 = 0, start2 = 999999;
			int count = 0, count2 = 0;
			String output = "";
			int[][] arr = new int[schedules][2];
			for(int j=0;j<schedules;j++)
				for(int k=0;k<2;k++)
					arr[j][k] = in.nextInt();
			HashSet<Integer> hashSet1 = new HashSet<Integer>();
			HashSet<Integer> hashSet2 = new HashSet<Integer>();
			for(int j=0;j<schedules;j++) {
				int startTime = arr[j][0];
				int endTime = arr[j][1];
				if(hashSet1.add(startTime) == false && count >=2){
					output = "IMPOSSIBLE";
					break;
				}else if(hashSet1.add(startTime) == false){
					count++;
				}
				if(hashSet2.add(endTime) == false && count2 >=2){
					output = "IMPOSSIBLE";
					break;
				}else if(hashSet2.add(endTime) == false){
					count2++;
				}
				if((startTime >= end1 || endTime <= start1)) {
					output = output + "C";
					start1 = startTime;
					end1 = endTime;
				}else if((startTime >= end2 || endTime <= start2)) {
					output = output + "J";
					start2 = startTime;
					end2 = endTime;
				}else {
					output = "IMPOSSIBLE";
					break;
				}
            }
            System.out.println("Case #"+i+": "+output);
        }
    }
}