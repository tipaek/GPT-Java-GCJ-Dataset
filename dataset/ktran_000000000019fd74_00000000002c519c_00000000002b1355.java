import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T; t++) {

            int R = sc.nextInt();
            int C = sc.nextInt();

            int[][] skills = new int[R][C];

            for(int r = 0; r < R ; r++) {
                for(int c = 0; c < C; c++){
                    skills[r][c] = sc.nextInt();
                }
            }


            int sum = 0;
            while(true) {

                int eliminated = 0;
                sum += calculate(skills, R, C);
                int[][] newSkills = new int[R][C];
                for(int r = 0 ; r < R; r++) {
                    for(int c = 0 ; c < C; c++) {
                        newSkills[r][c]  = skills[r][c];
                        if(skills[r][c] != -1) {
                            double avg = findCompassAvg(r,c,skills);
                            if(avg > skills[r][c]) {
                                newSkills[r][c] = -1;
                                eliminated++;
                            }
                        }
                    }
                }



                if(eliminated == 0) break;
                skills = newSkills;
            }

            System.out.println("Case #"+t+": "+sum);

        }


    }


    public static double findCompassAvg(int r, int c, int[][] skills) {

        int[][] directions = new int[][] {
                new int[] { 0,-1},
                new int[] { -1, 0},
                new int[] {0 ,1},
                new int[] {1, 0}
        };

        int R = skills.length;
        int C = skills[0].length;

        int count = 0;
        double sum = 0;

        for(int[] direction : directions) {
            int r1 = r + direction[0];
            int c1 = c + direction[1];

            while(!(r1 < 0 || c1 < 0 || r1 >= R || c1 >= C)) {
                if(skills[r1][c1] != -1) {
                    count++;
                    sum = sum + skills[r1][c1];
                    break;
                }
                r1 = r1 + direction[0];
                c1 = c1 + direction[1];
            }
        }

        if(count > 0) return sum / count;
        return -2;

    }



    public static int calculate(int[][] skills, int R , int C) {
        int sum = 0;
        for(int r = 0 ; r < R; r++) {
            for(int c = 0 ; c < C; c++) {
                if(skills[r][c] != -1) {
                    sum += skills[r][c];
                }
            }
        }
        return sum;
    }
}