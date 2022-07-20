package main.java.figure;

public class Block {
    private int x;
    private int y;
    private int  image;
    Block(int x, int y){
        this.x = x;
        this.y = y;
    }

    Block(int x, int y, int image){
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getImage(){
        return image;
    }


}