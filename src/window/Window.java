package window;

import factory.RpgCharacterFactory;
import pojos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {


        RpgCharacterFactory factory = new RpgCharacterFactory();
        public Window() {
            initComponents();
        }
        public void initLook() {

            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        private void initComponents() {

            charPanel = new JPanel();
            titlecharpanel = new JLabel();
            jScrollPane1 = new JScrollPane();
            charList = new JList<>();
            selectButton = new JButton();
            createButton = new JButton();
            jScrollBar1 = new JScrollBar();
            armorPanel = new JPanel();
            classLabel = new JLabel();
            levelLabel = new JLabel();
            headLabel = new JLabel();
            chestLabel = new JLabel();
            nameLabel = new JLabel();
            nameField = new JLabel();
            legsLabel = new JLabel();
            feetLabel = new JLabel();
            classField = new JLabel();
            levelField = new JLabel();
            headField = new JLabel();
            chestField = new JLabel();
            legsField = new JLabel();
            feetField = new JLabel();

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            charPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

            titlecharpanel.setFont(new Font("Tahoma", 0, 18)); // NOI18N
            titlecharpanel.setText("Characters");

            charList.setModel(new AbstractListModel() {
                RpgCharacter[] rpgCharacters = {};

                public int getSize() {
                    return rpgCharacters.length;
                }

                public Object getElementAt(int i) {
                    return rpgCharacters[i];
                }
            });
            jScrollPane1.setViewportView(charList);

            selectButton.setText("Select");
            selectButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    selectButtonActionPerformed(evt);
                }
            });

            createButton.setText("Create");
            createButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    createButtonActionPerformed(e);
                }
            });

            GroupLayout charPanelLayout = new GroupLayout(charPanel);
            charPanel.setLayout(charPanelLayout);
            charPanelLayout.setHorizontalGroup(
                    charPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(charPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(charPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(titlecharpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(charPanelLayout.createSequentialGroup()
                                                    .addGroup(charPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(selectButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                                                            .addComponent(createButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGroup(charPanelLayout.createSequentialGroup()
                                                                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jScrollBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addContainerGap())
            );
            charPanelLayout.setVerticalGroup(
                    charPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(charPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(titlecharpanel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                    .addGroup(charPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                                            .addComponent(jScrollBar1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(selectButton)
                                    .addComponent(createButton)
                                    .addContainerGap())
            );
            nameLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
            nameLabel.setText("Name:");
            classLabel.setText("Class:");
            levelLabel.setText("Level:");
            headLabel.setText("Head:");
            chestLabel.setText("Chest:");
            legsLabel.setText("Legs:");
            feetLabel.setText("Feet:");

            nameField.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
            nameField.setText("none");
            classField.setText("none");
            levelField.setText("none");
            headField.setText("none");
            chestField.setText("none");
            legsField.setText("none");
            feetField.setText("none");

            GroupLayout armorPanelLayout = new GroupLayout(armorPanel);
            armorPanel.setLayout(armorPanelLayout);
            armorPanelLayout.setHorizontalGroup(
                    armorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(armorPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(armorPanelLayout.createSequentialGroup()
                                                    .addComponent(nameLabel)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(nameField, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
                                            .addGroup(armorPanelLayout.createSequentialGroup()
                                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(chestLabel)
                                                            .addComponent(headLabel)
                                                            .addGroup(armorPanelLayout.createSequentialGroup()
                                                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                            .addComponent(classLabel)
                                                                            .addComponent(levelLabel)
                                                                            .addComponent(legsLabel)
                                                                            .addComponent(feetLabel))
                                                                    .addGap(28, 28, 28)
                                                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                            .addComponent(headField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                            .addComponent(levelField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                            .addComponent(classField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                            .addComponent(legsField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                            .addComponent(chestField, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                                                            .addComponent(feetField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addContainerGap())
            );
            armorPanelLayout.setVerticalGroup(
                    armorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(armorPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nameField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(classLabel)
                                            .addComponent(classField))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(levelLabel)
                                            .addComponent(levelField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(headLabel)
                                            .addComponent(headField))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(chestLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chestField))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(legsLabel)
                                            .addComponent(legsField))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(armorPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(feetLabel)
                                            .addComponent(feetField))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(charPanel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(armorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(charPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(armorPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }

        private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {
            setCurrentchar(charList.getSelectedValue());
            fillLabels();
        }
        private void createButtonActionPerformed(java.awt.event.ActionEvent evt){
            String naam = (String)JOptionPane.showInputDialog("Enter name");
            String cls = (String)JOptionPane.showInputDialog("Enter class");
            String level = (String)JOptionPane.showInputDialog("Enter level");
            factory.createRpgCharacter(naam, cls, level);
        }



        // Variables declaration - do not modify
        private JPanel armorPanel;
        private JPanel charPanel;
        private JLabel chestField;
        private JLabel chestLabel;
        private JLabel classField;
        private JLabel classLabel;
        private JLabel feetField;
        private JLabel feetLabel;
        private JLabel headField;
        private JLabel headLabel;
        private static JList<RpgCharacter> charList;
        private JScrollBar jScrollBar1;
        private JScrollPane jScrollPane1;
        private JLabel legsField;
        private JLabel legsLabel;
        private JLabel levelField;
        private JLabel levelLabel;
        private JLabel nameField;
        private JLabel nameLabel;
        private JButton selectButton;
        private JButton createButton;
        private JLabel titlecharpanel;
        private RpgCharacter currentchar;
        // End of variables declaration


    public RpgCharacter getCurrentchar() {
        return currentchar;
    }

    public void setCurrentchar(RpgCharacter _currentchar) {
        this.currentchar = _currentchar;
    }

    public static void setCharList(JList<RpgCharacter> charList) {
        Window.charList = charList;
    }

    public void fillLabels() {
        if(currentchar!=null) {
            nameField.setText(getCurrentchar().getName());
            levelField.setText(getCurrentchar().getLevel());
            classField.setText(getCurrentchar().getClassName());
            headField.setText(getCurrentchar().getHelmet().getName());
            chestField.setText(getCurrentchar().getChestPlate().getName());
            legsField.setText(getCurrentchar().getLeggings().getName());
            feetField.setText(getCurrentchar().getBoots().getName());
        }
    }

}

