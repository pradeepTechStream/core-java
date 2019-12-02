import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class NoobChain {

    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 5;

    public static void main(String[] args) {

        final ArrayList<Block> blockchain = new ArrayList<>();

        /*
         * final Block genesisBlock = new Block("Hi im the first block", "0"); System.out.println("Hash for block 1 : " + genesisBlock.hash); final Block
         * secondBlock = new Block("Yo im the second block", genesisBlock.hash); System.out.println("Hash for block 2 : " + secondBlock.hash); final Block
         * thirdBlock = new Block("Hey im the third block", secondBlock.hash); System.out.println("Hash for block 3 : " + thirdBlock.hash);
         */

        blockchain.add(new Block("Hi im the first block", "0"));
        blockchain.add(new Block("Yo im the second block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Hey im the third block", blockchain.get(blockchain.size() - 1).hash));

        final String blockchainJson = new GsonBuilder().setPrettyPrinting()
            .create()
            .toJson(blockchain);
        System.out.println(blockchainJson);

    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        final String hashTarget = new String(new char[NoobChain.difficulty]).replace('\0', '0');

        // loop through blockchain to check hashes:
        for (int i = 1; i < NoobChain.blockchain.size(); i++) {
            currentBlock = NoobChain.blockchain.get(i);
            previousBlock = NoobChain.blockchain.get(i - 1);
            // compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            // compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            // check if hash is solved
            if (!currentBlock.hash.substring(0, NoobChain.difficulty)
                .equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
}
