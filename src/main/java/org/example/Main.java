package org.example;
import java.util.Scanner;
/*заготовка
Це текст з посиланням на http://www.xxx.com, яке містить шкідливе ключове слово. А ось тут посилання на https://www.google.com, яке безпечне.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть текст: ");
        String text = scanner.nextLine();
        String result = deleteHarmfulLinks(text);
        System.out.println("Текст без посилань на шкідливі ресурси: ");
        System.out.println(result);
    }

    public static String deleteHarmfulLinks(String text) {
        String[] words = text.split("\\s+");

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!containsHarmfulLink(word)) {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }

    private static boolean containsHarmfulLink(String word) {
        return word.matches(".*http://www\\..+\\.(com|org|net).*")
                && (word.contains("xxx")
                || word.contains("charmes")
                || word.contains("hacking")
                || word.contains("crack"));
    }
}
