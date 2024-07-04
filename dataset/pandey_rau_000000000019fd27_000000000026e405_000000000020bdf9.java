import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = in.nextInt();
            int[][] array = new int[size][2];
            int[][] sortedArray = new int[size][3];

            for (int index = 0; index < size; index++) {
                array[index][0] = in.nextInt();
                array[index][1] = in.nextInt();
                sortedArray[index][0] = array[index][0];
                sortedArray[index][1] = array[index][1];
                sortedArray[index][2] = index;
            }

            Arrays.sort(sortedArray, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if (ints[0] > t1[0])
                        return 1;
                    else
                        return -1;
                }
            });

            int cameron = 0;
            int jamie = 0;
            boolean check = false;

            Map<Integer, Character> integerCharacterMap = new HashMap<>();

            for (int index = 0; index < size; index++) {
                if (cameron <= sortedArray[index][0]) {
                    integerCharacterMap.put(sortedArray[index][2], 'C');
                    cameron = sortedArray[index][1];
                } else if (jamie <= sortedArray[index][0]) {
                    integerCharacterMap.put(sortedArray[index][2], 'J');
                    jamie = sortedArray[index][1];
                } else {
                    check = true;
                    break;
                }
            }

            if (check) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < size; i++) {
                    stringBuffer.append((char) integerCharacterMap.get(i));
                }
                System.out.println("Case #" + testCase + ": " + stringBuffer);
            }
        }
    }
}
