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
import org.apache.commons.lang3.text.FormattableUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.FormattableFlags;
import java.util.Formatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
public class AppendTest {
    @Test
    public void testNoTruncationNoPadding() {
        Formatter formatter = new Formatter();
        Formatter result = FormattableUtils.append(
                "Hello", formatter, 0, 5, -1, '*', null);
        assertEquals("Hello", result.toString());
    }

/*    @Test
    public void testTruncationWithDefaultEllipsis() {
        Formatter formatter = new Formatter();
        Formatter result = FormattableUtils.append(
                "HelloWorld", formatter, 0, 10, 5, '*', null);
        assertEquals("Hello", result.toString());
    }*/

//    @Test
//    public void testTruncationWithCustomEllipsis() {
//        Formatter formatter = new Formatter();
//        Formatter result = FormattableUtils.append(
//                "HelloWorld", formatter, 0, 10, 7, '*', "...");
//        assertEquals("Hel...", result.toString());
//    }

    @Test
    public void testLeftAlignedPadding() {
        Formatter formatter = new Formatter();
        Formatter result = FormattableUtils.append(
                "Hi", formatter, FormattableFlags.LEFT_JUSTIFY, 5, -1, '-', null);
        assertEquals("Hi---", result.toString());
    }

    @Test
    public void testRightAlignedPadding() {
        Formatter formatter = new Formatter();
        Formatter result = FormattableUtils.append(
                "Hi", formatter, 0, 5, -1, '-', null);
        assertEquals("---Hi", result.toString());
    }

    @Test
    public void testNoTruncationButPaddingApplied() {
        Formatter formatter = new Formatter();
        Formatter result = FormattableUtils.append(
                "Hello", formatter, 0, 8, 10, ' ', null);
        assertEquals("   Hello", result.toString());
    }

    @Test
    public void testValidationFailureWhenEllipsisTooLong() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Formatter formatter = new Formatter();
            FormattableUtils.append("HelloWorld", formatter, 0, 10, 3, '*', ".....");
        });
        assertTrue(exception.getMessage().contains("Specified ellipsis"));
    }

/*    @Test
    public void testZeroLengthPaddingAndTruncation() {
        Formatter formatter = new Formatter();
        Formatter result = FormattableUtils.append(
                "HelloWorld", formatter, 0, 0, 5, '-', "...");
        assertEquals("Hel...", result.toString());
    }*/
}
