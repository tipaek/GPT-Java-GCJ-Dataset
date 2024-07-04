
import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    
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
    
    public static class Point{
        int x;
        int y;
        
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static class SequenceFinder{
        
        Point start;
        Point end;
        int minLength;
        ArrayList<Character> minSequence;
        int [] ar;
        
        SequenceFinder(Point p){
            start = new Point(0,0);
            end = p;
            minLength = Integer.MAX_VALUE;
            minSequence = new ArrayList<Character>();
            
            ar = new int[31];
                 
             ar[0] = 1;
           
             for(int i=1;i<31;i++){
                 ar[i] = ar[i-1]*2;
             }
        }
        
        void findSequence(ArrayList<Character> currentSequence,Point currentPoint,int index){
            
            
            if(currentPoint.x == end.x && currentPoint.y == end.y){
                
                if(currentSequence.size() < minLength){
                    minLength = currentSequence.size();
                    minSequence = new ArrayList<Character>(currentSequence);
                    
                    
                }
                
                return;
            }
            
            if(index > 8){
                return;
            }
            
            Point originalPoint = new Point(currentPoint.x,currentPoint.y);
            
            currentSequence.add('N');
            currentPoint.y += ar[index];
            findSequence(currentSequence,currentPoint,index+1);
            
            currentSequence.remove(currentSequence.size()-1);
            currentPoint = new Point(originalPoint.x,originalPoint.y);
            
            currentSequence.add('S');
            currentPoint.y -= ar[index];
            findSequence(currentSequence,currentPoint,index+1);
            
            currentSequence.remove(currentSequence.size()-1);
            currentPoint = new Point(originalPoint.x,originalPoint.y);
            
            currentSequence.add('E');
            currentPoint.x += ar[index];
            findSequence(currentSequence,currentPoint,index+1);
            
            currentSequence.remove(currentSequence.size()-1);
            currentPoint = new Point(originalPoint.x,originalPoint.y);
            
            currentSequence.add('W');
            currentPoint.x -= ar[index];
            findSequence(currentSequence,currentPoint,index+1);
            
            currentSequence.remove(currentSequence.size()-1);
            currentPoint = new Point(originalPoint.x,originalPoint.y);
        }
        
    }

    
  public static void main(String[] args) {
   
    FastReader fastRead = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    int t = fastRead.nextInt();
    int caseNum = 0;
      
    while (t-- > 0) {
        
        int x = fastRead.nextInt();
        int y = fastRead.nextInt();
        
        Point p = new Point(x,y);
        
        SequenceFinder sf = new SequenceFinder(p);
        sf.findSequence(new ArrayList<Character>(),new Point(0,0),0);
        
        caseNum++;
        
        if(sf.minLength == Integer.MAX_VALUE){
             out.println("Case #"+caseNum+": IMPOSSIBLE");
        }
        else{
            
            ArrayList<Character> listCh = sf.minSequence;
            
            StringBuilder sb = new StringBuilder();
            
                  // Appends characters one by one
                  for (Character ch : listCh) {
                      sb.append(ch);
                  }
            
                  // convert in string
                  String string = sb.toString();
            
            out.println("Case #"+caseNum+": "+string);
        }
        
      
    }
    
      out.close();
  }
}
