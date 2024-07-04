            
import java.util.*;import java.io.*;import java.math.*;

public class Solution
{

    public static void process(int tc)throws IOException
    {
        int n=ni(),d=ni(),res=0,cnt=0;

        long arr[]=new long[n+2];

        for(int i=1;i<=n;i++) arr[i]=nl();
        arr[n+1]=Long.MAX_VALUE;arr[0]=Long.MIN_VALUE;

        r_sort(arr,n+2);

        if(d==2){
            res=1;
            for(int i=1;i<=n;i++){
                cnt=1;
                while(i<=n && arr[i]==arr[i+1]){
                    i++;
                    cnt++;
                }

                if(cnt>=2)
                    res=0;
            }
        }
        else if(d==3){
            res=2;

            for(int i=1;i<=n;i++){
                for(int j=i+1;j<=n;j++){
                    if(arr[j]==arr[i]*2)
                        res=1;
                }
            }

            cnt=1;
            for(int i=1;i<=n;i++){
                while(i<=n && arr[i]==arr[i+1]){
                    i++;
                    cnt++;
                }

                if(cnt>=2)
                    res=0;
            }

        }
       
        pn("Case #"+tc+": "+res);
    }


    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new AnotherReader();
        boolean oj = true;

        //oj = System.getProperty("ONLINE_JUDGE") != null;
        if(!oj) sc=new AnotherReader(100);

        long s = System.currentTimeMillis();
        int t=1;
        t=ni();
        for(int i=1;i<=t;i++)
            process(i);

        out.flush();
        if(!oj)
            System.out.println(System.currentTimeMillis()-s+"ms");
        System.out.close();  
    }
    
    
    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);System.out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}
    static boolean multipleTC=false;
    static long mod=(long)1e9+7l;

    static void r_sort(long arr[],int n){
        Random r = new Random(); 
        for (int i = n-1; i > 0; i--){ 
            int j = r.nextInt(i+1); 
                  
            long temp = arr[i]; 
            arr[i] = arr[j]; 
            arr[j] = temp; 
        } 
        Arrays.sort(arr); 
    }

    static long mpow(long x, long n) {
        if(n == 0)
            return 1;
        if(n % 2 == 0) {
            long root = mpow(x, n / 2);
            return root * root % mod;
        }else {
            return x * mpow(x, n - 1) % mod;
        }
    }
    
    static long mcomb(long a, long b) {
        if(b > a - b)
            return mcomb(a, a - b);
        long m = 1;
        long d = 1;
        long i;
        for(i = 0; i < b; i++) {
            m *= (a - i);
            m %= mod;
            d *= (i + 1);
            d %= mod;
        }
        long ans = m * mpow(d, mod - 2) % mod;
        return ans;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////

    static class AnotherReader{BufferedReader br; StringTokenizer st;
    AnotherReader()throws FileNotFoundException{
    br=new BufferedReader(new InputStreamReader(System.in));}
    AnotherReader(int a)throws FileNotFoundException{
    br = new BufferedReader(new FileReader("input.txt"));}
    String next()throws IOException{
    while (st == null || !st.hasMoreElements()) {try{
    st = new StringTokenizer(br.readLine());}
    catch (IOException  e){ e.printStackTrace(); }}
    return st.nextToken(); } int nextInt() throws IOException{
    return Integer.parseInt(next());}
    long nextLong() throws IOException
    {return Long.parseLong(next());}
    double nextDouble()throws IOException { return Double.parseDouble(next()); }
    String nextLine() throws IOException{ String str = ""; try{
    str = br.readLine();} catch (IOException e){
    e.printStackTrace();} return str;}}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}