import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i=0;i<T;i++) {
			int timesC[] = new int[1500];
			int timesJ[] = new int[1500];
			for (int j=0;j<1500;j++) {
				timesC[j] = 0;
				timesJ[j] = 0;
			}
			String ans = "";
			int N = scan.nextInt();
			for (int j=0;j<N;j++) {
				int s = scan.nextInt();
				int e = scan.nextInt();
				boolean impossible = false;
				boolean c = true;
				for (int k=s;k<e;k++) {
					if (timesC[k] != 0) {
						c = false;
						//break;
					}
				}
				if (c) {
					for (int k=s;k<e;k++) {
						timesC[k]++;
					}
					ans += 'C';
				}
				else {
					for (int k=s;k<e;k++) {
						if (timesJ[k] != 0) {
							impossible = true;
							//break;
						}
					}
					if (!impossible) {
						for (int k = s;k<e;k++) {
							timesJ[k]++;
						}
						ans += 'J';
					}
					else {
						ans = "IMPOSSIBLE";
					}
				}
			}
			System.out.println("Case #" + (i+1) + ": " + ans);
		}

	}

}
