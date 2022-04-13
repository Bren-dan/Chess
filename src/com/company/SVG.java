package com.company;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;

public class SVG extends JLabel {
    private FlatSVGIcon icon;

    public void setSVGImage(String img , int width, int height) {
        icon = new FlatSVGIcon(img, width, height);

    }
}
