package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void testDeleteHarmfulLinks() {
        String input = "Це текст з посиланням на http://www.example.com, але без шкідливих посилань на xxx.";
        String expectedOutput = "Це текст з посиланням на http://www.example.com, але без шкідливих посилань на xxx.";
        Assertions.assertEquals(expectedOutput, Main.deleteHarmfulLinks(input));
    }

    @Test
    public void testDeleteHarmfulLinksNoMatch() {
        String input = "Це текст без посилань на шкідливі ресурси.";
        String expectedOutput = "Це текст без посилань на шкідливі ресурси.";
        Assertions.assertEquals(expectedOutput, Main.deleteHarmfulLinks(input));
    }

    @Test
    public void testDeleteHarmfulLinksEmptyInput() {
        String input = "";
        String expectedOutput = "";
        Assertions.assertEquals(expectedOutput, Main.deleteHarmfulLinks(input));
    }
}