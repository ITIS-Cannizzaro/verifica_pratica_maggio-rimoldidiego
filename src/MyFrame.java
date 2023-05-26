import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener {

    //Primo Frame
    JLabel numero = new JLabel("Inserisci Numero: ");
    JTextArea n = new JTextArea();
    JButton aggiungi = new JButton("Aggiungi");
    JLabel numordinati = new JLabel("Numeri Ordinati: ");
    JTextArea ordina = new JTextArea();
    JButton visualizza = new JButton("Visualizza");
    JButton r = new JButton("Rimuovi");
    ArrayList<Integer> a = new ArrayList<Integer>();

    //Secondo Frame
    JFrame rimuovi = new JFrame("Rimuovi Numero");
    JLabel nr = new JLabel("Inserisci Numero: ");
    JLabel agg = new JLabel("ArrayList Aggiornato: ");
    JTextArea nrimuovi = new JTextArea();
    JTextArea risultato = new JTextArea();
    JButton aggiorna = new JButton("Aggiorna");

    public MyFrame() {

        //Primo Frame: aggiungi e ordina

        super("ArrayList GUI");
        Container c = this.getContentPane();
        c.setLayout(null);

        c.add(numero);
        numero.setBounds(25, 17, 170, 20);

        c.add(n);
        n.setBounds(15, 47, 170, 20);

        c.add(aggiungi);
        aggiungi.setBounds(25, 77, 150, 25);
        aggiungi.addActionListener(e -> aggiungi());

        c.add(numordinati);
        numordinati.setBounds(260, 17, 170, 20);

        c.add(ordina);
        ordina.setBounds(250, 47, 170, 20);

        c.add(visualizza);
        visualizza.setBounds(260, 77, 150, 25);
        visualizza.addActionListener(e -> visualizza());

        c.add(r);
        r.setBounds(145,110,150,25);
        r.addActionListener(e -> cancella());

        setSize(450, 200);
        setVisible(true);
        setResizable(false);

        //Secondo Frame: rimuovi

        rimuovi.setSize(400, 150);
        rimuovi.setResizable(false);
        rimuovi.setLayout(new FlowLayout());

        rimuovi.add(nr);
        nr.setPreferredSize(new Dimension(150, 20));

        rimuovi.add(nrimuovi);
        nrimuovi.setPreferredSize(new Dimension(150, 20));

        rimuovi.add(aggiorna);
        aggiorna.setPreferredSize(new Dimension(350, 20));
        aggiorna.addActionListener(e ->aggiorna());

        rimuovi.add(agg);
        agg.setPreferredSize(new Dimension(150, 20));

        rimuovi.add(risultato);
        risultato.setPreferredSize(new Dimension(150, 20));
    }

    //Metodo aggiungi: aggiunge i numeri all'ArrayList
    public void aggiungi() {
        int numero = Integer.parseInt(n.getText());
        a.add(numero);
        n.setText("");
    }

    //Metodo visualizza: vengono visualizzati i numeri in modo ordinato all'interno dell'ArrayList
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

    //Metodo cancella: serve per aprire il secondo frame
    public void cancella(){
        rimuovi.setVisible(true);
    }

    //Metodo aggiorna: metodo per rimuovere e aggiornare i numeri all'interno dell'ArrayList
    public void aggiorna(){
        int x = Integer.parseInt(nrimuovi.getText());
        for(int y=0; y<a.size(); y++){
            if(x==a.get(y)){
                a.remove(y);
                risultato.setText(""+a);
            }
        }
        nrimuovi.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aggiungi) {
            aggiungi();
        }
        if (e.getSource() == visualizza) {
            visualizza();
        }
        if(e.getSource()==r){
            cancella();
        }
        if(e.getSource()==aggiorna){
            aggiorna();
        }
    }
}