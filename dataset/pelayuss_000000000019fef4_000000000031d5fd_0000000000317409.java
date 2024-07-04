import java.util.Scanner;
public class Solution{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int c=1; c<=T; c++){
            int x = s.nextInt();
            int y = s.nextInt();
            String path = s.next();
            char pathcito[] = path.toCharArray();
            boolean sePudo = false;
            int i = 0;
            for(i=0; i<pathcito.length; i++){
                if( pathcito[i] == 'N' ){
                    y++;
                }
                else if( pathcito[i] == 'S' ){
                    y--;
                }
                else if( pathcito[i] == 'E' ){
                    x++;
                }
                else{
                    x--;
                }
                int lejos = Math.abs(x) + Math.abs(y);
                if( lejos <= i+1 ){
                    sePudo = true;
                    break;
                }
            }
            if( sePudo ){
                System.out.println("Case #"+c+": "+(i+1));
            }
            else{
                System.out.println("Case #"+c+": IMPOSSIBLE");
            }

        }
    }
}
