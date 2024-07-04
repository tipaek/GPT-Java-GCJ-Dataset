import java.util.*;
import java.io.*;

class Task implements Comparable{
    int st, en, ind;
    Task(int st, int en, int ind){
        this.st = st;
        this.en = en;
        this.ind = ind;
    }
    public int compareTo(Object obj){
        Task task = (Task)obj;
        if(this.st > task.st){
            return 1;
        }
        else{
            return -1;
        }
    }
}
class Solution {
    public static void main(String args[]) throws Exception{
		FastReader sc1 = new FastReader();
		int tc = sc1.nextInt();
		int ch = 1;
		StringBuilder sb = new StringBuilder();
		
	    while(ch<=tc){
	        int n = sc1.nextInt();
	        ArrayList<Task> tasks = new ArrayList<>();
	        
	        for(int i=0;i<n;i++){
	            int st = sc1.nextInt();
	            int en = sc1.nextInt();
	            Task task = new Task(st,en,i);
	            tasks.add(task);
	        }
	        Collections.sort(tasks);
	        int c = 0;
	        int j = 0;
	        int[] assi = new int[n];
	        int posi = 1;
	        
	        for(int i=0;i<n;i++){
	            Task task = tasks.get(i);
	            //System.out.println(task.st+" "+task.en+" "+task.ind);
	            //System.out.println(c+" "+j);
	            if(task.st >= c){
	                assi[task.ind] = 0;
	                c = task.en;
	            }
	            else if(task.st >= j){
	                assi[task.ind] = 1;
	                j = task.en;
	            }
	            else{
	                posi = 0;
	                break;
	            }
	        }
	        StringBuilder sb1 = new StringBuilder();
	        if(posi == 0){
	            sb1.append("IMPOSSIBLE");
	        }
	        else{
	            for(int i=0;i<n;i++){
	                if(assi[i]==0){
	                    sb1.append("C");
	                }
	                else{
	                    sb1.append("J");
	                }
	            }
	        }
	        sb.append("Case #"+ch+": "+sb1.toString()+"\n");
	        ch++;
	    }
	    System.out.print(sb.toString());
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
