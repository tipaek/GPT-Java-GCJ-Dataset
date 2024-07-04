import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests =  in.nextInt();

        for(int test = 1; test <= tests; test++) {
            int R = in.nextInt();
            int C = in.nextInt();

            int[][] skill = new int[R][C];
            boolean[][] eliminated = new boolean[R][C];

            int interestLevel = 0;

            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    skill[i][j] = in.nextInt();
                }
            }

            while(true) {
                interestLevel += calculateInterestForLevel(skill, R, C, eliminated);
                int eliminated_count = 0;
                ArrayList<int[]> list = new ArrayList<>();
                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        if(!eliminated[i][j]) {
                            int neighbor_skills = 0;
                            int neighbor_count = 0;

                            int ni = i + 1;
                            while(ni < R && eliminated[ni][j]) {
                                ni++;
                            }
                            if(ni < R) {
                                neighbor_count++;
                                neighbor_skills += skill[ni][j];
                            }

                            ni = i - 1;
                            while(0 <= ni && eliminated[ni][j])  {
                                ni--;
                            }
                            if(ni >= 0) {
                                neighbor_count++;
                                neighbor_skills += skill[ni][j];
                            }

                            int nj = j + 1;
                            while(nj < C && eliminated[i][nj]) {
                                nj++;
                            }

                            if(nj < C) {
                                neighbor_count++;
                                neighbor_skills += skill[i][nj];
                            }

                            nj = j - 1;
                            while(nj >= 0 && eliminated[i][nj]) {
                                nj--;
                            }

                            if(nj >= 0) {
                                neighbor_count++;
                                neighbor_skills += skill[i][nj];
                            }
                            
                            float avg = (float) neighbor_skills/neighbor_count;
                            if((float) skill[i][j] < avg) {
                                list.add(new int[]{i, j});
                                eliminated_count++;
                            }
                        }

                    }
                }

                if(eliminated_count == 0) {
                    break;
                }

                for(int[] ii : list) {
                    eliminated[ii[0]][ii[1]] = true;
                }
            }

            System.out.println("Case #" + test + ": " + interestLevel);
        }
    }

    public static int calculateInterestForLevel(int[][] skill, int R, int C, boolean[][] eliminated) {
        int interest = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(!eliminated[i][j])
                    interest += skill[i][j];
            }
        }
        return interest;
    }
}