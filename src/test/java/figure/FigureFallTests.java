package figure;

import manager.FigureManager;
import org.junit.jupiter.api.Test;

public class FigureFallTests {

    @Test
    public void testFigureFallCorrect() {
        Figure figureOld = new Figure_I();
        Figure figure = new Figure_I();
        figure.setAbcoluteY(2);
        figureOld.setAbcoluteY(2);

        figure.goDown();

        assert areAllBlocksBelowOn(figure, figureOld);
    }

    private boolean areAllBlocksBelowOn(Figure figureBelow, Figure figure) {
        for (int i = 0; i < Figure.SIZE; i++) {
            if(figureBelow.getBlock(i).getY() - figure.getBlock(i).getY() == 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testFigureFallingDown() {
        Field field = new Field();
        FigureManager manager = new FigureManager(field);
        manager.figureOnStart();
        int numOfFallings = 0;

        while (manager.canFigureFall()) {
            manager.figureGoDown();
            numOfFallings++;
        }

        assert numOfFallings == (Field.FIELD_Y - 1);
    }

    @Test
    public void testFigureFallingOnBlock() {
        Field field = createFieldWithBlock();
        FigureManager manager = new FigureManager(field);
        manager.figureOnStart();
        int numOfFallings = 0;

        while (manager.canFigureFall()) {
            manager.figureGoDown();
            numOfFallings++;
        }

        assert numOfFallings == (Field.FIELD_Y - 2);
    }

    private Field createFieldWithBlock() {
        Field field = new Field();
        Figure figure = new Figure();

        figure.setAbsoluteX(10);
        figure.setAbcoluteY(19);
        field.addFigureToField(figure);

        return field;
    }

    @Test
    public void testFigureAddingToFieldOnFall() {
        Field field = new Field();
        FigureManager manager = new FigureManager(field);
        manager.figureOnStart();
        manager.figureGoDown();
        while (manager.getCurrentFigure().getBlock(0).getY() != 0)
            manager.figureGoDown();

        assert !field.IsBlockEmpty(10, 19) && field.blocks.size() == 4;
    }
}
