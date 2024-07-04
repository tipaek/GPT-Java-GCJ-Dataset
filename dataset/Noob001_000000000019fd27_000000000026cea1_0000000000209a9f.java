import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            String s= sc.next();
            int n=s.length();
            int[] digits=new int[n];
            for (int j=0;j<n;j++){
                digits[j]=Integer.valueOf(Character.toString(s.charAt(j)) );
            }
            int[][] paren=new int[n][2];//left parenthesis and right parenthesis count
            int ptr1=0;
            int ptr2=n-1;
            int l=0;
            int r=0;
            while(ptr1<n){
                if(digits[ptr1]==l){
                    ptr1++;
                }
                else if(digits[ptr1]>l){

                    paren[ptr1][0]=digits[ptr1]-l;
                    l+=digits[ptr1]-l;
                    ptr1++;
                }
                else{
                    l-=(l-digits[ptr1]);
                    ptr1++;
                }

            }
            while(ptr2>=0){
                if(digits[ptr2]==r){
                    ptr2--;
                }
                else if(digits[ptr2]>r){
                    paren[ptr2][1]=digits[ptr2]-r;
                    r+=digits[ptr2]-r;
                    ptr2--;
                }
                else{
                    r-=(r-digits[ptr2]);
                    ptr2--;
                }

            }
            String out= "";
            for (int j=0;j<n;j++){
                int left=paren[j][0];
                int right=paren[j][1];
                for (int k=0;k<left;k++){
                    out+="(";
                }
                out+=digits[j];
                for (int k=0;k<right;k++){
                    out+=")";
                }
            }
            System.out.println("Case #"+(i+1)+": "+out);

        }
    }
}