package ch.css.al1.russianpeasant;

import java.util.ArrayList;
import java.util.List;

public class RussianpeasantMultiplicator {
    List<Line> russianPeasanTable = new ArrayList<>();

    public int multiplicate(int x, int y) {
        addFirstLine(x, y);
        goToCalculate();
        return summerizeRightCoumn();
    }

    public CalculationProcess getMultiplicateResultTable(int x, int y) {
        return new CalculationProcess(russianPeasanTable,multiplicate(x, y));
    }

    private void addFirstLine(int x, int y) {
        final var firstLine = new Line(x, y);
        addLine(firstLine);
    }

    private void goToCalculate() {
        final var lastLine = getLastLine();
        if (isCalculationNotFinished(lastLine)) {
            addNewLine(lastLine);
            goToCalculate();
        }
    }

    private Line getLastLine() {
        return russianPeasanTable.get(russianPeasanTable.size() - 1);
    }

    private void addNewLine(Line lastLine) {
        int newLeftNumber = divideByTwo(lastLine.leftNumber());
        int newRightNumber = doubleValue(lastLine.rightNumber());
        final var newLine = new Line(newLeftNumber, newRightNumber);
        addLine(newLine);
    }

    private static int doubleValue(int rightNumber) {
        return rightNumber * 2;
    }

    private static int divideByTwo(int leftNumber) {
        return leftNumber / 2;
    }

    private void addLine(Line newLine) {
        russianPeasanTable.add(newLine);
    }

    private boolean isCalculationNotFinished(Line lastLine) {
        return lastLine.leftNumber() != 1;
    }

    private int summerizeRightCoumn() {
        return russianPeasanTable.stream()
                .filter(RussianpeasantMultiplicator::leftValueNotEven)
                .mapToInt(Line::rightNumber)
                .sum();
    }

    private static boolean leftValueNotEven(Line line) {
        return line.leftNumber() % 2 != 0;
    }

}
