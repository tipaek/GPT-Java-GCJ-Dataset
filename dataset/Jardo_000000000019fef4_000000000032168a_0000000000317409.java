package sk.liptak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String tour = scanner.next();

            int px = 0;
            int py = 0;

            if (Math.abs(x - px) + Math.abs(y - py) == 0)
                System.out.println("Case #" + (i+1) +": "+ (0));

            boolean possible = false;

            List<Tour> nextTour = new ArrayList<>();

            for (int j = 0; j < tour.length(); j++) {
                char c = tour.charAt(j);

                switch (c) {
                    case 'W':
                        px--;
                        break;
                    case 'E':
                        px++;
                        break;
                    case 'N':
                        py--;
                        break;
                    case 'S':
                        py++;
                        break;
                }

                Tour tour1 = new Tour();
                tour1.x = px;
                tour1.y = py;
                tour1.dist = Math.abs(px - x) + Math.abs(py - y);
                nextTour.add(tour1);
            }

            for (int j = 0; j < nextTour.size(); j++) {
                Tour c = nextTour.get(j);
                if(c.dist <= j+1)
                {
                    System.out.println("Case #" + (i+1) +": "+ (j+1));
                    possible=true;
                    break;
                }
            }

            if (!possible)
                System.out.println("Case #" + (i+1) +": " + "IMPOSSIBLE");
        }

    }

    static class Tour {
        public int x;
        public int y;
        public int dist;
    }
}
