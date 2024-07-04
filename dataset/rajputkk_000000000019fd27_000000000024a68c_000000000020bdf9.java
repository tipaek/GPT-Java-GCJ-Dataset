
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    static class FastReader{ 
     
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
    static class Activity{
        int st;
        int end;
        int index;
        public Activity(int st,int end,int index){
            this.st = st;
            this.end = end;
            this.index = index;
        }
        public int get_st(){
            return st;
        }
        public int get_end(){
            return end;
        }
        public int get_index(){
            return index;
        }
    }
    static class Sort implements Comparator<Activity>{
        public int compare(Activity a, Activity b){ 
            return a.st - b.st;
        } 
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	     FastReader sc=new FastReader();
	     int t = sc.nextInt();
	     PrintWriter out = new PrintWriter(System.out);
        for(int tcase = 1; tcase <= t; tcase++){
            int n = sc.nextInt();
            Activity arr[] = new Activity[n];
            for(int i = 0; i < n; i++){
                arr[i] = new Activity(sc.nextInt(),sc.nextInt(),i);
            }
            Arrays.sort(arr,new Sort());
            char str[] = new char[n];
            int c_freetime = 0;
            int j_freetime = 0;
            boolean flag = false;
            for(int i = 0; i < n; i++){
                if(c_freetime <= arr[i].get_st()){
                    str[arr[i].get_index()] = 'C';
                    c_freetime = arr[i].get_end();
                }
                else if(j_freetime <= arr[i].get_st()){
                    str[arr[i].get_index()] = 'J';
                    j_freetime = arr[i].get_end();
                }
                else{
                    out.println("Case #"+tcase+": "+"IMPOSSIBLE");
                    flag = true;
                    break;
                }
            }
            if(flag)
                continue;
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < n; i++){
                s.append(str[i]);
            }
            String final_s = s.toString();
            // for(int i = 0; i < n; i++){
            //     out.println(arr[i].get_st()+" "+arr[i].get_end()+" "+arr[i].get_index());
            // }
                
	        
            out.println("Case #"+tcase+": "+final_s);         
	    }out.flush();
	}
}
