
import java.io.*;
import java.util.*;
/**
 *
 * @author akash
 */
public class Solution {
    public static void main(String args[]) {
        try {
            int t=nextInt();
            int b=nextInt();
            t:while(t-->0){
                int A[]=new int[b+1];
                int B[]=new int[b+1];
                int C[]=new int[b+1];
                int D[]=new int[b+1];
                Arrays.fill(A, -1);
                Arrays.fill(B, -1);
                Arrays.fill(C, -1);
                Arrays.fill(D, -1);
                int cd=0;
                for(int i=1;i<=10;i++){
                    bw.write(i+"\n");
                    bw.flush();
                    A[i]=nextInt();
                    B[i]=1^A[i];
                    
                }
                if(b==10){
                        StringBuilder sb=new StringBuilder("");
                        for(int k=1;k<A.length;k++){
                            sb.append(A[k]);
                        }
                        bw.write(sb.toString()+"\n");
                        bw.flush();
                        char c=next().charAt(0);
                        if(c=='Y')
                            continue t;
                        else
                            break t;
                }
                int temp[]=new int[11];
                f: for(int i=0;i<140;i++){
                    int index=((i%10)+1);
                    bw.write(i+" "+index+"\n");
                    bw.flush();
                    temp[index]=nextInt();
                    if(index==9){
                        int flag=0;
                        for(int j=1;j<=9;j++){
                            if(A[j]!=temp[j]){
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0){
                            int count=11;
                            while(count<=b && A[count]!=-1)
                                count++;
                            if(count==b+1){
                                StringBuilder sb=new StringBuilder("");
                                for(int k=1;k<A.length;k++){
                                    sb.append(A[k]);
                                }
                                bw.write(sb.toString()+"\n");
                                bw.flush();
                                char c=next().charAt(0);
                                if(c=='Y')
                                    continue t;
                                else
                                    break t;
                            }else{
                                bw.write(count+"\n");
                                bw.flush();
                                A[count]=nextInt();
                                B[count]=1^A[count];
                                i++;
                                temp=new int[11];
                                continue f;
                            }
                        }
                        flag=0;
                        for(int j=1;j<=9;j++){
                            if(B[j]!=temp[j]){
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0){
                            int count=11;
                            while(count<=b && A[count]!=-1)
                                count++;
                            if(count==b+1){
                                StringBuilder sb=new StringBuilder("");
                                for(int k=1;k<B.length;k++){
                                    sb.append(B[k]);
                                }
                                bw.write(sb.toString()+"\n");
                                bw.flush();
                                char c=next().charAt(0);
                                if(c=='Y')
                                    continue t;
                                else
                                    break t;
                            }else{
                                bw.write(count+"\n");
                                bw.flush();
                                B[count]=nextInt();
                                A[count]=1^B[count];
                                i++;
                                temp=new int[11];
                                continue f;
                            }
                        }
                        if(cd==0){
                            //System.out.println(Arrays.toString(A)+"");
                            //System.out.println(Arrays.toString(temp)+"");
                            bw.write("10\n");
                            bw.flush();
                            temp[10]=nextInt();
                            for(int j=1;j<=10;j++){
                                C[j]=temp[j];
                                D[j]=1^C[j];
                            }
                            cd=1;
                        }else{
                            flag=0;
                            for(int j=1;j<=9;j++){
                                if(C[j]!=temp[j]){
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0){
                                int count=11;
                                while(count<=b && C[count]!=-1)
                                    count++;
                                if(count==b+1){
                                    StringBuilder sb=new StringBuilder("");
                                    for(int k=1;k<C.length;k++){
                                        sb.append(C[k]);
                                    }
                                    bw.write(sb.toString()+"\n");
                                    bw.flush();
                                    char c=next().charAt(0);
                                    if(c=='Y')
                                        continue t;
                                    else
                                        break t;
                                }else{
                                    bw.write(count+"\n");
                                    bw.flush();
                                    C[count]=nextInt();
                                    D[count]=1^C[count];
                                    i++;
                                    temp=new int[11];
                                    continue f;
                                }
                            }
                            flag=0;
                            for(int j=1;j<=9;j++){
                                if(D[j]!=temp[j]){
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0){
                                int count=11;
                                while(count<=b && D[count]!=-1)
                                    count++;
                                if(count==b+1){
                                    StringBuilder sb=new StringBuilder("");
                                    for(int k=1;k<D.length;k++){
                                        sb.append(D[k]);
                                    }
                                    bw.write(sb.toString()+"\n");
                                    bw.flush();
                                    char c=next().charAt(0);
                                    if(c=='Y')
                                        continue t;
                                    else
                                        break t;
                                }else{
                                    bw.write(count+"\n");
                                    bw.flush();
                                    D[count]=nextInt();
                                    C[count]=1^D[count];
                                    i++;
                                    temp=new int[11];
                                    continue f;
                                }
                            }
                        }
                        i++;
                        temp=new int[11];
                    }
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TEMPLATE
    
    //******************************************************************************
    // Fast I/O 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int mod=1000000007;
    static boolean prime[]=new boolean[10000001];

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    
    static int nextInt() {
        return Integer.parseInt(next());
    }
    
    static long nextLong() {
        return Long.parseLong(next());
    }

    static double nextDouble() {
        return Double.parseDouble(next());
    }

    static int b_search(int l,int r,int A[],int key){
        int ans=0;
        l=0;r=1000000000;

        while(l<r){
            //System.out.println(ans);
            ans=(l+r)/2;
            long temp=0;
            for (int i = 0; i < A.length; i++) {
                temp+=(long)Math.ceil((double)A[i]/(double)ans);
            }

            if(temp<=key){
                r=ans;
            }
            else{
                l=ans+1;
                ans=r;
            }
        }

        return ans;
    }

//******************************************************************************
//Sieve
static void sieveOfEratosthenes(boolean prime[]){
        int n=10000000;
        for(int i=0;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++){ 
            if(prime[p] == true) 
            {
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
    } 

//******************************************************************************
//Modulo and FastExpo
    static long modInverse(long a)
    {
       return power(a, mod - 2,mod);
    }
     
    // To compute x^y under modulo m
    static long power(long x, long y, int p)
    {
        // Initialize result
        long res = 1;     
        // Update x if it is more  
        // than or equal to p
        x = x % p; 
     while (y > 0)
        {
            // If y is odd, multiply x
            // with result
            if((y & 1)==1)
                res = (res * x) % p;
            // y must be even now
            // y = y / 2
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res;
    }
//******************************************************************************
//GCD
    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
         
        return gcd(b%a, a);
    }

    //******************************************************************************
    // Useful user datatype
    
    static class Pair{
        public long x;
        public long y;

        public Pair(long first, long second){
            this.x = first;
            this.y = second;
            }
        @Override
        public String toString() {
        return "(" + x + 
 + y + ")";
        }
    }

    static Comparator csort=new Comparator<Pair>(){
                    public int compare(Pair a, Pair b) {
                        if(a.x < b.x)
                        return -1;
                        else if (a.x > b.x)
                        return 1;
                        else if(a.y < b.y)
                        return -1;
                        else if (a.y > b.y)
                        return 1;
                        else
                        return 0;
                    }
                };

    //******************************************************************************
    //N choose K
    public static long choose(long total, long choose){
        if(total < choose)
            return 0;
        if(choose == 0 || choose == total)
            return 1;
        return choose(total-1,choose-1)+choose(total-1,choose);
    }

    //******************************************************************************
    //Permutations
    // simply prints all permutation - to see how it works
    private static void printPermutations( Comparable[] c ) {
            System.out.println( Arrays.toString( c ) );
            while ( ( c = nextPermutation( c ) ) != null ) {
                    System.out.println( Arrays.toString( c ) );
            }
    }

    // modifies c to next permutation or returns null if such permutation does not exist
    private static Comparable[] nextPermutation( final Comparable[] c ) {
            // 1. finds the largest k, that c[k] < c[k+1]
            int first = getFirst( c );
            if ( first == -1 ) return null; // no greater permutation
            // 2. find last index toSwap, that c[k] < c[toSwap]
            int toSwap = c.length - 1;
            while ( c[ first ].compareTo( c[ toSwap ] ) >= 0 )
                    --toSwap;
            // 3. swap elements with indexes first and last
            swap( c, first++, toSwap );
            // 4. reverse sequence from k+1 to n (inclusive) 
            toSwap = c.length - 1;
            while ( first < toSwap )
                    swap( c, first++, toSwap-- );
            return c;
    }

    // finds the largest k, that c[k] < c[k+1]
    // if no such k exists (there is not greater permutation), return -1
    private static int getFirst( final Comparable[] c ) {
            for ( int i = c.length - 2; i >= 0; --i )
                    if ( c[ i ].compareTo( c[ i + 1 ] ) < 0 )
                            return i;
            return -1;
    }

    // swaps two elements (with indexes i and j) in array 
    private static void swap( final Comparable[] c, final int i, final int j ) {
            final Comparable tmp = c[ i ];
            c[ i ] = c[ j ];
            c[ j ] = tmp;
    }
    //******************************************************************************
    // DSU
    //Maintain an Array A with N elements and Array size for size of each set, intialize A[i]=i and size[i]=1

    static int root(int A[],int i){
        while(A[i]!=i){
            A[i]=A[A[i]];
            i=A[i];
        }
        return i;
    }

    static boolean find(int A[],int a,int b){
        if(root(A,a)==root(A,b))return true;
        else return false;
    }

    static void union(int A[],int size[],int a,int b){
        int ra=root(A,a);
        int rb=root(A,b);

        if(ra==rb)return;

        if(size[ra]<size[rb]){
            A[ra]=A[rb];
            size[rb]+=size[ra];
        }else{
            A[rb]=A[ra];
            size[ra]+=size[rb];
        }
    }

    //**************************************************************************
    //BinarySearch
    /* binary search for 5:
                v-- lower bound
         1 2 3 4 5 5 5 6 7 9
                      ^-- upper bound
        
            binary search for 8
                        v-- lower bound
       1 2 3 4 5 5 5 6 7 9
                        ^-- upper bound
    */
    //For finding greater than 
    static int upper_bound(int A[],int key){
        int first = 0;
        int last = A.length;
        int mid;

        while (first < last) {
            mid =first+(last - first)/2; 

            if (A[mid] <= key)  
                first = mid + 1; 
            else 
                last = mid;
        }

        return first;
    }
    
    //For finding greater than equal to
    static int lower_bound(int A[],int key){
        int first = 0;
        int last = A.length;
        int mid=0;
        
        while (first < last) {
            mid = first + ((last - first) >> 1); 
            if (A[mid] < key)  
                first = mid + 1; 
            else 
                last = mid;
        }
        
        return first;
    }
    //**************************************************************************
}
