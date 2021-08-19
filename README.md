Súbory z foldra "CT":\

# Špecifikácia zadania

Naprogramujte v programovacom jazyku Java aplikáciu podľa nasledovných bodov:

* Každý študent dostane **4** správy (texty **ZT1, ZT2, ZT3, ZT4**), ktoré obsahujú v sebe zmysluplný textu ukrytý pomocou steganografie. Pri vytváraní boli použité rôzne spôsoby steganografie (null-cipher). Prvá úloha **je nájdenie všetkých 4 správ**. Treba automatizovane vyskúšať rôzne možnosti Steganografie (napr pomocou hrubej sily) a následne pomocou ohodnotenia textu nájsť **4 správne riešenia**. Na ohodnotenie textov použite **slovník**. Odporúčam použiť slovník, ktorý má aspoň 10000 slov. Pôvodné texty sú v **EN** jazyku.
* Následne dostanete jednu správu **ZT5**, ktorá bola zašifrovaná **Vigenerovou** šifrou S (s periodicky sa opakujúcim heslom) a **transpozíciou**  T (preskupenie písmen pomocou číselného hesla) v poradí TS (dešifrovať treba v poradí ST). Heslo k Vigenerovej šifre bolo vytvorené tak, že sa zobralo prvé písmeno z každého textu z predošlého bodu v poradí (k=OT1.charAt(0)+OT2.charAt(0)+OT3.charAt(0)+0T4.charAt(0)). V prípade, že úspešne nájdete 4 pôvodné texty z prechádzajúcej úlohy, tak po dešifrovaní ZT kľúčom **k** dostanete text, ktorý bol šifrovaný transpozíciou s heslom dľžky **8**. Úlohou je získať pôvodný otvorený text **OT5 plne automatizovaným spôsobom** (nie je bližšie špecifikované, že akú techniku máte použiť). V prípade, že neviete správne nájsť všetky texty z predch. úlohy, tak táto časť je ťažšia.

Pozn.: Pred menov v súbore "**priradeneZT.xlsx**" máte **ID**. Na základe toho **ID** si zoberte súbor "**<ID>_CT.txt**" z foldra "**CT**". Každý súbor obsahuje **5** zašifrovaných správ, ktoré máte vylúštiť podľa zadania.



Edit 13.12.2020:  poradie pri šifrovaní je Transpozicia  a potom Vigenere, dešifrovať treba najprv Vigenere a následne Transpozíciu.

## Popis použitých steganografických techník:

Texty ZT1 až ZT4 boly vytvorené s použitím uvedených metód. Vstupom metód je otvorený text X = x_0, x_1, ... x_{n-1}., kde |X| = n. Minimálna dĺžka |X| je 50.

   1. Pre každý **x_i** sa vytvorí sa blok velkosti **m** (2 < m < 8). Do bloku sa vložia náhodné znaky z TSA a na index  **p** (0 <= p < m) sa vloží znak **x_i**. Takto postupujeme pre každý znak. Na konci sa text rozdelí medzerou na bloky dĺžky **b**. Hodnoty **m, p** a **b** sa nastavia na začiatku. 
   2. Ako prvý bod, ale text je pred vložením napísaný od konca ako  X' = x_{n-1}, x_{n-2}, ..., x_0. Po prečítaní  X' zo ZT dostaneme pôvodnú správu X tak, že zmeníme poradie znakov.
   3. Pre každý **x_i** sa vytvorí blok velkosti **m** (2 < m < 8). Hodnota **m** sa nastaví na začiatku. Do bloku sa vložia náhodné znaky z TSA a na index **0** sa vloží znak **x_0**. Vygeneruje sa nový blok pre ďalší znak, kde na index **1** sa vloží znak **x_1**, atď. až kým **x_{m-1}** sa vloží do nového bloku na index **m-1**. Potom začneme zase s indexom **0** pre znak **x_{m}**. Formálne je teda index pre x_i práve **i mod m**. Takto postupujeme ďalej. Na konci sa text rozdelí medzerou na bloky dĺžky **b**. Hodnota **b** sa nastaví na začiatku. 
   4. Zoberie sa slovník W. Pre každý **x_i** so nájde v slovníku slovo **w** so začiatočným písmenom x_i. Písmeno x_i sa nahradí slovom **w** a pridá sa medzera.


## Projekt:

V prílohe sú zdrojové kódy, ktoré reprezentujú kostru projektu (je to celý priečinok src). Všetky zdrojové súbory musia byť súčastou tohto priečinku (teraz vrátane slovníka a iných vstupovov). 

Prvú úlohu naimplementujte do triedy ***NullCipherAnalyser***. 


Druhú úlohu naimplementujte do triedy ***CombinedCipherAnalyser***. 

V prípade, že potrebujete ďalšie pomocné triedy, tak ich vytvorte jedine v balíku **zadanie2.vlastne**, v ktorom sa nachádza aj trieda ***NullCipherAnalyser*** a ***CombinedCipherAnalyser***. Pri opravovani nahrám obsah balíka **zadanie2.vlastne** (priečinka zadanie2/vlastne)  k sebe do projektu. Čo budete mať inde ignorujem. Obsah balíka **zadanie2.nemenit** nemáte odovzdať, tu použijem vlastné triedy. 

Odovzdáte teda do AIS len jeden priečinok, a to priečinok **vlastne**, ktorý obsahuje .java súbory z balíku **zadanie2.vlastne** (+ iné vstupy ako napr. slovník). Je to priečinok ***src/zadanie2/vlastne***.

Ukážka ako bude prebiehať volanie uvedených tried a zárovaň aj samotné hodnotenie máte v triedach **Main** a **Evaluator**.

Edit 11.12.2020: Premenná *result* bol zmenený na *public* v *CipherAnalyser*. Dá sa k nemu pristupovať z iného balíka. V triede *Evaluator* bola opravená jedna chyba.

## Hodnotenie:

* 8b+2b - (4x 2b) za správne "vylúštenie" (nájdenie) pôvodných nešifrovaných správ zo ZT1, ZT2, ZT3 a ZT4, za každý text 2b. (+2b ako bonus) v prípade, že sa podarí správne nájsť všeky texty.
* 7b - za správne vylúštenie ZT5.

Posledná zmena: Sunday, 13 December 2020, 22:10
