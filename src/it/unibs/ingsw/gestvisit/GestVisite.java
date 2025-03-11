package src.it.unibs.ingsw.gestvisit;
import java.util.*;
import java.time.LocalDate;
import java.time.YearMonth;

class GestVisite {
    
    private String titolo;
    private String descrizioneVisita;
    private String luogoIncontro;
    private String periodoAnnoInCuiPossibileVedere;
    private List<Giorni> giornataSettimanale;
    private int ora;
    private int durataMinuti;
    private String descrizioneBiglietto;
    private int maxPersonePerVisita;
    /*private List<Luogo> luoghi;
    private Set<String> dateNonDisponibili;*/
    

    public GestVisite(String titolo, String descrizioneVisita, String luogoIncontro, String periodoAnnoInCuiPossibileVedere, List<Giorni> giornataSettimanale, int ora, int durataMinuti, String descrizioneBiglietto, int maxPersonePerVisita) {
       this.titolo = titolo;
       this.descrizioneVisita = descrizioneVisita;
       this.luogoIncontro = luogoIncontro;
       this.periodoAnnoInCuiPossibileVedere = periodoAnnoInCuiPossibileVedere;
       this.giornataSettimanale = giornataSettimanale;
       this.ora = ora;
       this.durataMinuti = durataMinuti;
       this.descrizioneBiglietto = descrizioneBiglietto;
       this.maxPersonePerVisita = maxPersonePerVisita;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizioneVisita() {
        return descrizioneVisita;
    }

    public void setDescrizioneVisita(String descrizioneVisita) {
        this.descrizioneVisita = descrizioneVisita;
    }

    public String getLuogoIncontro() {
        return luogoIncontro;
    }

    public void setLuogoIncontro(String luogoIncontro) {
        this.luogoIncontro = luogoIncontro;
    }

    public String getPeriodoAnnoInCuiPossibileVedere() {
        return periodoAnnoInCuiPossibileVedere;
    }

    public void setPeriodoAnnoInCuiPossibileVedere(String periodoAnnoInCuiPossibileVedere) {
        this.periodoAnnoInCuiPossibileVedere = periodoAnnoInCuiPossibileVedere;
    }

    public List<Giorni> getGiornataSettimanale() {
        return giornataSettimanale;
    }

    public void setGiornataSettimanale(List<Giorni> giornataSettimanale) {
        this.giornataSettimanale = giornataSettimanale;
    }

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getDurataMinuti() {
        return durataMinuti;
    }

    public void setDurataMinuti(int durataMinuti) {
        this.durataMinuti = durataMinuti;
    }

    public String getDescrizioneBiglietto() {
        return descrizioneBiglietto;
    }

    public void setDescrizioneBiglietto(String descrizioneBiglietto) {
        this.descrizioneBiglietto = descrizioneBiglietto;
    }

    public int getMaxPersonePerVisita() {
        return maxPersonePerVisita;
    }

    public void setMaxPersonePerVisita(int maxPersonePerVisita) {
        this.maxPersonePerVisita = maxPersonePerVisita;
    }
    
    public String toString(){
        return " " + titolo + " " + descrizioneVisita + " " + luogoIncontro + " " + periodoAnnoInCuiPossibileVedere + " " + giornataSettimanale + " " + ora
        + " " + durataMinuti + " " + descrizioneBiglietto; 
    }

    public static GestVisite creaGestVisite(String titolo, String descrizioneVisita, String luogoIncontro, String periodoAnnoInCuiPossibileVedere, List<Giorni> giornataSettimanale, int ora, int durataMinuti, String descrizioneBiglietto, int maxPersonePerVisita){
        return new GestVisite(titolo, descrizioneVisita, luogoIncontro, periodoAnnoInCuiPossibileVedere, giornataSettimanale, ora, durataMinuti, descrizioneBiglietto, maxPersonePerVisita);
    }

    public static Set<LocalDate> getExcludedDates(int year, int month, Set<Integer> excludedDays) {
        Set<LocalDate> excludedDates = new HashSet<>();
        YearMonth targetMonth = YearMonth.of(year, month).plusMonths(3); // Calcolo mese i+3
        
        for (Integer day : excludedDays) {
            if (day >= 1 && day <= targetMonth.lengthOfMonth()) {
                excludedDates.add(LocalDate.of(targetMonth.getYear(), targetMonth.getMonth(), day));
            }
        }
        return excludedDates;
    }
}
