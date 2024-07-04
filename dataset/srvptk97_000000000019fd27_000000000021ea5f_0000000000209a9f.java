import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception{
		FastReader sc1 = new FastReader();
		int tc = Integer.parseInt(sc1.nextLine());
		int ch = 1;
		StringBuilder sb = new StringBuilder();
		
	    while(ch<=tc){
	        String str = sc1.nextLine();
	        int n = str.length();
	        int[] arr = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(Character.toString(str.charAt(i)));
	        }
	        int[] nopl = new int[n];
	        int[] nopr = new int[n];
	        
	        while(true){
	            int maxval = 0;
	            int maxind = -1;
	            for(int i=0;i<n;i++){
	                if(arr[i]>maxval){
	                    maxval = arr[i];
	                    maxind = i;
	                }
	            }
	            if(maxval>0){
	                    int left = maxind-1;
	                    int right = maxind+1;
	                    while(right<n && arr[right]==maxval){
	                        right++;
	                    }
	                    while(left>=0 && arr[left]==maxval){
	                        left--;
	                    }
	                    int nol = maxval;
	                    int nor = maxval;
	                    if(left>=0){
	                        nol = maxval-arr[left];
	                    }
	                    if(right<=n-1){
	                        nor = maxval-arr[right];
	                    }
	                    int cnop = Math.min(nol,nor);
	                    nopl[left+1] += cnop;
	                    nopr[right-1] += cnop;
	                    for(int i=left+1;i<=right-1;i++){
	                        arr[i] -= cnop;
	                    }
	            }
	            else{
	                    break;
	            }
	        }
	        
	        /*for(int i=0;i<n;i++){
	            System.out.print(nopl[i]+" ");
	        }
	        System.out.println();
	        for(int i=0;i<n;i++){
	            System.out.print(nopr[i]+" ");
	        }
	        System.out.println();
	        */
	        
	        StringBuilder sb1 = new StringBuilder();
	        for(int i=0;i<n;i++){
	            while(nopl[i]>0){
	                sb1.append("(");
	                nopl[i]--;
	            }
	            sb1.append(Character.toString(str.charAt(i)));
	            while(nopr[i]>0){
	                sb1.append(")");
	                nopr[i]--;
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
