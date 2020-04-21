import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		double xN, r, seed;
		ArrayList<ArrayList<Double>> myArray = new ArrayList<ArrayList<Double>>();
		ArrayList<Double> myDoubles = new ArrayList<Double>();
		
		seed = 0.1;
		xN = 0;
		r = 0.0;
		
		for (int i = 0 ; i < 19; i++) {
			seed += 0.05;
			xN = seed;
			ArrayList<Double> tempArray = new ArrayList<Double>();
			
			
		for (double j = 1 ; j < 1010 ; j++) {
			tempArray.add(xN);
			tempArray.add(j);
			xN = 4*r*xN*(1-xN);
			
		}
		
		myArray.add(tempArray);
		
		
		}
		
		for (int i = 1 ; i < 20 ; i++) {
		salvarArquivo(myArray.get(i-1), "F:\\dataoutput\\meuspontos" + i + ".txt");
		}
			
		/*for (int k = 0 ; k < 16 ; k++) {
			
			r = 0.86;
		
		for (int i = 0 ; i < 100; i++) {
			xN = seed;
			ArrayList<Double> tempArray = new ArrayList<Double>();
			
			
		for (double j = 0 ; j < 1000 ; j++) {
			xN = 4*r*xN*(1-xN);
		}
		
		myDoubles.add(xN);
		myDoubles.add(r);
		
		
		r += 0.001;
		}
		seed += seed +0.05;
		}*/
		
		salvarArquivo(myDoubles, "F:\\dataoutput\\meuspontos" + ".txt");
		
	}
	
	private static int salvarArquivo(ArrayList<Double> meusPontos, String localArquivoSaida) {

		String stringTemp = "Inicialização de variável.";
		String stringFinal = "Inicialização de variável.";
		StringBuilder stringBuilder = new StringBuilder();
		int k = 0;

		for (Double i: meusPontos){
		stringTemp = i.toString() + "\t";
		stringBuilder.append(stringTemp);
		k++;

		if (k==2) {
			stringBuilder.append(System.getProperty("line.separator"));
			k = 0;
		}

		}


		stringFinal = stringBuilder.toString();
		System.out.println(stringFinal);



		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					localArquivoSaida));

			writer.write(stringFinal);

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("O arquivo não foi salvo!");
		}

		return 0;

	}

}
