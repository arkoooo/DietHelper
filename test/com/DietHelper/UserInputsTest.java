package com.DietHelper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputsTest {


    @Test
    void getInputFromUser() {
    }

    @Test
    void testGetInputFromUser() {
    }

    @Test
    void testGetInputFromUser1() {
    }

    @Test
    void isThatGoodChoice() {
        //act
        boolean goodResult = UserInputs.isThatGoodChoice(5,1,10);
        boolean badResult = UserInputs.isThatGoodChoice(5,1,4);
        //assert
        assertTrue(goodResult);
        assertFalse(badResult);
    }

    @Test
    void isThatGoodChoiceDouble() {
        //act
        boolean goodResult = UserInputs.isThatGoodChoice(5.2,1.1,9.9);
        boolean badResult = UserInputs.isThatGoodChoice(5.0,1.0,4.0);
        //assert
        assertTrue(goodResult);
        assertFalse(badResult);
    }
}