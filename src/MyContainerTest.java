import static org.junit.Assert.*;
import org.junit.*;

public class MyContainerTest {
    private MyContainer container;

    @Before
    public void setUp() {
        container = new MyContainer();
    }

    @Test
    public void testAddAndGet() {
        container.add(5);
        container.add(10);
        container.add(15);

        assertEquals(5, container.getValue(0));
        assertEquals(10, container.getValue(1));
        assertEquals(15, container.getValue(2));
    }

    @Test
    public void testRemoveAt() {
        container.add(5);
        container.add(10);
        container.add(15);

        container.removeAt(1);

        assertEquals(5, container.getValue(0));
        assertEquals(15, container.getValue(1));
        assertEquals(2, container.size());
    }

    @Test
    public void testGetValue() {
        container.add(5);
        container.add(10);
        container.add(15);

        assertEquals(10, container.getValue(1));
    }

    @Test
    public void testSetValue() {
        container.add(5);
        container.add(10);
        container.add(15);

        container.setValue(20, 1);

        assertEquals(20, container.getValue(1));
    }

    @Test
    public void testSize() {
        container.add(5);
        container.add(10);
        container.add(15);

        assertEquals(3, container.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueOutOfBounds() {
        container.add(5);
        container.getValue(1); // Should throw IndexOutOfBoundsException
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtOutOfBounds() {
        container.add(5);
        container.removeAt(1); // Should throw IndexOutOfBoundsException
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetValueOutOfBounds() {
        container.add(5);
        container.setValue(20, 1); // Should throw IndexOutOfBoundsException
    }
}
