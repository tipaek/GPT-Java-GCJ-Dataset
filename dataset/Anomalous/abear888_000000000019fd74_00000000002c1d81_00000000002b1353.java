import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int number = scanner.nextInt();
            boolean isEven = (number % 2 == 0);
            String binaryString = Integer.toBinaryString(number);
            boolean isLeft = true;
            List<Integer> rowList = new ArrayList<>();
            List<Integer> colList = new ArrayList<>();
            int extraSteps = 0;
            
            while (number > 0) {
                if (number == 1) {
                    rowList.add(1);
                    colList.add(1);
                    number = 0;
                } else if (binaryString.charAt(0) == '1') {
                    int remaining = number - (int) Math.pow(2, binaryString.length() - 1);
                    if (remaining < binaryString.length() - 1) {
                        rowList.add(binaryString.length());
                        colList.add(isLeft ? 1 : binaryString.length());
                        extraSteps = number - (int) Math.pow(2, binaryString.length() - 1);
                        number = (int) Math.pow(2, binaryString.length() - 1) - 1;
                        binaryString = Integer.toBinaryString(number);
                    } else {
                        for (int i = 0; i < binaryString.length(); i++) {
                            rowList.add(binaryString.length());
                            colList.add(isLeft ? i + 1 : binaryString.length() - i);
                        }
                        isLeft = !isLeft;
                        number -= Math.pow(2, binaryString.length() - 1);
                        binaryString = binaryString.substring(1);
                    }
                } else {
                    rowList.add(binaryString.length());
                    colList.add(isLeft ? 1 : binaryString.length());
                    number -= 1;
                    binaryString = Integer.toBinaryString(number);
                }
            }
            
            System.out.println("Case #" + caseNum + ":");
            for (int i = rowList.size() - 1; i >= 0; i--) {
                System.out.println(rowList.get(i) + " " + colList.get(i));
            }
            
            int lastRow = rowList.get(0);
            for (int i = 1; i <= extraSteps; i++) {
                System.out.println(lastRow + i + " " + 1);
            }
        }
    }
}