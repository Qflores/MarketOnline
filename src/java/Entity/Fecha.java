
package Entity;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fecha {
    
    
    public static String getFecha(){
         LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "America/Lima" ) );
        
        Calendar fecha_actual = Calendar.getInstance(); //new GregorianCalendar();
        
        //System.out.println("fecha actualk: "+fecha_actual.getTime());
        
        int year = fecha_actual.get(Calendar.YEAR) ;
        int mes= fecha_actual.get(Calendar.MONTH ) +1;
        int dia = fecha_actual.get(Calendar.DATE);
        int hora = fecha_actual.get(Calendar.HOUR_OF_DAY);
        int minuto =fecha_actual.get(Calendar.MINUTE);
        int second =fecha_actual.get(Calendar.SECOND);
        
        //label_fechasistema.setText(""+dia+"/"+mes+1+"/"+ano+"    "+hora+":"+minuto+":"+segundo);
        
        LocalDateTime ldt = LocalDateTime.of(year, Month.of(mes), dia, hora, minuto, second);        
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH );
        
        String fechas = formmat1.format(ldt);
        
        return fechas;
    }
    public static String OnlyFecha(){
        LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "America/Lima" ) );
        
        Calendar fecha_actual = Calendar.getInstance(); //new GregorianCalendar();
        
        //System.out.println("fecha actualk: "+fecha_actual.getTime());
        
        int year = fecha_actual.get(Calendar.YEAR) ;
        int mes= fecha_actual.get(Calendar.MONTH ) +1;
        int dia = fecha_actual.get(Calendar.DATE);
        int hora = fecha_actual.get(Calendar.HOUR_OF_DAY);
        int minuto =fecha_actual.get(Calendar.MINUTE);
        int second =fecha_actual.get(Calendar.SECOND);
        
        //label_fechasistema.setText(""+dia+"/"+mes+1+"/"+ano+"    "+hora+":"+minuto+":"+segundo);
        
        LocalDateTime ldt = LocalDateTime.of(year, Month.of(mes), dia, hora, minuto, second);        
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH );
        
        String fechas = formmat1.format(ldt);
        
        return fechas;
        
    }
    public static boolean compareFecha(String Ffech, String Lfech) {
        
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Para declarar valores en nuevos objetos date, usa el mismo formato date que usaste al crear las fechas 
            //Date date1 = sdf.parse("2020-02-23"); //date1 es el 23 de febrero de 2020

        try {
            Date date1 = sdf.parse(Ffech);
            Date date2 = sdf.parse(Lfech);
            
            //date1.compareTo(date2); //date1 < date2, devuelve un valor menor que 0
            
            if (date1.compareTo(date2) < 0) { //
               
                    return true;

                }else{

                   return false;
                }
            
            //System.out.print(date2.after(date1));//muestra true (verdadero)
            
        } catch (ParseException ex) {
            
            //Logger.getLogger(Fecha.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }          
        
        //return false;
        
    }
}
