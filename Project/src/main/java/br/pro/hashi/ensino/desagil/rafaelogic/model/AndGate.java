package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate{
	private NandGate nand;
	private NotGate note;

	public AndGate() {
		nand = new NandGate();
		note = new NotGate();
		
		note.connect(0, nand);
	}

	
	public void connect(int pinIndex, Emitter emitter) {
		if (pinIndex == 0){
			nand.connect(0, emitter);
		} else{
			nand.connect(1, emitter);
		}
			
	}
	
	
	public boolean read() {
		return note.read();
	}
}
