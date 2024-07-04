
/**
 *
 * @author Tanmay Deshpande (KIT College Of Engineering, Kolhapur)
 */
import java.io.*;
import java.util.*;

class Activity{
    public int start;
    public int end;
    
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
                
               Activity a = new Activity();
               a.start = s;
               a.end = e;
               arr.add(a);
            }
            
            boolean jamie[] = new boolean[1500];
            boolean cameron[] = new boolean[1500];
            
            for(int i=0; i<1500;i++)
            {
                jamie[i] = false;
                cameron[i] = false;
            }
            
            boolean impossible = false;
            String answer="";
            
            for(int i = 0; i<N;i++)
            {
                Activity a = arr.get(i);
                boolean flag=false;
                boolean check = false;
                for(int j = a.start; j<a.end;j++)
                {
                    if(cameron[j]==true)
                    {    
                        flag = true;
                        break;
                    }
                }
                if(flag==false)
                {
                    for(int j = a.start; j<a.end;j++)
                    {
                        cameron[j] = true;
                    }
                    answer = answer+"C";
                }
                else if(flag==true)
                {
                    for(int j = a.start; j<a.end;j++)
                    {
                        if(jamie[j]==true)
                        {    
                            check = true;
                            break;
                        }
                    }
                    if(check==false)
                    {
                        answer = answer+"J";
                        for(int j = a.start; j<a.end;j++)
                        {
                            jamie[j] = true;
                        }
                    }
                }
                if(flag && check)
                {
                    impossible = true;
                    break;
                }
                
               
                
            }//for
            
            
            
            
            System.out.print("case #"+(z+1)+": ");
            if(impossible)
            {
                System.out.print("IMPOSSIBLE");
            }
            else{
                System.out.print(answer);
            }
            System.out.print("\n");
            
           
          
            

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
