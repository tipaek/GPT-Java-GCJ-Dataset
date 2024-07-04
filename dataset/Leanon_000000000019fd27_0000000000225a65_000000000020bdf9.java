import java.util.*;
class Activity implements Comparable<Activity>{
	int start,end,i;
	public Activity(int start,int end,int i) {
		this.start=start;
		this.end=end;
		this.i=i;
	}
	@Override
	public int compareTo(Activity o) {
		
		return this.start-o.start;
	}
}
public class Solution{
  public static void main (String [] args){
    Scanner c = new Scanner(System.in);
    int t = c.nextInt();
    int cnt=1;
    while (t>0){
    	boolean f = true;
        int n = c.nextInt();
        System.out.print("Case #"+cnt+": ");
        Activity[] acts = new Activity[n];
        for (int i=0;i<n;i++) {
        	acts[i]=new Activity(c.nextInt(),c.nextInt(),i);
        }
        Arrays.sort(acts);
        int finish1=0,finish2=0;
        int num=0;
        char[] assignments = new char[n];
        for (int i=0;i<n;i++) {
        	if (num==0) {
        		num++;
        		finish1=acts[i].end;
        		assignments[acts[i].i]='C';
        	}
        	else if (num==1) {
        		if(acts[i].start>=finish1) {
        			finish1=acts[i].end;
        			assignments[acts[i].i]='C';
        		}
        		else {
        			num++;
        			finish2=acts[i].end;
        			assignments[acts[i].i]='J';
        		}
        		
        	}
        	else if (num==2) {
        		if (acts[i].start>=finish1) {
        			finish1=acts[i].end;
        			assignments[acts[i].i]='C';
        			if (finish1>=finish2) {
        				num--;
        			}
        		}
        		else if (acts[i].start>=finish2) {
        			finish2=acts[i].end;
        			assignments[acts[i].i]='J';
        		}
        		else {
        			System.out.println("IMPOSSIBLE");
        			f=false;
        			break;
        		}
        	}
        }
        if (f) {
            for (int i=0;i<assignments.length;i++) {
            	System.out.print(assignments[i]);
            }
            System.out.println();
        }

        cnt++;t--;
    }
  }

}