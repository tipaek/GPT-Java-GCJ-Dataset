import java.util.*;
import java.io.*;
import java.math.*;
class Solution{

	public static void main(String args[]){
		FastReader sc = new FastReader();
		StringBuilder sb=new StringBuilder();
        int t,k,i,n,j;
        String s;
		t=sc.nextInt();
		for(k=1;k<=t;k++){
            s=sc.next();
            n=s.length();
            int a[]=new int[n];
            StringBuilder ans=new StringBuilder();
            for(i=0;i<n;i++)
                a[i]=s.charAt(i)-'0';
            int count=a[0];
            for(i=1;i<=count;i++)
                ans.append("(");
            ans.append(a[0]);
            int diff;
            for(i=1;i<n;i++){
                if(a[i]<a[i-1]){
                    diff=a[i-1]-a[i];
                    for(j=1;j<=diff;j++)
                        ans.append(")");
                    ans.append(a[i]);
                    count-=diff;
                }
                else if(a[i]>a[i-1]){
                    diff=a[i]-a[i-1];
                    for(j=1;j<=diff;j++)
                        ans.append("(");
                    ans.append(a[i]);
                    count+=diff;
                }
                else 
                    ans.append(a[i]);
            }
            for(i=1;i<=count;i++)
                ans.append(")");
            
			sb.append("Case #"+k+": "+ans+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
        out.println(sb);
		out.flush();
	}

	static PrintWriter out;
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			br=new BufferedReader(new InputStreamReader(System.in));
			out=new PrintWriter(System.out);
		}
		String next(){
			while(st==null || !st.hasMoreElements()){
				try{
					st= new StringTokenizer(br.readLine());
				}
				catch (IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
		long nextLong(){
			return Long.parseLong(next());
		}
		double nextDouble(){
			return Double.parseDouble(next());
		}
		String nextLine(){
			String str = "";
			try{
				str=br.readLine();
			}
			catch(IOException e){
				e.printStackTrace();
			}
			return str;
		}
	}

	public static boolean isPrime(int n) {
		if(n<2) return false;
		for(int i=2;i<=(int)Math.sqrt(n);i++) {
			if(n%i==0) return false;
		}
		return true;
	}

	public static long fastexpo(long x, long y, long p){
		long res=1;
		while(y > 0){
			if((y & 1)==1)
				res= ((res%p)*(x%p))%p;
			y= y >> 1;			
			x = ((x%p)*(x%p))%p;
		}
		return res;
	}

	public static boolean[] sieve (int n) {
		boolean primes[]=new boolean[n+1];
		Arrays.fill(primes,true);
		primes[0]=primes[1]=false;
		for(int i=2;i*i<=n;i++){
			if(primes[i]){
				for(int j=i*i;j<=n;j+=i)
					primes[j]=false;
			}
		}
		return primes;
	}

	public static long gcd(long a,long b){
        return (BigInteger.valueOf(a).gcd(BigInteger.valueOf(b))).longValue();
    }

    public static void merge(int a[],int l,int m,int r){
        int n1,n2,i,j,k;
        n1=m-l+1;
        n2=r-m;

        int L[]=new int[n1];
        int R[]=new int[n2];

        for(i=0;i<n1;i++)
            L[i]=a[l+i];
        for(j=0;j<n2;j++)
            R[j]=a[m+1+j];

        i=0;j=0;

        k=l;
        while(i<n1&&j<n2){
            if(L[i]<=R[j]){
                a[k]=L[i];
                i++;
            }
            else{
                a[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            a[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k]=R[j];
            j++;
            k++;
        }
    }
    public static void sort(int a[],int l,int r){
        int m;
        if(l<r){
            m=(l+r)/2;
            sort(a,l,m);
            sort(a,m+1,r);
            merge(a,l,m,r);
        }
    }
}
