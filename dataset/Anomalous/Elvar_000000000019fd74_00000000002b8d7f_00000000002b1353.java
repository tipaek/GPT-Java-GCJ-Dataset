import java.util.Scanner;

public class CodeJamPascal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ":");
            
            if (N <= 100) {
                for (int i = 1; i <= N; i++) {
                    System.out.println(i + " " + 1);
                }
            } else {
                int M = N - 30;
                int[] binaryRepresentation = toBinary(M);
                int sum = 0;
                int position = 1;

                for (int i = 1; i <= binaryRepresentation.length; i++) {
                    if (binaryRepresentation[i - 1] == 0) {
                        System.out.println(i + " " + position);
                        sum += 1;
                        if (position != 1) position++;
                    } else {
                        sum += (int) Math.pow(2, i - 1);
                        if (position == 1) {
                            for (int j = 1; j <= i; j++) {
                                System.out.println(i + " " + j);
                            }
                            position = i + 1;
                        } else {
                            for (int j = i; j >= 1; j--) {
                                System.out.println(i + " " + j);
                            }
                            position = 1;
                        }
                    }
                }

                int k = 1;
                while (sum < N) {
                    if (position == 1) {
                        System.out.println((binaryRepresentation.length + k) + " " + 1);
                    } else {
                        System.out.println((binaryRepresentation.length + k) + " " + (binaryRepresentation.length + k));
                    }
                    sum++;
                    k++;
                }
            }
        }
        
        scanner.close();
    }

    private static int[] toBinary(int number) {
        int length = (int) Math.ceil(Math.log(number) / Math.log(2)) + 1;
        int[] binaryArray = new int[length];
        
        for (int i = 0; i < length; i++) {
            binaryArray[i] = number % 2;
            number /= 2;
        }
        
        return binaryArray;
    }
}