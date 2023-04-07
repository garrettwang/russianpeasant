package ch.css.al1.russianpeasant;

import java.util.List;

record CalculationProcess(List<Line> russianPeasantTable, int result) {
    public Line getOriginalLine() {
        return russianPeasantTable().get(0);
    }
}
