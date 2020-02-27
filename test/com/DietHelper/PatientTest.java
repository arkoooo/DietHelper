package com.DietHelper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.stream.FactoryConfigurationError;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient patient = new Patient();
    @BeforeEach
    public void setUp() {
        patient.setGender(1);
        patient.setActivity(1);
        patient.setHeight(180);
        patient.setWeight(95);
        patient.setYear(1994);
        patient.setInsulin(5);
        patient.setGlycemia(90);
        patient.calculateBmr();
    }
    @Test
    void calculateBmr(){
        //act
        int result = patient.getBmr();
        //assert
        assertEquals(1951,result);
    }
    @Test
    void calculateTotalMetabolism() {
        //act
        patient.calculateTotalMetabolism();
        int result = patient.getCalories();
        //assert
        assertEquals(2341,result);
    }
    @Test
    void homaIR() {
        //act
        patient.homaIR();
        double result = patient.homaIR();
        //assert
        assertEquals(1.125,result);
    }
    @Test
    void checkHomaIR() {
        //arrange
        Patient badPatient = new Patient();
        badPatient.setGlycemia(100);
        badPatient.setInsulin(25);
        //act
        double badResult = badPatient.homaIR();
        double goodResult = patient.homaIR();
        //assert
        assertTrue(badPatient.checkHomaIR());
        assertFalse(patient.checkHomaIR());
    }
}