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

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.substringsBetween;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SubstringsBetweenTest {


    @Test
    void testNullInputString() {
        assertNull(substringsBetween(null, "[", "]"));
    }

    @Test
    void testEmptyInputString() {
        assertArrayEquals(new String[0], substringsBetween("", "[", "]"));
    }

    @Test
    void testEmptyDelimiter() {
        assertNull(substringsBetween("text", "", "]"));
    }

    @Test
    void testEmptyTermination() {
        assertNull(substringsBetween("text", "[", ""));
    }

    @Test
    void testNoDelimitersInString() {
        assertNull(substringsBetween("nothing here", "[", "]"));
    }

    @Test
    void testOnlyDelimiterPresent() {
        assertNull(substringsBetween("start [ only", "[", "]"));
    }

    @Test
    void testOnlyTerminationPresent() {
        assertNull(substringsBetween("end ] only", "[", "]"));
    }

    @Test
    void testSingleMatch() {
        String input = "before [extract] after";
        String[] expected = {"extract"};
        assertArrayEquals(expected, substringsBetween(input, "[", "]"));
    }

    @Test
    void testMultipleMatches() {
        String input = "before [one] middle [two] end [three]";
        String[] expected = {"one", "two", "three"};
        assertArrayEquals(expected, substringsBetween(input, "[", "]"));
    }

    @Test
    void testNestedDelimitersIgnored() {
        String input = "text [outer [inner] outer-end] more";
        String[] expected = {"outer [inner"};
        assertArrayEquals(expected, substringsBetween(input, "[", "]"));
    }

    @Test
    void testDelimiterAfterTerminationIgnored() {
        String input = "data ]ignored[valid]done";
        String[] expected = {"valid"};
        assertArrayEquals(expected, substringsBetween(input, "[", "]"));
    }

/*    @Test
    void testDelimiterEqualsTermination() {
        String input = "==a==b==c==";
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, substringsBetween(input, "==", "=="));
    }*/

    @Test
    void testNoClosingTermination() {
        String input = "text [notClosed";
        assertNull(substringsBetween(input, "[", "]"));
    }

    @Test
    void testOverlappingMatches() {
        String input = "<a><b><c>";
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, substringsBetween(input, "<", ">"));
    }

    @Test
    void testInputEndsWithDelimiterOnly() {
        String input = "text before [data";
        assertNull(substringsBetween(input, "[", "]"));
    }

    @Test
    void testMultipleSameSubstrings() {
        String input = "{same}{same}{same}";
        String[] expected = {"same", "same", "same"};
        assertArrayEquals(expected, substringsBetween(input, "{", "}"));
    }
}