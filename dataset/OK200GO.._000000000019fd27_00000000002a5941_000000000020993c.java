import java.util.*;
import java.io.*;

class Run {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    byte t = in.nextByte();
		for (byte i = 1; i <= t; ++i) {
			byte a = 0, n = in.nextByte(), rows = 0, cols = 0;
			in.nextLine();
			String[] r = in.nextLine().split(" ");
			byte[][] m = new byte[n][r.length];
			while (a < n) {
				for (byte b = 0; b < r.length; ++b)
					m[a][b] = Byte.parseByte(r[b]);
				a++;
				if (a < n)
					r = in.nextLine().split(" ");
			}
			boolean jump;
			for (byte c = 0; c < m.length; ++c)
				for (byte d = 0; d < m.length - 1; ++d) {
					jump = false;
					for (byte dn = (byte) (d + 1); dn < m.length; ++dn)
						if (m[c][d] == m[c][dn]) {
							rows++;
							jump = true;
							break;
						}
					if (jump) break;
				}
			for (byte c = 0; c < m.length; ++c)
				for (byte d = 0; d < m.length - 1; ++d) {
					jump = false;
					for (byte dn = (byte) (d + 1); dn < m.length; ++dn)
						if (m[d][c] == m[dn][c]) {
							cols++;
							jump = true;
							break;
						}
					if (jump) break;
				}
			int sum = 0;
			for (byte c = 0; c < m.length; ++c)
				sum += m[c][c];
			System.out.println(String.format("Case #%d: %d %d %d", i, sum, rows, cols));		
		}
		in.close();
		System.exit(0);
	}
}