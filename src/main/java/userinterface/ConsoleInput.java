package userinterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {

    Scanner sc = new Scanner(System.in);

    public int readInt() {
        int i = 0;

        while(true){
            try {
                i = sc.nextInt();
                return i;
            } catch (InputMismatchException e) {
                System.out.println("Only numerical values!");
            } finally {
                sc.nextLine();
            }
        }
    }

    public String readString() {
        return sc.nextLine();
    }

}
