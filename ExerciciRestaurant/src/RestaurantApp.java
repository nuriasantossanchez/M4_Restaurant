import java.util.ArrayList;
import java.util.Scanner;

import fase.dos.UtilsFaseDos;
import fase.tres.UtilsFaseTres;
import fase.uno.UtilsFaseUno;

public class RestaurantApp {

	public static void main(String[] args) {
		
		System.out.println("\n======================= Fase 1 =======================\n");
		
		UtilsFaseUno utilsFase1 = new UtilsFaseUno();
		System.out.println(utilsFase1.toString());
		
		System.out.println("\n======================= Fase 2 =======================\n");
		
		UtilsFaseDos utilsFase2 = new UtilsFaseDos();
		utilsFase2.getPrecioPlato(utilsFase1.getMenuArray(), utilsFase1.getPrecioPlatoArray());
		System.out.println(utilsFase2.toString());
		
		utilsFase2.printMenu();
		
		Scanner consoleIn = new Scanner(System.in);
		ArrayList<String> pedido = new ArrayList<String>();
		try {
			pedido = pedirComida(consoleIn,pedido);
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.getMessage();
			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("-----------");
			utilsFase2.setPedidoComidaList(pedido);
			System.out.println("Su pedido: " + utilsFase2.getPedidoComidaList().toString());
			System.out.println("-----------");

		}

		System.out.println("\n======================= Fase 3 =======================\n");
		
		UtilsFaseTres utilsFase3 = new UtilsFaseTres(utilsFase1, utilsFase2.getPedidoComidaList());
		utilsFase3.printTicket(utilsFase2.getPrecioMenuHashMap(), utilsFase3.getPedidoComida(), utilsFase3.getUtilsFase1());
		
	}

	@SuppressWarnings("finally")
	public static ArrayList<String> pedirComida(Scanner consoleIn, ArrayList<String> pedido) throws NumberFormatException, EntradaDeDatosEnBlancoException{
		int opcionMasComida=0;
		String plato;
		
		try {
			System.out.println("Que quiere comer?");
			plato = consoleIn.nextLine();

			if (plato.trim().isEmpty()) {
				throw new EntradaDeDatosEnBlancoException(
						"Entrada de datos por consola son blancos o es un salto de l�nea");
			} else {
				pedido.add(plato);

				System.out.println("Quiere comer algo mas? (1:Si / 0:No)");
				opcionMasComida = Integer.parseInt(consoleIn.nextLine());
				while (opcionMasComida != 1 && opcionMasComida != 0) {
					System.out.println("La opcion introducida no es correcta");
					System.out.println("Quiere comer algo mas? (1:Si / 0:No)");
					opcionMasComida = Integer.parseInt(consoleIn.nextLine());
				}
				
				if (opcionMasComida != 0) {
					pedirComida(consoleIn, pedido);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("La opcion introducida no es un numero. Introduzca un numero, por favor");
			System.out.println("Quiere comer algo mas? (1:Si / 0:No)");
			
			opcionMasComida = Integer.parseInt(consoleIn.nextLine());
	
			while (opcionMasComida != 1 && opcionMasComida != 0) {
				System.out.println("La opcion introducida no es correcta");
				System.out.println("Quiere comer algo mas? (1:Si / 0:No)");
				opcionMasComida = Integer.parseInt(consoleIn.nextLine());
			}

			if (opcionMasComida != 0) {
				pedirComida(consoleIn, pedido);
			}
		} catch (EntradaDeDatosEnBlancoException e) {
			System.out.println("No ha introducido nada para comer");
			pedirComida(consoleIn, pedido);
		} catch (Exception e) {
			System.out.println("Error inesperado en pedirComida(Scanner consoleIn, ArrayList<String> pedido)");
			e.getMessage();
			e.printStackTrace();
		} finally {
			return pedido;
		}
	}

}

class EntradaDeDatosEnBlancoException extends Exception {

	private static final long serialVersionUID = 1L;

	public EntradaDeDatosEnBlancoException() {
		
	}
	
	public EntradaDeDatosEnBlancoException(String errorMessage) {
		
		super(errorMessage);
	}
	
}