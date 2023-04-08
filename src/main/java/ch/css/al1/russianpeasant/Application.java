package ch.css.al1.russianpeasant;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class Application {
    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();

        Integer numberX = getNumberX(textIO);

        Integer numberY = getNumberY(textIO);

        final var result = new RussianpeasantMultiplicator().getMultiplicateResultTable(numberX, numberY);

        printResult(textIO, result);
    }

    private static void printResult(TextIO textIO, CalculationProcess result) {
        RussianPeasantPrinter russianPeasantPrinter = new RussianPeasantPrinter(textIO.getTextTerminal(), result);
        russianPeasantPrinter.printResult();
    }

    private static Integer getNumberY(TextIO textIO) {
        return textIO.newIntInputReader()
                .read("Please input the first number y:");
    }

    private static Integer getNumberX(TextIO textIO) {
        return textIO.newIntInputReader()
                .read("Please input the first number x:");
    }
}
