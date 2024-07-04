import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new C().run();
    }
}



/**
 * @author sunny
 */
abstract class Solver {
    public abstract String getDataBaseDir();
    public abstract String getDataFilenamePrefix();

    public void run() throws FileNotFoundException {
        run(false);
    }

    public void run(boolean useFile) throws FileNotFoundException {
        String filenamePrefix = getDataFilenamePrefix();
        String baseDir = getDataBaseDir();
        try (
                Scanner in = new Scanner(new BufferedInputStream(useFile ? new FileInputStream(baseDir + filenamePrefix + ".in") : System.in));
                PrintWriter out = new PrintWriter(new BufferedOutputStream(useFile ? new FileOutputStream(baseDir + filenamePrefix + ".out") : System.out))
        ) {
            run(in, out);
        }
    }

    public void run(Scanner scanner, PrintWriter writer) {
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= T; ++i) {
            solve(i, scanner, writer);
        }
    }

    public abstract void solve(int caseI, Scanner scanner, PrintWriter writer);
}



/**
 * @author sunny
 */
class C extends Solver {
    public static void main(String[] args) throws FileNotFoundException {
        new C().run(true);
    }
    @Override
    public String getDataBaseDir() {
        return "data/contest/2020/qual/";
    }

    @Override
    public String getDataFilenamePrefix() {
        return "C";
    }

    @Override
    public void solve(int caseI, Scanner scanner, PrintWriter writer) {
//        new CSolver().solve(caseI, scanner, writer);

        int n = scanner.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            tasks.add(new Task(s, e, i));
        }

        tasks.sort((o1, o2) -> Integer.compare(o1.start, o2.start));

        writer.printf("Case #%d: ", caseI);

        char[] assignees = new char[n];
        int[] nLastFinish = new int[2];
        Arrays.fill(nLastFinish, 0);

        try {
            tasks.forEach(t -> {
                int assigneeId = -1;
                for (int i = 0; i < 2; i++) {
                    if (nLastFinish[i] <= t.start) {
                        assigneeId = i;
                        break;
                    }
                }
                if (assigneeId < 0) {
                    throw new ImpossibleException();
                }
                assignees[t.index] = assigneeId == 0 ? 'C' : 'J';
                nLastFinish[assigneeId] = t.end;
            });

            writer.println(assignees);
        } catch (ImpossibleException ignored) {
            writer.println("IMPOSSIBLE");
        }
    }

    static class ImpossibleException extends RuntimeException {}

    static class Task {
        int start, end;
        int index;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}
