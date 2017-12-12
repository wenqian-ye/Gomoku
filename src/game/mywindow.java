package game;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class mypanel extends Panel implements MouseListener
{
    int chess[][] = new int[11][11];
    boolean Is_Black_True;
    mypanel()
    {
        Is_Black_True = true;
        for(int i = 0;i < 11;i++)
        {
            for(int j = 0;j < 11;j++)
            {
                chess[i][j] = 0;
            }
        }
        addMouseListener(this);
        setBackground(Color.ORANGE);
        setBounds(0, 0, 360, 360);
        setVisible(true);
    }
    public void mousePressed(MouseEvent e)
    {
        int x = e.getX();
 int y = e.getY();

 if(x < 25 || x > 330 + 25 ||y < 25 || y > 330+25)
        {
  return;
        }
 if(chess[x/30-1][y/30-1] != 0)
        {
  return;
        }
        if(Is_Black_True == true)
        {
            chess[x/30-1][y/30-1] = 1;
            Is_Black_True = false;
            repaint();
            Justisewiner();
            return;
        }
        if(Is_Black_True == false)
        {
            chess[x/30-1][y/30-1] = 2;
            Is_Black_True = true;
            repaint();
            Justisewiner();
            return;
        }
    }
    void Drawline(Graphics g)
    {
 for(int i = 30;i <= 330;i += 30)
 {
            for(int j = 30;j <= 330; j+= 30)
            {
                g.setColor(Color.BLUE);
                g.drawLine(i, j, i, 330);
            }
 }

 for(int j = 30;j <= 330;j += 30)
 {
            g.setColor(Color.BLUE);
            g.drawLine(30, j, 330, j);
 }
        
    }
    void Drawchess(Graphics g)
    {
        for(int i = 0;i < 11;i++)
 {
            for(int j = 0;j < 11;j++)
            {
                if(chess[i][j] == 1)
                {
                    g.setColor(Color.BLACK);
                    g.fillOval((i + 1) * 30 - 8, (j + 1) * 30 - 8, 16, 16);
                }
                if(chess[i][j] == 2)
                {
                    g.setColor(Color.WHITE);
                    g.fillOval((i + 1) * 30 - 8, (j + 1) * 30 - 8, 16, 16);
                }
            }
 }
    }
    void Justisewiner()
    {
        int black_count = 0;
 int white_count = 0;
        int i = 0;
        
 for(i = 0;i < 11;i++)
 {
            for(int j = 0;j < 11;j++)
            {
                if(chess[i][j] == 1)
                {
                    black_count++;
                    if(black_count == 5)
                    {
                        JOptionPane.showMessageDialog(this, "Blcak Win! Congratulation!");
                        Clear_Chess();
                        return;
                    }
                }
                else
                {
                    black_count = 0;
                }
                if(chess[i][j] == 2)
                {
                    white_count++;
                    if(white_count == 5)
                    {
                        JOptionPane.showMessageDialog(this, "White Win! Congratulation!");
                        Clear_Chess();
                        return;
                    }
                }
                else
                {
                    white_count = 0;
                }
            }
 }
 
 for(i = 0;i < 11;i++)
 {
            for(int j = 0;j < 11;j++)
            {
                if(chess[j][i] == 1)
                {
                    black_count++;
                    if(black_count == 5)
                    {
                        JOptionPane.showMessageDialog(this, "Blcak Win! Congratulation!");
                        Clear_Chess();
                        return;
                    }
                }
                else
                {
                    black_count = 0;
                }
                if(chess[j][i] == 2)
                {
                    white_count++;
                    if(white_count == 5)
                    {
                        JOptionPane.showMessageDialog(this, "White Win! Congratulation!");
                        Clear_Chess();
                        return;
                    }
                }
                else
                {
                    white_count = 0;
                }
            }
 }

for(i = 0;i < 7;i++)
 {
            for(int j = 0;j < 7;j++)
            {
                for(int k = 0;k < 5;k++)
                {
                    if(chess[i + k][j + k] == 1)
                    {
                        black_count++;
                        if(black_count == 5)
                        {
                            JOptionPane.showMessageDialog(this, "Blcak Win! Congratulation!");
                            Clear_Chess();
                            return;
                        }
                    }
                    else
                    {
                        black_count = 0;
                    }
                    if(chess[i + k][j + k] == 2)
                    {
                        white_count++;
                        if(white_count == 5)
                        {
                            JOptionPane.showMessageDialog(this, "White Win! Congratulation!");
                            Clear_Chess();
                            return;
                        }
                    }
                    else
                    {
                        white_count = 0;
                    }
                }
            }
 }
 
 for(i = 4;i < 11;i++)
 {
            for(int j = 6;j >= 0;j--)
            {
                for(int k = 0;k < 5;k++)
                {
                    if(chess[i - k][j + k] == 1)
                    {
                        black_count++;
                        if(black_count == 5)
                        {
                            JOptionPane.showMessageDialog(this, "Blcak Win! Congratulation!");
                            Clear_Chess();
                            return;
                        }
                    }
                    else
                    {
                        black_count = 0;
                    }
                    if(chess[i - k][j + k] == 2)
                    {
                        white_count++;
                        if(white_count == 5)
                        {
                            JOptionPane.showMessageDialog(this, "White Win! congratulation!");
                            Clear_Chess();
                            return;
                        }
                    }
                    else
                    {
                        white_count = 0;
                    }
                }
            }
 }
       
    }
    void Clear_Chess()
    {
 for(int i=0;i<11;i++)
 {
  for(int j=0;j<11;j++)
  {
   chess[i][j]=0;
  }
 }
 repaint();
    }
    public void paint(Graphics g)
    {
        Drawline(g);
        Drawchess(g);
    }
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    
}

class myframe extends Frame implements WindowListener
{
    mypanel panel;
    myframe()
    {
        setLayout(null);
        panel = new mypanel();
        add(panel);
        panel.setBounds(0,23, 360, 360);
        setTitle("Gobang for UofI");
        setBounds(200, 200, 360, 383);
        setVisible(true);
        addWindowListener(this);
        
    }
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
    public void windowDeactivated(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
}
public class mywindow
{
    public static void main(String argc [])
    {
        myframe f = new myframe();
    }
}