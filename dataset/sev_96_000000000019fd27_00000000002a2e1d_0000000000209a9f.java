import java.util.Scanner;

class Solution {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();
        int size;
        String s = "";
        StringBuilder temp = new StringBuilder();
        StringBuilder s1 = new StringBuilder();

        for (int i = 0; i < caseCount; i++) {


                s = sc.next();

                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '1') {
                        temp.append(s.charAt(j));
                        if(j==s.length()-1) {s1.append("(").append(temp).append(")");};
                    } else if (temp.length()>0){

                        temp = new StringBuilder("(" + temp + ")");

                        s1.append(temp);
                        s1.append(s.charAt(j));
                        temp=new StringBuilder();
                    } else {s1.append(s.charAt(j));temp=new StringBuilder();}
                }
            System.out.println("Case #"+(i +1)+": "+s1);
                s="";
                s1 = new StringBuilder();
                temp = new StringBuilder();
        }
        }
}
