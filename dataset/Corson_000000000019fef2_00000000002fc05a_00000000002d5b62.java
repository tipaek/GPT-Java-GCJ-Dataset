import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for(int tc = 0; tc < testCases; tc++) {
            int celX, celY;
            celX = in.nextInt();
            celY = in.nextInt();
            boolean xUjemny = celX < 0;
            boolean yUjemny = celY < 0;
            celX = Math.abs(celX);
            celY = Math.abs(celY);

            boolean xNP = false;
            boolean yNP = false;
            if(celX%2 == 1 && celY%2 == 1) {
                System.out.println("Case #" + (tc+1) + ": IMPOSSIBLE");
                continue;
            } else if (celX%2 == 1) {
                xNP = true;
            } else if (celY%2 == 1) {
                yNP = true;
            }
            int krokiX, krokiY;
            String output = "";

            int and = celX & celY;
            if (and != 0) {
                if (xNP) {
                    and = (celX + 1) & celY;
                    if (and != 0) {
                        and = (celX - 1) & celY;
                        if (and != 0) {
                            System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
                            continue;
                        } else {
                            // da sie po zmniejszeniu X o 1
                            celX -= 1;
                            krokiX = (int)Integer.toBinaryString(celX).chars().filter(ch -> ch == '1').count();
                            krokiY = (int)Integer.toBinaryString(celY).chars().filter(ch -> ch == '1').count();

                            if(xUjemny) {
                                output += 'W';
                            } else {
                                output += 'E';
                            }
                            for(int i = 0; i < krokiX; i++) {
                                if(xUjemny) {
                                    output += 'W';
                                } else {
                                    output += 'E';
                                }
                            }
                            for(int i = 0; i < krokiY; i++) {
                                if(yUjemny) {
                                    output += 'S';
                                } else {
                                    output += 'N';
                                }
                            }
                        }
                    } else {
                        // da sie po zwiekszeniu X o 1
                        celX += 1;
                        krokiX = (int)Integer.toBinaryString(celX).chars().filter(ch -> ch == '1').count();
                        krokiY = (int)Integer.toBinaryString(celY).chars().filter(ch -> ch == '1').count();

                        if(xUjemny) {
                            output += 'E';
                        } else {
                            output += 'W';
                        }
                        for(int i = 0; i < krokiX; i++) {
                            if(xUjemny) {
                                output += 'W';
                            } else {
                                output += 'E';
                            }
                        }

                        for(int i = 0; i < krokiY; i++) {
                            if(yUjemny) {
                                output += 'S';
                            } else {
                                output += 'N';
                            }
                        }
                    }
                } else if (yNP) {
                    and = celX & (celY + 1);
                    if (and != 0) {
                        and = celX & (celY - 1);
                        if (and != 0) {
                            System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
                            continue;
                        } else {
                            // da sie po zmniejszeniu Y o 1
                            celY -= 1;
                            krokiX = (int)Integer.toBinaryString(celX).chars().filter(ch -> ch == '1').count();
                            krokiY = (int)Integer.toBinaryString(celY).chars().filter(ch -> ch == '1').count();

                            if(yUjemny) {
                                output += 'S';
                            } else {
                                output += 'N';
                            }
                            for(int i = 0; i < krokiX; i++) {
                                if(xUjemny) {
                                    output += 'W';
                                } else {
                                    output += 'E';
                                }
                            }
                            for(int i = 0; i < krokiY; i++) {
                                if(yUjemny) {
                                    output += 'S';
                                } else {
                                    output += 'N';
                                }
                            }
                        }
                    } else {
                        // da sie po zwiekszeniu Y o 1
                        celY += 1;
                        krokiX = (int)Integer.toBinaryString(celX).chars().filter(ch -> ch == '1').count();
                        krokiY = (int)Integer.toBinaryString(celY).chars().filter(ch -> ch == '1').count();

                        if(yUjemny) {
                            output += 'N';
                        } else {
                            output += 'S';
                        }
                        for(int i = 0; i < krokiX; i++) {
                            if(xUjemny) {
                                output += 'W';
                            } else {
                                output += 'E';
                            }
                        }
                        for(int i = 0; i < krokiY; i++) {
                            if(yUjemny) {
                                output += 'S';
                            } else {
                                output += 'N';
                            }
                        }
                    }
                } else {
                    System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
                    continue;
                }
            } else {
                // jesli tu doszlo to da sie
                //System.out.println("Da sie");
                krokiX = (int)Integer.toBinaryString(celX).chars().filter(ch -> ch == '1').count();
                krokiY = (int)Integer.toBinaryString(celY).chars().filter(ch -> ch == '1').count();
                for(int i = 0; i < krokiX; i++) {
                    if(xUjemny) {
                        output += 'W';
                    } else {
                        output += 'E';
                    }
                }
                for(int i = 0; i < krokiY; i++) {
                    if(yUjemny) {
                        output += 'S';
                    } else {
                        output += 'N';
                    }
                }
            }
            System.out.println("Case #" + (tc + 1) + ": " + output);
        }
      }
    }