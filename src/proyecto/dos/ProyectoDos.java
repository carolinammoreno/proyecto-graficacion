/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.dos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
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
        setBackground(Color.BLACK);
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
           
           //COLORES
           Color RosaBase = new Color(209, 96, 96);
           Color RosaClaro = new Color(255, 171, 171);
           
           g2d.setColor(Color.YELLOW);
          
           //CABELLO (MITAD IZQ parte trasera, detras de rostro y mano izq)
           GeneralPath cabAt = new GeneralPath();
           cabAt.moveTo(592, 24);
           cabAt.quadTo(584, 16, 571, 17);
           cabAt.quadTo(556, 6, 539, 6);
           cabAt.quadTo(527, 6, 510, 11);
           cabAt.quadTo(488, 5, 470, 6);
           cabAt.quadTo(457, 7, 438, 16);
           cabAt.quadTo(418, 28, 408, 39);
           cabAt.quadTo(399, 50, 390, 73);
           cabAt.quadTo(375, 100, 355, 116);
           cabAt.quadTo(341, 125, 340, 137);
           cabAt.quadTo(315, 146, 305, 178);
           cabAt.quadTo(298, 197, 311, 220);
           cabAt.quadTo(315, 235, 302, 248);
           cabAt.quadTo(280, 265, 288, 298);
           cabAt.quadTo(290, 311, 306, 328);
           cabAt.quadTo(300, 352, 317, 386);
           cabAt.curveTo(322, 396, 335, 408, 330, 433);
           cabAt.curveTo(325, 453, 322, 459, 333, 482);
           cabAt.curveTo(342, 494, 365, 517, 360, 534);
           cabAt.curveTo(353, 543, 345, 555, 353, 575);
           cabAt.quadTo(359, 586, 377, 607);
           cabAt.closePath();
           
           //CABELLO (MITAD DER parte trasera, detras de rostro y mano izq)
           
           GeneralPath cabAt2 = new GeneralPath();
           cabAt2.moveTo(592, 24);
           cabAt2.quadTo(622, 31, 638, 42);
           cabAt2.curveTo(662, 52, 680, 102, 674, 140);
           cabAt2.curveTo(677, 156, 684, 179, 697, 195);
           cabAt2.curveTo(707, 207, 707, 233, 694, 260);
           cabAt2.curveTo(691, 269, 699, 284, 712, 298);
           cabAt2.curveTo(728, 308, 742, 329, 736, 356);
           cabAt2.curveTo(730, 366, 722, 377, 728, 393);
           cabAt2.curveTo(735, 400, 750, 432, 732, 457);
           cabAt2.curveTo(723, 470, 717, 482, 724, 498);
           cabAt2.quadTo(731, 508, 724, 533);
           cabAt2.quadTo(547, 613, 377, 607);
           cabAt2.closePath();

           
           Area cabello = new Area(cabAt);
           cabello.add(new Area(cabAt2));
           Color cabBase = new Color(117, 84, 116);
           Color cabSombra = new Color(74, 46, 62);
           GradientPaint cab = new GradientPaint(0,0, cabBase, 0,450, cabSombra);
           g2d.setPaint(cab);
           g2d.fill(cabello); //CABELLO (parte atras)
           g2d.setColor(Color.BLACK);
           g2d.draw(cabello);
           
            //DEDO ATRAS MANO IZQUIERDA
           GeneralPath dedoIzq = new GeneralPath(); 
           dedoIzq.moveTo(324, 296);
           dedoIzq.quadTo(321, 271, 317, 261);
           dedoIzq.quadTo(315, 246, 326, 235);
           dedoIzq.curveTo(334, 214, 356, 189, 371, 167);
           dedoIzq.quadTo(380, 159, 395, 149);
           dedoIzq.curveTo(398, 152, 397, 159, 386, 170);
           dedoIzq.quadTo(358, 216, 363, 224);
           dedoIzq.closePath();
           //g2d.draw(dedoIzq);
           
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
            
          g2d.setColor(new Color(80, 12, 21));
          g2d.draw(r); //Dibujo del contorno
          GradientPaint Rostro = new GradientPaint(0,0, RosaClaro, 0,280, RosaBase); //Degradado de la luz del pelito
          g2d.setPaint(Rostro);
          g2d.fill(r);
          g2d.setColor(Color.BLACK);
          g2d.draw(r);
          
          //hoyito nariz
          GeneralPath narO = new GeneralPath();
          narO.moveTo(436, 233);
          narO.quadTo(440, 234, 446, 244);
          g2d.setColor(Color.BLACK);
          g2d.draw(narO);
           
          
          ///Parpados //
          GeneralPath ParI = new GeneralPath();
          ParI.moveTo(446, 185);
          ParI.curveTo(440, 168, 415, 137, 393, 161);
          ParI.curveTo(409, 147, 428, 157, 442, 176);
          ParI.closePath();
          g2d.setColor(new Color(78, 25, 35));
          g2d.fill(ParI);
          
          GeneralPath ParD = new GeneralPath();
          ParD.moveTo(479, 187);
          ParD.curveTo(520, 182, 542, 192, 561, 207);
          ParD.curveTo(547, 193, 526, 182, 503, 183);
          ParD.closePath();
          g2d.setColor(new Color(78, 25, 35));
          g2d.fill(ParD);
          
           //NARIZ
           
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
           g2d.setColor(new Color(132, 59, 86,150));
           g2d.fill(nar);
           g2d.setColor(new Color (107, 60, 74));
           //g2d.setColor(Color.YELLOW);
           //g2d.draw(nar);
           
           
           
   /////// //OJO IZQUIERZOOOO //////////
           //g2d.setColor(new Color(121, 98, 124));
           GeneralPath ojoI = new GeneralPath();
           ojoI.moveTo(439, 197);
           ojoI.quadTo(425, 174, 390, 169);
           ojoI.quadTo(388, 192, 421, 194);
           ojoI.closePath(); 
           Color ojoSombra = new Color(74, 62, 71);
           g2d.setColor(ojoSombra);
           g2d.fill(ojoI);
           
           GeneralPath detOI = new GeneralPath();
           detOI.moveTo(431, 192);
           detOI.curveTo(416, 180, 405, 175, 394, 177);
           detOI.curveTo(399, 190, 409, 191, 421, 193);
           detOI.closePath();
           
           g2d.setColor(new Color(121, 98, 124, 80));
           g2d.fill(detOI);
           
           Shape pup2 = new Ellipse2D.Double(413, 176,7,7);
           g2d.setColor(new Color(139, 112, 138));
           g2d.draw(pup2);
           
          GeneralPath li1 = new GeneralPath();
          li1.moveTo(411, 175);
          li1.quadTo(407, 181, 414, 185);
          g2d.setColor(new Color(139, 112, 138));
          g2d.draw(li1);
          GeneralPath li2 = new GeneralPath();
          li2.moveTo(413, 187);
          li2.quadTo(421, 188, 422, 179);
          g2d.setColor(new Color(139, 112, 138));
          g2d.draw(li2);
          GeneralPath li3 = new GeneralPath();
          li3.moveTo(406, 177);
          li3.quadTo(405, 183, 410, 187);
          g2d.setColor(new Color(139, 112, 138));
          g2d.draw(li3);
          GeneralPath li4 = new GeneralPath();
          li4.moveTo(414, 190);
          li4.quadTo(428, 188, 425, 181);
          g2d.setColor(new Color(139, 112, 138));
          g2d.draw(li4); 
          
          Shape br3 = new Ellipse2D.Double(422, 184, 5, 5);
           g2d.setColor(new Color(194, 175, 210));
           g2d.fill(br3);
          Shape br4 = new Ellipse2D.Double(427, 188, 3, 3);
           g2d.setColor(new Color(194, 175, 210));
           g2d.fill(br4); 
           
           ///Pestanias INFERIOREs ojo IZQUIERDO
           GeneralPath pestInfOI = new GeneralPath();
           pestInfOI.moveTo(426, 197);
           pestInfOI.curveTo(412, 191, 391, 196, 390, 172);
           pestInfOI.lineTo(387, 176);
           pestInfOI.lineTo(384, 171);
           pestInfOI.curveTo(385, 183, 388, 193, 415, 197);
           pestInfOI.lineTo(412, 195);
           pestInfOI.closePath();
                
                
           g2d.setColor(new Color(57, 34, 39));
           g2d.fill(pestInfOI);
           g2d.setColor(new Color(64, 39, 44));
           g2d.draw(pestInfOI);
           ///Pestanias Superioes ojo IZQUIERDO
           GeneralPath pestaniasOIz = new GeneralPath();
           pestaniasOIz.moveTo(439, 197);
           pestaniasOIz.quadTo(428, 172, 416, 168);
           pestaniasOIz.quadTo(409, 169, 399, 167);
           pestaniasOIz.quadTo(404, 167, 411, 163);
           pestaniasOIz.quadTo(399, 167, 391, 165);
           pestaniasOIz.quadTo(395, 166, 403, 161);
           pestaniasOIz.quadTo(396, 162, 391, 160);
           pestaniasOIz.quadTo(379, 166, 361, 162);
           pestaniasOIz.quadTo(369, 169, 384, 169);
           pestaniasOIz.quadTo(382, 173, 376, 171);
           pestaniasOIz.curveTo(384, 176, 396, 172, 416, 176);
           pestaniasOIz.quadTo(420, 177, 425, 181);
           pestaniasOIz.quadTo(422, 183, 417, 183);
           pestaniasOIz.quadTo(424, 184, 428, 183);
           pestaniasOIz.closePath();
      
           g2d.setColor(new Color(57, 34, 39));
           g2d.fill(pestaniasOIz);
           g2d.setColor(new Color(64, 39, 44));
           g2d.draw(pestaniasOIz);
                          
           
           //OJO DER//
           //g2d.setColor(new Color(121, 98, 124));;
           GeneralPath ojoD = new GeneralPath();
           ojoD.moveTo(486, 204);
           ojoD.quadTo(520, 190, 560, 237);
           ojoD.quadTo(516, 240, 502, 219);
           ojoD.closePath();
           
           g2d.setColor(new Color(74, 62, 71));
           g2d.fill(ojoD);
           
           ///detalles ojo///
           GeneralPath detO1 = new GeneralPath();
           detO1.moveTo(499, 207);
           detO1.curveTo(513, 207, 531, 215, 542, 233);
           detO1.curveTo(533, 233, 518, 232, 499, 211);
           detO1.closePath();
           g2d.setColor(new Color(121, 98, 124, 95));
           g2d.fill(detO1);
           
           GeneralPath l1 = new GeneralPath();
           l1.moveTo(514, 208);
           l1.quadTo(510, 217, 520, 222);
           g2d.setColor(new Color(139, 112, 138));
           g2d.draw(l1);
           
           GeneralPath l2 = new GeneralPath();
           l2.moveTo(518, 208);
           l2.quadTo(515, 214, 521, 218);
           g2d.setColor(new Color(139, 112, 138));
           g2d.draw(l2);
           GeneralPath l3 = new GeneralPath();
           l3.moveTo(534, 218);
           l3.quadTo(529, 224, 522, 221);
           g2d.setColor(new Color(139, 112, 138));
           g2d.draw(l3);
           GeneralPath l4 = new GeneralPath();
           l4.moveTo(537, 221);
           l4.quadTo(529, 230, 518, 224);
           g2d.setColor(new Color(139, 112, 138));
           g2d.draw(l4);
           GeneralPath l5 = new GeneralPath();
           l5.moveTo(531, 215);
           l5.quadTo(530, 219, 524, 218);
           g2d.setColor(new Color(139, 112, 138));
           g2d.draw(l5);
           
           Shape pup1 = new Ellipse2D.Double(522,210,6,6);
           g2d.setColor(new Color(139, 112, 138));
           g2d.draw(pup1);
           
           Shape br1 = new Ellipse2D.Double(532, 220, 5, 5);
           g2d.setColor(new Color(194, 175, 210));
           g2d.fill(br1);
           Shape br2 = new Ellipse2D.Double(538, 225, 3, 3);
           g2d.setColor(new Color(194, 175, 210));
           g2d.fill(br2);
           
           //Pestanias Superiores ojo DER
           GeneralPath PstD = new GeneralPath();
           PstD.moveTo(485, 195);
           PstD.quadTo(494, 195, 503, 197);
           PstD.quadTo(499, 192, 497, 185);
           PstD.quadTo(503, 193, 511, 197);
           PstD.quadTo(528, 200, 544, 213);
           PstD.quadTo(545, 218, 549, 223);
           PstD.quadTo(546, 217, 549, 213);
           PstD.quadTo(560, 227, 579, 232);
           PstD.quadTo(571, 235, 562, 233);
           PstD.quadTo(571, 242, 583, 248);
           PstD.curveTo(568, 251, 559, 247, 550, 235);
           PstD.quadTo(539, 220, 532, 214);
           PstD.quadTo(521, 206, 512, 205);
           PstD.quadTo(507, 208, 501, 206);
           PstD.quadTo(507, 204, 507, 203);
           PstD.quadTo(499, 201, 492, 202);
           PstD.lineTo(500, 200);
           PstD.closePath();
                    
                    
           g2d.setColor(new Color(57, 34, 39));
           g2d.fill(PstD);
           g2d.setColor(new Color(64, 39, 44));
           g2d.draw(PstD);
                    
           //Pestanias de abajo ojo DER
           GeneralPath PID = new GeneralPath();
           PID.moveTo(492, 207);
           PID.curveTo(506, 225, 523, 242, 550, 235);
           PID.quadTo(557, 242, 561, 258);
           PID.quadTo(552, 245, 547, 243);
           PID.quadTo(544, 244, 547, 250);
           PID.quadTo(544, 249, 543, 244);
           PID.quadTo(540, 250, 544, 260);
           PID.quadTo(535, 251, 535, 242);
           PID.quadTo(530, 237, 529, 243);
           PID.quadTo(527, 246, 528, 251);
           PID.quadTo(525, 240, 521, 247);
           PID.quadTo(517, 230, 504, 234);
           PID.quadTo(505, 228, 500, 223);
           PID.quadTo(494, 218, 488, 217);
           PID.quadTo(492, 216, 494, 215);
           PID.quadTo(491, 211, 490, 209);
           PID.lineTo(495, 213);
           PID.closePath();
                    
           g2d.setColor(new Color(57, 34, 39));
           g2d.fill(PID);
           g2d.setColor(new Color(64, 39, 44));
           g2d.draw(PID);
                    
           
           
           
           //BOCA INTERIOR (garganta)
          
           GeneralPath gar = new GeneralPath();
           gar.moveTo(405, 285);
           gar.quadTo(413, 277, 424, 272);
           gar.quadTo(436, 281, 444, 290);
           gar.lineTo(453, 299);
           gar.quadTo(431, 302, 410, 293);
           gar.closePath(); 
           g2d.setColor(new Color(92, 42, 54));
           g2d.fill(gar);
           
           //DIENTES
           GeneralPath dien = new GeneralPath();
           dien.moveTo(416,271);
           dien.quadTo(420, 280, 431, 285);
           dien.lineTo(443, 289);
           dien.lineTo(430, 276);
           dien.closePath();
           //g2d.setColor(new Color(189, 189, 189));
           g2d.setColor(new Color(165, 132, 137));
           g2d.fill(dien);
           
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
           g2d.setColor(new Color(198, 68, 68));
           g2d.fill(lSup);
           
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
           g2d.setColor(new Color(198, 68, 68));        
           g2d.fill(lInf);
           
           //Contorno labios
           GeneralPath cLab = new GeneralPath();
           cLab.moveTo(398, 283);
           cLab.quadTo(404, 287, 411, 286);
           cLab.quadTo(415, 280, 416, 274);
           cLab.curveTo(424, 275, 433, 279, 439, 286);
           cLab.curveTo(443, 291, 447, 296, 455, 299);
           cLab.quadTo(458, 300, 462, 299);
           cLab.quadTo(462, 299, 458, 300);
           cLab.curveTo(436, 299, 412, 295, 411, 285);
           
           g2d.setColor(new Color(50,13,20));
           g2d.draw(cLab);
           
           
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
           mDer.lineTo(604, 262);
           mDer.quadTo(611, 247, 618, 232);
           mDer.quadTo(627, 212, 640, 211);
           mDer.quadTo(651, 214, 640, 236);
           mDer.quadTo(634, 252, 632, 267);
           mDer.quadTo(631, 273, 627, 280);
           mDer.quadTo(623, 286, 618, 302);
           mDer.quadTo(613, 320, 608, 337);
           mDer.quadTo(613, 348, 612, 361);
           mDer.quadTo(606, 377, 594, 403);
           mDer.quadTo(587, 413, 572, 425);
           mDer.quadTo(567, 429, 562, 436);
           mDer.quadTo(546, 450, 528, 471);
           mDer.quadTo(518, 481, 525, 501);
           mDer.quadTo(559, 573, 597, 617);
           mDer.quadTo(613, 632, 638, 665);
           mDer.closePath();
           g2d.draw(mDer);
           
           //MANO IZQ
           GeneralPath mIzq = new GeneralPath();
           mIzq.moveTo(355, 649);
           mIzq.curveTo(351, 607, 360, 574, 372, 543);
           mIzq.curveTo(379, 519, 383, 481, 382, 442);
           mIzq.curveTo(376, 434, 373, 427, 376, 418);
           mIzq.curveTo(371, 406, 361, 392, 329, 334);
           mIzq.curveTo(315, 318, 326, 299, 330, 279);
           mIzq.curveTo(336, 257, 335, 237, 350, 231);
           mIzq.curveTo(390, 214, 404, 209, 419, 209);
           mIzq.quadTo(430, 208, 438, 206);
           mIzq.quadTo(431, 213, 421, 219);
           mIzq.lineTo(420, 223);
           mIzq.quadTo(414, 224, 408, 226);
           mIzq.curveTo(398, 229, 384, 236, 371, 242);
           mIzq.quadTo(367, 247, 363, 249);
           mIzq.quadTo(368, 289, 378, 307);
           mIzq.quadTo(384, 322, 386, 339);
           mIzq.quadTo(386, 362, 422, 369);
           mIzq.quadTo(449, 369, 462, 361);
           mIzq.quadTo(435, 404, 418, 433);
           mIzq.curveTo(411, 445, 405, 475, 466, 647);
           mIzq.closePath();
           g2d.draw(mIzq);
           
    ////// COPETE /////////
           GeneralPath Cop = new GeneralPath();
           Cop.moveTo(556, 36);
           Cop.curveTo(524, 15, 473, 17, 426, 49);
           Cop.quadTo(405, 61, 374, 67);
           Cop.quadTo(383, 73, 400, 69);
           Cop.quadTo(407, 67, 416, 62);
           Cop.curveTo(403, 79, 370, 95, 378, 112);
           Cop.quadTo(380, 125, 397, 132);
           Cop.curveTo(391, 122, 378, 109, 402, 82);
           Cop.curveTo(395, 100, 385, 109, 403, 129);
           Cop.quadTo(396, 121, 404, 104);
           Cop.quadTo(400, 121, 413, 137);
           Cop.quadTo(423, 142, 438, 144);
           Cop.quadTo(433, 120, 443, 97);
           Cop.quadTo(447, 84, 457, 73);
           Cop.curveTo(440, 96, 441, 126, 463, 151);
           Cop.quadTo(455, 139, 459, 122);
           Cop.quadTo(461, 135, 466, 146);
           Cop.quadTo(475, 153, 492, 157);
           Cop.curveTo(498, 165, 509, 171, 528, 176);
           Cop.curveTo(506, 160, 501, 137, 506, 88);
           Cop.curveTo(510, 132, 511, 164, 544, 180);
           Cop.quadTo(549, 186, 578, 196);
           Cop.quadTo(546, 114, 554, 59);
           Cop.closePath();
           GradientPaint copetito = new GradientPaint(0,0, cabBase, 0,150, cabSombra);
           g2d.setPaint(copetito);
           g2d.fill(Cop);
           
        /// TONO CLARO EN COPETE ///
        GeneralPath TonoClaro_cop = new GeneralPath();
        TonoClaro_cop.moveTo(556, 36);
        TonoClaro_cop.curveTo(524, 15, 473, 17, 426, 49);
        TonoClaro_cop.quadTo(405, 61, 374, 67);
        TonoClaro_cop.quadTo(383, 73, 400, 69);
        TonoClaro_cop.curveTo(422, 52, 448, 37, 476, 31);
        TonoClaro_cop.quadTo(502, 28, 487, 36);
        TonoClaro_cop.quadTo(480, 43, 476, 50);
        TonoClaro_cop.curveTo(490, 41, 516, 30, 532, 33);
        TonoClaro_cop.quadTo(547, 35, 536, 37);
        TonoClaro_cop.curveTo(523, 42, 499, 53, 508, 96);
        TonoClaro_cop.curveTo(512, 111, 522, 127, 565, 134);
        TonoClaro_cop.curveTo(522, 127, 520, 111, 516, 107);
        TonoClaro_cop.curveTo(505, 82, 517, 55, 545, 41);
        TonoClaro_cop.curveTo(530, 51, 525, 60, 523, 80);
        TonoClaro_cop.quadTo(527, 67, 545, 52);
        TonoClaro_cop.quadTo(559, 40, 565, 58);
        TonoClaro_cop.quadTo(572, 43, 595, 53);
        TonoClaro_cop.curveTo(608, 57, 623, 78, 628, 100);
        TonoClaro_cop.curveTo(620, 73, 607, 56, 592, 44);
        TonoClaro_cop.quadTo(578, 36, 559, 38);
        TonoClaro_cop.closePath();
            GradientPaint LuzCabello_Rosa = new GradientPaint(0,0, RosaClaro, 0,100, RosaBase); //Degradado de la luz del pelito
            g2d.setPaint(LuzCabello_Rosa);
            g2d.fill(TonoClaro_cop);
           
            
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
