import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int x=1;x<=t;x++){
            String s=in.next();
            int n=s.length();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=s.charAt(i);
                a[i]=a[i]-48;
            }
            String y="";
            int open=0;
            for(int i=0;i<n;i++){
                if(open<a[i]){
                    for(int j=0;;j++){
                        open++;
                        y+='(';
                        if(open==a[i]){
                            break;
                        }
                    }
                    y+=""+a[i];
                }
                else if(a[i]<open){
                    for(int j=0;;j++){
                        open--;
                        y+=')';
                        if(open==a[i]){
                            break;
                        }
                    }
                    y+=""+a[i];
                }
                else{
                    y+=""+a[i];
                }
            }
            if(open!=0) {
            	while(open!=0) {
            		y+=')';
            		open--;
            	}
            }
            	System.out.println("Case #" + x + ": " + y);
        }
    }
}