package ch.css.al1.russianpeasant;

import org.beryx.textio.TextTerminal;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RussianPeasantPrinter {
    public static final int SPACE_DISTANCE_BETWEEN_TWO_NUMBERS = 3;
    public static final String SPACES_BETWEEN_TWO_NUMBERS = "  ";
    private final TextTerminal<?> textTerminal;
    private final CalculationProcess calculationProcess;

    public RussianPeasantPrinter(TextTerminal<?> textTerminal, CalculationProcess calculationProcess) {

        this.textTerminal = textTerminal;
        this.calculationProcess = calculationProcess;
    }


    public void printResult() {
        StringBuilder output = new StringBuilder();
        int lengthOfLine = getLengthOfLine();
        addFirstLine(output);
        addSymbolLine(output, lengthOfLine);
        addCalculationProcess(output);
        addSecondSymbolLine(output, lengthOfLine);
        addResultLine(output, lengthOfLine);
        print(output);
    }

    private void print(StringBuilder output) {
        textTerminal.print(output.toString());
    }

    private void addResultLine(StringBuilder output, int lengthOfLine) {
        output.append(getResultLineOutput(calculationProcess.result(), lengthOfLine));
    }

    private void addSecondSymbolLine(StringBuilder output, int lengthOfLine) {
        output.append(getSymbolLine("=", lengthOfLine));
    }

    private void addCalculationProcess(StringBuilder output) {
        output.append(calculationProcess.russianPeasantTable().stream()
                .map(line -> line.leftNumber() + SPACES_BETWEEN_TWO_NUMBERS + line.rightNumber() + "\n")
                .collect(Collectors.joining()));
    }

    private void addSymbolLine(StringBuilder output, int lengthOfLine) {
        output.append(getSymbolLine("-", lengthOfLine));
    }

    private void addFirstLine(StringBuilder output) {
        output.append(getFirstLineOutput(calculationProcess.getOriginalLine()));
    }

    private String getSymbolLine(String symbol, int lengthOfALine) {
        return IntStream.rangeClosed(1, lengthOfALine)
                .mapToObj(value -> symbol)
                .collect(Collectors.joining()) + "\n";
    }

    private int getLengthOfLine() {
        return countDig(calculationProcess.getOriginalLine().leftNumber()) +
                countDig(calculationProcess.getOriginalLine().rightNumber()) +
                SPACE_DISTANCE_BETWEEN_TWO_NUMBERS;
    }

    private String getResultLineOutput(int result, int lengthOfALine) {
        int resultLength = countDig(result);
        var spaces = IntStream.rangeClosed(1, lengthOfALine - resultLength)
                .mapToObj(value -> " ")
                .collect(Collectors.joining());
        return spaces + result;
    }

    private int countDig(int value) {
        return (int) (Math.log10(value) + 1);
    }

    private static String getFirstLineOutput(Line firstLine) {
        return firstLine.leftNumber() + " * " + firstLine.rightNumber() + "\n";
    }
}
