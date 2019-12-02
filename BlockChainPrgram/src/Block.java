import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private final String data;
    private final long timeStamp;
    private int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    // Calculate new hash based on blocks contents
    public String calculateHash() {
        final String calculatedhash = StringUtil.applySha256(this.previousHash + Long.toString(this.timeStamp) + Integer.toString(this.nonce) + this.data);
        return calculatedhash;
    }

    public void mineBlock(int difficulty) {
        final String target = new String(new char[difficulty]).replace('\0', '0'); // Create a string with difficulty * "0"
        while (!this.hash.substring(0, difficulty)
            .equals(target)) {
            this.nonce++;
            this.hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + this.hash);
    }

}
