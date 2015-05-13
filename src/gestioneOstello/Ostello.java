package gestioneOstello;

import java.util.Vector;

public class Ostello {
	
	private String nome;
	private Vector<Stanza> stanze;
	
	public Ostello(String nome){
		if(nome!=null){
			this.nome=nome;
		}
		else
			throw new IllegalArgumentException("nome=null");
		
		stanze=new Vector<Stanza>();
	}
	
	public void addStanza(Stanza s){
		if(s!=null){
			stanze.addElement(s);
		}
		else
			throw new IllegalArgumentException("Stanza=null");
	}

	public String getNome() {
		return nome;
	}

	public Vector<Stanza> getStanze() {
		return stanze;
	}
	
	public Vector<Stanza> getStanzeDisponibili(Prenotazione p){
		Vector <Stanza> stanzeDisponibili=new Vector<Stanza>();
		for(int i=0;i<stanze.size();i++){
			Stanza stanza=stanze.elementAt(i);
			if(stanza.isDisponibile(p.getArrivo(), p.getPartenza(), p.getPostiRichiesti())){
				stanzeDisponibili.add(stanza);
			}
		}
		return stanzeDisponibili;
	}

	@Override
	public String toString() {
		return "Ostello [nome=" + nome + ", stanze=" + stanze + "]";
	}
	
	

}
