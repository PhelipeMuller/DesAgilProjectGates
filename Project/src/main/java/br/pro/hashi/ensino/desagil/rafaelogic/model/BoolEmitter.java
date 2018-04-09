package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class BoolEmitter implements Emitter{
	private boolean bool;
	public BoolEmitter(boolean bool) {
		this.bool = bool;
	}
	
	public boolean read() {
		return bool;
	}
	
	public void SetBool(boolean bool) {
		this.bool = bool;
	}
	
}
