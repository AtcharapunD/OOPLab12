
// File Name : Lab12_05.java
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.xml.crypto.dsig.spec.XPathFilter2ParameterSpec;

public class Lab12_05_1 extends JFrame implements KeyListener, ActionListener {
    private int width, height;
    private JButton startBtn, stopBtn;
    private JButton redBtn, greenBtn, blueBtn, blackBtn, pinkBtn, yellowBtn;
    private int xMin, xMax, yMin, yMax;
    private int x2Min, x2Max, y2Min, y2Max;
    private int x, y, size, xSpeed, ySpeed;
    private int x2, y2, xSpeed2, ySpeed2;
    Timer swTimer;
    private Color color;

    public Lab12_05_1() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        startBtn = new JButton("Play");
        startBtn.addActionListener(this);
        startBtn.addKeyListener(this);
        c.add(startBtn);

        stopBtn = new JButton("Stop");
        stopBtn.addActionListener(this);
        stopBtn.addKeyListener(this);
        c.add(stopBtn);

        redBtn = new JButton("Red");
        redBtn.addActionListener(this);
        redBtn.addKeyListener(this);
        c.add(redBtn);

        greenBtn = new JButton("Green");
        greenBtn.addActionListener(this);
        greenBtn.addKeyListener(this);
        c.add(greenBtn);

        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(this);
        blueBtn.addKeyListener(this);
        c.add(blueBtn);

        blackBtn = new JButton("Black");
        blackBtn.addActionListener(this);
        blackBtn.addKeyListener(this);
        c.add(blackBtn);

        pinkBtn = new JButton("Pink");
        pinkBtn.addActionListener(this);
        pinkBtn.addKeyListener(this);
        c.add(pinkBtn);

        yellowBtn = new JButton("Yellow");
        yellowBtn.addActionListener(this);
        yellowBtn.addKeyListener(this);
        c.add(yellowBtn);

        width = 480;
        height = 320;

        xMin = 1;
        xMax = 480;
        yMin = 30;
        yMax = 320;

        x2Min = 1;
        x2Max = 480;
        y2Min = 30;
        y2Max = 320;

        xSpeed = 3;
        ySpeed = 3;

        xSpeed2 = 1;
        ySpeed2 = 1;

        x = 240;
        y = 160;

        x2 = 200;
        y2 = 150;

        size = 40;
        swTimer = new Timer(10, this);
        color = Color.BLUE;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(4, 30, 471, 285);
        g.setColor(color);
        g.fillOval(x, y, size, size);
        g.setColor(color);
        g.fillRect(x2, y2, size, size);
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyChar() == 'p')
            swTimer.start();
        else if (event.getKeyChar() == 's')
            swTimer.stop();
    }

    public void keyReleased(KeyEvent event) {
    }

    public void keyTyped(KeyEvent event) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn)
            swTimer.start();
        else if (e.getSource() == stopBtn)
            swTimer.stop();
        else if (e.getSource() == redBtn)
            color = Color.RED;
        else if (e.getSource() == greenBtn)
            color = Color.GREEN;
        else if (e.getSource() == blueBtn)
            color = Color.BLUE;
        else if (e.getSource() == blackBtn)
            color = Color.BLACK;
        else if (e.getSource() == pinkBtn)
            color = Color.PINK;
        else if (e.getSource() == yellowBtn)
            color = Color.YELLOW;
        else {
            move();
            repaint();
        }
    }

    public void move() {
        x = x + xSpeed;
        y = y + ySpeed;

        x2 = x2 + xSpeed2;
        y2 = y2 + ySpeed2;

        if (x < xMin) {
            x = xMin;
            xSpeed = -xSpeed;
        } else if (x + size > xMax) {
            x = xMax - size;
            xSpeed = -xSpeed;
        }
        if (y < yMin) {
            y = yMin;
            ySpeed = -ySpeed;
        } else if (y + size > yMax) {
            y = yMax - size;
            ySpeed = -ySpeed;
        }

        if (x2 < x2Min) {
            x2 = x2Min;
            xSpeed2 = -xSpeed2;
        } else if (x2 + size > x2Max) {
            x2 = x2Max - size;
            xSpeed2 = -xSpeed2;
        }
        if (y2 < y2Min) {
            y2 = y2Min;
            ySpeed2 = -ySpeed2;
        } else if (y2 + size > y2Max) {
            y2 = y2Max - size;
            ySpeed2 = -ySpeed2;
        }
    }

    public static void main(String[] args) {
        Lab12_05_1 window = new Lab12_05_1();
        window.setSize(480, 320);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}