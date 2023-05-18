import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AuthorAPIView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JLabel authorIdLabel;
    private JTextField authorIdField;
    private JButton searchButton;
    private JLabel responseLabel;
    private AuthorAPIController controller;

    public AuthorAPIView(AuthorAPIController controller) {
        super("Google Scholar Author API");
        this.controller = controller;

        panel = new JPanel(new FlowLayout());

        authorIdLabel = new JLabel("Author ID:");
        panel.add(authorIdLabel);

        authorIdField = new JTextField(20);
        panel.add(authorIdField);

        searchButton = new JButton("Consultar");
        searchButton.addActionListener(this);
        panel.add(searchButton);

        responseLabel = new JLabel("");
        panel.add(responseLabel);

        add(panel);

        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String authorId = authorIdField.getText();
            String data = controller.getAuthorData(authorId);
            responseLabel.setText(data);
        } catch (IOException ex) {
            responseLabel.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        AuthorAPIModel model = new AuthorAPIModel("209ecdda7b297c929375d5e62924dee71194016f9c5eff742ecfeed2df72b4c2");
        AuthorAPIController controller = new AuthorAPIController(model);
        AuthorAPIView view = new AuthorAPIView(controller);
        view.display();
    }

    public void display() {
        setVisible(true);
    }
}
