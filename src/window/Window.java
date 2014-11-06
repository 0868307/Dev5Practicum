package window;

import database.GraphDBController;
import database.TestDB;
import factory.RpgCharacterFactory;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Node;
import pojos.*;
import scala.collection.Iterator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        charList = new JList<RpgCharacter>();
        selectButton = new JButton();
        deleteButton = new JButton();
        createButton = new JButton();
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
        equipPanel = new JPanel();
        equipTitle = new JLabel();
        jScrollPane2 = new JScrollPane();
        headList = new JList();
        jScrollPane3 = new JScrollPane();
        chestList = new JList();
        jScrollPane4 = new JScrollPane();
        feetList = new JList();
        jScrollPane5 = new JScrollPane();
        legsList = new JList();
        headequipLabel = new JLabel();
        chestequipLabel = new JLabel();
        legsequipLabel = new JLabel();
        feetequipLabel = new JLabel();
        headequipButton = new JButton();
        chestequipButton = new JButton();
        legsequipButton = new JButton();
        feetequipButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        charPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        titlecharpanel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titlecharpanel.setText("Characters");

        charList.setModel(new AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });

        jScrollPane1.setViewportView(charList);

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
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
                                        .addGroup(GroupLayout.Alignment.TRAILING, charPanelLayout.createSequentialGroup()
                                                .addGroup(charPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(selectButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(GroupLayout.Alignment.LEADING, charPanelLayout.createSequentialGroup()
                                                                .addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING))
                                                .addContainerGap())))
        );
        charPanelLayout.setVerticalGroup(
                charPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(charPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titlecharpanel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(charPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteButton)
                                        .addComponent(createButton))
                                .addGap(15, 15, 15))
        );

        classLabel.setText("Class:");
        levelLabel.setText("Level:");
        headLabel.setText("Head:");
        chestLabel.setText("Chest:");
        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nameLabel.setText("Name:");
        legsLabel.setText("Legs:");
        feetLabel.setText("Feet:");
        headequipLabel.setText("Head");
        chestequipLabel.setText("Chest");
        legsequipLabel.setText("Legs");
        feetequipLabel.setText("Feet");

        nameField.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nameField.setText("None");
        classField.setText("None");
        levelField.setText("None");
        headField.setText("None");
        chestField.setText("None");
        legsField.setText("None");
        feetField.setText("None");

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
                                                .addComponent(nameField, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
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

        equipPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        equipTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        equipTitle.setText("Characters");

        headList.setModel(new AbstractListModel() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(headList);

        chestList.setModel(new AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(chestList);

        feetList.setModel(new AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(feetList);

        legsList.setModel(new AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(legsList);



        headequipButton.setText("Equip");
        headequipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headequipButtonActionPerformed(evt);
            }
        });

        chestequipButton.setText("Equip");
        chestequipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chestequipButtonActionPerformed(evt);
            }
        });

        legsequipButton.setText("Equip");
        legsequipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                legsequipButtonActionPerformed(evt);
            }
        });

        feetequipButton.setText("Equip");
        feetequipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feetequipButtonActionPerformed(evt);
            }
        });

        GroupLayout equipPanelLayout = new GroupLayout(equipPanel);
        equipPanel.setLayout(equipPanelLayout);
        equipPanelLayout.setHorizontalGroup(
                equipPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(equipPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(equipPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(equipPanelLayout.createSequentialGroup()
                                                .addComponent(equipTitle, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                                .addGap(60, 60, 60))
                                        .addGroup(equipPanelLayout.createSequentialGroup()
                                                .addGroup(equipPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(legsequipButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(headequipButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                                        .addComponent(headequipLabel, GroupLayout.Alignment.LEADING)
                                                        .addComponent(legsequipLabel, GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(equipPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(equipPanelLayout.createSequentialGroup()
                                                                .addGroup(equipPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane3)
                                                                        .addComponent(chestequipButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addContainerGap())
                                                        .addGroup(equipPanelLayout.createSequentialGroup()
                                                                .addGroup(equipPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(feetequipLabel)
                                                                        .addComponent(chestequipLabel)
                                                                        .addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                                                        .addComponent(feetequipButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        equipPanelLayout.setVerticalGroup(
                equipPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(equipPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(equipTitle, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(equipPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(headequipLabel)
                                        .addComponent(chestequipLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(equipPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(equipPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(headequipButton)
                                        .addComponent(chestequipButton))
                                .addGap(43, 43, 43)
                                .addGroup(equipPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(equipPanelLayout.createSequentialGroup()
                                                .addComponent(legsequipLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(equipPanelLayout.createSequentialGroup()
                                                .addComponent(feetequipLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(equipPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(legsequipButton)
                                        .addComponent(feetequipButton))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(charPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(armorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(equipPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(charPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(armorPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(equipPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setCharList(updateRpgCharacters(charList));
        pack();
    }



    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {
        setCurrentchar(charList.getSelectedValue());
        fillLabels();
    }
    private void deleteButtonActionPerformed(ActionEvent evt) {
    }
    private void createButtonActionPerformed(java.awt.event.ActionEvent evt){
        String naam = (String)JOptionPane.showInputDialog("Enter name");
        String cls = (String)JOptionPane.showInputDialog("Enter class");
        String level = (String)JOptionPane.showInputDialog("Enter level");
        factory.createRpgCharacter(naam, cls, level);
        charList = updateRpgCharacters(charList);
    }

    private void headequipButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void chestequipButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void legsequipButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void feetequipButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void initList()
        {
            charList = updateRpgCharacters(charList);
        }
    public JList<RpgCharacter> updateRpgCharacters(JList<RpgCharacter> x)
    {
        ArrayList<RpgCharacter> rpgCharacters = new ArrayList<RpgCharacter>();
        ExecutionResult result = TestDB.getRpgCharacters();
        Iterator<Node> e_column = result.columnAs("e");
        while(e_column.hasNext())
        {

            Node node = e_column.next();
            rpgCharacters.add(new RpgCharacter(node));
        }
        x.setListData(rpgCharacters.toArray(new RpgCharacter[rpgCharacters.size()]));


        return x;
    }


        // Variables declaration - do not modify
        private JPanel armorPanel;
    private JPanel charPanel;
    private JLabel chestField;
    private JLabel chestLabel;
    private JList chestList;
    private JButton chestequipButton;
    private JLabel chestequipLabel;
    private JLabel classField;
    private JLabel classLabel;
    private JButton createButton;
    private JButton deleteButton;
    private JPanel equipPanel;
    private JLabel equipTitle;
    private JLabel feetField;
    private JLabel feetLabel;
    private JList feetList;
    private JButton feetequipButton;
    private JLabel feetequipLabel;
    private JLabel headField;
    private JLabel headLabel;
    private JList headList;
    private JButton headequipButton;
    private JLabel headequipLabel;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JLabel legsField;
    private JLabel legsLabel;
    private JList legsList;
    private JButton legsequipButton;
    private JLabel legsequipLabel;
    private JLabel levelField;
    private JLabel levelLabel;
    private JLabel nameField;
    private JLabel nameLabel;
    private JButton selectButton;
    private JLabel titlecharpanel;
    private static JList<RpgCharacter> charList;
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
            classField.setText(getCurrentchar().getClassName());
            levelField.setText(getCurrentchar().getLevel());
            headField.setText(getCurrentchar().getHelmet().getName());
            chestField.setText(getCurrentchar().getChestPlate().getName());
            legsField.setText(getCurrentchar().getLeggings().getName());
            feetField.setText(getCurrentchar().getBoots().getName());
        }
    }

}

