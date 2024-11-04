package com.serzhio_pet_projects.encoder;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RleEncoderTest {

    @Test
    public void testEncode_oneWord_1() {
        String input = "AAABBBAA";
        String expectedOutput = "3A3B2A";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_2() {
        String input = "AB";
        String expectedOutput = "AB";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_3() {
        String input = "A";
        String expectedOutput = "A";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_4() {
        String input = "";
        String expectedOutput = "";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_5() {
        String input = "AAAABAB";
        String expectedOutput = "4ABAB";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_6() {
        String input = "ABABAB";
        String expectedOutput = "ABABAB";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_7() {
        String input = "ABBBBBBA";
        String expectedOutput = "A6BA";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_8() {
        String input = "AaaA";
        String expectedOutput = "AaaA";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_9() {
        String input = "a.,AA";
        String expectedOutput = "a.,2A";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_10() {
        String input = "...AAA###aaaAAaaa";
        String expectedOutput = "3.3A3#3aAA3a";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_11() {
        String input = "AAAAAAAAAB";
        String expectedOutput = "9AB";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_12() {
        String input = "AaAaAaAaBAAaaBaaaCd";
        String expectedOutput = "AaAaAaAaBAAaaB3aCd";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_13() {
        String input = "aаaаaаaаaаaаa";
        String expectedOutput = "aаaаaаaаaаaаa";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_oneWord_14() {
        String input = "AbA";
        String expectedOutput = "AbA";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_someWords_1() {
        String input = "a b";
        String expectedOutput = "a b";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_someWords_2() {
        String input = "a a a a a";
        String expectedOutput = "a a a a a";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_someWords_3() {
        String input = "a. a ba .abab";
        String expectedOutput = "a. a ba .abab";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_someWords_4() {
        String input = "a a a a a";
        String expectedOutput = "a a a a a";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }

    @Test
    public void testEncode_someWords_5() {
        String input = "a, a, A! a. A.";
        String expectedOutput = "a, a, A! a. A.";
        assertEquals(expectedOutput, RleEncoder.encode(input));
    }
}
