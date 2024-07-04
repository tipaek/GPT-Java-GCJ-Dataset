import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tt = scanner.nextInt();

        for(int i = 0; i < tt; i++){
            int n = scanner.nextInt();
            String result = "";

            int[] Cameron = new int[1000000];
            int[] Jamie = new int[1000000];

            for(int j = 0; j < n; j++) {
                int s = scanner.nextInt();
                int e = scanner.nextInt();

                int empty = 0;
                int diff = e-s;
                for(int k = s; k < e; k++){
                    if(Cameron[k] != 1){
                        empty += 1;
                    }
                }

                if(empty == diff){
                    result += "C";
                    for(int k = s; k < e; k++){
                        Cameron[k] = 1;
                    }
                }else{
                    empty = 0;
                    for(int k = s; k < e; k++){
                        if(Jamie[k] != 1){
                            empty += 1;
                        }
                    }

                    if(empty == diff){
                        result += "J";
                        for(int k = s; k < e; k++){
                            Jamie[k] = 1;
                        }
                    }else{
                        result = "IMPOSSIBLE";
                    }

                }

            }

            System.out.println("Case #"+ (i+1) + ": " + result);

        }

    }
}
