import java.lang.reflect.Field;
import java.util.Scanner;

public class Tools {


    private Tools() {
    }

    public static Conta start() {
        Conta c = new Conta();
        Field[] campos = c.getClass().getDeclaredFields();
        Scanner sc = new Scanner(System.in);

        System.out.println(" Vamos criar uma nova conta!");
        for (Field campo : campos) {
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.print("Entre com o(a) " + campo.getName() + " da conta: ");
                    switch (campo.getName()) {
                        case "Numero" -> c.setNumero(sc.nextInt());
                        case "Agencia" -> c.setAgencia(sc.next());
                        case "Nome" -> {
                            sc.nextLine();
                            c.setNome(sc.nextLine());
                        }
                        case "Saldo" -> c.setSaldo(sc.nextDouble());
                    }
                    entradaValida = true;
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                    System.out.println("Por favor, tente novamente. \n");
                    sc.nextLine();
                }
            }
        }

        return c;
    }

    public static void print(Conta c) {
        System.out.println("Olá "+c.getNome()+", obrigado por criar uma conta em nosso banco," +
                " sua agência é "+ c.getAgencia()+"," +
                " conta "+c.getNumero()+" e seu saldo "+c.getSaldo()+
                " já está disponível para saque\".");
    }
}