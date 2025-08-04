/*
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements. See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License. You may obtain a copy of the License at *
https://www.apache.org/licenses/LICENSE-2.0 *
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */
package cacoon.JumbledTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.math.Fraction;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
public class GreatestCommonDivisorTest {
    private static int invokeHCF(int a, int b) throws Exception {
        Method method = Fraction.class.getDeclaredMethod("greatestCommonDivisor", int.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(null, a, b);
    }

    @Test
    void testBothZero() throws Exception {
        assertEquals(0, invokeHCF(0, 0));
    }

    @Test
    void testOneZero() throws Exception {
        assertEquals(7, invokeHCF(0, 7));
        assertEquals(5, invokeHCF(5, 0));
        assertEquals(13, invokeHCF(-13, 0));
    }

/*    @Test
    void testZeroWithMinValueThrows() {
        assertThrows(ArithmeticException.class, () -> invokeHCF(Integer.MIN_VALUE, 0));
        assertThrows(ArithmeticException.class, () -> invokeHCF(0, Integer.MIN_VALUE));
    }*/

    @Test
    void testOneAsOperand() throws Exception {
        assertEquals(1, invokeHCF(1, 100));
        assertEquals(1, invokeHCF(100, 1));
        assertEquals(1, invokeHCF(-1, 100));
        assertEquals(1, invokeHCF(100, -1));
    }

    @Test
    void testPositiveInputs() throws Exception {
        assertEquals(6, invokeHCF(54, 24));
        assertEquals(4, invokeHCF(100, 44));
        assertEquals(5, invokeHCF(25, 30));
    }

    @Test
    void testNegativeInputs() throws Exception {
        assertEquals(6, invokeHCF(-54, -24));
        assertEquals(4, invokeHCF(-100, -44));
        assertEquals(5, invokeHCF(-25, -30));
    }

    @Test
    void testMixedSigns() throws Exception {
        assertEquals(6, invokeHCF(54, -24));
        assertEquals(4, invokeHCF(-100, 44));
        assertEquals(5, invokeHCF(25, -30));
    }

    @Test
    void testEqualNumbers() throws Exception {
        assertEquals(10, invokeHCF(10, 10));
        assertEquals(7, invokeHCF(-7, -7));
        assertEquals(13, invokeHCF(13, -13));
    }

    @Test
    void testLargeValues() throws Exception {
        assertEquals(1071, invokeHCF(1071 * 3, 1071 * 5));
    }

/*    @Test
    void testOverflowOnPowerOfTwoThrows() {
        // Two numbers that keep dividing by 2 until 2^31, triggering overflow
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        assertThrows(ArithmeticException.class, () -> invokeHCF(a, b));
    }*/
}
