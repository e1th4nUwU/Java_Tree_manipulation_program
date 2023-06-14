package utilidades;

import java.util.Scanner;

public class AskUser {
    private static Scanner sc = new Scanner(System.in);
    
    public static int tryToAskInt(String s, int min, int max){
        int n = 0;
        
        do {
            System.out.print(s);
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                n=min -1;
            }
            if( n < min || n > max)
                System.out.println("\n\tParece que ingresaste un valor no valido, intenta de nuevo\n");
        } while ( n < min || n > max);

        return n;
    }
    
    public static int tryToAskInt(String s, int min) {
        int n = 0;

        do {
            System.out.print(s);
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                n = min - 1;
            }
            if (n < min)
                System.out.println("\n\tParece que ingresaste un valor no valido, intenta de nuevo\n");
        } while (n < min);

        return n;
    }
    
    public static int tryToAskInt(String s) {
        int n = 0;
        boolean flag = true;

        do {
            System.out.print(s);
            try {
                n = Integer.parseInt(sc.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("\n\tParece que ingresaste un valor no valido, intenta de nuevo\n");
            }

        } while (flag);

        return n;
    }
    public static String askString(String s){
        String str;
        System.out.print(s);
        str = sc.nextLine();
        return str;
    }
    
    static void closeScanner(){
        sc.close();
    }
}
