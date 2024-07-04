import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        InputReader.OutputWriter out = new InputReader.OutputWriter(outputStream);

        int t = in.nextInt();
        for (int it = 0; it < t; it++) {
            char [] s = in.next().toCharArray();
            int prevDigit = -1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                int currentDigit = (s[i] - '0');
                if(prevDigit == -1) {
                    for (int j = 0; j < currentDigit; j++) {
                        sb.append("(");
                    }
                }
                else if (currentDigit > prevDigit) {
                    int diff = currentDigit - prevDigit;
                    while (diff --> 0) {
                        sb.append("(");
                    }
                }
                else {
                    int diff = prevDigit - currentDigit;
                    while (diff --> 0) {
                        sb.append(")");
                    }
                }
                sb.append(s[i]);
                prevDigit = currentDigit;
            }
            while (prevDigit -- > 0) sb.append(")");
            out.println("Case #" +  (it + 1) +": " + sb);
        }
        
        out.flush();
    }

    public int findTheLongestSubstring(String s) {
        Set<StringBuilder> set = new HashSet<>();
        for(int i = 0; i < s.length();i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < s.length(); j++) {
                sb.append(s.charAt(i));
                set.add(sb);
            }
        }
        int max = 0;
        for(StringBuilder ss : set) {
            int a = 0;
            int e = 0;
            int i = 0;
            int o = 0;
            int u = 0;
            for(int j = 0; j < ss.length();j++) {
                if(ss.charAt(i) == 'a') a++;
                if(ss.charAt(i) == 'e') e++;
                if(ss.charAt(i) == 'i') i++;
                if(ss.charAt(i) == 'o') o++;
                if(ss.charAt(i) == 'u') u++;
            }
            if(a%2 == 0 && e%2==0 && i%2==0 && o%2==0 && u%2==0) {
                max = Math.max(max,ss.length());
            }
        }
        return max;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            if(s.charAt(i++)!=s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    private static Set<Integer> del(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            if(n%i==0) {
                set.add(i);
                if(i*i!=n) {
                    set.add(n/i);
                }
            }
        }
        return set;
    }
    private static void randomlyFillAnArray(int [] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*Integer.MAX_VALUE);
        }
    }


    private static void permutationOfNumbers(int n, int m, int [] a, int index) {
        if(index == n) {
            System.out.println(Arrays.toString(a));
            return;
        }
        for (int i = 1; i <=m; i++) {
            a[index] = i;
            permutationOfNumbers(n,m,a,index + 1);
        }
    }

    private static void permutationOfLetters( char m, int index, char[] a) {
        if(index == a.length) {
            System.out.println(Arrays.toString(a));
            return;
        }
        for (char c = 'a'; c <=m; c++) {
            a[index] = c;
            permutationOfLetters(m,index + 1, a);
        }
    }

    private static void permutations(int n, int index, int [] a, boolean [] used) {
        if(index == n) {
            System.out.println(Arrays.toString(a));
            return;
        }
        for (int i = 1; i <=n; i++) {
            if(used[i]) continue;
            a[index] = i;
            used[i] = true;
            permutations(n,index + 1,a,used);
            used[i] = false;
        }
    }

    private static boolean correct(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) return false;
                char peek = stack.peek();
                if(peek == '(' && c == ']') return false;
                if(peek == '[' && c == ')') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    private static void divideNumber(int sum, int last, int n, List<Integer> current) {
        if(sum > n) {
            return;
        }
        if(sum == n) {
            System.out.println(current);
            return;
        }
        for (int i = last; i <= n - sum ; i++) {
            current.add(i);
            divideNumber( sum + i, i,n,current);
            current.remove(current.size() - 1);
        }
    }
    private static void fishki(String s, int n, int m) {
        if(s.length() == n) {
            if(m == 0) {
                System.out.println(s);
            }
            return;
        }

        fishki(s + "*", n, m - 1);
        fishki(s + ".", n, m);
    }
    private static boolean check(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(i > 0 && s.charAt(i) == '*' && s.charAt(i-1) == '*') return false;
        }
        return true;
    }
    private static boolean [] erath() {
        boolean[] isPrime = new boolean[200_000 + 1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        int n = isPrime.length - 1;
        for (int i = 2; i*i<=n; i++) {
            if(isPrime[i]) {
                for (int j = i*i; j <=n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }



    public static long gcd(long a, long b) {
       while (b > 0) {
           long temp = a;
           a = b;
           b = temp%b;
       }
       return a;
    }


    private static int factorization(long n) {
        Set<Long> set = new HashSet<>();
        for(long i = 2; i * i <=n; i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }
        if(n > 1) set.add(n);
        return set.size();
    }
}
class IntervalComparator implements Comparator<int []> {
    @Override
    public int compare(int[] a, int[] b) {
        if(a[0] - b[0] == 0) {
            return a[1] - b[1];
        }
        return a[0] - b[0];
    }
}
class Point implements Comparator<Point>{
    
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compare(Point o1, Point o2) {
        return 0;
    }
}

class InputReader extends BufferedReader {
    StringTokenizer tokenizer;

    public InputReader(InputStream inputStream) {
        super(new InputStreamReader(inputStream), 32768);
    }

    public InputReader(String filename) {
        super(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(readLine());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return tokenizer.nextToken();
    }

    public Integer nextInt(){
        return Integer.valueOf(next());
    }
    public Long nextLong() {
        return  Long.valueOf(next());
    }
    public Double nextDouble() {
        return Double.valueOf(next());
    }
    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream outputStream) {
            super(outputStream);
        }

        public OutputWriter(Writer writer) {
            super(writer);
        }

        public OutputWriter(String filename) throws FileNotFoundException {
            super(filename);
        }

        public void close() {
            super.close();
        }
    }
}
