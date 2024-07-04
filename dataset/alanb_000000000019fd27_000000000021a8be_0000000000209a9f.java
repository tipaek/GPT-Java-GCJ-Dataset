import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < t; i++){
            String s = scan.nextLine() + "0";//the zero will bring it down, truncate the end
            StringBuilder sP = new StringBuilder();
            int cur = 0;
            for(int j = 0; j < s.length(); j++){
                int temp = Integer.parseInt("" + s.charAt(j));
                while(cur!= temp){
                    if (temp > cur){
                        sP.append("(");
                        cur++;
                    } else {
                        sP.append(")");
                        cur--;
                    }
                }
                sP.append(s.charAt(j));
            }
            System.out.println(sP.toString().substring(0,sP.toString().length()-1));
        }
        scan.close();
    }
}