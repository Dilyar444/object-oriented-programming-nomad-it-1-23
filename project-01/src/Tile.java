import java.awt.Color;

public class Tile {

    private int value;
    private Color color;
    private Color textColor;

    public Tile(int value, Color color, Color textColor) {
        this.value = value;
        this.color = color;
        this.textColor = textColor;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}




