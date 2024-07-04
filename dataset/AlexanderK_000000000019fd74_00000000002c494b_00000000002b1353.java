
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author alexk
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            process(r);
        }
    }

    static class Input {

        int n;

        public Input(int n) {
            this.n = n;
        }

        public Input(BufferedReader br) throws IOException {
            String line = br.readLine();
            n = Integer.parseInt(line);
        }

        @Override
        public String toString() {
            return "Input{" + "n=" + n + '}';
        }
    }

    static class Output {

        List<Pos> p;

        public Output(List<Pos> p) {
            this.p = p;
        }

        @Override
        public String toString() {     
            StringBuilder sb = new StringBuilder(7 * p.size());
            p.forEach((pos) -> {
                sb.append('\n').append(pos.n + 1).append(' ').append(pos.k + 1);
            });
            return sb.toString();
        }
    }

    public static void process(BufferedReader r) throws IOException {
        int t = Integer.parseInt(r.readLine());
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(new Input(r)));
        }
    }
    
    static class Pos {
        final int n, k;

        public Pos(int n, int k) {
            this.n = n;
            this.k = k;
        }
        
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 67 * hash + this.n;
            hash = 67 * hash + this.k;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Pos other = (Pos) obj;
            if (this.n != other.n) {
                return false;
            }
            if (this.k != other.k) {
                return false;
            }
            return true;
        }
        
        
    }
    
    static Output solve(Input in) {
//        System.err.println("Input: " + in);
        if (in.n <= 500) {
            return new Output(IntStream.range(0, in.n)
                    .mapToObj(i -> new Pos(i, 0))
                    .collect(Collectors.toList()));
        }
        if (in.n <= 1000) {
            int s = in.n - 1;
            List<Pos> pp = new ArrayList<>();
            pp.add(new Pos(0, 0));            
            int k = (int) ((Math.sqrt(1 + 8 * s) - 1) / 2);
            for (int i = 0; i < k; i++) {
                pp.add(new Pos(i + 1, 1));
            }
            s -= k * (k + 1) / 2;
//            System.err.println("s = " + s);
            while (s > 0) {
                s--;
                pp.add(new Pos(k++, 0));
            }
            return new Output(pp);
        }
        // Not solved :-(
        return new Output(IntStream.range(0, 500)
                .mapToObj(i -> new Pos(i, 0))
                .collect(Collectors.toList()));
        
//        List<Pos> pp = new ArrayList<>();
//        Set<Pos> visited = new HashSet<>();
//        int n = 0;
//        int k = 0;
//        long v = 1;
//        long rest = in.n - v;
//        System.err.println("rest = " + rest + " v = " + v);
//        Pos p = new Pos(n, k);
//        pp.add(p);
//        visited.add(p);
//        while (rest > in.n / 2) {
//            // go down
//            if (n % 2 == 0) {
//                v = v * (n + 1) / (n - k + 1);
//                n++;
//            } else {
//                v = v * (n + 1) / (k + 1);
//                n++;
//                k++;
//            }
//            p = new Pos(n, k);
//            pp.add(p);
//            visited.add(p);
//            rest -= v;
//            System.err.println("rest = " + rest + " v = " + v);
//        }
//        while(rest > 0 && k > 0) {
//            // go left
//            k--;
//            v = v * k / (n - k + 1);
//            rest -= v;
//            System.err.println("rest = " + rest + " v = " + v);
//        }        
//        return new Output(pp);
    }
}
