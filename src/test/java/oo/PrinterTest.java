package oo;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static oo.Printer.print;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintWhatIWantPrint() {
        print("Print me!");

        assertThat(outContent.toString(), is("Print me!"));
    }
}