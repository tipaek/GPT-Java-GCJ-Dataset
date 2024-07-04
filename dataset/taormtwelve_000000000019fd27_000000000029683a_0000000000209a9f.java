import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int T,closer=0;
        String st,outt="";
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for(int x=1;x<=T;x++){
            st = scanner.next();
            closer=st.charAt(0)-'0';
            for(int i=0;i<closer;i++) outt +='(';
            outt +=st.charAt(0);
            for(int i=0;i<st.length();i++){
                outt +=st.charAt(i);
                if(i+1 < st.length() && st.charAt(i) > st.charAt(i+1)){
                    for(int j=st.charAt(i);j>st.charAt(i+1);j--){
                        outt += ')';
                        closer--;
                    }
                }else if(i+1 < st.length() && st.charAt(i) < st.charAt(i+1)){
                    for(int j=st.charAt(i);j<st.charAt(i+1);j++){
                        outt +='(';
                        closer++;
                    }

                }

            }
            for(int i=0;i<closer;i++) outt += ')';
            System.out.println("Case #" + x + ":" + " "+ outt);
        }
    }
}
