package application;
import java.text.ParseException; // Importa a classe ParseException para tratar erros de conversão de data
import java.text.SimpleDateFormat; // Importa a classe SimpleDateFormat para formatar e analisar datas
import java.util.Date; // Importa a classe Date para trabalhar com datas
import java.util.Scanner; // Importa a classe Scanner para ler dados do teclado

import model.entities.Reservation;

public class Main { // Define a classe Main, que contém o método principal do programa

    public static void main(String[] args) throws ParseException { // Define o método principal, que pode lançar ParseException

        Scanner sc = new Scanner(System.in); // Cria um objeto Scanner para ler dados do teclado
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Cria um objeto SimpleDateFormat para formatar datas no formato "dd/MM/yyyy"

        System.out.print("Room number: "); // Imprime uma mensagem pedindo o número do quarto
        int number = sc.nextInt(); // Lê o número do quarto do teclado e armazena na variável 'number'
        System.out.print("Check-in date (dd/MM/yyyy): "); // Imprime uma mensagem pedindo a data de check-in
        Date checkIn = sdf.parse(sc.next()); // Lê a data de check-in do teclado, converte para um objeto Date e armazena em 'checkIn'
        System.out.print("Check-out date (dd/MM/yyyy): "); // Imprime uma mensagem pedindo a data de check-out
        Date checkOut = sdf.parse(sc.next()); // Lê a data de check-out do teclado, converte para um objeto Date e armazena em 'checkOut'

        if (!checkOut.after(checkIn)) { // Verifica se a data de check-out não é posterior à data de check-in
            System.out.println("Error in reservation: Check-out date must be after check-in date"); // Imprime uma mensagem de erro se a data de check-out for inválida
        } else { // Se a data de check-out for válida
            Reservation reservation = new Reservation(number, checkIn, checkOut); // Cria um objeto Reservation com os dados lidos
            System.out.println("Reservation: " + reservation); // Imprime os detalhes da reserva

            System.out.println(); // Imprime uma linha em branco para separar as seções
            System.out.println("Enter data to update the reservation:"); // Imprime uma mensagem pedindo os novos dados para atualizar a reserva
            System.out.print("Check-in date (dd/MM/yyyy): "); // Imprime uma mensagem pedindo a nova data de check-in
            checkIn = sdf.parse(sc.next()); //var pra Lê a nova data de check-in do teclado e atualiza a variável 'checkIn'
            System.out.print("Check-out date (dd/MM/yyyy): "); // Imprime uma mensagem pedindo a nova data de check-out
            checkOut = sdf.parse(sc.next()); // Lê a nova data de check-out do teclado e atualiza a variável 'checkOut'

            Date now = new Date(); // Cria um objeto Date com a data e hora atuais
            if (checkIn.before(now) || checkOut.before(now)) { // Verifica se as novas datas são anteriores à data atual
                System.out.println("Error in reservation: Reservation dates for update must be future dates"); // Imprime uma mensagem de erro se as datas forem inválidas
            } else if (!checkOut.after(checkIn)) { // Verifica se a nova data de check-out não é posterior à nova data de check-in
                System.out.println("Error in reservation: Check-out date must be after check-in date"); // Imprime uma mensagem de erro se a data de check-out for inválida
            } else { // Se as novas datas forem válidas
                reservation.updateDates(checkIn, checkOut); // Atualiza as datas da reserva com os novos valores
                System.out.println("Reservation: " + reservation); // Imprime os detalhes da reserva atualizada
            }
        }

        sc.close(); // Fecha o objeto Scanner para liberar recursos
    }
}