/* Use the slash-star style comments or the system won't see your
	identification information */
/*
	ID: audreylee16
	LANG: JAVA
	TASK: default
*/
import java.io.*;
import java.util.*;

class Solution {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	int cases = in.nextInt();
	in.nextLine();
	for(int i = 1; i <= cases; i++) {
		int n = in.nextInt();
		in.nextLine();
		List<int[]> sorted = new ArrayList<int[]>();
		String[] task = new String[n];
		String answer = null;
		for(int lcv = 0; lcv < n; lcv++) {
			String[] a = in.nextLine().split(" ");
			int[] add = {Integer.parseInt(a[0]),Integer.parseInt(a[1]),lcv};
			for(int x = 0; x < sorted.size(); x++) {
				if(add[0] < sorted.get(x)[0]) {
					sorted.add(x, add);
					add = null;
					break;
				}
			}
			if(add != null) {
				sorted.add(add);
			}
		}
		
		int lastJ = 0;
		int lastC = 99999;
		boolean CTurn = false;
		task[sorted.get(0)[2]] = "J";
		for(int t = 1; t < sorted.size(); t++) {
			int[] curr = sorted.get(t);
			int[] prev = sorted.get(t-1);
			if(curr[0] < prev[1]) {
				if(lastC == 99999) {
					CTurn = true;
					lastC = t;
					task[curr[2]] = "C";
				} else {
					if(CTurn) {
						if(curr[0] < sorted.get(lastJ)[1]) {
							answer = "IMPOSSIBLE";
							break;
						} else {
							CTurn = false;
							lastJ = t;
							task[curr[2]] = "J";
						}
					} else {
						if(curr[0] < sorted.get(lastC)[1]) {
							answer = "IMPOSSIBLE";
							break;
						} else {
							CTurn = true;
							lastC = t;
							task[curr[2]] = "C";
						}
					}
				}
			} else {
				if(CTurn) {
					lastC = t;
					task[curr[2]] = "C";
				} else {
					lastJ = t;
					task[curr[2]] = "J";
				}
			}
		}
		
		if(answer==null) {
			answer = "";
			for(String s : task) {
				answer += s;
			}
		}
		System.out.println("Case #" + i + ": " + answer);
	}
  }
  
  public static void printList(List<int[]> print) {
	  for(int[] i : print) {
		  System.out.println(i[0] + "->" + i[1]);
	  }
  }
}
