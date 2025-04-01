//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main 
class Esercizio {

    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i;

        System.out.println("Inserire il numero di elementi del vettore");
        n = Integer.parseInt(input.nextLine()); 
        int[] r = new int[n];
        int[] v = new int[n];

        // Caricamento del vettore con numeri casuali.
        for (i = 0; i <n; i++) {
            r[i] = random.nextInt(n * 10 + 1);
        }
        System.out.println("Valori generati:");
        visualizza(r);

        // Conservo la copia originale del vettore perchè dovrò ordinarlo più volte per confrontare i metodi di ordinamento.
        System.arraycopy(r, 0, v, 0, r.length);

        // Ordinamento del vettore
        System.out.println("ORDINAMENTO NON OTTIMIZZATO:");
        bubbleSortNonOttimizzato(v);
        System.out.println("Valori ordinati:");
        visualizza(v);

        // Ordinamento ottimizzato sulla scansione
        System.out.println("ORDINAMENTO OTTIMIZZATO sulla scansione:");
        System.arraycopy(r, 0, v, 0, r.length);

        bubbleSortOttimScan(v);
        System.out.println("Valori ordinati:");
        visualizza(v);

        // Ordinamento ottimizzato
        System.out.println("ORDINAMENTO OTTIMIZZATO:");
        System.arraycopy(r, 0, v, 0, r.length);

        bubbleSortOttimizzato(v);
        System.out.println("Valori ordinati:");
        visualizza(v);
    }
    
    public static void bubbleSortNonOttimizzato(int[] v) {
        int n = v.length;
        int i, j, cont, t;

        cont = 0;
        i = 0;
        while (i <= n - 1) {
            j = 0;
            while (j <= n - 2) {
                cont = cont + 1;
                if (v[j] > v[j + 1]) {
                    t = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = t;
                }
                j = j + 1;
            }
            i = i + 1;
        }
        System.out.println("Controlli effettuati: " + cont);
    }
    
    public static void bubbleSortOttimScan(int[] v) {
        int i, j, cont, t;
        int n = v.length;

        cont = 0;
        i = 0;
        while (i <= n - 1) {
            j = 0;

            // Sono sicuro che al passo i, gli i elementi maggiori sono al loro posto. Quindi evito di controllarli fermando prima la scansione.
            while (j <= n - 2 - i) {
                cont = cont + 1;
                if (v[j] > v[j + 1]) {
                    t = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = t;
                }
                j = j + 1;
            }
            i = i + 1;
        }
        System.out.println("Controlli effettuati: " + cont);
    }
    
    public static void bubbleSortOttimizzato(int[] v) {
        int i, j, cont, t;
        boolean scambio;
        int n = v.length;

        cont = 0;
        i = 0;
        scambio = true;

        // se durante la scansione non effettuo scambi, allora il vettore è già ordinato, quindi non serve fare ulteriori passaggi.
        while (i <= n - 1 && scambio) {
            scambio = false;
            j = 0;

            // Sono sicuro che al passo i, gli i elementi maggiori sono al loro posto. Quindi evito di controllarli fermando prima la scansione.
            while (j <= n - 2 - i) {
                cont = cont + 1;
                if (v[j] > v[j + 1]) {
                    t = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = t;
                    scambio = true;
                }
                j = j + 1;
            }
            i = i + 1;
        }
        System.out.println("Controlli effettuati: " + cont);
    }
        
    public static void visualizza(int[] v) {
        int i;
        int n = v.length;

        i = 0;
        while (i <= n - 1) {
            System.out.println(Integer.toString(i) + ": " + v[i]);
            i = i + 1;
        }
    }
}
