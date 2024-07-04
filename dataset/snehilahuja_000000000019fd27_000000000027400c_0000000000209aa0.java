import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0; i < t; i++) {
            int n = 0;
            int k = 0;
            int count = i + 1;
            n = s.nextInt();
            k = s.nextInt();
            int flag = 0;
            if((k == n + 1) || (k == (n * n) - 1)) {
                flag = 1;
            }
            if(flag == 0) {
                System.out.println("Case "+ count + ": Possible"); 
            }
            if(flag == 1) {
                System.out.println("Case "+ count + ": Impossible");
            }
        }   
	}
}