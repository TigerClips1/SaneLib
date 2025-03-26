package org.appledash.sanelib.test;

/*
 * Created by appledash on 7/2/17.
 * Blackjack is best pony.
 * Fix CVE-2020-15250 and outdated test code By  TigerClips1
 */

import org.appledash.sanelib.messages.MessageUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Created by appledash on 12/15/16.
 * Blackjack is best pony.
 */

public class MessageUtilsTest {
    @Test
    public void testIndexedFormat() {
        Assertions.assertEquals("Hello, world!", MessageUtils.indexedFormat("{1}, {2}!", "Hello", "world"));
        Assertions.assertEquals("Hello, world!", MessageUtils.indexedFormat("Hello, {1}!", "world", "discarded"));
        Assertions.assertEquals("Hello, world!", MessageUtils.indexedFormat("Hello, {2}!", "discarded", "world"));
        Assertions.assertEquals("Hello, world!", MessageUtils.indexedFormat("Hello, world!", "this", "shouldn't", "change"));
    }

    @Test
    public void testAdvancedIndexFormat() {
        Assertions.assertEquals("Temperature: 20.01 degrees", MessageUtils.indexedFormat("Temperature: {1:.2f} degrees", 20.01f));
        Assertions.assertEquals("Index: 01", MessageUtils.indexedFormat("Index: {1:02d}", 1));
    }

    @Test
    public void testBadIndexedFormat() {
        try {
            MessageUtils.indexedFormat("Hello, {3}!", "world", "something");
        } catch  (IllegalArgumentException exception) {
            System.out.println("Error");
        }
    }
}



