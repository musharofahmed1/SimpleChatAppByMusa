import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleChatApp extends JFrame {

    private JTextArea chatArea;
    private JTextField user1TextField;
    private JTextField user2TextField;
    private JButton user1SendButton;
    private JButton user2SendButton;

    public SimpleChatApp() {
        setTitle("Simple Chat App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 240));

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel user1Panel = createUserPanel("User 1", new Color(255, 182, 193), Color.black); // Light Pink
        JPanel user2Panel = createUserPanel("User 2", new Color(173, 216, 230), Color.black); // Light Blue

        add(user1Panel, BorderLayout.NORTH);
        add(user2Panel, BorderLayout.SOUTH);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createUserPanel(String userName, Color backgroundColor, Color textColor) {
        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.setBackground(backgroundColor);

        JTextField userTextField = new JTextField();
        userTextField.setBackground(new Color(255, 255, 255)); // White background
        userTextField.setForeground(textColor);

        JButton sendButton = new JButton("Send");
        sendButton.setBackground(new Color(50, 205, 50)); // Lime Green
        sendButton.setForeground(Color.white);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(userName, userTextField.getText());
                userTextField.setText("");
            }
        });

        userPanel.add(new JLabel(userName), BorderLayout.WEST);
        userPanel.add(userTextField, BorderLayout.CENTER);
        userPanel.add(sendButton, BorderLayout.EAST);

        return userPanel;
    }

    private void sendMessage(String user, String message) {
        if (!message.isEmpty()) {
            chatArea.append(user + ": " + message + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleChatApp();
            }
        });
    }
}
