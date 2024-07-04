import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();
        s.nextLine();
        for (int t = 1; t <= testCases; t++) {
            int r = s.nextInt();
            int c = s.nextInt();
            int[][] skills = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    skills[i][j] = s.nextInt();
                }
            }

            long interestLevel = solve(skills, r, c);

            System.out.format("Case #%d: %s\n", t, interestLevel);
        }
    }

    private static long solve(int[][] skills, int r, int c) {
        long interest = 0;
        long totalElims = 0;
        List<Long> eliminations = new ArrayList<>();
        while (true) {
            long roundInterest = 0;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    roundInterest += skills[i][j];
                    if (eliminatable(skills, i, j, r, c)) {
                        eliminations.add(enc(i, j));
                    }
                }
            }

            interest += roundInterest;
            if (eliminations.isEmpty()) {
                break;
            }
            totalElims += eliminations.size();
            eliminations.stream().forEach(l -> eliminate(skills, l));
            eliminations.clear();
            if(totalElims == r*c) {
                break;
            }
        }
        return interest;
    }

    private static boolean eliminatable(int[][] skills, int i, int j, int r, int c) {
        int base = skills[i][j];
        if(base == 0) {
            return false;
        }
        int mult = 0;
        int cmp = 0;
        for (int x = i - 1; x >= 0; x--) {
            int skill = skills[x][j];
            if (skill > 0) {
                mult++;
                cmp += skill;
                break;
            }
        }

        for (int x = i + 1; x < r; x++) {
            int skill = skills[x][j];
            if (skill > 0) {
                mult++;
                cmp += skill;
                break;
            }
        }

        for (int x = j - 1; x >= 0; x--) {
            int skill = skills[i][x];
            if (skill > 0) {
                mult++;
                cmp += skill;
                break;
            }
        }

        for (int x = j + 1; x < c; x++) {
            int skill = skills[i][x];
            if (skill > 0) {
                mult++;
                cmp += skill;
                break;
            }
        }

        return base * mult < cmp;
    }

    private static void eliminate(int[][] skills, long l) {
        int r = (int) (l / 1000_000);
        int c = (int) (l % 1000_000);
        skills[r][c] = 0;
    }

    private static long enc(int r, int c) {
        return r * 1000_000 + c;
    }
}