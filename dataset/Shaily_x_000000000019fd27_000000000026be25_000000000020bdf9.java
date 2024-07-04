import java.util.*;
import java.io.*;

class Activity implements Comparable<Activity>{
    int start,end,idx;
    
    Activity(int idx,int start,int end){
    	this.idx=idx;
        this.start=start;
        this.end=end;
    }
    
    public int compareTo(Activity p1){
    	return this.end-p1.end;
    }
}

public class Solution 
{
    public static void main (String[] args) 
    {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        //System.out.println(open+" "+close+" "+add);
        for (int i = 1; i <= t; ++i) {
        	int n = in.nextInt();
        	String ans= "";
        	Activity[] act = new Activity[n];
        	for(int j=0;j<n;j++){
        		int start = in.nextInt();
        		int end = in.nextInt();
        		act[j]=new Activity(j,start,end);
        	}
        	
        	Arrays.sort(act);
        	
        	char[] answer = new char[n];
        	answer[act[0].idx]='C';
        	int Cend=act[0].end;
        	int Jend=0;
        	int acts=1;
        	for(int j=1;j<n;j++){
        		if(act[j].start>=Cend){
        			answer[act[j].idx]='C';
        			Cend=act[j].end;
        			acts++;
        		}
        		else if(act[j].start>=Jend){
        			answer[act[j].idx]='J';
        			Jend=act[j].end;
        			acts++;
        		}
        		else{
        			break;
        		}
        	}
        	
        	if(acts!=n){
        		System.out.println("Case #"+i+": Impossible");
        	}
        	else{
        		for(int j=0;j<n;j++){
        			ans=ans+answer[j];
        		}
        		System.out.println("Case #"+i+": "+ans);
        	}
        
        }
	}
    
}