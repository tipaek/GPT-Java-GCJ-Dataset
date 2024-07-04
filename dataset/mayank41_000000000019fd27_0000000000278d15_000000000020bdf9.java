import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++) {
            int n = sc.nextInt();
            int[][] jobs = new int[n][2];
            for(int i=0; i<n; i++) {
                jobs[i][0] = sc.nextInt();
                jobs[i][1] = sc.nextInt();
            }
            Arrays.sort(jobs, (j1, j2) -> compare(j1, j2));
            String sequence = computeSequence(jobs, n);
            System.out.println("Case #" +t+": "+sequence);
        }
    }

    private static String computeSequence(int[][] jobs, int n) {
        if(jobs.length == 1) {
            return "C";
        } else if(jobs.length == 2) {
            return "CJ";
        }
        String impossible = "IMPOSSIBLE";
        StringBuilder result = new StringBuilder("CJ");
        int cend = jobs[0][1];
        int jend = jobs[1][1];
        for(int i=2; i<n; i++) {
            int jobStart = jobs[i][0];
            int jobEnd = jobs[i][1];
            if(jobStart<cend && jobStart<jend) {
                return impossible;
            }
            if(jobStart<cend && jobStart>=jend) {
                result.append('J');
                jend = jobEnd;
            } else if(jobStart<jend && jobStart>=cend) {
                result.append('C');
                cend = jobEnd;
            } else {
                if(cend<jend) {
                    result.append('C');
                    cend = jobEnd;
                } else {
                    result.append('J');
                    jend = jobEnd;
                }
            }
        }
        return result.toString();
    }

    private static int compare(int[] j1, int[] j2) {
        return (j1[0] == j2[0]) ? (j1[1] - j2[1]) : (j1[0] - j2[0]);
    }
}
