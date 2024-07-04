
import java.io.*;
import java.util.*;
public class Solution {
    
    static int depth = 0;
    static int[] diag = new int[1];
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numcases = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        boolean darnit = false;
        
        for (int i = 0; i < numcases; i++) {
            int[] array = new int[size];
            Arrays.fill(array, -1);
            
            int currentquery = 0;
            int counter = 0;
            int invindex = -1; // find bits that are the same
            int revindex = -1; // find bits that are different
            
            while (counter < array.length) {
                if (currentquery % 10 == 0 && currentquery != 0) {
                    if (invindex != -1) {
                        System.out.println(invindex + 1);
                        String line = br.readLine();
                        if (line.charAt(0) == 'N') {
                            System.out.println("Darn it");
                            darnit = true;
                            break;
                        }
                        currentquery++;
                        int hold = Integer.parseInt(line);
                        if (array[invindex] != hold)
                            invert(array);
                    } else {
                        System.out.println(1);
                        br.readLine();
                        currentquery++;
                    }
                    if (revindex != -1) {
                        System.out.println(revindex + 1);
                        String line = br.readLine();
                        if (line.charAt(0) == 'N') {
                            System.out.println("Darn it");
                            darnit = true;
                            break;
                        }
                        currentquery++;
                        int hold = Integer.parseInt(line);
                        if (array[revindex] != hold)
                            reverse(array);
                    } else {
                        System.out.println(1);
                        br.readLine();
                        currentquery++;
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
                    darnit = true;
                    break;
                }
                int hold = Integer.parseInt(line);
                if (counter % 2 == 0) {
                    array[counter / 2] = hold;
                } else {
                    array[array.length - counter / 2 - 1] = hold;
                    if (invindex == -1 && array[array.length - counter / 2 - 1] == array[counter / 2])
                        invindex = counter / 2;
                    if (revindex == -1 && array[array.length - counter / 2 - 1] != array[counter / 2])
                        revindex = counter / 2;
                }
                currentquery++;
                counter++;
            }
            if (darnit)
                break;
            
            print(array);
            String line = br.readLine();
            if (line.charAt(0) == 'N') {
                System.out.println("Darn it");
                darnit = true;
                break;
            }
            
        }
    }
    
    public static void invert(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 0)
                ar[i] = 1;
            else if (ar[i] == 1)
                ar[i] = 0;
        }
    }
    
    public static void reverse(int[] ar) {
        int[] hold = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            hold[ar.length - i - 1] = ar[i];
        }
        for (int i = 0; i < ar.length; i++) {
            ar[i] = hold[i];
        }
    }
    
    public static void print(int[] ar) {
        String line = "";
        for (int i : ar)
            line = line.concat(String.valueOf(i));
        System.out.println(line);
    }
}