import javax.swing.*;
import java.awt.*;

public class Swing00 extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new Swing00("Prova");
            }
        }); // fa partire il thread quando vuole lui
    }

    // solitamente si assegna a un thread separato la grafica
    private Swing00(String title){
        setTitle(title);
        setSize(400,600);
        // per dire dove inserire la finestra nella schermata, se null -> centrata
        // prima settare la size -> centrata in base ad esse
        // se avessimo un frame parent che la genera, bisognerebbe settarla al centro del parent
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // se la finestra viene chiusa il programma termina

        // Pannello ID
        JLabel lblId = new JLabel("Id: ");
        JTextField txtId = new JTextField(30);
        txtId.setEnabled(false);
        // panel che contiene un flow layout che a sua volta ci permettera' di mettere in fila piu' JComponent
        JPanel pnlId = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlId.add(lblId);
        pnlId.add(txtId);

        // Pannello Descrizione

        JLabel lblDescription = new JLabel("Descrizione: ");
        JTextField txtDescription = new JTextField(30);

        JPanel pnlDescription = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlDescription.add(lblDescription);
        pnlDescription.add(txtDescription);

        // Pannello Stagione

        JLabel lblStagione = new JLabel("Stagione: ");
        JComboBox <Season> cmbSeason = new JComboBox<>(Season.values());

        JPanel pnlStagione = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlStagione.add(lblStagione);
        pnlStagione.add(cmbSeason);

        // Pannello Prezzo

        JLabel lblPrezzo = new JLabel("Prezzo: ");
        JTextField txtPrezzo = new JTextField(30);

        JPanel pnlPrezzo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlPrezzo.add(lblPrezzo);
        pnlPrezzo.add(txtPrezzo);

        JPanel pnlCenter = new JPanel(new GridLayout(4,1));

        pnlCenter.add(pnlId);
        pnlCenter.add(pnlDescription);
        pnlCenter.add(pnlStagione);
        pnlCenter.add(pnlPrezzo);

        add(pnlCenter, BorderLayout.CENTER);

        //add(btnTest);
        //add(lblText);

        JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnAdd = new JButton("Add");

        pnlSouth.add(btnUpdate);
        pnlSouth.add(btnDelete);
        pnlSouth.add(btnAdd);

        add(pnlSouth, BorderLayout.SOUTH);



        setVisible(true); // si setta visibile
        }
}