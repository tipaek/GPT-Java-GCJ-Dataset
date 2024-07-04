import java.util.Scanner;

class Solution {
    public static void main(String[] commands) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();
        
        for (int t = 1; t <= testCases; t++) {
            char[] data = new char[bitLength];
            int left = 1;
            int right = bitLength;
            
            while (left < right) {
                System.out.println(left);
                System.out.flush();
                String responseLeft = scanner.nextLine();
                
                System.out.println(right);
                System.out.flush();
                String responseRight = scanner.nextLine();
                
                if (responseLeft.equals(responseRight)) {
                    data[left - 1] = 'S';
                    data[right - 1] = 'S';
                } else {
                    data[left - 1] = 'D';
                    data[right - 1] = 'D';
                }
                
                left++;
                right--;
            }
            
            char[] result = new char[bitLength];
            for (int i = bitLength / 2 - 1; i >= 0; i--) {
                System.out.println(i + 1);
                System.out.flush();
                String response = scanner.nextLine();
                char bit = response.charAt(0);
                
                if (bit == '0') {
                    result[i] = '0';
                    if (data[i] == 'S') {
                        result[bitLength - i - 1] = '0';
                    } else {
                        result[bitLength - i - 1] = '1';
                    }
                } else if (bit == '1') {
                    result[i] = '1';
                    if (data[i] == 'S') {
                        result[bitLength - i - 1] = '1';
                    } else {
                        result[bitLength - i - 1] = '0';
                    }
                }
            }
            
            System.out.println(new String(result));
            System.out.flush();
            String verification = scanner.nextLine();
        }
        
        scanner.close();
        System.exit(0);
    }
}