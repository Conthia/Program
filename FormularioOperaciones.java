import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioOperaciones extends JFrame {
    private JTextField text_one;
    private JTextField text_two;
    private JLabel First_Number;
    private JLabel Second_Number;
    private JLabel Operaciones;
    private JPanel Operations_Panel;
    private JComboBox comboOperaciones;
    private JButton operarButton;
    private JTextField text_result;
    private JLabel Resultado;
    private JRadioButton RadioOp1;
    private JRadioButton RadioOp2;
    private JCheckBox CheckRedondear;

    public FormularioOperaciones() {
        setTitle("Operaciones");
        setContentPane(Operations_Panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        comboOperaciones.addItem("Sumar");
        comboOperaciones.addItem("Restar");
        comboOperaciones.addItem("Multiplicar");
        comboOperaciones.addItem("Dividir");

        operarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double n_one,n_two,results;
                results = 0.0;
                String operacion;

                n_one = Double.parseDouble(text_one.getText());
                n_two = Double.parseDouble(text_two.getText());

                operacion = comboOperaciones.getSelectedItem().toString();
                /*JOptionPane.showMessageDialog(null,operacion);*/
                switch (operacion) {
                    case "Sumar":
                        results = n_one + n_two;
                        break;
                    case "Restar":
                        if (RadioOp1.isSelected()) {
                            results = n_one - n_two;
                        }else{
                            results = n_two - n_one;
                        }break;
                    case "Multiplicar":
                        results = n_one * n_two;
                        break;
                    case "Dividir":
                        if (RadioOp1.isSelected()) {
                            results = n_one / n_two;
                        }else{
                            results = n_two / n_one;
                        }break;
                }
                if (CheckRedondear.isSelected()) {
                    String result = String.format("%.2f", results);
                    text_result.setText(result);
                } else {
                    text_result.setText(Double.toString(results));
                }
            }
        });
    }

    public static void main(String[] args) {
        new FormularioOperaciones();

    }
}