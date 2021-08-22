package duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    public void convertToTxtTest() {
        Event task = new Event("Test convertToTxt()", "2021-08-22 1000");
        assertEquals("E | 0 | Test convertToTxt() | Aug 22 2021 10.00 AM", task.convertToTxt());
    }

    @Test
    public void toStringDateTest() {
        Event task = new Event("Test toString() with Date", "2021-08-22");
        assertEquals("[E][ ] Test toString() with Date (at: Aug 22 2021)", task.toString());
    }

    @Test
    public void toStringDateTimeTest() {
        Event task = new Event("Test toString() with DateTime", "2021-08-22 1000");
        assertEquals("[E][ ] Test toString() with DateTime (at: Aug 22 2021 10.00 AM)", task.toString());
    }

    @Test
    public void toStringNormalTest() {
        Event task = new Event("Test toString()", "Tonight");
        assertEquals("[E][ ] Test toString() (at: Tonight)", task.toString());
    }

    @Test
    public void markAsDoneTest() {
        Event task = new Event("Test markAsDone()", "2021-08-22 1000");
        task.markAsDone();
        assertEquals("[E][X] Test markAsDone() (at: Aug 22 2021 10.00 AM)", task.toString());
    }
}
