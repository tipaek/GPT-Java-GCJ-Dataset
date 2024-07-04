import java.util.Scanner;

public class Solution {

	static int  R , C ;
	
	static long num;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		long ans = 0;
		for(int i = 1 ; i <= t ; i++) {
			num = 0;
			ans = 0;
			R = scan.nextInt();
			C = scan.nextInt();
			int [][] val = new int[R][C];
			long pnum = 0;
			for(int j = 0 ; j < R ; j++) {
				for(int k = 0 ; k < C ; k++) {
					val[j][k] = scan.nextInt();
					pnum += val[j][k];
				}
			}
			pnum++;
			
			while(true) {
				val = elim(val);
				if(pnum==num) {
					break;
				}
				
				//System.out.println("pnum = " + pnum + "num = " + num);
				ans += num;
				pnum = num;
				num = 0;
			}
			System.out.println("Case #" + i + ": " + ans);
		}
	}

	public static int [][] elim(int [][] val) {
		int [][] nVal = new int[R][C];
		for(int j = 0 ; j < R ; j++) {
			for(int k = 0 ; k < C ; k++) {
				//System.out.print(val[j][k] + "  ");
				if(val[j][k]!=-1) {
					
					num+=val[j][k];
					int neigh = 0;
					int l = left(val,j,k);
					int r = right(val,j,k);
					int u = up(val , j,k);
					int d = down(val,j,k);
					int score = 0;
					if(l!=-1) {
						neigh++;
						score += l;
					}
					if(r!=-1) {
						neigh++;
						score += r;
					}
					if(u!=-1) {
						neigh++;
						score += u;
					}
					if(d!=-1) {
						neigh++;
						score += d;
					}
					if(neigh!=0) {
						int myscore = val[j][k] * neigh;
						int oscore = score;
						//System.out.println("myscore = " + myscore + " oscore = " + oscore);
						if(myscore<oscore) {
							nVal[j][k] = -1;
						} else {
							nVal[j][k] = val[j][k];
						}
					} else {
						nVal[j][k] = val[j][k];
					}
				} else {
					nVal[j][k] = -1;
				}
			}
			//System.out.println();
		}
		return nVal;
	}
	
	static int left(int [][] val, int j , int k) {
		for(int l = k-1 ; l >= 0 ; l--) {
			if(val[j][l]>=0) {
				return val[j][l];
			}
		}
		return -1;
	}
	
	static int right(int [][] val, int j , int k) {
		for(int l = k+1 ; l < C ; l++) {
			if(val[j][l]>=0) {
				return val[j][l];
			}
		}
		return -1;
	}
	
	static int up(int [][] val, int j , int k) {
		for(int l = j-1 ; l >= 0 ; l--) {
			if(val[l][k]>=0) {
				return val[l][k];
			}
		}
		return -1;
	}
	
	static int down(int [][] val, int j , int k) {
		for(int l = j+1 ; l < R ; l++) {
			if(val[l][k]>=0) {
				return val[l][k];
			}
		}
		return -1;
	}

}
