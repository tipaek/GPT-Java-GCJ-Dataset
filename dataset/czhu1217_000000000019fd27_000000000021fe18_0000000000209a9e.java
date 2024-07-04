import java.util.*;
public class jamp4{
    public static void main(String[] args){
        boolean a[] = new boolean[12];
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            for(int i=1;i<=10;i++){
                System.out.println(i);
                a[i] = sc.nextBoolean();
            }
            for(int i=1;i<=10;i++){
                System.out.print(a[i]);

            }
            System.out.println();
        }


    }
}