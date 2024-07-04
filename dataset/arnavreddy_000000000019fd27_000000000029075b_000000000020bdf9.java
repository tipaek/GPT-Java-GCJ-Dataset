import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = in.nextInt();
		for(int count = 1; count <= t; count++){
			
			int n= in.nextInt();
			
			Interval[] intervals = new Interval[n];
			for(int i = 0; i<n; i++){
				intervals[i] = new Interval(in.nextInt(), in.nextInt(), i);
			}
			Arrays.sort(intervals);
			
			Interval cam = null, jam = null;		
			String[] ans = new String[n];
			boolean impos = false;
			for(int index = 0; index<intervals.length; index++){
				
				if(cam == null) {
					
					cam = intervals[index];
					ans[intervals[index].ogIndex] = "C";
				}
				
				else{
					
					if(cam.end <= intervals[index].start){
						cam = intervals[index];
						ans[intervals[index].ogIndex] = "C";
					}
					else{
						if(jam == null){
							
							jam = intervals[index];
							ans[intervals[index].ogIndex] = "J";
							
						}
						else{
							if(jam.end <= intervals[index].start){
								jam= intervals[index];
								ans[intervals[index].ogIndex] = "J";
							}
							else {
								System.out.println("Case #" + count + ": IMPOSSIBLE");
								impos = true;
							}
							
						}
				}
				}
				
			}
			if(impos==false){
				System.out.print("Case #" + count +": ");
				for(int i = 0; i<ans.length;i++) {
					String str = ans[i];
					System.out.print(str);
					System.out.println();
				}
			}
		}
	}
}