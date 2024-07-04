import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int i=1;i<=tests;i++) {
			Map<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
            int schedules = in.nextInt();
			int end1 = 0, start1 = 1550;
			int end2 = 0, start2 = 1550;
			String output = "";
			for(int j=1;j<=schedules;j++){
				int startTime = in.nextInt();
				int endTime = in.nextInt();
				if((startTime >= end1 || endTime <= start1)){
					output = output + "C";
					start1 = startTime;
					end1 = endTime;
				}else if((startTime >= end2 || endTime <= start2)){
					output = output + "J";
					start2 = startTime;
					end2 = endTime;
				}else {
					output = "IMPOSSIBLE";
				}
            }
            System.out.println("Case #"+i+": "+output);
        }
    }
}