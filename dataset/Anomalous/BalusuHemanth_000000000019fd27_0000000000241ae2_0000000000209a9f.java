import java.util.Scanner;

class TestClass {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int suvoCount = 0, suvojitCount = 0;
            String s = sc.nextLine().toUpperCase();

            while (s.contains("SUVOJIT")) {
                suvojitCount++;
                int index = s.indexOf("SUVOJIT");
                s = s.substring(0, index) + s.substring(index + "SUVOJIT".length());
            }

            while (s.contains("SUVO")) {
                suvoCount++;
                int index = s.indexOf("SUVO");
                s = s.substring(0, index) + s.substring(index + "SUVO".length());
            }

            System.out.println("SUVO = " + suvoCount + ", SUVOJIT = " + suvojitCount);
        }
    }
}