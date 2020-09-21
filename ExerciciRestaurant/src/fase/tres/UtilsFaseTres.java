package fase.tres;

import java.util.ArrayList;
import java.util.Map;

import fase.uno.UtilsFaseUno;

public class UtilsFaseTres {

	private ArrayList<String> pedidoFueraDeMenu = new ArrayList<String>();
	private ArrayList<String> pedidoComida = new ArrayList<String>();
	private UtilsFaseUno utilsFase1;

	public UtilsFaseTres(UtilsFaseUno utilsFase1, ArrayList<String> pedidoComida) {
		this.pedidoComida = pedidoComida;
		this.utilsFase1=utilsFase1;
	}

	public UtilsFaseUno getUtilsFase1() {
		return utilsFase1;
	}

	public void setUtilsFase1(UtilsFaseUno utilsFase1) {
		this.utilsFase1 = utilsFase1;
	}

	public ArrayList<String> getPedidoFueraDeMenu() {
		return pedidoFueraDeMenu;
	}

	public void setPedidoFueraDeMenu(ArrayList<String> pedidoFueraDeMenu) {
		this.pedidoFueraDeMenu = pedidoFueraDeMenu;
	}

	public ArrayList<String> getPedidoComida() {
		return pedidoComida;
	}

	public void setpedidoComida(ArrayList<String> pedidoComida) {
		this.pedidoComida = pedidoComida;
	}

	public void damePedidoComidaFueraDeMenu(ArrayList<String> pedidoComida, String[] menu) {

		for (String s : pedidoComida) {
			int cont = 0;
			for (int i = 0; i < menu.length; i++) {
				if (!s.toUpperCase().equals(menu[i].toUpperCase())) {
					cont++;
				}
			}
			if (cont == menu.length) {
				this.getPedidoFueraDeMenu().add(s);
			}
		}

		if (!this.getPedidoFueraDeMenu().isEmpty()) {
			System.out.println();
			System.out.println("-------------------------------------------------------------");
			for (String s : this.getPedidoFueraDeMenu()) {
				System.out.println("Ha pedido: " + s.toUpperCase() + ". Este producto no existe en el menu");
			}
			System.out.println("-------------------------------------------------------------");
		}

	}

	public void printTicket(Map<String, Double> menuPrecio, ArrayList<String> pedidoComida,UtilsFaseUno utilsFase1) {
		double precioTotal = 0;

		System.out.println("------------------------------------");
		System.out.println("Ticket");
		System.out.println("------------------------------------");

		for (String s : this.getPedidoComida()) {
			for (Map.Entry<String, Double> entrada : menuPrecio.entrySet()) {
				String plato = entrada.getKey();
				double precioPlato = entrada.getValue();
				if (s.equalsIgnoreCase(plato)) {
					System.out.println(plato.toUpperCase() + ": " + String.format("%.2f", precioPlato) + " euros");
					precioTotal += precioPlato;
					break;
				}
			}
		}

		utilsFase1.setPrecioTotal(precioTotal);

		System.out.println("\nTotal a pagar: " + String.format("%.2f", utilsFase1.getPrecioTotal()) + " euros\n");

		if (utilsFase1.getPrecioTotal() > 0) {
			desglosarEnBilletesPrecioTotalTicket(utilsFase1);
		}

		damePedidoComidaFueraDeMenu(this.getPedidoComida(), utilsFase1.getMenuArray());

	}

	public void desglosarEnBilletesPrecioTotalTicket(UtilsFaseUno utilsFase1) {
		int contBilletes5 = 0, contBilletes10 = 0, contBilletes20 = 0, contBilletes50 = 0, contBilletes100 = 0,
				contBilletes200 = 0, contBilletes500 = 0;
		double totalTicket = utilsFase1.getPrecioTotal();

		System.out.println("-----------------------");
		System.out.println("Opcion de pago:");
		System.out.println("-----------------------");

		totalTicket = desglosandoEnBilletes(totalTicket, utilsFase1.getBillete500(), contBilletes500);
		totalTicket = desglosandoEnBilletes(totalTicket, utilsFase1.getBillete200(), contBilletes200);
		totalTicket = desglosandoEnBilletes(totalTicket, utilsFase1.getBillete100(), contBilletes100);
		totalTicket = desglosandoEnBilletes(totalTicket, utilsFase1.getBillete50(), contBilletes50);
		totalTicket = desglosandoEnBilletes(totalTicket, utilsFase1.getBillete20(), contBilletes20);
		totalTicket = desglosandoEnBilletes(totalTicket, utilsFase1.getBillete10(), contBilletes10);
		totalTicket = desglosandoEnBilletes(totalTicket, utilsFase1.getBillete5(), contBilletes5);

	}

	public double desglosandoEnBilletes(double totalTicket, int billeteDeDesglose, int contBilletes) {
		contBilletes = (int) (totalTicket - totalTicket % billeteDeDesglose) / billeteDeDesglose;
		if (contBilletes > 0) {
			System.out.println("Billetes de " + billeteDeDesglose + " euros: " + contBilletes);
			totalTicket -= billeteDeDesglose * contBilletes;
		}
		return totalTicket;
	}

}
