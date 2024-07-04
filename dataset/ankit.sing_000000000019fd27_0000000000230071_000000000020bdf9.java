import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int i=1;i<=tests;i++) {
			Map<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
            int schedules = in.nextInt();
			for(int j=0;j<schedules;j++){
				int startTime = in.nextInt();
				int endTime = in.nextInt();
                treeMap.put(startTime,endTime);
            }
			int end1 = (int) treeMap.values().toArray()[0];
			int end2 = (int) treeMap.values().toArray()[1];
			int countGT2 = 0;
			String output = "JC";
			for(Map.Entry<Integer,Integer> x: treeMap.entrySet()){
				int start = x.getKey();
				int end = x.getValue();
				if(start >= end1 && countGT2 > 1){
					output = output + "J";
					end1 = end;
				}else if(start >= end2 && countGT2 > 1) {
					output = output + "C";
					end2 = end;
				}else if(countGT2 > 1){
					output = "IMPOSSIBLE";
				}
				countGT2++;
			}
            System.out.println("Case #"+i+": "+output);
        }
    }
}