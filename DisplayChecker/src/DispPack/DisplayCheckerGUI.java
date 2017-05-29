package DispPack;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

/**
 *
 * @author Joni
 */
public class DisplayCheckerGUI extends javax.swing.JFrame {

    
    // Remove the trailing from double and add spaces after 3 integers
    DecimalFormat df = new DecimalFormat("0.#");
    DecimalFormat df3Int = new DecimalFormat("#,###.#");
    
    /**
     * Creates new form DisplayChekcerGUI
     */
    public DisplayCheckerGUI() {
        initComponents();
        
        // Only integer values to textfields
        texWidth.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == KeyEvent.VK_ENTER) {
                    calculateFields();
                }
                else if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        
        texHeight.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == KeyEvent.VK_ENTER) {
                    calculateFields();
                }
                else if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        
        // Make the frame to appear middle of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    public void calculateFields() {
        String getX = texWidth.getText();
        String getY = texHeight.getText();
        
        getDisplayStandard(Double.parseDouble(getX), Double.parseDouble(getY));
    }
    
    public void getDisplayStandard(double x, double y) {
        String displayType = "";
        String displayTypeFullName = "";
        String displayResolution = "";
        String displayDescription = "";
        String source = "Source: Wikipedia";
        
        texDescription.setText(""); // Clear the previous info(s) if there are any
        
        if (x == 320 && y == 240) {
            displayType = "QVGA";
            displayTypeFullName = "Quarter Video Graphics Array";
            displayResolution = "4:3";
            displayDescription = "Half the resolution in each dimension as standard VGA. "
                    + "A retronym for CGA \"medium\" and EGA/MCGA/VGA \"low\" pixel resolution, "
                    + "normally used when describing screens on portable devices (pocket media players, cellular phones, PDAs etc.). "
                    + "No set colour depth or refresh rate is associated with this standard or those that follow, "
                    + "as it is dependent both on the manufacturing quality of the screen and the capabilities of the attached display driver hardware, "
                    + "and almost always incorporates an LCD panel with no visible line-scanning. "
                    + "However, it would typically be in the 8-to-12 bpp (256 to 4096 colour) through 18 bpp (262,144 colour) range."; 
        }
        else if (x == 320 && y == 200) {
            displayType = "CGA";
            displayTypeFullName = "Color Graphics Adapter";
            displayResolution = "8:5 (16:10)";
            displayDescription = "Introduced in 1981 by IBM, as the first color display standard for the IBM PC. "
                    + "The standard CGA graphics cards were equipped with 16 kB video RAM";
        }
        else if (x == 640 && y == 480) {
            displayType = "VGA";
            displayTypeFullName = "Video Graphics Array";
            displayResolution = "4:3";
            displayDescription = "Introduced on MCA-based PS/2 models in 1987. VGA is actually a set of different resolutions, "
                    + "but is most commonly used today to refer to 640x480 pixel displays with 16 colors (4 bits per pixel) and a 4:3 aspect ratio. "
                    + "Other display modes are also defined as VGA, such as 320x200 at 256 colors (8 bits per pixel) and a text mode with 720x400 pixels. "
                    + "VGA displays and adapters are generally capable of Mode X graphics, an undocumented mode to allow increased non-standard resolutions, "
                    + "most commonly 320x240 (with 8 bpp and square pixels). "
                    + "VGA, like the majority of the following standards, was capable of displaying most standard modes featured by IBM-compatible PCs - CGA, EGA, MDA and MCGA - but typically not Hercules or PGA/PGC.";
        }
        else if (x == 800 && y == 480) {
            displayType = "WVGA";
            displayTypeFullName = "Wide Video Graphics Array";
            displayResolution = "5:3";
            displayDescription = "Wide VGA or WVGA, sometimes just WGA, an abbreviation for Wide Video Graphics Array is any display resolution with the same 480 pixel height as VGA but wider, "
                    + "such as 720×480 (3:2 aspect ratio), 800×480 (5:3), 848×480, 852×480, 853×480 or 854×480 (~16:9). "
                    + "It is a common resolution among LCD projectors and later portable and hand-held internet-enabled devices (such as MID and Netbooks) as it is capable of rendering web sites designed for an 800 wide window in full page-width.";
        }
        else if (x == 768 && y == 576) {
            displayType = "PAL";
            displayTypeFullName = "Phase Alternating Line";
            displayResolution = "4:3";
            displayDescription = "Phase Alternating Line (PAL) is a colour encoding system for analogue television used in broadcast television systems in most countries broadcasting at 625-line / 50 field (25 frame) per second (576i). "
                    + "Other common colour encoding systems are NTSC and SECAM.";
        }
        else if (x == 854 && y == 480) {
            displayType = "FWVGA";
            displayTypeFullName = "Full Wide Video Graphics Array";
            displayResolution = "16:9";
            displayDescription = "FWVGA is an abbreviation for Full Wide Video Graphics Array which refers to a display resolution of 854x480 pixels. "
                    + "854x480 is approximately the 16:9 aspect ratio of anamorphically \"un-squeezed\" NTSC DVD widescreen video and considered a \"safe\" resolution that does not crop any of the image.";
        }
        else if (x == 800 && y == 600) {
            displayType = "SVGA";
            displayTypeFullName = "Super Video Graphics Array";
            displayResolution = "4:3";
            displayDescription = "A video display standard created by VESA for IBM PC compatible personal computers. "
                    + "Introduced in 1989. Displayed the regular VGA modes, plus 800x600 in 16 colours at a slightly lower 56 Hz refresh rate. "
                    + "As it was one of the feature modes on third-party video cards offering a wide array of \"extended\" video modes "
                    + "(making best use of whatever memory they had available, e.g. 384 kB instead of the minimum 256 kB to meet the VESA standard), "
                    + "\"SVGA\" - and later \"VESA\" - became, for a while, a catch-all term describing any video card or mode over and above \"standard\" 640x480, "
                    + "4 bpp VGA - including base resolution VGA in 8 bpp colour (a common choice for \"SVGA\" mode in PC games), "
                    + "and a wide variety of high- and true-colour modes, until high-resolution, true-colour displays became commonplace enough to no longer be deemed worthy of a special group designation.";
        }
        else if (x == 1024 && y == 600) {
            displayType = "WSVGA";
            displayTypeFullName = "Wide Super Video Graphics Array";
            displayResolution = "16:9";
            displayDescription = "The wide version of SVGA is known as WSVGA (Wide Super VGA), featured on Ultra-Mobile PCs, netbooks, and tablet computers. "
                    + "The resolution is either 1024×576 (aspect ratio 16:9) or 1024×600 (between 15:9 and 16:9) with screen sizes normally ranging from 7 to 10 inches. "
                    + "It has full XGA width of 1024 pixels.";
        }
        else if (x == 1024 && y == 768) {
            displayType = "XGA";
            displayTypeFullName = "Extended Graphics Array";
            displayResolution = "4:3";
            displayDescription = "An IBM display standard introduced in 1990. XGA added built on 8514/A's existing 1024x768 mode and added support for \"high color\" (65,536 colour, 16 bpp) at 640x480. "
                    + "The second revision (\"XGA-2\") was a more thorough upgrade, offering higher refresh rates (75 Hz and up, non-interlaced, "
                    + "up to at least 1024x768), improved performance, and a fully programmable display engine capable of almost any resolution within its physical limits. "
                    + "For example, 1280x1024 (5:4) or 1360x1024 (4:3) in 16 colors at 60 Hz, 1056x400 [14h] Text Mode (132x50 characters), 800x600 in 256 or 64k colour, "
                    + "and even as high as 1600x1200 (at a reduced 50 Hz scan rate) with a high quality multisync monitor (or an otherwise non-standard 960x720 at 60 Hz on a lower-end one capable of high refresh at 800x600, "
                    + "but only interlaced mode at 1024x768). "
                    + "However, the extended modes required custom drivers, and so only the basic options (1024x768×8 I, 640x480×16 NI, high-res text) were commonly used outside Windows and other hardware-abstracting graphical environments.";
        }
        else if (x == 1280 && y == 1024) {
            displayType = "SXGA";
            displayTypeFullName = "Super Extended Graphics Array";
            displayResolution = "5:4";
            displayDescription = "A widely used standard, introduced with XGA-2 and other early \"multiscan\" graphics cards and monitors, "
                    + "with an unusual aspect ratio of 5:4 (1.25:1) instead of the more common 4:3 (1.33:1), "
                    + "meaning even 4:3 pictures and video will appear letterboxed on the narrower 5:4 screens. "
                    + "This is generally the native resolution - with, therefore, square pixels - of standard 17\" and 19\" LCD monitors. "
                    + "It was often a recommended resolution for 17\" and 19\" CRTs also ,"
                    + "although as they were usually produced in a 4:3 aspect it either gave non-square pixels or required adjustment to show small vertical borders at each side of the image. "
                    + "Allows 24-bit colour in 4 MB of graphics memory, or 4-bit in 640 kB.";
        }
        else if (x == 1400 && y == 1050) {
            displayType = "SXGA+";
            displayTypeFullName = "Super Extended Graphics Array PLUS";
            displayResolution = "4:3";
            displayDescription = "Used on 14-inch (360 mm) and 15-inch (380 mm) notebook LCD screens and a few smaller screens,"
                    + "until the eventual market-wide phasing-out of 4:3 aspect displays.";
        }
        else if (x == 1280 && y == 720) {
            displayType = "HD 720";
            displayTypeFullName = "High Definition (720p)";
            displayResolution = "16:9";
            displayDescription = "This display aspect ratio is among the most common in recent notebook computers and desktop monitors.";
        }
        else if (x == 1280 && y == 768) {
            displayType = "WXGA";
            displayTypeFullName = "Widescreen Extended Graphics Array";
            displayResolution = "5:3";
            displayDescription = "A wide version of the XGA format."
                    + "This display aspect ratio was common in widescreen notebook computers until ca. 2010.";
        }
        else if (x == 1280 && y == 800) {
            displayType = "WXGA";
            displayTypeFullName = "Widescreen Extended Graphics Array";
            displayResolution = "8:5 (16:10)";
            displayDescription = "A wide version of the XGA format."
                    + "This display aspect ratio was common in widescreen notebook computers until ca. 2010.";
        }
        else if (x == 1680 && y == 1050) {
            displayType = "WSXGA+";
            displayTypeFullName = "Widescreen Extended Graphics Array PLUS";
            displayResolution = "8:5 (16:10)";
            displayDescription = "An enhanced version of the WXGA format."
                    + "This display aspect ratio was common in widescreen notebook computers and many 19\" widescreen LCD monitors until ca. 2010.";
        }
        else if (x == 1920 && y == 1080) {
            displayType = "HD 1080";
            displayTypeFullName = "Full High Definition (1080p)";
            displayResolution = "16:9";
            displayDescription = "This display aspect ratio is the native resolution for many 24\" widescreen LCD monitors,"
                    + "and is expected to also become a standard resolution for smaller to medium-size,"
                    + "wide-aspect tablet computers in the near future (as of 2012).";
        }
        else if (x == 1600 && y == 1200) {
            displayType = "UXGA";
            displayTypeFullName = "Ultra Extended Graphics Array";
            displayResolution = "4:3";
            displayDescription = "A high-resolution standard.\n"
                    + "This is the native resolution for many 20\" LCD monitors, and was a recommended mode for some high end 21\" CRTs";
        }
        else if (x == 2048 && y == 1536) {
            displayType = "QXGA";
            displayTypeFullName = "Quad Extended Graphics Array";
            displayResolution = "4:3";
            displayDescription = "This is the highest resolution that generally can be displayed on analog computer monitors (most CRTs),"
                    + "and the highest resolution that most analogue video cards and other display transmission hardware (cables, switch boxes, signal boosters) are rated for (at 60 Hz refresh)."
                    + "24-bit colour requires 9 MB of video memory (and transmission bandwidth) for a single frame."
                    + "Also the native resolution of medium to large latest-generation (2012), standard-aspect tablet computers.";
        }
        else if (x == 2048 && y == 1080) {
            displayType = "DCI 2K";
            displayTypeFullName = "DLP Cinema Technology";
            displayResolution = "17:9";
            displayDescription = "Digital Film Projection standard.";
        }
        else if (x == 1920 && y == 1200) {
            displayType = "WUXGA";
            displayTypeFullName = "Widescreen Ultra Extended Graphics Array";
            displayResolution = "8:5 (16:10)";
            displayDescription = "A wide version of the UXGA format.\n"
                    + "This display aspect ratio was popular on high-end 15\" and 17\" widescreen notebook computers,"
                    + "as well as on many 23–27\" widescreen LCD monitors,until ca. 2010."
                    + "It is also a popular resolution for home cinema projectors, besides 1080p,"
                    + "in order to show non-widescreen material slightly taller than widescreen (and therefore also slightly wider than it might otherwise be),"
                    + "and is the highest resolution supported by single-link DVI at standard colour depth and scan rate (I.E. no less than 24 bpp and 60 Hz non-interlaced).";
        }
        else if (x == 2560 && y == 1600) {
            displayType = "WQXGA";
            displayTypeFullName = "Widescreen Quad Extended Graphics Array";
            displayResolution = "8:5 (16:10)";
            displayDescription = "A version of the XGA format, the native resolution for many 30\" widescreen LCD monitors."
                    + "Also, the highest resolution supported by dual-link DVI at a standard colour depth and non-interlaced refresh rate (I.E. at least 24 bpp and 60 Hz)."
                    + "Used on the MacBook Pro with Retina display (13.3\"). Requires 12 MB of memory/bandwidth for a single frame.";
        }
        else if (x == 2560 && y == 2048) {
            displayType = "QSXGA";
            displayTypeFullName = "Quad Super Extended Graphics Array";
            displayResolution = "5:4";
            displayDescription = "Double the resolution of SXGA in each dimension.";
        }
        else if (x == 3840 && y == 2160) {
            displayType = "4K UHD";
            displayTypeFullName = "Ultra High Definition";
            displayResolution = "5:4";
            displayDescription = "Four times the resolution of 1080p. Requires a dual-link DVI, category 2 (high-speed) HDMI, Displayport or single Thunderbolt link, "
                    + "and a reduced scan rate (up to 30 Hz); a DisplayPort 1.2 connection can support this resolution at 60 Hz, or 30 Hz in stereoscopic 3D.";
        }
        else if (x == 3840 && y == 2160) {
            displayType = "QSXGA";
            displayTypeFullName = "Quad Super Extended Graphics Array";
            displayResolution = "5:4";
            displayDescription = "Double the resolution of SXGA in each dimension.";
        }
        else if (x == 7680 && y == 4320) {
            displayType = "8K UHD";
            displayTypeFullName = "8K Ultra-high-definition (Super Hi-Vision)";
            displayResolution = "16:9";
            displayDescription = "A digital format in testing by NHK in Japan (with a partnership extending to the BBC for test coverage of the 2012 London Olympic Games), "
                    + "intended to provide effectively \"pixel-less\" imagery even on extra-large LCD or projection screens.";
        }
        else {
            displayType = "Unknown";
            displayResolution = "Unknown";
            displayDescription = "No further information.";
            source = ""; // Leave this empty
        }
        
        /* 
        // Counts the aspect ratio
        double ratio = 1.778;
        double bestDelta = Double.MAX_VALUE;
        double calcX = x;
        double calcY = y;

        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                double newDelta = Math.abs((double) i / (double) j - ratio);
                if (newDelta < bestDelta) {
                    bestDelta = newDelta;
                    calcX = i;
                    calcY = j;
                }
            }
        }*/
        
        // Set the variables to the textarea
        texDescription.setLineWrap(true);
        texDescription.setWrapStyleWord(true);
        texDescription.append("Display: " + displayType);
        if (displayType != "Unknown") texDescription.append(" - " + displayTypeFullName); // Don't add the full name if the display is unknown
        texDescription.append("\n");
        texDescription.append("Aspect Ratio: " + displayResolution);
        //texDescription.append("Aspect Ratio: " + df.format(calcX) + ":" + df.format(calcY));
        texDescription.append("\n");
        texDescription.append("Width: " + df.format(x));
        texDescription.append("\n");
        texDescription.append("Height: " + df.format(y));
        texDescription.append("\n");
        texDescription.append("Pixels: " + df3Int.format((x * y)) + " px.");
        texDescription.append("\n");
        texDescription.append("Info:\n" + displayDescription);
        texDescription.append("\n");
        texDescription.append(source);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labWidth = new javax.swing.JLabel();
        labHeight = new javax.swing.JLabel();
        scrollPaneDescription = new javax.swing.JScrollPane();
        texDescription = new javax.swing.JTextArea();
        btnDetect = new javax.swing.JButton();
        btnCalculateFields = new javax.swing.JButton();
        btnResetFields = new javax.swing.JButton();
        texWidth = new javax.swing.JFormattedTextField();
        texHeight = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Display Detector");
        setResizable(false);

        labWidth.setText("Width:");

        labHeight.setText("Height:");

        texDescription.setEditable(false);
        texDescription.setColumns(20);
        texDescription.setRows(5);
        texDescription.setFocusable(false);
        scrollPaneDescription.setViewportView(texDescription);

        btnDetect.setText("Detect");
        btnDetect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetect.setFocusable(false);
        btnDetect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetectMouseClicked(evt);
            }
        });

        btnCalculateFields.setText("Calculate fields");
        btnCalculateFields.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalculateFields.setFocusable(false);
        btnCalculateFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCalculateFieldsMouseClicked(evt);
            }
        });

        btnResetFields.setText("Reset fields");
        btnResetFields.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetFields.setFocusable(false);
        btnResetFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetFieldsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labWidth)
                            .addComponent(labHeight))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(texHeight, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(texWidth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCalculateFields, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnResetFields, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDetect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(labWidth)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCalculateFields, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnResetFields, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labHeight))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDetect)
                            .addComponent(texHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addComponent(scrollPaneDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetectMouseClicked

        // Using toolkit to grab the variables
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Set the Dimension parameters into variables
        double width = displaySize.getWidth();
        double height = displaySize.getHeight();
        
        // Display the result
        texWidth.setText(String.valueOf(df.format(width)));
        texHeight.setText(String.valueOf(df.format(height)));
        
        getDisplayStandard(width, height);
        
        /* MULTIMONITOR METHOD
        // Test if each monitor will support my app's window
        // Iterate through each monitor and see what size each is
        GraphicsEnvironment ge      = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[]    gs      = ge.getScreenDevices();
        Dimension           mySize  = new Dimension(myWidth, myHeight);
        Dimension           maxSize = new Dimension(minRequiredWidth, minRequiredHeight);
        for (int i = 0; i < gs.length; i++)
        {
            DisplayMode dm = gs[i].getDisplayMode();
            if (dm.getWidth() > maxSize.getWidth() && dm.getHeight() > maxSize.getHeight())
            {   // Update the max size found on this monitor
                maxSize.setSize(dm.getWidth(), dm.getHeight());
            }

            // Do test if it will work here
        }
        */
        
    }//GEN-LAST:event_btnDetectMouseClicked

    private void btnCalculateFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalculateFieldsMouseClicked
        calculateFields();
    }//GEN-LAST:event_btnCalculateFieldsMouseClicked

    private void btnResetFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetFieldsMouseClicked
        texWidth.setText("");
        texHeight.setText("");
        texDescription.setText("");
    }//GEN-LAST:event_btnResetFieldsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DisplayCheckerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayCheckerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayCheckerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayCheckerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayCheckerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculateFields;
    private javax.swing.JButton btnDetect;
    private javax.swing.JButton btnResetFields;
    private javax.swing.JLabel labHeight;
    private javax.swing.JLabel labWidth;
    private javax.swing.JScrollPane scrollPaneDescription;
    private javax.swing.JTextArea texDescription;
    private javax.swing.JFormattedTextField texHeight;
    private javax.swing.JFormattedTextField texWidth;
    // End of variables declaration//GEN-END:variables
}
