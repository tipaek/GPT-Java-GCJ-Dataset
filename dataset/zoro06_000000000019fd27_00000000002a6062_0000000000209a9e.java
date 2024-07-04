
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); 
        String[] numbers = input.split(",");
        
        int T =  Integer.parseInt(numbers[0]);
        int B =  Integer.parseInt(numbers[1]);

        System.out.println(T);
        System.out.println(B);
        for(int casenum = 1; casenum <= T; casenum++) {
            if(!qualhelper(B)) {
                break;
            }
        }
    }

    public static boolean qualhelper(int B){
        Scanner sc = new Scanner(System.in);
        if(B<=10){
            StringBuilder sb = new StringBuilder();
            for(int k=1; k<=B; k++){
                System.out.print(k);
                System.out.println();
                String val = sc.next();
                sb.append(val);
            }
            System.out.print(sb);
            System.out.println();
            String res = sc.nextLine();
            if (res.equals("Y")){
                return true;
            }
            else{
                System.exit(0);
            }

        }
        return false;
    }
}
