import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Lab12_05 extends JFrame implements KeyListener, ActionListener {
    private int width, height;
    private JButton startBtn, stopBtn,redBtn, greenBtn, blueBtn, clearBtn;
    private int xMin, xMax, yMin, yMax;
    private int x, y, size, xSpeed, ySpeed;
    Timer swTimer;
    private Color color;

    public Lab12_05() {
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
        c.add(redBtn);
        greenBtn = new JButton("Green");
        greenBtn.addActionListener(this);
        c.add(greenBtn);
        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(this);
        c.add(blueBtn);
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(this);

        color = Color.BLACK;

        width = 480;
        height = 320;
        xMin = 1;
        xMax = 480;
        yMin = 30;
        yMax = 320;
        xSpeed = 1; //2
        ySpeed = 1; //2
        x = 240;
        y = 160;
        size = 40;
        swTimer = new Timer(10, this);

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.drawRect(4, 30, 471, 285);
        g.setColor(Color.PINK);
        g.fillOval(x, y, size, size);
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
        else {
            move();
            repaint();
        }
    }

    public void clear(Graphics g) {
        repaint();
        g.setColor(this.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void move() {
        x = x + xSpeed;
        y = y + ySpeed;
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
    }

    public static void main(String[] args) {
        Lab12_05 window = new Lab12_05();
        window.setSize(480, 320);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}