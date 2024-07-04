import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testcase=sc.nextInt();
        sc.nextLine();
        for(int test=1;test<=testcase;test++){
            String s = sc.nextLine();
            char[] ch = s.toCharArray();
            int[] arr = new int[s.length()];
            for(int i=0;i<ch.length;i++){
                arr[i] = ch[i]-'0';
            }
            int left=0;
            int start=0;
            int close=0;
            String res="";
            int i=0;
            for(i=0;i<s.length()-1;i++){
                int a=arr[i];
                left = start>a?start-a:a-start;
                for(int j=0;j<left;j++)
                    res+='(';
                    start = start+left;
                    res+=ch[i];
                close = arr[i+1]<a?a-arr[i+1]:0;
                for(int j=0;j<close;j++)
                    res+=')';
                    start-=close;
            }
            left =start>arr[i]?start-arr[i]:arr[i]-start;
            for(int j=0;j<left;j++)
                res+='(';
                res+=ch[i];
            for(int j=0;j<arr[i];j++)
                res+=')';
            System.out.println("Case #"+test+": "+res);
        }
    }
}