package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class XorGate extends Gate{
	private AndGate[] ands;
	private NotGate[] notes;
	private OrGate ores;
	
	

	public XorGate() {
		ands = new AndGate[2];
		ands[0] = new AndGate();
		ands[1] = new AndGate();
		
		notes = new NotGate[2];
		notes[0] = new NotGate();
		notes[1] = new NotGate();
		
		ores = new OrGate();
		
		ands[0].connect(1,notes[1]);
		ands[1].connect(1,notes[0]);
		
		ores.connect(0,ands[0]);
		ores.connect(1, ands[1]);
		
	}

	
	public void connect(int pinIndex, Emitter emitter) {
		if (pinIndex == 0){
			notes[0].connect(0,emitter);
			ands[0].connect(0,emitter);
		} else {
			notes[1].connect(0,emitter);
			ands[1].connect(0,emitter);
			
		}
	}
	
	public boolean read() {
		return ores.read();
	}

}
