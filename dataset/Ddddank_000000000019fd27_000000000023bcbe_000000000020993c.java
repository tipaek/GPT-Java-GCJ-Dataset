
import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Vector;
import java.lang.Exception.*;
import java.util.InputMismatchException;

public class Solution{
	public static Print print=new Print();
	public static Scan scan=new Scan();
	public static void solve(int[][] mat,int n,int t) throws Exception{
		
		int k=0;
		int trace=0;
		int rows=0;
		int cols=0;
		while(k<n){
			//print.println(mat[k][k]);
			trace+=mat[k][k];
			HashSet<Integer> repRow=new HashSet<>();
			HashSet<Integer> repCol=new HashSet<>();
			//repRow.add(mat[k][k]);
			//repCol.add(mat[k][k]);
			boolean rowRep=false;
			boolean colRep=false;
			int i=0;
			while(i<n &&(!rowRep || !colRep)){
				//print.println(k/0);
				if(!rowRep){
					if(repRow.contains(mat[k][i])){
						//print.println("Hello");
						rows++;
						rowRep=true;
					}
					else{
						
						repRow.add(mat[k][i]);
					}
				}
				if(!colRep){
					if(repCol.contains(mat[i][k])){
						cols++;
						colRep=true;
					}
					else{
						repCol.add(mat[i][k]);
					}
				}
				i++;
		}
		k++;
			
			
			//Case #3: 8 0 2
	}
		print.println("Case #"+(t+1)+": "+trace+" "+rows+" "+cols);
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		//Scan
		int t=scan.scanInt();
		//print.println(t);
		
		for(int i=0;i<t;i++){
			//print.println(i);
			int n=scan.scanInt();
			int[][] mat=new int[n][n];
			for(int k=0;k<n;k++){
				for(int j=0;j<n;j++){
					mat[k][j]=scan.scanInt();
				}
			}
			solve(mat,n,i);
			
			
			
		}
		
		
		
		print.close();
	}
}


































class Scan
{
    private byte[] buf=new byte[1024];
    private int index;
    private InputStream in;
    private int total;
    public Scan()
    {
        in=System.in;
    }
    public int scan()throws IOException
    {
        if(total<0)
        throw new InputMismatchException();
        if(index>=total)
        {
            index=0;
            total=in.read(buf);
            if(total<=0)
            return -1;
        }
        return buf[index++];
    }
    public int scanInt()throws IOException
    {
        int integer=0;
        int n=scan();
        while(isWhiteSpace(n))
        n=scan();
        int neg=1;
        if(n=='-')
        {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n))
        {
            if(n>='0'&&n<='9')
            {
                integer*=10;
                integer+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        return neg*integer;
    }
    public double scanDouble()throws IOException
    {
        double doub=0;
        int n=scan();
        while(isWhiteSpace(n))
        n=scan();
        int neg=1;
        if(n=='-')
        {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n)&&n!='.')
        {
            if(n>='0'&&n<='9')
            {
                doub*=10;
                doub+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        if(n=='.')
        {
            n=scan();
            double temp=1;
            while(!isWhiteSpace(n))
            {
                if(n>='0'&&n<='9')
                {
                    temp/=10;
                    doub+=(n-'0')*temp;
                    n=scan();
                }
                else throw new InputMismatchException();
            }
        }
        return doub*neg;
    }
    public String scanString()throws IOException
    {
        StringBuilder sb=new StringBuilder();
        int n=scan();
        while(isWhiteSpace(n))
        n=scan();
        while(!isWhiteSpace(n))
        {
            sb.append((char)n);
            n=scan();
        }
        return sb.toString();
    }
    private boolean isWhiteSpace(int n)
    {
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
        return true;
        return false;
    }
}
class Print
{
    private final BufferedWriter bw;
    public Print()
    {
        this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public void print(Object object)throws IOException
    {
        bw.append(""+object);
    }
    public void println(Object object)throws IOException
    {
        print(object);
        bw.append("\n");
    }
    public void close()throws IOException
    {
        bw.close();
    }
}

