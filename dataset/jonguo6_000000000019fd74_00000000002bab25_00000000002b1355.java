import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] dx = {0,1,-1,0};
	static int[] dy = {1,0,0,-1};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=0;test<tests;test++) {
			String[] inp = in.nextLine().split(" ");
			int r = Integer.parseInt(inp[0]);
			int c = Integer.parseInt(inp[1]);
			dancer[][] floor = new dancer[r][c];
			int totalskill = 0;
			for(int i=0;i<r;i++) {
				String[] input = in.nextLine().split(" ");
				for(int j=0;j<c;j++) {
					int tskill = Integer.parseInt(input[j]);
					dancer one = new dancer(i,j);
					one.skill = tskill;
					floor[i][j] = one;
				}
			}
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					dancer curr = floor[i][j];
					for(int k=0;k<4;k++) {
						int ax = i + dx[k];
						int ay = j + dy[k];
						if(ax<0||ay<0||ax>=r||ay>=c) continue;
						curr.hasneighbor[k] = true;
						curr.neighbor[k] = floor[ax][ay];
					}
				}
			}
			boolean good = true;
			while(good) {
				good = false;
				for(int i=0;i<r;i++) {
					for(int j=0;j<c;j++) {
						dancer curr = floor[i][j];
						if(curr.eliminate || curr.oldeliminate) continue;
						curr.updateskill();
						totalskill += curr.skill;
						if(curr.skill * curr.numneighbor < curr.enemyskill) {
							curr.eliminate = true;
							good = true;
						}
					}
				}
				for(int i=0;i<r;i++) {
					for(int j=0;j<c;j++) {
						dancer curr = floor[i][j];
						if(!curr.eliminate && !curr.oldeliminate) continue;
						for(int k=0;k<4;k++) {
							if(!curr.hasneighbor[k]) continue;
							dancer neighbor = curr.neighbor[k];
							if(!curr.hasneighbor[3-k]) {
								neighbor.hasneighbor[3-k] = false;
							} else {
								neighbor.neighbor[3-k] = curr.neighbor[3-k];
							}
						}
						curr.oldeliminate = true;
					}
				}
			}
			System.out.println("Case #"+(test+1)+": "+totalskill);
		}
		in.close();
	}
	static class dancer {
		int x=0,y=0;
		int skill = 0;
		boolean[] hasneighbor = new boolean[4];
		dancer[] neighbor = new dancer[4];
		boolean eliminate = false;
		boolean oldeliminate = false;
		int enemyskill = 0;
		int numneighbor = 0;
		public dancer(int a, int b) {
			x=a;
			y=b;
			Arrays.fill(hasneighbor, false);
		}
		public void updateskill() {
			enemyskill = 0;
			numneighbor = 0;
			for(int k=0;k<4;k++) {
				if(!hasneighbor[k]) continue;
				enemyskill += neighbor[k].skill;
				numneighbor++;
			}
		}
	}
}
