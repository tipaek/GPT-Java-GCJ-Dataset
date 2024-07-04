import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        in = new FastReader();
        int T=ni();
        int ca=0;
        while (T-->0){
            String str=n();
            int[] arr=new int[str.length()];
            for (int i=0;i<str.length();i++){
                arr[i]=str.charAt(i)-'0';
            }
            boolean[] done = new boolean[arr.length];
            ArrayList<pair> al = new ArrayList<>();
            for (int i=0;i<arr.length;i++){
                al.add(new pair(arr[i],i));
            }
            al.sort(Collections.reverseOrder());
            int[] start=new int[arr.length];
            int[] end=new int[arr.length];
            for (int i=0;i<al.size();i++){
                pair pp=al.get(i);
                if (done[pp.y])continue;
                done[pp.y]=true;
                // right
                {
                    int max=pp.x;
                    int rem=pp.x;
                    int last=pp.y;
                    for (int k = pp.y + 1; k < arr.length; k++) {
                        if (arr[k]>max){
                            end[k-1]+=rem;
                            rem=arr[k];
                            max=arr[k];
                            break;
                        }else{
                            if(arr[k]==max){
                                last=k;
                                done[k]=true;
                                continue;
                            }
                            else{
                                end[k - 1] += rem - arr[k];
                                max = arr[k];
                                rem = arr[k];
                                done[k] = true;
                            }
                        }
                        last=k;

                    }
                    if (rem>0){
                        end[last]+=rem;
                    }

                }

                // left

                {
                    int max=pp.x;
                    int rem=pp.x;
                    int last=pp.y;
                    for (int k = pp.y - 1; k >= 0 ; k--) {
                        if (arr[k]>max){
                            start[k+1]+=rem;
                            rem=arr[k];
                            max=arr[k];
                            break;
                        }else{
                            if(arr[k]==max){
                                last=k;
                                done[k]=true;
                                continue;
                            }
                            else{
                                start[k + 1] += rem - arr[k];
                                max = arr[k];
                                rem = arr[k];
                                done[k] = true;
                            }
                        }
                        last=k;

                    }
                    if (rem>0){
                        start[last]+=rem;
                    }

                }


            }
            StringBuilder sb=new StringBuilder();
            for (int k=0;k<arr.length;k++){
                for (int i=0;i<start[k];i++)sb.append('(');
                sb.append(arr[k]);
                for (int i=0;i<end[k];i++)sb.append(')');
            }

            System.out.println("Case #"+(++ca)+": "+sb.toString());
        }

    }
    static class pair implements Comparable<pair>{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(pair o) {
            return this.x-o.x;
        }
    }
    public static long binarySearch(long low, long high) {
        while (high - low > 1) {
            long mid = (high - low)/2 + low;
            //System.out.println(mid);
            if (works(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (works(low) ? low : high);
    }
    static long fast_exp_with_mod(long base, long exp) {
        long MOD=1000000000+7;
        long res=1;
        while(exp>0) {
            if(exp%2==1) res=(res*base)%MOD;
            base=(base*base)%MOD;
            exp/=2;
        }
        return res%MOD;
    }
    public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
    static class my_no{
        long num;
        long denom;

        @Override
        public String toString() {
            if (denom<0){
                this.num=-this.num;
                this.denom=-this.denom;
            }
            if (num==0)return "0";
            return (num+"/"+denom);
        }

        my_no(int no){
            this.num=no;
            this.denom=1;
        }
        my_no(long num,long denom){
            this.num=num;
            this.denom=denom;
        }

        my_no multiply(my_no obj){
            long num1=obj.num;
            long denom1=obj.denom;
            long n=num1*num;
            long d=denom1*denom;
            long gcd=gcd(n,d);
            n/=gcd;
            d/=gcd;
            return new my_no(n,d);

        }
//        my_no multiply(my_no obj){
//            long num1=obj.num;
//            long denom1=obj.denom;
//            long num2=this.num;
//            long denom2=this.denom;
//
//        }

        my_no multiply(int no){
            long n=num*no;
            long d=denom;
            long gcd=gcd(n,d);
            n/=gcd;
            d/=gcd;
            return new my_no(n,d);

        }
    }
    static void memset(int[][] arr,int val){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                arr[i][j]=val;
            }
        }
    }
    static void memset(int[] arr,int val){
        for (int i=0;i<arr.length;i++){
            arr[i]=val;
        }
    }


    static void memset(long[][] arr,long val){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                arr[i][j]=val;
            }
        }
    }
    static void memset(long[] arr,long val){
        for (int i=0;i<arr.length;i++){
            arr[i]=val;
        }
    }
    static private boolean works(long test){
        return true;
    }
    public static int upperBound(int[] array,
                                 int value)
    {
        int low = 0;
        int high = array.length;
        while (low < high)
        {
            final int mid = (low + high) / 2;
            if (value >= array[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }
        return low;
    }


    static void reverse(char[] arr ,int i,int j){
        if (i==j)
            return;
        while (i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            ++i;
            --j;
        }
    }
    static int[]  takeIntegerArrayInput(int no){
        int[] arr=new int[no];
        for (int i=0;i<no;++i){
            arr[i]=ni();
        }
        return arr;
    }
    static long fast_Multiply(long no , long pow){
        long result=1;
        while (pow>0){
            if ((pow&1)==1){
                result=result*no;
            }
            no=no*no;
            pow>>=1;
        }
        return result;
    }

    static long[]  takeLongArrayInput(int no){
        long[] arr=new long[no];
        for (int i=0;i<no;++i){
            arr[i]=ni();
        }
        return arr;
    }
    static final long MOD = (long)1e9+7;
    static FastReader in;


    static void p(Object o){
        System.out.print(o);
    }

    static void pn(Object o){
        System.out.println(o);
    }

    static String n(){
        return in.next();
    }

    static String nln(){
        return in.nextLine();
    }

    static int ni(){
        return Integer.parseInt(in.next());
    }

    static int[] ia(int N){
        int[] a = new int[N];
        for(int i = 0; i<N; i++)a[i] = ni();
        return a;
    }

    static long[] la(int N){
        long[] a = new long[N];
        for(int i = 0; i<N; i++)a[i] = nl();
        return a;
    }

    static long nl(){
        return Long.parseLong(in.next());
    }

    static double nd(){
        return Double.parseDouble(in.next());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
    static void println(String[] arr){
        for (int i=0;i<arr.length;++i){
            System.out.println(arr[i]);
        }
    }

}

