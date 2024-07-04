import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;

public class Solution {
    Scanner in;
    int cases;
    
    
    public Solution(){
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= cases; cases++) {
            int acts=in.nextInt();
            Activity[] actList= new Activity[acts];
            for(int e=0;e<=acts;e++){
                actList[e]=new Activity(in.nextInt(),in.nextInt());
            }
            actList=sortActList(actList);
            String solution=new String();
            int ftC=0;
            int ftJ=0;
            boolean failed=false;
            for(int e=0;e<=acts;e++){
                if(actList[e].start>=ftC){
                    ftC=actList[e].end;
                    solution=solution+'C';
                }
                else if(actList[e].start>=ftJ){
                    ftJ=actList[e].end;
                    solution=solution+'J';
                }
                else{
                    failed=true;
                }
                
            }
            if(failed)solution="IMPOSSIBLE";
            
            
            System.out.println("Case #" + i + ": " + solution);
        }
        
    }
    
    public Activity[] sortActList(Activity[] actList){
        Activity[] k=new Activity[actList.length];
        int[]starts=new int[actList.length];
        for(int i=0;i<actList.length;i++){
            starts[i]=actList[i].start;
        }
        Arrays.sort(starts);
        for(int i=0;i<actList.length;i++){
            for(Activity a:actList){
                if(a!=null&&a.start==starts[i]){
                    k[i]=a;
                    actList=ArrayUtils.removeElement(actList, a);
                }
            }
        }
        return k;
    }
    
    public static void main(String[] args) {
        Solution s=new Solution();
    }
    
    class Activity{
        public int start;
        public int end;
        public Activity(int s,int e){
            start=s;
            end=e;
        }
    }
}