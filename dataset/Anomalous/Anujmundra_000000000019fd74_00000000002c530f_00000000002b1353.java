import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            System.out.println("Case #" + t + ":");
            
            List<Integer> currentRow = new ArrayList<>(Arrays.asList(1, 1));
            System.out.println("1 1");
            n--;

            if (n > 0) {
                System.out.println("2 1");
                n--;
                int rowNumber = 2;

                while (n > 0) {
                    List<Integer> nextRow = new ArrayList<>();
                    rowNumber++;
                    nextRow.add(1);

                    for (int j = 0; j < currentRow.size() - 1; j++) {
                        nextRow.add(currentRow.get(j) + currentRow.get(j + 1));
                    }
                    nextRow.add(1);

                    for (int j = 0; j < nextRow.size(); j++) {
                        if (n >= nextRow.get(j)) {
                            n -= nextRow.get(j);
                            System.out.println(rowNumber + " " + (j + 1));
                        } else {
                            break;
                        }
                    }

                    currentRow = new ArrayList<>(nextRow);
                }
            }
        }

        sc.close();
    }
}