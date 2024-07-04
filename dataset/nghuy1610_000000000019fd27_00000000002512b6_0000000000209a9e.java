
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static String find10(Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            String res = scanner.next();
            if (res.equals("N")) {
                System.exit(-1);
            }
            sb.append(res);
        }
        return sb.toString();
    }

    static String flip(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }
    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.insert(0, c);
        }
        return sb.toString();
    }

    static String find20(Scanner scanner) {
        List<List<String>> returnQuery = new ArrayList<>();
        int round = 0;
        for (int i = 0; i < 2; i++) {
            StringBuilder sb = new StringBuilder();
            String res1;
            String res2;
            for (int j = 1; j <= 5; j++) {
                System.out.println(j + round*5);
                sb.append(scanner.next());
            }
            res1 = sb.toString();
            sb = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                System.out.println(20-j - round * 5);
                sb.append(scanner.next());
            }
            res2 = sb.toString();
            List<String> resList = new ArrayList<>();
            resList.add(res1);
            resList.add(res2);
            round++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            sb.append(scanner.next());
        }
        String first4 = sb.toString().substring(0, 5);
        String sec4 = sb.toString().substring(5);
        if (sec4.equals(returnQuery.get(1).get(0))) {
            sb.append(returnQuery.get(1).get(1));
        } else if (sec4.equals(flip(returnQuery.get(1).get(0)))) {
            sb.append(flip(returnQuery.get(1).get(1)));
        } else if (sec4.equals(reverse(returnQuery.get(1).get(1)))) {
            sb.append(reverse(returnQuery.get(1).get(0)));
        } else {
            sb.append(flip(reverse(returnQuery.get(1).get(0))));
        }
        
        if (first4.equals(returnQuery.get(0).get(0))) {
            sb.append(returnQuery.get(0).get(1));
        } else if (first4.equals(flip(returnQuery.get(0).get(0)))) {
            sb.append(flip(returnQuery.get(0).get(1)));
        } else if (first4.equals(reverse(returnQuery.get(0).get(1)))) {
            sb.append(reverse(returnQuery.get(0).get(0)));
        } else {
            sb.append(flip(reverse(returnQuery.get(0).get(0))));
        }
        return sb.toString();
    }
    static String find(int b, Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        if (b == 10) {
            return find10(scanner);
        } else if (b == 20) {
            return find20(scanner);
        } else {
            return "";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int round = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = 0; i < round; i++) {
            System.out.println(find(b, scanner));
            String result = scanner.next();
            if (result.equals("N")) {
                break;
            }
        }
    }
}
