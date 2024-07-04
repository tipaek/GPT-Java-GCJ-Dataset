
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
            for (int j = 4; j >= 0; j--) {
                System.out.println(20-j - round * 5);
                sb.append(scanner.next());
            }
            res2 = sb.toString();
            List<String> resList = new ArrayList<>();
            resList.add(res1);
            resList.add(res2);
            returnQuery.add(resList);
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
        static String findRespectiveRightPart(String current, List<String> history) {
        if (current.equals(history.get(0))) {
            return history.get(1);
        } else if (current.equals(reverse(history.get(1)))) {
            return reverse(history.get(0));
        } else if (current.equals(flip(history.get(0)))) {
            return flip(history.get(1));
        } else {
            return reverse(flip(history.get(0)));
        }
    }

    static String findWithAnyB(Scanner scanner, int b) {
        List<List<String>> queryResult = new ArrayList<>();
        for (int i = 0; i < b / 10; i++) {
            List<String> resultList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= 5; j++) {
                System.out.println(j + i * 5);
                sb.append(scanner.next());
            }
            resultList.add(sb.toString());
            sb = new StringBuilder();
            for (int j = 4; j >= 0; j--) {
                System.out.println(b - j - i*5 );
                sb.append(scanner.next());
            }
            resultList.add(sb.toString());
            queryResult.add(resultList);
        }
        if (b == 10) {
            return queryResult.get(0).get(0) + queryResult.get(0).get(1);
        }
        List<String> leftParts = new ArrayList<>();
        for (int i = 0; i < b / 10 - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 10; j++) {
                System.out.println(j + i * 5);
                sb.append(scanner.next());
            }
            leftParts.add(sb.toString());
        }
        int nPart = b / 5;
        String[] parts = new String[nPart];
        parts[nPart / 2 - 1] = leftParts.get(nPart / 2 - 2).substring(5);
        parts[nPart / 2 - 2] = leftParts.get(nPart / 2 - 2).substring(0, 5);
        parts[nPart / 2] = findRespectiveRightPart(parts[nPart / 2 - 1], queryResult.get(nPart / 2 -1));
        parts[nPart /2 + 1] = findRespectiveRightPart(parts[nPart / 2 -2], queryResult.get(nPart / 2 -2));
        for (int i = nPart / 2 - 3; i >= 0; i--) {
            String leftPart = leftParts.get(i);
            String subLeft = leftPart.substring(0, 5);
            String subRight = leftPart.substring(5);
            String respLeft = findRespectiveRightPart(subLeft, queryResult.get(i));
            String respRight = findRespectiveRightPart(subRight, queryResult.get(i+1));
            if (parts[i+1].equals(subRight)) {
                parts[i] = subLeft;
            } else if (parts[i+1].equals(flip(subRight))) {
                parts[i] = flip(subLeft);
            } else if (parts[i+1].equals(reverse(respRight))) {
                parts[i] = reverse(respLeft);
            } else {
                parts[i] = flip(reverse(respLeft));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(part);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int round = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = 0; i < round; i++) {
            System.out.println(findWithAnyB(scanner, b));
            String result = scanner.next();
            if (result.equals("N")) {
                break;
            }
        }
    }
}
