import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener {
    JLabel numero = new JLabel("Inserisci Numero: ");
    JTextArea n = new JTextArea();
    JButton aggiungi = new JButton("AGGIUNGI");
    JLabel numordinati = new JLabel("Numeri Ordinati: ");
    JTextArea ordina = new JTextArea();
    JButton visualizza = new JButton("VISUALIZZA");
    ArrayList<Integer> a = new ArrayList<Integer>();

    public MyFrame() {
        super("ArrayList GUI");
        Container c = this.getContentPane();
        c.setLayout(null);

        c.add(numero);
        numero.setBounds(15, 17, 170, 20);
        c.add(n);
        n.setBounds(135, 17, 170, 20);

        c.add(aggiungi);
        aggiungi.setBounds(315, 15, 150, 25);
        aggiungi.addActionListener(e -> aggiungi());

        c.add(numordinati);
        numordinati.setBounds(15, 70, 170, 20);

        c.add(ordina);
        ordina.setBounds(135, 70, 170, 20);

        c.add(visualizza);
        visualizza.setBounds(315, 68, 150, 25);
        visualizza.addActionListener(e -> visualizza());

        setSize(500, 200);
        setVisible(true);
        setResizable(false);
    }

    public void aggiungi() {
        int numero = Integer.parseInt(n.getText());
        a.add(numero);
        n.setText("");
    }

    public void visualizza() {
        int m = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size() - 1; j++) {
                if (a.get(j) > a.get(j + 1)) {
                    m = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, m);
                }
            }
        }
        ordina.setText("" + a);
        ordina.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aggiungi) {
            aggiungi();
        }
        if (e.getSource() == visualizza) {
            visualizza();
        }
    }
}

