import java.util.Scanner;
import java.util.Arrays;

class Solution {
    private static boolean finished = false;
    private static int numQueries = 0;
    private static int[] array;
    private static boolean explore = true;
    private static int increment = 0;
    private static int search = 1;
    private static int[] lastChange = {0, 0, 0, 0};
    private static int lastRec = 1;
    
    private static int numBits;
    private static Scanner scan;
    
    private static void explore() {
        System.out.println(search);
        int input = scan.nextInt();
        array[search] = input;
        numQueries++;
        
        if (search == array.length / 2 + 1) finished = true;
        
        lastRec = (search > numBits / 2) ? (numBits + 1 - search) : (search - 1);
        
        search = numBits + 1 - search + increment;
        increment = (increment + 1) % 2;
        
        if (numQueries % 10 == 0) {
            explore = false;
            Arrays.fill(lastChange, 1);
        }
    }
    
    private static void investigate() {
        int iter = 0;
        int lookAt = 1;
        
        while (iter < 10 && Arrays.stream(lastChange).sum() > 1) {
            System.out.println(lookAt);
            int input = scan.nextInt();
            numQueries++;
            if (array[lookAt] == input) {
                lastChange[0] = 0;
            } else {
                lastChange[3] = 0;
            }
            if (array[numBits + 1 - lookAt] == input) {
                lastChange[2] = 0;
            } else {
                lastChange[1] = 0;
            }
            lookAt++;
            iter++;
        }
        if (iter == 10 || Arrays.stream(lastChange).sum() != 1) {
            System.err.println("Error: could not determine change");
        } else {
            if (lastChange[0] == 1) {
                complement();
            } else if (lastChange[1] == 1) {
                reverse();
            } else if (lastChange[2] == 1) {
                complement();
                reverse();
            }
            explore = true;
        }
    }
    
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        int numTests = scan.nextInt();
        numBits = scan.nextInt();
        for (int j = 0; j < numTests; j++) {
            array = new int[numBits + 1];
            
            System.out.println(search);
            int input = scan.nextInt();
            array[search] = input;
            numQueries++;
            search = numBits + 1 - search + increment;
            increment = (increment + 1) % 2;
            
            while (!finished) {
                if (!explore) {
                    investigate();
                } else {
                    explore();
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= numBits; i++) {
                result.append(array[i] == 0 ? '0' : '1');
            }
            
            System.out.println(result);
            
            scan.nextLine();
            String confirmation = scan.nextLine();
            if (confirmation.charAt(0) == 'N') {
                System.err.println("Error in output.");
                return;
            }
        }
    }
    
    private static void reverse() {
        for (int i = 1; i <= array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i];
            array[array.length - i] = temp;
        }
    }
    
    private static void complement() {
        for (int i = 1; i < array.length; i++) {
            array[i] = (array[i] + 1) % 2;
        }
    }
}