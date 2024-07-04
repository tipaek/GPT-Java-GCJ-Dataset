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
        int[][] arr = new int[n][2];
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
        Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b){
				if(a[0]==b[0]){
					return a[1] - b[1];
				}else {
					return a[0] - b[0];
				}
			}
		});
        //check each act assign to first if not conflict
        List<int[]> c = new ArrayList<int[]>();
        List<int[]> j = new ArrayList<int[]>();
        
        String s = new String();
        for (int i = 0; i < n; i++)
            s += " ";
		StringBuilder sb = new StringBuilder(s);
        c.add(arr[0]);
        sb.setCharAt(0, 'C');
        boolean flag = true;
        //n acts for 1 test set
        //System.out.println(n);
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
		for (int i = 1; i < n; i++) {
// 			map.put(arr[i], i);
			if (arr[i][0] >= c.get(c.size()-1)[1] ) {
				c.add(arr[i]);
				sb.setCharAt(map.get(arr[i]), 'C');
				// s += "C";
			} else {
				if (j.size() != 0 && arr[i][0] < j.get(j.size() - 1)[1]) {
					flag = false;
					//break;
				} else {
					j.add(arr[i]);
					sb.setCharAt(map.get(arr[i]), 'J');
					//s += "J";
				}
			}
		}
		if (!flag) System.out.println("Case #" + tt + ": " + "IMPOSSIBLE");
        else System.out.println("Case #" + tt + ": " + sb.toString());
    }
}
}