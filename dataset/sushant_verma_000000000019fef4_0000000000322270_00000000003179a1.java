
import org.omg.PortableInterceptor.INACTIVE;
import sun.awt.windows.ThemeReader;

import javax.print.DocFlavor;
import java.io.*;

import java.sql.SQLOutput;
import java.util.*;


public class Solution {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int t = Reader.nextInt();
        PrintWriter out = new PrintWriter(System.out);
//        int t = 1;
        for (int i = 1 ; i<= t ; i++){
            out.print("Case #" + i + ": ");
            solve(out);
        }
        out.close();
    }
    static class Pair{
        int a;
        String b;

        public Pair(int a, String b) {
            this.a = a;
            this.b = b;
        }
    }
    static void solve(PrintWriter out)throws IOException{
        int u = Reader.nextInt();
        TreeSet<String> arr[] = new TreeSet[100];
        for (int i = 0 ; i < 100 ; i++){
            arr[i] = new TreeSet<>();
        }
        TreeSet<Character> zero = new TreeSet<>();
        for (int i = 0 ; i < 10000 ; i++){
            int q = Reader.nextInt();
            String r = Reader.next();
            for (int j = 0 ; j < r.length() ; j++){
                zero.add(r.charAt(j));
            }
            arr[q].add(r);
        }
        char[] ans = new char[10];
        LinkedList<String> lmao = new LinkedList<>();
        for (int i = 1 ; i < 10 ; i++){
            if(i==1){
                ans[1] = arr[i].first().charAt(0);
                lmao.add(arr[i].first());
            }
            else{
                Iterator j = lmao.iterator();
                while (j.hasNext()){
                    String nxt = (String)j.next();
                    arr[i].remove(nxt);
                }
                ans[i] = arr[i].first().charAt(0);
                lmao.add(arr[i].first());
            }
        }
        for (int i= 1 ; i < 10 ; i++){
            zero.remove(ans[i]);
        }
        ans[0] = zero.first();
        out.println(String.valueOf(ans));








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