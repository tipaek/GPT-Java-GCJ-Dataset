import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        int t=Integer.parseInt(str[0]);
        int b=Integer.parseInt(str[1]);
        for(int k=1;k<=t;k++)
        {
            int[] arr=new int[b+1];
            for(int i=1;i<=b;++i)
            {
                System.out.println(i);
                arr[i]=Integer.parseInt(br.readLine());
            }
            for(int i=1;i<=b;++i)
                System.out.print(arr[i]);
            System.out.println();
            char response=br.readLine().charAt(0);
            if(response=='N')
                break;
        }
    }
}
