package ch.css.al1.russianpeasant;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class Application {
    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();

        Integer numberX = textIO.newIntInputReader()
                .read("Please input the first number x:");

        Integer numberY = textIO.newIntInputReader()
                .read("Please input the first number y:");
        final var result = new RussianpeasantMultiplicator().getMultiplicateResultTable(numberX, numberY);
        TextTerminal<?> textTerminal = textIO.getTextTerminal();
        RussianPeasantPrinter russianPeasantPrinter = new RussianPeasantPrinter(textTerminal,result);
        russianPeasantPrinter.printResult();
    }
}
