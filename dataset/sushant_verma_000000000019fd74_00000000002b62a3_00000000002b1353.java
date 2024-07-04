import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
	    Reader.init(System.in);
	    int t = Reader.nextInt();
	    for (int i = 1 ; i<= t ; i++){
            System.out.println("Case #" + i + ": ");
            solve();
        }
    }
    static int N = 50000 + 100;
    static int[][] trie;
    static int[][]cnt;
    static boolean[] finish;
    static int nxt = 1;
    static int ans = 0;
    static void addString(char[] s)
    {
        int node = 0;
        for(int i = s.length-1; i > 0; i--)
        {
            cnt[node][s[i]-'a']++;
            if (trie[node][s[i]-'a']==0) {
                trie[node][s[i] - 'a'] = nxt++;
            }
            node = trie[node][s[i] - 'a'];
        }
        finish[node] = true;
    }
    static boolean findString(char[] s)
    {
        int node = 0;
        for(int i = 0; i < s.length; i++)
        {
            if(trie[node][s[i] - 'a']>0) return false;
            node = trie[node][s[i] - 'a'];
        }
        return finish[node];
    }
    static boolean check(char[] s){
        int node = 0;
        for(int i = s.length-1; i > 0; i--)
        {
            for (int j = 0 ; j < 26 ; j++){
                if (j!=s[i]-'a'){
                    if (cnt[node][j]>0){
                        return false;
                    }
                }
            }
            node = trie[node][s[i] - 'a'];
        }
        return true;
    }

    public static void solve() throws IOException {
        int n = Reader.nextInt();
        int a1 = 2;
        int a2 = 1;
        long sum = 0;
        int num = 1;
        System.out.println("1 1");
        if (n==1){
            return;
        }
        System.out.println("2 1");
        if (n==2){
            return;
        }
        sum = 2;
        num = 2;
        for (int i = 0 ; i < 498 ; i++){
            int to = num;
            if (to > n-sum){
                for (int j = 0 ; j < n-sum ; j++){
                    System.out.println((a1+1) + " " + 1);
                    a1++;
                }
                return;
            }
            else{
                System.out.println(a1 + " " + 2);
                a1++;
                sum+=num;
                if (sum==n){
                    return;
                }
                num++;
            }
        }
    }








    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);

    }
    public static void sortbyColumn(int arr[][], int col)
    {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(final int[] entry1,
                               final int[] entry2) {

                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]

    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method

}
