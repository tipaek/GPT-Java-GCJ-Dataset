import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int iteration=0; iteration<T; iteration++){
            String input = sc.nextLine();
            String output = "";
            for(int i=0; i<input.length(); i++){
                int temp = Integer.parseInt(input.substring(i, i+1));
                String out1 = input.substring(i, i+1);
                for(int j=0; j<temp; j++){
                    out1 = "(" + out1 + ")";
                }
                output = output + out1;
            }
            while(output.contains(")(")){
                output = output.replace(")(", "");
            }
            System.out.println("Case #"+ (iteration+1) + ": " + output);
        }
        sc.close();
    }
}