import java.io.*;

/**
 * Solution
 */
public class Solution {

    // variable declaration
    int X, Y, steps;
    String dirX = "", dirY = "", result = "";

    void calculateDirection() {
        // determine direction
        if (X > 0) dirX = "E";
        else if (X < 0) dirX = "W";
        
        if (Y > 0) dirY = "N";
        else if (Y < 0) dirY = "S";

        // check for straight direction
        if (dirX.isEmpty()) dirY += "F";
        if (dirY.isEmpty()) dirX += "F";

        System.out.println("Direction: " + dirX + dirY);
    }

    void calculateSteps() {
        // calculate steps to reach goal
        steps = Math.abs(X) + Math.abs(Y);

        boolean loop = true;
        int count = 1, actualSteps = 0;
        while (loop) {
            actualSteps += Math.pow(2, count - 1);
            if (actualSteps >= steps) loop = false;
            count++;
        }
        System.out.println("Actual Steps: " + actualSteps + " Steps: " + steps);
    }

    void findPath() {
        String dir;
        int dirVal, stepVal = 0;
        boolean loop = true;

        while (loop) {
            result = "";
            System.out.println("X: " + X + " Y: " + Y);
            if (Y > X) {
                dir = "Y";
                dirVal = Y;
            } else {
                dir = "X";
                dirVal = X;
            }

            for (int i = 1; stepVal < (X + Y); i++) {
                stepVal += Math.pow(2, i - 1);
                if (stepVal > dirVal) {
                    if (dir.equals("X")) dir = "Y";
                    else dir = "X";
                }
            }
        }
    }

    void getResult() {
        calculateDirection();
        calculateSteps();
        findPath();
    }

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            Solution obj = new Solution();
            obj.X = sc.nextInt();
            obj.Y = sc.nextInt();
            obj.getResult();
            System.out.println("Case #" + t + ": ");
        }
        System.exit(0);
    }
}

class FastReader {
    private final int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public FastReader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public FastReader(String fileName) {
        try {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLine() {
        StringBuilder sb = new StringBuilder();
        byte c;
        while ((c = read()) != -1) {
            if (c == '\n') break;
            sb.append((char) c);
        }
        return sb.toString();
    }

    public String readLine(int size) {
        byte[] buf = new byte[size];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() {
        int n = 0;
        boolean neg = false;
        int c;
        while ((c = read()) <= ' ') ;
        if (c == '-') {
            neg = true;
            c = read();
        }
        do {
            n = n * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == 13) read();
        return neg ? -n : n;
    }

    public long nextLong() {
        long n = 0;
        boolean neg = false;
        int c;
        while ((c = read()) <= ' ') ;
        if (c == '-') {
            neg = true;
            c = read();
        }
        do {
            n = n * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == 13) read();
        return neg ? -n : n;
    }

    public double nextDouble() {
        double n = 0, div = 1;
        boolean neg = false;
        int c;
        while ((c = read()) <= ' ') ;
        if (c == '-') {
            neg = true;
            c = read();
        }
        do {
            n = n * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                n += (c - '0') / (div *= 10);
            }
        }
        if (c == 13) read();
        return neg ? -n : n;
    }

    private void fillBuffer() {
        try {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte read() {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() {
        try {
            if (din != null) din.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}