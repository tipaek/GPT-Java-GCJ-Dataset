/*
**  q2 2020 for problem
**  
*/

import  java.lang.*;
import  java.io.*;
import  java.util.*;
import java.text.DecimalFormat;
import  java.math.BigInteger;

class Solution extends codejam {


    public static void main(String[] av) throws Exception {

        Solution t = new Solution();
        t.solve();
        System.exit(0);

    }

    String buf;
    int    buf_p=0;

    static int maxK=100000000;
    static int maxN=30;

    static int maxSize=1000;

    boolean bitK[] = new boolean[maxK];

    int n, v[];
    int i1, i2, i3;
    int n1, n2, n3;
    int v1[], v2[], v3[];
    long l1, l2, l3;
    long lv[], lv1[], lv2[], lv3[];
    String s, s1, s2;
    String sarr[], s1arr[], s2arr[];
    HashMap<String, String> hss, hss1, hss2;
    HashMap<String, Integer> hsi, hsi1, hsi2;
    HashMap<Integer, Integer> hii, hii1, hii2;

    public void initialize() throws Exception {
    }

    public void wrapup() throws Exception {
    }
	    
    public void process() throws Exception {
	

        int numtests = getInt();

        for( int nt=1; nt <= numtests; nt++ ) {

            // System.err.print("Case #" + nt + ": ");
/****
    one line of input per test case
***/

    /* one line with <int> */
            // n =  getInt();
    /* one line with number of ints <int>  */
            // v = getInts();
    /* one line with string */
            buf = getString();
    /* one line with strings */
            // bufarr = getStrings();
    /* one line with <int> <string> */
            // n = getNextInt();
            // buf = getNext();
            // nextLine();  // skip the rest


/****
    two lines of input per test case

    n =  getInt();  
    buf = getString();

    int a[] = getInts();
    n1 = a[0];
    n2 = a[1];
    v1 = getInts();

****/

/****

    3 lines of input per test case
    int a[] = getInts();
    n1 = a[0];
    n2= a[1];

    v1 = getInts();
    v2 = getInts();
****/



            String val = compute();
            // System.err.println(val);
            println("Case #" + nt + ": " +  val);
            flush();
            
        }

    }


    public String compute() {

        int level = 0;
        
        init_state();

       char[] inpA = buf.toCharArray();
       StringBuffer sb = new StringBuffer();

       for( int i=0; i< buf.length(); i++ ) {

            int x = Character.digit(inpA[i],10);
            //System.err.print("L="+ level+ " val="+ x);
            if( level < x ) {
                    addLevel(sb, x-level);
                    //System.err.print(" add-"+ (x-level));
                    level += (x-level);
            } else if ( level > x ) {
                    removeLevel(sb, level-x);
                    //System.err.print(" remove-"+ (level-x));
                    level -= (level-x);
            }
            //System.err.println(" L="+ level);
           
            // pop
            sb.append(inpA[i]);
        }
        removeLevel(sb, level);


        return sb.toString();

    }

    public void addLevel(StringBuffer sb, int delta ) {

        for( int i=0; i< delta; i++ ) {
            sb.append("(");
        }
        
    }

    public void removeLevel(StringBuffer sb, int delta ) {

        for( int i=0; i< delta; i++ ) {
            sb.append(")");
        }
        
    }

    public void init_state() {
        /*****
            for( int i=0; i<n; i++ ) {
                bitK[i] = ((k&1) == 1);
                k >>== 1;
            }
        *****/
    }

}



/*
    codejam base class

  int   32bit     -2,147,483,648        2,147,483,647            
                    10**9
  long  64bit   -9,223,372,036,854,775,808  9,223,372,036,854,775,807 
                   -2**63, (2**63)-1
                   10**18, 
                    
  float 32bit
  double 64

*/

class codejam {

    Scanner        inpScanner;
    BufferedReader br;
    PrintWriter    outp;
    boolean        useScanner = false;
    boolean        useStdio = false;
	    
    
    public void solve(String[] av) throws Exception {
            solve(av, true);
    }

    public void solve(String[] av, boolean scanner) throws Exception {
            solve(av, scanner, "\\s+");
    }

    public void solve() throws Exception {    // use Stdin, stdout
        long st = System.currentTimeMillis();

        useScanner = false;
        useStdio = true;
        BufferedReader tmpInp = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter tmpOut =  new PrintWriter(System.out);
        solveExt(tmpInp, tmpOut, null);

    }

    public void solve(String[] av, boolean scanner, String delim) throws Exception {

        long st = System.currentTimeMillis();

        useScanner = scanner;
        useStdio = false;

        BufferedReader tmpInp = null;
        Scanner     tmpScanner = null;

        if(useScanner) {
	        tmpScanner = new Scanner(new File(av[0])).useDelimiter(delim);	
        } else {
            tmpInp = new BufferedReader(new FileReader(av[0]));
        }
        PrintWriter tmpOut =   new PrintWriter(av[0] + ".out");

        solveExt(tmpInp, tmpOut, tmpScanner);

    }

    private void solveExt(BufferedReader inpReader, PrintWriter outWriter, Scanner inpS) throws Exception {

        long st = System.currentTimeMillis();

        if(useScanner) {
	        inpScanner = inpS;
        } else {
            br = inpReader;
        }
	    outp = outWriter;

        initialize();
        process();
        wrapup();

        flush();
        outp.close();
        if(useScanner) {
            inpScanner.close();
        } else {
            if(!useStdio) br.close();
        }

        long et = System.currentTimeMillis();
        // System.err.println("time= " + (et-st) + " ms");

    }

    public void initialize() throws Exception {};
    public void process() throws Exception {};
    public void wrapup() throws Exception {};

	
    public void flush() {
        outp.flush();
    }

    public void print(char c) {
        outp.print(c);
    }

    public void print(String s) {
        outp.print(s);
    }

    public void println(String s) {
        outp.println(s);
    }

    public void print(Double d) {
        outp.printf("%.09f", d);
    }

    public void println(Double d) {
        outp.printf("%.09f%n", d);
    }

    public int getInt() throws Exception {
        if(useScanner) {
            return inpScanner.nextInt();
        } else {
            return Integer.parseInt(br.readLine());
        }
    }

    public int[] getInts()  throws Exception {

        if( useScanner ) {
            throw new Exception("cant call getints");
        } else {
            String [] temp = br.readLine().split("\\s+");

            int[] ret= new int[temp.length];

            for( int j=0; j < ret.length; j++ ) {
               ret[j] = Integer.parseInt(temp[j]);
            }
            return ret;
        }

    }


    public long getLong() throws Exception {
        if(useScanner) {
            return inpScanner.nextLong();
        } else {
            return Long.parseLong(br.readLine());
        }
    }

    public long[] getLongs()  throws Exception {

        if( useScanner ) {
            throw new Exception("cant call getints");
        } else {
            String [] temp = br.readLine().split("\\s+");

            long[] ret= new long[temp.length];

            for( int j=0; j < ret.length; j++ ) {
               ret[j] = Long.parseLong(temp[j]);
            }
            return ret;
        }

    }


    public String getString()  throws Exception {

        if( useScanner ) {
            throw new Exception("cant call getString");
        } else {
            return br.readLine();
        }

    }

    public String[] getStrings()  throws Exception {

        if( useScanner ) {
            throw new Exception("cant call getStrings");
        } else {
            String [] temp = br.readLine().split("\\s+");
            return temp;
        }

    }

    public HashMap<String, String> getHashMapSS(int size)  throws Exception {

        if( useScanner ) {
            throw new Exception("cant call getHashMapSS");
        } else {
            HashMap<String, String> hss = new HashMap<String, String>();
            for( int i=0; i<size; i++ ) {
                String s1 = getString();
                hss.put(s1,s1);
            }
            return hss;
        }
    }

    public HashMap<Integer, Integer> getHashMapII(int size)  throws Exception {

        if( useScanner ) {
            throw new Exception("cant call getHashMapII");
        } else {
            HashMap<Integer, Integer> hii = new HashMap<Integer, Integer>();
            for( int i=0; i<size; i++ ) {
                Integer tmpi = new Integer(getInt());
                hii.put(tmpi,tmpi);
            }
            return hii;
        }
    }


    public HashMap<String, Integer> getHashMapSI(int size)  throws Exception {

        if( useScanner ) {
            throw new Exception("cant call getHashMapSI");
        } else {
            HashMap<String, Integer> hsi = new HashMap<String, Integer>();
            for( int i=0; i<size; i++ ) {
                String ss[] = getStrings();
                Integer tmpi = new Integer(ss[1]);
                hsi.put(ss[0],tmpi);
            }
            return hsi;
        }
    }



    public long getNextLong()  throws Exception {

        if( useScanner ) {
            return inpScanner.nextLong();
        } else {
            throw new Exception("cant call getNextXXX");
        }

    }

    public int getNextInt()  throws Exception {

        if( useScanner ) {
            return inpScanner.nextInt();
        } else {
            throw new Exception("cant call getNextXXX");
        }

    }

    public String getNext()  throws Exception {

        if( useScanner ) {
            return inpScanner.next();
        } else {
            throw new Exception("cant call getNextXXX");
        }

    }

    public String nextLine()  throws Exception {

        if( useScanner ) {
            return inpScanner.nextLine();
        } else {
            throw new Exception("cant call getNextXXX");
        }

    }


    public void D(String s) {
        System.err.println(s);
    }


}
