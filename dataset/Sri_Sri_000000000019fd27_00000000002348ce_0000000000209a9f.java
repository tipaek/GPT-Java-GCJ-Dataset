import java.util.*;
class A{
static void simple(char c)
{
    switch(c)
    {
        case '0':System.out.print("0");
                break;
        case '1':System.out.print("(1)");
                break;
        case '2':System.out.print("((2))");
                break;
        case '3':System.out.print("(((3)))");
                break;
        case '4':System.out.print("((((4))))");
                break;
        case '5':System.out.print("(((((5)))))");
                break;
        case '6':System.out.print("((((((6))))))");
                break;
        case '7':System.out.print("(((((((7)))))))");
                break;
        case '8':System.out.print("((((((((8))))))))");
                break;
        case '9':System.out.print("(((((((((9)))))))))");
                break;
    }
}
static void simple1(char c)
{
    switch(c)
    {
        case '0':System.out.print("00");
                break;
        case '1':System.out.print("(11)");
                break;
        case '2':System.out.print("((22))");
                break;
        case '3':System.out.print("(((33)))");
                break;
        case '4':System.out.print("((((44))))");
                break;
        case '5':System.out.print("(((((55)))))");
                break;
        case '6':System.out.print("((((((66))))))");
                break;
        case '7':System.out.print("(((((((77)))))))");
                break;
        case '8':System.out.print("((((((((88))))))))");
                break;
        case '9':System.out.print("(((((((((99)))))))))");
                break;
    }
}
static void simple2(char c)
{
    switch(c)
    {
        case '0':System.out.print("000");
                break;
        case '1':System.out.print("(111)");
                break;
        case '2':System.out.print("((222))");
                break;
        case '3':System.out.print("(((333)))");
                break;
        case '4':System.out.print("((((444))))");
                break;
        case '5':System.out.print("(((((555)))))");
                break;
        case '6':System.out.print("((((((666))))))");
                break;
        case '7':System.out.print("(((((((777)))))))");
                break;
        case '8':System.out.print("((((((((888))))))))");
                break;
        case '9':System.out.print("(((((((((999)))))))))");
                break;
    }
}
static void simple3(char c)
{
    switch(c)
    {
        case '0':System.out.print("0000");
                break;
        case '1':System.out.print("(1111)");
                break;
        case '2':System.out.print("((2222))");
                break;
        case '3':System.out.print("(((3333)))");
                break;
        case '4':System.out.print("((((4444))))");
                break;
        case '5':System.out.print("(((((5555)))))");
                break;
        case '6':System.out.print("((((((6666))))))");
                break;
        case '7':System.out.print("(((((((7777)))))))");
                break;
        case '8':System.out.print("((((((((8888))))))))");
                break;
        case '9':System.out.print("(((((((((9999)))))))))");
                break;
    }
}
public static void main(String args[])
{
    char[][] str=new char[10][100];
    String[] a=new String[100]; 
    int T;
    int i,j,z;
    Scanner sc=new Scanner(System.in);
    T=sc.nextInt();
    for(z=1;z<=T;z++)
    {
        a[z]=sc.next();
    }
    for(i=1;i<=T;i++)
    {
        j=0;
        while(a[i].charAt(j)!='\0')
        {
            str[i][j]=a[i].charAt(j);
            j++;
        }
    }
    for(i=1;i<=T;i++)
    {
        System.out.print("Case #%d: "+i);
        for(j=0;str[i][j]!='\0';j++)
        {
            if(str[i][j+1]!='\0' && str[i][j]==str[i][j+1])
            {
                if(str[i][j+2]!='\0' && str[i][j+1]==str[i][j+2])
                {
                    if(str[i][j+3]!='\0' && str[i][j+2]==str[i][j+3])
                    {
                        simple3(str[i][j]);
                        j=j+3;
                    }
                    else
                    {
                        simple2(str[i][j]);
                        j=j+2;
                    }
                }
                else
                {
                    simple1(str[i][j]);
                    j++;
                }
            }
            else
            {
                simple(str[i][j]);
            }
        }
        System.out.println("");
    }
}
}
