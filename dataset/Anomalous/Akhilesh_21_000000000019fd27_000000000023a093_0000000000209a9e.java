import java.util.ArrayList;
import java.util.Scanner;

public class ESABATAD {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            ArrayList<String> s = new ArrayList<>();
            ArrayList<String> f = new ArrayList<>();
            boolean exit = false;
            int k = 1;

            for (int j = 1; j < 150; j++) {
                System.out.println(k);
                String response = sc.nextLine();
                
                if (j % 10 == 1) {
                    f.add(response);
                } else {
                    s.add(response);
                    k++;
                }

                if (s.size() == b) {
                    StringBuilder val = new StringBuilder();
                    for (String bit : s) {
                        val.append(bit);
                    }
                    System.out.println(val.toString());
                    String ans = sc.nextLine();
                    
                    if (ans.equals("N")) {
                        exit = true;
                        break;
                    } else if (ans.equals("Y")) {
                        exit = false;
                        break;
                    }
                }
            }
            
            if (exit) {
                break;
            }
        }
        
        sc.close();
    }
}