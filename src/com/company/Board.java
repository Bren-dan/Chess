package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board {
    ArrayList<Tile[]> board = new ArrayList<>();

    public Board() {
    //display the board
    JFrame display = new JFrame();
    display.setSize(500,500);
    display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JFrame display2 = new JFrame();
    display2.setSize(500,500);
    display2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SVG img = new SVG();
    JPanel panel2 = new JPanel();
    img.setSVGImage("static/Chess_Pieces_Sprite.svg", 200, 200);
    panel2.add(img);
    display2.add(panel2);
    display2.setVisible(true);





    // build empty board
        for (int i = 0; i < 8; i++) {
            Tile[] file = new Tile[8];
            for (int j = 0; j < 8; j++) {
                // even tiles are white
                if ((i+j) % 2 == 0) {
                    JPanel panel = new JPanel();
                    panel.setBackground(Color.black);
                    display.add(panel);
                    file[j] = new Tile("w", panel);
                }
                else{
                    JPanel panel = new JPanel();
                    panel.setBackground(Color.white);
                    display.add(panel);
                    file[j] = new Tile("b", panel);

                }
            }
            board.add(file);
        }
        display.setVisible(true);
        display.setLayout(new GridLayout(8,8));
    }
    public ArrayList<Tile[]> buildBoardFEN(String fen) {
        //process string. Starts and rank 8 and descends
        String num = "123456789";
        String white = "PNBRQK";
        String black = "pnbrqk";
        int rank = 7;
        int file = 0;
        for (int i = 0; i < fen.length(); i++) {
            String iter = ""+fen.charAt(i);
            // if number skip by # of tiles
            if (num.contains(iter)) {
                int number = Integer.parseInt(iter);
                file += number;
            }
            //if / then it's a new rank
            if (iter.equals("/")) {
                rank--;
                file = 0;
            }
            // if a white piece is being added
            if(white.contains(iter)) {
                board.get(rank)[file].setPiece(new Piece(iter));
                file++;
            }

            // if a black piece is being added
            if(black.contains(iter)) {
                board.get(rank)[file].setPiece(new Piece(iter));
                file++;
            }
        }
        // Builds a default starting board
        //buildBoardFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        return board;
    }

    @Override
    public String toString() {
        String returnString = "";
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                returnString += board.get(i)[j].getPiece().getId();
            }
            returnString+= "/";
        }
        return returnString;
    }
}
