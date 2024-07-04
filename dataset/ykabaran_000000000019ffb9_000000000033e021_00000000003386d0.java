
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Google Code Jam 2020 Round 2
 */
public class Solution {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in);
				 PrintStream out = System.out;) {
			int t = in.nextInt();
			for (int i = 1; i <= t; i++) {
				String solution = solveNext(in);
				out.println("Case #" + i + ": " + solution);
//				out.println(solution);
				out.flush();
			}
		}
		System.exit(0);
	}

	public static String solveNext(Scanner in) {
		int numHoles = in.nextInt();
		Coord[] holes = new Coord[numHoles];
		for (int i = 0; i < numHoles; i++) {
			holes[i] = new Coord(in.nextLong(), in.nextLong());
		}
		return new Solution(numHoles, holes).solve();
	}

	public static class Coord {

		long x;
		long y;

		public Coord(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Fraction {

		long num;
		long den;

		public Fraction(long num, long den) {
			this.num = num;
			this.den = den;
		}

		public boolean isSame(Fraction o) {
			return this.num * o.den == this.den * o.num;
		}
	}

	public static class Line {

		Fraction m;
		Fraction c;

		public Line(Coord c1, Coord c2) {
			long mNum = c2.y - c1.y;
			long mDen = c2.x - c1.x;
			this.m = new Fraction(mNum, mDen);

			long cNum = mDen * c1.y - mNum * c1.x;
			long cDen = mDen;
			this.c = new Fraction(cNum, cDen);
		}

		public boolean isSameM(Line o) {
			return this.m.isSame(o.m);
		}

		public boolean isSameC(Line o) {
			return this.c.isSame(o.c);
		}

		public boolean isSameLine(Line o) {
			return this.isSameM(o) && this.isSameC(o);
		}

	}

	int numHoles;
	Coord[] holes;

	public Solution(int numHoles, Coord[] holes) {
		this.numHoles = numHoles;
		this.holes = holes;
	}

	private Fraction findGradient(Fraction gradient, List<Fraction> all) {
		for (Fraction f : all) {
			if (f.isSame(gradient)) {
				return f;
			}
		}
		all.add(gradient);
		return gradient;
	}

	private Line findLine(Line line, List<Line> all) {
		for (Line l : all) {
			if (l.isSameLine(line)) {
				return l;
			}
		}
		all.add(line);
		return line;
	}

	private int getGradientCount(Fraction gradient, List<Line> allLines, Map<Line, Set<Coord>> lineGroups) {
		int numTotal = 0;
		int numOdds = 0;
		for (Line line : allLines) {
			if (!gradient.isSame(line.m)) {
				continue;
			}
			Set<Coord> lineCoords = lineGroups.get(line);
			int lineCount = lineCoords.size();
			numTotal += lineCount;
			if (lineCount % 2 == 1) {
				numOdds++;
			}
		}

		int remCount = this.numHoles - numTotal;
		if (numOdds % 2 == 0) {
			numTotal += Math.min(2, remCount);
		} else {
			numTotal += Math.min(1, remCount);
		}
		return numTotal;
	}

	public String solve() {
		if (this.numHoles < 4) {
			return Integer.toString(this.numHoles);
		}

		List<Fraction> allGradients = new LinkedList<>();
		List<Line> allLines = new LinkedList<>();
		Map<Fraction, Set<Coord>> gradientGroups = new HashMap<>();
		Map<Line, Set<Coord>> lineGroups = new HashMap<>();

		for (int i = 0; i < this.numHoles - 1; i++) {
			Coord hole1 = this.holes[i];
			for (int j = i + 1; j < this.numHoles; j++) {
				Coord hole2 = this.holes[j];
				Line line = new Line(hole1, hole2);
				line.m = this.findGradient(line.m, allGradients);
				line = this.findLine(line, allLines);

				Set<Coord> gradientCoords = gradientGroups.get(line.m);
				if (gradientCoords == null) {
					gradientCoords = new HashSet<>();
					gradientGroups.put(line.m, gradientCoords);
				}
				gradientCoords.add(hole1);
				gradientCoords.add(hole2);

				Set<Coord> lineCoords = lineGroups.get(line);
				if (lineCoords == null) {
					lineCoords = new HashSet<>();
					lineGroups.put(line, lineCoords);
				}
				lineCoords.add(hole1);
				lineCoords.add(hole2);
			}
		}

		int maxCount = 0;
		for (Fraction gradient : allGradients) {
			int currCount = this.getGradientCount(gradient, allLines, lineGroups);
			maxCount = Math.max(maxCount, currCount);
		}

		return Integer.toString(maxCount);
	}
}
