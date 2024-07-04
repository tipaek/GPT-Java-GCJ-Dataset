import java.util.*;
public class Solutioin {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int abx = x<0? -x: x;
			int aby = y<0? -y: y;
			Boolean change = false;
			if(abx < aby) {
				int tmp = abx;
				abx = aby;
				aby = tmp;
				change = true;
			}
			int sum = abx+aby;
			if(sum % 2 == 0) {
				System.out.println("Case #"+i+": IMPOSSIBLE");
				continue;
			}
			// sum is odd, we can do it
			int[] tmp = find(sum);
			int n = tmp[0];
			int tsum = tmp[1];
			int[] ans = new int[n];
			int p = (tsum - sum) / 2;
			int idx = 0;
			while(p > 0) {
				if(p%2 == 1) {
					ans[idx] = -1;
				}
				idx++;
				p = p/2;
			}
			int fdx = abx + (tsum -sum)/2;
			idx = 0;
			ArrayList<Integer> scrumble = new ArrayList();
			while(fdx > 0) {
				if(fdx%2 == 1) {
					if(ans[idx] == 0) {
						ans[idx] = 1;
					}
					if(ans[idx] == -1) {
//						ans[idx] = -2;
//						scrumble.add(idx+1);
					}
				} else {
					if(ans[idx] == -1) {
						ans[idx] = -2;
					}
				}
				idx++;
				fdx = fdx/2;
			}
			for(int e: scrumble) {
//				System.out.println("scrum "+e);
				if(ans[e] ==0) {
					ans[e] = 1;
				} else if(ans[e] == -2) {
					ans[e] = -1;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int e: ans) {
//				System.out.println(e);
				if(e == 1 && !change || e == 0 &&change) {
					if(x>=0) {
						sb.append('E');
					} else {
						sb.append('W');
					}
				}
				if(e == -2 && !change || e==-1 && change) {
					if(x >=0) {
						sb.append('W');
					} else {
						sb.append('E');
					}
				}
				if (e == 0 && !change || e==1 && change) {
					if(y >=0) {
						sb.append('N');
					} else {
						sb.append('S');
					}
				}
				if (e == -1 && !change || e == -2 && change) {
					if(y >= 0) {
						sb.append('S');
					} else {
						sb.append('N');
					}
				}
			}
			System.out.println("Case #"+i+": "+sb);
		}
	}
	
	public static int[] find(int sum) {
		int ans = 1;
		int i = 1;
		while(i < sum) {
			i = i*2+1;
			ans++;
		}
		return new int[]{ans, i};
	}
}
