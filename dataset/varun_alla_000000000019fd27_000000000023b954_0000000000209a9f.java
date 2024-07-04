import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count =1;
        while(t-->0){
            String ka = sc.next();
            char c[] = ka.toCharArray();
            String s = "";
            int open =0;
            for(int i=0;i<c.length ;i++){
                int k = Integer.parseInt(String.valueOf(c[i]));
                if(open==k){
                    s+=String.valueOf(k);
                }
                else if(open<k){
                    while(open!=k)
                    {
                        s+="(";
                        open++;
                    }
                    s+=String.valueOf(k);
                }
                else if(open>k){
                    
                    while(open!=k)
                    {
                        s+=")";
                        open--;
                    }
					 s+=String.valueOf(k);
                }
                }
            while(open>0)
                    {
                        s+=")";
                        open--;
                    }
            System.out.println("Case #"+count+++": "+s);
        }
		}
    }
