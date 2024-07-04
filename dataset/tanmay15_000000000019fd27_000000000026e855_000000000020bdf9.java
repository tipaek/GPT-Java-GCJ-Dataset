
/**
 *
 * @author Tanmay Deshpande (KIT College Of Engineering, Kolhapur)
 */
import java.io.*;
import java.util.*;

class Temp{
    public int start;
    public int end;
    public int duration;
    public int job;
    public int index;
    
}

class SortbyDuration implements Comparator<Temp> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Temp a, Temp b) 
    { 
        return b.duration - a.duration; 
    } 
} 

class SortbyIndex implements Comparator<Temp> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Temp a, Temp b) 
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
            ArrayList<Temp> arr = new ArrayList<Temp>();
            
            for(int i = 0; i<N; i++)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                
                Temp t = new Temp();
                t.start = s;
                t.end = e;
                t.duration = e - s;
                t.job = 99;
                t.index = i;
                
                arr.add(t);
            }
            Collections.sort(arr, new SortbyDuration()); 
            boolean jamie[] = new boolean[1500];
            boolean cameron[] = new boolean[1500];
            boolean impossible = false;
            
            for(int i = 0; i< arr.size();i++)
            {
                Temp t = arr.get(i);
                
                if(cameron[t.start] == false && cameron[t.end-1] == false){
                    for(int j = t.start; j < t.end; j++)
                    {
                        cameron[j] = true;
                    }
                    t.job = 0;
                }
                else if(jamie[t.start] == false && jamie[t.end-1] == false)
                {
                    for(int j = t.start; j < t.end; j++)
                    {
                        jamie[j] = true;
                    }
                    t.job = 1;
                }
                else
                {
                    impossible = true;
                    break;
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
                    Temp t = arr.get(i);
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
            pw.println();
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
