import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution {
public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    int T = sc.nextInt();
    //sc.nextLine();
    int tt = 0;
    while (tt++ <= T) {
        // int n = sc.nextInt();
        //sc.next();
        //System.out.println(n);
        String rowStr = sc.nextLine();
        int[] arr = new int[rowStr.length()];
        for (int i = 0; i < rowStr.length(); i++) {
            arr[i] = Integer.parseInt(rowStr.substring(i, i+1));
        }
        // for(int j : arr) {
        //     System.out.print(j + " ");
        // }
        // System.out.println();
        
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int[] arrSort = new int[set.size()];
		int idx = 0;
		for (int k : set) {
			arrSort[idx++] = k;
		}
		Arrays.sort(arrSort);
		String s = new String();
		//check each element

		for (int i = arrSort.length - 1; i >= 0; i--) {
			int cur = arrSort[i];
			if (cur == arrSort[arrSort.length - 1]) {
				for (int j = 0; j < cur; j++) {
					s += '(';
				}
			}
			if (cur != 0) {
				for (int j = map.get(cur); j > 0; j--) {
					s += String.valueOf(cur);
				}
				s += ')';
			}
		}
		if (map.keySet().contains(0)) {
			for (int i = map.get(0); i > 0; i--) {
				s += '0';
			}
		}
		int left = 0; int right = 0;
		for (int i = 0; i < s.length(); i++) {
			if ( s.charAt(i)=='(' ) left++;
			if ( s.charAt(i)==')' ) right++;
		}
		for (int i = (left-right); i > 0; i--) {
			s += ')';
		}
		if (tt <= T + 1) {
			int t = tt - 1;
			if (t == 0) continue;
			System.out.println("Case #" + t + ": " + s);
		}
		    
		// System.out.println("Case #" + tt + ": " + s);
		// if (!flag) System.out.println("Case #" + tt + ": " + "IMPOSSIBLE");
		// else System.out.println("Case #" + tt + ": " + sb.toString());
	}
}
}