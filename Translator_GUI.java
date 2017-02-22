import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by grzesiek on 1/20/17.
 */
public class Translator_GUI {
    private JTextArea pythonCodeTextArea;
    private JPanel panel1;
    private JTextArea javaCodeTextArea;
    private JButton translateButton;
    private Translator translator = new Translator();

    public Translator_GUI() {
        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = pythonCodeTextArea.getText();
                String result = translator.translationResult(text);
                result = translator.rewrite(result);
                javaCodeTextArea.setText(result);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Translator_GUI");
        frame.setContentPane(new Translator_GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
