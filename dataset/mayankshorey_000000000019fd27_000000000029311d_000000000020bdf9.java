import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int tc=1;tc<=t;++tc) {
			int n = input.nextInt();
			char[] activityOwnerArr = new char[n];
			int[][] timingsArr = new int[n][2];
			for(int i=0;i<n;++i) {
				for(int j=0;j<2;++j) {
					timingsArr[i][j]=input.nextInt();
				}
			}
int[][] copyArr = Arrays.copyOf(timingsArr,n);
			Arrays.sort(timingsArr,new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if(o1[0]<o2[0])
						return -1;
					return 1;
				}

			});

			int activityCount=0;
			int jEnd=0;
			for(int i=0;i<n;++i) {
				if(activityOwnerArr[i]=='\u0000' && timingsArr[i][0]>=jEnd) {
					jEnd= timingsArr[i][1];
					activityOwnerArr[i]='J';
					activityCount++;
				}
			}
			int cEnd=0;
			for(int i=0;i<n;++i) {
				if(activityOwnerArr[i]=='\u0000' && timingsArr[i][0]>=cEnd) {
					cEnd= timingsArr[i][1];
					activityOwnerArr[i]='C';
					activityCount++;
				}
			}


			System.out.print("Case #"+tc+": ");
			if(activityCount==n) {
				char[] outputArr = new char[n];
				for(int i=0;i<n;++i) {
					for(int j=0;j<n;++j) {
						if(outputArr[j]=='\u0000' && copyArr[j][0]==timingsArr[i][0] && copyArr[j][1]==timingsArr[i][1]) {
							outputArr[j]=activityOwnerArr[i];
							break;
						}
				}
			}

			for(int i=0;i<n;++i) {
				System.out.print(outputArr[i]);
			}
			System.out.println();
		}
		else {
			System.out.println("IMPOSSIBLE");
		}
	}
}

}
