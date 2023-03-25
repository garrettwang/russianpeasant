package ch.css.al1.russianpeasant;

import java.util.ArrayList;
import java.util.List;

public class RussianpeasantMultiplicator {
    List<Line> russianPeasanTable = new ArrayList<>();

    public int mul(int x, int y) {
        russianPeasanTable.add(new Line(x, y));
        goToCalculate();
        return summerizeRightCoumn();
    }

    private void goToCalculate() {
        final Line lastLine = russianPeasanTable.get(russianPeasanTable.size() - 1);
        if (!isCalFinished(lastLine)) {
            addNewLine(lastLine);
            goToCalculate();
        }
    }

    private void addNewLine(Line lastLine) {
        russianPeasanTable.add(new Line(lastLine.x() / 2, lastLine.y() * 2));
    }

    private static boolean isCalFinished(Line lastLine) {
        return lastLine.x() == 1;
    }

    private int summerizeRightCoumn() {
        return russianPeasanTable.stream()
                .filter(RussianpeasantMultiplicator::leftValueNotEven)
                .mapToInt(Line::y)
                .sum();
    }

    private static boolean leftValueNotEven(Line line) {
        return line.x() % 2 != 0;
    }
}
