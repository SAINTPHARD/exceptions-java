package model.entities;

import java.text.SimpleDateFormat; // Importa a classe SimpleDateFormat para formatar datas
import java.util.Date; // Importa a classe Date para trabalhar com datas
import java.util.concurrent.TimeUnit; // Importa a classe TimeUnit para converter unidades de tempo

public class Reservation { // Define a classe Reservation

    private Integer roomNumber; // Declara a variável de instância roomNumber para armazenar o número do quarto
    private Date checkin; // Declara a variável de instância checkin para armazenar a data de check-in
    private Date checkout; // Declara a variável de instância checkout para armazenar a data de check-out

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Cria um objeto SimpleDateFormat para formatar datas no formato "dd/MM/yyyy"

    public Reservation(Integer roomNumber, Date checkin, Date checkout) { // Construtor da classe Reservation
        this.roomNumber = roomNumber; // Inicializa a variável de instância roomNumber com o valor passado como argumento
        this.checkin = checkin; // Inicializa a variável de instância checkin com o valor passado como argumento
        this.checkout = checkout; // Inicializa a variável de instância checkout com o valor passado como argumento
    }

    public Integer getRoomNumber() { // Método getter para a variável de instância roomNumber
        return roomNumber; // Retorna o valor da variável de instância roomNumber
    }

    public void setRoomNumber(Integer roomNumber) { // Método setter para a variável de instância roomNumber
        this.roomNumber = roomNumber; // Define o valor da variável de instância roomNumber com o valor passado como argumento
    }

    public Date getCheckin() { // Método getter para a variável de instância checkin
        return checkin; // Retorna o valor da variável de instância checkin
    }

    public Date getCheckout() { // Método getter para a variável de instância checkout
        return checkout; // Retorna o valor da variável de instância checkout
    }

    public long duration() { // Método para calcular a duração da reserva em dias
        long diff = checkout.getTime() - checkin.getTime(); // Calcula a diferença em milissegundos entre as datas de check-out e check-in
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Converte a diferença de milissegundos para dias e retorna o valor
    }

    public void updateDates(Date checkin, Date checkout) { // Método para atualizar as datas de check-in e check-out da reserva
        this.checkin = checkin; // Define o valor da variável de instância checkin com o novo valor passado como argumento
        this.checkout = checkout; // Define o valor da variável de instância checkout com o novo valor passado como argumento
    }

    @Override // Indica que o método toString() está sendo sobrescrito da classe Object
    public String toString() { // Método para retornar uma representação em String do objeto Reservation
        return "Room " + roomNumber + ", checkin: " + sdf.format(checkin) + ", checkout: " + sdf.format(checkout) + ", " + duration() + " nights"; // Retorna uma string formatada com os detalhes da reserva
    }
}