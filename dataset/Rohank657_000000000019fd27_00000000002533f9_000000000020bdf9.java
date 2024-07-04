import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i = 1;i<=t;i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][2];
			String[] copyArr = new String[n];
			HashMap<String,Integer> test = new HashMap<String,Integer>();
			for(int j = 0;j<n;j++) {
				arr[j][0] = sc.nextInt();
				arr[j][1] = sc.nextInt();
				if(test.containsKey(arr[j][0]+" "+arr[j][1])) {
					test.put(arr[j][0]+" "+arr[j][1]+" "+2, 1);
					copyArr[j] = arr[j][0]+" "+arr[j][1]+" "+2;
				}
				else {
					test.put(arr[j][0]+" "+arr[j][1], 1);
					copyArr[j] = arr[j][0]+" "+arr[j][1];
				}
			}
			Arrays.sort(arr,new Comparator<int[]>(){
				public int compare(int[] a,int[] b) {
					if(a[0]>=b[0]) return 1;
					return -1;
				}
			});
			HashMap<String,Character> hm = new HashMap<String,Character>();
			int[] jcurr = {-1,-1};
			int[] ccurr = {-1,-1};
			boolean flag = false;
			for(int j = 0;j<n;j++) {
				if(arr[j][0]>=ccurr[1]) {
					if(hm.containsKey(arr[j][0]+" "+arr[j][1])) {
						hm.put(arr[j][0]+" "+arr[j][1]+" "+2, 'C');
					}
					else {
						hm.put(arr[j][0]+" "+arr[j][1], 'C');
					}
					ccurr[0] = arr[j][0];
					ccurr[1] = arr[j][1];
				}
				else if(arr[j][0]>=jcurr[1]) {
					if(hm.containsKey(arr[j][0]+" "+arr[j][1])) {
						hm.put(arr[j][0]+" "+arr[j][1]+" "+2, 'J');
					}
					else {
						hm.put(arr[j][0]+" "+arr[j][1], 'J');
					}
					jcurr[0] = arr[j][0];
					jcurr[1] = arr[j][1];
				}
				else {
					System.out.println("Case #"+i+": "+"IMPOSSIBLE");
					flag = true;
					break;
				}
			}
			if(flag) continue;
			StringBuffer sb = new StringBuffer();
			for(int j = 0;j<n;j++) {
				sb.append(hm.get(copyArr[j]));
			}
			System.out.println("Case #"+i+": "+sb.toString());
		}
		sc.close();
	}
}