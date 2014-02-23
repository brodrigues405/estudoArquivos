package designPattern;

public class PadraoStrategy {
	
	public static void main(String[] args) {
		
		Calculadora c = new Subtracao();
		
		System.out.println(c.calcular(10, 2)); 
		
		
	}

}
