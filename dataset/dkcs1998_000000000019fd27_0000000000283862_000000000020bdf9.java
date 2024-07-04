import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 * @author User
 */
public class Solution
{
    static class FastReader {
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
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

    static class Job {

        int val,b;

        Job(int x, int y) {
            val = x;
            b = y;
        }
        public String toString()
        {
            if(this.b==0)
                return "Starting job at "+this.val;
            else                
                return "Ending job at "+this.val;
        }
    }
    
    static class Comp implements Comparator<Job> {

        public int compare(Job o1, Job o2) {
            if (o1.val > o2.val) {
                return 1;
            }
            else if(o1.val<o2.val)
                return -1;
            else
            {
                if(o1.b<o2.b)
                    return 1;
                else
                    return -1;
            }
        }
    }
    
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int kt=1;
        while(kt<=t)
        {
            HashMap<Integer,Integer> se=new HashMap();
            HashMap<Integer,Integer> id=new HashMap();
            PriorityQueue<Job> pq=new PriorityQueue(new Comp());            
            int n=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                pq.add(new Job(a,0));
                pq.add(new Job(b,1));                
                se.put(a,b);
                id.put(a,i);
            }
            HashMap<Integer,Integer> hm=new HashMap();
            int work[]=new int[2];
            StringBuffer ans=new StringBuffer();
            char ch[]={'C','J'};
            int flag=0;
            char ans2[]=new char[n];
            
            while(!pq.isEmpty())
            {
                Job job=pq.poll();
//                System.out.println(hm);
//                System.out.println(Arrays.toString(work));
//                System.out.println(job);
                int l=-1;
                if(job.b==1)
                {
                    if(hm.containsKey((Integer)job.val))
                    {
                        //System.out.println("nfnnfnfnfn");
                        l=hm.get(job.val);
                        //System.out.println("l="+l);
                        work[l]=0;
                        hm.remove(new Integer(job.val));
                    }
                    
                }
                else
                {
                    if(work[0]==0)
                    {
                        ans.append(ch[0]);
                        ans2[id.get(job.val)]=ch[0];
                        hm.put(se.get(job.val), 0);
                        work[0]=1;
                    }
                    else if(work[1]==0)
                    {
                        ans.append(ch[1]);
                        ans2[id.get(job.val)]=ch[1];
                        hm.put(se.get(job.val), 1);
                        work[1]=1;
                    }
                    else
                    {
                       flag=-1;
                       break;
                    }
                    
                }
            }
            if(flag==-1)
                System.out.println("Case #"+kt+": IMPOSSIBLE");
            else
                System.out.println("Case #"+kt+": "+new String(ans2));
            ++kt;
        }
    }
    
}
