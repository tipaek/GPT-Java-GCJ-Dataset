import java.util.*;
class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		    int t=sc.nextInt();
            for(int k=1;k<=t;k++){
                String s=sc.next(),ans="";
                int n=s.length(),prev=s.charAt(0);
                for(int i=0;i<n;i++){
                    if(i==0 && s.charAt(i)>0){
                        int x=(int)s.charAt(i)-48;
                        while(x-->0){
                            ans+="(";
                        }
                        prev=(int)s.charAt(i)-48;
                    }
                    else{
                        int x=(int)s.charAt(i)-48;
                        if(x>prev){
                            while(x-prev>0){
                                ans+="(";
                                x--;
                            }
                        }
                        else if(prev>x){
                            while(prev-x>0){
                                ans+=")";
                                prev--;
                            }
                        }
                        prev=(int)s.charAt(i)-48;
                    }
                    ans+=s.charAt(i);
                }
                while(prev-->0){
                    ans+=")";
                }
                System.out.println("Case #"+k+": "+ans);
            }
	}
}

