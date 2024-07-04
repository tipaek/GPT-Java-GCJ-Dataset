import java.io.*;

class Vestigium
{
    private static int findTrace(int[][] nums) {
        int trace = 0;
        for (int i=0,j=0; i<nums.length && j<nums.length;i++,j++) {
            trace += nums[i][j];
        }
        return trace;
    }

    private static int findRepeatedRows(int[][] nums) {
        int[] freq;
        int rows = 0;
        // rows
        for (int i=0;i<nums.length;i++) {
            freq = new int[nums.length+1];
            // columns
            for (int j=0;j<nums[0].length;j++) {
                int n = nums[i][j];
                freq[n]++;
            }
            for (int k=1;k<freq.length;k++) {
                if (freq[k]>1) {
                    rows++;
                    break;
                }
            }
        }
        return rows;
    }

    private static int findRepeatedColumns(int[][] nums) {
        int[] freq;
        int cols = 0;
        // rows
        for (int i=0;i<nums.length;i++) {
            freq = new int[nums.length+1];
            // columns
            for (int j=0;j<nums.length;j++) {
                int n = nums[j][i];
                freq[n]++;
            }
            for (int k=1;k<freq.length;k++) {
                if (freq[k]>1) {
                    cols++;
                    break;
                }
            }
        }
        return cols;
    }

    public static void main(String[] args)
            throws IOException
    {
        /*int[][] nums = {
                {1,2,3,4},
                {2,1,4,3},
                {3,4,1,2},
                {4,3,2,1}};*/
        /*int[][] nums = {
                {2,2,2,2},
                {2,3,2,3},
                {2,2,2,3},
                {2,2,2,2}};*/
        /*int[][] nums = {
                {2,1,3},
                {1,3,2},
                {1,2,3}};*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line.split("\\s")[0]);
        int cases = 0;
        while (T > 0) {
            cases++;
            String str = br.readLine();
            int N = Integer.parseInt(str.split("\\s")[0]);
            int[][] nums = new int[N][N];
            for (int i=0; i<N; i++) {
                String[] s = br.readLine().split("\\s+");
                for (int j=0;j<N;j++) {
                    nums[i][j] = Integer.parseInt(s[j]);
                }
            }
            /*System.out.println("Print array:");
            for (int k=0;k<nums.length;k++) {
                for (int l=0;l<nums.length;l++) {
                    System.out.print(nums[k][l] + " ");
                }
                System.out.println();
            }*/
            System.out.println("Case #" + cases + ": " + findTrace(nums) + " " + findRepeatedRows(nums) + " " + findRepeatedColumns(nums));
            T--;
        }
    }
}
