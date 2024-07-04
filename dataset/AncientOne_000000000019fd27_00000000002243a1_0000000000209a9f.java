
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

 class NestingDepths {
    public static  void  main(String[] args){
        Scanner sc= new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t= sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String str=sc.next();
            int[] digits= new int[str.length()];
            for (int j = 0; j < str.length(); j++)
                digits[j]=str.charAt(j)-'0';
            StringBuilder ans=new StringBuilder();
            int cnt=digits[0],val;
            ans.append("(".repeat(cnt)).append(digits[0]);
            for (int j = 1; j < str.length(); j++) {
                val=digits[j]-cnt;
                if(val>0)
                    ans.append("(".repeat(val));
                else if (val<0)
                    ans.append(")".repeat(Math.abs(val)));
                ans.append(digits[j]);
                cnt+=val;
            }
            ans.append(")".repeat(cnt));
            System.out.println("Case #"+i+": "+ans);
        }
    }
}
