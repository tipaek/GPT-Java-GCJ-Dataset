import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
    		String answer = "";
    		int n = in.nextInt();
    		List<int[]> cameron = new ArrayList<>();
    		List<int[]> jamie = new ArrayList<>();
    		boolean cam_flag = false;
    		boolean jam_flag = false;
    		for(int j = 0; j < n; j++) {
    			int[] event = new int[] {in.nextInt(), in.nextInt()};
    			cam_flag = check(event, cameron);
    			jam_flag = check(event, jamie);
    			if(cam_flag && jam_flag) {
    				answer = "IMPOSSIBLE";
    				break;
    			}
    			if(cam_flag && !jam_flag) {
    				jamie.add(event);
    				answer+="J";
    			}
    			if(!cam_flag) {
    				cameron.add(event);
    				answer+="C";
    			}
    		}
    		System.out.println("Case #" + i + ": " + answer);
    }
  }
  
  private static boolean check(int[] event, List<int[]> person) {
	  for(int[] e: person) {
			if(overlap(e,event)) {
				return true;
			}
		}
	  
	 return false;
  }
  private static boolean overlap(int[] e1, int[] e2) {
	  return !(e1[0] >= e2[1] || e1[1] <= e2[0]);
  }
}
