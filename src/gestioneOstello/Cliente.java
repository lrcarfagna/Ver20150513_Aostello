package gestioneOstello;

import java.util.Vector;

public class Cliente {
	
	private String nome;
	private String cognome;
	private String numeroTelefonico;
	private Vector<Prenotazione> prenotazioni;
	
	
	Cliente(String nome,String cognome,String numeroTelefonico){
		if(nome!=null){
			this.nome=nome;
		}
		else 
			throw new IllegalArgumentException("nome=null");
		if(cognome!=null){
			this.cognome=cognome;
		}
		else
			throw new IllegalArgumentException("cognome=null");
		if(numeroTelefonico!=null){
			this.numeroTelefonico=numeroTelefonico;
		}
		else
			throw new IllegalArgumentException("numeroTelefonico=null");
		
		prenotazioni= new Vector<Prenotazione>();
	}


	public String getNome() {
		return nome;
	}


	public String getCognome() {
		return cognome;
	}


	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}


	public Vector<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	
	public void addPrenotazione(Prenotazione p){
		prenotazioni.addElement(p);
	}
	
	public int getNumeroGiorni(){
		int numeroNotti=0;
		for(int i=0;i<prenotazioni.size();i++){
			numeroNotti+=prenotazioni.elementAt(i).getNumeroNotti();
		}
		return numeroNotti;
		
	}
	
	public double getCostoTotale(){
		int costoTotale=0;
		for(int i=0;i<prenotazioni.size();i++){
			costoTotale+=prenotazioni.elementAt(i).getCostoTotale();
		}
		return costoTotale;
		
	}


	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cognome=" + cognome
				+ ", numeroTelefonico=" + numeroTelefonico + ", prenotazioni="
				+ prenotazioni + "]";
	}

}
