

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{

    


    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int t =sc.nextInt();


        for(int k=0;k<t;k++){

            int n = sc.nextInt();

            ArrayList<Interval> list = new ArrayList<Interval>();

            for(int i=0;i<n;i++){
                int st = sc.nextInt();
                int en = sc.nextInt();

                Interval intervl = new Interval(st,en);

                list.add(intervl);

            }
            String output="";

            Set<Interval> setA = new HashSet<Interval>();
            Set<Interval> setB = new HashSet<Interval>();

            setA.add(list.get(0));
            boolean flag = true;


            for ( int i=1; i<n; i++ ) {
                Interval val = list.get(i);

                if (checkOverlapSet(setA,val)) {

                    if (checkOverlapSet(setB,val)) {
                        flag = false;
                        break;
                    } else {
                        setB.add(val);
                    }
                }
                else{
                    setA.add(val);
                }
            }

            if(flag) {
                for(int i=0;i<n;i++){
                    if(setA.contains(list.get(i))){
                        output+="C";
                    }else if (setB.contains(list.get(i))){
                        output+="J";
                    }
                    else {

                        output="IMPOSSIBLE";
                        break;
                    }
                }
            }
            else{
                output= "IMPOSSIBLE";
            }

            System.out.println("Case #" +(k+1) +": "+output);
        }


        
        

        
    }

    public static boolean checkOverlapSet( Set<Interval> set, Interval val) {

        if ( set.isEmpty() )return false;

        for(Interval checkInterval: set) {

            if(checkInterval.checkOverlap(val))return true;

        }

        return false;
    }

    

}

class Interval {
    public int start;
    public int end;



    public Interval(int start, int end){
        this.start= start;
        this.end = end;
    }


    public boolean checkOverlap(Interval a) {
        if(a.start > this.start && a.start<this.end)return true;
        if(a.end > this.start && a.end<this.end)return true;


        if(a.start < this.start && this.start <a.end)return true;
        if(this.end > a.start && this.end<a.end)return true;

        if(a.start==this.start && a.end==this.end)return true;
        return false;
    }
}



