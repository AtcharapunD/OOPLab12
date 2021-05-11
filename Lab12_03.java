import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab12_03 extends JFrame implements ActionListener, MouseListener {
    int x1, y1, x2, y2;
    JButton btnLine, btnRect, btnCircle, btnClear;
    JTextField text1, text2;
    Color oldColor1, oldColor2;
    char typeShape = 'L';

    public Lab12_03() {
        super("");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        btnLine = new JButton("Line");
        btnLine.addActionListener(this);
        c.add(btnLine);
        btnRect = new JButton("Rectangle");
        btnRect.addActionListener(this);
        c.add(btnRect);
        btnCircle = new JButton("Circle");
        btnCircle.addActionListener(this);
        c.add(btnCircle);
        btnClear = new JButton("Clear");
        btnClear.addActionListener(this);
        c.add(btnClear);
        text1 = new JTextField(12);
        text1.setEditable(false);
        c.add(text1);
        text2 = new JTextField(12);
        text2.setEditable(false);
        c.add(text2);
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
        switch (typeShape) {
        case 'L':
            g.drawLine(x1, y1, x2, y2);
            break;
        case 'R':
            g.drawRect(x1, y1, x2 - x1, y2 - y1);
            break;
        case 'C':
            g.drawOval(x1, y1, x2 - x1, y2 - y1);
            break;
        }
    }

    public void mousePressed(MouseEvent event) {
        if (event.getButton() == 1) { // Mouse Left
            x1 = event.getX();
            y1 = event.getY();
            text1.setText("(X1 = " + x1 + ",Y1 = " + y1 + ")");
        } else if (event.getButton() == 3) { // Mouse Right
            x2 = event.getX();
            y2 = event.getY();
            text2.setText(" (X2 = " + x2 + ",Y2 = " + y2 + ")");
        }
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mouseClicked(MouseEvent event) {
        repaint();
    }

    public void mouseEntered(MouseEvent event) {
        repaint();
    }

    public void mouseExited(MouseEvent event) {
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLine)
            typeShape = 'L';
        else if (e.getSource() == btnRect)
            typeShape = 'R';
        else if (e.getSource() == btnCircle)
            typeShape = 'C';
        else if (e.getSource() == btnClear) {
            x1 = y1 = x2 = y2 = 0;
            text1.setText("");
            text2.setText("");
        }
        repaint();
    }

    public static void main(String[] args) {
        Lab12_03 window = new Lab12_03();
        window.setSize(320, 240);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}