
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *
 * @author DPC
 */

class Interval{
    int ind;
    int start;
    int end;
    public Interval(int ind,int s,int e){
       this.ind = ind;
       this.start = s;
       this.end = e;
    }
}

class IComparator implements Comparator<Interval>{

    @Override
    public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
    }
}


public class Solution {
    
    
    public static void main(String a[]) throws IOException{
        
        doIt();
    }

    private static void doIt() throws IOException {
        BufferedReader in = new BufferedReader( new  InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());
        int nTc = Integer.parseInt(stk.nextToken());
        for(int tc=1;tc<=nTc;tc++){
            executeOneTc(tc,in);
        }
    }
    
    

    private static void executeOneTc(int caseNo,BufferedReader in) throws IOException {
        
        StringTokenizer stk = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(stk.nextToken());
        Interval[]  ints = new Interval[n];
        
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            ints[i] = new Interval(i, s, e);
        }
        
        Arrays.sort(ints,new IComparator());
        
        char rslt[] = new char[n];
        int cFree = -1;
        int jFree = -1;
        
        for(int i=0;i<n;i++){
            int start = ints[i].start;
            if(start<cFree && start<jFree){
                System.out.println("Case #"+caseNo+": IMPOSSIBLE");
                return;
            }
            
            if(cFree<=start){
                rslt[ints[i].ind] = 'C';
                cFree = ints[i].end;
            } else {
                rslt[ints[i].ind] = 'J';
                jFree = ints[i].end;
            }
        }

        System.out.println("Case #"+caseNo+": "+new String(rslt));
    }
    
    
}
