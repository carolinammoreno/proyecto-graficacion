/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.dos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 Laura Carolina Millan Moreno / 20130415
   /10/2022  Graficación - 
 */
public class ProyectoDos extends JFrame{
    //constuctor
    public ProyectoDos() {
        setTitle("Proyecto - Dibujo - Laura Millan 20130415");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DibujoPanel p = new DibujoPanel();
        getContentPane().add(p);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
    
    }
    

    public static void main(String[] args) {
        new ProyectoDos(); 
    }
    
}

class DibujoPanel extends JPanel implements MouseMotionListener{
    BufferedImage img;
    public DibujoPanel(){
        setPreferredSize(new Dimension(900,800));
           addMouseMotionListener(this);
        URL url = getClass().getClassLoader().getResource("dibujo.jpg");
        
        try {
            img = ImageIO.read(url);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
           g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
           g2d.drawImage(img, 250, 0,500,650, this);
           
           g2d.setColor(Color.YELLOW);
          
           //contorno rostro
          GeneralPath r = new GeneralPath();
           r.moveTo(403, 129);
           r.quadTo(386, 147, 382, 175);
           r.quadTo(380, 181, 370, 195);
           r.quadTo(358, 216, 365, 269);
           r.quadTo(368, 289, 378, 307);
           r.quadTo(384, 322, 386, 339);
           r.quadTo(386, 362, 422, 369);
           r.quadTo(449, 369, 473, 355);
           r.quadTo(570, 324, 610, 228);
           r.quadTo(535, 109, 428, 99);
           r.closePath();
           //g2d.setColor(new Color(226,144,144));
           g2d.draw(r); //Dibujo del contorno
           
           //NARIZ
           //g2d.setColor(new Color(132, 59, 86,150));
           GeneralPath nar = new GeneralPath();
           nar.moveTo(429, 156);
           nar.quadTo(457, 172, 450, 194);
           nar.quadTo(438, 210, 420, 219);
           nar.quadTo(420, 230, 426, 238);
           nar.quadTo(426, 242, 424, 246);
           nar.quadTo(408, 235, 404, 215);
           nar.quadTo(405, 210, 409, 211);
           nar.quadTo(425, 201, 434, 174);
           nar.quadTo(435, 165, 433, 163);
           nar.closePath();
           g2d.draw(nar);
           
           //OJO IZQ
           //g2d.setColor(new Color(121, 98, 124));
           GeneralPath ojoI = new GeneralPath();
           ojoI.moveTo(439, 197);
           ojoI.quadTo(425, 174, 390, 169);
           ojoI.quadTo(388, 192, 421, 194);
           ojoI.closePath(); 
           g2d.draw(ojoI);
           
           //OJO DER
           //g2d.setColor(new Color(121, 98, 124));;
           GeneralPath ojoD = new GeneralPath();
           ojoD.moveTo(486, 204);
           ojoD.quadTo(520, 201, 560, 237);
           ojoD.quadTo(516, 236, 502, 219);
           ojoD.closePath();
           g2d.draw(ojoD);
           
           
           
           //BOCA INTERIOR (garganta)
          
           /*GeneralPath gar = new GeneralPath();
           gar.moveTo(405, 285);
           gar.quadTo(413, 277, 424, 272);
           gar.quadTo(436, 281, 444, 290);
           gar.lineTo(453, 299);
           gar.quadTo(431, 302, 410, 293);
           gar.closePath(); 
           g2d.setColor(new Color(92, 42, 54));
           g2d.fill(gar);*/
           
           //DIENTES
          /* GeneralPath dien = new GeneralPath();
           dien.moveTo(416,271);
           dien.quadTo(420, 280, 431, 285);
           dien.lineTo(443, 289);
           dien.lineTo(430, 276);
           dien.closePath();
           //g2d.setColor(new Color(189, 189, 189));
           g2d.setColor(new Color(165, 132, 137));
           g2d.fill(dien);*/
           
           //LABIO SUP
           GeneralPath lSup = new GeneralPath();
           lSup.moveTo(401,285);
           lSup.quadTo(407, 287, 412, 286);
           lSup.quadTo(417, 279, 417, 274);
           lSup.quadTo(425, 275, 433, 280);
           lSup.quadTo(440, 286, 446, 294);
           lSup.quadTo(450, 298, 456, 301);
           lSup.quadTo(452, 296, 448, 289);
           lSup.quadTo(441, 275, 433, 261);
           lSup.quadTo(430, 261, 426, 263);
           lSup.lineTo(419, 256);
           lSup.quadTo(411, 260, 408, 273);
           lSup.closePath();
           //g2d.setColor(new Color(198, 68, 68));
           g2d.draw(lSup);
           
           //LABIO INF
           GeneralPath lInf = new GeneralPath();
           lInf.moveTo(401,285);
           lInf.quadTo(407, 287, 412, 286);
           lInf.quadTo(410, 294, 428, 298);
           lInf.quadTo(439, 301, 450, 300);
           lInf.lineTo(457, 304);
           lInf.quadTo(450, 307, 444, 314);
           lInf.quadTo(438, 318, 431, 318);
           lInf.quadTo(423, 317, 417, 313);
           lInf.quadTo(413, 310, 408, 309);
           lInf.quadTo(401, 308, 400, 303);
           lInf.quadTo(400, 298, 403, 292);
           lInf.closePath();
           //g2d.setColor(new Color(198, 68, 68));        
           g2d.draw(lInf);
           
           //MANO DERECHA
           GeneralPath mDer = new GeneralPath();
           mDer.moveTo(467, 651);
           mDer.lineTo(415, 483);
           mDer.quadTo(408, 443, 427, 417);
           mDer.quadTo(456, 374, 473, 343);
           mDer.quadTo(482, 316, 479, 297);
           mDer.quadTo(473, 280, 468, 265);
           mDer.quadTo(463, 256, 462, 242);
           mDer.quadTo(460, 225, 470, 218);
           mDer.quadTo(475, 218, 481, 231);
           mDer.quadTo(484, 241, 489, 249);
           mDer.quadTo(490, 254, 492, 259);
           mDer.quadTo(495, 263, 498, 269);
           mDer.quadTo(499, 273, 501, 279);
           mDer.quadTo(505, 293, 511, 304);
           mDer.quadTo(521, 305, 530, 299);
           mDer.quadTo(538, 288, 544, 275);
           mDer.quadTo(548, 260, 553, 235);
           mDer.quadTo(554, 219, 554, 201);
           mDer.quadTo(555, 189, 564, 178);
           mDer.quadTo(571, 175, 576, 179);
           mDer.quadTo(577, 183, 578, 194);
           mDer.curveTo(578, 200, 580, 206, 579, 229);
           mDer.lineTo(580, 239);
           mDer.quadTo(584, 218, 592, 197);
           mDer.quadTo(600, 171, 610, 167);
           mDer.quadTo(618, 168, 620, 178);
           mDer.quadTo(618, 188, 615, 203);
           mDer.quadTo(612, 211, 613, 221);
           mDer.quadTo(612, 229, 610, 237);
           mDer.lineTo(607, 249);
           mDer.lineTo(619, 233);
           //mDer.quadTo(627, 218, 638, 212);
           //mDer.quadTo(644, 211, 644, 219);
          // mDer.quadTo(641, 234, 628, 266);
           
           
           
           //mDer.curveTo(580, 243, 579, 257, 572, 288);
           //mDer.quadTo(566, 304, 565, 330);
           
           g2d.draw(mDer);
    }
    
    
    
    
    
    
    @Override
    public void mouseDragged(MouseEvent ev) {
    }

    @Override
    public void mouseMoved(MouseEvent ev) {
        Graphics g = getGraphics();
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.white);
            g2.fill(new Rectangle2D.Double(10,550,90,32));
            g2.setColor(Color.black);
            g2.drawString("X: "+ev.getX()+"      Y: "+ev.getY(),10,565);
    }
    
    
}
