import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int n = 1; n <= cases; n++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x == 0 && y == 0){
                System.out.println("Case #" + n + ": ");
                continue;
            }
            char xDir = x < 0?'W':'E';
            char yDir = y < 0?'S':'N';
            int bigger = Math.max(Math.abs(x), Math.abs(y));
            int lower = Math.min(Math.abs(x), Math.abs(y));
            char lowerDir = lower == Math.abs(x)?xDir:yDir;
            char biggerDir = lowerDir == xDir?yDir:xDir;
            char changedDir = ' ';
            switch(biggerDir){
                case 'S':
                    changedDir = 'N';
                break;
                case 'N':
                    changedDir = 'S';
                break;
                case 'E':
                    changedDir = 'W';
                break;
                case 'W':
                    changedDir = 'E';
                break;
            }
            boolean changed = false;
            boolean possible = true;
            int changePoint = -1;
            String s = Integer.toBinaryString(lower);
            int acc = 0;
            for(int i = s.length()-1; i >= 0; i--){
                if(s.charAt(i)=='1')continue;
                acc+= (int)Math.pow(2,(s.length()-1) - i);
            }
            int pow = s.length();
            while(acc < bigger){
                int add = (int)Math.pow(2,pow);
                if(add + acc > bigger){
                    if(changed){
                        possible = false;
                        break;
                    }
                    acc = Math.abs(acc - add);
                    changed = true;
                    changePoint = pow;
                    if(acc > bigger) possible = false;
                }else{
                    acc+= add;
                }
                pow++;
            }
            String result = "";
            
            if(!possible)
                result = "IMPOSSIBLE";
            else{
                StringBuilder b = new StringBuilder();  
                b.append(s); 
                b = b.reverse();
                s=b.toString();
                StringBuilder builder = new StringBuilder(pow);
                for(int i = 0; i < pow; i++){
                    if(i >= s.length()){
                        if(changed && i < changePoint){
                            builder.append(changedDir);
                        }else{
                            builder.append(biggerDir);
                        }   
                    }else{
                        if(s.charAt(i) == '1'){
                            builder.append(lowerDir);
                        }else{
                            if(changed && i < changePoint){
                                builder.append(changedDir);
                            }else{
                                builder.append(biggerDir);
                            }
                        }
                    }
                }
                result = builder.toString();
            }
            System.out.println("CASE #" + n + ": " + result);
        }
    }
}