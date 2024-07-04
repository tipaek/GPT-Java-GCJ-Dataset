
import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    
    static class ActivityInterval{
        int start;
        int end;
        int index;
        
        ActivityInterval(int start,int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
    
    static class compareByStart implements Comparator<ActivityInterval>{
        
        public int compare(ActivityInterval i1,ActivityInterval i2){
            return (i1.start - i2.start);
        }
    }
    
    static class FastReader{
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong()
        {
           return Long.parseLong(next());
        }
        
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
         
       String nextLine()
       {
           String str = "";
           try
           {
               str = br.readLine();
           }
           catch (IOException e)
           {
               e.printStackTrace();
           }
           return str;
       }

    }

  public static void main(String[] args) {
   
    FastReader fastRead = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
      
    int t = fastRead.nextInt();
    int caseNum = 0;
      
    while (t-- > 0) {
        
        int n = fastRead.nextInt();
        
        ArrayList <ActivityInterval> intervals = new ArrayList <ActivityInterval>();
        
        for(int i=0;i<n;i++){
            
            int start = fastRead.nextInt();
            int end = fastRead.nextInt();
            
            ActivityInterval interval = new ActivityInterval(start,end,i);
            intervals.add(interval);
        }
        
        Collections.sort(intervals,new compareByStart());
        
        int jayden = -1;
        int cameron = -1;
        
        //char [] intervalOwner = new char[1005];
        
        int [] intervalOwner = new int[1005];
        
        //Arrays.fill(intervalOwner);
        
        boolean possible = true;
        
        for(int i=0;i<intervals.size();i++){
            
            ActivityInterval interval = intervals.get(i);
            int start = interval.start;
            
            if(jayden <=start){
                jayden = interval.end;
                intervalOwner[interval.index] = 0;
            }
            else if(cameron <= start){
                cameron = interval.end;
                intervalOwner[interval.index] = 1;
            }
            else{
                possible = false;
                break;
            }
        }
        
        caseNum++;
        
        if(possible){
            String output = new String();
            
            for(int i=0;i<n;i++){
                
                String str = "J";
                
                if(intervalOwner[i] == 1){
                    str = "C";
                }
                
                output = output.concat(str);
            }
            
            out.println("Case #"+caseNum+": "+output);
        }
        else{
            out.println("Case #"+caseNum+": "+"IMPOSSIBLE");
        }
 
   }
      
    out.close();
  }
}
