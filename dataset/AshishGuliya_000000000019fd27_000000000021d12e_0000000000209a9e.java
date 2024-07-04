import java.lang.reflect.Array;
import java.util.*;

class Activity {
    private final int START_TIME;
    private final int END_TIME;
    private char owner;

    Activity(int start_time, int end_time) {
        START_TIME = start_time;
        END_TIME = end_time;
    }

    public int getSTART_TIME() {
        return START_TIME;
    }

    public int getEND_TIME() {
        return END_TIME;
    }

    public char getOwner() {
        return owner;
    }

    public void setOwner(char owner) {
        this.owner = owner;
    }
}

public class Solution {

    private static Scanner scanner;

    private static Comparator<Activity> byStart = Comparator.comparing(Activity::getSTART_TIME);
    private static Comparator<Activity> byEnd = Comparator.comparing(Activity::getEND_TIME);

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        esab();
    }

    private static void esab() {
        int N;
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        int array[] = new int[B];
        int i;
        int result;
        for (int t = 1; t <= T; t++) {
            i = 0;
            for (int j = 1; j <= B; j++) {
                System.out.println(j);
                array[j - 1] = scanner.nextInt();
            }
            for (int digit : array) {
                System.out.print(digit);
            }
            System.out.println();
            result = 'A' + scanner.nextInt();
            if(result == 'N')
                break;
        }
    }
}