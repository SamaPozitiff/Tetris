package main.java.manager;

import main.java.figure.Block;

import java.util.List;

public interface IField {
    public static final int FIELD_X = 20;
    public static final int FIELD_Y = 20;
    public boolean isBlockEmpty(int x, int y);
    void addBlock(List<Block> blocks);


}
