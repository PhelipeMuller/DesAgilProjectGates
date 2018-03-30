package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate{
	private NotGate[] notes;
	private NandGate nand;
	

	public OrGate() {
		notes = new NotGate[2];
		notes[0] = new NotGate();
		notes[1] = new NotGate();
		nand = new NandGate();
		
		nand.connect(0, notes[0]);
		nand.connect(1, notes[1]);
	}

	
	public void connect(int pinIndex, Emitter emitter) {
		if (pinIndex == 0){
			notes[0].connect(0, emitter);
		} else{
			notes[1].connect(0, emitter);
		}
	}
	
	public boolean read() {		
		return nand.read();
	}

}
