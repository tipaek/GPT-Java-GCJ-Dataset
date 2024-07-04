
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    FastScan1CP3 fs;
    PrintWriter pw;

    Solution() {
        fs = new FastScan1CP3();
        pw = new PrintWriter(System.out);
    }

    public static void main(String[] args) {
        Solution pr = new Solution();
        int T = pr.fs.nextInt();

        for (int i = 0; i < T; i++) {
            int N = pr.fs.nextInt();
            int D = pr.fs.nextInt();

            int arr[] = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j]= pr.fs.nextInt();
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            int result = 0;
            boolean found = false;

            for (int j = 0; j < N; j++) {
                    int count = map.getOrDefault(arr[j], 0);
                    count++;
                    map.put(arr[j], count);
                    if(count == D){
                        found = true;
                        break;
                    }
            }

            if(!found){
                if(D==2){
                    result = 1;
                }
                else {
                    Arrays.sort(arr);
                    int b=0;
                    for(b=0;b<arr.length-1;b++){
                        if (map.get(arr[b]) == 2 && arr[b+1] > arr[b]){
                            result = 1;
                            break;
                        }
                        else{
                            if(arr[b]*2 <= Integer.MAX_VALUE && map.containsKey(arr[b]*2)){
                                result = 1;
                                break;
                            }
                        }
                    }
                    if(b == arr.length-1){
                        result=2;
                    }
                }

            }

            pr.pw.println("Case #" + (i + 1) + ": " + result);
        }
        pr.pw.close();
    }
}

class FastScan1CP3 {
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScan1CP3() {
        this(System.in);
    }

    public FastScan1CP3(InputStream is) {
        mIs = is;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = mIs.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }


    public String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; }

    public boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
}
