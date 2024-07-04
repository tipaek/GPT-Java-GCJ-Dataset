import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int test=obj.nextInt();
        int Case=1;
        while(test-->0){
            int n=obj.nextInt();
            String arr[]=new String[n];
            int temp_len=0,temp_index=0;
            String temp_string="";
            for (int i=0;i<n;i++){
                arr[i]=obj.next();
                int temp=arr[i].length();
                if(temp>temp_len)
                {
                    temp_string=arr[i];
                    temp_index=i;
                    temp_len=temp;
                }
            }
//            System.out.println(temp_string);
            String s1, s2=temp_string;
            int i=0;
            for (i=0;i<n;i++) {
                if(i!=temp_index) {
                    s1 = arr[i].substring(1);
                    if(check(s1,s2))
                        continue;
                    else
                        break;
                }
            }
            if(i==n)
                System.out.println("Case #"+ (Case++) + ": "+temp_string.substring(1));
            else
                System.out.println("Case #"+ (Case++) + ": "+"*");
//            for (String a: arr) {
//                System.out.println(a);
//            }
    }
}
    public  static boolean check(String s1,String s2){
         return s2.endsWith(s1);
    }
}

