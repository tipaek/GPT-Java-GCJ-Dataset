import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/**
 * Author    : joney_000[developer.jaswant@gmail.com]
 * Algorithm : Extended Euclid Algo: find 3 things X, Y, GCD(A, B) Such that X * A + Y * B = GCD(A, B)
 *             Time : O(MAX(A, B)) Space : O(MAX(A, B))
 * Platform  : Codeforces
 * Ref       : https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/
 */

class Solution{ 
  
  private InputStream inputStream ;
  private OutputStream outputStream ;
  private FastReader in ;
  private PrintWriter out ;
  
  private final int BUFFER = 100005;
  
  private final long mod = 1000000000+7;
  private final int  INF  = Integer.MAX_VALUE;
  private final long INF_L  = Long.MAX_VALUE / 10;

  public Solution(){}
  public Solution(boolean stdIO)throws FileNotFoundException{
    // stdIO = false;
    if(stdIO){
      inputStream = System.in;
      outputStream = System.out;
    }else{
      inputStream = new FileInputStream("input.txt");
      outputStream = new FileOutputStream("output.txt");
    }
    in = new FastReader(inputStream);
    out = new PrintWriter(outputStream);
  }
  final int MAXN = 24 * 60 + 2;
 // int [][]mat = new int[MAXN][MAXN];
  int activity[] = new int[MAXN];

  void run()throws Exception{
    int tests = i();
    outer:
    for(int t = 1; t <= tests; t++){
      out.write("Case #"+t+": ");
      LinkedList<Integer> ids[] = new LinkedList[MAXN];

      for(int pos = 0; pos <= MAXN - 1; pos++){
        activity[pos] = 0;
        ids[pos] = new LinkedList<Integer>();
      }

      int activityCount = i();
      char assignment[] = new char[activityCount + 1];

      for(int activityId = 0; activityId < activityCount; activityId++){
        int startTime = i();
        int endTime = i();
        activity[startTime] += 1;
        activity[endTime] -= 1;
        ids[startTime].add(activityId);
        ids[endTime].add(-(activityId + 100000));
      }

      int cuncurrentActivities = 0;
      LinkedList<Character> available = new LinkedList<>();
      available.add('C');
      available.add('J');
      for(int pos = 0; pos <= MAXN - 1; pos++){
        cuncurrentActivities += activity[pos];
        if(cuncurrentActivities > 2){
          out.write("IMPOSSIBLE\n");
          continue outer;
        }
        for(int activityId : ids[pos]){
          if(activityId < 0){
            available.add(assignment[-activityId - 100000]);
          }
        }
        for(int activityId : ids[pos]){
          if(activityId >= 0){
            assignment[activityId] = (char)available.removeFirst();
          }
        }
      }
      for(int activityId = 0; activityId < activityCount; activityId++){
        out.write(""+assignment[activityId]);
      }
      out.write("\n");
     // out.flush();
    }
  }
  
  void clear(){

  }

  long gcd(long a, long b){
    if(b == 0)return a;
    return gcd(b, a % b);
  }

  long lcm(long a, long b){
    if(a == 0 || b == 0)return 0;
    return (a * b)/gcd(a, b);
  }

  long mulMod(long a, long b, long mod){
    if(a == 0 || b == 0)return 0;
    if(b == 1)return a;
    long ans = mulMod(a, b/2, mod);
    ans = (ans * 2) % mod;
    if(b % 2 == 1)ans = (a + ans)% mod;
    return ans;
  }

  long pow(long a, long b, long mod){
    if(b == 0)return 1;
    if(b == 1)return a;
    long ans = pow(a, b/2, mod);
    ans = mulMod(ans, ans, mod);
    if(ans >= mod)ans %= mod;

    if(b % 2 == 1)ans = mulMod(a, ans, mod);
    if(ans >= mod)ans %= mod;

    return ans;
  }

  // 20*20   nCr Pascal Table
  long[][] ncrTable(){
    long ncr[][] = new long[21][21];

    for(int i = 0; i <= 20; i++){
      ncr[i][0] = ncr[i][i] = 1L;
    }

    for(int j = 0; j <= 20; j++){
      for(int i = j + 1; i <= 20; i++){
        ncr[i][j] = ncr[i-1][j] + ncr[i-1][j-1];
      }
    }

    return ncr;
  }

  int i()throws Exception{
    return in.nextInt();
  }

  long l()throws Exception{
    return in.nextLong();
  }

  double d()throws Exception{
    return in.nextDouble();
  }

  char c()throws Exception{
    return in.nextCharacter();
  }

  String s()throws Exception{
    return in.nextLine();
  }

  BigInteger bi()throws Exception{
    return in.nextBigInteger();
  }
  
  private void closeResources(){
    out.flush();
    out.close();
    return;
  }

//  IMP: roundoff upto 2 digits 
//  double roundOff = Math.round(a * 100.0) / 100.0;
//                    or
//  System.out.printf("%.2f", val);

//  print upto 2 digits after decimal
//  val = ((long)(val * 100.0))/100.0;    

  public static void main(String[] args) throws java.lang.Exception{
  
    Solution driver = new Solution(true);
    driver.run();
    driver.closeResources();
  }
}

class FastReader{

  private boolean finished = false;

  private InputStream stream;
  private byte[] buf = new byte[4 * 1024];
  private int curChar;
  private int numChars;
  private SpaceCharFilter filter;

  public FastReader(InputStream stream){
    this.stream = stream;
  }

  public int read(){
    if (numChars == -1){
      throw new InputMismatchException ();
    }
    if (curChar >= numChars){
      curChar = 0;
      try{
        numChars = stream.read (buf);
      } catch (IOException e){
        throw new InputMismatchException ();
      }
      if (numChars <= 0){
        return -1;
      }
    }
    return buf[curChar++];
  }

  public int peek(){
    if (numChars == -1){
      return -1;
    }
    if (curChar >= numChars){
      curChar = 0;
      try{
        numChars = stream.read (buf);
      } catch (IOException e){
        return -1;
      }
      if (numChars <= 0){
        return -1;
      }
    }
    return buf[curChar];
  }

  public int nextInt(){
    int c = read ();
    while (isSpaceChar (c))
      c = read ();
    int sgn = 1;
    if (c == '-'){
      sgn = -1;
      c = read ();
    }
    int res = 0;
    do{
      if(c==','){
        c = read();
      }
      if (c < '0' || c > '9'){
        throw new InputMismatchException ();
      }
      res *= 10;
      res += c - '0';
      c = read ();
    } while (!isSpaceChar (c));
    return res * sgn;
  }

  public long nextLong(){
    int c = read ();
    while (isSpaceChar (c))
      c = read ();
    int sgn = 1;
    if (c == '-'){
      sgn = -1;
      c = read ();
    }
    long res = 0;
    do{
      if (c < '0' || c > '9'){
        throw new InputMismatchException ();
      }
      res *= 10;
      res += c - '0';
      c = read ();
    } while (!isSpaceChar (c));
    return res * sgn;
  }

  public String nextString(){
    int c = read ();
    while (isSpaceChar (c))
      c = read ();
    StringBuilder res = new StringBuilder ();
    do{
      res.appendCodePoint (c);
      c = read ();
    } while (!isSpaceChar (c));
    return res.toString ();
  }

  public boolean isSpaceChar(int c){
    if (filter != null){
      return filter.isSpaceChar (c);
    }
    return isWhitespace (c);
  }

  public static boolean isWhitespace(int c){
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
  }

  private String readLine0(){
    StringBuilder buf = new StringBuilder ();
    int c = read ();
    while (c != '\n' && c != -1){
      if (c != '\r'){
        buf.appendCodePoint (c);
      }
      c = read ();
    }
    return buf.toString ();
  }

  public String nextLine(){
    String s = readLine0 ();
    while (s.trim ().length () == 0)
      s = readLine0 ();
    return s;
  }

  public String nextLine(boolean ignoreEmptyLines){
    if (ignoreEmptyLines){
      return nextLine ();
    }else{
      return readLine0 ();
    }
  }

  public BigInteger nextBigInteger(){
    try{
      return new BigInteger (nextString ());
    } catch (NumberFormatException e){
      throw new InputMismatchException ();
    }
  }

  public char nextCharacter(){
    int c = read ();
    while (isSpaceChar (c))
      c = read ();
    return (char) c;
  }

  public double nextDouble(){
    int c = read ();
    while (isSpaceChar (c))
      c = read ();
    int sgn = 1;
    if (c == '-'){
      sgn = -1;
      c = read ();
    }
    double res = 0;
    while (!isSpaceChar (c) && c != '.'){
      if (c == 'e' || c == 'E'){
        return res * Math.pow (10, nextInt ());
      }
      if (c < '0' || c > '9'){
        throw new InputMismatchException ();
      }
      res *= 10;
      res += c - '0';
      c = read ();
    }
    if (c == '.'){
      c = read ();
      double m = 1;
      while (!isSpaceChar (c)){
        if (c == 'e' || c == 'E'){
          return res * Math.pow (10, nextInt ());
        }
        if (c < '0' || c > '9'){
          throw new InputMismatchException ();
        }
        m /= 10;
        res += (c - '0') * m;
        c = read ();
      }
    }
    return res * sgn;
  }

  public boolean isExhausted(){
    int value;
    while (isSpaceChar (value = peek ()) && value != -1)
      read ();
    return value == -1;
  }

  public String next(){
    return nextString ();
  }

  public SpaceCharFilter getFilter(){
    return filter;
  }

  public void setFilter(SpaceCharFilter filter){
    this.filter = filter;
  }

  public interface SpaceCharFilter{
    public boolean isSpaceChar(int ch);
  }
}

class Pair implements Comparable<Pair>{
  public int a;
  public int b;
   
  public Pair(){
    this.a = 0;
    this.b = 0;
  }

  public Pair(int a,int b){
    this.a = a;
    this.b = b;
  }

  public int compareTo(Pair p){
    if(this.a == p.a){
     return this.b - p.b;  
   }
   return this.a - p.a; 
  }

  @Override
  public String toString(){
    return "a = " + this.a + " b = " + this.b;
  }
} 