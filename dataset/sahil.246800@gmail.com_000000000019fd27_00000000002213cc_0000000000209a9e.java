import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        for(int i =1; i<=t; i++){
            StringBuffer ans = new StringBuffer();
            int count = 1,query = 1;
            while(count<=b){
                if(query%10==1){
                    System.out.println("1");
                    int n = sc.nextInt();
                }
                else{
                    System.out.println(""+count);
                    String s = sc.next();
                    ans.append(s.charAt(0));
                    count++;
                }
                query++;
            }
            System.out.println(ans);
            if(sc.next().equals("Y")){
                continue;
            }
            else{
                System.exit(0);
            }
        }
        sc.close();
    }
}