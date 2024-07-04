
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 class Solution {
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
			} while ((c = read()) >= '0' && c <= '9'); 

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
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int T = sc.nextInt(),t=1;
        
        while(t <= T)
        {
            int N  = sc.nextInt();
            int arrTr[][] = new int[N][N];
            int i,j,input,count=0,urow=0,ucol=0,trace = 0;
           
            Map<Integer,Set<Integer>> tracker = new HashMap<>();
            
             Map<Integer,Set<Integer>> tracker2 = new HashMap<>();
              for(i=0;i<N;i++)
              {
                  
                  for(j=0;j<N;j++)
                  {
                      input = sc.nextInt();
                     if(tracker.containsKey(i))
                         tracker.get(i).add(input);
                     else
                     {
                         tracker.put(i, new HashSet<>());
                           tracker.get(i).add(input);
                     }
                     
                     
                      if(tracker2.containsKey(j))
                         tracker2.get(j).add(input);
                     else
                      {
                         tracker2.put(j, new HashSet<>());
                           tracker2.get(j).add(input);
                      }
                     
                        if(i==j)
                            trace+=input;
                       
                          
                  }
              
              }
              for(i=0;i<N;i++)
              {
                  if(tracker.get(i).size() != N)
                      urow++;
                  if(tracker2.get(i).size() != N)
                      ucol++;
              }
              StringBuffer sb = new StringBuffer();
              sb.append("Case #"+t+":"+" ");
              sb.append(trace+" "+urow+" "+ucol);
              sb.append(System.getProperty("line.separator"));
              System.out.print(sb);
              t++;
                  
        }
    }

    
}
