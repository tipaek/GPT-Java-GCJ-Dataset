
/**
 *
 * @author Tanmay Deshpande (KIT College Of Engineering, Kolhapur)
 */
import java.io.*;
import java.util.*;

class Activity{
    public int start;
    public int end;
    public int job;
    public int index;
    
}

class SortbyEnd implements Comparator<Activity> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Activity a, Activity b) 
    { 
        return b.end - a.end; 
    } 
} 

class SortbyIndex implements Comparator<Activity> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Activity a, Activity b) 
    { 
        return a.index - b.index; 
    } 
} 
  

public class Solution
{
    public static void main(String ar[]) throws Throwable
    {
        int T,z;
        MyScanner sc = new MyScanner(); 	// use it just like normal scanner object.
        PrintWriter pw = new PrintWriter(System.out);  //use it as pw.print() or pw.println();
        
        T=sc.nextInt();

        for(z=0;z<T;z++)
        {
            int N = sc.nextInt();
            ArrayList<Activity> arr = new ArrayList<Activity>();
            
            for(int i = 0; i<N; i++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                
                Activity t = new Activity();
                t.start = s;
                t.end = e;
                t.job = 99;
                t.index = i;
                
                arr.add(t);
            }
            Collections.sort(arr, new SortbyEnd()); 
            
            String answer="";
            boolean impossible = false;
            int jamieFront=9999;
            int camFront=9999;
            
            for(int i = 0; i< arr.size();i++)
            {
                Activity t = arr.get(i);
               
                int endTime = t.end;
                
                if(endTime<=camFront)
                {
                   t.job=0;
                   camFront = t.start;
                }
                else if(endTime<=jamieFront)
                {
                    t.job=1;
                    jamieFront = t.start;
                }
                else
                {
                    impossible = true;
                }
            }    
                
            pw.print("Case #"+(z+1)+": ");
            if(impossible)
            {
                pw.print("IMPOSSIBLE");
            }
            else{
                Collections.sort(arr, new SortbyIndex()); 
                for(int  i = 0; i< arr.size();i++)
                {
                    Activity t = arr.get(i);
                    if(t.job == 0)
                    {
                        pw.print("C");
                    }
                    else
                    {
                        pw.print("J");
                    }
                }
            }
            pw.print("\n");
            pw.flush();
            
            
            

        } //T
        

    }
    
    // Fast input output stuff
    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
