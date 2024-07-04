import java.util.Random;
import java.util.Scanner;

public class Solution {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int b = sc.nextInt();
		for (int i = 0;i<t;i++) {
			if (b==10) {
				int [] l = new int[10];
				for (int j = 10;j<l.length;j++) {
					l[j]=sc.nextInt();
				}
				String str = "";
				for (int j = 0;j<l.length;j++) {
					if (l[j]==1) str+="1";
					else str+="0";
				}
				
				System.out.println(str);
				String correct = sc.next();
				continue;
			} 
			
			boolean [] same = new boolean[b/2];
			int [] nums = new int[b];
			
			for (int j = 0;j<b/2;j++) {
				System.out.println(j+1);
				nums[j] = sc.nextInt();
				System.out.println(b-j);
				nums[b-j-1] = sc.nextInt();
				if (nums[j] == nums[b-j-1]) {
					same[j]=true;
				} else {
					same[j]=false;
				}
			}
			
			int rows = b/20;
			String [] status = new String[rows];
			int [] indices = new int[rows*2];
			for (int j = 0;j<rows;j++) {
				boolean hasSame = false;
				boolean hasDiff = false;
				int indexSame = -1;
				int indexDiff = -1;
				for (int k = 0;k<10;k++) {
					if (same[rows*10+k]) {
						hasSame=true;
						indexSame = rows*10+k;
					}
					else {
						hasDiff = true;
						indexDiff = rows*10+k;
					}
				}
				if (hasSame && hasDiff) {
					status[j] = "both";
					indices[2*j] = indexSame;
					indices[2*j+1] = indexDiff;
				}
				else if (hasSame && !hasDiff) {
					indices[2*j] = indexSame;
					indices[2*j+1] = indexSame;
					status[j] = "same";
				}
				else {
					indices[2*j] = indexDiff;
					indices[2*j-1] = indexDiff;
					status[j]="diff";
				}
			}
			
			int [] current = new int[indices.length];
			for (int j = 0;j<indices.length/2;j++) {
				System.out.println(indices[2*j]);
				current[2*j] = sc.nextInt();
				System.out.println(indices[2*j+1]);
				current[2*j+1] = sc.nextInt();
			}
			
			String [] rowOp = new String[rows];
			for (int j = 0;j<rows;j++) {
				int sBefore = nums[indices[2*j]];
				int dBefore = nums[indices[2*j+1]];
				int sNow = current[2*j];
				int dNow = current[2*j+1];
				if (status[j].contentEquals("both")) {
					
					
					if (sBefore == sNow && dBefore == dNow) {
						rowOp[j] = "none";
					} else if (sBefore != sNow && dBefore != dNow) {
						rowOp[j] = "flip";
					} else if (sBefore == sNow && dBefore!=dNow) {
						rowOp[j] = "reverse";
					} else {
						rowOp[j] = "both";
					}
					
				} else if (status[j].contentEquals("diff")) {
					if (dBefore==dNow) {
						rowOp[j] = "flip";
					} else {
						rowOp[j] = "none";
					}
				} else {
					if (sBefore==sNow) {
						rowOp[j] = "none";
					} else {
						rowOp[j] = "flip";
					}
				}
			}
			
			int [] result = new int[b];
			
			for (int j = 0;j<rows;j++) {
				for (int k = 0;k<10;k++) {
					result[j*10+k] = nums[j*10+k];
					if (rowOp[j].contentEquals("flip")) {
						if (result[j*10+k]==1) {
							result[j*10+k]=0;
						} else {
							result[j*10+k]=1;
						}
					} else if (rowOp[j].contentEquals("reverse")) {
						if (!same[j+10+k]) {
							if (result[j*10+k]==1) {
								result[j*10+k]=0;
							} else {
								result[j*10+k]=1;
							}
						}
					} else if (rowOp[j].contentEquals("both")) {
						if (same[j+10+k]) {
							if (result[j*10+k]==1) {
								result[j*10+k]=0;
							} else {
								result[j*10+k]=1;
							}
						}
					}
				}
			}
			
			int c = rows*10;
			for (int j = 0;j<rows;j++) {
				for (int k = 0;k<10;k++) {
					int index = c+j*10+k;
					result[index] = nums[nums.length-1-index];
					if (!same[nums.length-1-index]) {
						if (result[index]==1) {
							result[index]=0;
						} else {
							result[index]=1;
						}
					}
				}
			}
			
			String str = "";
			for (int j = 0;j<result.length;j++) {
				if (result[j]==1) str+="1";
				else str+="0";
			}
			
			System.out.println(str);
			String correct = sc.next();
			System.out.println(correct);
		}
		
		
	}
}