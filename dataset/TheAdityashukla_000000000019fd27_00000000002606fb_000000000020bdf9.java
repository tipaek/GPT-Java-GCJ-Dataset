
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 class Solution {
    static class Activity
    {
        int start;
        int end;
        int index;
        char boy;
    }
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
			byte[] buf = new byte[200]; // line length 
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
            int N  = sc.nextInt(),i;
            Activity activity[] = new Activity[N];
            for(i=0;i<N;i++)
            {
                activity[i] = new Activity();
                activity[i].index = i;
                activity[i].start = sc.nextInt();
                activity[i].end = sc.nextInt();
            }
         
          Arrays.sort(activity, new Comparator<Activity>() 
            {
			public int compare(Activity first, Activity second) {
				if (first.start != second.start) {
					return first.start - second.start;
				}
				return 0;
			}
		});
          char ans[] = new char[N];
          activity[0].boy = 'J';
          ans[activity[0].index] = 'J';
          int Jpointer = 0,Cpointer=-1;
          StringBuffer sb = new StringBuffer();
         for(i =1;i<N;i++)
         {
             //If there is a overlap : 
             
             if(activity[i].start < activity[i-1].end)
             {
                 if(activity[i-1].boy=='J') //iF LAST WAS J
                   {
                 if(Cpointer!=-1)
                 {
                    if(activity[i].start >= activity[Cpointer].end) //IF POSSIBLE TO SWITCH :
                    {
                        activity[i].boy = 'C';
                        ans[activity[i].index] = 'C';
                        Cpointer = i;
                    }
                    else
                    {
                       sb.append("Case #"+t+": "+"IMPOSSIBLE");
                       break;
                    }
                        
                 }
                 else
                 {
                   activity[i].boy = 'C';
                        ans[activity[i].index] = 'C';
                        Cpointer = i;   
                 }
             }
            
             else
             {
                    
                 if(activity[i].start >= activity[Jpointer].end) //IF POSSIBLE TO SWITCH :
                    {
                        activity[i].boy = 'J';
                        ans[activity[i].index] = 'J';
                        Jpointer = i;
                    }
                    else
                    {
                       sb.append("Case #"+t+": "+"IMPOSSIBLE");
                       break;
                    }
                        
                 }
               
             }
                  else
             {
                 activity[i].boy = activity[i-1].boy;
                        ans[activity[i].index] = activity[i].boy;
                        if(activity[i].boy == 'J')
                            Jpointer = i;
                        else
                            Cpointer = i;
             }
        }
         if(sb.length()==0)
         {
             sb.append("Case #"+t+": ");
             sb.append(ans);
         }
         sb.append(System.getProperty("line.separator"));
            System.out.print(sb);
            t++;
}
}
}
