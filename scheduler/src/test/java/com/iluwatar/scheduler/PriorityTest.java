package com.iluwatar.scheduler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriorityTest {

    @Test
    public void shouldReturnCorrectPropertyName() throws Exception {
        // given
        Priority priority = new Priority(1);
        // when
        String propertyName = priority.getName();
        // then
        assertEquals("priority", propertyName);
    }
}