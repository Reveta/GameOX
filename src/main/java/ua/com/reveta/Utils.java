package ua.com.reveta;

import java.util.HashMap;
import java.util.Scanner;

public final class Utils {

    final static private HashMap<Integer, String> messages = new HashMap<>();
    final static private Scanner scanner = new Scanner(System.in);


    public Utils(){
        messages.put(1, "Було введено не коректні дані. Введіть цифру з номером поля");
        messages.put(2, "Такого поля не існує, введи від 1 - 9");
        messages.put(3, "Дана клітинка вже зайнята");
        messages.put(4, "Гра завершена!");
    }

    public HashMap getMessages() {
        return messages;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
