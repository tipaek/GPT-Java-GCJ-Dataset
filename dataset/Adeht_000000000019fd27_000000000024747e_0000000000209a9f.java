import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int testCase=sc.nextInt();
        for(int i=0;i<testCase;i++){
            String input=sc.next();
            input=input.replaceAll("1","(1)");
            input=input.replaceAll("2","((2))");
            input=input.replaceAll("3","(((3)))");
            input=input.replaceAll("4","((((4))))");
            input=input.replaceAll("5","(((((5)))))");
            input=input.replaceAll("6","((((((6))))))");
            input=input.replaceAll("7","(((((((7)))))))");
            input=input.replaceAll("8","((((((((8))))))))");
            input=input.replaceAll("9","(((((((((9)))))))))");
            for(int j=0;j<9;j++){
                input=input.replaceAll("\\)\\(","");
            }
            System.out.println("Case #"+(i+1)+": "+input);
        }
    }
}