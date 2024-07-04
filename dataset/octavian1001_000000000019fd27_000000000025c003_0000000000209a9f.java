import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

//        ProblemHelper helper = new ProblemHelper("A", Vestigium.class, fromFile);
        ProblemHelper helper = new ProblemHelper("B", NestingDepth.class, fromFile);

        ExecutorService executorService = Executors.newFixedThreadPool(8);
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
    private String name;
    private Class<? extends Problem> problemClass;
    private boolean fromFile;

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

class NestingDepth implements Problem {
    int[] v;

    public NestingDepth(BufferedReader reader) throws IOException {
        String s = reader.readLine();
        v = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            v[i] = s.charAt(i) - '0';
        }
    }

    @Override
    public String solve() {
        int n = v.length;
        StringBuilder sb = new StringBuilder();
        int p = v[0];
        for (int i = 0; i < p; i++) {
            sb.append('(');
        }
        sb.append(v[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < p - v[i]; j++) {
                sb.append(')');
            }
            for (int j = 0; j < v[i] - p; j++) {
                sb.append('(');
            }
            sb.append(v[i]);
            p = v[i];
        }
        for (int i = 0; i < p; i++) {
            sb.append(')');
        }
        return sb.toString();
    }
}

class Vestigium implements Problem {
    int n;
    int[][] m;

    public Vestigium(BufferedReader reader) throws IOException {
        n = Integer.parseInt(reader.readLine());
        m = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] v = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(v[j]);
            }
        }
    }

    @Override
    public String solve() {
        int d = 0;
        for (int i = 0; i < n; i++) {
            d += m[i][i];
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniques = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (uniques.contains(m[i][j])) {
                    r++;
                    break;
                }
                uniques.add(m[i][j]);
            }
        }

        int c = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> uniques = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (uniques.contains(m[i][j])) {
                    c++;
                    break;
                }
                uniques.add(m[i][j]);
            }
        }

        return d + " " + r + " " + c;
    }
}
