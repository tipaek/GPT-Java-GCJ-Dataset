import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t =s.nextInt();
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			long sum = 0;
			long cx = 0;
			long rx = 0;
			ArrayList<Long>[] cs = new ArrayList[n];
			boolean[] rs = new boolean[n];
			for (int j = 0; j < n; j++) {
				ArrayList<Long> ccs = new ArrayList<Long>();
				boolean counted = false;
				for (int j2 = 0; j2 < n; j2++) {
					long x = s.nextLong();
					if(j==j2) {
						sum=sum+x;
					}
					if(ccs.contains(x)&&!counted) {
						rx++;
						counted=true;
					}else {
						ccs.add(x);
					}
					if(cs[j2]==null) {
						cs[j2]=new ArrayList<Long>();
						cs[j2].add(x);
					}else {
						if(cs[j2].contains(x)&&!rs[j2]) {
							cx++;
							rs[j2]=true;
						}else {
							cs[j2].add(x);
						}
					}
					
				}
			}
			System.out.println("Case #"+(i+1)+": "+sum+" "+rx+" "+cx);
		}

	}

}
