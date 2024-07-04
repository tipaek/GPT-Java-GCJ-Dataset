import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t = scan.nextInt();
        for(int test = 1; test<=t; test++){
            //int n = Integer.parseInt(scan.nextLine().trim());
            int n = scan.nextInt();
            scan.nextLine();
            String[] a = new String[n];
            int l = 0;
            for(int i=0;i<n;i++){
                String s = scan.nextLine();
                a[i] = s.substring(1);
                if(s.length() > a[l].length()){
                    l = i;
                }
            }
            boolean f = true;
            for(int i=0;i<n;i++){
                if(i==l)continue;
                if(!a[l].contains(a[i])) {
                    f = false;
                    break;
                }
            }
            System.out.printf("%nCase #%d: ",test);
            if(f){
                System.out.printf("%s",a[l]);
            }else{
                System.out.println("*");
            }

        }
    }
}
