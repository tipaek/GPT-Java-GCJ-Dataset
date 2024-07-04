import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static class Node implements Comparable<Node> {
		public int x;
		public int y;
		public int idx;
		public Node(int x, int y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}

		@Override
		public int compareTo(Node node) {
			if (this.x == node.x) {
				if (this.y < node.y) {
					return -1;
				} else if (this.y > node.y) {
					return 1;
				}
				return 0;
			} else if (this.x < node.x) {
				return -1;
			} else {
				return 1;
			}
		}
	}

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int t = scanner.nextInt();
	    for (int a=1; a<=t; a++) {
	        int n = scanner.nextInt();
	        int[] cnt = new int[24*60+1];
			int[] mflag = new int[24*60+1];
	        Arrays.fill(cnt, 0);
	        Node[] nodes = new Node[n];
	        for (int i=0; i<n; i++) {
	        	int x = scanner.nextInt();
	        	int y = scanner.nextInt();
	        	cnt[x]++;
	        	cnt[y]--;
	        	nodes[i] = new Node(x, y, i);
			}
	        boolean imp = false;
			mflag[0] = cnt[0];
	        for (int i=1; i<=24*60; i++) {
				mflag[i]=cnt[i]+mflag[i-1];
	        	if (mflag[i] > 2) {
	        		imp = true;
	        		break;
				}
			}
			if (imp) {
				System.out.println("Case #" + a + ": " + "IMPOSSIBLE");
				continue;
			} else {
				StringBuilder ans = new StringBuilder();
				boolean isCA = false;
				boolean isJA = false;
				int sC = -1;
				int sJ = -1;
				Arrays.sort(nodes);
				char[] tans = new char[n];
				for (int i=0; i<n; i++) {
					if ((isCA && nodes[i].x >= sC) || (!isCA)) {
						tans[nodes[i].idx] = 'C';
						isCA = true;
						sC = nodes[i].y;
					} else if ((isJA && nodes[i].x >= sJ) || (!isJA)) {
						tans[nodes[i].idx] = 'J';
						isJA = true;
						sJ = nodes[i].y;
					}
				}
				System.out.println("Case #" + a + ": " + new String(tans));
			}
        }
    }
}