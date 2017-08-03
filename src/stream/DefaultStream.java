package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DefaultStream implements Stream{
	
	private CharSequence sequence;
	private int index;
	
	public DefaultStream(String stream) {
		sequence = stream.subSequence(0, stream.length());
		this.index = 0;
	}

	public char getNext() {
		return sequence.charAt(index++);
	}

	public boolean hasNext() {
		return index < sequence.length();
	}

	public static char firstChar(final Stream input){
		ArrayList<Character> caracteres = new ArrayList<Character>();
		while(input.hasNext())
			caracteres.add(input.getNext());
		
		if(caracteres.size() > 2){
			for (int index = 3; index < caracteres.size(); index++) {
				char atual = caracteres.get(index);
				if(contarIguais(caracteres, atual) == 1){
					char anterior = caracteres.get(index-1);
					char anterior_anterior = caracteres.get(index-2);
									
					if(ehVogal(atual) && ehConsoante(anterior) && ehVogal(anterior_anterior))
						return atual;
				}
			}
		}		
		return 0;
	}
	
	private static boolean ehVogal(char vogal){
		char[] vogais = {'A','E','I','O','U','a','e','i','o','u'};
		return Arrays.binarySearch(vogais,vogal) > -1;
	}
	
	private static boolean ehConsoante(char consoante){
		char[] consoantes = {'B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Y','Z','b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','x','y','w','z'};
		return Arrays.binarySearch(consoantes,consoante) > -1;
	}
	
	private static int contarIguais(Collection<Character> caracteres, Character caracter){
		int conta = 0;
		for(Character c : caracteres)
			if(c.equals(caracter))
				conta++;
		return conta;
	}
}
