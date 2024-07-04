

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        
    Scanner sc1 = new Scanner(System.in);
        
    int t = sc1.nextInt();
    int in = 0;
    
    for (int it= 0 ;it<t;it++){
        
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        
            String s1 = new String();
            String s2 = new String();

            int d,n1,pr=0;

            int l=s.length();
            int a[] = new int[l];
            int flag=0;
            int i;

            for (i = 0 ;i<l;i++){

                a[i] = Character.getNumericValue(s.charAt(i)) ;
            }

            for (i=0;i<l;i++){

                if(a[i]!=0){
                    break;
                }
            }
            flag = i ;
            s1 = s.substring(0,i); 

            if(flag!=l){
                s1 = s1 + '(';            

                for (i=flag ;i<l-1;i++){

                if(a[i]!=0){

                    if(a[i+1] == a[i]){
                        s1 = s1 + a[i] ;// i=1 ; (11        
                    }
                    else if(a[i+1] > a[i]){
                        s1 = s1 + a[i] + '('  ;// 00(1
                        pr++;            
                    }

                    else if(a[i+1] < a[i]){
                        s1 = s1 + a[i] + ')' ; // 00(1)
                        pr--;
                    }

                }
                else{
                    if(a[i+1] == a[i]){
                           s1 = s1 + a[i] ;// i=1 ; (11        
                    }
                    else if(a[i+1] > a[i]){
                        s1 = s1 + a[i] + '('  ;// 00(1
                        pr++;            
                    }

                }


            }

                        s1 = s1 + a[i];
                    for (i=0;i<pr+1;i++){
                        s1 = s1 + ')';
                    }
            }

                System.out.println("Case #"+(it+1)+": "+s1);
    }
    }
    
}
