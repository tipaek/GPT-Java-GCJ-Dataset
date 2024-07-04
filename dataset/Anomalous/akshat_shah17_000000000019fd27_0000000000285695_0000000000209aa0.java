import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int j = 0; j < t; j++) {
            int no = sc.nextInt();
            int val = sc.nextInt();
            System.out.print("Case #" + (j + 1) + ": ");
            
            if (no == 2) {
                handleCase2(val);
            } else if (no == 3) {
                handleCase3(val);
            } else if (no == 4) {
                handleCase4(val);
            } else if (no == 5) {
                handleCase5(val);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
    
    private static void handleCase2(int val) {
        if (val == 2) {
            System.out.println("POSSIBLE");
            System.out.println("1 2");
            System.out.println("2 1");
        } else if (val == 3) {
            System.out.println("IMPOSSIBLE");
        } else if (val == 4) {
            System.out.println("POSSIBLE");
            System.out.println("2 1");
            System.out.println("1 2");
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
    
    private static void handleCase3(int val) {
        switch (val) {
            case 3:
                System.out.println("POSSIBLE");
                System.out.println("1 2 3");
                System.out.println("3 1 2");
                System.out.println("2 3 1");
                break;
            case 6:
                System.out.println("POSSIBLE");
                System.out.println("3 2 1");
                System.out.println("2 1 3");
                System.out.println("1 3 2");
                break;
            case 9:
                System.out.println("POSSIBLE");
                System.out.println("3 2 1");
                System.out.println("1 3 2");
                System.out.println("2 1 3");
                break;
            default:
                System.out.println("IMPOSSIBLE");
                break;
        }
    }
    
    private static void handleCase4(int val) {
        switch (val) {
            case 4:
            case 6:
                System.out.println("POSSIBLE");
                System.out.println("1 2 3 4");
                System.out.println("2 1 4 3");
                System.out.println("3 4 2 1");
                System.out.println("4 3 1 2");
                break;
            case 7:
                System.out.println("POSSIBLE");
                System.out.println("1 2 3 4");
                System.out.println("3 1 4 2");
                System.out.println("4 3 2 1");
                System.out.println("2 4 1 3");
                break;
            case 8:
                System.out.println("POSSIBLE");
                System.out.println("1 4 3 2");
                System.out.println("2 1 4 3");
                System.out.println("4 3 2 1");
                System.out.println("3 2 1 4");
                break;
            case 9:
                System.out.println("POSSIBLE");
                System.out.println("2 4 3 1");
                System.out.println("1 2 4 3");
                System.out.println("4 3 1 2");
                System.out.println("3 1 2 4");
                break;
            case 10:
                System.out.println("POSSIBLE");
                System.out.println("1 3 4 2");
                System.out.println("4 2 1 3");
                System.out.println("2 4 3 1");
                System.out.println("3 1 2 4");
                break;
            case 11:
                System.out.println("POSSIBLE");
                System.out.println("1 2 4 3");
                System.out.println("3 4 1 2");
                System.out.println("4 3 2 1");
                System.out.println("2 1 3 4");
                break;
            case 12:
                System.out.println("POSSIBLE");
                System.out.println("4 2 3 1");
                System.out.println("2 4 1 3");
                System.out.println("3 1 2 4");
                System.out.println("1 3 4 2");
                break;
            case 13:
                System.out.println("POSSIBLE");
                System.out.println("4 3 2 1");
                System.out.println("2 4 1 3");
                System.out.println("1 2 3 4");
                System.out.println("3 1 4 2");
                break;
            case 14:
                System.out.println("POSSIBLE");
                System.out.println("3 4 1 2");
                System.out.println("4 3 2 1");
                System.out.println("2 1 4 3");
                System.out.println("1 2 3 4");
                break;
            case 16:
                System.out.println("POSSIBLE");
                System.out.println("4 3 2 1");
                System.out.println("3 4 1 2");
                System.out.println("2 1 4 3");
                System.out.println("1 2 3 4");
                break;
            default:
                System.out.println("IMPOSSIBLE");
                break;
        }
    }
    
    private static void handleCase5(int val) {
        switch (val) {
            case 5:
                System.out.println("POSSIBLE");
                System.out.println("1 2 3 4 5");
                System.out.println("2 1 5 3 4");
                System.out.println("3 4 1 5 2");
                System.out.println("4 5 2 1 3");
                System.out.println("5 3 4 2 1");
                break;
            case 7:
                System.out.println("POSSIBLE");
                System.out.println("1 5 2 3 4");
                System.out.println("2 1 4 5 3");
                System.out.println("3 2 1 4 5");
                System.out.println("4 3 5 2 1");
                System.out.println("5 4 3 1 2");
                break;
            case 8:
                System.out.println("POSSIBLE");
                System.out.println("1 2 5 4 3");
                System.out.println("3 1 2 5 4");
                System.out.println("4 3 1 2 5");
                System.out.println("2 5 4 3 1");
                System.out.println("5 4 3 1 2");
                break;
            case 9:
                System.out.println("POSSIBLE");
                System.out.println("3 4 2 1 5");
                System.out.println("2 1 5 3 4");
                System.out.println("4 2 1 5 3");
                System.out.println("5 3 4 2 1");
                System.out.println("1 5 3 4 2");
                break;
            case 10:
                System.out.println("POSSIBLE");
                System.out.println("1 5 3 4 2");
                System.out.println("2 1 5 3 4");
                System.out.println("5 3 4 2 1");
                System.out.println("3 4 2 1 5");
                System.out.println("4 2 1 5 3");
                break;
            case 11:
                System.out.println("POSSIBLE");
                System.out.println("2 3 4 1 5");
                System.out.println("4 1 5 2 3");
                System.out.println("1 5 2 3 4");
                System.out.println("5 2 3 4 1");
                System.out.println("3 4 1 5 2");
                break;
            case 12:
                System.out.println("POSSIBLE");
                System.out.println("1 4 2 3 5");
                System.out.println("5 1 4 2 3");
                System.out.println("2 3 5 1 4");
                System.out.println("3 5 1 4 2");
                System.out.println("4 2 3 5 1");
                break;
            case 13:
                System.out.println("POSSIBLE");
                System.out.println("1 5 3 2 4");
                System.out.println("5 3 2 4 1");
                System.out.println("2 4 1 5 3");
                System.out.println("4 1 5 3 2");
                System.out.println("3 2 4 1 5");
                break;
            case 14:
                System.out.println("POSSIBLE");
                System.out.println("2 4 3 5 1");
                System.out.println("1 2 4 3 5");
                System.out.println("4 3 5 1 2");
                System.out.println("3 5 1 2 4");
                System.out.println("5 1 2 4 3");
                break;
            case 15:
                System.out.println("POSSIBLE");
                System.out.println("1 3 5 2 4");
                System.out.println("5 2 4 1 3");
                System.out.println("3 5 2 4 1");
                System.out.println("4 1 3 5 2");
                System.out.println("2 4 1 3 5");
                break;
            case 16:
                System.out.println("POSSIBLE");
                System.out.println("5 2 3 1 4");
                System.out.println("1 4 5 2 3");
                System.out.println("2 3 1 4 5");
                System.out.println("3 1 4 5 2");
                System.out.println("4 5 2 3 1");
                break;
            case 17:
                System.out.println("POSSIBLE");
                System.out.println("1 5 2 4 3");
                System.out.println("4 3 1 5 2");
                System.out.println("3 1 5 2 4");
                System.out.println("5 2 4 3 1");
                System.out.println("2 4 3 1 5");
                break;
            case 18:
                System.out.println("POSSIBLE");
                System.out.println("2 4 5 1 3");
                System.out.println("4 5 1 3 2");
                System.out.println("1 3 2 4 5");
                System.out.println("3 2 4 5 1");
                System.out.println("5 1 3 2 4");
                break;
            case 19:
                System.out.println("POSSIBLE");
                System.out.println("1 4 3 2 5");
                System.out.println("2 5 1 4 3");
                System.out.println("5 1 4 3 2");
                System.out.println("4 3 2 5 1");
                System.out.println("3 2 5 1 4");
                break;
            case 20:
                System.out.println("POSSIBLE");
                System.out.println("5 2 4 1 3");
                System.out.println("3 5 2 4 1");
                System.out.println("4 1 3 5 2");
                System.out.println("1 3 5 2 4");
                System.out.println("2 4 1 3 5");
                break;
            case 21:
                System.out.println("POSSIBLE");
                System.out.println("5 3 4 2 1");
                System.out.println("1 5 3 4 2");
                System.out.println("3 4 2 1 5");
                System.out.println("4 2 1 5 3");
                System.out.println("2 1 5 3 4");
                break;
            case 22:
                System.out.println("POSSIBLE");
                System.out.println("5 3 1 2 4");
                System.out.println("4 5 3 1 2");
                System.out.println("1 2 4 5 3");
                System.out.println("2 4 5 3 1");
                System.out.println("3 1 2 4 5");
                break;
            case 23:
                System.out.println("POSSIBLE");
                System.out.println("5 1 4 3 2");
                System.out.println("4 5 2 1 3");
                System.out.println("3 4 5 2 1");
                System.out.println("2 3 1 4 5");
                System.out.println("1 2 3 5 4");
                break;
            case 25:
                System.out.println("POSSIBLE");
                System.out.println("5 2 4 1 3");
                System.out.println("3 5 2 4 1");
                System.out.println("1 3 5 2 4");
                System.out.println("4 1 3 5 2");
                System.out.println("2 4 1 3 5");
                break;
            default:
                System.out.println("IMPOSSIBLE");
                break;
        }
    }
}