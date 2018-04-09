package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.BoolEmitter;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;

public class CalculatorView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;


	private Gate calculator;
	private BoolEmitter A = new BoolEmitter(false);
	private BoolEmitter B = new BoolEmitter(false);

	private	JCheckBox weightField;
	private	JCheckBox radiusField;
	private JCheckBox resultField;


	public CalculatorView(Gate calculator) {
		this.calculator = calculator;

		calculator.connect(0,A);
		calculator.connect(1,B);
		

		weightField = new JCheckBox();
		radiusField = new JCheckBox();
		resultField = new JCheckBox();

		JLabel weightLabel = new JLabel("A");
		JLabel radiusLabel = new JLabel("B");
		if (calculator.toString() == "NotGate") {radiusLabel = new JLabel("A");}
		JLabel resultLabel = new JLabel("Result");

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		if (calculator.toString() != "NotGate") { 
		add(weightLabel);
		add(weightField);
		};
		add(radiusLabel);
		add(radiusField);
		add(resultLabel);
		add(resultField);

		weightField.addActionListener(this);
		radiusField.addActionListener(this);

		resultField.setEnabled(false);

		update();
	}

	private void update() {
		A.SetBool(weightField.isSelected());
		B.SetBool(radiusField.isSelected());
	
		resultField.setSelected(calculator.read());
	}

	public void actionPerformed(ActionEvent event) {
		update();
	}
}
