import java.util.Scanner;
class Solution {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;i++){
            String s=scanner.next();
            int v=0;
            String out="";
            int counter=0;
            for(int j=0;j<s.length();j++){
                if(Integer.parseInt(s.substring(j,j+1))>v){
                    for(int k=0;k<Integer.parseInt(s.substring(j,j+1))-v;k++){
                        out+="(";
                        counter++;
                    }
                    v=Integer.parseInt(s.substring(j,j+1));
                }
                else if(Integer.parseInt(s.substring(j,j+1))<v){
                    for(int k=0;k<v-Integer.parseInt(s.substring(j,j+1));k++){
                        out+=")";
                        counter--;
                    }
                    v=Integer.parseInt(s.substring(j,j+1));
                }out+=s.substring(j,j+1);
            }
            while(counter!=0){
                out+=')';
                counter--;
            }
            int x=i+1;
            System.out.println("Case #"+x+": "+out);
        }
    }
}
