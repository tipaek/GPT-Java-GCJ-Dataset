import java.util.*;

public class Solution{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Integer noOfCases= scanner.nextInt();
        for(Integer caz=0;caz<noOfCases;caz++){
            String caseString="Case #"+(caz+1)+": ";
            String input=scanner.nextLine();
            caseString+=solver(input);
            System.out.println(caseString);
        }
    }
    private  static String solver(String input){
        Boolean ok=true;
        for(char i : input.toCharArray()){
            if(i!='0'){
                ok=false;
            }
        }
        if(ok){
            return input;
        }
        else {
            String newInput="";
            String result="";
            char[] c=input.toCharArray();
            for(int l=0;l<input.length();l++){
                if(c[l]=='0'||l==input.length()-1){
                    if(newInput==""&&c[l]=='0')
                        result+='0';
                    else {
                        if(l==input.length()-1&&newInput=="")
                            result+='(';
                        if(c[l]!='0')
                            newInput+=c[l];

                        char[] array = newInput.toCharArray();
                        for(int i = 0; i<newInput.length();i++){
                            array[i]-=1;
                        }
                        String wasReturned=solver(String.copyValueOf(array));
                        char[] returned= wasReturned.toCharArray();
                        for(int i = 0; i<wasReturned.length();i++){
                            if(returned[i]=='('||returned[i]==')')
                                continue;
                            else
                                returned[i]+=1;
                        }
                        wasReturned=String.copyValueOf(returned);

                        result+=wasReturned;
                        result+=')';
                        if(c[l]=='0')
                            result+='0';
                        newInput="";
                    }
                }
                else{
                    if(newInput=="")
                        result+='(';
                    newInput+=c[l];
                }
            }
            return result;
        }

    }

}