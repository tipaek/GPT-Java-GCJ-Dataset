import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = Integer.parseInt(scanner.nextLine());
		for(int k=1;k<=numberOfTestCases;k++) {
			int numberOfWork = Integer.parseInt(scanner.nextLine());
			int[][] workTimings = new int[numberOfWork][2];
			for(int j=0;j<numberOfWork;j++) {
				String timing  = scanner.nextLine();
				workTimings[j][0] = Integer.parseInt(timing.split(" ")[0]);
				workTimings[j][1] = Integer.parseInt(timing.split(" ")[1]);
			}
			int[][] workTimingsCopy = new int[numberOfWork][2];
			for(int i=0;i<numberOfWork;i++) {
				for(int j=0;j<2;j++)
					workTimingsCopy[i][j]=workTimings[i][j];
			}
			Arrays.sort(workTimingsCopy,new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]>o2[0])
					return 1;
					else
						return -1;
				}
				
			});
				String schedule = getPossibleSchedule(workTimings, numberOfWork,workTimingsCopy);
				System.out.println("Case #"+k+": "+schedule);
			
		}
	}
	

	public static String getPossibleSchedule(int[][] workTimings,int n,int[][] workTimingsCopy) {
		String s ="";		
		char c[] = new char[n];
		int cameron=0;
		int jamie=-1;
		searchInWorkTimimgs(workTimings,c,workTimingsCopy[0][0],workTimingsCopy[0][1],n,'C');
		for(int i=1;i<n;i++) {
			if(workTimingsCopy[i][0]>=workTimingsCopy[cameron][1]) {
				searchInWorkTimimgs(workTimings,c,workTimingsCopy[i][0],workTimingsCopy[i][1],n,'C');
				cameron=i;
			}
			else if(jamie==-1) {
				searchInWorkTimimgs(workTimings,c,workTimingsCopy[i][0],workTimingsCopy[i][1],n,'J');
				jamie=i;
			}else if(workTimingsCopy[i][0]>=workTimingsCopy[jamie][1]) {
				searchInWorkTimimgs(workTimings,c,workTimingsCopy[i][0],workTimingsCopy[i][1],n,'J');
				jamie=i;
			}
			else
				return "IMPOSSIBLE";
		}
		
		return String.valueOf(c);
	}
	
	public static void searchInWorkTimimgs(int[][] workTimings,char[] c,int lowerLimit,int upperLimit,int n,char x) {
		for(int i=0;i<n;i++) {
			if(workTimings[i][0]==lowerLimit&&workTimings[i][1]==upperLimit) {
				workTimings[i][0]=0;
				workTimings[i][1]=0;
				c[i]=x;
				break;
			}
				
		}
	}
	


}
