import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int depth = 0;
    static int[] diag = new int[1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCases = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        boolean darnIt = false;

        for (int i = 0; i < numCases; i++) {
            int[] array = new int[size];
            Arrays.fill(array, -1);

            int currentQuery = 0;
            int counter = 0;
            int invIndex = -1; // find bits that are the same
            int revIndex = -1; // find bits that are different

            while (counter < array.length) {
                if (currentQuery % 10 == 0 && currentQuery != 0) {
                    if (invIndex != -1) {
                        System.out.println(invIndex + 1);
                        String line = br.readLine();
                        if (line.charAt(0) == 'N') {
                            System.out.println("Darn it");
                            darnIt = true;
                            break;
                        }
                        currentQuery++;
                        int hold = Integer.parseInt(line);
                        if (array[invIndex] != hold)
                            invert(array);
                    } else {
                        System.out.println(1);
                        br.readLine();
                        currentQuery++;
                    }
                    if (revIndex != -1) {
                        System.out.println(revIndex + 1);
                        String line = br.readLine();
                        if (line.charAt(0) == 'N') {
                            System.out.println("Darn it");
                            darnIt = true;
                            break;
                        }
                        currentQuery++;
                        int hold = Integer.parseInt(line);
                        if (array[revIndex] != hold)
                            reverse(array);
                    } else {
                        System.out.println(1);
                        br.readLine();
                        currentQuery++;
                    }
                }
                if (counter % 2 == 0) {
                    System.out.println(counter / 2 + 1);
                } else {
                    System.out.println(array.length - counter / 2);
                }

                String line = br.readLine();
                if (line.charAt(0) == 'N') {
                    System.out.println("Darn it");
                    darnIt = true;
                    break;
                }
                int hold = Integer.parseInt(line);
                if (counter % 2 == 0) {
                    array[counter / 2] = hold;
                } else {
                    array[array.length - counter / 2 - 1] = hold;
                    if (invIndex == -1 && array[array.length - counter / 2 - 1] == array[counter / 2])
                        invIndex = counter / 2;
                    if (revIndex == -1 && array[array.length - counter / 2 - 1] != array[counter / 2])
                        revIndex = counter / 2;
                }
                currentQuery++;
                counter++;
            }
            if (darnIt)
                break;

            print(array);
            String line = br.readLine();
            if (line.charAt(0) == 'N') {
                System.out.println("Darn it");
                darnIt = true;
                break;
            }
        }
    }

    public static void invert(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    public static void reverse(int[] array) {
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[array.length - i - 1] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }

    public static void print(int[] array) {
        StringBuilder line = new StringBuilder();
        for (int i : array) {
            line.append(i);
        }
        System.out.println(line);
    }
}