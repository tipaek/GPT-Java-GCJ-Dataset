//import java.math.*;
import java.io.*;
import java.util.*;
//import java.lang.*;

//solution classes here

public class Solution {

    //main solution here

    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static long mod = (long)1e9+7;
    static long MOD = 998244353;
    //static ArrayList<Integer> list[] = new ArrayList[(int)1e4+1];
    //static int color[] = new int[(int)2e6+1];
    //static int visit[] = new int[(int)1e4+1];
    //static int level[] = new int[(int)1e4+1];
    //static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        int test = t;
        while(t-->0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            ArrayList<Character> a=new ArrayList<>();
            out.print("Case #"+(test-t)+": ");
            if((x%2==1&&y%2==1)||(y%2==0&&x%2==0)) {
                out.println("IMPOSSIBLE");
            }
            else {
                long v = Math.abs(y);
                long h = Math.abs(x);
                long sum=v+h;
                int count=0;
                boolean f=true;
                while(sum>0) {
                    int msb1=0;
                    int msb2=0;
                    if((sum>>count&1)==1) {
                        long v1=v;
                        long h1=h;
                        while(v1>0) {
                            msb1++;
                            v1>>=1;
                        }
                        while(h1>0) {
                            msb2++;
                            h1>>=1;
                        }
                        msb1--;
                        msb2--;
                        if((v>>count&1)==1) {
                            if((sum>>(count+1)&1)==0) {
                                if(count!=msb1) {
                                    a.add('S');
                                    v += 1 << count;
                                }
                                else {
                                    a.add('N');
                                    v-=1<<count;
                                }
                            }
                            else {
                                a.add('N');
                                v-=1<<count;
                            }
                            count++;
                        }
                        else if((h>>count&1)==1) {
                            if((sum>>(count+1))==0) {
                                if(count!=msb2) {
                                    a.add('W');
                                    h += 1 << count;
                                }
                                else {
                                    a.add('E');
                                    h-=1<<count;
                                }
                            }
                            else {
                                a.add('E');
                                h-=1<<count;
                            }
                            count++;
                        }
                        else {
                            f=false;
                            break;
                        }
                    }
                    else {
                        if((v>>count&1)==0&&(h>>count&1)==0)
                            count++;
                        else {
                            f=false;
                            break;
                        }
                    }
                    sum=v+h;
                }
                if(f) {
                    ArrayList<Character> ans = new ArrayList<>();
                    if(y<0) {
                        for(int i=0;i<a.size();i++) {
                            if(a.get(i)=='S') {
                                ans.add('N');
                            }
                            else if(a.get(i)=='N') {
                                ans.add('S');
                            }
                            else {
                                if(x<0) {
                                    if(a.get(i)=='E') {
                                        ans.add('W');
                                    }
                                    else if(a.get(i)=='W') {
                                        ans.add('E');
                                    }
                                }
                                else
                                    ans.add(a.get(i));
                            }
                        }
                    }
                    else if(x<0) {
                        for(char i: a) {
                            if(i=='E') {
                                ans.add('W');
                            }
                            else if(i=='W') {
                                ans.add('E');
                            }
                            else {
                                ans.add(i);
                            }
                        }
                    }
                    else {
                        for(char i:a) {
                            ans.add(i);
                        }
                    }

                    for(char i:ans) {
                        out.print(i);
                    }
                }
                else {
                    out.print("IMPOSSIBLE");
                }


            }
            out.println();

        }

        out.flush();
        out.close();
    }

    //solution functions here


    //---templates---
    public static void reverse (long[] array) {
        int len = array.length;
        for(int i=0;i<len/2;i++) {
            array[i]^=array[len-1-i];
            array[len-i-1]^=array[i];
            array[i]^=array[len-i-1];
        }
    }

    public static int low_bound(long[] array, long value) {
        int len = array.length;
        int lo = 0;
        int hi = len-1;
        int ans = -1;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(array[mid]<=value) {
                lo=mid+1;
                ans=mid;
            }
            else
                hi=mid-1;
        }
        return ans;
    }

    public static int up_bound(long[] array, long value) {
        int len = array.length;
        int lo = 0;
        int hi = len-1;
        int ans = -1;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(array[mid]>=value) {
                hi=mid-1;
                ans=mid;
            }
            else
                lo=mid+1;
        }
        return ans;
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader fileReader) {
            br = new BufferedReader(fileReader);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}

/* *****************************************************************************************************************************
 * I'M NOT IN DANGER, I'M THE DANGER!!!
 * *****************************************************************************************************************************
 */