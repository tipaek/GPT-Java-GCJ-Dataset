import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

interface Problem {
    String solve();
}

public class Solution {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        boolean fromFile = isLocal();

        ProblemHelper helper = new ProblemHelper("A", OverexcitedFan.class, fromFile);

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try (BufferedReader reader = helper.createReader();
             BufferedWriter writer = helper.createWriter()) {

            int t = Integer.parseInt(reader.readLine());
            List<Future<String>> futures = new ArrayList<>(t);
            for (int i = 0; i < t; i++) {
                Problem problem = helper.createProblem(reader);
                futures.add(executorService.submit(problem::solve));
            }

            for (int i = 0; i < t; i++) {
                String result = futures.get(i).get();
                writer.append(String.format("Case #%d: %s\r\n", i + 1, result));
                writer.flush();
            }
        }
        executorService.shutdown();

        if (fromFile) {
            System.out.println((System.currentTimeMillis() - start) / 1000.0);
        }
    }

    private static boolean isLocal() {
        boolean local = false;
        try {
            local = "octavian".equalsIgnoreCase(System.getenv().get("user"));
        } catch (Exception ignore) {
        }
        return local;
    }
}

class ProblemHelper {
    private final String name;
    private final Class<? extends Problem> problemClass;
    private final boolean fromFile;

    ProblemHelper(String name, Class<? extends Problem> problemClass, boolean fromFile) {
        this.name = name;
        this.problemClass = problemClass;
        this.fromFile = fromFile;
    }

    Problem createProblem(BufferedReader reader) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return problemClass.getDeclaredConstructor(BufferedReader.class).newInstance(reader);
    }

    BufferedReader createReader() throws FileNotFoundException {
        if (fromFile) {
            return new BufferedReader(new FileReader("data/" + name + ".in"));
        }
        return new BufferedReader(new InputStreamReader(System.in));
    }

    BufferedWriter createWriter() throws IOException {
        if (fromFile) {
            return new BufferedWriter(new FileWriter("data/" + name + ".out"));
        }
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }
}

class Position {
    public int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Position move(char c) {
        switch (c) {
            case 'N':
                return new Position(x, y + 1);
            case 'S':
                return new Position(x, y - 1);
            case 'E':
                return new Position(x + 1, y);
            default:
                return new Position(x - 1, y);
        }
    }

    int distToCenter() {
        return Math.abs(x) + Math.abs(y);
    }
}

class OverexcitedFan implements Problem {
    int x, y;
    String s;

    public OverexcitedFan(BufferedReader reader) throws IOException {
        String[] v = reader.readLine().split(" ");
        x = Integer.parseInt(v[0]);
        y = Integer.parseInt(v[1]);
        s = v[2];
    }

    @Override
    public String solve() {
        Position position = new Position(x, y);
        for (int i = 0; i < s.length(); i++) {
            position = position.move(s.charAt(i));

            if (position.distToCenter() <= i + 1) {
                return "" + (i + 1);
            }
        }
        return "IMPOSSIBLE";
    }
}

