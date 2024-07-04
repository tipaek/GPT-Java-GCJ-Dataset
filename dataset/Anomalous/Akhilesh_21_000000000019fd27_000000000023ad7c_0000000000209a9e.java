import java.util.*;

class ESABATAD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            List<String> responses = new ArrayList<>();
            boolean exit = false;

            for (int j = 1, queryCount = 1; j <= 150; j++) {
                System.out.println(queryCount);
                String response = sc.next();
                
                if (j % 10 == 1) {
                    // Do nothing with f, it's not used in the logic
                } else {
                    responses.add(response);
                    queryCount++;
                }

                if (responses.size() == b) {
                    StringBuilder result = new StringBuilder();
                    for (String bit : responses) {
                        result.append(bit);
                    }
                    System.out.println(result.toString());
                    
                    String verdict = sc.next();
                    if ("N".equals(verdict)) {
                        exit = true;
                        break;
                    } else if ("Y".equals(verdict)) {
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