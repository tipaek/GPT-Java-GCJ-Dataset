//shem
import java.io.*;
import java.util.*;

public class shem{
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			//test case starts
	        int MINUTES = 24 * 60 + 1;
	        int n = Integer.parseInt(br.readLine());
	        char a[] = new char[n + 1];
	        int start[] = new int[n];
	        int end[] = new int[n];
	        int id[] = new int[n];
	        boolean impossible = false;
	        
	      
	        //creating jobs
	        for(int job = 1; job <= n; job++){
	            int s, e;
	            String str[] = br.readLine().split(" ");
	            s = Integer.parseInt(str[0]);
	            e = Integer.parseInt(str[1]);
	            start[job - 1] = s;
	            end[job - 1] = e;
	            id[job - 1] = job;
	        }
	        //end creating jobs
			
	        
	        //sorting: earliest finish time first
	        for(int i = 0; i < n - 1; i++){
	            int min = i;
	            for(int j = i + 1; j < n; j++){
	                if(end[j] < end[min])
	                    min = j;
	            }
	            int tmp = end[i];
	            end[i] = end[min];
	            end[min] = tmp;
	            
	            tmp = start[i];
	            start[i] = start[min];
	            start[min] = tmp;
	            
	            tmp = id[i];
	            id[i] = id[min];
	            id[min] = tmp;
	        }
	        // end sorting
	        
	        int cam = 0, jam = 0;
	        for(int i = 0; i < n; i++){
	            //assigning
	            //if cam finishes before the next job
	            if(cam <= start[i]){
	                a[id[i] - 1] = 'C';
	                cam = end[i];
	            }
	            //else if jam finishes before the next job
	            else if(jam <= start[i]){
	                a[id[i] - 1] = 'J';
	                jam = end[i];
	            }
	            //else none of them finishes
	            else{
	                impossible = true;
	                break;
	            }
	            
	            //end assigning
	        }
	        
	        System.out.print("Case #");
	        System.out.print(t);
	        System.out.print(": ");
	        if(impossible)
	            System.out.println("IMPOSSIBLE");
	        else{
	            String x = a.toString();
	        	System.out.println(x);
	        }  
	        
			
			//end test case
		}
		
		//end main
	}
	
	
	//end class
}