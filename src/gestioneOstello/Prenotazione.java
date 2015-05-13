package gestioneOstello;

import java.time.*;

public class Prenotazione {
	private LocalDateTime arrivo;
	private LocalDateTime partenza;
	private int postiRichiesti;
	private Cliente cliente;
	private Stanza stanza;
	
	
	Prenotazione(LocalDateTime arrivo,LocalDateTime partenza,int postiRichiesti,Cliente c){
		if(arrivo!=null){
			this.arrivo=arrivo;
		}
		else
			throw new IllegalArgumentException("arrivo=null");
		if(partenza!=null){
			this.partenza=partenza;
		}
		else
			throw new IllegalArgumentException("partenza=null");
		if(postiRichiesti>0){
			this.postiRichiesti=postiRichiesti;
		}
		else
			throw new IllegalArgumentException("postiRichiesti<=0");
		if(c!=null){
			this.cliente=c;
		}
		else
			throw new IllegalArgumentException("cliente=null");
	}


	public LocalDateTime getArrivo() {
		return arrivo;
	}


	public LocalDateTime getPartenza() {
		return partenza;
	}


	public int getPostiRichiesti() {
		return postiRichiesti;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public Stanza getStanza() {
		return stanza;
	}
	
	public void setStanza(Stanza s){
		if(s!=null){
			stanza=s;
		}
		else
			throw new IllegalArgumentException("Stanza=null");
	}
	
	public int getNumeroNotti(){
		
		Period notti;
		notti= Period.between(arrivo.toLocalDate(), partenza.toLocalDate());
		return notti.getDays();
		
	}
	
	public double getCostoTotale(){
		return this.getStanza().getCostoGiornaliero() * this.getNumeroNotti();
	}


	@Override
	public String toString() {
		return "Prenotazione [arrivo=" + arrivo + ", partenza=" + partenza
				+ ", postiRichiesti=" + postiRichiesti + ", cliente=" + cliente
				+ ", stanza=" + stanza + "]";
	}
	

}
