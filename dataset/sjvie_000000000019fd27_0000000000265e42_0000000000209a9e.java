import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountCases = scanner.nextInt();
        int b = scanner.nextInt();

        for(int currentCase = 1; currentCase <= amountCases; currentCase ++){
            solve(scanner, b);
        }
    }

    public static void solve(Scanner scanner, int b){
        int[] bits = new int[b];
        Arrays.fill(bits, -1);

        int diffPair = -1;
        int samePair = -1;

        boolean done = false;
        int q = 1;
        int currPair = 0;
        do{
            System.out.println(currPair+1);
            bits[currPair] = scanner.nextInt();
            System.out.println(b-currPair);
            bits[b-currPair-1] = scanner.nextInt();

            if(diffPair == -1){
                if(bits[currPair] != bits[b-currPair-1]){
                    diffPair = currPair;
                }
            }
            if(samePair == -1){
                if(bits[currPair] == bits[b-currPair-1]){
                    samePair = currPair;
                }
            }

            currPair ++;
            if(currPair >= b/2){
                break;
            }

            if(q%5 == 0){
                boolean complement = false;
                boolean reverse = false;
                if(samePair != -1){
                    System.out.println(samePair+1);
                    int newVal = scanner.nextInt();
                    if(newVal != bits[samePair]){
                        complement = true;
                    }
                }else{
                    System.out.println(0);
                    scanner.nextInt();
                }
                if(diffPair != -1){
                    System.out.println(diffPair+1);
                    int newVal = scanner.nextInt();
                    if(newVal == bits[diffPair]){
                        if(complement){
                            reverse = true;
                        }
                    }else{
                        if(!complement){
                            reverse = true;
                        }
                    }
                }else{
                    System.out.println(0);
                    scanner.nextInt();
                }
                q++;

                if(complement){
                    for (int i = 0; i < b; i++) {
                        if(bits[i] != -1){
                            if(bits[i] == 1){
                                bits[i] = 0;
                            }else{
                                bits[i] = 1;
                            }
                        }
                    }
                }
                if(reverse){
                    for (int i = 0; i < b/2; i++) {
                        if(bits[i] != -1){
                            int tmp = bits[i];
                            bits[i] = bits[b-i-1];
                            bits[b-i-1] = tmp;
                        }
                    }
                }
            }

            q++;
        }while(q <= 150);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b; i++) {
            sb.append(bits[i]);
        }

        System.out.println(sb.toString());

        String answer = scanner.next();
        if(answer.equals("N")){
            System.exit(0);
        }
    }
}