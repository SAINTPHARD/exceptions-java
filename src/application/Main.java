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

            System.out.println(); 
            System.out.println("Enter data to update the reservation:"); 
            System.out.print("Check-in date (dd/MM/yyyy): "); // Imprime uma mensagem pedindo a nova data de check-in
            checkIn = sdf.parse(sc.next()); 
            System.out.print("Check-out date (dd/MM/yyyy): "); 
            checkOut = sdf.parse(sc.next()); // Lê a nova data de check-out do teclado e atualiza a variável 'checkOut'


                String error = reservation.updateDates(checkIn, checkOut); // Atualiza as datas da reserva e obtem uma mensagem de erro, se houver
                if (error != null) { // Se houver erro na atualização
                    System.out.println("Error in reservation: " + error); // Imprime a mensagem de erro
                }
                else {  // Se a atualização for bem-sucedida
                System.out.println("Reservation: " + reservation); // Imprime os detalhes da reserva atualizada
            }
        }

        sc.close(); // Fecha o objeto Scanner para liberar recursos
    }
}