import java.util.Scanner;

public class Solution {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            StringBuilder output = new StringBuilder();
            
            switch (n) {
                case 1:
                    output.append("1 1");
                    break;
                case 2:
                    output.append("1 1").append(LINE_SEPARATOR).append("2 1");
                    break;
                case 3:
                    output.append("1 1").append(LINE_SEPARATOR).append("2 1").append(LINE_SEPARATOR).append("2 2");
                    break;
                case 4:
                    output.append("1 1").append(LINE_SEPARATOR).append("2 1").append(LINE_SEPARATOR).append("3 2");
                    break;
                default:
                    int sum = 4, row = 3, col = 2;
                    output.append("1 1").append(LINE_SEPARATOR).append("2 1").append(LINE_SEPARATOR).append("3 2");
                    
                    while (n - sum >= row) {
                        sum += row;
                        row++;
                        output.append(LINE_SEPARATOR).append(row).append(" ").append(col);
                    }
                    
                    if (sum < n) {
                        col--;
                        sum++;
                        output.append(LINE_SEPARATOR).append(row).append(" ").append(col);
                    }
                    
                    while (sum < n) {
                        row++;
                        sum++;
                        output.append(LINE_SEPARATOR).append(row).append(" ").append(col);
                    }
                    break;
            }

            System.out.println("Case #" + testCase + ":");
            System.out.println(output.toString());
        }
    }
}