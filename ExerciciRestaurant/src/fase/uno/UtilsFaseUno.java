package fase.uno;

import java.util.Arrays;

public class UtilsFaseUno {
	
	private int billete5=5;
	private int billete10=10;
	private int billete20=20;
	private int billete50=50;
	private int billete100=100;
	private int billete200=200;
	private int billete500=500;
	private double precioTotal;
	
	private String [] menuArray = {"Agua","Pan","Paella","Fideua","Crema Verduras","Ensalada","Ensaladilla","Entrecot","Calamares","Rape","Pollo","Pizza Carbonara"};
	private double [] precioPlatoArray = new double[menuArray.length]; 
	
	public UtilsFaseUno() {
		addPrecioPlatoMenu();
	}

	public int getBillete5() {
		return billete5;
	}

	public void setBillete5(int billete5) {
		this.billete5 = billete5;
	}

	public int getBillete10() {
		return billete10;
	}

	public void setBillete10(int billete10) {
		this.billete10 = billete10;
	}

	public int getBillete20() {
		return billete20;
	}

	public void setBillete20(int billete20) {
		this.billete20 = billete20;
	}

	public int getBillete50() {
		return billete50;
	}

	public void setBillete50(int billete50) {
		this.billete50 = billete50;
	}

	public int getBillete100() {
		return billete100;
	}

	public void setBillete100(int billete100) {
		this.billete100 = billete100;
	}

	public int getBillete200() {
		return billete200;
	}

	public void setBillete200(int billete200) {
		this.billete200 = billete200;
	}

	public int getBillete500() {
		return billete500;
	}

	public void setBillete500(int billete500) {
		this.billete500 = billete500;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String[] getMenuArray() {
		return menuArray;
	}

	public void setMenuArray(String[] menuArray) {
		this.menuArray = menuArray;
	}

	public double[] getPrecioPlatoArray() {
		return precioPlatoArray;
	}

	public void setPrecioPlatoArray(double[] precioPlatoArray) {
		this.precioPlatoArray = precioPlatoArray;
	}

	public void addPrecioPlatoMenu() {
		String platoMemu;
		int j=0;
		
		for(int i=0;i<this.menuArray.length;i++) {
			platoMemu = this.menuArray[i];
			
			switch (platoMemu) {
			case "Agua":
				this.precioPlatoArray[j]=this.getBillete5();
				j++;
				break;
				
			case "Pan":
				this.precioPlatoArray[j]=this.getBillete10();
				j++;
				break;
				
			case "Paella":
				this.precioPlatoArray[j]=this.getBillete50();
				j++;
				break;
				
			case "Fideua":
				this.precioPlatoArray[j]=this.getBillete20()+this.getBillete20();
				j++;
				break;
				
			case "Crema Verduras":
				this.precioPlatoArray[j]=this.getBillete20()+this.getBillete10();
				j++;
				break;
				
			case "Ensalada":
				this.precioPlatoArray[j]=this.getBillete10();
				j++;
				break;
				
			case "Ensaladilla":
				this.precioPlatoArray[j]=this.getBillete20();
				j++;
				break;
				
			case "Entrecot":
				this.precioPlatoArray[j]=this.getBillete100();
				j++;
				break;
				
			case "Calamares":
				this.precioPlatoArray[j]=this.getBillete50()+this.getBillete10();
				j++;
				break;
				
			case "Rape":
				this.precioPlatoArray[j]=this.getBillete50()+this.getBillete20();
				j++;
				break;
				
			case "Pollo":
				this.precioPlatoArray[j]=this.getBillete5();
				j++;
				break;
				
			case "Pizza Carbonara":
				this.precioPlatoArray[j]=this.getBillete10()+this.getBillete5();
				j++;
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Menu=" + Arrays.toString(menuArray) + "\nPrecioPlatoMenu=" + Arrays.toString(precioPlatoArray);
	}
	
}
