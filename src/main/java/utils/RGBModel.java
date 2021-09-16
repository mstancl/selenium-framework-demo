package utils;

public class RGBModel {

    int red;
    int green;
    int blue;

    public RGBModel(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public Boolean isRed() {
        return getRed() > 200 && getGreen() < 100 && getBlue() < 100;
    }

    public Boolean isGray() {
        return getRed() > 200 && getGreen() > 200 && getBlue() > 200;
    }

    public Boolean isBlack() {
        return getRed() < 50 && getGreen() < 50 && getBlue() < 50;
    }

    public Boolean isGreen() {
        return getRed() < 150 && getGreen() > 150 && getBlue() < 150;
    }


    @Override
    public String toString() {
        return "RGBModel{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
