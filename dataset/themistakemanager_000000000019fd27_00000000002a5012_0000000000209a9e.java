import java.util.*;
public class Solution{

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        for(int k = 1; k<=t; k++){
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= b; i++){
                System.out.println(i);
				System.out.flush();
                sb.append(sc.next());
            }
            
            System.out.println(sb.toString());
			System.out.flush();
			
			if("N".equals(sc.next())){
				return;
			}
			
        }
        
    }
}