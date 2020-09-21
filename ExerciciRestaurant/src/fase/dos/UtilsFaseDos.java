package fase.dos;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class UtilsFaseDos {

	private Map<String, Double> precioMenuHashMap = new LinkedHashMap<String, Double>();
	private ArrayList<String> pedidoComidaList = new ArrayList<String>();

	public UtilsFaseDos() {
	}

	public Map<String, Double> getPrecioMenuHashMap() {
		return precioMenuHashMap;
	}

	public void setPrecioMenuHashMap(Map<String, Double> precioMenuHashMap) {
		this.precioMenuHashMap = precioMenuHashMap;
	}

	public ArrayList<String> getPedidoComidaList() {
		return pedidoComidaList;
	}

	public void setPedidoComidaList(ArrayList<String> pedidoComidaList) {
		this.pedidoComidaList = pedidoComidaList;
	}

	public void getPrecioPlato(String[] menu, double precioPlato[]) {
		
		for (int i = 0; i < precioPlato.length; i++) {
			this.getPrecioMenuHashMap().put(menu[i], precioPlato[i]);
		}
	}

	public void printMenu() {
		System.out.println("------------------------------------");
		System.out.println("Menu");
		System.out.println("------------------------------------");

		for (Map.Entry<String, Double> entrada : precioMenuHashMap.entrySet()) {
			String plato = entrada.getKey();
			Double precio = entrada.getValue();

			System.out.println(plato + " -> " + String.format("%.2f", precio) + " euros");

		}
		System.out.println("------------------------------------");
	}

	@Override
	public String toString() {
		return "MenuPrecio=" + precioMenuHashMap;
	}

}
