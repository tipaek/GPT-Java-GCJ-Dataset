import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		JoltyScanner in = new JoltyScanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int r = in.nextInt(), c = in.nextInt();
			ArrayList<Dancer> changed = new ArrayList();
			Dancer[][] grid = new Dancer[r][c];
			long skillSum = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					grid[i][j] = new Dancer(i, j, in.nextInt());
					changed.add(grid[i][j]);
					skillSum += grid[i][j].skill;
				}
			}

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (i != 0)
						grid[i][j].up = grid[i - 1][j];
					if (i != r - 1)
						grid[i][j].down = grid[i + 1][j];
					if (j != 0)
						grid[i][j].left = grid[i][j - 1];
					if (j != c - 1)
						grid[i][j].right = grid[i][j + 1];
				}
			}

			long ans = 0;
			while (true) {
				ans += skillSum;
				ArrayList<Dancer> kill = new ArrayList<>();

				ArrayList<Dancer> nextChanging = new ArrayList<>();
				for (Dancer d : changed) {
					if(d.ead)
						continue;
					Iterable<Dancer> adj = getAdj(d);
					if (!isOk(d, adj)) {
						kill.add(d);
						for (Dancer o : adj)
							nextChanging.add(o);
					}
				}

				if (kill.isEmpty())
					break;
				for (Dancer d : kill) {
					d.ead = true;
					skillSum -= d.skill;
					if (d.left != null) {
						d.left.right = d.right;
					}
					if (d.right != null) {
						d.right.left = d.left;
					}
					if (d.up != null) {
						d.up.down = d.down;
					}
					if (d.down != null) {
						d.down.up = d.up;
					}
				}
				changed = nextChanging;
			}
			System.out.printf("Case #%d: %d\n", t, ans);
		}
	}

	static boolean isOk(Dancer d, Iterable<Dancer> adj) {
		long sum = 0;
		long me = 0;
		for (Dancer o : adj) {
			me += d.skill;
			sum += o.skill;
		}
		return me >= sum;
	}

	static Iterable<Dancer> getAdj(Dancer d) {
		return Arrays.stream(new Dancer[] { d.left, d.right, d.up, d.down }).filter(Objects::nonNull).collect(Collectors.toList());
	}

	static class Dancer {
		boolean ead = false;
		int row, col, skill;

		Dancer left, right, up, down;

		public Dancer(int row, int col, int skill) {
			this.row = row;
			this.col = col;
			this.skill = skill;
		}
	}
	//@
	static class JoltyScanner 
	{
		public static final int BUFFER_SIZE = 1 << 16;
		public static final char NULL_CHAR = (char) -1;
		byte[] buffer = new byte[BUFFER_SIZE];
		boolean EOF_FLAG = false;
		int bufferIdx = 0, size = 0;
		char c = NULL_CHAR;
		BufferedInputStream in;
		public JoltyScanner(InputStream in) 
		{
			this.in = new BufferedInputStream(in, BUFFER_SIZE);
		}
		public int nextInt() 
		{
			long x = nextLong();
			if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) 
			{
				throw new ArithmeticException("Scanned value overflows integer");
			}
			return (int) x;
		}
		public long nextLong() 
		{
			boolean negative = false;
			if (c == NULL_CHAR) 
			{
				c = nextChar();
			}
			for (; !EOF_FLAG && (c < '0' || c > '9'); c = nextChar()) 
			{
				if (c == '-') 
				{
					negative = true;
				}				
			}
			checkEOF();
			long res = 0;
			for (; c >= '0' && c <= '9'; c = nextChar()) 
			{
				res = (res << 3) + (res << 1) + c - '0';
			}
			return negative ? -res : res;
		}
		public char nextChar() 
		{
			if (EOF_FLAG) 
			{
				return NULL_CHAR;
			}
			while (bufferIdx == size) 
			{
				try 
				{
					size = in.read(buffer);
					if (size == -1) 
					{
						throw new Exception();
					}
				} 
				catch (Exception e) 
				{
					EOF_FLAG = true;
					return NULL_CHAR;
				}
				if (size == -1) 
				{
					size = BUFFER_SIZE;
				}
				bufferIdx = 0;
			}
			return (char) buffer[bufferIdx++];
		}
		public void checkEOF() 
		{
			if (EOF_FLAG) 
			{
				throw new EndOfFileException();
			}
		}
		public class EndOfFileException extends RuntimeException 
		{
		}
	}
}
