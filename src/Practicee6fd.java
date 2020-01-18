interface BitSet {
    void add(int x);
    void remove(int x);
    boolean contains(int x);
    void intersectWith(BitSet s);
    int maxStorableValue();
    Number getBitSet();
}

class BitSet8 implements BitSet {
    byte bitset;

    public BitSet8(byte bitset) {
        this.bitset = bitset;
    }

    @Override
    public void add(int x) {
        if (inRange(x))
            bitset |= 1 << x;
        else
            System.out.println("Overflow!");
    }

    @Override
    public void remove(int x) {
        if (inRange(x))
            bitset &= (~(1 << x));
        else
            System.out.println("Overflow!");
    }

    @Override
    public boolean contains(int x) {
        if (inRange(x))
            return ((1 << x) & bitset) != 0;
        else
            System.out.println("Overflow!");
            return false;
    }

    @Override
    public void intersectWith(BitSet s) {
        if (s instanceof BitSet8)
            bitset &= ((byte) s.getBitSet());
        else
            for (int x = 0; inRange(x); x++) {
                if (!(contains(x) && s.contains(x))) {
                    remove(x);
                }
            }
    }

    @Override
    public int maxStorableValue() {
        return Byte.SIZE;
    }

    @Override
    public Number getBitSet() {
        return (byte) this.bitset;
    }

    private boolean inRange(int x) {
        //Including 0, thereby x has to be smaller or equal to max - 1
        return x >= 0 && x <= maxStorableValue() - 1;
    }
    
}