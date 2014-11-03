import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hro.infdev4.neo4jpracticum.window.PersonList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window extends JFrame {
	private PersonList people = null;

	public Window() {
		super("Practicum");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BoxLayout(this.getContentPane(),1));
		this.setSize(200,200);
		people = new PersonList();
		this.add(people);
		this.add(getInputButton());
		this.setVisible(true);
	}

	public JButton getInputButton() {
		JButton out = new JButton("Voeg persoon toe");
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String input = (String)JOptionPane.showInputDialog("Geef een naam op");
				if(input != null && !input.isEmpty()) {
					Neo4j.createPerson(input);
					people.updateList();
					people.validate();
					people.repaint();
				}
			}
		});
		return out;
	}

	public static void main(String[] args) {
		new Window();
	}
}
