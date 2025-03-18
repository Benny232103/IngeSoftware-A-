package src.it.unibs.ingsw.gestvisit;
import java.util.*;
import java.time.LocalDate;
import java.time.YearMonth;

class Visite {
    
    // private String titolo;
    // private String descrizioneVisita;
    // private String luogoIncontro;
    // private String periodoAnnoInCuiPossibileVedere;
    // private List<Giorni> giornataSettimanale;
    // private int ora;
    // private int durataMinuti;
    // private String descrizioneBiglietto;
    // private int maxPersonePerVisita;
    // private String statoVisita;
    // private Set<LocalDate> dateNonDisponibili;
    // /*private List<Luogo> luoghi;
    // private Set<String> dateNonDisponibili;*/
    
    // /**
    //  * @param maxPersonePerVisita
    //  */
    // // public GestVisite(int maxPersonePerVisita){
    // //     this.maxPersonePerVisita = maxPersonePerVisita;
    // // }

    // public Visite(String titolo, String descrizioneVisita, String luogoIncontro, String periodoAnnoInCuiPossibileVedere, List<Giorni> giornataSettimanale, int ora, int durataMinuti, String descrizioneBiglietto, int maxPersonePerVisita, String statoVisita) {
    //    this.titolo = titolo;
    //    this.descrizioneVisita = descrizioneVisita;
    //    this.luogoIncontro = luogoIncontro;
    //    this.periodoAnnoInCuiPossibileVedere = periodoAnnoInCuiPossibileVedere;
    //    this.giornataSettimanale = giornataSettimanale;
    //    this.ora = ora;
    //    this.durataMinuti = durataMinuti;
    //    this.descrizioneBiglietto = descrizioneBiglietto;
    //    this.maxPersonePerVisita = maxPersonePerVisita;
    //    this.statoVisita = statoVisita;
    
    // }
    
    // public String getStatoVisita() {
    //     return statoVisita;
    // }

    // public void setStatoVisita(String statoVisita) {
    //     this.statoVisita = statoVisita;
    // }
    
    // public String getTitolo() {
    //     return titolo;
    // }

    // public void setTitolo(String titolo) {
    //     this.titolo = titolo;
    // }

    // public String getDescrizioneVisita() {
    //     return descrizioneVisita;
    // }

    // public void setDescrizioneVisita(String descrizioneVisita) {
    //     this.descrizioneVisita = descrizioneVisita;
    // }

    // public String getLuogoIncontro() {
    //     return luogoIncontro;
    // }

    // public void setLuogoIncontro(String luogoIncontro) {
    //     this.luogoIncontro = luogoIncontro;
    // }

    // public String getPeriodoAnnoInCuiPossibileVedere() {
    //     return periodoAnnoInCuiPossibileVedere;
    // }

    // public void setPeriodoAnnoInCuiPossibileVedere(String periodoAnnoInCuiPossibileVedere) {
    //     this.periodoAnnoInCuiPossibileVedere = periodoAnnoInCuiPossibileVedere;
    // }

    // public List<Giorni> getGiornataSettimanale() {
    //     return giornataSettimanale;
    // }

    // public void setGiornataSettimanale(List<Giorni> giornataSettimanale) {
    //     this.giornataSettimanale = giornataSettimanale;
    // }

    // public int getOra() {
    //     return ora;
    // }

    // public void setOra(int ora) {
    //     this.ora = ora;
    // }

    // public int getDurataMinuti() {
    //     return durataMinuti;
    // }

    // public void setDurataMinuti(int durataMinuti) {
    //     this.durataMinuti = durataMinuti;
    // }

    // public String getDescrizioneBiglietto() {
    //     return descrizioneBiglietto;
    // }

    // public void setDescrizioneBiglietto(String descrizioneBiglietto) {
    //     this.descrizioneBiglietto = descrizioneBiglietto;
    // }

    // public int getMaxPersonePerVisita() {
    //     return maxPersonePerVisita;
    // }

    // public void setMaxPersonePerVisita(int maxPersonePerVisita) {
    //     this.maxPersonePerVisita = maxPersonePerVisita;
    // }
    
    // public String toString(){
    //     return " " + titolo + " " + descrizioneVisita + " " + luogoIncontro + " " + periodoAnnoInCuiPossibileVedere + " " + giornataSettimanale + " " + ora
    //     + " " + durataMinuti + " " + descrizioneBiglietto + " " + statoVisita; 
    // }

    // public static Visite creaVisite(String titolo, String descrizioneVisita, String luogoIncontro, String periodoAnnoInCuiPossibileVedere, List<Giorni> giornataSettimanale, int ora, int durataMinuti, String descrizioneBiglietto, int maxPersonePerVisita, String statoVisita){
    //     return new Visite(titolo, descrizioneVisita, luogoIncontro, periodoAnnoInCuiPossibileVedere, giornataSettimanale, ora, durataMinuti, descrizioneBiglietto, maxPersonePerVisita, statoVisita);
    // }

    // public Set<LocalDate> getDateNonDisponibili() {
    //     return dateNonDisponibili;
    // }

    // public void setDateNonDisponibili(Set<LocalDate> dateNonDisponibili) {
    //     this.dateNonDisponibili = dateNonDisponibili;
    // }

    // public void calcolaDateNonDisponibili (int meseCorrente){
    //     YearMonth mesePrecluso = YearMonth.now().plusMonths(meseCorrente + 3);
    //     LocalDate inizioPeriodo = mesePrecluso.atDay(1);
    //     LocalDate finePeriodo = mesePrecluso.atEndOfMonth();

    //     for (LocalDate date = inizioPeriodo; !date.isAfter(finePeriodo); date = date.plusDays(1)){
    //         dateNonDisponibili.add(date);
    //     }
       
    // }

    private HashMap<String, List<Volontario>> visite;
    private int maxPersonePerVisita;

    public Visite() {
        this.visite = new HashMap<>();
        this.maxPersonePerVisita = 10; // Default value
    }

    public void aggiungiVisita(String tipoVisita, Volontario volontario) {
        visite.putIfAbsent(tipoVisita, new ArrayList<>());
        visite.get(tipoVisita).add(volontario);
    }

    public HashMap<String, List<Volontario>> getVisite() {
        return visite;
    }

    public int getMaxPersonePerVisita() {
        return maxPersonePerVisita;
    }

    public void setMaxPersonePerVisita(int maxPersonePerVisita) {
        this.maxPersonePerVisita = maxPersonePerVisita;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String tipoVisita : visite.keySet()) {
            sb.append("Tipo di visita: ").append(tipoVisita).append("\n");
            for (Volontario volontario : visite.get(tipoVisita)) {
                sb.append("  Volontario: ").append(volontario.getNome()).append(" (").append(volontario.getEmail()).append(")\n");
            }
        }
        return sb.toString();
    }

    

}
