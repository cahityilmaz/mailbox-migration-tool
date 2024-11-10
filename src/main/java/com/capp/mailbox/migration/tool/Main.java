package com.capp.mailbox.migration.tool;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatSystemProperties;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;

/**
 * @author mucahit.yilmaz
 */
public class Main {

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            System.setProperty("flatlaf.animatedLafChange", "true");
            System.setProperty( FlatSystemProperties.UI_SCALE, "1.1x" );

            FlatRobotoFont.install();
            FlatLaf.disableWindowsD3Donscreen();
            FlatLaf.setPreferredFontFamily(FlatRobotoFont.FAMILY);

            FlatLightLaf.registerCustomDefaultsSource("com/capp/mailbox/migration/tool");
            FlatLightLaf.setup();

            new App().setVisible(true);
        });
    }
}
