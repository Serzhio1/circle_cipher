package com.serzhio_pet_projects.decoder;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RleDecoderTest {

    @Test
    public void testDecode_1() {
        String encodeText = "3A";
        String expectedOutput = "AAA";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_2() {
        String encodeText = "";
        String expectedOutput = "";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_3() {
        String encodeText = "A";
        String expectedOutput = "A";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_4() {
        String encodeText = "AB";
        String expectedOutput = "AB";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_5() {
        String encodeText = "3A2BaBaa";
        String expectedOutput = "AAABBaBaa";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_6() {
        String encodeText = "A A A";
        String expectedOutput = "A A A";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_7() {
        String encodeText = "3A A 3A";
        String expectedOutput = "AAA A AAA";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_8() {
        String encodeText = "A. a, baba 3A.";
        String expectedOutput = "A. a, baba AAA.";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_9() {
        String encodeText = "4ABAB";
        String expectedOutput = "AAAABAB";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_10() {
        String encodeText = "A6BA";
        String expectedOutput = "ABBBBBBA";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_12() {
        String encodeText = "AaaA";
        String expectedOutput = "AaaA";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_13() {
        String encodeText = "a.,2A";
        String expectedOutput = "a.,AA";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_14() {
        String encodeText = "3.3A3#3aAA3a";
        String expectedOutput = "...AAA###aaaAAaaa";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_15() {
        String encodeText = "9AB";
        String expectedOutput = "AAAAAAAAAB";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_16() {
        String encodeText = "aаaаaаaаaаaаa";
        String expectedOutput = "aаaаaаaаaаaаa";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_17() {
        String encodeText = "9AB";
        String expectedOutput = "AAAAAAAAAB";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }

    @Test
    public void testDecode_18() {
        String encodeText = " ";
        String expectedOutput = " ";
        assertEquals(expectedOutput, RleDecoder.decode(encodeText));
    }





}
