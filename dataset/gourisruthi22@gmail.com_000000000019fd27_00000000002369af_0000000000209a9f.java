import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        for(int i=0;i<t;i++){
            int n=ob.nextInt();
            for(int l=0;l<n;l++){
                String str=nextLine();
                int j=0;
                while(j<str.length()){
                    if(str.charAt(j)=="1"){
                        System.out.print("(");
                        int k=j;
                        while(str.charAt(k)!="0"){
                            System.out.print(str.charAt(k));
                            k++;
                            if(k==str.length())
                            break;
                        }
                        System.out.print(")");
                        j=k;
                    }
                    else{
                        System.out.print(str.charAt(j));
                        j++;
                    }
                }
            }
        }
    }
}
