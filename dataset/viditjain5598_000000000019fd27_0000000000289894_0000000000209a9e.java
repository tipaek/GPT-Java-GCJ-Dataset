import java.util.*;

public class Solution{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();
        while(T-->0){
            
            StringBuilder temp = new StringBuilder();
            for(int i=0; i<B; i++){
                System.out.println((i+1));
                String s = in.nextLine();
                temp.append(s);
            }
        
            System.out.println(temp.toString());
            String an = in.nextLine();
            if(an.equals("Y")) continue;
        }
    }
}