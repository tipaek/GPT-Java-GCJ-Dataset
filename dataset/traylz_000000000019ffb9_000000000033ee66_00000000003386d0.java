
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            final List<Point> points = new ArrayList<>();

            final int numOfPoints = Integer.parseInt(in.readLine());
            for (int j = 0; j < numOfPoints; j++) {
                final String[] point = in.readLine().split(" ");
                points.add(new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
            }

            int result = solve(points);
            System.out.println("Case #" + i + ": " + result);
        }

    }

    public static int solve(Collection<Point> points) {
        if (points.size() <= 2) {
            return points.size();
        }
        final Map<Coeff, Set<Point>> pointsPerCoeff = new HashMap<>();
        for (Point point1 : points) {
            for (Point point2 : points) {
                if (point1 != point2) {
                    final Coeff coeff = Coeff.forPoints(point1, point2);
                    pointsPerCoeff.putIfAbsent(coeff, new HashSet<>());
                    pointsPerCoeff.get(coeff).add(point1);
                    pointsPerCoeff.get(coeff).add(point2);
                }
            }
        }
        final Integer maxCluster = pointsPerCoeff.values().stream().map(Set::size).max(Integer::compareTo).orElseThrow(() -> new IllegalStateException("cannot be here"));
        if (points.size() - maxCluster > 2 && maxCluster % 2 == 0) {
            return maxCluster + 2; // add beginning and ending to the cluster, only if cluster size is even
        } else if (points.size() - maxCluster >= 1) {
            return maxCluster + 1; // add point to beginning
        }
        return maxCluster;
    }
}

class Point {
    final int x;
    final int y;

    public static Point p(int x, int y) {
        return new Point(x, y);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Point point = (Point) o;
        return x == point.x &&
            y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Q {

    public static Q integer(long i) {
        return new Q(i, 1);
    }

    public static Q rational(long nominator, long denominator) {
        return new Q(nominator, denominator).simplify();
    }

    long nominator;
    long denominator;

    Q(long nominator, long denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    Q multiply(int i) {
        return new Q(nominator * i, denominator).simplify();
    }

    Q simplify() {
        if (denominator < 0) {
            denominator *= -1;
            nominator *= -1;
        }
        if (nominator == 0) {
            denominator = 1;
        } else if (denominator == 0) {
            throw new IllegalStateException("Infinite number!");
        } else {
            int gcd = BigInteger.valueOf(nominator).abs().gcd(BigInteger.valueOf(denominator)).intValueExact();
            while (gcd != 1) {
                nominator /= gcd;
                denominator /= gcd;
                gcd = BigInteger.valueOf(nominator).abs().gcd(BigInteger.valueOf(denominator).abs()).intValueExact();
            }
        }
        return this;
    }

    Q add(Q another) {
        return rational(this.nominator * another.denominator + another.nominator * this.denominator, this.denominator * another.denominator).simplify();
    }

    Q neg() {
        return rational(-this.nominator, this.denominator);
    }

    @Override
    public boolean equals(Object o) {
        Q that = (Q) o;
        return nominator == that.nominator &&
            denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominator, denominator);
    }

    public boolean isZero() {
        return nominator == 0;
    }

}


class Coeff {
    // y = kx
    Q k;
    boolean isVertical = false;

    static Coeff forPoints(Point p1, Point p2) {
        Coeff coeff = new Coeff();
        if (p1.x == p2.x) {

            coeff.isVertical = true;
            coeff.k = Q.integer(1).simplify();

        } else {
            coeff.k = Q.rational(p1.y - p2.y, p1.x - p2.x);
        }
        return coeff;
    }


    @Override
    public boolean equals(Object o) {
        Coeff coeff = (Coeff) o;
        return isVertical == coeff.isVertical &&
            Objects.equals(k, coeff.k);
    }

    @Override
    public int hashCode() {
        return Objects.hash(k, isVertical);
    }

    @Override
    public String toString() {
        return "Coeff{" +
            "k=" + k +
            ", isVertical=" + isVertical +
            '}';
    }
}