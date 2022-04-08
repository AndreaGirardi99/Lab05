package model;

import java.util.HashSet;
import java.util.Set;

public class Anagrammi {
	public Set<String> anagramma(String s) {
		Set<String> anagrammi = new HashSet<String>();
		anagramma_ricorsiva("", 0, s, anagrammi);
		return anagrammi;
	}

	private void anagramma_ricorsiva(String parziale, int livello, String rimanenti, Set<String> anagrammi) {
		if (rimanenti.length() == 0) {
			anagrammi.add(parziale);
			return;
		} else {
			for (int pos = 0; pos < rimanenti.length(); pos++) {
				String nuova_parziale = parziale + rimanenti.charAt(pos);
				String nuova_rimanenti = rimanenti.substring(0, pos) + rimanenti.substring(pos + 1);
				anagramma_ricorsiva(nuova_parziale, livello + 1, nuova_rimanenti, anagrammi);
			}
		}
	}

}
