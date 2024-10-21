package cz.fei.upce.cv05.evidence.chatek;

import java.util.Scanner;

public class EvidenceChatekApp {

    public static void main(String[] args) {
        // Konstanty pro definovani jednotlivych operaci (pouze pro cisty kod)
        final int KONEC_PROGRAMU = 0;
        final int VYPIS_CHATEK = 1;
        final int VYPIS_KONKRETNI_CHATKU = 2;
        final int PRIDANI_NAVSTEVNIKU = 3;
        final int ODEBRANI_NAVSTEVNIKU = 4;
        final int CELKOVA_OBSAZENOST = 5;
        final int VYPIS_PRAZDNE_CHATKY = 6;

        final int VELIKOST_KEMPU = 5;
        final int MAX_VELIKOST_CHATKY = 10;

        Scanner scanner = new Scanner(System.in);

        // Definovani pole podle velikosti kempu (poctu chatek)
        int[] chatky = new int[VELIKOST_KEMPU];
        int operace;

        do {
            System.out.println("""
                    MENU:
                                        
                    1 - vypsani vsech chatek
                    2 - vypsani konkretni chatky
                    3 - Pridani navstevniku
                    4 - Odebrani navstevniku
                    5 - Celkova obsazenost kempu
                    6 - Vypis prazdne chatky
                    0 - Konec programu
                    """);

            // Ziskani operace od uzivatele
            System.out.print("Zadej volbu: ");
            operace = scanner.nextInt();

            switch (operace) {
                case VYPIS_CHATEK -> {

                    // Projdi cele pole od <0, VELIKOST) a vypis kazdy index
                    for (int i = 0; i < chatky.length; i++) {
                        System.out.println("Chatka [" + (i + 1) + "] = " + chatky[i]);
                    }
                }

                case VYPIS_KONKRETNI_CHATKU -> {

                    // Ziskani cisla chatky od uzivatele
                    System.out.print("Zadej cislo chatky: ");
                    // Odecteni 1 protoze uzivatel cisluje chatky o 1, ale program od 0
                    int cisloChatky = scanner.nextInt() - 1;

                    // Zaporne nebo cislo vetsi nez je pocet chatek je nevalidni vstup
                    if (cisloChatky < 0 || cisloChatky >= chatky.length) {
                        System.err.println("Tato chatka neexistuje");
                        continue; // Zacni novou iteraci cyklu
                    }

                    System.out.println("Chatka [" + (cisloChatky + 1) + "] = " + chatky[cisloChatky]);
                }

                case PRIDANI_NAVSTEVNIKU -> {

                    // Ziskani cisla chatky od uzivatele
                    System.out.print("Zadej cislo chatky: ");
                    // Odecteni 1 protoze uzivatel cisluje chatky o 1, ale program od 0
                    int cisloChatky = scanner.nextInt() - 1;

                    // Zaporne nebo cislo vetsi nez je pocet chatek je nevalidni vstup
                    if (cisloChatky < 0 || cisloChatky >= chatky.length) {
                        System.err.println("Tato chatka neexistuje");
                        continue; // Zacni novou iteraci cyklu
                    }

                    // Ziskani poctu navstevniku, kteri se chteji v chatce ubytovat
                    System.out.print("Zadej pocet navstevniku: ");
                    int pocetNavstevniku = scanner.nextInt();

                    // Zaporne cislo nebo prilis velky nevalidni vstup
                    if (pocetNavstevniku <= 0 || pocetNavstevniku > MAX_VELIKOST_CHATKY) {
                        System.err.println("Neplatna hodnota pro pocet navstevniku");
                        continue; // Zacni novou iteraci cyklu
                    }

                    // Pokud je pocet uz ubytovanych plus ty co se chteji ubytovat vetsi nez kapacita chatky je to nevalidni vstup
                    if ((chatky[cisloChatky] + pocetNavstevniku) > MAX_VELIKOST_CHATKY) {
                        System.err.println("Prekrocen maximalni pocet navstevniku chatky");
                        continue; // Zacni novou iteraci cyklu
                    }

                    // Pridej nove ubytovane do chatky k tem co uz tam jsou
                    chatky[cisloChatky] = pocetNavstevniku + chatky[cisloChatky];
                }

                case ODEBRANI_NAVSTEVNIKU -> {
                    // TODO
                }

                case CELKOVA_OBSAZENOST -> {
                    // TODO
                }

                case VYPIS_PRAZDNE_CHATKY -> {
                    // TODO
                }

                case KONEC_PROGRAMU -> {
                    System.out.println("Konec programu");
                }

                default -> {
                    System.err.println("Neplatna volba");
                }
            }
        } while (operace != 0);
    }
}
