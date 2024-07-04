import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line=line.trim();
        String[] arr=line.split(" ");
        int testcase = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        char[] ch = new char[b];
        for(int test=1;test<=testcase;test++){
            for(int i=1;i<=150;i+=10){
                if(i==1){
                    for(int j=1;j<=10;j++){
                        System.out.println(j);
                        ch[j-1] = sc.nextLine().charAt(0); 
                    }
                }
                for(int j=11;j<=20;j++){
                    System.out.println(j);
                    ch[j-1] = sc.nextLine().charAt(0); 
                }
                if(i==21){
                    for(int j=11;j<=20;j++){
                        System.out.println(j);
                        ch[j-1] = sc.nextLine().charAt(0); 
                    }
                }
                if(i==21)
                    break;
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