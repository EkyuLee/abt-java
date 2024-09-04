package com.jtre.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class calTest {

    @Test
    void added() {
        assertEquals(5,cal.added(2,3));
    }

    @Test
    void sub() {
        assertEquals(-1,cal.sub(2,3));
    }

    @Test
    void mul() {
        assertEquals(6,cal.mul(2,3));
    }

    @Test
    void div() {
        assertEquals(2,cal.div(4,2));
    }

    @Test
    void mod() {
        assertEquals(1,cal.mod(4,3));
    }
}