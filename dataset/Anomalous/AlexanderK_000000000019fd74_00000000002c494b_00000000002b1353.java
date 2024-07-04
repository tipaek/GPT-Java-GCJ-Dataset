import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            process(reader);
        }
    }

    static class Input {
        int n;

        public Input(int n) {
            this.n = n;
        }

        public Input(BufferedReader reader) throws IOException {
            this.n = Integer.parseInt(reader.readLine());
        }

        @Override
        public String toString() {
            return "Input{n=" + n + '}';
        }
    }

    static class Output {
        List<Pos> positions;

        public Output(List<Pos> positions) {
            this.positions = positions;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(7 * positions.size());
            for (Pos pos : positions) {
                sb.append('\n').append(pos.n + 1).append(' ').append(pos.k + 1);
            }
            return sb.toString();
        }
    }

    public static void process(BufferedReader reader) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(new Input(reader)));
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
            return 67 * (67 * 5 + n) + k;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pos other = (Pos) obj;
            return n == other.n && k == other.k;
        }
    }

    static Output solve(Input input) {
        int n = input.n;
        if (n <= 500) {
            return new Output(IntStream.range(0, n)
                    .mapToObj(i -> new Pos(i, 0))
                    .collect(Collectors.toList()));
        }
        if (n <= 1000) {
            int s = n - 1;
            List<Pos> positions = new ArrayList<>();
            positions.add(new Pos(0, 0));
            int k = (int) ((Math.sqrt(1 + 8 * s) - 1) / 2);
            for (int i = 0; i < k; i++) {
                positions.add(new Pos(i + 1, 1));
            }
            s -= k * (k + 1) / 2;
            while (s > 0) {
                s--;
                positions.add(new Pos(k++, 0));
            }
            return new Output(positions);
        }
        return new Output(IntStream.range(0, 500)
                .mapToObj(i -> new Pos(i, 0))
                .collect(Collectors.toList()));
    }
}