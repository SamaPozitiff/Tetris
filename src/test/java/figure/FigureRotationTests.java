package figure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FigureRotationTests {

    @Test
    public void rotate_I_left() {
        Figure_I figure_i = new Figure_I();

        checkAllLeftRotationsOfFigure(figure_i);
    }

    @Test
    public void rotate_I_right() {
        Figure_I figure_i = new Figure_I();

        checkAllLeftRotationsOfFigure(figure_i);
    }

    @Test
    public void rotate_o_right() {
        Figure_O figure_o = new Figure_O();

        figure_o.rotateRight();

        assert isFigureRotatedCorrect(figure_o, 1);
    }

    @Test
    public void rotate_o_left() {
        Figure_O figure_o = new Figure_O();

        figure_o.rotateLeft();

        assert isFigureRotatedCorrect(figure_o, 0);
    }

    @Test
    public void rotate_L_right() {
        Figures_L_J_T figure_l = new Figures_L_J_T(Figure.FIGURE_L);

        checkAllRightRotationsOfFigure(figure_l);
    }

    @Test
    public void rotate_L_left() {
        Figures_L_J_T figure_l = new Figures_L_J_T(Figure.FIGURE_L);

        checkAllLeftRotationsOfFigure(figure_l);
    }

    @Test
    public void testRotating_T_Left() {
        Figures_L_J_T figure_T = new Figures_L_J_T(Figure.FIGURE_T);

        checkAllLeftRotationsOfFigure(figure_T);
    }

    @Test
    public void testRotating_T_Right() {
        Figures_L_J_T figure_T = new Figures_L_J_T(Figure.FIGURE_T);

        checkAllRightRotationsOfFigure(figure_T);
    }

    @Test
    public void testRotating_J_Left() {
        Figures_L_J_T figure_T = new Figures_L_J_T(Figure.FIGURE_T);

        checkAllLeftRotationsOfFigure(figure_T);
    }

    @Test
    public void testRotating_J_Right() {
        Figures_L_J_T figures_j = new Figures_L_J_T(Figure.FIGURE_J);

        checkAllRightRotationsOfFigure(figures_j);
    }

    @Test
    public void testRotating_S_Right() {
        Figures_S_Z figures_s = new Figures_S_Z(Figure.FIGURE_S);

        checkAllRightRotationsOfFigure(figures_s);
    }

    @Test
    public void testRotating_S_Left() {
        Figures_S_Z figures_s = new Figures_S_Z(Figure.FIGURE_S);

        checkAllLeftRotationsOfFigure(figures_s);
    }

    @Test
    public void testRotating_Z_Right() {
        Figures_S_Z figures_z = new Figures_S_Z(Figure.FIGURE_Z);

        checkAllRightRotationsOfFigure(figures_z);
    }

    @Test
    public void testRotating_Z_Left() {
        Figures_S_Z figures_z = new Figures_S_Z(Figure.FIGURE_Z);

        checkAllLeftRotationsOfFigure(figures_z);
    }

    private void checkAllLeftRotationsOfFigure(Figure figure) {
        figure.rotateLeft();

        assert isFigureRotatedCorrect(figure, 1);

        figure.rotateLeft();

        assert isFigureRotatedCorrect(figure, 2);

        figure.rotateLeft();

        assert isFigureRotatedCorrect(figure, 3);

        figure.rotateLeft();

        assert isFigureRotatedCorrect(figure, 0);
    }

    private void checkAllRightRotationsOfFigure(Figure figure) {
        figure.rotateLeft();

        assert isFigureRotatedCorrect(figure, 3);

        figure.rotateLeft();

        assert isFigureRotatedCorrect(figure, 2);

        figure.rotateLeft();

        assert isFigureRotatedCorrect(figure, 1);

        figure.rotateLeft();

        assert isFigureRotatedCorrect(figure, 0);
    }

    private boolean isFigureRotatedCorrect(Figure figure, int numOfRotations) {
        if(figure instanceof Figure_I) {
            Figure_I figure_i = (Figure_I) figure;
            return isFigureIRotatedCorrect(figure_i, numOfRotations);
        } else if (figure instanceof Figures_L_J_T) {
            Figures_L_J_T figures_l_j_t = (Figures_L_J_T) figure;
            return isFigure_LJT_RotatedCorrect(figures_l_j_t, numOfRotations);
        } else if (figure instanceof Figures_S_Z) {
            Figures_S_Z figures_s_z = (Figures_S_Z) figure;
            return isFigure_S_Z_RotatedCorrect(figures_s_z, numOfRotations);
        }

        Figure_O figure_o = (Figure_O) figure;
        return isFigure_O_RotatedCorrect(figure_o);
    }

    private boolean isFigure_O_RotatedCorrect(Figure_O figure_o) {
        return checkBlocsState(figure_o.blocks, new Figure_O().blocks);
    }

    private boolean isFigure_S_Z_RotatedCorrect(Figures_S_Z figures_s_z, int numOfRotating) {
        List<Block> expectedBlocks = new ArrayList<>();
        if(figures_s_z.typeOfFigure == Figures_S_Z.FIGURE_S) {
            expectedBlocks.add(new Block(0, 0));
            expectedBlocks.add(new Block(0, 1));
            expectedBlocks.add(new Block(-1, 0));
            expectedBlocks.add(new Block(-1, -1));
            rotateLeftFigureWithAlgorithm(expectedBlocks, numOfRotating);
        } else if (figures_s_z.typeOfFigure == Figures_L_J_T.FIGURE_Z) {
            expectedBlocks.add(new Block(0, 0));
            expectedBlocks.add(new Block(0, -1));
            expectedBlocks.add(new Block(-1, 0));
            expectedBlocks.add(new Block(1, -1));
            rotateLeftFigureWithAlgorithm(expectedBlocks, numOfRotating);
        }

        return checkBlocsState(figures_s_z.blocks, expectedBlocks);
    }

    private boolean isFigure_LJT_RotatedCorrect(Figures_L_J_T figures_l_j_t, int numOfRotating) {
        List<Block> expectedBlocks = new ArrayList<>();
        if(figures_l_j_t.typeOfFigure == Figures_L_J_T.FIGURE_T) {
            expectedBlocks.add(new Block(0, 0));
            expectedBlocks.add(new Block(1, 0));
            expectedBlocks.add(new Block(0, 1));
            expectedBlocks.add(new Block(0, -1));
            rotateLeftFigureWithAlgorithm(expectedBlocks, numOfRotating);
        } else if (figures_l_j_t.typeOfFigure == Figures_L_J_T.FIGURE_J) {
            expectedBlocks.add(new Block(0, 0));
            expectedBlocks.add(new Block(-1, 0));
            expectedBlocks.add(new Block(0, -1));
            expectedBlocks.add(new Block(0, -2));
            rotateLeftFigureWithAlgorithm(expectedBlocks, numOfRotating);
        } else if (figures_l_j_t.typeOfFigure == Figures_L_J_T.FIGURE_L) {
            expectedBlocks.add(new Block(0, 0));
            expectedBlocks.add(new Block(1, 0));
            expectedBlocks.add(new Block(0, -1));
            expectedBlocks.add(new Block(0, -2));
            rotateLeftFigureWithAlgorithm(expectedBlocks, numOfRotating);
        }

        return checkBlocsState(figures_l_j_t.blocks, expectedBlocks);
    }

    private void rotateLeftFigureWithAlgorithm(List<Block> blocks, int numOfRotating) {

        for(int i = 0; i < numOfRotating; i++) {
            for (Block block : blocks) {
                int h = block.getX();
                block.setX(block.getY());
                block.setY(-1 * h);
            }
        }
    }

    private boolean isFigureIRotatedCorrect(Figure_I figure_i, int numOfRotations) {
        List<Block> expectedBlocks = generateIRotation(numOfRotations);
        return checkBlocsState(figure_i.blocks, expectedBlocks);
    }

    private List<Block> generateIRotation(int iteration) {
        ArrayList<Block> figureI = new ArrayList<>();
        int state = iteration % 2;
        if (state == 0) {
            figureI.add(new Block(0, 0));
            figureI.add(new Block(0, -1));
            figureI.add(new Block(0, -2));
            figureI.add(new Block(0, -3));
        } else {
            figureI.add(new Block(0, 0));
            figureI.add(new Block(-1, 0));
            figureI.add(new Block(-2, 0));
            figureI.add(new Block(-3, 0));
        }
        return figureI;
    }

    private boolean checkBlocsState(List<Block> actualState, List<Block> expectedState) {
        for (int i = 0; i < expectedState.size(); i++) {
            if(!blockListContainsBlock(expectedState, actualState.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean blockListContainsBlock(List<Block> blockList, Block block) {
        for(int j = 0; j < blockList.size(); j++) {
            if(areBlocksEquals(block, blockList.get(j))) {
                return true;
            }
        }
        return false;
    }
    private boolean areBlocksEquals(Block block1, Block block2) {
        return block1.getX() == block2.getX() && block1.getY() == block2.getY();
    }
}
