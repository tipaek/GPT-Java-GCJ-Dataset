import java.util.*;


class Solution{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int tr = sc.nextInt();
        sc.nextLine();
        for(int i=1;i<=tr;++i){
            String str = sc.nextLine();
            int[] digits = new int[str.length()];
            for(int j=0;j<str.length();++j)
                digits[j] = str.charAt(j) - '0';
            // for(int x: digits)
            //   System.out.print(x+" ");
            // System.out.println();
            String res = "";
            res = res + "(".repeat(digits[0]);
            // System.out.println(res);
            for(int j=0;j<digits.length-1;++j){
                res = res + digits[j];
                int diff = digits[j+1] - digits[j];
                if(diff == 0)
                    continue;
                else if(diff > 0)
                    res = res + "(".repeat(diff);
                else
                    res = res + ")".repeat(-diff);
            }
            res = res + digits[digits.length-1];
            res = res + ")".repeat(digits[digits.length-1]);
            System.out.println("Case #"+i+": "+res);
        }
      sc.close();
    }
}