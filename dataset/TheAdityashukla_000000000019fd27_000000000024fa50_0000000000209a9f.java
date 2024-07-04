
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KIIT
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
        while(t<=T)
        {
           String query = sc.readLine();
           StringBuffer  ans = new StringBuffer(),sb = new StringBuffer();
           int len = query.length(),val,openBrace=0,i,j,valBefore = 0;
           for(i=0;i<len;i++)
           {
               char ch = query.charAt(i);
               val = Character.getNumericValue(ch);
               if(i-1 >= 0)
                    valBefore =  Character.getNumericValue(query.charAt(i-1));
              if(i-1 < 0)
              {
                  ans.append(openBracket(val));
                  openBrace = val;
                 
              }
              else if(val >= valBefore)
              {
                  ans.append(openBracket(val-openBrace));
                  openBrace+=val-openBrace;
                 
              }
              else
              {
                  ans.append(closeBracket(valBefore-val));
                  openBrace-=(valBefore-val);
                
              }
               ans.append(val);
              
            
               
           }
           ans.append(closeBracket(openBrace));
           sb.append("Case #"+t+": "+ans);
           sb.append(System.getProperty("line.separator"));
            System.out.print(sb);
            t++;
            
        }
    }
    public static String openBracket(int n)
    {
        String val="";
        if(n<=0)
            return "";
        else
            for(int i =0;i<n;i++)
            {
                val+="(";
            }
        return val;
    }
    public static String closeBracket(int n)
    {
        String val="";
        if(n<=0)
            return "";
        else
            for(int i =0;i<n;i++)
            {
                val+=")";
            }
        return val;
    }
}
