import java.util.*;
public class Solution{
    public static void main(String [] args){
      
		Scanner s= new Scanner(System.in);
        int t = s.nextInt();
        for(int j=1; j<=t; j++){
            String a= s.next();
            String ans ="";int i=0;
            while( i<a.length()){
                int b= a.charAt(i) - '0';
                int x=b;
                while(x!=0 &&( i==0 || (i>0 && a.charAt(i-1)=='0'))) {
                    ans += "(";
                    x--;
                }
                if(i>0 && a.charAt(i-1)<a.charAt(i) && a.charAt(i-1)!='0'){
                    int diff= a.charAt(i)- a.charAt(i-1);
                    x= b-diff;
                    while(x!=0){
                        ans += "(";
                        x--;
                    }
                }
                ans += a.charAt(i);
                if((i<a.length()-1 && a.charAt(i+1)!=a.charAt(i))|| i== a.length()-1){
                    if(i<a.length()-1 && a.charAt(i+1)!=a.charAt(i)){
                    int y = a.charAt(i+1) -'0';
                     for(int h=0;h<b-y;h++){
                    ans+= ')';
                }
                    }else{
                    while(b!=0){
                    ans += ')';
                    b--;
                    }
                    }
            }
            i++;
        }
        System.out.println("Case #"+ j+ ": "+ ans);
	}
    }
}