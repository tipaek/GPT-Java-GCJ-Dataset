import java.util.*;
import java.lang.*; 
import java.io.*; 

class Interval{
    int start;
    int end;
    Interval(int start,int end){
        this.start = start;
        this.end = end;
    }
}

class SortByStart implements Comparator<Interval>{
    public int compare(Interval a,Interval b){
        return a.start-b.start;
    }
}

public class Solution{
    
    public static boolean overlap(Interval i1,Interval i2){
        if (i1.start == i2.start && i1.end == i2.end) {
            return true;
        }
        if(i1.start>i2.start&&i1.start<i2.end){
            return true;
        }
        if(i2.start>i1.start&&i2.start<i1.end){
            return true;
        }
        return false;
    }
    
    public static boolean check(ArrayList<Interval> list, Interval in) {
        if (list.isEmpty()) {
            return true;
        }
        boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            if (overlap(list.get(i), in)) {
                check = false;
                break;
            }
        }
        return check;
    }
    
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 1;
        while(c<=t){
            ArrayList<Interval> carry = new ArrayList<>();
            ArrayList<Interval> james = new ArrayList<>();
            boolean flag = true;
            
            int n = sc.nextInt();
            
            ArrayList<Interval> intervals = new ArrayList<>();
            ArrayList<Interval> orignals = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                Interval in = new Interval(start,end);
                intervals.add(in);
                orignals.add(in);
            }
            
            Collections.sort(intervals, new SortByStart());
            
            HashMap<Interval,Character> map = new HashMap<>();
            
            for(int i=0;i<n;i++){
                Interval in = intervals.get(i);
                boolean checkCarry = check(carry,in);
                if(checkCarry){
                    map.put(in,'C');
                    carry.add(in);
                }else{
                    boolean checkJames = check(james,in);
                    if(checkJames){
                        map.put(in,'J');
                        james.add(in);
                    }else{
                        flag = false;
                    }
                }
            }
            
            if(!flag){
                System.out.println("Case #"+c+": IMPOSSIBLE");
            }else{
                String output = "";
                for(int i=0;i<n;i++){
                    output += map.get(orignals.get(i));
                }
                System.out.println("Case #"+c+": "+output);
            }
            c++;
        }
    }
}