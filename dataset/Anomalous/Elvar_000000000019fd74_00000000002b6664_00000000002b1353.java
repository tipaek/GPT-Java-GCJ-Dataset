import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + caseNum + ":");
            
            if (N < 30) {
                for (int i = 1; i <= N; i++) {
                    System.out.println(i + " " + 1);
                }
            } else {
                int modifiedN = N > 30 ? N - 30 : N;
                int[] binaryRepresentation = toBinary(modifiedN);
                int sum = 0;
                int column = 1;
                
                for (int i = 1; i <= binaryRepresentation.length; i++) {
                    if (binaryRepresentation[i - 1] == 0) {
                        System.out.println(i + " " + column);
                        sum++;
                        if (column != 1) column++;
                    } else {
                        sum += Math.pow(2, i - 1);
                        if (column == 1) {
                            for (int j = 1; j <= i; j++) {
                                System.out.println(i + " " + j);
                            }
                            column = i + 1;
                        } else {
                            for (int j = i; j >= 1; j--) {
                                System.out.println(i + " " + j);
                            }
                            column = 1;
                        }
                    }
                }
                
                int row = 1;
                while (sum < N) {
                    if (column == 1) {
                        System.out.println((binaryRepresentation.length + row) + " " + 1);
                    } else {
                        System.out.println((binaryRepresentation.length + row) + " " + (binaryRepresentation.length + row));
                    }
                    sum++;
                    row++;
                }
            }
        }
    }
    
    public static int[] toBinary(int number) {
        int length = (int) Math.ceil(Math.log(number) / Math.log(2));
        int[] binaryArray = new int[length];
        
        for (int i = 0; i < length; i++) {
            binaryArray[i] = number % 2;
            number /= 2;
        }
        
        return binaryArray;
    }
}