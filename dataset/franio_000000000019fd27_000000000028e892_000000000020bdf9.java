
import java.util.*;

public class Solution {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int tests = scanner.nextInt();

            for (int t = 0; t < tests; t++) {
                int N = scanner.nextInt();
                Period[] tasks = new Period[N];
                for (int i = 0; i < N; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    tasks[i] = new Period(start, end, i);
                }

                String result = "";
                for(int j = 0; j < Math.pow(2, N); j ++) {
                    result = "";
                    List<Period> cP = new LinkedList<>();
                    List<Period> jP = new LinkedList<>();

                    int tmp = j;
                    for(int k = 0; k < N; k ++) {
                        if(tmp%2 == 0) {
                            int finalK = k;
                            Optional<Period> first = cP.stream().filter(p -> tasks[finalK].overlap(p)).findFirst();
                            if (first.isPresent()) {
                                break;
                            } else {
                                cP.add(tasks[k]);
                                result+="C";
                            }
                        } else {
                            int finalK = k;
                            Optional<Period> first = jP.stream().filter(p -> tasks[finalK].overlap(p)).findFirst();
                            if (first.isPresent()) {
                                break;
                            } else {
                                jP.add(tasks[k]);
                                result+="J";
                            }
                        }
                        tmp/=2;
                    }
                    if(result.length() == N) {
                        break;
                    }

                }

                sout(t + 1, result.length() == N ? result : "IMPOSSIBLE");

            }
            scanner.close();
    }


    private static void sout(int x, String s) {
        System.out.println("Case #" + x + ": " + s);
    }


}

class Period {
    int start;
    int end;
    int n;

    public Period(int start, int end, int n) {
        this.start = start;
        this.end = end;
        this.n = n;
    }

    public boolean overlap(Period p) {
        if (this.start >= p.start && this.start < p.end) return true;
        if (p.start >= this.start && p.start < this.end) return true;

        return false;
    }
}

