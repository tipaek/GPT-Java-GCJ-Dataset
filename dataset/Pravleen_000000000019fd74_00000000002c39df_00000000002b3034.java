import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class jam6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        for(int i=0;i<a;i++){
            int b=sc.nextInt();
            String[] arr=new String[b];
            for(int y=0;y<b;y++){
                arr[y]=sc.nextLine();    
            }
            
		List<String> Strings = Arrays.asList(arr);
                String s1=Collections.min(Strings);
		String s2=Collections.max(Strings);
                String s1New = s1.replaceAll("*", "");
                String replaceString=s2.replace("*",s1New);
                System.out.println("Case #"+(i+1)+": "+replaceString );
}
}           
        }