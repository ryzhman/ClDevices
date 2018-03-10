package stackRealization;

import exceptions.StackSizeExceededException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Oleksandr Ryzhkov on 10.03.2018.
 */
public class CustomStackTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void pushTest() throws StackSizeExceededException {
        CustomStack customStack = new CustomStack(5);
        customStack.push("item 1");
        customStack.push("item 2");
        customStack.push("item 3");

        assertEquals(3, customStack.getSize());

        customStack.push("item 4");

        assertEquals(4, customStack.getSize());
        assertFalse(customStack.isEmpty());
        assertEquals(5, customStack.getMaxSize());
    }

    @Test
    public void pushExceedMaxSizeTest() throws StackSizeExceededException {
        exception.expect(StackSizeExceededException.class);
        exception.expectMessage("Maximum size of a stack as exceeded");
        CustomStack customStack = new CustomStack(5);

        assertEquals(5, customStack.getMaxSize());

        customStack.push("item 1");
        customStack.push("item 2");
        customStack.push("item 3");
        customStack.push("item 4");
        customStack.push("item 5");
        customStack.push("item 6");
    }

    @Test
    public void popTest() throws StackSizeExceededException {
        CustomStack customStack = new CustomStack(5);
        customStack.push("item 1");
        customStack.push("item 2");
        customStack.push("item 3");

        assertEquals(5, customStack.getMaxSize());
        assertEquals(3, customStack.getSize());
        assertEquals("item 3", customStack.pop());
        assertEquals(2, customStack.getSize());
        assertEquals("item 2", customStack.pop());
        assertEquals(1, customStack.getSize());
        assertEquals("item 1", customStack.pop());
        assertEquals(0, customStack.getSize());
        assertNull(customStack.pop());
        assertEquals(5, customStack.getMaxSize());
    }

    @Test
    public void getMaxSizeTest() {
        CustomStack customStack = new CustomStack(33);
        assertEquals(33, customStack.getMaxSize());
    }

    @Test
    public void getSizeTest() throws StackSizeExceededException {
        CustomStack customStack = new CustomStack(33);
        customStack.push("item 1");
        customStack.push("item 2");
        customStack.push("item 3");
        customStack.push("item 4");
        customStack.push("item 5");
        customStack.push("item 6");
        customStack.push("item 7");

        assertEquals(7, customStack.getSize());
    }

    @Test
    public void isEmpytTest() throws StackSizeExceededException {
        CustomStack customStack = new CustomStack(33);
        customStack.push("item 1");
        customStack.push("item 2");
        customStack.push("item 3");
        customStack.push("item 4");
        customStack.push("item 5");
        customStack.push("item 6");
        customStack.push("item 7");

        assertFalse(customStack.isEmpty());

        customStack = new CustomStack(33);
        assertTrue(customStack.isEmpty());
    }

    @Test
    public void stackWithZeroSizeTest() throws StackSizeExceededException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Stack size cannot be less or equals to zero");

        new CustomStack(0);
    }
}
