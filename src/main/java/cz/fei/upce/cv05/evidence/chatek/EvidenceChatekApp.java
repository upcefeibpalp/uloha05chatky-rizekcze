package cz.fei.upce.cv05.evidence.chatek;

import java.util.Scanner;

public class EvidenceChatekApp {

    static final int KONEC_PROGRAMU = 0;
    static final int VYPIS_CHATEK = 1;
    static final int VYPIS_KONKRETNI_CHATKU = 2;
    static final int PRIDANI_NAVSTEVNIKU = 3;
    static final int ODEBRANI_NAVSTEVNIKU = 4;
    static final int CELKOVA_OBSAZENOST = 5;
    static final int VYPIS_PRAZDNE_CHATKY = 6;

    static final int VELIKOST_KEMPU = 10;
    static final int MAX_VELIKOST_CHATKY = 4;
    static Scanner scanner = new Scanner(System.in);
    static int[] chatky = new int[VELIKOST_KEMPU];
    static int operace;

    public static void main(String[] args) {
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

            System.out.print("Zadej volbu: ");
            operace = scanner.nextInt();

            switch (operace) {
                case VYPIS_CHATEK -> {
                    vypisChatek();
                }
                case VYPIS_KONKRETNI_CHATKU -> {
                    if (VypisKonkretnichatky()) {
                        continue;
                    }
                }
                case PRIDANI_NAVSTEVNIKU -> {
                    if (pridaniNavstevniku()) {
                        continue;
                    }
                }
                case ODEBRANI_NAVSTEVNIKU -> {

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

    private static void vypisChatek() {
        // Projdi cele pole od <0, VELIKOST) a vypis kazdy index
        for (int i = 0; i < chatky.length; i++) {
            System.out.println("Chatka [" + (i + 1) + "] = " + chatky[i]);
        }
    }

    private static boolean VypisKonkretnichatky() {
        int cisloChatky = zadejCisloChatky();
        if (kontrolaCislaChatky(cisloChatky)) {
            return true;
        }
        System.out.println("Chatka [" + (cisloChatky + 1) + "] = " + chatky[cisloChatky]);
        return false;
    }

    private static boolean pridaniNavstevniku() {
        int cisloChatky = zadejCisloChatky();
        if (kontrolaCislaChatky(cisloChatky) == false) {
            System.err.println("Neplatna hodnota pro pocet navstevniku");
        }
        int pocetNavstevniku = zadejPocetNavstevniku();
        if (kontrolaMAXpoctuNavstevnikuVChatce(pocetNavstevniku)) {
            return true;
        }
        return vlozNavstevnikydoChatky(cisloChatky, pocetNavstevniku);
    }

    private static boolean vlozNavstevnikydoChatky(int cisloChatky, int pocetNavstevniku) {
        if ((chatky[cisloChatky] + pocetNavstevniku) > MAX_VELIKOST_CHATKY) {
            System.err.println("Prekrocen maximalni pocet navstevniku chatky");
            return true; // Zacni novou iteraci cyklu
        }
        // Pridej nove ubytovane do chatky k tem co uz tam jsou
        chatky[cisloChatky] = pocetNavstevniku + chatky[cisloChatky];
        return false;
    }

    private static boolean kontrolaMAXpoctuNavstevnikuVChatce(int pocet) {
        return !(pocet <= 0 || pocet > MAX_VELIKOST_CHATKY);
        //
    }

    private static int zadejPocetNavstevniku() {
        // Ziskani poctu navstevniku, kteri se chteji v chatce ubytovat
        System.out.print("Zadej pocet navstevniku: ");
        int pocetNavstevniku = scanner.nextInt();
        return pocetNavstevniku;
    }

    private static boolean kontrolaCislaChatky(int cisloChatky) {
        // Zaporne nebo cislo vetsi nez je pocet chatek je nevalidni vstup
        if (cisloChatky < 0 || cisloChatky >= chatky.length) {
            System.err.println("Tato chatka neexistuje");
            return true; // Zacni novou iteraci cyklu
        }
        return (0 < cisloChatky && cisloChatky < VELIKOST_KEMPU);
    }

    private static int zadejCisloChatky() {
        System.out.print("Zadej cislo chatky: ");
        int cisloChatky = scanner.nextInt();
        return cisloChatky;
    }

}
