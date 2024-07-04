import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;
  
public class Solution 
{ 
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[100]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }
    
    



    
    static boolean isValidated(int[][] arr , int row , int col , int val){
    
        for(int i = 0 ; i<arr[0].length ; i++){
            if(arr[row][i] ==val) return false;
        }

        for(int i = 0 ; i<arr[0].length ; i++){
            if(arr[i][col] == val) return false;
        }

        return true;
    }


    public static boolean solvearr(int[][] arr, int tcase) {
        
        int row = 0 , col = 0;
        boolean hasNotReached = true;
        Stack<ArrayList<Integer>> reached = new Stack<>();
        while(row!=arr.length){
        	// printArr(arr);
            while( hasNotReached && col < arr[0].length && arr[row][col] != 0 ){
               col++;
            }
            // System.out.println(row + " " + col);

            if(hasNotReached == false) {
                hasNotReached = true;
            }

            if(col == arr[0].length){
                col=0;
                row++;
                continue;
            }

            int i = 1 ;
            
            if(arr[row][col] != 0){
                i = arr[row][col] + 1;
            }

            for( ; i<=arr.length ; i++){
                
                if(isValidated(arr, row, col, i)){

                    arr[row][col] =  i;
                    ArrayList<Integer> currEle = new ArrayList<>();
                    currEle.add(row);
                    currEle.add(col);
                    reached.push(currEle);
                    break;
                }
                // else
                // 	System.out.println("Not Valid");
            }

            col++;
            if(i==arr.length + 1){
                arr[row][col-1] = 0;
                if(reached.size()==0) {
                    return false;
                }

                ArrayList<Integer> prevEle = reached.pop();
                row = prevEle.get(0);
                col = prevEle.get(1);
                hasNotReached = false;
            }
        }
		
		System.out.println("Case #" + tcase + ": POSSIBLE");
		printArr(arr);
		
        // System.out.println("Found a Sol");
        return true;
    }

	public static void printArr(int[][] arr) {
		int N = arr.length;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
    
    
    public static boolean getCombination(int[][] arr, int rem, int ij, int prev_num, int N, int tcase) {
    		
    		if(rem == 0) {
    			// System.out.println("Not Possible Rem 0");
    			if(ij == N){
    				
    				
    				if(solvearr(arr, tcase)){
                        return true;
                    }
                    else{
                        return false;
                    }
    			}
    			else{
    				return false;
    			}
    		}
    		
    		if(ij == N){
    			return false;
    		}
    		
    		if(rem < prev_num*(N-ij)){
    			// System.out.println("Not Possible by rem < product");
    			return false;
    		}
    		
    		for(int i=prev_num;i<=N;i++){
    			// printArr(arr);
    			arr[ij][ij] = i;
    			if(getCombination(arr, rem-i, ij+1, i, N, tcase)){
    				return true;
    			}
    		}
    		return false;
    }


    public static void solution(int tcase, int n, int k) {
    	
    	int[][] arr = new int[n][n];
    	if(getCombination(arr, k, 0, 1, n, tcase)){
    		return;
    	}
    	System.out.println("Case #" + tcase + ": IMPOSSIBLE");
    	
    }
  
    public static void main(String[] args) throws IOException 

    { 
        Reader s=new Reader(); 
        int t = s.nextInt(); 
        int cnt=1;
        
        while (cnt<=t) 
        {
        	int n = s.nextInt();
        	int k = s.nextInt();
        	solution(cnt++, n, k);
               
        } 
    } 
} 
