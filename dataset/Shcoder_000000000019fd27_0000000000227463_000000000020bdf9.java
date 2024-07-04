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
        
    Arrays.sort(intervals,new Comparator<Interval>(){
    	public int compare(Interval a,Interval b){
    		return a.start-b.start;
    	}	
    });
        
        Stack<Interval> cst=new Stack<Interval>();
        Stack<Interval> jst=new Stack<Interval>();
        
        String res="";
        
        for(Interval i:intervals){
            if(cst.isEmpty() || i.start>=cst.peek().end){
                res+="C";
                cst.push(i);
            }else if(jst.isEmpty() ||i.start>=jst.peek().end){
                res+="J";
                jst.push(i);
            }else{
                return "IMPOSSIBLE";
            }
        }
        return res;
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