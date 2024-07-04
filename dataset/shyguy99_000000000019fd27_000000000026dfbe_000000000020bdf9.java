import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;


class Rextester
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
  static class interval{
    int start, end;
    interval(int s, int e){
      start=s;end=e;
    }
    public String toString(){
      return "start: "+start+"  end: "+end;
    }
  }
  public static class sortbySec implements Comparator<interval>{
    @Override
    public int compare(interval i1, interval i2){
      return (i1.end > i2.end)? 1:-1;
    }
  }
  public static class sortbyFirst implements Comparator<interval>{
    @Override
    public int compare(interval i1, interval i2){
      return (i1.start >= i2.start)? 1:-1;
    }
  }
	public static void main(String[] args) throws IOException
	{
		Reader in=new Reader();
		int test=in.nextInt();
    for(int testtt=1;testtt<=test;testtt++){
      int n=in.nextInt();
      ArrayList<interval> ar= new ArrayList<>();
      ArrayList<Integer> index= new ArrayList<>();
      for(int i=0;i<n;i++){
        int start=(i%2==0)? i-1:i;//in.nextInt();
        index.add(start);
        int end=i+1;//in.nextInt();
        interval inter=new interval(start, end);
        ar.add(inter);
      }
      ar.sort(new sortbyFirst());
      int cs, ce, js, je, flag=0;
      cs=ce=js=je=0;
      cs=ar.get(0).start;
      ce=ar.get(0).end;
      char[] c= new char[n];
      c[index.indexOf(cs)]='C';
      // System.out.println(index.indexOf(cs));
      index.set(index.indexOf(cs), -1);
      // System.out.println(Arrays.toString(c));
      for(int i=1;i<ar.size();i++){
        //System.out.println(s);
        int start=ar.get(i).start;
        int end=ar.get(i).end;
        int idx=index.indexOf(start);
        index.set(idx, -1);
        //System.out.println("index is: "+ idx);
        //System.out.println(ar.get(i));
        if(ce<=start){
          c[idx]='C';
          cs=start;ce=end;
        }
        else if(je<=start){
          c[idx]='J';
          je=end;
          js=start;
        }
        else{
          flag=1;
          break;
        }
      }
      if(flag!=1)
        System.out.printf("Case #%d: %s\n",testtt, new String(c));
      else {
        System.out.printf("Case #%d: IMPOSSIBLE\n",testtt);
      }
      // System.out.println(Arrays.toString(c));
    }
	}
}
