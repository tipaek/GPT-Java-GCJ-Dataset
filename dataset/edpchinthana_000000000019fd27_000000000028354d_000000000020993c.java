import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for(int x=0;x<n;x++){
            int m = input.nextInt();
            String temp = input.nextLine();
            int a[][] = new int[m][m];
            int b=0;
            int c=0;
            int d=0;
            for(int y=0;y<m;y++){
                String s[] = input.nextLine().split(" ");
                for(int z=0;z<s.length;z++){
                    a[y][z] = Integer.parseInt(s[z]);
                    if(z==y){
                        b = b+a[y][z];
                    }
                }
            }
            for(int y=0;y<m;y++){
                int count = 0;
                for(int z=0;z<m;z++){
                    for(int z2=z+1;z2<m;z2++){
                        if(a[y][z]==a[y][z2]){
                            count = 1;
                        }
                    }
                }
                if(count==1){
                    c++;
                }
            }
            for(int y=0;y<m;y++){
                int count = 0;
                for(int z=0;z<m;z++){
                    for(int z2=z+1;z2<m;z2++){
                        if(a[z][y]==a[z2][y]){
                            count = 1;
                        }
                    }
                }
                if(count==1){
                    d++;
                }
            }
            System.out.println("Case #"+(x+1)+": "+b+" "+c+" "+d);
        }
    }
}
