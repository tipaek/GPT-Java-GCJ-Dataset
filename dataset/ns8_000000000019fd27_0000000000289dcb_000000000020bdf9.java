import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static class jobPair {
        public int start, end;

        jobPair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class jobIndexingMapping {
        public jobPair pair;
        public int index;

        jobIndexingMapping(jobPair jobPair, int index) {
            this.pair = jobPair;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++) {
            int n = sc.nextInt();
            jobIndexingMapping[] jobIndexingMappings = new jobIndexingMapping[n];
            for(int i=0; i<n; i++) {
                jobIndexingMappings[i] = new jobIndexingMapping(new jobPair(sc.nextInt(), sc.nextInt()), i);
            }
            Arrays.sort(jobIndexingMappings, (p1, p2) -> compare(p1, p2));
            String sequence = getJobSequence(jobIndexingMappings, n);
            System.out.println("Case #" + t + ": " + sequence);
        }
    }

    private static String getJobSequence(jobIndexingMapping[] jobIndexingMappings, int n) {
        if(jobIndexingMappings.length == 1) {
            return "C";
        } else if(jobIndexingMappings.length == 2) {
            return "CJ";
        }
        StringBuilder result = new StringBuilder();
        for(int i=0; i<n; i++) {
            result.append(' ');
        }
        result.setCharAt(jobIndexingMappings[0].index, 'C');
        result.setCharAt(jobIndexingMappings[1].index, 'J');
        int cEnd = jobIndexingMappings[0].pair.end;
        int jEnd = jobIndexingMappings[1].pair.end;
        for(int i=2; i<n; i++) {
            int jobStart = jobIndexingMappings[i].pair.start;
            int jobEnd = jobIndexingMappings[i].pair.end;
            int index = jobIndexingMappings[i].index;
            if(jobStart<cEnd && jobStart<jEnd) {
                return "IMPOSSIBLE";
            }
            if(jobStart<cEnd && jobStart>=jEnd) {
                result.setCharAt(index,'J');
                jEnd = jobEnd;
            } else if(jobStart<jEnd && jobStart>=cEnd) {
                result.setCharAt(index,'C');
                cEnd = jobEnd;
            } else {
                if(cEnd<jEnd) {
                    result.setCharAt(index,'C');
                    cEnd = jobEnd;
                } else {
                    result.setCharAt(index,'J');
                    jEnd = jobEnd;
                }
            }
        }
        return result.toString();
    }

    private static int compare(jobIndexingMapping p1, jobIndexingMapping p2) {
        return (p1.pair.start == p2.pair.start) ? (p1.pair.end - p2.pair.end) : (p1.pair.start - p2.pair.start);
    }
}