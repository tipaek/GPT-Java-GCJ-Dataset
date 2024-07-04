import java.util.*;

/**
 * 02/05/20
 * Created by Himanshu
 **/
public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int q=1;q<=t;q++) {
            System.out.print("Case #" + q + ": ");
            int u = s.nextInt();
            char [] arr = new char[10];
            for (int i=0;i<10000;i++) {
                int x = s.nextInt();
                String str = s.next();
                if (x != -1) {
                    for (int j=str.length()-1;j>=0;j--) {
                        int temp = x%10;
                        arr[temp] = str.charAt(j);
                        x /=10;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<10;i++) sb.append(arr[i]);
            System.out.println(sb);
        }
    }
}
