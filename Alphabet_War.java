public class Alphabet_War {

   
    static int og_wval = 4;
    static int og_pval = 3;
    static int og_bval = 2;
    static int og_sval = 1;
    static int og_mval = 4;
    static int og_qval = 3;
    static int og_dval = 2;
    static int og_zval = 1;

    
    int wval;
    int pval;
    int bval;
    int sval;

    
    int mval;
    int qval;
    int dval;
    int zval;

    
    public Alphabet_War() {
        this.wval = og_wval;
        this.pval = og_pval;
        this.bval = og_bval;
        this.sval = og_sval;
        this.mval = og_mval;
        this.qval = og_qval;
        this.dval = og_dval;
        this.zval = og_zval;
    }

    public Alphabet_War(int w, int p, int b, int s, int m, int q, int d, int z) 
    {
        this.wval = w;
        this.pval = p;
        this.bval = b;
        this.sval = s;
        this.mval = m;
        this.qval = q;
        this.dval = d;
        this.zval = z;
    }

    
    public String battle(String... str) {
        int left_side = 0;
        int right_side = 0;

        for (String word : str) {
            for (char lt : word.toCharArray()) {
                switch (lt) {
                    case 'w':
                        left_side += wval;
                        break;
                    case 'p':
                        left_side += pval;
                        break;
                    case 'b':
                        left_side += bval;
                        break;
                    case 's':
                        left_side += sval;
                        break;
                    case 'm':
                        right_side += mval;
                        break;
                    case 'q':
                        right_side += qval;
                        break;
                    case 'd':
                        right_side += dval;
                        break;
                    case 'z':
                        right_side += zval;
                        break;
                    default:
                    System.out.println("plase choose from the list of given characters");
                }
            }
        }

        if (left_side > right_side) {
            return "Left side wins!";
        } else if (left_side < right_side) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    public static void main(String[] args) {
    
        Alphabet_War a1 = new Alphabet_War();
        System.out.println(a1.battle("z")); 

        Alphabet_War a2 = new Alphabet_War(7, 3, 2, 1, 4, 3, 6, 1);
        System.out.println(a2.battle("abcdefgh")); 

        Alphabet_War a3 = new Alphabet_War();
        System.out.println(a3.battle("wwwwwwz")); 
    }
}
