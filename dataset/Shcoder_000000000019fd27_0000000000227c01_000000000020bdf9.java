import java.util.*;
import java.io.*;
import java.lang.*;

class Interval{
    int start,end;
    Interval(int s,int e){
        start=s;
        end=e;
    }
}

public class Solution{
    
    public static String sol(Interval[] intervals){
        
               
        Map<String,Integer> map=new HashMap<String,Integer>();
        
        for(int i=0;i<intervals.length;i++){
            String key=intervals[i].start+"-"+intervals[i].end;
            map.put(key,i);
        }
        
    Arrays.sort(intervals,new Comparator<Interval>(){
 
        
    	public int compare(Interval a,Interval b){
    		return a.start-b.start;
    	}	
    });
        
        Stack<Interval> cst=new Stack<Interval>();
        Stack<Interval> jst=new Stack<Interval>();
        
        
        
        char[] res=new char[intervals.length];
        
        for(Interval i:intervals){
            if(cst.isEmpty() || i.start>=cst.peek().end){
                String key=i.start+"-"+i.end;
                res[map.get(key)]='C';
                //res+="C";
                cst.push(i);
            }else if(jst.isEmpty() ||i.start>=jst.peek().end){
                String key=i.start+"-"+i.end;
                 res[map.get(key)]='J';
                jst.push(i);
            }else{
                return "IMPOSSIBLE";
            }
        }
        return new String(res);
    }
    
    public static void main(String[] args){
         Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
        in.nextLine();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            in.nextLine();
            Interval[] intervals=new Interval[n];
            for(int j=0;j<n;j++){
                int st=in.nextInt();
                int e=in.nextInt();
                intervals[j]=new Interval(st,e);
                in.nextLine();
                
            }
            System.out.println("Case #"+(i+1)+": "+sol(intervals));
        }
    }
}