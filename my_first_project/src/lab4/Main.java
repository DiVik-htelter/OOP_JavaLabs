import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;
// лаб 4 вар 13
// Промоделировать аналоговые часы (со стрелками) 
// с кнопками для увеличения/уменьшения времени на час/минуту. 

public class Main {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Вращение треугольника вокруг своего центра тяжести");
        fr.setPreferredSize(new Dimension(500, 500));
        final JPanel pan = new JPanel();

        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        int a = 5; // ускорение скорости
        final AtomicInteger speed = new AtomicInteger(a);

        Timer tm = new Timer(speed.get(), new ActionListener() {
            int sec = 0;
            int min = 0;
            int h = 0;

            int x0 = 100, y0 = 100; // нулевые координаты центра окружности
            double x2 = 100;
            double y2 = 50;

            @Override // переопределение метода
            public void actionPerformed(ActionEvent arg0) {
                if (sec == 60) {
                    min++;
                    sec = 0;
                } else if (min == 60) {
                    h++;
                    min = 0;
                }
                Graphics2D gr = (Graphics2D) pan.getRootPane().getGraphics();
                pan.update(gr);

                GeneralPath el = new GeneralPath();
                el.append(new Ellipse2D.Double(50, 50, 100, 100), true);

// вычисление положения точки на окружности для 3 стрелок часов
                x2 = (Math.cos(sec * 3.14f / 30 - 3.14f / 2) * 100 + x0);
                y2 = (Math.sin(sec * 3.14f / 30 - 3.14f / 2) * 100 + y0);
                gr.drawLine(100, 100, (int) x2, (int) y2);
                x2 = (Math.cos(min * 3.14f / 30 - 3.14f / 2) * 100 + x0);
                y2 = (Math.sin(min * 3.14f / 30 - 3.14f / 2) * 100 + y0);
                gr.drawLine(100, 100, (int) x2, (int) y2);
                x2 = (Math.cos((h * 30 + min / 2) * 3.14f / 180 - 3.14f / 2) * 80 + x0);
                y2 = (Math.sin((h * 30 + min / 2) * 3.14f / 180 - 3.14f / 2) * 80 + y0);
                gr.drawLine(x0, y0, (int) x2, (int) y2);
                gr.draw(el);
                sec++;
            }
        });

        JPanel buttonPanel = new JPanel();
// кнопки увеличения скорости
        JButton incrementButton = new JButton("-");
        incrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                speed.getAndAdd(a);
                tm.setDelay(speed.get());
            }
        });
        buttonPanel.add(incrementButton);

        JButton decrementButton = new JButton("+");
        decrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (speed.get() > a) {
                    speed.getAndAdd(-a);
                    tm.setDelay(speed.get());
                }
            }
        });
        buttonPanel.add(decrementButton);
        fr.add(buttonPanel, BorderLayout.SOUTH);

        tm.start();
    }
}