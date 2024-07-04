
//-------------------------------------------------------------------------------------------------------
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution implements Runnable {
	private final static long START_TIME=System.currentTimeMillis();

	private final static boolean USE_FILES=false;
	private final static File FILE_DIR=new File("D:/");
	private final static File IN_FILE=new File(FILE_DIR,"in.txt");
	private final static File OUT_FILE=new File(FILE_DIR,"out.txt");


	private final static boolean LOG_ENABLED=true;
	private final static boolean ONLINE_JUDGE = (System.getenv("LOCAL_JUDGE") == null);
	private final static String SYSTEM_ENCODING="utf-8";
	private final static int DEFAULT_BUFFER_SIZE=256*256;


	private static class Logger{
		private final PrintWriter logWriter=Util.newPrintWriter(System.err,true);
		private final DecimalFormat df=new DecimalFormat("0.000");
		private void message(String type, String message, Object ... params){
			if(ONLINE_JUDGE || !LOG_ENABLED){
				return;
			}
			logWriter.printf("["+type+"] "+df.format((System.currentTimeMillis()-START_TIME)/1000.0)+": "+message+"\r\n", params);
		}
		public void debug(String message, Object ... params){
			message("DEBUG", message, params);
		}
	}

	interface PermutationVisitor<T>{
		void visit(T [] permutation);
	}

	public final static class Util{
		public final static String LINE_SEPARATOR=System.getProperty("line.separator");
		public static PrintWriter newPrintWriter(OutputStream out, boolean autoFlush){
			try {
				return new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(out), SYSTEM_ENCODING),autoFlush);
			} catch (UnsupportedEncodingException e) {
				throw new IllegalStateException(e);
			}
		}

		public static PrintWriter newPrintWriter(Writer writer, boolean autoFlush){
			return new PrintWriter(writer,autoFlush);
		}


		private static void flushStringBuilder(Writer writer, StringBuilder sb) throws IOException {
			if(sb.length()>DEFAULT_BUFFER_SIZE){
				writer.append(sb);
				sb.setLength(0);
			}
		}

		public static void printArray(Writer writer, String separator, Object ... elements) throws IOException{
			StringBuilder sb = new StringBuilder();
			boolean first=true;
			for(Object o:elements){
				if(first){
					first=false;
				}else{
					sb.append(separator);
				}
				sb.append(o);
				flushStringBuilder(writer, sb);
			}
			sb.append(LINE_SEPARATOR);
			writer.append(sb);
		}
		public static void printArray(Writer writer, String separator, int ... elements) throws IOException{
			StringBuilder sb = new StringBuilder();
			boolean first=true;
			for(Object o:elements){
				if(first){
					first=false;
				}else{
					sb.append(separator);
				}
				sb.append(o);
				flushStringBuilder(writer, sb);
			}
			sb.append(LINE_SEPARATOR);
			writer.append(sb);
		}

		public static long getElement(long[] array,int index, long outOfBoundsValue){
			if(index<0 || index>=array.length){
				return outOfBoundsValue;
			}
			return array[index];
		}
		public static char getElement(char[] array,int index, char outOfBoundsValue){
			if(index<0 || index>=array.length){
				return outOfBoundsValue;
			}
			return array[index];
		}

		public static int getElement(int[] array,int index, int outOfBoundsValue){
			if(index<0 || index>=array.length){
				return outOfBoundsValue;
			}
			return array[index];
		}

		public static double getElement(double[] array,int index, double outOfBoundsValue){
			if(index<0 || index>=array.length){
				return outOfBoundsValue;
			}
			return array[index];
		}

		public static <T> T firstNotNull(T value1, T value2){
			if(value1!=null){
				return value1;
			}
			if(value2!=null){
				return value2;
			}
			throw new NullPointerException("All values are nulls");
		}

		public static long max(long... values){
			long result=values[0];
			for(int i=1,n=values.length;i<n;i++){
				long currentValue = values[i];
				if(result<currentValue){
					result=currentValue;
				}
			}
			return result;
		}
		public static double max(double... values){
			double result=values[0];
			for(int i=1,n=values.length;i<n;i++){
				double currentValue = values[i];
				if(result<currentValue){
					result=currentValue;
				}
			}
			return result;
		}
		public static long min(long... values){
			long result=values[0];
			for(int i=1,n=values.length;i<n;i++){
				long currentValue = values[i];
				if(result>currentValue){
					result=currentValue;
				}
			}
			return result;
		}
		public static double min(double... values){
			double result=values[0];
			for(int i=1,n=values.length;i<n;i++){
				double currentValue = values[i];
				if(result>currentValue){
					result=currentValue;
				}
			}
			return result;
		}

		public static <T> void visitAllPermutations(T[] array, PermutationVisitor<T> permutationVisitor) {
			visitAllPermutations(array, 0, permutationVisitor);
		}
		private static <T> void visitAllPermutations(T[] arr, int index, PermutationVisitor<T> permutationVisitor) {
			if(index==arr.length-1){
				permutationVisitor.visit(arr);
			}else{
				for(int i=index;i<arr.length;i++){
					T tmp = arr[index];
					arr[index]=arr[i];
					arr[i]=tmp;
					visitAllPermutations(arr,index+1,permutationVisitor);
				}
				T last=arr[index];
				for(int i=index;i<arr.length-1;i++){
					arr[i]=arr[i+1];
				}
				arr[arr.length-1]=last;
			}
		}
		public static long euclideanAlgorithm(long n1, long n2) {
			long max = Math.max(n1, n2);
			long min = Math.min(n1, n2);
			while(min>0){
				long r = max%min;
				max=min;
				min=r;
			}
			return max;
		}
	}

	public final static class FastScanner{
		private BufferedReader reader;
		private StringTokenizer currentTokenizer;
		public FastScanner(Reader reader) {
			if(reader instanceof BufferedReader){
				this.reader=(BufferedReader) reader;
			}else{
				this.reader=new BufferedReader(reader);
			}
		}

		public String nextString(){
			if(currentTokenizer==null || !currentTokenizer.hasMoreTokens()){
				try {
					String line;
					while((line=reader.readLine()).isEmpty()){
						log.debug("Empty line has been skipped");
						continue;
					}
					log.debug("Input line has been read:'%s'", line);
					currentTokenizer=new  StringTokenizer(line);
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			}
			return currentTokenizer.nextToken();
		}

		public String[] nextStrings(int n){
			String[] result=new String[n];
			for(int i=0;i<n;i++){
				result[i]=nextString();
			}
			return result;
		}


		public int nextInt(){
			return Integer.parseInt(nextString());
		}
		public int[] nextInts(int n){
			int[] result=new int[n];
			for(int i=0;i<n;i++){
				result[i]=nextInt();
			}
			return result;
		}

		public long nextLong(){
			return Long.parseLong(nextString());
		}

		public long[] nextLongs(int n){
			long[] result=new long[n];
			for(int i=0;i<n;i++){
				result[i]=nextLong();
			}
			return result;
		}


		public double nextDouble(){
			return Double.parseDouble(nextString());
		}

		public double[] nextDoubles(int n){
			double[] result=new double[n];
			for(int i=0;i<n;i++){
				result[i]=nextDouble();
			}
			return result;
		}


	}
	public final static class MultidimensionalArrayHelper{
		private final int[] dimensions;
		private final int size;
		public MultidimensionalArrayHelper(int ...dimensions) {
			this.dimensions=dimensions;
			int s=1;
			for(int dimension:dimensions){
				s*=dimension;
			}
			this.size=s;
		}
		public int index(int ... indexes){
			int n=indexes.length;
			int index=0;
			for(int i=n-1;i>0;i--){
				index=(index+indexes[i])*dimensions[i-1];
			}
			index+=indexes[0];
			return index;
		}

		public int size() {
			return size;
		}
	}


	private final static Logger log=new Logger();
	private final BufferedReader reader;
	private final FastScanner in;
	private final PrintWriter out;


	public Solution(Reader reader, Writer writer){
		this.reader=new BufferedReader(reader,DEFAULT_BUFFER_SIZE);
		this.out=new PrintWriter(new BufferedWriter(writer, DEFAULT_BUFFER_SIZE),false);
		in=new FastScanner(this.reader);
	}

	public static void main(String[] args) throws IOException {
		if(USE_FILES){
			OUT_FILE.delete();
		}

		try(InputStream input=USE_FILES?new FileInputStream(IN_FILE):System.in;
				OutputStream outputStream=USE_FILES?new FileOutputStream(OUT_FILE):System.out;){
			new Solution(
					new InputStreamReader(input, SYSTEM_ENCODING),
					new OutputStreamWriter(outputStream, SYSTEM_ENCODING)).run();
		}
	}

	@Override
	public void run(){
		log.debug("Started");
		try{
			try {
				solveAll();
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
			out.flush();
		}finally{
			log.debug("Stopped");
		}
	}

	private void solveAll() throws Exception{
		int t = in.nextInt();
		int b = in.nextInt();
		for(int i=0;i<t;i++) {
			log.debug("================================ Task#%s====================", i+1);
			solve(b);
		}
	}

	private void solve(int b) {
		BitSet bits=new FixedSizeBitSet(b);
		int group00=-1;
		int group01=-1;
		Boolean[] isSame=new Boolean[b/2];

		int solvedPairs=0;
		int queryCount=1;
		while(solvedPairs<b/2) {
			log.debug("Query count %s",queryCount);
			if(queryCount%10==1) {
				queryCount+=checkGroops(group00,group01,isSame,bits,solvedPairs);
			}
			boolean bit1 = ask(solvedPairs);
			if(queryCount%10==0) {
				queryCount++;
				continue;
			}
			boolean bit2 = ask(b-solvedPairs-1);
			bits.set(solvedPairs,bit1);
			bits.set(b-solvedPairs-1,bit2);
			if(bit1==bit2) {
				if(group00==-1) {
					group00=solvedPairs;
				}
				isSame[solvedPairs]=true;
			}else {
				if(group01==-1) {
					group01=solvedPairs;
				}
				isSame[solvedPairs]=false;
			}
			solvedPairs++;
			queryCount+=2;
		}
		out.println(bits);
		out.flush();
		if(!in.nextString().equals("Y")) {
			throw new IllegalStateException("My algorithm is incorrect ((");
		}
	}

	private int checkGroops(int group00, int group01, Boolean[] isSame, BitSet bits, int solvedPairs) {
		log.debug("Time to check groups");
		int queryCount=0;
		if(group00!=-1) {
			queryCount++;
			if(bits.get(group00)!=ask(group00)) {
				inverse(true,bits,isSame,solvedPairs);
			}
		}
		if(group01!=-1) {
			queryCount++;
			if(bits.get(group01)!=ask(group01)) {
				inverse(false,bits,isSame,solvedPairs);
			}
		}

		return queryCount;
	}

	private void inverse(boolean same, BitSet bits, Boolean[] isSame, int solvedPairs) {
		log.debug("Inverse %s", same?"same":"different");
		for(int i=0;i<solvedPairs;i++) {
			if(same==isSame[i]) {
				bits.flip(i);
				bits.flip(isSame.length*2-1-i);
			}
		}
	}

	private boolean ask(int i) {
		log.debug("Try to ask %s", i+1);
		out.println(i+1);
		out.flush();
		boolean result = in.nextInt()==1;
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return result;

	}
	private static class FixedSizeBitSet extends BitSet {
	    private final int nbits;

	    public FixedSizeBitSet(final int nbits) {
	        super(nbits);
	        this.nbits = nbits;
	    }

	    @Override
	    public String toString() {
	        final StringBuilder buffer = new StringBuilder(nbits);
	        IntStream.range(0, nbits).mapToObj(i -> get(i) ? '1' : '0').forEach(buffer::append);
	        return buffer.toString();
	    }
	}


}
//-------------------------------