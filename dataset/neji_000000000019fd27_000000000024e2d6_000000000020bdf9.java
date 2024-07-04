
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    private static class Pair {
        public int item1;
        public int item2;

        public Pair(int item1, int item2) {
            this.item1 = item1;
            this.item2 = item2;
        }
    }

    public static void main(String[] args) {
        InputStream is = System.in;
        String result = "";
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            ArrayList<Pair> taskA = new ArrayList<>();
            ArrayList<Pair> taskB = new ArrayList<>();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int input = scanner.nextInt();
                boolean isImpossible = false;
                for (int i = 0; i < input; i++) {
                    int inp1 = scanner.nextInt();
                    int inp2 = scanner.nextInt();
                    Pair pair = new Pair(inp1, inp2);
                    boolean isValidForA = true;
                    boolean isValidForB = true;
                    for (int j = 0; j < taskA.size(); j++) {
                        Pair sample = taskA.get(j);
                        if ((pair.item1 > sample.item1 && pair.item1 < sample.item2)
                                || (pair.item2 > sample.item1 && pair.item2 < sample.item2)) {
                            isValidForA = false;
                            break;
                        }
                    }
                    if (isValidForA) {
                        taskA.add(pair);
                        result = result + "C";
                    } else {
                        for (int j = 0; j < taskB.size(); j++) {
                            Pair sample = taskB.get(j);
                            if ((pair.item1 > sample.item1 && pair.item1 < sample.item2)
                                    || (pair.item2 > sample.item1 && pair.item2 < sample.item2)) {
                                isValidForB = false;
                                break;
                            }
                        }
                        if (isValidForB) {
                            taskB.add(pair);
                            result = result + "J";
                        } else {
                            System.out.println("Case #" + testNumber + ": " + "IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }

                    }
                }
                if (!isImpossible)
                    System.out.println("Case #" + testNumber + ": " + result);
            }
            // System.out.println("Case #" + testNumber + ": " + diagSum + " " +
            // duplicateRow + " " + duplicateColumn);
        } catch (Exception e) {
        }
    }}

    

    
    
    
    
    
    
        
            
                
            
                
            
        
    
    
        
    
    
    
