import java.util.Scanner;

public class Solution {




    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();

        for (int ks = 1; ks <= T; ks++) {
            for(int i=0;i<300;i++){
                int x=0;
                int y=0;
                System.out.println(x+ " "+ y);
                if(input.next().equals("CENTER"))
                    break;
                for(int j=1;j<5;j++){
                    System.out.println(x+ " "+ (y+j));
                    if(input.next().equals("CENTER"))
                        break;
                }
                for(int j=1;j<5;j++){
                    System.out.println(x+ " "+ (y-j));
                    if(input.next().equals("CENTER"))
                        break;
                }
                for(int j=1;j<5;j++){
                    System.out.println((x+j)+ " "+ (y+j));
                    if(input.next().equals("CENTER"))
                        break;
                }
                for(int j=1;j<5;j++){
                    System.out.println((x-j)+ " "+ (y-j));
                    if(input.next().equals("CENTER"))
                        break;
                }
                for(int j=1;j<5;j++){
                    System.out.println((x-j)+ " "+ (y+j));
                    if(input.next().equals("CENTER"))
                        break;
                }
                for(int j=1;j<5;j++){
                    System.out.println((x+j)+ " "+ (y-j));
                    if(input.next().equals("CENTER"))
                        break;
                }
                for(int j=1;j<5;j++){
                    System.out.println((x+j)+ " "+ (y));
                    if(input.next().equals("CENTER"))
                        break;
                }
                for(int j=1;j<5;j++){
                    System.out.println((x-j)+ " "+ (y));
                    if(input.next().equals("CENTER"))
                        break;
                }
                break;

            }
        }
    }
}