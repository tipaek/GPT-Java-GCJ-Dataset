import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int casos = Integer.parseInt(sc.nextLine());
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < casos; i++) {
            res.append("Case #").append(i + 1).append(": ");
            String linea = sc.nextLine();
            StringBuilder line = new StringBuilder();
            
            for (char ch : linea.toCharArray()) {
                switch (ch) {
                    case '0':
                        line.append("0");
                        break;
                    case '1':
                        line.append("(1)");
                        break;
                    case '2':
                        line.append("((2))");
                        break;
                    case '3':
                        line.append("(((3)))");
                        break;
                    case '4':
                        line.append("((((4))))");
                        break;
                    case '5':
                        line.append("(((((5)))))");
                        break;
                    case '6':
                        line.append("((((((6))))))");
                        break;
                    case '7':
                        line.append("(((((((7)))))))");
                        break;
                    case '8':
                        line.append("((((((((8))))))))");
                        break;
                    case '9':
                        line.append("(((((((((9)))))))))");
                        break;
                }
            }
            
            String lineStr = line.toString();
            while (lineStr.contains(")(")) {
                lineStr = lineStr.replace(")(", "");
            }
            
            res.append(lineStr).append("\n");
        }
        
        sc.close();
        System.out.println(res.toString());
    }
}