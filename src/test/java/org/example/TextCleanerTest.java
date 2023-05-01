package org.example;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;


    public class TextCleanerTest {

        @Test
        public void testRemoveMaliciousLinks() {
            TextCleaner cleaner = new TextCleaner("Visit http://www.google.com for search. But avoid sites like http://www.xxx.com, http://www.charmes.org, http://www.hacking.net, http://www.crack.com");
            String cleanedText = cleaner.removeMaliciousLinks();
            assertEquals("Visit http://www.google.com for search. But avoid sites like *** *** *** ***", cleanedText);
        }

        @Test
        public void testRemoveMaliciousLinksWithNoLinks() {
            TextCleaner cleaner = new TextCleaner("This text contains no links.");
            String cleanedText = cleaner.removeMaliciousLinks();
            assertEquals("This text contains no links.", cleanedText);
        }

        @Test
        public void testRemoveMaliciousLinksWithOnlyHarmfulLinks() {
            TextCleaner cleaner = new TextCleaner("Avoid sites like http://www.xxx.com, http://www.charmes.org, http://www.hacking.net, http://www.crack.com");
            String cleanedText = cleaner.removeMaliciousLinks();
            assertEquals("Avoid sites like *** *** *** ***", cleanedText);
        }

        @Test
        public void testRemoveMaliciousLinksWithOnlyHarmlessLinks() {
            TextCleaner cleaner = new TextCleaner("Visit http://www.google.com for search.");
            String cleanedText = cleaner.removeMaliciousLinks();
            assertEquals("Visit http://www.google.com for search.", cleanedText);
        }
    }
