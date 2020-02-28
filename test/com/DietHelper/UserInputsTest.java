package com.DietHelper;

import com.sunny.plugin.MockitoGenPlugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

class UserInputsTest {


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