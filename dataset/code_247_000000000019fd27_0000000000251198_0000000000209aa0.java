import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        Reader reader = new Reader();
        int test = reader.nextInt();
        
        int[] Ns = new int[test];
        int[] Ks = new int[test];

        for(int i=0;i<test;++i)
        {
            Ns[i]=reader.nextInt();
            Ks[i] = reader.nextInt();
        }
        
        
        for(int i=0;i<test;++i){
            int N = Ns[i];
            int K = Ks[i];

            if(K<N){
                System.out.println("Case #" + i+1 + ": IMPOSSIBLE");
            }else {
                int X = check(N, K);
                if (X == -1) {
                    System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + (i+1) + ": POSSIBLE");
                    //System.out.println();
                    int index = 0;
                    int[][] result = new int[N][N];
                    for(int a=0;a<N;++a){
                        result[a][index]=X;
                        ++index;
                    }
                    if (solveSudoku(result, N))
                    {
                        print(result, N); // print solution
                    }
                    else
                    {
                        System.out.println("No solution");
                    }
                }
            }

        }
    }



    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num)
    {
        for (int d = 0; d < board.length; d++)
        {
            if (board[row][d] == num)
            {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++)
        {
            if (board[r][col] == num)
            {
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
            {
                break;
            }
        }

        // no empty space left
        if (isEmpty)
        {
            return true;
        }

        // else for each-row backtrack
        for (int num = 1; num <= n; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board[row][col] = num;
                if (solveSudoku(board, n))
                {
                    return true;
                }
                else
                {
                    board[row][col] = 0; // replace it
                }
            }
        }
        return false;
    }

    public static void print(int[][] board, int N)
    {
        // we got the answer, just print it
        for (int r = 0; r < N; r++)
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }

    static int check(int N,int K){
        int index = -1;
        for(int i=1;i<=N;++i)
            if(i*N==K){
                index = i;
                break;
            }
        return index;
    }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
