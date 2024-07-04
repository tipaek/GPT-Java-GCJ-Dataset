import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		for(int k=0; k<tc; k++){
			int meetings=sc.nextInt();
			int[][] timings = new int[meetings][2];
			int min=1440, max=0;
			for(int i=0; i<meetings; i++)
				for(int j=0; j<2; j++){
					timings[i][j]=sc.nextInt();
					if(timings[i][j]<min)
						min=timings[i][j];
					if(timings[i][j]>max)
						max=timings[i][j];
					
				}
			fixAppointment(timings,meetings,min, max, k+1);
		}
	}

	private static void fixAppointment(int[][] timings, int meetings, int min, int max, int k) {
		// TODO Auto-generated method stub
		//System.out.println(min+" "+max);
		Calendar C = new Calendar(min, max);
		Calendar J = new Calendar(min, max);
		StringBuilder build = new StringBuilder();
		boolean notpossible=false;
		for(int i=0; i<meetings && notpossible==false; i++){
				int starttime=timings[i][0];
				int endtime=timings[i][1];
				boolean check=false;
				check=C.checkAvailability(starttime, endtime);
				if(check){
					C=C.bookAppointment(starttime, endtime, C);
					build.append("C");
				}
				else{
					check=J.checkAvailability(starttime, endtime);
					if(check){
						J=J.bookAppointment(starttime, endtime, J);
						build.append("J");
					}
					else
						notpossible=true;
				}
			}
		if(notpossible)
			System.out.println("Case #"+k+": IMPOSSIBLE");
		else
			System.out.println("Case #"+k+": "+build);
	}

}
class Calendar{
	Map<Integer,Boolean> hashmap = new HashMap<Integer,Boolean>();
	public Calendar(int min, int max) {
		// TODO Auto-generated constructor stub
		for(int i=min; i<=max; i++){
			hashmap.put(i, true);
		}
	}
	public Calendar bookAppointment(int starttime, int endtime, Calendar c) {
		// TODO Auto-generated method stub
		for(int i=starttime;i<endtime; i++){
			c.hashmap.replace(i, false);
		}
		return c;
	}
	public boolean checkAvailability(int starttime, int endtime) {
		// TODO Auto-generated method stub
		boolean check=true;
		for(int i=starttime;i<endtime && check==true; i++){
			if(!hashmap.get(i))
				check=false;
		}
		
		return check;
	}
	
}
