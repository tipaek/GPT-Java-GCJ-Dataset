import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static String sol="";
	public static int timecount=1;
	public static int jamietimecount=1;
	public static int[][] cprevioustimings=new int[1][2];
	public static int[][] jprevioustimings=new int[1][2];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int count=0;
		while(t>=1) {
			count++;
			int N=s.nextInt();
			int[][] timings=new int[N][2];
			for(int i=0;i<N;i++) {
				for(int j=0;j<2;j++) {
					timings[i][j]=s.nextInt();
				}
			}
			Arrays.sort(timings,(a,b)->Integer.compare(a[0], b[0]));
			for(int i=0;i<N;i++) {
				int CameronEndTiming;
				int CameronstartTiming;
				int JamieEndTiming;
				int jamiestartTiming;
				
				
				CameronstartTiming=timings[i][0];
				CameronEndTiming=timings[i][1];
				camfunction(CameronstartTiming,CameronEndTiming);
			}
			System.out.println("Case #"+count+": "+sol);
			t--;
			sol="";
			timecount=1;
			jamietimecount=1;
			cprevioustimings[0][0]=0;
			cprevioustimings[0][1]=0;
			jprevioustimings[0][0]=0;
			jprevioustimings[0][1]=0;
			
		}
		
		
	}

	public static void camfunction(int cameronstartTiming, int cameronEndTiming) {
		// TODO Auto-generated method stub
	    
		if(timecount==1) {
			sol=sol+"C";
			cprevioustimings[0][0]=cameronstartTiming;
			cprevioustimings[0][1]=cameronEndTiming;
			timecount=timecount+1;
		}else {
			if(cameronstartTiming>=cprevioustimings[0][1]) {
			sol=sol+"C";
			cprevioustimings[0][0]=cameronstartTiming;
			cprevioustimings[0][1]=cameronEndTiming;
			}
			else {
				jamfunction(cameronstartTiming,cameronEndTiming);
			}
		}
	}

	public static void jamfunction(int cameronstartTiming, int cameronEndTiming) {
		// TODO Auto-generated method stub
	   
		if(jamietimecount==1) {
			sol=sol+"J";
			jprevioustimings[0][0]=cameronstartTiming;
			jprevioustimings[0][1]=cameronEndTiming;
			jamietimecount++;
		}else {
			if(cameronstartTiming>=jprevioustimings[0][1]) {
				sol=sol+"J";
				jprevioustimings[0][0]=cameronstartTiming;
				jprevioustimings[0][1]=cameronEndTiming;
			}
			else
			{
				sol="IMPOSSIBLE";
			}
		}
	}

}
