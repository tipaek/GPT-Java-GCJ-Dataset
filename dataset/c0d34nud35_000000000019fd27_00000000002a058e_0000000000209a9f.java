import java.util.*;

public class Solution{

     public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int T,closing=0,digit,temp;
        String num,num2;
        String tempStr= new String(); 
        String tempStr2;
        StringBuilder input1;
        
        T=Integer.parseInt(scan.nextLine().trim());
        for(int t=0;t<T;t++){
            //temp=scan.nextInt();
            
            //num=Integer.toString(temp); 
            
            num=scan.nextLine().trim();
            
            tempStr= new String(); 
            for(int i=0;i<num.length();i++){
                digit=num.charAt(i)-'0';
                
                if(closing==0){
                    //place opening brackets, then number in tempStr
                    for(int j=0;j<digit;j++){
                        tempStr+='(';
                    }
                    tempStr+=num.charAt(i);
                    
                    closing=digit;
                }else if(i>0 && digit>num.charAt(i-1)-'0'){
                    for(int j=0;j<digit - (num.charAt(i-1)-'0');j++){
                        tempStr+='(';
                    }
                    tempStr+=num.charAt(i);
                    
                    closing+=digit - (num.charAt(i-1)-'0');
                }else if(closing >=digit){
                    for(int j=0;j<closing-digit;j++){
                        tempStr+=')';
                    }
                    closing=digit;
                    tempStr+=num.charAt(i);
                }else{
                    //close remaining
                    for(int j=0;j<closing;j++){
                        tempStr+=')';
                        closing--;
                    }
                    
                    //place opening brackets, then number in tempStr
                    for(int j=0;j<digit;j++){
                        tempStr+='(';
                    }
                    tempStr+=num.charAt(i);
                    
                    closing=digit;
                }
            }
            
            //close remaining brackets 
            for(int j=0;j<closing;j++){
                tempStr+=')';
            }
            closing=0;

            System.out.println("Case #"+(t+1)+": "+tempStr);

        }
     }

}