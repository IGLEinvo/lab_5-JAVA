package org.example;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Visit http://www.google.com for search. But avoid sites like http://www.xxx.com, http://www.charmes.org, http://www.hacking.net, http://www.crack.com
public class TextCleaner {
    private final String text;

    public TextCleaner(String text) {
        this.text = text;
    }

    public String removeMaliciousLinks() {
        String pattern = "https?://\\S+";
        Pattern linkPattern = Pattern.compile(pattern);

        String[] harmfulWords = {"xxx", "charmes", "hacking", "crack"};

        Pattern harmfulWordsPattern = Pattern.compile(String.join("|", harmfulWords));

        Matcher matcher = linkPattern.matcher(text);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String link = matcher.group();
            Matcher harmfulMatcher = harmfulWordsPattern.matcher(link);
            if (harmfulMatcher.find()) {
                matcher.appendReplacement(result, "***");
            }
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine();
        TextCleaner cleaner = new TextCleaner(text);
        String cleanedText = cleaner.removeMaliciousLinks();
        System.out.println("Cleaned text:");
        System.out.println(cleanedText);
    }
}
