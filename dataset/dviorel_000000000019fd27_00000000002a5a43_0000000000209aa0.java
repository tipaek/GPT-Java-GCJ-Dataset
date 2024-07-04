import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int q = 1; q <= t; q++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (isPossible(n, k)){
                System.out.printf("Case #%d: POSSIBLE%n%s", q, getMatrix(n, k));
            }
            else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", q);
            }
        }
    }

    static boolean isPossible(int n, int k){
        switch (n){
            case 2:
                return k == 2 || k == 4;
            case 3:
                return k == 3 || k == 6 || k == 9;
            case 4:
                return k == 4 || k == 8 || k == 12 || k == 16 || k == 10;
            case 5:
                return k == 5 || k == 10 || k == 15 || k == 20 || k == 25;
        }
        return false;
    }

    static String getMatrix(int n, int k){
        switch (n){
            case 2:
                switch (k){
                    case 2:
                        return "1 2\n2 1\n";
                    case 4:
                        return "2 1\n1 2\n";
                }
            case 3:
                switch (k){
                    case 3:
                        return "1 2 3\n3 1 2\n2 3 1\n";
                    case 6:
                        return "2 1 3\n3 2 1\n1 3 2\n";
                    case 9:
                        return "3 1 2\n2 3 1\n1 2 3\n";
                }
            case 4:
                switch (k){
                    case 4:
                        return "1 2 3 4\n3 1 4 2\n2 4 1 3\n4 3 2 1\n";
                    case 8:
                        return "2 1 3 4\n3 2 4 1\n1 4 2 3\n4 3 1 2\n";
                    case 10:
                        return "1 4 2 3\n3 2 4 1\n4 1 3 2\n2 1 3 4\n";
                    case 12:
                        return "3 1 2 4\n2 3 4 1\n1 4 3 2\n4 2 1 3\n";
                    case 16:
                        return "4 1 2 3\n2 4 3 1\n1 3 4 2\n3 2 1 4\n";
                }
            case 5:
                switch (k){
                    case 5:
                        return "1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n";
                    case 10:
                        return "2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n";
                    case 15:
                        return "3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n";
                    case 20:
                        return "4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n";
                    case 25:
                        return "5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n";
                }
        }
        return null;
    }

}
