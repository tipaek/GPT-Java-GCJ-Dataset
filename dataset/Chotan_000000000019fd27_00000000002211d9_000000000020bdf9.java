import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
		    int N = sc.nextInt();
		    int[][] arr = new int[N][2];
		    for(int i = 0; i < N; i++) {
		        arr[i][0] = sc.nextInt();
		        arr[i][1] = sc.nextInt();
		    }
		    Arrays.sort(arr, new Comparator<int[]>() {
		        public int compare(int[] m, int[] n) {
		            if(m[1] < n[1]) {
		                return -1;
		            } else if(m[1] == n[1]) {
		                if(m[0] <= n[0]) {
		                    return -1;
		                } else {
		                    return 1;
		                }
		            } else {
		                return 1;
		            }
		        }
		    });
		    HashSet<Integer> setC = new HashSet();
		    int last = arr[0][1];
		    setC.add(0);
		    for(int i = 1; i < N; i++) {
		        if(last <= arr[i][0]) {
		            setC.add(i);
		            last = arr[i][1];
		        }
		    }
		    HashSet<Integer> setJ = new HashSet();
		    last = -1;
		    for(int i = 0; i < N; i++) {
		        if(!setC.contains(i)) {
		            if(last == -1) {
		                setJ.add(i);
		                last = arr[i][1];
		            } else if(last <= arr[i][0]) {
		                setJ.add(i);
		                last = arr[i][1];
		            }
		        }
		    }
		    if(setC.size() + setJ.size() == N) {
		        StringBuilder sb = new StringBuilder();
		        for(int i = 0; i < N; i++) {
		            if(setC.contains(i))
		                sb.append('C');
		            else 
		                sb.append('J');
		        }
		        System.out.println("Case #" + t + ": " + sb.toString());
		    } else {
		        System.out.println("IMPOSSIBLE");
		    }
		}
	}
}
