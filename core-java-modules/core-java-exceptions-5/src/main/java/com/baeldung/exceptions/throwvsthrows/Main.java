package com.baeldung.exceptions.throwvsthrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.SocketException;

import com.sun.mail.iap.ConnectionException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        TryCatch tryCatch = new TryCatch();

        try {
            tryCatch.execute();
        } catch (ConnectionException | SocketException ex) {
            System.out.println("IOException");
        } catch (Exception ex) {
            System.out.println("General exception");
        }

        checkedExceptionWithTryCatch();
        checkedExceptionWithThrows();
        divideByZero();
    }

    private static void checkedExceptionWithThrows() throws FileNotFoundException {
        File file = new File("not_existing_file.txt");
        FileInputStream stream = new FileInputStream(file);
    }

    private static void checkedExceptionWithTryCatch() {
        File file = new File("not_existing_file.txt");
        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private static void divideByZero() {
        int numerator = 1;
        int denominator = 0;
        int result = numerator / denominator;
    }

}
