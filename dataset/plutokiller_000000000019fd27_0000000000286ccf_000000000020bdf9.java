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
        
        int impos = 0;
        
        SortedMap<Integer, Integer> start = new TreeMap<Integer,Integer>();
        int[] end = new int[N];
        //Set<Integer> start = new TreeSet<Integer>();
        int[] sortedStart = new int[N];
        int[] sortedInd = new int[N];
        int[] startNew = new int[N];
        int[] indNew = new int[N];
        
        // collect the start and end times for each case
        for(int i = 0; i < N; i++) {
            
            int inn = in.nextInt();

            startNew[i] = inn;
            indNew[i] = i;
            end[i] = in.nextInt();
        }
        
        // sort the list 
        for(int i = 0; i < N; i++) {
            int less = 1500;
            int lessInd = -1;
            for(int j = 0; j < N; j++) {
                
                if(startNew[j] < less) {
                    
                    less = startNew[j];
                    lessInd = j;
                    
                }
                
            }
            sortedStart[i] = less;
            sortedInd[i] = lessInd;
            startNew[lessInd] = 1500;
            
        }
        
        // we now have sorted start times in SortedStart
        
        char[] chars = new char[N];
        
        //Iterator key = start.keySet().iterator();
        
        int jInd = -1;
        int cInd = -1;
        
        boolean jBusy = false;
        boolean cBusy = false;
        
        StringBuilder sb = new StringBuilder();
    
        //int i = -1;
        
        //for(int i = 0; i < N; i++) {
        for(int i = 0; i < N; i++) {  
            
            //i++;
            
            //??????
            //int nextStart = (int)key.next();
            int nextStart = sortedStart[i];
            
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
            
            //int ind = start.get(nextStart);
            int ind = sortedInd[i];
            //write code for allocating j or c
            if(!jBusy) {
                
                //sb.append('J');
                chars[ind] = 'J';
                jBusy = true;
                jInd = ind;
                
            }
            else if(!cBusy) {
                
                //sb.append('C');
                chars[ind] = 'C';
                cBusy = true;
                cInd = ind;
                
            } else {
                
                impos = 1;
                
                break;
                
            }
            
            
        }
        
        String res = "";
        
        if(impos == 1) {
            
            res = "IMPOSSIBLE";
            
        } else{
            
            //res = sb.toString();
            res = new String(chars);
        }
        
        
        System.out.println("Case #" + t + ": " + res);
    }
  }
}