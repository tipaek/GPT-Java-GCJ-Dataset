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
    // complement, reverse, reverse and complement, no change
    private static int lastRec = 1;
    
    private static int numBits;
    private static Scanner scan;
    
    private static void explore() {
        System.out.println(Integer.toString(search));
        int input = scan.nextInt();
        array[search] = input;
        numQueries++;
        
        if (search == array.length / 2 + 1) finished = true;
        
        lastRec = search > numBits / 2 ? numBits + 1 - search : search - 1;
        //lastRec is the last integer which has its complement in the array
        
        search = numBits + 1 - search + increment;
        increment = (increment + 1) % 2;
        
        if (numQueries % 10 == 0) {
            explore = false;
            lastChange = Arrays.stream(lastChange)
                .map(i -> 1).toArray();
        }
    }
    
    private static void investigate() {
        int iter = 0;
        int lookAt = 1;
        
        while (iter < 10 && Arrays.stream(lastChange).sum() > 1) {
            System.out.println(Integer.toString(lookAt));
            int input = scan.nextInt();
            numQueries++;
            if (array[lookAt] == input) {
                lastChange[0] = 0; // wasn't complement
            } else {
                lastChange[3] = 0; // something changed
            }
            if (array[numBits + 1 - lookAt] == input) {
                // wasn't reverse and complement
                lastChange[2] = 0;
            } else {
                // wasn't reverse
                lastChange[1] = 0;
            }
            lookAt++;
            iter++;
        }
        if (iter == 10 || Arrays.stream(lastChange).sum() != 1) {
            System.err.println("Error: could not determine change");
        } else {
            if (lastChange[0] == 1) { // we should complement
                complement();
            } else if (lastChange[1] == 1) { // we should reverse
                reverse();
            } else if (lastChange[2] == 1) { // we should do both
                complement();
                reverse();
            } else {} // do nothing
            explore = true;
        }
    }
    
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        int numTests = scan.nextInt();
        numBits = scan.nextInt();
        for (int j = 0; j < numTests; j++) {
            array = new int[numBits + 1]; // ignore 0th entry
            
            System.out.println(Integer.toString(search));
            int input = scan.nextInt();
            array[search] = input;
            numQueries++;
            search = numBits + 1 - search + increment;
            increment = (increment + 1) % 2;
            
            while (!finished) {
                if (!explore) {
                    // investigation mode. what happened on last change?
                    investigate();
                } else {
                    // explore mode. find more data
                    explore();
                }
            }
            
            String result = "";
            
            for (int i = 1; i <= numBits; i++) {
                result += (array[i] == 0 ? '0' : '1');
            }
            
            System.out.println(result);
            
            scan.nextLine(); // consume \n
            
            String confirmation = scan.nextLine();
            if (confirmation.charAt(0) == 'N') {
                System.err.println("Error in output.");
                return;
            }
        }
    }
    
    private static void reverse() {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    
    private static void complement() {
        array = Arrays.stream(array).map(i -> (i + 1) % 2).toArray();
    }
}