import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Lab12_04 extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
    private int lastx = 0, lasty = 0;
    private JButton redBtn, greenBtn, blueBtn, clearBtn;
    // private Graphics g;
    private JTextField showStatus;
    private Color color;

    public Lab12_04() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
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
        c.add(clearBtn);
        showStatus = new JTextField(30);
        showStatus.setEditable(false);
        c.add(showStatus);
        // g = getGraphics();
        color = Color.BLACK;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public void mousePressed(MouseEvent event) {
        lastx = event.getX();
        lasty = event.getY();
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mouseClicked(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mouseDragged(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        Graphics g = getGraphics();
        g.setColor(color);
        g.drawLine(lastx, lasty, x, y);
        lastx = x;
        lasty = y;
    }

    public void mouseMoved(MouseEvent event) {
        showStatus.setText(event.getX() + ", " + event.getY());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redBtn)
            color = Color.RED;
        else if (e.getSource() == greenBtn)
            color = Color.GREEN;
        else if (e.getSource() == blueBtn)
            color = Color.BLUE;
        else if (e.getSource() == clearBtn) {
            color = Color.BLACK;
            Graphics g = getGraphics();
            clear(g);
        }
    }

    public void clear(Graphics g) {
        repaint();
        g.setColor(this.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public static void main(String[] args) {
        Lab12_04 window = new Lab12_04();
        window.setSize(320, 240);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}