package gestioneOstello;

import java.time.LocalDateTime;
import java.util.Vector;

public class Stanza {
	
	private String numero;
	private int capienza;
	private double costoGiornaliero;
	private Vector<Prenotazione> prenotazioni;
	
	
	public Stanza(String numero,int capienza,double costoGiornaliero){
		if(numero!=null){
			this.numero=numero;
		}
		else
			throw new IllegalArgumentException("numeroStanza=null");
		if(capienza>0){
			this.capienza=capienza;
		}
		else
			throw new IllegalArgumentException("capienza<=0");
		if(costoGiornaliero>0){
			this.costoGiornaliero=costoGiornaliero;
		}
		else
			throw new IllegalArgumentException("costoGiornaliero<=0");
		
		prenotazioni=new Vector<Prenotazione>();
	}
	
	public String getNumero() {
		return numero;
	}

	public int getCapienza() {
		return capienza;
	}

	public double getCostoGiornaliero() {
		return costoGiornaliero;
	}

	public Vector<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	

	public boolean isDisponibile(LocalDateTime dal, LocalDateTime al, int postiRichiesti){
		boolean disponibile=true;
		for(int i=0;i<prenotazioni.size();i++){
			if(dal.isBefore(prenotazioni.elementAt(i).getPartenza())&& 
					al.isAfter(prenotazioni.elementAt(i).getArrivo())){
				if(this.getCapienza()<postiRichiesti + prenotazioni.elementAt(i).getPostiRichiesti()){
					disponibile=false;
				}
			}
		}
		return disponibile;
	}
	
	public void addPrenotazione(Prenotazione p) throws Exception{
		
		if(p!=null){
			if(this.isDisponibile(p.getArrivo(),p.getPartenza(),p.getPostiRichiesti())){
				prenotazioni.addElement(p);
				p.getCliente().addPrenotazione(p);
			}
			else
				throw new Exception("Camera non disponibile");
		}
		else
			throw new IllegalArgumentException("prenotazione=null");
	
	}
	

}
