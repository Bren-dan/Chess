package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------");
        // board from starting position
        Board board = new Board();
        board.buildBoardFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        System.out.println("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        System.out.println(board);

        System.out.println("------------------------------------------------------------------------");
        /*board after a few moves
        Board board2 = new Board();
        board2.buildBoardFEN("rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R");
        System.out.println("rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R");
        System.out.println(board2);
        System.out.println("------------------------------------------------------------------------");*/
    }
}
