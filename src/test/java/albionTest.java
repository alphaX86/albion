import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;

import albion.albion;

public class albionTest {
    @DisplayName("Test 1")
    @Test
    public void testMain() {
        String[] args = {"Round Robin"};
        albion.main(args);
    }

    @DisplayName("Test 2")
    @Test
    public void testMain2() {
        String[] args = {"Honey Bee"};
        albion.main(args);
    }

    @DisplayName("Test 3")
    @Test
    public void testMain3() {
        String[] args = {"Ant Colony"};
        albion.main(args);
    }

    @DisplayName("Test 1")
    @RepeatedTest(5)
    public void testMainR() {
        String[] args = {"Round Robin"};
        albion.main(args);
    }

    @DisplayName("Test 2")
    @RepeatedTest(5)
    public void testMainR2() {
        String[] args = {"Honey Bee"};
        albion.main(args);
    }

    @DisplayName("Test 3")
    @RepeatedTest(5)
    public void testMainR3() {
        String[] args = {"Ant Colony"};
        albion.main(args);
    }
}
