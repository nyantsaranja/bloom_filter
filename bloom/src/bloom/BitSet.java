package bloom;

public class BitSet {

    private byte[] bfArray;

    public BitSet(int nbits) {

        // On calcule le nbre de byte necessaire dans le filtre
        int nBytes = (int) Math.ceil(1.0 * nbits/8);
        this.bfArray = new byte[nBytes];

        // On parcours le tableau en mettant chaque byte à 0
        for(int i=0; i<nBytes; i++){
            this.bfArray[i] = 0;
        }
    }

    public boolean get(int bitIndex) {

        // Retrouver l'index du byte qui contient le bit avec une division entière
        int i = bitIndex / 8;

        // Retrouver la position du bit dans le byte avec modulo
        int j = bitIndex % 8;

        return (this.bfArray[i] >> j & 1) == 1;
    }

    public void set(int bitIndex) {

        // Retrouver l'index du byte qui contient le bit avec une division entière
        int i = bitIndex / 8;

        // Retrouver la position du bit dans le byte avec modulo
        int j = bitIndex % 8;

        this.bfArray[i] |= (1 << j);
    }

    public void clear(int bitIndex) {

        // Retrouver l'index du byte qui contient le bit avec une division entière
        //
        int i = bitIndex / 8;

        // Retrouver la position du bit dans le byte avec modulo
        int j = bitIndex % 8;

        this.bfArray[i] &= (0 << j);
    }
}
