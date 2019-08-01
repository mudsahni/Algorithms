

public class findGene {
    public String findGeneSimple(String dna) {

        String upper = dna.toUpperCase();
        String lower = dna.toLowerCase();

        String start = "ATG";
        String stop = "TAA";

        if(lower == dna){
            start = "atg";
            stop = "taa";
        }

        String result = "";

        int startIndex = dna.indexOf(start);
        if(startIndex == -1) //no ATG
        {
            return "";
        }
        int stopIndex = dna.indexOf(stop, startIndex+3);
        if(stopIndex == -1) //no TAA
        {
            return "";
        }

        int difference = stopIndex - startIndex;
        if (difference % 3 == 0) {
            result = dna.substring(startIndex, stopIndex + 3);
        }
        else {
            result = "";
        }
        return result;
    }

    public boolean twoOccurrences(String dna, String find) {
        int first = dna.indexOf(find);
        int last = dna.lastIndexOf(find);
        if(first == last){
            return false;
        }
        else {
            return true;
        }
    }

    public String lastPart(String dna, String find) {
        int first = dna.indexOf(find);
        if(first != -1) {
            int start = first + find.length();
            int stop = dna.length();
            return dna.substring(start, stop);
        }
        else {
            return dna;
        }
    }

    public void testLastPart() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String ans = lastPart(dna, "ATG");
        System.out.println("Last part of gene: " + ans);

        dna = "ATGTAA";
        System.out.println("DNA strand is " + dna);
        ans = lastPart(dna, "Q");
        System.out.println("Last part of gene: " + ans);

    }

    public void testFindGeneSimple() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "ATGTAA";
        dna = dna.toLowerCase();
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "ATGTGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "TTATAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);


    }

    public void testTwoOccurrences() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        boolean ans = twoOccurrences(dna, "ATG");
        System.out.println("Gene has two occurrences: " + ans);

        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        ans = twoOccurrences(dna, "AATG");
        System.out.println("Gene has two occurrences: " + ans);

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        ans = twoOccurrences(dna, "ATC");
        System.out.println("Gene has two occurrences: " + ans);

        dna = "ATGTAA";
        dna = dna.toLowerCase();
        System.out.println("DNA strand is " + dna);
        ans = twoOccurrences(dna, "a");
        System.out.println("Gene has two occurrences: " + ans);

    }

    public static void main(String[] args) {
        findGene fG = new findGene();
        fG.testFindGeneSimple();
        fG.testTwoOccurrences();
        fG.testLastPart();
    }
}
