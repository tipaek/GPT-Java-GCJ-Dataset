import java.util.*;
import java.io.*;

class Time{
	int startTime;
	int endTime;
	
	public Time(int s, int e){
		startTime = s;
		endTime = e;
	}
}

public class Solution {
	
	public static boolean overlap(Time t1, Time t2){
		if (t1.startTime<=t2.startTime && t1.endTime>t2.startTime) return true;
	    if (t1.startTime<t2.endTime && t1.endTime>=t2.endTime) return true;
	    if (t1.startTime>=t2.startTime && t1.endTime<=t2.endTime) return true;
	    return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		boolean ret;
		ArrayList<Time> csec = new ArrayList<Time>();
		ArrayList<Time> jsec = new ArrayList<Time>();
		
		for(int i = 0; i < t; i++){
			int n = in.nextInt();
			String r = "";
			for(int j = 0; j < n; j++){
				Time a = new Time(in.nextInt(),in.nextInt());
				if(j == 0){
					csec.add(a);
					r += "C";
				}else{
					ret = true;
					for(int k = 0; k < csec.size(); k++){
						if(overlap(a,csec.get(k))){
							ret = false;
							break;
						}
					}
					if(ret){
						csec.add(a);
						r += "C";
						continue;
					}
					ret = true;
					for(int k = 0; k < jsec.size(); k++){
						if(overlap(a,jsec.get(k))){
							ret = false;
							break;
						}
					}
					if(ret){
						jsec.add(a);
						r += "J";
					}else{
						r = "IMPOSSIBLE";
						break;
					}
				}
			}
			System.out.printf("Case #%d: %s\n",i+1,r);
			csec.clear();
			jsec.clear();
		}
	}

}
