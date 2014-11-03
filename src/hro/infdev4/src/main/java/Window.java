import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private static final int[] SIZE = {1000,500};
    private static final int[] LOCATION = {0,0};


    private Window() throws InterruptedException {
        this.setSize(SIZE[0], SIZE[1]);
        this.setLocation(LOCATION[0],LOCATION[1]);
        this.setTitle("Standaard");
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new GridBagLayout());

                this.add(getCharPanel());


        this.add(getArmorPanel());
    }
    private JPanel getCharPanel() {
        JPanel panel = new JPanel();
        panel.setSize((int) (SIZE[0] * 0.25), (int) (SIZE[1]));
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        //panel.add(new PersonList());
        JButton button = new JButton();
        button.setText("Goto");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(button);
        return panel;
    }
    private synchronized JPanel getArmorPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(createLabel("Name: Darryl"));
        panel.add(createLabel("Class: Mage"));
        panel.add(createLabel("Head: Gold Plated Helmet"));
        panel.add(createLabel("Chest: Gold Plated Breastplate "));
        panel.add(createLabel("Legs: Gold Plated Greaves "));
        panel.add(createLabel("Feet: Gold Plated Boots "));
        //panel.add(new ArmorList());
        return panel;
    }
    private JLabel createLabel(String txt) {
        JLabel label = new JLabel();
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setText(txt);
        return label;
    }

    public static void main(String[]args)
    {
        try {
            JFrame window = new Window();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}