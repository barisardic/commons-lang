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
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.ClassUtils.getShortClassName;
import static org.junit.jupiter.api.Assertions.*;
public class GetShortClassNameTest {

/*    @Test
    void testNullInput() {
        assertEquals("", getShortClassName(null));
    }*/

    @Test
    void testEmptyInput() {
        assertEquals("", getShortClassName(""));
    }

    @Test
    void testRegularClassName() {
        assertEquals("String", getShortClassName("java.lang.String"));
    }

    @Test
    void testNestedClass() {
        assertEquals("Outer.Inner", getShortClassName("com.example.Outer$Inner"));
    }

    @Test
    void testPrimitiveArrayTypeEncoded() {
        assertEquals("int[]", getShortClassName("[I"));
        assertEquals("boolean[]", getShortClassName("[Z"));
        assertEquals("char[]", getShortClassName("[C"));
    }

    @Test
    void testObjectArrayTypeEncoded() {
        assertEquals("String[]", getShortClassName("[Ljava.lang.String;"));
    }

    @Test
    void testMultiDimensionalObjectArray() {
        assertEquals("String[][]", getShortClassName("[[Ljava.lang.String;"));
    }

    @Test
    void testMultiDimensionalPrimitiveArray() {
        assertEquals("int[][]", getShortClassName("[[I"));
    }

    @Test
    void testSimpleArrayClassName() {
        assertEquals("String[]", getShortClassName("java.lang.String[]"));
    }

    @Test
    void testClassNameWithNoPackage() {
        assertEquals("MyClass", getShortClassName("MyClass"));
    }

    @Test
    void testNestedClassWithNoPackage() {
        assertEquals("Outer.Inner", getShortClassName("Outer$Inner"));
    }
}
