package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;

public class View extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JComboBox<Gate> menu;
	private CalculatorView calculatorView;


	public View(LinkedList<Gate> model) {

		menu = new JComboBox<Gate>();

		for(Gate calculator: model) {
			menu.addItem(calculator);
		}

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(menu);

		addCalculatorView(0);

		menu.addActionListener(this);
	}

	private void addCalculatorView(int index) {
		Gate calculator = menu.getItemAt(index);
		calculatorView = new CalculatorView(calculator);
		add(calculatorView);
	}

	public void actionPerformed(ActionEvent event) {
		remove(calculatorView);
		int index = menu.getSelectedIndex();
		addCalculatorView(index);

		((JFrame) SwingUtilities.getRoot(this)).pack();
	}
}
