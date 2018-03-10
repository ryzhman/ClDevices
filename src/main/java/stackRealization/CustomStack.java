package stackRealization;

import exceptions.StackSizeExceededException;

import java.util.Arrays;

/**
 * Class that represents custom stack realiation
 * <p>
 * Created by Oleksandr Ryzhkov on 10.03.2018.
 */
public class CustomStack {
    private String[] array;
    private int topIndex;
    private int maxSize;

    public CustomStack(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Stack size cannot be less or equals to zero");
        }
        this.maxSize = maxSize;
        array = new String[maxSize];
        topIndex = 0;
    }

    public void push(String itemToPush) throws StackSizeExceededException {
        if (topIndex >= maxSize) {
            throw new StackSizeExceededException("Maximum size of a stack as exceeded");
        }
        synchronized (this) {
            array[topIndex] = itemToPush;
            topIndex++;
        }
    }

    public String pop() {
        if (topIndex == 0) {
            return null;
        }
        synchronized (this) {
            String topItem = new String(array[--topIndex]);
            array[topIndex] = null;
            return topItem;
        }
    }

    public boolean isEmpty() {
        return Arrays.stream(array).allMatch(s -> s == null);
    }

    public int getSize() {
        return Math.toIntExact(Arrays.stream(array).filter(s -> s != null).count());
    }

    public int getMaxSize() {
        return maxSize;
    }
}
