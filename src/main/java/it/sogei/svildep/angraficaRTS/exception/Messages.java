package it.sogei.svildep.angraficaRTS.exception;

public interface Messages {
    String nonAutorizzato = "L'utente corrente non è autorizzato ad eseguire l'operazione.";

    String RtsNonTrovata = "non è stata trovata nessuna RTS";

    String denominazioneRtsEsistente = "esiste già una Rts con la denominazione selezionata";

    String operazioneRiuscita = "operazione riuscita";

    String utenteInesistente = "utente non trovato";

    String competenzaProvincialeGiaPresente = "Non puoi inserire una provincia gia presente nella competenza della Rts";

    String chiusuraNegata = "non puoi chiudere la Rts perchè ha uno o più depositi associati";
}
