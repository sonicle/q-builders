/*
 *
 *  *  com.github.rutledgepaulv.qbuilders.utilities.ObjectUtilsTest
 *  *  *
 *  *  * Copyright (C) 2016 Paul Rutledge <paul.v.rutledge@gmail.com>
 *  *  *
 *  *  * This software may be modified and distributed under the terms
 *  *  * of the MIT license.  See the LICENSE file for details.
 *  *
 *
 */

package com.github.rutledgepaulv.qbuilders.utilities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ObjectUtilsTest {

    private static class WithNoVisibleConstructor {

        private WithNoVisibleConstructor(){}

    }


    public static class SinglePlainArgument {

        public SinglePlainArgument(String value) {

        }
    }

    @Test
    public void noVisibleConstructor() throws Exception {
        expect("Could not instantiate class for provided arguments.", ()
                -> ObjectUtils.init(WithNoVisibleConstructor.class));
    }

    @Test
    public void noArgumentsProvided() throws Exception {
        expect("Could not instantiate class for provided arguments.", ()
                -> ObjectUtils.init(SinglePlainArgument.class));
    }

    @Test
    public void wrongArgumentTypesProvided() throws Exception {
        expect("Could not instantiate class for provided arguments.", ()
                -> ObjectUtils.init(SinglePlainArgument.class, (Integer) 55));
    }

    @Test
    public void correctTypeProvided() throws Exception {
        SinglePlainArgument instance = ObjectUtils.init(SinglePlainArgument.class, "stuff");
        assertNotNull(instance);
    }

    private void expect(String message, Runnable runnable) {
        try {
            runnable.run();
        } catch(Exception e) {
            assertTrue(e instanceof RuntimeException);
            assertEquals(message, e.getMessage());
        }
    }
}
