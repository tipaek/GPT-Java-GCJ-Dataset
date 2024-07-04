import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int totalTests = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < totalTests; i++) {
            solve();
        }
    }

    public static void solve() {
        int numEvents = scanner.nextInt();
        int[][] events = new int[numEvents][2];
        char[] result = new char[numEvents];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean isImpossible = false;
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < numEvents; i++) {
            events[i][0] = scanner.nextInt();
            events[i][1] = scanner.nextInt();
            indexMap.put(events[i], i);
        }

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';
        for (int i = 0; i < numEvents; i++) {
            result[indexMap.get(events[i])] = currentPerson;

            if (i < numEvents - 1 && overlaps(events[i], events[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(events[i]);
                    currentPerson = switchPerson(currentPerson);
                    
                    if (!cStack.isEmpty() && overlaps(cStack.peek(), events[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(events[i]);
                    currentPerson = switchPerson(currentPerson);
                    
                    if (!jStack.isEmpty() && overlaps(jStack.peek(), events[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    jStack.push(events[i]);
                } else {
                    cStack.push(events[i]);
                }
            }
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean overlaps(int[] event1, int[] event2) {
        return event1[1] > event2[0];
    }
}