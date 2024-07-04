import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.*;
import java.io.*;
public class Solution{
public static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public InputReader(InputStream stream) {
        this.stream = stream;
    }
 
    public int read() {
        if (numChars==-1)
            throw new InputMismatchException();
 
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            }
            catch (IOException e) {
                throw new InputMismatchException();
            }
 
            if(numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
 
    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public int nextInt() {
        int c = read();
 
        while(isSpaceChar(c))
            c = read();
 
        int sgn = 1;
 
        if (c == '-') {
            sgn = -1;
            c = read();
        }
 
        int res = 0;
        do {
            if(c<'0'||c>'9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));
 
        return res * sgn;
    }
 
    public long nextLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
 
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, nextInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
 
    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        }
        while (!isSpaceChar(c));
 
        return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next() {
        return readString();
    }
 
    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
    
	static void mergeSort(int[] input,int start,int end)
    {
        if(start>end || start==end)
            return;
        int mid=(start+end)/2;
        mergeSort(input,start,mid);
        mergeSort(input,mid+1,end);
        
        merge(input,start,end);
        
    }
    static void merge(int input[],int start,int end)
    {
        int sorted[] = new int[end-start+1];
        int mid=(start+end)/2;
        int i=start,j=mid+1,count=0;
        
        while(i<=mid && j<=end)
        {
            if(input[i]>input[j])
            {
                sorted[count]=input[j];
                j++;
                count++;
            }
            else
            {
                sorted[count]=input[i];
                i++;
                count++;
            }
        }
        if(i>mid)
        {
            while(j<=end)
            {
                sorted[count]=input[j];
                j++;
                count++;
            }
        }
        else
        {
            while(i<=mid)
            {
                sorted[count]=input[i];
                i++;
                count++;
            }
        }
        for(i=start;i<=end;i++)
        {
            input[i]=sorted[i-start];
        }
    }
 
    public static void main(String[] args) 
    { 
       InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
       int t=sc.nextInt();
       int c=1;
		while(t-->0) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			char a[]=sc.next().toCharArray();
			int h=x,v=y,i=0,f=0;
			for(;i<a.length;++i) 
			  {
			      if(a[i]=='S')
			         y--;
			         else if(a[i]=='N')
			         y++;
			         else if(a[i]=='W')
			         x--;
			         else if(a[i]=='E')
			         x++;
			         
			         if(Math.abs(x)+Math.abs(y)<=i+1)
			         {
			         f=1;
			         break;
			         }
			  }
			     if(f==1)
			      w.println("Case #"+c+": "+(i+1));
			      else
			      w.println("Case #"+c+": IMPOSSIBLE");
			      c++;
			  }
			  
			  
			
			
			
		
	w.close();
	}
 } 