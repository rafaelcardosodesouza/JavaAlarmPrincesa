import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        ZoneId fusoHorarioBrasilia = ZoneId.of("America/Sao_Paulo");

        LocalDateTime dataHoraAtual = LocalDateTime.now(fusoHorarioBrasilia);
        Scanner sc = new Scanner(System.in);

        System.out.println("Hora atual em Brasilia: " + dataHoraAtual);
        System.out.print("Daqui quantos minutos e para te chamar? ");
        
        // arrumar bugHoras
        double minutosParaChamar = sc.nextDouble();

        //ZonedDateTime
        ZonedDateTime zonedDateTimeAtual = ZonedDateTime.of(dataHoraAtual, fusoHorarioBrasilia);
        ZonedDateTime novaZonedDateTime = zonedDateTimeAtual.plusMinutes((long) minutosParaChamar);

        System.out.println("Nova data e hora para te chamar: " + novaZonedDateTime);

        long tempoAteNovaDataHora = java.time.Duration.between(ZonedDateTime.now(fusoHorarioBrasilia), novaZonedDateTime).toMillis();

        try {
            Thread.sleep(tempoAteNovaDataHora);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Bom dia, princesa! agora ja e " + tempoAteNovaDataHora);

        sc.close();
        
    }
}
