import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    //String s = in.nextLine();
    for (int t = 1; t <= T; ++t) {
        int N = in.nextInt();
        
        //int[] start = new int[N];
       
        
        SortedMap<Integer, Integer> start = new TreeMap<Integer,Integer>();
         int[] end = new int[N];
        //Set<Integer> end = new TreeSet<Integer>();
        
        // collect the start and end times for each case
        for(int i = 0; i < N; i++) {
            //start[i] = in.nextInt();
            //end[i] = in.nextInt();
            start.put(in.nextInt(),i);
            end[i] = in.nextInt();
        }
        
        
        /*for(int t = 0; t < 24*60; t++) {
            
            
            
            isStart = contains
            
            
        }*/
        
        //Set<Integer> keys = start.keySet();
        //Iterator key = keys.iterator();
        
        Iterator key = start.keySet().iterator();
        
        int jInd = -1;
        int cInd = -1;
        
        boolean jBusy = false;
        boolean cBusy = false;
        
        StringBuilder sb = new StringBuilder();
        
        int impos = 0;
    
        
        int i = -1;
        
        //for(int i = 0; i < N; i++) {
        while(key.hasNext()) {  
            
            i++;
            
            //??????
            int nextStart = (int)key.next();
            
            if(jBusy && jInd != -1 && end[jInd] <= nextStart) {
                
                // no longer busy
                jInd = -1;
                jBusy = false;
                
            }
            
            if(cBusy && cInd != -1 && end[cInd] <= nextStart) {
                // no longer busy
                cInd = -1;
                cBusy = false;
                
            }
            
            // if both are busy with the next allocation, it's impossible
            if(cBusy && jBusy) {
                impos = 1;
                
                break;
                
            }
            
            int ind = start.get(nextStart);
            //write code for allocating j or c
            if(!jBusy) {
                
                sb.append('J');
                
                jBusy = true;
                jInd = ind;
                
            }
            else if(!cBusy) {
                
                sb.append('C');
                
                cBusy = true;
                cInd = ind;
                
            }
            
            
        }
        
        String res = "";
        
        if(impos == 1) {
            
            res = "IMPOSSIBLE";
            
        } else{
            
            res = sb.toString();
            
        }
        
        
        System.out.println("Case #" + t + ": " + res);
    }
  }
}