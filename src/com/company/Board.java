package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Board {
    ArrayList<Tile[]> board = new ArrayList<>();
    BufferedImage chessSprites;
    // pieces
    BufferedImage wK;
    BufferedImage wQ;
    BufferedImage wR;
    BufferedImage wB;
    BufferedImage wN;
    BufferedImage wP;
    BufferedImage bK;
    BufferedImage bQ;
    BufferedImage bB;
    BufferedImage bR;
    BufferedImage bN;
    BufferedImage bP;
    public Board() {
    //display the board
    JFrame display = new JFrame("Chess");
    display.setSize(500,500);
    display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //get all the images
        try {
            chessSprites = ImageIO.read(getClass().getResource("/Chess_Pieces_Sprite.png"));
            wK = chessSprites.getSubimage(0,0,45,45);
            wQ = chessSprites.getSubimage(45,0,45,45);
            wB = chessSprites.getSubimage(90,0,45,45);
            wN = chessSprites.getSubimage(135,0,45,45);
            wR = chessSprites.getSubimage(180,0,45,45);
            wP = chessSprites.getSubimage(225,0,45,45);
            bK = chessSprites.getSubimage(0,45,45,45);
            bQ = chessSprites.getSubimage(45,45,45,45);
            bB = chessSprites.getSubimage(90,45,45,45);
            bN = chessSprites.getSubimage(135,45,45,45);
            bR = chessSprites.getSubimage(180,45,45,45);
            bP = chessSprites.getSubimage(225,45,45,45);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    // build empty board
        for (int i = 0; i < 8; i++) {
            Tile[] file = new Tile[8];
            for (int j = 0; j < 8; j++) {
                // even tiles are white
                if ((i+j) % 2 == 0) {
                    JPanel panel = new JPanel();
                    panel.setBackground(Color.decode("#769656"));
                    display.add(panel);
                    file[j] = new Tile("w", panel);
                }
                else{
                    JPanel panel = new JPanel();
                    panel.setBackground(Color.decode("#eeeed2"));
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
                JLabel piece = new JLabel(new ImageIcon(wQ));
                board.get(rank)[file].setPiece(new Piece(iter));
                board.get(rank)[file].getPanel().add(piece);

                file++;
            }

            // if a black piece is being added
            if(black.contains(iter)) {
                JLabel piece = new JLabel(new ImageIcon(bQ));
                board.get(rank)[file].setPiece(new Piece(iter));
                board.get(rank)[file].getPanel().add(piece);
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
