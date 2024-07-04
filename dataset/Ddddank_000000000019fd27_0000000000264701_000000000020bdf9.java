
import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Vector;
import java.lang.Exception.*;
import java.util.InputMismatchException;



class act{
	public int st;
	public int end;
	public act(int st,int end){
		this.st=st;
		this.end=end;
	}
}

public class Solution{
	public static Print print=new Print();
	public static Scan scan=new Scan();
	
	public static boolean overlap(int s1,int e1,int s2 ,int e2){
		if(e1<=s2)return false;
		if(s1>=e2)return false;
		return true;
	}
	
	
	
	
	
	
	public static void solve(act[] acts,int n,int t) throws Exception{
		Vector<act> carla=new Vector<>();
		Vector<act> jack=new Vector<>();
		String ans="";
		for(int i=0;i<n;i++){
			int st=acts[i].st;
			int end=acts[i].end;
			boolean boolC=true;
			for(int j=0;j<carla.size();j++){
				if(overlap(st,end,carla.get(j).st,carla.get(j).end)){
					boolC=false;
					break;
				}
			}
			if(boolC){
				//int[] temp={st,end};
				
				carla.add(new act(st,end));
				ans=ans+"C";
			}
			else{
				boolean boolJ=true;
				for(int j=0;j<jack.size();j++){
					if(overlap(st,end,jack.get(j).st,jack.get(j).end)){
						boolJ=false;
					    	break;
					}
				}
				if(boolJ){
					//int[] temp={st,end};
					jack.add(new act(st,end));
					ans=ans+"J";
				}
				else{
					ans="IMPOSSIBLE";
					break;
				}
			}
		}
		print.println("Case #"+t+": "+ans);
		
		
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
			int t=scan.scanInt();
			for(int i=0;i<t;i++){
				int n=scan.scanInt();
				act[] acts=new act[n];
				act a;
				for(int y=0;y<n;y++){
					int t1=scan.scanInt();
					int t2=scan.scanInt();
					a=new act(t1,t2);
					acts[y]=a;
					
				}
				solve(acts,n,i+1);
				
				
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

