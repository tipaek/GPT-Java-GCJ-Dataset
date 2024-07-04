import java.util.*;
import java.io.*;
class Solution{
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
            byte[] buf = new byte[64]; // line length 
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


    //MAIN HERE------------------->
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	for (int z=0;z<t ;z++ ) {

    		String s;
    		if(z==0){
    		 s = sc.nextLine();
    		}
    		s = sc.nextLine();
    		StringBuffer ans = new StringBuffer(100);

    		int stack[] = new int[s.length()];
    		int countOfBrackets = 0;
    		for(int i=0;i<s.length(); i++){
    			if(i==0){
    				stack[i] = Character.getNumericValue(s.charAt(i));
    				for (int j=0;j<stack[i] ;j++ ) {
    					ans.append('(');
    					countOfBrackets++;
    				}
    				ans.append(stack[i]);
    				continue;
    			}
    			int temp = Character.getNumericValue(s.charAt(i));
    			stack[i] = temp;
    			if(temp < stack[i-1]){

    				int closing = Math.abs(stack[i-1]-temp);
    				for (int j=0;j<closing ;j++ ) {
    					ans.append(')');
    					countOfBrackets--;
    				}
    				ans.append(stack[i]);
    			}else if(temp == stack[i-1]){
    				ans.append(stack[i]);
    			}else{
    				int opening = Math.abs(stack[i-1] - temp); 
    				for (int j=0;j<opening;j++ ) {
    					ans.append('(');
    					countOfBrackets++;
    				}
    				ans.append(stack[i]);
    			}
    		}
    		if(countOfBrackets > 0){
    			for (int j=countOfBrackets;j>0 ;j-- ) {
    				ans.append(')');
    			}
    		}
    		System.out.println("Case #"+(z+1)+": "+ans);	
    	}
    	


    }
}