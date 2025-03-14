package src.it.unibs.ingsw.gestvisit;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {

    public static void creaCalendario(int year, int month) {

        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        DayOfWeek firstDay = firstDayOfMonth.getDayOfWeek();
        int daysInMonth = firstDayOfMonth.lengthOfMonth();

        System.out.println("Lun Mar Mer Gio Ven Sab Dom");

        int currentDayPosition = firstDay.getValue() % 7; // Lunedì inizia con 0
        for (int i = 0; i < currentDayPosition; i++) {
            System.out.print("    "); // Spazi vuoti prima del primo giorno
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            currentDayPosition++;
            if (currentDayPosition % 7 == 0) {
                System.out.println(); // Vai a capo alla fine della settimana
            }
        }
        System.out.println(); // Vai a capo alla fine del mese

    }
}


