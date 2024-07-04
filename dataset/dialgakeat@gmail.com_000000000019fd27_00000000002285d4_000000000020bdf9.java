import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        
        for(int i = 1; i<=t ; i++){
            int n = scan.nextInt();
            boolean impossible = false;
            boolean[] c = new boolean[1440];
            boolean[] j = new boolean[1440];
            String result = "";
            for(int a = 0; a< n; a++){
                int s = scan.nextInt();
                int e = scan.nextInt();
                boolean cok = true;
                boolean jok = true;
                for (int x = s ; x < e ; x++){
                    if(c[x] == true){
                        cok = false;
                        break;
                    }
                }
                if(cok){
                    for (int x = s ; x < e ; x++){
                        c[x] = true;
                    }
                }else{
                    for (int x = s ; x < e ; x++){
                        if(j[x] == true){
                            jok = false;
                            break;
                        }
                    }
                    if(jok){
                        for (int x = s ; x < e ; x++){
                            j[x] = true;
                        }
                    }
                }

                
                if(cok){
                    result += 'J';
                }else if(jok){
                    result += 'C'; 
                }else{
                    impossible = true;
                }
            }
            if(impossible){
                result = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}