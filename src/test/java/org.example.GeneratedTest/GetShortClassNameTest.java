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
package org.example.GeneratedTest;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.ClassUtils.getShortClassName;
import static org.junit.jupiter.api.Assertions.*;
public class GetShortClassNameTest {

    @Test
    void testNullInput() {
        assertEquals("", getShortClassName((Class<?>) null));
    }

    @Test
    void testEmptyInput() {
        assertEquals("", getShortClassName(""));
    }

    @Test
    void testNormalClassName() {
        assertEquals("String", getShortClassName("java.lang.String"));
    }

    @Test
    void testClassWithoutPackage() {
        assertEquals("Main", getShortClassName("Main"));
    }

    @Test
    void testInnerClass() {
        assertEquals("Outer.Inner", getShortClassName("com.example.Outer$Inner"));
    }

    @Test
    void testNestedInnerClass() {
        assertEquals("Outer.Inner.DeepInner", getShortClassName("com.example.Outer$Inner$DeepInner"));
    }

    @Test
    void testPrimitiveArrayInt() {
        assertEquals("int[]", getShortClassName("[I"));
    }

    @Test
    void testPrimitiveArrayBoolean() {
        assertEquals("boolean[]", getShortClassName("[Z"));
    }

    @Test
    void testObjectArray() {
        assertEquals("String[]", getShortClassName("[Ljava.lang.String;"));
    }

    @Test
    void testMultiDimensionalPrimitiveArray() {
        assertEquals("int[][]", getShortClassName("[[I"));
    }

    @Test
    void testMultiDimensionalObjectArray() {
        assertEquals("String[][]", getShortClassName("[[Ljava.lang.String;"));
    }

    @Test
    void testArrayOfInnerClass() {
        assertEquals("Outer.Inner[]", getShortClassName("[Lcom.example.Outer$Inner;"));
    }

    @Test
    void testUnusualButValidClassName() {
        assertEquals("X", getShortClassName("a.b.c.X"));
    }

    @Test
    void testArrayWithUnmappedPrimitive() {
        assertEquals("Q[]", getShortClassName("[Q"));  // should remain as 'Q[]' if not mapped
    }
}
