package com.serzhio_pet_projects.input;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InputFileVerifierTest {

    @Test
    public void testCheckPathToInputFile_notFile1() {
        String inputFilePath = "";
        Object expectedOutput = null;
        assertEquals(expectedOutput, InputFileVerifier.checkPathToInputFile(inputFilePath));
    }

    @Test
    public void testCheckPathToInputFile_notFile2() {
        String inputFilePath = "asdvasdva avasdv";
        Object expectedOutput = null;
        assertEquals(expectedOutput, InputFileVerifier.checkPathToInputFile(inputFilePath));
    }
    
    @Test
    public void testCheckPathToInputFile_notFile3() {
        String inputFilePath = "asdc";
        Object expectedOutput = null;
        assertEquals(expectedOutput, InputFileVerifier.checkPathToInputFile(inputFilePath));
    }

    @Test
    public void testCheckPathToInputFile_notFile4() {
        String inputFilePath = ".";
        Object expectedOutput = null;
        assertEquals(expectedOutput, InputFileVerifier.checkPathToInputFile(inputFilePath));
    }

    @Test
    public void testCheckPathToInputFile_notFile5() {
        String inputFilePath = "/home/serezha";
        Object expectedOutput = null;
        assertEquals(expectedOutput, InputFileVerifier.checkPathToInputFile(inputFilePath));
    }

    @Test
    public void testCheckPathToInputFile_notFile6() {
        String inputFilePath = null;
        Object expectedOutput = null;
        assertEquals(expectedOutput, InputFileVerifier.checkPathToInputFile(inputFilePath));
    }


}