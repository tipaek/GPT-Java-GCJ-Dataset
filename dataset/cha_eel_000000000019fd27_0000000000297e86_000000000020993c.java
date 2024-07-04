import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    int T = sc.nextInt();
    int tt = 0;
    while (tt++ < T) {
        int n = sc.nextInt();
        sc.nextLine();
        //System.out.println(n);
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String rowStr = sc.nextLine();
            //System.out.println(rowStr);
            String[] row = rowStr.split(" ");
            int len = 0;
            // int[] a = new int[row.length];
            for (String s : row) {
                arr[i][len++] = Integer.parseInt(s);
            }
            // for(int j : arr[i]) {
            // 	System.out.print(j + " ");
            // }
            // System.out.println();
        }
        int rNum = 0, cNum = 0, tsum = 0;
        //check each row if has repetative
        for (int i = 0; i < n; i++) {
        	Set<Integer> set = new HashSet<>();
        	for (int j : arr[i]) {
        		if (set.contains(j)) {
        			rNum++;
        			break;
        		} else {
        			set.add(j);
        		}
        	}
        }
        //check each row if has repetative
        for (int j = 0; j < n; j++) {
        	Set<Integer> set = new HashSet<>();
        	for(int i = 0; i < n; i++) {
        		if (set.contains(arr[i][j])) {
        			cNum++;
        			break;
        		} else {
        			set.add(arr[i][j]);
        		}
        	}
        	tsum += arr[j][j];
        }
        System.out.println("Case #" + tt + ": " + tsum + " " + rNum + " " + cNum);
    }
}
}