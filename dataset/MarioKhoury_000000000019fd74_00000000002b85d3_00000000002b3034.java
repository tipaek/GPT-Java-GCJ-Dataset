
import java.util.Scanner;
import java.util.regex.Pattern; 
public class Solution {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1;i<=t;i++){
            int n = sc.nextInt();
            sc.nextLine();
            String temp = sc.nextLine();
            String max = temp;
            boolean is = true;
            for(int j = 1;j<n;j++)
            {
                String s = sc.nextLine();
                if(s.length() >= temp.length()){
                    if (Pattern.matches(temp.replace("*", ".*"),s.replace("*", ".*"))){
                        temp = s;
                    }else{
                        is = false;
                    }
                }else{
                    if (Pattern.matches(s.replace("*", ".*"),temp.replace("*", ".*"))){

                    }else{
                        is = false;
                    }
                }
                    
            }
            if (is) {
                temp = temp.replace("*","");
                System.out.println("Case #" + i + ": " + temp);
            }
            else System.out.println("Case #" + i + ": *" );
 
        }
    }
    
}
