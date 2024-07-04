import java.io.*;
import java.util.*;

/**
 *  Class should be renamed to Solution when submitting.
 *  @author Ivan Pryvalov (ivan.pryvalov@gmail.com)
 */
public class Solution implements Runnable {

    static EventType eventType = EventType.GOOGLE_CODE_JAM; //EventType.GOOGLE_CODE_JAM;
    static boolean interactive = false; //use outGlobal.println()   and   outGlobal.flush()
    static int T = 0; // T \in {0,1}. If T=0, it will be read from the input.
    static String inputFilename = null;//"A_example.txt"; // if 'null', it reads data from std-in.

    static boolean largeFakeTest = false; // Check if you generate data on fly
    static int largeFakeTest_T = 1;
    //--------------------------------------------------------------------



    public static class Solver extends  SolverAbstract{

        int X, Y;

        @Override
        public void readInput() throws IOException {
            X = scanner.nextInt();
            Y = scanner.nextInt();
        }

        boolean match2(long a, long b){
            return (a>>1)%2 != (b>>1)%2;
        }

        @Override
        protected void solve() throws IOException {
            long A = X;
            long B = Y;

            StringBuilder sb = new StringBuilder();

            boolean revA = false;
            boolean revB = false;
            if (A<0){
                A = -A;
                revA = !revA;
            }
            if (B<0){
                B = -B;
                revB = !revB;
            }

            while(A!=0 && B!=0){
                if (A%2 == B%2){
                    out.println("IMPOSSIBLE");
                    return;
                }else{
                    if (A%2==1){
                        if (match2(A-1,B)){
                            A = A-1;
                            sb.append(revA? 'W': 'E');
                        }else{
                            A = A+1;
                            sb.append(revA? 'E': 'W');
                        }
                    }else { //if (B%2==1){
                        if (match2(A,B-1)){
                            B = B-1;
                            sb.append(revB? 'S':'N');
                        }else{
                            B = B+1;
                            sb.append(revB? 'N':'S');
                        }
                    }
                    A >>= 1;
                    B >>= 1;
                }
            }
            if (A!=0){
                char ch = revA? 'W': 'E';
                while(A>0){
                    sb.append(ch);
                    A>>=1;
                }
            }
            if (B!=0){
                char ch = revB? 'S':'N';
                while(B>0){
                    sb.append(ch);
                    B>>=1;
                }
            }
            out.println(sb.toString());
        }

    }

    //--------------------------------------------------------------------

    private void solveAll() throws IOException {
        long timeStart = System.currentTimeMillis();
        if (T==0) {
            if (largeFakeTest) {
                T = largeFakeTest_T;
            } else {
                T = scanner.nextInt();
            }
        }
        final String[] results = new String[T+1];
        for (int test = 0; test < T; test++) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream outLocal = new PrintStream(baos);
            Solver solver = new Solver(){
                @Override
                public void callback() {
                    results[testNo] = answer;
                }
            };
            solver.out = outLocal;
            solver.testNo = test+1;
            if (largeFakeTest) {
                solver.readFakeInput();
            }else{
                solver.readInput();
            }
            solver.solveWrapped(baos);
        }

        long timeEnd = System.currentTimeMillis();
        if (isInputFromFile())
            System.out.println("All tasks are solved! Elapsed time "+(timeEnd-timeStart)/1000.0+" sec.");

        // write all responses in the proper order
        if (!interactive) {
            for (int i = 1; i <= T; i++) {
                if (eventType == EventType.GOOGLE_CODE_JAM) {
                    outGlobal.printf("Case #%d: %s", i, results[i]);
                } else {
                    outGlobal.print(results[i]);
                }
            }
        }
    }

    enum EventType{
        DEFAULT,
        GOOGLE_CODE_JAM
    }

    static boolean isInputFromFile() {
        return inputFilename != null;
    }

    public static abstract class SolverAbstract {
        PrintStream out;
        int testNo;
        String answer = null;

        public void callback(){};

        public abstract void readInput() throws IOException;

        //generate a randomized test with the maximal input values
        public void readFakeInput() throws  IOException{
            throw new RuntimeException("not implemented");
        }

        protected abstract void solve() throws IOException;

        protected void solveWrapped(ByteArrayOutputStream baos) throws IOException {
            if (isInputFromFile())
                System.out.println("SOLVER: solving task #"+testNo+" out of "+ T+"...");
            solve();
            answer = baos.toString();
            if (isInputFromFile()) {
                System.out.println("\t"+answer);
            }
            callback();
        }
    }

    ////////////////////////////////////////////////////////
    // Link about multithreading: http://stackoverflow.com/questions/4521983/java-executorservice-that-blocks-on-submission-after-a-certain-queue-size


    // ------------- Some stardard tools that are currently not tested.
    //adopt for the lists of adjacent vertices
    static class Graph{

        int[][] G;
        int N;

        int[][] A;
        int[][] F;

        int[] path;
        int pathLen;
        boolean[] visited;
        int target;
        boolean flowFound;

        public Graph(int[][] g) {
            G = g;
            N = G.length;
        }

        public int[][] maxflow(int iSource, int iSink) {
            path = new int[N];
            visited = new boolean[N];

            A = new int[N][];
            for (int i = 0; i < N; i++) {
                A[i] = G[i].clone();
            }
            F = new int[N][N];

            target = iSink;
            //dfs from source to sink
            //increase path
            while(true){
                flowFound = false;
                visited[iSource] = true;
                pathLen = 0;
                path[pathLen++] = iSource;
                dfs(iSource);
                if (!flowFound)
                    break;
            }
            return F;
        }

        private void dfs(int u) {
            if (u==target){
                flowFound = true;
                for (int i = 0; i < pathLen-1; i++) {
                    int from = path[i];
                    int to  = path[i+1];
                    F[from][to]++;
                    F[to][from]--;
                }
            }else {
                for (int i = 0; i < N && !flowFound; i++) {
                    if (!visited[i] && A[u][i] > F[u][i]) {
                        visited[i] = true;
                        path[pathLen] = i;
                        pathLen++;
                        dfs(i);
                        visited[i] = false;
                        pathLen--;
                    }
                }
            }
        }
    }

    public static class Utilities{
        public static List<Integer> getPrimes(int limit) {
            boolean[] primes = new boolean[limit+1];
            Arrays.fill(primes, true);

            primes[1] = false;
            for(int i=2; i<=limit; i++){
                if (primes[i]){
                    for(int j=i+i; j<=limit; j+=i){
                        primes[j] = false;
                    }
                }
            }
            List<Integer> listPrimes = new ArrayList<>();
            for(int i=2; i<=limit; i++){
                if (primes[i]){
                    listPrimes.add(i);
                }
            }
            return listPrimes;
        }
    }

    public static class Modulo{
        long mod = (long)1e9+7;

        public Modulo(long mod) {
            super();
            this.mod = mod;
        }

        public long inv(long a) {
            long res =  pow(a, mod-2);
            return res;
        }

        public long pow(long a, long x) {
            if (x==0)
                return 1;
            long part = 1;
            if ((x&1)!=0)
                part = a;
            return (part * pow((a*a)%mod, x>>1)) % mod;
        }

        public long c(long n, long m){
            long res = 1;
            for(int i=1; i<=m; i++){
                res = (res * (n-m+i)) % mod;
                res = (res * inv(i)) % mod;
            }
            return res;
        }
    }

    /**
     * Added 26.04.2013.
     * See KROK 2013, Round 1, Problem D.
     */
    static class DisjointUnionSet implements Cloneable{
        int[] rank;
        int[] parent;

        protected DisjointUnionSet clone(){
            DisjointUnionSet cloned = new DisjointUnionSet(parent.length);
            for(int i=0; i<parent.length; i++){
                cloned.parent[i] = parent[i];
                cloned.rank[i] = rank[i];
            }
            return cloned;
        }

        public DisjointUnionSet(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        @Override
        public String toString() {
            return "disj [parents=" + Arrays.toString(parent) + "]";
        }

        /**
         * Problem specific or general?
         * O(N * alpha)
         */
        public void union(DisjointUnionSet set2){
            for(int i=0; i<parent.length; i++){
                parent[find(i)] = parent[find(set2.find(i))];
            }
        }

        /**
         * @param index1 range 0..n-1
         * @param index2
         */
        public void union(int index1, int index2){
            int p1 = find(index1);
            int p2 = find(index2);
            if (rank[p1] > rank[p2]){
                parent[p2] = p1;
            }else if (rank[p2] > rank[p1]){
                parent[p1] = p2;
            }else{
                parent[p2] = p1;
                rank[p1]++;
            }
        }

        // O(alpha(n))
        private int find(int index) {
            if (parent[index] != index)
                parent[index] =  find(parent[index]);
            return parent[index];
        }

        // O(N alpha(N)) ==> see find()
        public int getCountDisjointSets(){
            int[] used = new int[parent.length];
            for(int i=0; i<parent.length; i++){
                used[find(i)] = 1;
            }
            int res = 0;
            for(int i=0; i<parent.length; i++){
                res += used[i];
            }
            return res;
        }
    }

    private static Random rnd = new Random();
    public static class ArrayUtils{
        public static void shuffle(int[] a){
            for(int j=a.length-1; j>=1; j--){
                int i = rnd.nextInt(j+1);
                swap(a, i, j);
            }
        }

        public static void swap(int[] a, int i, int j){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    static class GraphSupport{
        /*
        //Added 20.02.2017.
        //See Codeforces Round 398, Div.2, C.
        // Recoursive call to dfs function may result in either MTL or StackOverflow.
        // Codeforces provide stacksize 64M
 
        private void dfs_no_recursion(int root, IntConsumer dfs_post){
            int[] stack = new int[N];
            int[] stackInt = new int[N];
            int iStack = 0;
            stack[iStack] = root;
            stackInt[iStack++] = 0;
            while(true){
                Node node = nodes[stack[iStack-1]];
                int childIdx = stackInt[iStack-1];
                if (childIdx < node.children.size()){
                    stack[iStack] = node.children.get(childIdx).idx;
                    stackInt[iStack++] = 0;
                }else{
                    dfs_post.accept(node.idx);
 
                    iStack--;
                    if (iStack==0){
                        break;
                    }
                    stackInt[iStack-1]++;
                }
            }
        }
        */
    }


    ////////////////////////////////////////////////////////
    /// Typically, you don't want to edit anything below
    ///////////////////////////////////////////////////////
    final int BUF_SIZE = 1024 * 1024 * 8;//important to read long-string tokens properly
    final int INPUT_BUFFER_SIZE = 1024 * 1024 * 8;
    final int BUF_SIZE_INPUT = 1024;

    boolean useClassResourceTopDir = true;
    String outSuffix = ".out";

    static PrintStream outGlobal;
    static ByteScanner scanner;

    public void run() {
        try{
            InputStream bis;
            OutputStream bos;
            if (inputFilename !=null){
                File inputFile;
                File outputFile;
                if (useClassResourceTopDir) {
                    File baseFile = new File(getClass().getResource("/").getFile());
                    inputFile = new File(baseFile, inputFilename);
                    outputFile = new File(baseFile, inputFilename +outSuffix);
                }else{
                    inputFile = new File(inputFilename);
                    outputFile = new File(inputFilename +outSuffix);
                }
                System.out.println("Input file canonical path: "+inputFile.getCanonicalPath());
                bis = new BufferedInputStream(
                        new FileInputStream(inputFile),
                        INPUT_BUFFER_SIZE);
                bos = new BufferedOutputStream(new FileOutputStream(outputFile));
                outGlobal = new PrintStream(bos);
            }else{
                bis = new BufferedInputStream(System.in, INPUT_BUFFER_SIZE);
                bos = new BufferedOutputStream(System.out);
                outGlobal = new PrintStream(bos);
            }
            scanner = new ByteScanner(bis, BUF_SIZE_INPUT, BUF_SIZE);

            solveAll();
            outGlobal.flush();
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static class EofException extends IOException{
    }

    public static class ByteScanner{
        InputStream is;

        public ByteScanner(InputStream is, int bufSizeInput, int bufSize){
            this.is = is;
            this.bufSizeInput = bufSizeInput;
            this.bufSize = bufSize;

            byteBufInput = new byte[this.bufSizeInput];
            byteBuf = new byte[this.bufSize];
        }

        public ByteScanner(byte[] data){
            byteBufInput = data;
            bufSizeInput = data.length;
            bufSize = data.length;
            byteBuf = new byte[bufSize];
            byteRead = data.length;
            bytePos = 0;
        }

        private int bufSizeInput;
        private int bufSize;

        byte[] byteBufInput;
        byte by=-1;
        int byteRead=-1;
        int bytePos=-1;

        byte[] byteBuf;
        int totalBytes;

        boolean eofMet = false;

        private byte nextByte() throws IOException{
            if (bytePos<0 || bytePos>=byteRead){
                byteRead = is==null? -1: is.read(byteBufInput);
                bytePos=0;
                if (byteRead<0){
                    byteBufInput[bytePos]=-1;//!!!
                    if (eofMet)
                        throw new EofException();
                    eofMet = true;
                }
            }
            return byteBufInput[bytePos++];
        }

        public byte nextVisibleChar() throws IOException{
            while ((by=nextByte())<=0x20);
            return by;
        }

        public String nextLine() throws IOException {
            readToken((byte)0x20);
            return new String(byteBuf,0,totalBytes);
        }

        // Reads token. Spacebar is separator char.
        public String nextToken() throws IOException {
            readToken((byte)0x21);
            return new String(byteBuf,0,totalBytes);
        }

        // Spacebar is included as separator char
        private void readToken() throws IOException {
            readToken((byte)0x21);
        }

        private void readToken(byte acceptFrom) throws IOException {
            totalBytes = 0;
            while ((by=nextByte())<acceptFrom);
            byteBuf[totalBytes++] = by;
            while ((by=nextByte())>=acceptFrom){
                byteBuf[totalBytes++] = by;
            }
        }

        public int nextInt() throws IOException{
            readToken();
            int num=0, i=0;
            boolean sign=false;
            if (byteBuf[i]=='-'){
                sign = true;
                i++;
            }
            for (; i<totalBytes; i++){
                num*=10;
                num+=byteBuf[i]-'0';
            }
            return sign?-num:num;
        }

        public long nextLong() throws IOException{
            readToken();
            long num=0;
            int i=0;
            boolean sign=false;
            if (byteBuf[i]=='-'){
                sign = true;
                i++;
            }
            for (; i<totalBytes; i++){
                num*=10;
                num+=byteBuf[i]-'0';
            }
            return sign?-num:num;
        }

        public double nextDouble() throws IOException{
            readToken();
            char[] token = new char[totalBytes];
            for (int i = 0; i < totalBytes; i++) {
                token[i] = (char)byteBuf[i];
            }
            return Double.parseDouble(new String(token));
        }

        public int[] loadIntArray(int size) throws IOException{
            int[] a = new int[size];
            for (int i = 0; i < a.length; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public long[] loadLongArray(int size) throws IOException{
            long[] a = new long[size];
            for (int i = 0; i < a.length; i++) {
                a[i] = nextLong();
            }
            return a;
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}