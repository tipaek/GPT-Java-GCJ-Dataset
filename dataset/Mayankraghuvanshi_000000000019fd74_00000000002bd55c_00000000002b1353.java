import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner scn =  new Scanner(System.in);
        int tc = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        int tcCount =1;
        while(tc-->0){
            long n =scn.nextInt();
            sb.append("Case #"+tcCount+":").append("\n");
            long sum=1,temp =1, rem=1,cos=1;
            sb.append(rem+" "+cos).append("\n");
            cos++;
            while(sum+temp<=n){
                sum+=temp;
                temp++;
                rem++;
                sb.append(rem+" "+cos).append("\n");
            }
            cos--;
            while(sum!=n){
                sum++;
                sb.append(rem+" "+cos).append("\n");
                rem++;
            }
            tcCount++;
        }
        System.out.println(sb);
    }
}