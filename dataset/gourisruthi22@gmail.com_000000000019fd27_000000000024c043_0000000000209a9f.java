import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        String[] str=new String[t];
        for(int i=0;i<t;i++){
                str[i]=ob.next();
        }
        for(int i=0;i<t;i++){
                int j=0;
                while(j<str[i].length()){
                    if(str[i].charAt(j)=='1'){
                        System.out.print("(");
                        int k=j;
                        while(str[i].charAt(k)!='0'){
                            System.out.print(str[i].charAt(k));
                            k++;
                            if(k==str[i].length())
                            break;
                        }
                        System.out.print(")");
                        j=k;
                    }
                    else{
                        System.out.print(str[i].charAt(j));
                        j++;
                    }
                }
        }
    }
}
