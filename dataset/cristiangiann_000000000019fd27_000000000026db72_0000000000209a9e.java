import java.util.Scanner;

public class Solution {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        int nTests = Integer.parseInt(input.split(" ")[0]);
        int B = Integer.parseInt(input.split(" ")[1]);
        if(B == 10) {
            for (int counter = 0; counter < nTests; counter++) {
                String result = "";
                for(int i = 0; i < B; i++){
                    System.out.println(i + 1);
                    result += (in.nextLine());
                }
                System.out.print(result);
                String serverResponse = in.nextLine();
                if(serverResponse == "N") return;
            }
        }
    }
}