import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int b=sc.nextInt();
        char[] ch = new char[b];
        for(int test=1;test<=testcase;test++){
            for(int i=1;i<=150;i++){
                System.out.println(j);
                ch[j] = sc.nextLine().charAt(0); 
                if(i==31){
                    for(int j=1;j<=b;j++){
                        System.out.println(j);
                        ch[j] = sc.nextLine().charAt(0); 
                    }
                    break;
                }
            }
            String s="";
            for(int i=0;i<b;i++){
                s+=ch[i];
            }
            System.out.println(s);
            char c = sc.nextLine().charAt(0);
            if(c=='N')
                break;
        }
    }
}