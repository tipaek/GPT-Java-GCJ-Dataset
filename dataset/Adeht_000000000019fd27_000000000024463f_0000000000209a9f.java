import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int size=0,j=0,index=0,column=0,row=0;
        boolean flag=false;
        int testCase=sc.nextInt();
        StringBuffer result= new StringBuffer();
        StringBuffer temp= new StringBuffer();
        for(int i=0;i<testCase;i++){
            String input=sc.next();
            size=input.length();
            for(index=0;index<size;index++){
                int digit=Character.getNumericValue(input.charAt(index));
                temp.append(digit);
                for(j=0;j<digit;j++){
                    temp.insert(j,"(");
                    temp.insert(temp.length()-j,")");
                }
                result.append(temp);
                temp=new StringBuffer();
            }
            j=0;
            while(j++<9){
                input=result.toString().replaceAll("\\)\\(","");
            }
            System.out.println("Case #"+(i+1)+": "+input);
            result=new StringBuffer();
        }
    }
}