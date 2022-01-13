package com.prodan.kmm_playground

import kotlin.test.Test
import kotlin.test.assertTrue

class NativeTest {

    @Test
    fun testExample() {
        assertTrue(Greeting().greeting().contains("Hello"), "Check 'Hello' is mentioned")
    }
}