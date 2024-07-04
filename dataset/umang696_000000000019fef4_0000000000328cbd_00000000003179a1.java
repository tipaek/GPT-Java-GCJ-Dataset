import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String []args) throws IOException {
    FastScanner in  = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false);
    solve(in, out);
    in.close();
    out.close();
    }
    static class FastScanner{
BufferedReader reader;
StringTokenizer st;
FastScanner(InputStream stream){reader=new BufferedReader(new InputStreamReader(stream));st=null;}
String next(){while(st == null || !st.hasMoreTokens()){try{String line = reader.readLine();if(line == null){return null;}
    st = new StringTokenizer(line);}catch (Exception e){throw new RuntimeException();}}return st.nextToken();}
String nextLine()  {String s=null;try{s=reader.readLine();}catch(IOException e){e.printStackTrace();}return s;}
int    nextInt()   {return Integer.parseInt(next());}
long   nextLong()  {return Long.parseLong(next());}
double nextDouble(){return Double.parseDouble(next());}
char   nextChar()  {return next().charAt(0);}
int[]  nextIntArray(int n)         {int[] arr= new int[n];   int i=0;while(i<n){arr[i++]=nextInt();}  return arr;}
long[] nextLongArray(int n)        {long[]arr= new long[n];  int i=0;while(i<n){arr[i++]=nextLong();} return arr;}
int[]  nextIntArrayOneBased(int n) {int[] arr= new int[n+1]; int i=1;while(i<=n){arr[i++]=nextInt();} return arr;}
long[] nextLongArrayOneBased(int n){long[]arr= new long[n+1];int i=1;while(i<=n){arr[i++]=nextLong();}return arr;}
void   close(){try{reader.close();}catch(IOException e){e.printStackTrace();}}
    }
   
    /********* SOLUTION STARTS HERE ************/
   
    static int len(long n){
        String s = n+"";
        return s.length();
    }
    static int first(long n){
        return (int)(((n+"").charAt(0)) - '0');
    }
    private static void solve(FastScanner in, PrintWriter out){
        int n = 10000;
        int T = in.nextInt();
        for(int t = 1; t <= T; t++)
        {
            out.print("Case #"+t+": ");
            int u = in.nextInt();
            long v = (long)Math.pow(10L, u);
            String s[] = new String[n];
            long val[] = new long[n];
            boolean ch[] = new boolean[150];
            for(int i=0;i<n;i++){
                val[i] = in.nextLong();
                s[i] = in.next();
                for(int j=0;j<s[i].length();j++){
                    ch[s[i].charAt(j)] = true;
                }
            }
            char arr[] = new char[10];int pt=0;
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0;i<150;i++){
                if(ch[i]){
                    arr[pt] = (char)i;
                    map.put((char)i, pt);
                    ++pt;
                }
            }
            boolean[][] possible = new boolean[10][10];
            char[] ans = new char[10];
            Arrays.fill(ans, '.');
            for(int i=0;i<n;i++){
                if(s[i].length() == len(val[i])){
               
                    int w1 = map.get(s[i].charAt(0));
                    int w2 = first(val[i]);
                //     if(s[i].length()==1) {
                // out.println(s[i]+" - "+val[i]+" = "+first(val[i])+" - "+w1+" = "+w2);
                // }
                    for(int j=w2 + 1; j < 10; j++){
                        possible[w1][j] = true;
                    }
                    possible[w1][0] = true;
                }
            }
            for(int i=0;i<10;i++){
                int cnt = 9;
                for(int j=0;j<10;j++){
                    if(possible[i][j] && ans[j]=='.') {cnt = j; break;}
                }
                if(ans[cnt] == '.'){
                    ans[cnt] = arr[cnt];
                }
            }
            // for(char i: ans) out.print(i); out.println();
            // for(char c: arr) out.print(c+" "); out.println();
            // for(char c: arr) out.print(map.get(c)+" "); out.println("\n");
           
            int[][] ar2 = new int[10][2];
            // for(int i=0;i<10;i++) {
            // out.print(i+":- ");
            // for(int j=0;j<10;j++) {
            // out.print((possible[i][j]?1:0) + " ");
            // }out.println();
            // }
           
            outer:
            for(int k=0;k<10;k++){
                for(int i=0;i<10;i++) {
                    int cnt=0,ind=0;
                for(int j=0;j<10;j++) {
                   if(!possible[i][j]) {cnt++;ind = j;}
                }
                if(cnt==1){
                   ans[ind] = arr[i];
                   for(int j=0;j<10;j++){
                       possible[j][ind] = true;
                   }
                   continue outer;
                }
                }
            }
            // out.println("ANS: ");
            for(char c: ans) out.print(c);out.println();
           
           
            Arrays.sort(ar2, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    return a[1] - b[1];
                }
            });
            // for(int i=0;i<10;i++){
            //     for(int j:ar2[i]) out.print(j+" "); out.println();
            // }
           
        }
    }
   
    /************* SOLUTION ENDS HERE **********/
}