package src;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UserInterface extends JPanel implements MouseListener, MouseMotionListener{
    private static final long serialVersionUID = 1L;
    static int x, y;
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.setBackground(Color.RED);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x-20, y-20, 20, 20);
        graphics.setColor(Color.RED);
        graphics.fillRect(40, 20, 80, 50);
        graphics.drawString("Alex", x, y);
        Image chessPiecesImage;
        chessPiecesImage = new ImageIcon("ChessPieces.png").getImage();
        graphics.drawImage(chessPiecesImage, x, y, x+64, y+64, 0, 0, 64, 64, this);
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override 
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}