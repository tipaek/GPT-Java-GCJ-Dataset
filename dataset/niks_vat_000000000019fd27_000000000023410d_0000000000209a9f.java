import java.util.*;

class Solution{
    
    
    public static void main(String... args){
        
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=1;t<=T;t++){
            
            String s = in.next();

            String snew = compute(s,0);
            System.out.println("Case #"+t+": "+snew);
        }
        
    }

    public static String compute(String s, int dec){

        int n = s.length();
        if(n==0){
            return "";
        }
        
        int min = Integer.MAX_VALUE;
        int pos=-1;
        for(int i=0;i<n;i++){
            if(Integer.parseInt(String.valueOf(s.charAt(i)))<min){
                min = Integer.parseInt(String.valueOf(s.charAt(i)));
                pos=i;
            }
        }


        
        String ans = "";
        for(int i=0;i<min-dec;i++){
            ans+="(";
        }

        //if range exist

        int leftindex=pos;
        int rightindex=pos;
        while(leftindex>=0 && s.charAt(leftindex)==s.charAt(pos)){
            leftindex--;
        }
        leftindex++;

        while(rightindex<n && s.charAt(rightindex)==s.charAt(pos)){
            rightindex++;
        }
        rightindex--;



        String left = compute(s.substring(0,leftindex),min);
        String right = compute(s.substring(rightindex+1),min);

        ans+=left;
        ans+=s.substring(leftindex,rightindex+1);
        ans+=right;

        for(int i=0;i<min-dec;i++){
            ans+=")";
        }

        return ans;

    }

    
}