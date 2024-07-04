import java.util.Arrays;
import java.util.Scanner;

public class ParentingPartneringReturns {

    static class Pair {
        public int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class MapPair {
        public Pair pair;
        public int mapping;

        MapPair(Pair pair, int mappping) {
            this.pair = pair;
            this.mapping = mappping;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++) {
            int n = sc.nextInt();
            MapPair[] jobs = new MapPair[n];
            for(int i=0; i<n; i++) {
                jobs[i] = new MapPair(new Pair(sc.nextInt(), sc.nextInt()), i);
            }
            Arrays.sort(jobs, (p1, p2) -> compare(p1, p2));
            String sequence = computeSequence(jobs, n);
            System.out.println("Case #" + t + ": " + sequence);
        }
    }

    private static String computeSequence(MapPair[] jobs, int n) {
        if(jobs.length == 1) {
            return "C";
        } else if(jobs.length == 2) {
            return "CJ";
        }
        String impossible = "IMPOSSIBLE";
        StringBuilder result = new StringBuilder();
        for(int i=0; i<n; i++) {
            result.append(' ');
        }
        result.setCharAt(jobs[0].mapping, 'C');
        result.setCharAt(jobs[1].mapping, 'J');
        int cend = jobs[0].pair.end;
        int jend = jobs[1].pair.end;
        for(int i=2; i<n; i++) {
            int jobStart = jobs[i].pair.start;
            int jobEnd = jobs[i].pair.end;
            int index = jobs[i].mapping;
            if(jobStart<cend && jobStart<jend) {
                return impossible;
            }
            if(jobStart<cend && jobStart>=jend) {
                result.setCharAt(index,'J');
                jend = jobEnd;
            } else if(jobStart<jend && jobStart>=cend) {
                result.setCharAt(index,'C');
                cend = jobEnd;
            } else {
                if(cend<jend) {
                    result.setCharAt(index,'C');
                    cend = jobEnd;
                } else {
                    result.setCharAt(index,'J');
                    jend = jobEnd;
                }
            }
        }
        return result.toString();
    }

    private static int compare(MapPair p1, MapPair p2) {
        return (p1.pair.start == p2.pair.start) ? (p1.pair.end - p2.pair.end) : (p1.pair.start - p2.pair.start);
    }
}
