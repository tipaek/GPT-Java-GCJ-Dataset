import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;


public class Solution {

	public static Scan fr = new Scan();
	public static OutputWriter op = new OutputWriter();


	public static void main(String[] args) throws IOException {

		int i,j,k;
		int T;
		T=fr.scanInt();
		for (int cs = 1; cs <= T; cs++) {
			int R,C;
			R=fr.scanInt();
			C=fr.scanInt();
			int[][] A = new int[R][C];
			boolean[][] el = new boolean[R][C];
			Dan[][] dan = new Dan[R][C];
			for(i=0;i<R;i++) {
				for(j=0;j<C;j++)
					A[i][j]=fr.scanInt();
			}
			long ans=0;
			long tot=0;
			List<Pair> elL = new ArrayList<>();
			for(i=0;i<R;i++) {
				for(j=0;j<C;j++) {
					tot+=A[i][j];
					Dan d = new Dan();
					if(i>0) {
						d.c++;
						d.tt+=A[i-1][j];
					}
					if(i+1<R) {
						d.c++;
						d.tt+=A[i+1][j];
					}
					if(j>0) {
						d.c++;
						d.tt+=A[i][j-1];
					}
					if(j+1<C) {
						d.c++;
						d.tt+=A[i][j+1];
					}
					dan[i][j]=d;
					if(d.c>0 && d.tt > d.c*A[i][j]) {
						elL.add(new Pair(i,j));
					}
				}
			}
			ans+=tot;
			while(!elL.isEmpty()) {
				Set<Pair> aff = new HashSet<>();
				for(Pair p : elL) {
					Pair up = null;
					Pair lp = null;
					Pair lfp = null;
					Pair rtp = null;
					for(i=p.x-1;i>=0;i--) {
						if(A[i][p.y]>0) {
							up = new Pair(i,p.y);
							break;
						}
					}
					for(i=p.x+1;i<R;i++) {
						if(A[i][p.y]>0) {
							lp = new Pair(i,p.y);
							break;
						}
					}
					for(j=p.y-1;j>=0;j--) {
						if(A[p.x][j]>0) {
							lfp = new Pair(p.x,j);
							break;
						}
					}
					for(j=p.y+1;j<C;j++) {
						if(A[p.x][j]>0) {
							rtp = new Pair(p.x,j);
							break;
						}
					}
					if(up == null && lp != null) {
						dan[lp.x][lp.y].c--;
						dan[lp.x][lp.y].tt-=A[p.x][p.y];
						aff.add(lp);
					} else if(up != null && lp == null) {
						dan[up.x][up.y].c--;
						dan[up.x][up.y].tt-=A[p.x][p.y];
						aff.add(up);
					} else if(up != null && lp != null) {
						dan[lp.x][lp.y].tt-=A[p.x][p.y];
						dan[up.x][up.y].tt-=A[p.x][p.y];

						dan[lp.x][lp.y].tt+=A[up.x][up.y];
						dan[up.x][up.y].tt+=A[lp.x][lp.y];						

						aff.add(lp);
						aff.add(up);
					}
					if(lfp == null && rtp != null) {
						dan[rtp.x][rtp.y].c--;
						dan[rtp.x][rtp.y].tt-=A[p.x][p.y];
						aff.add(rtp);
					} else if(lfp != null && rtp == null) {
						dan[lfp.x][lfp.y].c--;
						dan[lfp.x][lfp.y].tt-=A[p.x][p.y];
						aff.add(lfp);
					} else if(lfp != null && rtp != null) {
						dan[lfp.x][lfp.y].tt-=A[p.x][p.y];
						dan[rtp.x][rtp.y].tt-=A[p.x][p.y];

						dan[lfp.x][lfp.y].tt+=A[rtp.x][rtp.y];
						dan[rtp.x][rtp.y].tt+=A[lfp.x][lfp.y];						
						aff.add(lfp);
						aff.add(rtp);
					}
					
					
					tot-=A[p.x][p.y];
					A[p.x][p.y]=0;
				}
				ans+=tot;
				elL.clear();
				for(Pair p : aff) {
					Dan d = dan[p.x][p.y];
					if(d.c>0 && d.tt>d.c*A[p.x][p.y]) {
						elL.add(p);
					}
				}
			}
			
			System.out.println("Case #"+cs+": "+ans);			
		}
	}

	static class Dan {
		int c;
		long tt;
	}
	
	static class Pair {
		int x,y;
		Pair(int x,int y) {
			this.x=x;this.y=y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
	
	static class OutputWriter {
		private final PrintWriter writer;
 
		public OutputWriter() {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));			
		}
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
 
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
 
		public void print(Object...objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}
 
		public void printLine(Object...objects) {
			print(objects);
			writer.println();
		}
 
		public void close() {
			writer.close();
		}
 
		public void flush() {
			writer.flush();
		}
 
	}

	
	static class Scan
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
	    public long scanLong()throws IOException
	    {
	        long integer=0;
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
}
