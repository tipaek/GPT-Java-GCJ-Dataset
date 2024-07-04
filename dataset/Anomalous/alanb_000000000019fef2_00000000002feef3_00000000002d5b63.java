import java.io.FileNotFoundException;
import java.util.Scanner;

class TargetFinder {
    static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            boolean hit = false;
            boolean centerFound = false;
            int hitX = 0, hitY = 0;

            for (int i = -1000000000 + a / 2; i <= 1000000000 && !hit && !centerFound; i += a) {
                for (int j = -1000000000 + a / 2; j <= 1000000000 && !hit && !centerFound; j += a) {
                    int response = query(i, j);
                    if (response == 1) {
                        hitX = i;
                        hitY = j;
                        hit = true;
                    } else if (response == 2) {
                        centerFound = true;
                    }
                }
            }

            int distance = Math.abs((hitX + 1000000000)) / 4;
            int x1 = (hitX - 1000000000) / 2, x2 = (hitX + 1000000000) / 2;
            int y1 = (hitY - 1000000000) / 2, y2 = (hitY + 1000000000) / 2;

            while (distance > 0 && !centerFound) {
                int response = query(x1, hitY);
                if (response == 0) {
                    x1 += distance;
                } else if (response == 1) {
                    x1 -= distance;
                } else {
                    centerFound = true;
                }
                distance >>= 1;
            }

            distance = Math.abs((1000000000 - hitX)) / 4;
            while (distance > 0 && !centerFound) {
                int response = query(x2, hitY);
                if (response == 0) {
                    x2 -= distance;
                } else if (response == 1) {
                    x2 += distance;
                } else {
                    centerFound = true;
                }
                distance >>= 1;
            }

            distance = Math.abs((hitY + 1000000000)) / 4;
            while (distance > 0 && !centerFound) {
                int response = query(hitX, y1);
                if (response == 0) {
                    y1 += distance;
                } else if (response == 1) {
                    y1 -= distance;
                } else {
                    centerFound = true;
                }
                distance >>= 1;
            }

            distance = Math.abs((1000000000 - hitY)) / 4;
            while (distance > 0 && !centerFound) {
                int response = query(hitX, y2);
                if (response == 0) {
                    y2 -= distance;
                } else if (response == 1) {
                    y2 += distance;
                } else {
                    centerFound = true;
                }
                distance >>= 1;
            }

            hitX = (x1 + x2) / 2;
            hitY = (y1 + y2) / 2;

            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    if (!centerFound) {
                        int response = query(hitX + i, hitY + j);
                        if (response == 2) {
                            centerFound = true;
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    public static int query(int x, int y) {
        System.out.print(x + " " + y);
        String response = scanner.next();
        switch (response) {
            case "MISS":
                return 0;
            case "HIT":
                return 1;
            case "CENTER":
                return 2;
            default:
                throw new IllegalStateException("Unexpected response: " + response);
        }
    }
}