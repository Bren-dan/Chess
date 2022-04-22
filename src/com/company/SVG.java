package com.company;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.extras.FlatSVGUtils;

import javax.swing.*;

public class SVG extends JLabel {
    private FlatSVGIcon icon;

    public void setSVGImage(String img , int width, int height) {
        icon = new FlatSVGIcon(img, width, height);
        System.out.println(icon.hasFound());
        setIcon(icon);

    }
}
