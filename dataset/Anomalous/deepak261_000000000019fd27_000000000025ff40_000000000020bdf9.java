import java.util.*;

class Solution {
    private static Scanner sc;
    static int testCaseNumber = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() {
        int n = sc.nextInt();
        int[][] matrix = new int[n][2];
        int[][] sortedMatrix = matrix.clone();
        char currentPerson = 'J';
        char[] resultChars = new char[n];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean isImpossible = false;
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
            indexMap.put(matrix[i], i);
        }

        Arrays.sort(sortedMatrix, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < sortedMatrix.length; i++) {
            resultChars[indexMap.get(sortedMatrix[i])] = currentPerson;
            if (i < sortedMatrix.length - 1 && overlap(sortedMatrix[i], sortedMatrix[i + 1])) {
                if (currentPerson == 'J') {
                    JStack.push(sortedMatrix[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!CStack.isEmpty() && overlap(CStack.peek(), sortedMatrix[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    CStack.push(sortedMatrix[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!JStack.isEmpty() && overlap(JStack.peek(), sortedMatrix[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    JStack.push(sortedMatrix[i]);
                } else {
                    CStack.push(sortedMatrix[i]);
                }
            }
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(resultChars)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean overlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}