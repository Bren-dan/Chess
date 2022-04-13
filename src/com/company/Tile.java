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
        panel = panel;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
