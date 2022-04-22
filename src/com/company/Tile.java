package com.company;

import javax.swing.*;
import java.awt.*;

public class Tile {
    Piece piece;
    String colour;
    JPanel panel;

    public Tile(String colour, JPanel panel) {
        this.piece = new Piece("e");
        this.colour = colour;
        this.panel = panel;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
