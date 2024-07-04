import java.util.*;

class Interval{
    int start;
    int end;
    Interval(int start,int end){
        this.start = start;
        this.end = end;
    }
}

public class Solution{
    
    public static boolean overlap(Interval i1,Interval i2){
        if(i1.start>i2.start&&i1.start<i2.end){
            return true;
        }
        if(i2.start>i1.start&&i2.start<i1.end){
            return true;
        }
        return false;
    }
    
    public static boolean check(ArrayList<Interval> list,Interval in){
        if(list.isEmpty()){
            return true;
        }
        boolean check = false;
        for(int i=0;i<list.size();i++){
            if(!overlap(list.get(i),in)){
                check = true;
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
            String output = "";
            for(int i=0;i<n;i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                Interval in = new Interval(start,end);
                boolean checkCarry = check(carry,in);
                if(checkCarry){
                    output+="C";
                    carry.add(in);
                }else{
                    boolean checkJames = check(james,in);
                    if(checkJames){
                        output+="J";
                        james.add(in);
                    }else{
                        flag = false;
                    }
                }
            }
            
            if(flag){
                System.out.println("Case #"+c+": "+output);
            }else{
                System.out.println("Case #"+c+": IMPOSSIBLE");
            }
            c++;
        }
    }
}