/*
 * Quart exercici IT ACADEMY
 * Xavi Gonzalez JAVA-1
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuartExerciciApp {

	public static void main(String[] args) {


		/*----------
		-- FASE 1 --
		----------*/
		System.out.println(" Fase 1:");
		
		// Creeu una variable int per cada un dels bitllets que existeixen des de 5€ a 500€, 
		// haureu de crear un altre variable per guardar el preu total del menjar. 
		int billete5 = 5;
		int billete10 = 10;
		int billete20 = 20;
		int billete50 = 50;
		int billete100 = 100;
		int billete200 = 200;
		int billete500 = 500;
		
		// Creeu dos arrays, un on guardarem el menú i un altre on guardarem el preu de cada plat. 
		String[] menu = new String[5];
		int [] preu_plat = new int[5];

		System.out.println("Arrays de menú i preus creats");

		
		/*----------
		-- FASE 2 --
		----------*/
		System.out.println(" \n Fase 2:");
		
		// Amb un bucle for haurem d’omplir els dos arrays anteriorment creats. 
		// Afegirem el nom del plat i després el preu. Pots fer us de diccionaris de dades(Java HasMap)
		
		
		/*
		menu[0]= "Sopa";
		menu[1]= "Paella";
		menu[2]= "Fideos";
		menu[3]= "Ensalada";
		menu[4]= "Hummus";
		
		preu_plat[0]= 15;
		preu_plat[1]= 25;
		preu_plat[2]= 35;
		preu_plat[3]= 45;
		preu_plat[4]= 55;
		*/
		
		Scanner menu_in = new Scanner(System.in);		
		
		for(int i=0 ; i<menu.length; i++) {
			
			System.out.println("Plat nº"+(i+1));
			menu[i]= menu_in.next();
			
			while(true) {
				
				System.out.println("Preu plat nº"+(i+1));
				
				try {
					preu_plat[i]= menu_in.nextInt();
					break;
				
				}catch (Exception e){
					menu_in.next();
					System.out.println("El preu ha de ser un numero, torna a posar-lo");
			
				}
			}
			
		}
		
		System.out.println("Este es el menú:");
		
		for(int i=0 ; i<menu.length; i++) {
			
			System.out.println(" - " +menu[i] + ": " + preu_plat[i] + "€");
			
		}
		
		// Un cop plens els dos arrays haurem de mostrar-los i preguntar que es vol per menjar, 
		// guardarem la informació en una List fent servir un bucle while.
		System.out.println("¿Que quieres para comer?");
		
		Scanner input = new Scanner(System.in);

		List<String> comanda = new ArrayList<String>();
		
		String plato = "";
		int mas_comida = 1;
		
		// Haurem de preguntar si es vol seguir demanant menjar. 
		// Podeu fer servir el sistema (1:Si / 0:No), per tant haureu de crear un altre variable int per guardar la informació.
		while (mas_comida != 0) {
			
			plato= input.next();
			
			comanda.add(plato);
			
			System.out.println("¿Quieres más comida? (1 = Sí / 0 = No)");
			
			mas_comida = input.nextInt();
			
			if (mas_comida == 1) {
				System.out.println("¿Qué plato?");
			}

		}
		
		/*----------
		-- FASE 3 --
		----------*/
		System.out.println(" \n Fase 3:");

		// Un cop hem acabat de demanar el menjar, haurem de comparar la llista amb l’array que hem fet al principi. 
		// En el cas que la informació que hem introduït a la List coincideixi amb la del array, haurem de sumar el preu del producte demanat; 
		// en el cas contrari haurem de mostrar un missatge que digui que el producte que hem demanat no existeix.
		
		int preu_total=0;
		int encontrado = 0;
		
		for (int i = 0; i < comanda.size(); i++) {
			
			encontrado = 0;
			
			for (int j= 0; j<menu.length; j++) {
				
				if(comanda.get(i).equalsIgnoreCase(menu[j])) {
					
					preu_total = preu_total + preu_plat[j];
					System.out.println("El plato -" + comanda.get(i) + "- se añade a la cuenta");
					encontrado = 1;
					break;
				} 
				
			}
			
			if (encontrado == 0) {
			
				System.out.println("El plato -" + comanda.get(i) + "- NO existe");
				
			}
			
		}
		
		System.out.println("\n" + "La cuenta asciende a: " + preu_total + "€");
		
	}

}
