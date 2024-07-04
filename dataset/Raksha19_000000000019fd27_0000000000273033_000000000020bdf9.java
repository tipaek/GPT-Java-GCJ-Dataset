import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    static class Activity {
		int start;
		int end;
		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T=sc.nextInt();
		for(int i=0;i<T;i++){
			int n=sc.nextInt();
			HashSet<Activity> CSet=new HashSet<>();
			HashSet<Activity> JSet=new HashSet<>();
			String result="";
			int start,end;
			for(int j=0;j<n;j++){
				start=sc.nextInt();
				end=sc.nextInt();
				Activity current=new Activity(start,end);
				if(isValid(CSet,current)){
					result+='C';
					CSet.add(current);
				}
				else if(isValid(JSet,current)){
					result+='J';
					JSet.add(current);
				}
				else{
					result="IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #"+(i+1)+":"+result);
		}
			
	}
	private static boolean isValid(HashSet<Activity> hs,Activity current){
		Iterator<Activity> it=hs.iterator();
		while(it.hasNext()){
		    Activity temp=it.next();
		    if (current.start<=temp.start && current.end>temp.start) return false;
            if (current.start<temp.end && current.end>=temp.end) return false;
            if (current.start>=temp.start && current.end<=temp.end) return false;
		}
		return true;	
	}
}