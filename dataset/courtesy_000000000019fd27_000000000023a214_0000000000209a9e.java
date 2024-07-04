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
		int B = fr.scanInt();
		for (int cs = 1; cs <= T; cs++) {
			int[] A = new int[B];
			if(B==10) {
				for(i=1;i<=B;i++) {
					op.printLine(i);
					op.flush();
					A[i-1]=fr.scanInt();
				}
				for(i=0;i<B;i++) {
					op.print(A[i]);
				}
				op.printLine();
				op.flush();
				String s = fr.scanString();
				if(s.equals("N")) {
					return;
				}
				continue;
			}
			
			List<Group> l = new ArrayList<>();
			for(i=0;i<B/10;i++) {
				Group g = new Group();
				int d1,d2;
				for(j=i*5+1;j<=(i+1)*5;j++) {
					op.printLine(j);
					op.flush();
					d1=fr.scanInt();					

					op.printLine(B-j+1);
					op.flush();
					d2=fr.scanInt();	
					
					if(d1==d2) {
						if(d1==0)
							g.s0.add(j);
						else
							g.s1.add(j);
					} else {
						if(d1==0)
							g.d0.add(j);
						else
							g.d1.add(j);
					}
				}
				l.add(g);
			}
			Group g = new Group();
			int qc=0;
			int d1,d2;
			for(i=0;i<l.size();i++) {
				if(l.get(i).s0.size()>0) {
					qc++;
					op.printLine(l.get(i).s0.get(0));
					op.flush();
					d1=fr.scanInt();					
					if(d1==0) {
						g.s0.addAll(l.get(i).s0);
						g.s1.addAll(l.get(i).s1);
					} else {
						g.s0.addAll(l.get(i).s1);
						g.s1.addAll(l.get(i).s0);						
					}
				} else if(l.get(i).s1.size()>0) {
					qc++;
					op.printLine(l.get(i).s1.get(0));
					op.flush();
					d1=fr.scanInt();					
					if(d1==0) {
						g.s0.addAll(l.get(i).s1);
						g.s1.addAll(l.get(i).s0);
					} else {
						g.s0.addAll(l.get(i).s0);
						g.s1.addAll(l.get(i).s1);						
					}
				} 
			}
			while(qc<10) {
				qc++;
				op.printLine(1);
				op.flush();
				d1=fr.scanInt();									
			}
			qc=0;
			for(i=0;i<l.size();i++) {
				if(l.get(i).d0.size()>0) {
					qc++;
					op.printLine(l.get(i).d0.get(0));
					op.flush();
					d1=fr.scanInt();					
					if(d1==0) {
						g.d0.addAll(l.get(i).d0);
						g.d1.addAll(l.get(i).d1);
					} else {
						g.d0.addAll(l.get(i).d1);
						g.d1.addAll(l.get(i).d0);						
					}
				} else if(l.get(i).d1.size()>0) {
					qc++;
					op.printLine(l.get(i).d1.get(0));
					op.flush();
					d1=fr.scanInt();					
					if(d1==0) {
						g.d0.addAll(l.get(i).d1);
						g.d1.addAll(l.get(i).d0);
					} else {
						g.d0.addAll(l.get(i).d0);
						g.d1.addAll(l.get(i).d1);						
					}
				} 
			}
			while(qc<10) {
				qc++;
				op.printLine(1);
				op.flush();
				d1=fr.scanInt();									
			}

			
			int s=0,d=0;
			if(g.s0.size()>0) {
				op.printLine(g.s0.get(0));
				op.flush();
				s=fr.scanInt();		
			} else if(g.s1.size()>0) {
				op.printLine(g.s1.get(0));
				op.flush();
				s=1-fr.scanInt();		
			}
			if(g.d0.size()>0) {
				op.printLine(g.d0.get(0));
				op.flush();
				d=fr.scanInt();		
			} else if(g.d1.size()>0) {
				op.printLine(g.d1.get(0));
				op.flush();
				d=1-fr.scanInt();		
			}
			
			for(Integer id : g.s0) {
				A[id-1]=s;
				A[B-id]=s;
			}
			for(Integer id : g.s1) {
				A[id-1]=1-s;
				A[B-id]=1-s;
			}
			for(Integer id : g.d0) {
				A[id-1]=d;
				A[B-id]=1-d;
			}
			for(Integer id : g.d1) {
				A[id-1]=1-d;
				A[B-id]=d;
			}

			for(i=0;i<B;i++) {
				op.print(A[i]);
			}
			op.printLine();
			op.flush();
			if(fr.scanString().equals("N")) {
				return;
			}
			continue;
		}
		op.close();
	}
	static class Group {
		List<Integer> s0,s1,d0,d1;
		Group() {
			s0=new ArrayList<>();
			s1=new ArrayList<>();
			d0=new ArrayList<>();
			d1=new ArrayList<>();			
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
