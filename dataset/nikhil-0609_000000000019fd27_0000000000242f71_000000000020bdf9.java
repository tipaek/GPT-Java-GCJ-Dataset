import java.util.*;
import java.lang.*;
import java.io.*;

class jobs {
    int si;
    int ei;
    int index;
    public jobs(int si, int ei, int index) {
        this.si = si;
        this.ei = ei;
        this.index = index;
    }
}
class Solution
{
	public static void main (String[] args)	throws java.lang.Exception{
		FastReader sc = new FastReader();
		int t = sc.nextInt();
        int c = 1;
		while(c <= t) {
		    int n = sc.nextInt();
            ArrayList<jobs> al = new ArrayList<jobs>(n);
            for(int i = 0; i<n; i++) {
                int si = sc.nextInt();
                int ei = sc.nextInt();
                jobs ob = new jobs(si, ei, i);
                al.add(ob);
            }
            //sort the jobs according to their start time.
            Collections.sort(al, new Comparator<jobs> () {
                public int compare(jobs j1, jobs j2) {
                    if(j1.si > j2.si) {
                        return 1;
                    }
                    return -1;
                }
            });
            int check = 0;
            int c_end = 0, j_end = 0;
            String ans[] = new String[n];
        // assign the first job to "C".

            c_end = al.get(0).ei;
            ans[al.get(0).index] = "C";

            for(int i = 1; i<n; i++) {
                int st = al.get(i).si;
                if(st < c_end) {
                    //this job can't be added to the list of jobs done by "C";
                    if(st < j_end) {
                        //this job can't be added to the list of jobs done by "J" too;
                        // therefore we found a conflicting job. thus answer should be "IMPOSSIBLE".
                        System.out.println("Case #"+c+": IMPOSSIBLE");
                        check = -1;
                        break;
                    }else {
                        //this means current job conflicts with "C" but not with "J".
                        //therefore add this job to "J" list.
                        ans[al.get(i).index] = "J";
                        int et = al.get(i).ei;
                        j_end = et;
                    }
                }else {
                    //this means this job can be added to "C" list.
                    ans[al.get(i).index] = "C";
                    c_end = al.get(i).ei;
                }
            }
            if(check == -1){
                c++;
                continue;
            }
            StringBuilder sb = new StringBuilder(n);
            for(int i = 0; i<n; i++) {
                sb.append(ans[i]);
            }
            System.out.println("Case #"+c+": "+sb);
            c++;
		}
	}
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
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
  
        int nextInt() 
        { 
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
}