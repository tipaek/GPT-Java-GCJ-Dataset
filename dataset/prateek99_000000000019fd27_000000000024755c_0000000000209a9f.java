import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t1 = sc.nextInt();
        sc.nextLine();
        int count=0;
        while(++count<=t1){
            String s=sc.nextLine();
            String f="";
            int c = 0;
            for(int i=0;i<s.length();i++){
                int d = s.charAt(i)-48;
                System.out.println("Detected "+d);
                if(d>c){
                    for(int x=0;x<d-c;x++){
                        f+="(";
                    }
                    c+=(d-c);
                }
                else if(d<c){
                    for(int x=0;x<c-d;x++){
                        f+=")";
                    }
                    c-=(c-d);
                }
                f+=d;
            }
            while(c-->0)
                f+=")";
            System.out.print("Case #"+count+": "+f+"\n");
        }
    }
}